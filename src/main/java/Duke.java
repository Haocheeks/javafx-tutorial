public class Duke {

    private String commandType;

    public static void main(String[] args) {
        System.out.println("Hello!");
    }

    /**
     * Generates a response for the user's chat message.
     */
    public String getResponse(String input) {
        commandType = parseCommandType(input);
        return "Duke heard: " + input;
    }

    /**
     * Returns the simple name of the command produced by the last call to
     * {@link #getResponse(String)}, or null if no input has been handled yet.
     */
    public String getCommandType() {
        return commandType;
    }

    /**
     * Determines the command type from the raw user input. Once the Parser and Command
     * classes exist, replace this with {@code Parser.parse(input).getClass().getSimpleName()}.
     */
    private String parseCommandType(String input) {
        String keyword = input.trim().split("\\s+", 2)[0].toLowerCase();
        switch (keyword) {
        case "todo":
        case "deadline":
        case "event":
            return "AddCommand";
        case "mark":
        case "unmark":
            return "ChangeMarkCommand";
        case "delete":
            return "DeleteCommand";
        default:
            return "UnknownCommand";
        }
    }
}
