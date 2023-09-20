package Commands;
import packages.CommandContext;
public interface Command {
    void execute(CommandContext context);
}
