package Commands;

import packages.CommandContext;

public class slapCommand implements Command{
    public void execute(CommandContext context) {
        String frend = context.getMentionedMember().getAsMention();
        String author = context.getMember().getAsMention();
//        String action = String.format("%s slaps %s into oblivion", frend, author);
        String action = String.format("%s slaps %s into oblivion :slap:", frend, author);
        context.getMessage().reply(action).queue();
    }
}
