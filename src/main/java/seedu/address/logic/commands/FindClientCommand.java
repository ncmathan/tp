package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;

import java.util.function.Predicate;

import seedu.address.commons.util.ToStringBuilder;
import seedu.address.logic.Messages;
import seedu.address.model.Model;
import seedu.address.model.client.Client;
import seedu.address.model.client.DocumentContainsKeywordsPredicate;
import seedu.address.model.client.OrganisationContainsKeywordsPredicate;
import seedu.address.model.person.AddressContainsKeywordsPredicate;
import seedu.address.model.person.EmailContainsKeywordsPredicate;
import seedu.address.model.person.KeywordPredicate;
import seedu.address.model.person.NameContainsKeywordsPredicate;
import seedu.address.model.person.Person;
import seedu.address.model.person.PhoneContainsKeywordsPredicate;
import seedu.address.model.person.ProjectContainsKeywordsPredicate;
import seedu.address.model.person.RoleContainsKeywordsPredicate;

/**
 * Finds and lists all persons in address book whose name contains any of the argument keywords.
 * Keyword matching is case insensitive.
 */
public class FindClientCommand extends Command {

    public static final String COMMAND_WORD = "find-client";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Please Find with the correct input "
            + "Find pr/<Project Name> OR Find r/<Role> OR Find n/<Name>.\n"
            + "Example: " + COMMAND_WORD + " n/ alice bob charlie";

    private KeywordPredicate<? extends Person> predicate;

    public FindClientCommand(NameContainsKeywordsPredicate namePredicate) {
        this.predicate = namePredicate;
    }

    public FindClientCommand(RoleContainsKeywordsPredicate rolePredicate) {
        this.predicate = rolePredicate;
    }

    public FindClientCommand(AddressContainsKeywordsPredicate addressPredicate) {
        this.predicate = addressPredicate;
    }

    public FindClientCommand(EmailContainsKeywordsPredicate emailPredicate) {
        this.predicate = emailPredicate;
    }

    public FindClientCommand(PhoneContainsKeywordsPredicate phonePredicate) {
        this.predicate = phonePredicate;
    }


    public FindClientCommand(ProjectContainsKeywordsPredicate projectPredicate) {
        this.predicate = projectPredicate;
    }

    public FindClientCommand(DocumentContainsKeywordsPredicate documentPredicate) {
        this.predicate = documentPredicate;
    }

    public FindClientCommand(OrganisationContainsKeywordsPredicate organisationPredicate) {
        this.predicate = organisationPredicate;
    }

    @Override
    public CommandResult execute(Model model) {
        requireNonNull(model);
        model.updateFilteredClientList((Predicate<Client>) predicate);
        return new CommandResult(
                String.format(Messages.MESSAGE_DEVELOPERS_LISTED_OVERVIEW, model.getFilteredDeveloperList().size()), TabIndex.Client);
    }


    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof FindClientCommand)) {
            return false;
        }

        FindClientCommand otherFindClientCommand = (FindClientCommand) other;
        return predicate.equals(otherFindClientCommand.predicate);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .add("predicate", predicate)
                .toString();
    }
}
