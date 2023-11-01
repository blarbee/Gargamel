package reactions;

import Commands.Command;
import net.dv8tion.jda.api.entities.emoji.Emoji;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import packages.CommandContext;
public class Strawberry extends ListenerAdapter implements Reaction, Command{
    private static final Emoji straw = Emoji.fromCustom("Strawbewwy", 1130247677154709675L, false);
    @Override
    public void execute(CommandContext context) {
        context.getMessage().reply("*purrrrrs* ??").queue();

        long id = context.getMessage().getAuthor().getIdLong();
        String name = context.getId();
        System.out.println("straw.java");

        if (id == 688043538088329236L){
            context.getMessage().addReaction(straw).queue();
            context.getMessage().reply("am in str.java").queue();
        }
    }

}
