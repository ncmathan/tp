package seedu.address.testutil;

import java.util.HashSet;
import java.util.Set;

import seedu.address.model.commons.Date;
import seedu.address.model.commons.Name;
import seedu.address.model.person.Role;
import seedu.address.model.developer.Salary;
import seedu.address.model.person.*;
import seedu.address.model.project.Project;
import seedu.address.model.util.SampleDataUtil;

/**
 * A utility class to help with building Developer objects.
 */
public class PersonBuilder {
    public static final String DEFAULT_NAME = "Amy Bee";
    public static final String DEFAULT_PHONE = "85355255";
    public static final String DEFAULT_EMAIL = "amy@gmail.com";
    public static final String DEFAULT_ADDRESS = "123, Jurong West Ave 6, #08-111";
    public static final Date DEFAULT_DATE_JOINED = new Date("01-01-2022");
    public static final Username DEFAULT_USERNAME = new Username("amy_bee");
    public static final Password DEFAULT_PASSWORD = new Password("password123");
    public static final Role DEFAULT_ROLE = new Role("User");
    public static final Salary DEFAULT_SALARY = new Salary("50000");

    private Name name;
    private Phone phone;
    private Email email;
    private Address address;
    private Set<Project> projects;
    private Date dateJoined;
    private Username username;
    private Password password;
    private Role role;
    private Salary salary;

    public PersonBuilder() {
        name = new Name(DEFAULT_NAME);
        phone = new Phone(DEFAULT_PHONE);
        email = new Email(DEFAULT_EMAIL);
        address = new Address(DEFAULT_ADDRESS);
        projects = new HashSet<>();
        dateJoined = DEFAULT_DATE_JOINED;
        username = DEFAULT_USERNAME;
        password = DEFAULT_PASSWORD;
        role = DEFAULT_ROLE;
        salary = DEFAULT_SALARY;
    }

    public PersonBuilder(Developer developerToCopy) {
        name = developerToCopy.getName();
        phone = developerToCopy.getPhone();
        email = developerToCopy.getEmail();
        address = developerToCopy.getAddress();
        projects = new HashSet<>(developerToCopy.getProjects());
        dateJoined = developerToCopy.getDateJoined();
        username = developerToCopy.getUsername();
        password = developerToCopy.getPassword();
        role = developerToCopy.getRole();
        salary = developerToCopy.getSalary();
    }

    public PersonBuilder withName(String name) {
        this.name = new Name(name);
        return this;
    }

    public PersonBuilder withProjects(String... tags) {
        this.projects = SampleDataUtil.getProjectSet(tags);
        return this;
    }

    public PersonBuilder withAddress(String address) {
        this.address = new Address(address);
        return this;
    }

    public PersonBuilder withPhone(String phone) {
        this.phone = new Phone(phone);
        return this;
    }

    public PersonBuilder withEmail(String email) {
        this.email = new Email(email);
        return this;
    }

    public PersonBuilder withDateJoined(String dateJoined) {
        this.dateJoined = new Date(dateJoined);
        return this;
    }

    public PersonBuilder withUsername(String username) {
        this.username = new Username(username);
        return this;
    }

    public PersonBuilder withPassword(String password) {
        this.password = new Password(password);
        return this;
    }

    public PersonBuilder withRole(String role) {
        this.role = new Role(role);
        return this;
    }

    public PersonBuilder withSalary(String salary) {
        this.salary = new Salary(salary);
        return this;
    }

    public Developer build() {
        return new Developer(name, phone, email, address, dateJoined, username, password, role, salary, projects);
    }
}
