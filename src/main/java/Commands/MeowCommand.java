package Commands;

import packages.CommandContext;

public class MeowCommand implements Command {
    @Override
    public void execute(CommandContext context) {
        context.getMessage().reply("*purrrrrs*").queue();
    }
}
