package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.Assert.assertThrows;
import static seedu.address.testutil.TypicalPersons.ALICE;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Predicate;

import org.junit.jupiter.api.Test;

import javafx.collections.ObservableList;
import seedu.address.commons.core.GuiSettings;
import seedu.address.logic.Messages;
import seedu.address.logic.commands.add.AddDeveloperCommand;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.AddressBook;
import seedu.address.model.Model;
import seedu.address.model.ReadOnlyAddressBook;
import seedu.address.model.ReadOnlyUserPrefs;
import seedu.address.model.person.Developer;
import seedu.address.testutil.PersonBuilder;

public class AddDeveloperCommandTest {

    @Test
    public void constructor_nullPerson_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new AddDeveloperCommand(null));
    }

    @Test
    public void execute_personAcceptedByModel_addSuccessful() throws Exception {
        ModelStubAcceptingPersonAdded modelStub = new ModelStubAcceptingPersonAdded();
        Developer validDeveloper = new PersonBuilder().build();

        CommandResult commandResult = new AddDeveloperCommand(validDeveloper).execute(modelStub);

        assertEquals(String.format(AddDeveloperCommand.MESSAGE_SUCCESS, Messages.format(validDeveloper)),
                commandResult.getFeedbackToUser());
        assertEquals(Arrays.asList(validDeveloper), modelStub.personsAdded);
    }

    @Test
    public void execute_duplicatePerson_throwsCommandException() {
        Developer validDeveloper = new PersonBuilder().build();
        AddDeveloperCommand addDeveloperCommand = new AddDeveloperCommand(validDeveloper);
        ModelStub modelStub = new ModelStubWithPerson(validDeveloper);

        assertThrows(CommandException.class, AddDeveloperCommand.MESSAGE_DUPLICATE_PERSON, () -> addDeveloperCommand.execute(modelStub));
    }

    @Test
    public void equals() {
        Developer alice = new PersonBuilder().withName("Alice").build();
        Developer bob = new PersonBuilder().withName("Bob").build();
        AddDeveloperCommand addAliceCommand = new AddDeveloperCommand(alice);
        AddDeveloperCommand addBobCommand = new AddDeveloperCommand(bob);

        // same object -> returns true
        assertTrue(addAliceCommand.equals(addAliceCommand));

        // same values -> returns true
        AddDeveloperCommand addAliceCommandCopy = new AddDeveloperCommand(alice);
        assertTrue(addAliceCommand.equals(addAliceCommandCopy));

        // different types -> returns false
        assertFalse(addAliceCommand.equals(1));

        // null -> returns false
        assertFalse(addAliceCommand.equals(null));

        // different developer -> returns false
        assertFalse(addAliceCommand.equals(addBobCommand));
    }

    @Test
    public void toStringMethod() {
        AddDeveloperCommand addDeveloperCommand = new AddDeveloperCommand(ALICE);
        String expected = AddDeveloperCommand.class.getCanonicalName() + "{toAdd=" + ALICE + "}";
        assertEquals(expected, addDeveloperCommand.toString());
    }

    /**
     * A default model stub that have all of the methods failing.
     */
    private class ModelStub implements Model {
        @Override
        public void setUserPrefs(ReadOnlyUserPrefs userPrefs) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public ReadOnlyUserPrefs getUserPrefs() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public GuiSettings getGuiSettings() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void setGuiSettings(GuiSettings guiSettings) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public Path getAddressBookFilePath() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void setAddressBookFilePath(Path addressBookFilePath) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void addPerson(Developer developer) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void setAddressBook(ReadOnlyAddressBook newData) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public ReadOnlyAddressBook getAddressBook() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public boolean hasPerson(Developer developer) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void deletePerson(Developer target) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void setPerson(Developer target, Developer editedDeveloper) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public ObservableList<Developer> getFilteredPersonList() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void updateFilteredPersonList(Predicate<Developer> predicate) {
            throw new AssertionError("This method should not be called.");
        }
    }

    /**
     * A Model stub that contains a single developer.
     */
    private class ModelStubWithPerson extends ModelStub {
        private final Developer developer;

        ModelStubWithPerson(Developer developer) {
            requireNonNull(developer);
            this.developer = developer;
        }

        @Override
        public boolean hasPerson(Developer developer) {
            requireNonNull(developer);
            return this.developer.isSamePerson(developer);
        }
    }

    /**
     * A Model stub that always accept the developer being added.
     */
    private class ModelStubAcceptingPersonAdded extends ModelStub {
        final ArrayList<Developer> personsAdded = new ArrayList<>();

        @Override
        public boolean hasPerson(Developer developer) {
            requireNonNull(developer);
            return personsAdded.stream().anyMatch(developer::isSamePerson);
        }

        @Override
        public void addPerson(Developer developer) {
            requireNonNull(developer);
            personsAdded.add(developer);
        }

        @Override
        public ReadOnlyAddressBook getAddressBook() {
            return new AddressBook();
        }
    }

}
