package org.example;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.requests.GatewayIntent;

import org.apache.commons.io.monitor.FileAlterationMonitor;
import org.apache.commons.io.monitor.FileAlterationObserver;
import packages.MyMessageListener;
import reactions.Strawberry;

import java.io.File;
import java.util.EventListener;

public class Main implements EventListener {
    public static void main(String[] args) throws InterruptedException {
        // Note: It is important to register your ReadyListener before building
        JDA bot = JDABuilder.createDefault("MTEyMDcyODA1MDA2NjI3MjM1Ng.GF8dK9.VCaVDdwlOcnFUTCX4pR_tCloYQxyzcGGjxm5rw", GatewayIntent.GUILD_MESSAGES, GatewayIntent.MESSAGE_CONTENT, GatewayIntent.GUILD_MEMBERS).addEventListeners(new MyMessageListener(), new Strawberry()).build();
        // optionally block until JDA is ready
//        ((JDABuilder) bot).addEventListeners(new MyMessageListener()).build();
        bot.awaitReady();
        onReady(bot);

    }
        public static void onReady(JDA bot) {
            System.out.println(bot.getSelfUser().getName() + " is online <3");
            // Perform actions or setup here once the bot is ready
        }
//    }
}