package Commands;

import net.dv8tion.jda.api.entities.Member;
import packages.CommandContext;

public class HugCommand implements Command{
    @Override
    public void execute(CommandContext context) {
        String frend = context.getMentionedMember().getAsMention();
        String auth = context.getMember().getAsMention();
      context.getMessage().reply(auth + " envelops " + frend + " in a warm bear hug<3").queue();
    }
}
