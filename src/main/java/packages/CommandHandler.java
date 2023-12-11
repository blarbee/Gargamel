package packages;

import Commands.*;
import net.dv8tion.jda.api.entities.channel.unions.MessageChannelUnion;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class CommandHandler {
    public static final Map<String, Command> commands = new HashMap<>();

    public CommandHandler() {
        // Register your commands here
        registerCommand("ping", new PingCommand());
        registerCommand("meow", new MeowCommand());
        registerCommand("yash", new YashCommand());
        registerCommand("shark", new SharkCommand());
        registerCommand("list", new ListCommand());
        registerCommand("hug", new HugCommand());
        registerCommand("kissi", new KissiCommand());
//        registerCommand("slap", new slapCommand());










    }

    public void registerCommand(String commandName, Command command) {
        commands.put(commandName, command);
    }

    public void handleCommand(CommandContext context) {
        String[] args = context.getMessage().getContentRaw().split(" ");
        if (args.length == 0) return;

        String commandName = args[0].substring(1); // Remove the command prefix
        MessageChannelUnion channel = context.getChannel();
        Command command = commands.get(commandName);
        if (command != null) {
            channel.sendTyping().queue();
            command.execute(context);
        }
    }

    public void createCommand(CommandContext context) {
        String sentence = context.getMessage().getContentRaw();
        if (sentence.startsWith("-add")) {
            // Use a regular expression to extract the command and action in square brackets
            Pattern pattern = Pattern.compile("-add\\s+(\\w+)\\s+\\[(.*?)\\]");
            Matcher matcher = pattern.matcher(sentence);

            // Check if the pattern matches
            if (matcher.find()) {
                String newCommand = matcher.group(1).toLowerCase();
                String action = matcher.group(2);

                // Call your addCommand method here with the newCommand and action
                addCommand(action, newCommand, e -> e.getChannel().sendMessage(action).queue());

                // Respond to the user in the same channel
                context.getMessage().reply("Command -" + newCommand + " added!").queue();
            } else {
                // Respond if the pattern doesn't match
                context.getMessage().reply("Invalid syntax for adding a command.").queue();
            }
        }
    }


    public static void handleDynamicCommand(CommandContext event) {
        String command = event.getMessage().getContentRaw().substring(1).toLowerCase();
        if (commands.containsKey(command)) {
            commands.get(command).execute(event);
        }
    }

    private void addCommand(String action, String commandName, Command command) {
        commands.put(commandName, command);

        // Specify the directory path where you want to create the file
        String directoryPath = "/home/nwl/Documents/1/bot/Gargamel/src/main/java/Commands/";

        // Specify the file name
        String fileName = commandName + "Command.java";

        // Combine the directory path and file name to get the full file path
        String filePath = directoryPath + fileName;

        // Create a Path object
//        Path path = Paths.get(filePath);
        Path path = Paths.get(directoryPath).resolve(fileName);

        try {
            // Create the directory (if it doesn't exist)
            Files.createDirectories(path.getParent());

            // Create the file
            Files.createFile(path);

            System.out.println("File created successfully at: " + path);
            writeExecute(action, commandName, directoryPath, fileName, command);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error creating the file.");
        }

    }

    private void writeExecute(String action, String commandName, String dir, String file, Command command){
        // Specify the directory path where you want to create the file
        String directoryPath = dir;
        // Specify the file name
        String fileName = file;
        // Combine the directory path and file name to get the full file path
        String filePath = directoryPath + fileName;
        // Create a Path object
        Path path = Paths.get(filePath);
        try {
            // Write content to the file
            List<String> lines = Arrays.asList("package Commands;\n" +
                    "\n" +
                    "import packages.CommandContext;\n" +
                    "\n" +
                    "public class " + commandName + "Command implements Command{\n" +
                    "    public void execute(CommandContext context) {\n" +
                    "        String frend = context.getMentionedMember().getAsMention();\n" +
                    "        String auth = context.getMember().getAsMention();\n" +
                    "        context.getMessage().reply(\"" +action+"\").queue();\n" +
                    "    }\n" +
                    "}");
            Files.write(path, lines);

            System.out.println("File created and content written successfully at: " + path);
            writeHere(commandName);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error creating the file or writing content.");
        }
    }

    private void writeHere(String commandName){

    }

}
