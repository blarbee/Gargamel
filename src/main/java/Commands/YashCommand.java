package Commands;

import packages.CommandContext;

public class YashCommand implements Command {
    @Override
    public void execute(CommandContext context) {
        context.getMessage().reply("Someone said Yash!!? I love this guy he is so meow!! :3").queue();
    }
}
