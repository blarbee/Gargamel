package org.example;

import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.JDA;
import java.util.EventListener;

import net.dv8tion.jda.api.requests.GatewayIntent;
import packages.MyMessageListener;
import reactions.Strawberry;

public class Main implements EventListener {
    public static void main(String[] args) throws InterruptedException {
        // Note: It is important to register your ReadyListener before building
        JDA bot = JDABuilder.createDefault("MTEyMDcyODA1MDA2NjI3MjM1Ng.GF8dK9.VCaVDdwlOcnFUTCX4pR_tCloYQxyzcGGjxm5rw", GatewayIntent.GUILD_MESSAGES, GatewayIntent.MESSAGE_CONTENT, GatewayIntent.GUILD_MEMBERS).addEventListeners(new MyMessageListener(), new Strawberry()).build();
        // optionally block until JDA is ready
//        ((JDABuilder) bot).addEventListeners(new MyMessageListener()).build();
        bot.awaitReady();
        onReady(bot);

    }

//    public static class methods extends ListenerAdapter {
//
//        private static final Emoji straw = Emoji.fromCustom("Strawbewwy", 1130247677154709675L, false);
//        private static final Emoji crow = Emoji.fromCustom("judgeCrow", 1124702935973109840L, false);
//        private static final Emoji mikeWeird = Emoji.fromCustom("MikeWeird", 1124361316786770132L, false);
//        private static final Emoji shark = Emoji.fromUnicode("\uD83E\uDD88");
//
//       @Override
//        public void onMessageReceived(MessageReceivedEvent event) {
//          if (event.getAuthor().isBot()) return;
//          if (event.isFromGuild()) {
//                meow(event);
//          }
//        }
//        public static void meow(MessageReceivedEvent event) {
//            Message message = event.getMessage();
//            String content = message.getContentRaw();
//
//            switch (content) {
//                case "!meow":
//                    event.getChannel().sendMessage("*purrrrs* ").queue();
//                    break;
//                case "!shark":
//                    event.getChannel().sendMessage("Get sharked!!! " + ":shark: :shark: :shark:").queue();
//                    break;
//                case "!grr":
//                    event.getChannel().sendMessage("rawr").queue();
//                    break;
//                case "yash":
//                    event.getChannel().sendMessage("Someone said Yash? love this guy, kith kith! meow~").queue();
//                    break;
//                case "nwl":
//                    event.getChannel().sendMessage("I am here. Why would you call her when I am here, you don't need her>:|").queue();
//                    break;
//                case "blarb":
//                    event.getChannel().sendMessage("Don't summon her please help me").queue();
//
//                    break;
//                case "Don't summon her please help me":
//                    if(event.getAuthor().isBot()) event.getChannel().().queue();
//                    break;
//            }
//        }
//
//
        public static void onReady(JDA bot) {
            System.out.println(bot.getSelfUser().getName() + " is online <3");
            // Perform actions or setup here once the bot is ready
        }
//    }
}