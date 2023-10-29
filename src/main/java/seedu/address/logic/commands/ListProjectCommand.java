package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;
import static seedu.address.model.Model.PREDICATE_SHOW_ALL_PROJECTS;

import seedu.address.model.Model;

/**
 * Lists all persons in the address book to the user.
 */
public class ListProjectCommand extends Command {

    public static final String COMMAND_WORD = "list-project";

    public static final String MESSAGE_SUCCESS = "Listed all projects";


    @Override
    public CommandResult execute(Model model) {
        assert model != null : "Model cannot be null";
        requireNonNull(model);
        model.updateFilteredProjectList(PREDICATE_SHOW_ALL_PROJECTS);
        return new CommandResult(MESSAGE_SUCCESS, TabIndex.Project);
    }
}
