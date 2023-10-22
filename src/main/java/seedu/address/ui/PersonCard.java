package seedu.address.ui;

import java.util.Comparator;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import seedu.address.model.person.Person;
import seedu.address.model.person.Role;


/**
 * An UI component that displays information of a {@code Person}.
 */
public class PersonCard extends UiPart<Region> {

    private static final String FXML = "PersonListCard.fxml";

    /**
     * Note: Certain keywords such as "location" and "resources" are reserved keywords in JavaFX.
     * As a consequence, UI elements' variable names cannot be set to such keywords
     * or an exception will be thrown by JavaFX during runtime.
     *
     * @see <a href="https://github.com/se-edu/addressbook-level4/issues/336">The issue on AddressBook level 4</a>
     */

    public final Person person;

    @FXML
    private HBox cardPane;
    @FXML
    private Label name;
    @FXML
    private Label id;
    @FXML
    private Label phone;
    @FXML
    private Label address;
    @FXML
    private Label email;
    @FXML
    private Label dateJoined;
    @FXML
    private Label username;
    @FXML
    private Label password;
    @FXML
    private Label roles;
    @FXML
    private Label salary;
    @FXML
    private FlowPane tags;
    private static Role role = new Role("Developer");

    /**
     * Creates a {@code PersonCode} with the given {@code Person} and index to display.
     */
    public PersonCard(Person person, int displayedIndex) {
        super(FXML);
        this.person = person;
        id.setText(displayedIndex + ". ");
        name.setText(person.getName().fullName);
        phone.setText(person.getPhone().value);
        email.setText(person.getEmail().value);
        roles.setText(person.getRole().role);

        if (PersonCard.role.equals(new Role("HR"))) {
            address.setText(person.getAddress().value);
            dateJoined.setText(String.valueOf(person.getDateJoined().value));
            username.setText(person.getUsername().username);
            password.setText(person.getPassword().password);
            roles.setText(person.getRole().role);
            salary.setText(String.valueOf(person.getSalary().salary));
            person.getProjects().stream()
                    .sorted(Comparator.comparing(tag -> tag.projectName))
                    .forEach(tag -> tags.getChildren().add(new Label(tag.projectName)));
        } else if (PersonCard.role.equals(new Role("Manager"))) {
            person.getProjects().stream()
                    .sorted(Comparator.comparing(tag -> tag.projectName))
                    .forEach(tag -> tags.getChildren().add(new Label(tag.projectName)));
        } else if (PersonCard.role.equals(new Role("Developer"))) {
        }
    }

    /**
     * Sets the current user's role in the PersonCard application based on the provided Person object.
     *
     * @param user The Person object representing the current user.
     *             This person's role will be used to set the user's role in the application.
     */
    public static void setCurrentUser(Person user) {
        PersonCard.role = user.getRole();
    }
}
