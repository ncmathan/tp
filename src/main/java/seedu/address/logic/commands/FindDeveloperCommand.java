package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;

import java.util.function.Predicate;

import seedu.address.commons.util.ToStringBuilder;
import seedu.address.logic.Messages;
import seedu.address.model.Model;
import seedu.address.model.developer.DateJoinedContainsKeywordsPredicate;
import seedu.address.model.developer.Developer;
import seedu.address.model.developer.GithubIdContainsKeywordsPredicate;
import seedu.address.model.developer.RatingContainsKeywordsPredicate;
import seedu.address.model.developer.SalaryContainsKeywordsPredicate;
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
public class FindDeveloperCommand extends Command {

    public static final String COMMAND_WORD = "find-developer";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Please Find with the correct input "
            + "Find pr/<Project Name> OR Find r/<Role> OR Find n/<Name>.\n"
            + "Example: " + COMMAND_WORD + " n/ alice bob charlie";

    private KeywordPredicate<? extends Person> predicate;

    public FindDeveloperCommand(NameContainsKeywordsPredicate namePredicate) {
        this.predicate = namePredicate;
    }

    public FindDeveloperCommand(RoleContainsKeywordsPredicate rolePredicate) {
        this.predicate = rolePredicate;
    }

    public FindDeveloperCommand(AddressContainsKeywordsPredicate addressPredicate) {
        this.predicate = addressPredicate;
    }

    public FindDeveloperCommand(DateJoinedContainsKeywordsPredicate dateJoinedPredicate) {
        this.predicate = dateJoinedPredicate;
    }

    public FindDeveloperCommand(EmailContainsKeywordsPredicate emailPredicate) {
        this.predicate = emailPredicate;
    }

    public FindDeveloperCommand(PhoneContainsKeywordsPredicate phonePredicate) {
        this.predicate = phonePredicate;
    }

    public FindDeveloperCommand(SalaryContainsKeywordsPredicate salaryPredicate) {
        this.predicate = salaryPredicate;
    }


    public FindDeveloperCommand(ProjectContainsKeywordsPredicate projectPredicate) {
        this.predicate = projectPredicate;
    }

    public FindDeveloperCommand(RatingContainsKeywordsPredicate projectPredicate) {
        this.predicate = projectPredicate;
    }
    public FindDeveloperCommand(GithubIdContainsKeywordsPredicate projectPredicate) {
        this.predicate = projectPredicate;
    }

    @Override
    public CommandResult execute(Model model) {
        requireNonNull(model);
        model.updateFilteredDeveloperList((Predicate<Developer>) predicate);
        return new CommandResult(
                String.format(Messages.MESSAGE_DEVELOPERS_LISTED_OVERVIEW, model.getFilteredDeveloperList().size()),
                TabIndex.Developer);
    }


    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof FindDeveloperCommand)) {
            return false;
        }

        FindDeveloperCommand otherFindDeveloperCommand = (FindDeveloperCommand) other;
        return predicate.equals(otherFindDeveloperCommand.predicate);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .add("predicate", predicate)
                .toString();
    }
}
