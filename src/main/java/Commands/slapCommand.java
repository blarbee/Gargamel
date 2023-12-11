package Commands;

import packages.CommandContext;

public class slapCommand implements Command{
    public void execute(CommandContext context) {
        String B = context.getMentionedMember().getAsMention();
        String A = context.getMember().getAsMention();
        context.getMessage().reply("am slap uuu").queue();
    }
}
