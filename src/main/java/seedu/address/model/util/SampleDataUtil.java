package seedu.address.model.util;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

import seedu.address.model.AddressBook;
import seedu.address.model.ReadOnlyAddressBook;
import seedu.address.model.commons.Date;
import seedu.address.model.commons.Name;
import seedu.address.model.developer.Developer;
import seedu.address.model.developer.GithubId;
import seedu.address.model.developer.Rating;
import seedu.address.model.person.Role;
import seedu.address.model.developer.Salary;
import seedu.address.model.person.*;

/**
 * Contains utility methods for populating {@code AddressBook} with sample data.
 */
public class SampleDataUtil {
    public static Developer[] getSamplePersons() {
        return new Developer[] {
            new seedu.address.model.developer.Developer(new Name("Alex Yeoh"), new Phone("87438807"), new Email("alexyeoh@example.com"),
                new Address("Blk 30 Geylang Street 29, #06-40"), new Role("Developer"), getProjectSet(), new Salary("5000"), new Date("15-12-2019"), new GithubId("mahidharah"), new Rating("5.0")),
            new seedu.address.model.developer.Developer(new Name("Bernice Yu"), new Phone("99272758"), new Email("berniceyu@example.com"),
                new Address("Blk 30 Lorong 3 Serangoon Gardens, #07-18"), new Role("Developer"), getProjectSet("AndroidApp", "customWebsite"), new Salary("6000"), new Date("16-11-2020"), new GithubId("mahidharah1"), new Rating("5.0")),
            new seedu.address.model.developer.Developer(new Name("Charlotte Oliveiro"), new Phone("93210283"), new Email("charlotte@example.com"),
                new Address("Blk 11 Ang Mo Kio Street 74, #11-04"), new Role("Developer"), getProjectSet("AndroidApp"), new Salary("4500"), new Date("20-10-2020"), new GithubId("mahidharah2"), new Rating("5.0")),
            new Developer(new Name("David Li"), new Phone("91031282"), new Email("lidavid@example.com"),
                new Address("Blk 436 Serangoon Gardens Street 26, #16-43"), new Role("Developer"), getProjectSet("customWebsite"), new Salary("5500"), new Date("23-09-2021"), new GithubId("mahidharah3"), new Rating("5.0")),
                  };
    }

    public static ReadOnlyAddressBook getSampleAddressBook() {
        AddressBook sampleAb = new AddressBook();
        for (Developer sampleDeveloper: getSamplePersons()) {
            sampleAb.addDeveloper(sampleDeveloper);
        }
        return sampleAb;
    }

    /**
     * Returns a tag set containing the list of strings given.
     */
    public static Set<String> getProjectSet(String... strings) {
        return Arrays.stream(strings)
                .collect(Collectors.toSet());
    }

}
