package Commands;

import packages.CommandContext;

public class SharkCommand implements Command {
    @Override
    public void execute(CommandContext context) {
        context.getMessage().reply("Get sharked!!! :shark: :shark: :shark:").queue();
    }
}
