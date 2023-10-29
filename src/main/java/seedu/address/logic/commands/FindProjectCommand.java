package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;

import seedu.address.commons.util.ToStringBuilder;
import seedu.address.logic.Messages;
import seedu.address.model.Model;
import seedu.address.model.person.KeywordPredicate;
import seedu.address.model.project.DeadlineContainsKeywordsPredicate;
import seedu.address.model.project.DescriptionContainsKeywordsPredicate;
import seedu.address.model.project.Project;
import seedu.address.model.project.ProjectNameContainsKeywordsPredicate;

/**
 * Finds and lists all persons in address book whose name contains any of the argument keywords.
 * Keyword matching is case-insensitive.
 */
public class FindProjectCommand extends Command {

    public static final String COMMAND_WORD = "find-project";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Please Find with the correct input "
            + "Find pr/<Project Name> OR Find r/<Role> OR Find n/<Name>.\n"
            + "Example: " + COMMAND_WORD + " n/ alice bob charlie";

    private KeywordPredicate<Project> predicate;

    public FindProjectCommand(ProjectNameContainsKeywordsPredicate namePredicate) {
        this.predicate = namePredicate;
    }

    public FindProjectCommand(DescriptionContainsKeywordsPredicate rolePredicate) {
        this.predicate = rolePredicate;
    }

    public FindProjectCommand(DeadlineContainsKeywordsPredicate addressPredicate) {
        this.predicate = addressPredicate;
    }

    @Override
    public CommandResult execute(Model model) {
        requireNonNull(model);
        model.updateFilteredProjectList(predicate);
        return new CommandResult(
                String.format(Messages.MESSAGE_DEVELOPERS_LISTED_OVERVIEW, model.getFilteredDeveloperList().size()),TabIndex.Project);
    }


    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof FindProjectCommand)) {
            return false;
        }

        FindProjectCommand otherFindProjectCommand = (FindProjectCommand) other;
        return predicate.equals(otherFindProjectCommand.predicate);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .add("predicate", predicate)
                .toString();
    }
}