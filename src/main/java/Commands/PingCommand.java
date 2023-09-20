package Commands;

import packages.CommandContext;

public class PingCommand implements Command {
    @Override
    public void execute(CommandContext context) {
        context.getMessage().reply("Pong!").queue();
    }
}