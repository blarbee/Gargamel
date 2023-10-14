package packages;
import net.dv8tion.jda.api.entities.emoji.Emoji;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
public class MyMessageListener extends ListenerAdapter {
    private final CommandHandler commandHandler;

    public MyMessageListener() {
        commandHandler = new CommandHandler();
    }
    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        if (event.getAuthor().isBot()) return; // Ignore messages from bots

        String messageContent = event.getMessage().getContentRaw();
        if (messageContent.startsWith("!")) {
            CommandContext context = new CommandContext(event.getMessage());
            commandHandler.handleCommand(context);
        }

    }
    private static final Emoji straw = Emoji.fromCustom("Strawbewwy", 1130247677154709675L, false);
    public void onMessage(MessageReceivedEvent event) {
        event.getMessage().reply("*purrrrrs* ??").queue();

        long id = event.getMessage().getAuthor().getIdLong();
        String name = event.getAuthor().getName();
        System.out.println("straw.java");

        if (id == 688043538088329236L || name.equals(".nwl.") || name.equals("ßõšş")){
            event.getMessage().addReaction(straw).queue();
            event.getMessage().reply("hey girlypop<3").queue();
        }
    }
}
