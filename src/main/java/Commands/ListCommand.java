package Commands;

import packages.CommandContext;

import java.util.Map;

import static packages.CommandHandler.commands;

public class ListCommand implements Command{
    public void execute(CommandContext context) {
//        String res = " ";
//        for(Map.Entry<String, Command> ignored : commands.entrySet() ){
//            res += "Key:" + ignored.getKey() + ", Value: " + ignored.getValue();
//        }
//        context.getMessage().reply("res");

        StringBuilder res = new StringBuilder("Available Commands:\n");

        for (Map.Entry<String, Command> entry : commands.entrySet()) {
            res.append("| -").append(entry.getKey()).append(" ");
        }
        context.getMessage().reply(res.toString()).queue();
    }

}
