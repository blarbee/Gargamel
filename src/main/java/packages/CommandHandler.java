package packages;

import Commands.*;

import java.util.HashMap;
import java.util.Map;

public class CommandHandler {
    private final Map<String, Command> commands = new HashMap<>();
    public CommandHandler() {
        // Register your commands here
        registerCommand("ping", new PingCommand());
        registerCommand("meow", new MeowCommand());
        registerCommand("yash", new YashCommand());
        registerCommand("shark", new SharkCommand());

    }

    public void registerCommand(String commandName, Command command) {commands.put(commandName, command);}
    public void handleCommand(CommandContext context) {
        String[] args = context.getMessage().getContentRaw().split(" ");
        if (args.length == 0) return;

        String commandName = args[0].substring(1); // Remove the command prefix

        Command command = commands.get(commandName);
        if (command != null) {
            command.execute(context);
        }
    }
}