package Commands;

import packages.CommandContext;

public class KissiCommand implements Command{
    public void execute(CommandContext context) {
        String frend = context.getMentionedMember().getAsMention();
        String author = context.getMember().getAsMention();
        String action = String.format("%s leaves a lil kissi on %s's cheek<3", frend, author);
        context.getMessage().reply(action).queue();
    }
}
