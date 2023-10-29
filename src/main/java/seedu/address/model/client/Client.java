package seedu.address.model.client;
import seedu.address.logic.parser.Prefix;
import seedu.address.model.commons.Name;
import seedu.address.model.person.*;

import java.util.Objects;
import java.util.Set;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;
import static seedu.address.logic.parser.CliSyntax.PREFIX_DATEJOINED;
import static seedu.address.logic.parser.CliSyntax.PREFIX_DEADLINE;
import static seedu.address.logic.parser.CliSyntax.PREFIX_DESCRIPTION;
import static seedu.address.logic.parser.CliSyntax.PREFIX_DOCUMENT;
import static seedu.address.logic.parser.CliSyntax.PREFIX_GITHUBID;
import static seedu.address.logic.parser.CliSyntax.PREFIX_ORGANISATION;
import static seedu.address.logic.parser.CliSyntax.PREFIX_RATING;
import static seedu.address.logic.parser.CliSyntax.PREFIX_SALARY;

/**
 * Represents a Client in the address book, extending the Developer class.
 * Guarantees: details are present and not null, field values are validated, immutable.
 */
public class Client extends Person {
    private final Name organisation;
    private final Document document;

    public static final Prefix[] unusedPrefixes = new Prefix[]{ PREFIX_DATEJOINED, PREFIX_SALARY, PREFIX_RATING,
            PREFIX_GITHUBID, PREFIX_DESCRIPTION, PREFIX_DEADLINE };
    
    /**
     * Every field must be present and not null.
     */
    public Client(Name name, Phone phone, Email email, Address address, Role role, Set<String> projects,
                  Name organisation, Document document) {
        super(name, phone, email, address, role, projects);
        requireAllNonNull(organisation, document);
        this.organisation = organisation;
        this.document = document;
    }

    public Name getOrganisation() {
        return organisation;
    }

    public Document getDocument() {
        return document;
    }

    public boolean isSameClient(Client otherClient) {
        if (otherClient == this) {
            return true;
        }

        return otherClient != null
                && otherClient.getName().equals(getName());
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof Client)) {
            return false;
        }

        Client otherClient = (Client) other;
        return super.equals(otherClient) && organisation.equals(otherClient.organisation)
                && document.equals(otherClient.document);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), organisation, document);
    }

    @Override
    public String toString() {
        return super.toString() + " Organisation: " + organisation + " Document: " + document;
    }
}