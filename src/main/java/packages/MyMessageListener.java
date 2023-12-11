package packages;
import net.dv8tion.jda.api.entities.channel.unions.MessageChannelUnion;
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
        String name = event.getMember().getEffectiveName();
        String content = event.getMessage().getContentRaw();
        String guild = String.valueOf(event.getGuild());
        String messageContent = event.getMessage().getContentRaw();
        MessageChannelUnion channel = event.getChannel();

        System.out.println(channel + name + ":" + content);
        BotReact(event);
        easterEggs(event);

        if (messageContent.startsWith("-add")){
            CommandContext context = new CommandContext(event.getMessage());
            commandHandler.createCommand(context);
            CommandHandler.handleDynamicCommand(context);
        }else if (messageContent.startsWith("-")) {
            CommandContext context = new CommandContext(event.getMessage());
            commandHandler.handleCommand(context);
        }



        if(content.equals("meow")){
            event.getMessage().reply("||do not tell them i got out||").queue();
        }
    }
    private void BotReact(MessageReceivedEvent event){
        long id = event.getMessage().getAuthor().getIdLong();
        int rand = (int) ((Math.random() * (500 - 1)) + 1);
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
        } else if (rand == 24){
            event.getMessage().addReaction(mikeWeird).queue();
        }
    }

    private void easterEggs(MessageReceivedEvent event){
        String content = event.getMessage().getContentRaw();
        switch (content) {
                case "meow":
                    event.getChannel().sendMessage("||do not tell them i escaped||").queue();
                    break;
                case "stop":
                    event.getChannel().sendMessage("Get sharked!!! " + ":shark: :shark: :shark:").queue();
                    break;
                case "grr":
                    event.getChannel().sendMessage("rawr").queue();
                    break;
                case "yash":
                    event.getChannel().sendMessage("Someone said Yash? love this guy, kith kith! meow~").queue();
                    break;
                case "-blarb":
                    event.getChannel().sendMessage("Don't summon her please help me").queue();
                    break;
                case "0909Don't summon her please help me":
                    if(event.getAuthor().isBot()){
                        long IDmessage = event.getMessageIdLong();
                    }
                    break;
                case "damn":
                    event.getChannel().sendMessage("damn bruh").queue();
                    break;
        }
    }
}
