package seedu.address.logic.parser;

import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;

import java.util.Arrays;

import seedu.address.logic.commands.FindDeveloperCommand;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.developer.DateJoinedContainsKeywordsPredicate;
import seedu.address.model.developer.GithubIdContainsKeywordsPredicate;
import seedu.address.model.developer.RatingContainsKeywordsPredicate;
import seedu.address.model.developer.SalaryContainsKeywordsPredicate;
import seedu.address.model.person.AddressContainsKeywordsPredicate;
import seedu.address.model.person.EmailContainsKeywordsPredicate;
import seedu.address.model.person.NameContainsKeywordsPredicate;
import seedu.address.model.person.PhoneContainsKeywordsPredicate;
import seedu.address.model.person.ProjectContainsKeywordsPredicate;
import seedu.address.model.person.RoleContainsKeywordsPredicate;

/**
 * Parses input arguments and creates a new FindDeveloperCommand object
 */
public class FindDeveloperCommandParser implements Parser<FindDeveloperCommand> {
        /**
         * Parses the given {@code String} of arguments in the context of the FindDeveloperCommand
         * and returns a FindDeveloperCommand object for execution.
         * @throws ParseException if the user input does not conform the expected format
         */
        public FindDeveloperCommand parse(String args) throws ParseException {
            String trimmedArgs = args.trim();
            if (trimmedArgs.isEmpty()) {
                throw new ParseException(
                        String.format(MESSAGE_INVALID_COMMAND_FORMAT, FindDeveloperCommand.MESSAGE_USAGE));
            }

            if (trimmedArgs.startsWith("n/")) {
                String[] nameKeywords = trimmedArgs.replaceFirst("n/", "").split("\\s+");
                return new FindDeveloperCommand(new NameContainsKeywordsPredicate(Arrays.asList(nameKeywords)));
            } else if (trimmedArgs.startsWith("ro/")) {
                String[] roleKeywords = trimmedArgs.replaceFirst("r/", "").split("\\s+");
                return new FindDeveloperCommand(new RoleContainsKeywordsPredicate(Arrays.asList(roleKeywords)));
            } else if (trimmedArgs.startsWith("a/")) {
                String[] addressKeywords = trimmedArgs.replaceFirst("a/", "").split("\\s+");
                return new FindDeveloperCommand(new AddressContainsKeywordsPredicate(Arrays.asList(addressKeywords)));
            } else if (trimmedArgs.startsWith("d/")) {
                String[] dateJoinedKeywords = trimmedArgs.replaceFirst("d/", "").split("\\s+");
                return new FindDeveloperCommand(new DateJoinedContainsKeywordsPredicate(Arrays.asList(dateJoinedKeywords)));
            } else if (trimmedArgs.startsWith("e/")) {
                String[] emailKeywords = trimmedArgs.replaceFirst("e/", "").split("\\s+");
                return new FindDeveloperCommand(new EmailContainsKeywordsPredicate(Arrays.asList(emailKeywords)));
            } else if (trimmedArgs.startsWith("ph/")) {
                String[] phoneKeywords = trimmedArgs.replaceFirst("ph/", "").split("\\s+");
                return new FindDeveloperCommand(new PhoneContainsKeywordsPredicate(Arrays.asList(phoneKeywords)));
            } else if (trimmedArgs.startsWith("pr/")) {
                String[] projectKeywords = trimmedArgs.replaceFirst("pr/", "").split("\\s+");
                return new FindDeveloperCommand(new ProjectContainsKeywordsPredicate(Arrays.asList(projectKeywords)));
            } else if (trimmedArgs.startsWith("s/")) {
                String[] salaryKeywords = trimmedArgs.replaceFirst("s/", "").split("\\s+");
                return new FindDeveloperCommand(new SalaryContainsKeywordsPredicate(Arrays.asList(salaryKeywords)));
            } else if (trimmedArgs.startsWith("ra/")) {
                String[] ratingKeywords = trimmedArgs.replaceFirst("ra/", "").split("\\s+");
                return new FindDeveloperCommand(new RatingContainsKeywordsPredicate(Arrays.asList(ratingKeywords)));
            } else if (trimmedArgs.startsWith("g/")) {
                String[] githubKeywords = trimmedArgs.replaceFirst("g/", "").split("\\s+");
                return new FindDeveloperCommand(new GithubIdContainsKeywordsPredicate(Arrays.asList(githubKeywords)));
            } else {
                throw new ParseException(
                        String.format(MESSAGE_INVALID_COMMAND_FORMAT, FindDeveloperCommand.MESSAGE_USAGE));
            }
        }

}