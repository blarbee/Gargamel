package packages;
import net.dv8tion.jda.api.entities.emoji.Emoji;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class MyMessageListener extends ListenerAdapter {
    private final CommandHandler commandHandler;
    private static final Emoji straw = Emoji.fromCustom("Strawbewwy", 1130247677154709675L, false);
    private static final Emoji crow = Emoji.fromCustom("judgeCrow", 1124702935973109840L, false);
    private static final Emoji mikeWeird = Emoji.fromCustom("MikeWeird", 1124361316786770132L, false);
    private static final Emoji DuckHeart = Emoji.fromCustom("DuckHeart", 1124357640428982434L, false);
    private static final Emoji shark = Emoji.fromUnicode("\uD83E\uDD88");
    private static final Emoji upside = Emoji.fromUnicode("U+1F643");
    private static final long nwl = 688043538088329236L;
    private static final long yash = 930717042632433675L;
    private static final long buddy = 844121272383307776L;
    private static final long hound = 708221122319089725L;
    private static final long lapis = 369422767659024384L;
    private static final long itachi = 1105759688735342693L;

    public MyMessageListener() {
        commandHandler = new CommandHandler();
    }
    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        if (event.getAuthor().isBot()) return; // Ignore messages from bots

        Long id = event.getMessage().getAuthor().getIdLong();
        String name = event.getAuthor().getName();
        String content = event.getMessage().getContentRaw();
        String guild = String.valueOf(event.getGuild());
        String messageContent = event.getMessage().getContentRaw();

        System.out.println(guild + name + ":" + content);

        if (messageContent.startsWith("!")) {
            CommandContext context = new CommandContext(event.getMessage());
            commandHandler.handleCommand(context);
        }

        if(content.equals("mhm")){
            event.getMessage().reply("*purrrrrs*").queue();
        }else if(content.equals("yash")){
            event.getMessage().reply("Someone said Yash!!? I love this guy!! :3").queue();
        }

        int rand = (int) ((Math.random() * (100 - 1)) + 1);
        System.out.println(rand);

        if (id == nwl && rand == 1) {
            event.getMessage().addReaction(mikeWeird).queue();
        } else if (id == yash && rand == 2) {
            event.getMessage().addReaction(crow).queue();
        }else if (id == yash && rand == 6) {
            event.getMessage().addReaction(straw).queue();
            event.getMessage().addReaction(crow).queue();
        }else if (id == buddy && rand == 3) {
            event.getMessage().addReaction(DuckHeart).queue();
        } else if (id == hound && rand == 4) {
            event.getMessage().addReaction(shark).queue();
        } else if (id == lapis && rand == 5) {
            event.getMessage().addReaction(upside).queue();
        }
    }
}
