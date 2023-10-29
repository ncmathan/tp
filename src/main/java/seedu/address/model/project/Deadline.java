package seedu.address.model.project;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;
import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Objects;

import seedu.address.commons.util.ToStringBuilder;
import seedu.address.model.commons.Date;

/**
 * Represents a Project's deadline in the address book.
 * Guarantees: immutable; fields are validated.
 */
public class Deadline {
    public static final String MESSAGE_CONSTRAINTS =
            "Deadline should be of the format dd-MM-yyyy,<DESCRIPTION>,<HIGH|MEDIUM|LOW>,<0|1>\n" +
                    "Eg: 31-12-2019,Develop front end interface,HIGH,0";
    public static final String VALIDATION_REGEX = "^[0-3]\\d-[01]\\d-\\d{4},[^,]+,(HIGH|MEDIUM|LOW),(0|1)$";
    
    private final Date date;
    private final Description desc;
    private final Priority priority;

    private final boolean isDone;

    /**
     * Every field must be present and not null.
     */
    public Deadline(Date date, Description desc, Priority priority, boolean isDone) {
        requireAllNonNull(date, desc,priority,isDone);
        this.date = date;
        this.desc = desc;
        this.priority = priority;
        this.isDone = isDone;
    }
    public Deadline (String str) {
        requireNonNull(str);
        checkArgument(isValidDeadline(str), MESSAGE_CONSTRAINTS);
        String[] output = str.split(",");
        this.date = new Date(output[0]);
        this.desc = new Description(output[1]);
        this.priority= Priority.valueOf(output[2]);
        this.isDone = output[3].contains("1");
    }
    /**
     * Returns true if a given string is a valid date.
     */
    public static boolean isValidDeadline(String text) {
        if (text == null || !text.matches(VALIDATION_REGEX))
            return false;
        return true;
    }
    
    public Date getDate() {
        return date;
    }
    
    public Description getDescription() {
        return desc;
    }
    
    public Priority getPriority() {
        return priority;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof Deadline)) {
            return false;
        }

        Deadline otherDeadline = (Deadline) other;
        return date.equals(otherDeadline.date)
                && desc.equals(otherDeadline.desc)
                && priority.equals(otherDeadline.priority);
    }

    public String getStringRepresentation() {
        return date.toString()+","+desc.toString()+","+priority.toString()+","+(isDone? "1" : "0");
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, desc, priority);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .add("date", date)
                .add("description", desc)
                .add("priority", priority)
                .toString();
    }

    public boolean getIsDone() {
        return isDone;
    }
}
