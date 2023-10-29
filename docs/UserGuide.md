---
layout: page
title: User Guide
pageNav: 3
---
Seamlessly integrate contact, client, and project management, simplifying access to coding-related contacts, facilitating collaboration, and offering command-line efficiency for project managers

CodeContact is a **desktop app for managing contacts, optimized for use via a Command Line Interface** (CLI) while still having the benefits of a Graphical User Interface (GUI). If you can type fast, CodeContact can get your contact management tasks done faster than traditional GUI apps.

* Table of Contents
  * [Quick Start](#quick-start)
  * [Features](#features)
    * [Adding new information `add`](#adding-new-information--add)
    * [Editing information `edit`](#edit)
    * [Finding information `find`](#find-according-to-type-and-industry-details--find)
    * [Listing information `list`](#listing-information--list)
    * [Delete information `delete`](#deleting-a-developer--delete)  
    * [Help `help`](#viewing-help--help)
    * [Clear entries `clear`](#clearing-all-entries--clear)
    * [Exit program `exit`](#exiting-the-program--exit)
  * [FAQ](#faq)
  * [Known Issues](#known-issues)
  * [Command Summary](#command-summary)

--------------------------------------------------------------------------------------------------------------------
## Quick start

1. Ensure you have Java `11` or above installed in your Computer.

1. Download the latest `codecontact.jar`.

1. Copy the file to the folder you want to use as the _home folder_ for your CodeContact.

1. Open a command terminal, `cd` into the folder you put the jar file in, and use the `java -jar codecontact.jar` command to run the application.<br>
   A GUI similar to the below should appear in a few seconds. Note how the app contains some sample data.<br>
   ![Ui](images/Ui.png)

1. Type the command in the command box and press Enter to execute it. e.g. typing **`help`** and pressing Enter will open the help window.<br>
   Some example commands you can try:

    * `list developers` : Lists all developers.

    * `n/Amy p/12345678 e/any.u.nus.edu a/NUS UTOWN d/06-09-2023 r/Developer s/4999 pr/{PROJECT1, PROJECT2…}` : Adds a contact named `John Doe` to the Address Book.

    * `delete developer 3` : Deletes the 3rd contact shown in the current list.

    * `clear` : Deletes all contacts.

    * `exit` : Exits the app.

1. Refer to the [Features](#features) below for details of each command.

--------------------------------------------------------------------------------------------------------------------
## Features

<div markdown="block" class="alert alert-info">

**:information_source: Notes about the command format:**<br>

* Words in `UPPER_CASE` are the parameters to be supplied by the user.<br>
  e.g. in `add n/NAME`, `NAME` is a parameter which can be used as `add n/John Doe`.

* Items in square brackets are optional.<br>
  e.g `n/NAME [t/TAG]` can be used as `n/John Doe t/friend` or as `n/John Doe`.

* Items with `…`​ after them can be used multiple times including zero times.<br>
  e.g. `[t/TAG]…​` can be used as ` ` (i.e. 0 times), `t/friend`, `t/friend t/family` etc.

* Parameters can be in any order.<br>
  e.g. if the command specifies `n/NAME p/PHONE_NUMBER`, `p/PHONE_NUMBER n/NAME` is also acceptable.

* Extraneous parameters for commands that do not take in parameters (such as `help`, `list`, `exit` and `clear`) will be ignored.<br>
  e.g. if the command specifies `help 123`, it will be interpreted as `help`.

* If you are using a PDF version of this document, be careful when copying and pasting commands that span multiple lines as space characters surrounding line-breaks may be omitted when copied over to the application.
</div>

### Adding new information : `add`
* What it does:
    * Manager can add a new employee to the list of people into the data one by one
* Format
    * `create new employee`
    * `n/NAME p/PHONE_NUMBER e/EMAIL a/ADDRESS d/DATE_JOINED r/ROLE s/SALARY pr/{PROJECT1, PROJECT2…}`
* Example
    * User types: `create new employee`
    * CLI  shows: `Input employee details in the format below:`
      `n/NAME p/PHONE_NUMBER e/EMAIL a/ADDRESS d/DATE_JOINED r/ROLE `
    * User types: `n/AMY p/87654321 e/amy@u.nus.edu a/NUS UTOWN d/06 Sep 2023 r/Developer s/4999`
* Acceptable parameters
    * Names can only consist of capital and small letters, spaces and hyphens.
    * Contact number has to 8 digits without spaces
    * Email has to be of the format `<TEXT>@<TEXT>`
    * Date joined has to be of format `dd mmm yyyy `(E.x 09 Sept 2022)
    * Salary has to be at least 4 digits
    * Project should be valid project name already listed in the company, multiple projects have to be comma separated
    * Password is at least 8 characters long, with a combination of uppercase letters, lowercase letters, numbers, and symbols
* When command succeeds
    * Continuing from the above example, CLI shows:
    ```
  The following user has been added:
  Name: AMY
    Contact Number: 87654321
    Email: amy@u.nus.edu
    Address: NUS UTOWN
    Date Joined: 06 Sep 2023
    Role: Developer
    Salary: 4999
    Assigned Projects:login
    Username: amy
    Password: Password123!
  ```
* When command fails
    * User particular's error
        * `Error! New user’s <PARTICULAR> already exists in <COMPANY_NAME>`
    * Format error
        * `Error! New user’s <PARTICULAR> does not follow the format: <FORMAT>`
        * E.g.:  `Error! New user’s name does not follow the format:
          Names can only consist of capital and small letters, spaces and hyphens.`
    * Missing particular's error
        * `Error! New user’s {MISSING_PARTICULARS} are missing.`
* Relevant UI mock-ups

### Edit
#### Edit developer details
Edits the details of an existing developer in the address book.

Format: `edit-developer INDEX [n/NAME] [p/PHONE_NUMBER] [e/EMAIL] [a/ADDRESS] [d/DATE_JOINED] [r/ROLE] [s/SALARY] [pr/PROJECT_NAME]... [gh/GITHUB_ID] [ra/RATING]`

* Edits the developer at the specified `INDEX` in the currently displayed developer list.
* At least one of the optional fields must be provided.
* Existing values will be updated to the input values.
* When editing projects, the existing assigned projects of the developer will be removed ie. adding of projects is not cumulative.
* You can remove all the developer's projects by typing `p/` without specifying any project name after it.

Example of usage: `edit-developer 2 p/98989898 pr/Project2 pr/Project3`
  * Edits `AMY`'s phone number to `98989898` and changes the projects assigned to her to `Project2` and `Project3`.

Acceptable parameters: 
* `INDEX` must be a positive integer.
* `NAME` and `PROJECT_NAME` can only consist of capital and small letters, spaces and hyphens.
* `NAME` cannot be the same as another existing developer's name in the address book.
* `PHONE_NUMBER` has to 8 digits without spaces.
* `EMAIL` has to be of the format `<TEXT>@<TEXT>`.
* `DATE_JOINED` has to be of format `dd-MM-yyyy` (e.g. `31-12-2019`).
* `ROLE` has to be.......??
* `SALARY` has to be at least 4 digits.
* `PROJECT_NAME` should be the name of an existing project.

When command succeeds, CLI shows:          (??)
```
Here are the updated employee details:
Name: AMY
Contact Number: 98989898
Email: amy@u.nus.edu
Address: NUS UTOWN
Date Joined: 06-09-2023
Role: Developer
Salary: 6999
Assigned Projects: Project1, Project2
```
* When command fails
    * Repetitive name
        * `More than 1 developer with the NAME has been found, please input employee’s phone number:`
    * Invalid input
        * `Please input the employee details in the right format`
    * No access error
        * `You do not have access to modify this. Please contact your administrator.`
    * Format error
        * `Error! New user’s <PARTICULAR> does not follow the format: <FORMAT>`
        * E.x.:  `Error! New user’s name does not follow the format:
          Names can only consist of capital and small letters, spaces and hyphens.`

When command fails due to an error, the respective error message will be displayed:
* Non-existent developer
  * `There is no employee with that name!`
* Non-existent project
  * `There is no project with that name!`
* Invalid command format
  * `Please input the employee details in the correct format!`
* No edits in input command
  * `At least one field to edit must be provided!`
* Invalid command target
  * `Invalid command target! You cannot call edit-d on the target.`

Relevant UI mock-ups (???)

#### Edit client details
Edits the details of an existing client in the address book.

Format: `edit-client INDEX [n/NAME] [p/PHONE_NUMBER] [e/EMAIL] [a/ADDRESS] [pr/PROJECT_NAME]...  [o/ORGANISATION]`

* Edits the client at the specified `INDEX` in the currently displayed client list.
* At least one of the optional fields must be provided.
* Existing values will be updated to the input values.
* When editing projects, the existing assigned projects of the client will be removed ie. adding of projects is not cumulative.
* You can remove all the client's projects by typing `p/` without specifying any project name after it.

Example of usage: `edit-client 3 p/bob@gmail.com`
* Edits `BOB`'s email to `bob@gmail.com`.

Acceptable parameters:
* `INDEX` must be a positive integer.
* `NAME`, `PROJECT_NAME` and `ORGANISATION` can only consist of capital and small letters, spaces and hyphens.
* `NAME` cannot be the same as another existing client's name in the address book.
* `PHONE_NUMBER` has to 8 digits without spaces.
* `EMAIL` has to be of the format `<TEXT>@<TEXT>`.
* `PROJECT_NAME` should be the name of an existing project.

When command succeeds, CLI shows: (??)
```
Here are the updated employee details:
Name: BOB
Contact Number: 87654321
Email: bob@gmail.com
Address: Blk 123 Banana Road
Projects: Project1
Organisation: Banana
```

When command fails due to an error, the respective error message will be displayed:
* Non-existent client
    * `There is no client with that name!`
* Non-existent project
    * `There is no project with that name!`
* Invalid command format
    * `Please input the client details in the correct format!`
* No edits in input command
    * `At least one field to edit must be provided!`
* Invalid command target
    * `Invalid command target! You cannot call edit-d on the target.`

Relevant UI mock-ups (???)

#### Edit project details
Edits the details of an existing project in the address book.

Format: `edit-project INDEX [desc/DESCRIPTION] [d/DEADLINE]...`

* Edits the project at the specified `INDEX` in the currently displayed project list.
* At least one of the optional fields must be provided.
* Existing values will be updated to the input values.
* When editing deadlines, the existing deadlines will be removed ie. adding of projects is not cumulative.
* You can remove all the current deadlines by typing `d/` without specifying any deadline.
* The name of a project cannot be edited.

Example of usage: `edit-project 1 d/Finish Feature-A by: 09-09-2023`
* Deletes existing project deadlines and adds new deadline `Finish Feature-A by: 09-09-2023`

Acceptable parameters:
* `INDEX` must be a positive integer.
* `DEADLINE` should be of the format `DEADLINE_DESCRIPTION by: DATE`, where `DATE` is in `dd-MM-yyyy` format.

When command succeeds, CLI shows: (??)
```
Here are the updated project details:
Name: Project1
Description: Project1's deliverable is a CLI chatbot to manage tasks.
Deadlines: 
    1. Finish Feature-A by: 09-09-2023
    2. Finish Feature-B by: 20-09-2023
    3. Release first iteration by: 30-09-2023.
```

When command fails due to an error, the respective error message will be displayed:
* Non-existent project
    * `There is no project with that name!`
* Invalid command format
    * `Please input the project details in the correct format!`
* No edits in input command
    * `At least one field to edit must be provided!`
* Invalid command target
    * `Invalid command target! You cannot call edit-developers on the target.`

Relevant UI mock-ups (???)

### Find according to type and industry details: `Find`
* What it does
    * Project managers can find developers and clients for contacts related to the keyword (eg. by Find project name, members of the project team will appear)
* Format
    * `find-developer p/<Project Name>`
    * `find-developer r/<Role>`
    * `find-client n/<Name>`
* Example
    * `find-developer p/2103/T` (Prints developers in 2103/T prj)
    * `find-developer r/Senior Developer` (Prints developers of the senior developer role)
    * `find-client n/Amy` (Prints everyone of the name Amy)
* Acceptable Parameters
    * Incomplete inputs for string searches work too
    * Anything beyond p/ and r/ and n/ does not work
    * Name must be closely following  / for more accurate output (eg. n/Amy vs n/ Amy)
* When command succeeds
    * `These are the project members for the project <Project Name>` followed by list of project members
    * `These are all the Senior Developers in this company` followed by list of senior developers
    * `This is Amy’s contact` / `These are the contact details for Amy` followed by Amy’s details or list of all the Amy’s contact
      `No relevant contact details can be found`
* When command fails
    * Missing header<br> `Please find with the correct input find p/<Project Name> OR find r/<Role> OR find n/<Name>`
    * Invalid input<br> `x/ is not a valid type to find, Please find with the correct input find p/<Project Name> OR find r/<Role> OR find n/<Name>`

* Relevant UI mock-ups

### Listing information : `list`

Shows a list of all developers in the address book.

Format: `list TYPE`

* lists the specific type of thing you are asking

Examples:`list developers`
* lists all the developers

Acceptable inputs: 
* `developers` to list the developers
* `clients` to list the clients
* `projects` to list the projects

When command fails due to an error, the respective error message will be displayed:
* Invalid input 
    * `This is an invalid field to list, you can only list developers, clients or projects`

### Deleting a developer : `delete`

Deletes the specified developer from the address book.

Format: `delete INDEX`

* Deletes the developer at the specified `INDEX`.
* The index refers to the index number shown in the displayed developer list.
* The index **must be a positive integer** 1, 2, 3, …​

Examples:
* `list` followed by `delete 2` deletes the 2nd developer in the address book.
* `find Betsy` followed by `delete 1` deletes the 1st developer in the results of the `find` command.

### Viewing help : `help`

Shows a message explaning how to access the help page.

Format: `help`

### Clearing all entries : `clear`

Clears all entries from the address book.

Format: `clear`

### Exiting the program : `exit`

Exits the program.

Format: `exit`

### Feedback System `[coming in v2.0]`

--------------------------------------------------------------------------------------------------------------------

## FAQ

**Q**: How do I transfer my data to another Computer?<br>
**A**: Install the app in the other computer and overwrite the empty data file it creates with the file that contains the data of your previous AddressBook home folder.

**Q**: How can I launch CodeContact if the clicking on the JAR file does not work? <br>
**A**: There are two possible methods to launch CodeContact.
<br>
* Method 1: For users familiar with the command prompt
1. Open the command prompt
1. Navigate to the directory where the JAR file is located using cd [JAR file location]
1. Type java -jar CodeContact.jar and press enter
1. CodeContact should launch
<br> <br>
* Method 2: For users that wish to create a script to launch Docedex (Recommended)
1. Create a new text file
2. Type the following into the text file:
   `java -jar [JAR file location]/CodeContact.jar`
3. Save the text file as CodeContact.bat (Windows) or CodeContact.sh (MacOS/Linux)
4. Change the admin settings of the script to allow it to run as a program:
   * Windows: Right-click on the script and select Properties. Under General , check
   the box that says Allow this file to run as a program .
   * MacOS/Linux: Open the terminal and navigate to the directory where the script is
   located. Type `chmod +x [script name]` and press enter. ( `chmod +x` changes
   permissions of the script to allow it to be executed.)
5. Double-click on the script to launch CodeContact
6. CodeContact should launch

**Q**: How can i check my java version?<br>
**A**: Open a command prompt and type `java -version` . If you do not have Java installed, you
can download it [here](https://www.oracle.com/java/technologies/downloads/#java11)

--------------------------------------------------------------------------------------------------------------------

## Known issues

1. **When using multiple screens**, if you move the application to a secondary screen, and later switch to using only the primary screen, the GUI will open off-screen. The remedy is to delete the `preferences.json` file created by the application before running the application again.

--------------------------------------------------------------------------------------------------------------------

## Command summary

| Action              | Format, Examples                                                                                                                                                                                                                                             |
|---------------------|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| **add developers**  | Format: <br> <br> Example: <br><br>                                                                                                                                                                                                                          |
| **add clients**     | Format: <br> <br> Example: <br><br>                                                                                                                                                                                                                          |
| **add projects**    | Format: <br> <br> Example: <br><br>                                                                                                                                                                                                                          |
| **edit developers** | Format: <br>`edit-developer INDEX INDEX [n/NAME] [p/PHONE_NUMBER] [e/EMAIL] [a/ADDRESS] [d/DATE_JOINED] [r/ROLE] [s/SALARY] [pr/PROJECT_NAME]... [gh/GITHUB_ID] [ra/RATING]`  <br> Example: <br> `edit-developers 2 p/98989898 pr/Project2 pr/Project3` <br> |
| **edit clients**    | Format: <br>`edit-client INDEX INDEX [n/NAME] [p/PHONE_NUMBER] [e/EMAIL] [a/ADDRESS] [d/DATE_JOINED] [r/ROLE] [s/SALARY] [pr/PROJECT_NAME]... [gh/GITHUB_ID] [ra/RATING]`  <br> Example: <br> `edit-clients 3 p/bob@gmail.com` <br>                          |
| **edit projects**   | Format: <br>`edit-project INDEX [n/NAME] [desc/DESCRIPTION] [gh/GITHUB_REPO] [d/DEADLINE]...`  <br> Example: <br> `edit-projects 1 d/Finish Feature-A by: 09-09-2023` <br>                                                                                   |
| **find developers** | Format: <br>`find-developer p/<Project Name>` <br> Example: <br>`find-developer p/2103/T` <br>                                                                                                                                                               |
| **find clients**    | Format: <br>`find-client n/<Name>` <br> Example: <br>`find-client n/Amy` <br>                                                                                                                                                                                |
| **find projects**   | Format: <br>`find-project dr/description` <br> Example: <br>`find-project dr/school semester project` <br>                                                                                                                                                   |
| **delete**          | Format: <br> <br> Example: <br><br>                                                                                                                                                                                                                          |
| **list**            | Format: <br> `list-developers` <br>  `list-projects` <br> `list-clients`                                                                                                                                                                                     |
| **help**            | `help`                                                                                                                                                                                                                                                       |
