package Commands;

import packages.CommandContext;

public class pocketCommand implements Command{
    public void execute(CommandContext context) {
        String frend = context.getMentionedMember().getAsMention();
        String author = context.getMember().getAsMention();
        String action = String.format("%s puts %s in their pocket", frend, author);
        context.getMessage().reply(action).queue();
    }
}
