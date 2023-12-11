package Commands;

import packages.CommandContext;

public class YashCommand implements Command {
    @Override
    public void execute(CommandContext context) {
        context.getMessage().reply(":nerd: <33").queue();
    }
}
