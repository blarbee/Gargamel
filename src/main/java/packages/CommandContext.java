package packages;

import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.channel.unions.MessageChannelUnion;

public class CommandContext {
    private final Message message;
    public CommandContext(Message message) {
        this.message = message;
    }
    public Message getMessage() {
        return message;
    }
    // Add any other useful methods or getters
    public MessageChannelUnion getChannel() {
        return message.getChannel();
    }
    public String getId(){return message.getId();}
    public Member getMentionedMember(){return message.getMentions().getMembers().get(0);}
    public Member getMember(){return message.getMember();}
    public String getContentRaw(){return message.getContentRaw();}
}
