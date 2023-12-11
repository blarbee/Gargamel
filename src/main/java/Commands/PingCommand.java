package Commands;

import net.dv8tion.jda.api.entities.channel.unions.MessageChannelUnion;
import packages.CommandContext;

public class PingCommand implements Command {
    @Override
    public void execute(CommandContext context) {context.getMessage().reply("Pong!").queue();}
}