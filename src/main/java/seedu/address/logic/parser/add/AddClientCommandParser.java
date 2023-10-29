package seedu.address.logic.parser.add;
import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CliSyntax.*;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

import seedu.address.logic.commands.add.AddClientCommand;
import seedu.address.logic.parser.*;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.client.Client;
import seedu.address.model.client.Document;
import seedu.address.model.commons.Name;
import seedu.address.model.person.Address;
import seedu.address.model.person.Email;
import seedu.address.model.person.Phone;
import seedu.address.model.person.Role;

/**
 * Parses input arguments and creates a new AddClientCommand object
 */
public class AddClientCommandParser implements Parser<AddClientCommand> {
    //Name name, Phone phone, Email email, Address address, Role role, Set<String> projects,
    //                  Name organisation, Document document

    public AddClientCommand parse(String args) throws ParseException {
        ArgumentMultimap argMultimap = ArgumentTokenizer.tokenize(args,
                PREFIX_NAME, PREFIX_PHONE, PREFIX_EMAIL, PREFIX_ADDRESS, PREFIX_ROLE, PREFIX_PROJECT,
                PREFIX_ORGANISATION, PREFIX_DOCUMENT);

        if (!arePrefixesPresent(argMultimap, PREFIX_NAME, PREFIX_ADDRESS, PREFIX_PHONE, PREFIX_EMAIL,
                PREFIX_ROLE, PREFIX_ORGANISATION, PREFIX_DOCUMENT)
                || !argMultimap.getPreamble().isEmpty()) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, AddClientCommand.MESSAGE_USAGE));
        }

        argMultimap.verifyNoDuplicatePrefixesFor(PREFIX_NAME, PREFIX_PHONE, PREFIX_EMAIL, PREFIX_ADDRESS);
        Name name = ParserUtil.parseName(argMultimap.getValue(PREFIX_NAME).get());
        Phone phone = ParserUtil.parsePhone(argMultimap.getValue(PREFIX_PHONE).get());
        Email email = ParserUtil.parseEmail(argMultimap.getValue(PREFIX_EMAIL).get());
        Address address = ParserUtil.parseAddress(argMultimap.getValue(PREFIX_ADDRESS).get());
        Role role = ParserUtil.parseRole(argMultimap.getValue(PREFIX_ROLE).get());
        Set<String> projectList = new HashSet<>(argMultimap.getAllValues(PREFIX_PROJECT));
        Name organisation = ParserUtil.parseName(argMultimap.getValue(PREFIX_ORGANISATION).get());
        Document document = ParserUtil.parseDocument(argMultimap.getValue(PREFIX_DOCUMENT).get());

        Client client = new Client(name, phone, email, address, role, projectList, organisation, document);

        return new AddClientCommand(client);
    }

    /**
     * Returns true if none of the prefixes contains empty {@code Optional} values in the given
     * {@code ArgumentMultimap}.
     */
    private static boolean arePrefixesPresent(ArgumentMultimap argumentMultimap, Prefix... prefixes) {
        return Stream.of(prefixes).allMatch(prefix -> argumentMultimap.getValue(prefix).isPresent());
    }
}