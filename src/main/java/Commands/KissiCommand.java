package Commands;

import packages.CommandContext;

public class KissiCommand implements Command{
    public void execute(CommandContext context) {
        String frend = context.getMentionedMember().getAsMention();
        String auth = context.getMember().getAsMention();
        context.getMessage().reply(auth + " leaves a lil kissi on " + frend + "'s cheek<3").queue();
    }
}
