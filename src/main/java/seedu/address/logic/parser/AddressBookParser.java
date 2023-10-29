package seedu.address.logic.parser;

import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.Messages.MESSAGE_UNKNOWN_COMMAND;

import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import seedu.address.commons.core.LogsCenter;
import seedu.address.logic.commands.ClearCommand;
import seedu.address.logic.commands.Command;
import seedu.address.logic.commands.DeleteDeveloperCommand;
import seedu.address.logic.commands.ExitCommand;
import seedu.address.logic.commands.FindClientCommand;
import seedu.address.logic.commands.FindDeveloperCommand;
import seedu.address.logic.commands.FindProjectCommand;
import seedu.address.logic.commands.HelpCommand;
import seedu.address.logic.commands.ImportCommand;
import seedu.address.logic.commands.ListClientCommand;
import seedu.address.logic.commands.ListDeveloperCommand;
import seedu.address.logic.commands.ListProjectCommand;
import seedu.address.logic.commands.add.AddClientCommand;
import seedu.address.logic.commands.add.AddDeveloperCommand;
import seedu.address.logic.commands.add.AddProjectCommand;
import seedu.address.logic.commands.edit.EditClientCommand;
import seedu.address.logic.commands.edit.EditDeveloperCommand;
import seedu.address.logic.commands.edit.EditProjectCommand;
import seedu.address.logic.commands.imports.ImportDeveloperCommand;
import seedu.address.logic.commands.imports.ImportClientCommand;
import seedu.address.logic.parser.add.AddClientCommandParser;
import seedu.address.logic.parser.add.AddDeveloperCommandParser;
import seedu.address.logic.parser.add.AddProjectCommandParser;
import seedu.address.logic.parser.edit.EditClientCommandParser;
import seedu.address.logic.parser.edit.EditDeveloperCommandParser;
import seedu.address.logic.parser.edit.EditProjectCommandParser;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.logic.parser.imports.ImportClientCommandParser;
import seedu.address.logic.parser.imports.ImportDeveloperCommandParser;

/**
 * Parses user input.
 */
public class AddressBookParser {

    /**
     * Used for initial separation of command word and args.
     */
    private static final Pattern BASIC_COMMAND_FORMAT = Pattern.compile("(?<commandWord>\\S+)(?<arguments>.*)");
    private static final Logger logger = LogsCenter.getLogger(AddressBookParser.class);

    /**
     * Parses user input into command for execution.
     *
     * @param userInput full user input string
     * @return the command based on the user input
     * @throws ParseException if the user input does not conform the expected format
     */
    public Command parseCommand(String userInput) throws ParseException {
        final Matcher matcher = BASIC_COMMAND_FORMAT.matcher(userInput.trim());
        if (!matcher.matches()) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, HelpCommand.MESSAGE_USAGE));
        }

        final String commandWord = matcher.group("commandWord");
        final String arguments = matcher.group("arguments");

        // Note to developers: Change the log level in config.json to enable lower level (i.e., FINE, FINER and lower)
        // log messages such as the one below.
        // Lower level log messages are used sparingly to minimize noise in the code.
        logger.fine("Command word: " + commandWord + "; Arguments: " + arguments);

        switch (commandWord) {

        case AddDeveloperCommand.COMMAND_WORD:
            return new AddDeveloperCommandParser().parse(arguments);
        case AddClientCommand.COMMAND_WORD:
            return new AddClientCommandParser().parse(arguments);
        case AddProjectCommand.COMMAND_WORD:
            return new AddProjectCommandParser().parse(arguments);
        case ImportDeveloperCommand.COMMAND_WORD:
            return new ImportDeveloperCommandParser().parse(arguments);
        case ImportClientCommand.COMMAND_WORD:
            return new ImportClientCommandParser().parse(arguments);

        case ImportCommand.COMMAND_WORD:
            return new ImportDeveloperCommandParser().parse(arguments);

        case EditDeveloperCommand.COMMAND_WORD:
            return new EditDeveloperCommandParser().parse(arguments);
        case EditClientCommand.COMMAND_WORD:
            return new EditClientCommandParser().parse(arguments);
        case EditProjectCommand.COMMAND_WORD:
            return new EditProjectCommandParser().parse(arguments);
            
        case DeleteDeveloperCommand.COMMAND_WORD:
            return new DeleteDeveloperCommandParser().parse(arguments);

        case ClearCommand.COMMAND_WORD:
            return new ClearCommand();

        case FindDeveloperCommand.COMMAND_WORD:
            return new FindDeveloperCommandParser().parse(arguments);

        case FindClientCommand.COMMAND_WORD:
            return new FindClientCommandParser().parse(arguments);

        case FindProjectCommand.COMMAND_WORD:
            return new FindProjectCommandParser().parse(arguments);
            
        case ListClientCommand.COMMAND_WORD:
            return new ListClientCommand();

        case ListDeveloperCommand.COMMAND_WORD:
            return new ListDeveloperCommand();

        case ListProjectCommand.COMMAND_WORD:
            return new ListProjectCommand();

        case ExitCommand.COMMAND_WORD:
            return new ExitCommand();

        case HelpCommand.COMMAND_WORD:
            return new HelpCommand();

        default:
            logger.finer("This user input caused a ParseException: " + userInput);
            throw new ParseException(MESSAGE_UNKNOWN_COMMAND);
        }
    }
}
