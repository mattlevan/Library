/* User.java
 *
 * Abstract superclass for all users (managers, customers) in the library.
 *
 * @author Matthew Scott Levan
 * @version 03/20/2015
 * @semester Spring 2015
 */

import java.util.*;
import java.io.*;

public class User {
    // variables common to customers and managers
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private int itemsHeld;
    private boolean loggedIn;
    private boolean managerStatus;

    // instantiate Scanner for user keyboard input
    Scanner input = new Scanner(System.in);

    // abstract method implementation for registering a new customer
    public void register() {
        System.out.println("\nThank you for choosing our library! Please " +
        "enter your information:\n");

        // set username
        System.out.print("Username: ");
        setUsername(input.next());

        // set password
        System.out.print("Password: ");
        setPassword(input.next());

        // set first name
        System.out.print("First name: ");
        setFirstName(input.next());

        // set last name
        System.out.print("Last name: ");
        setLastName(input.next());

        // set email
        System.out.print("Email address: ");
        setEmail(input.next());

        // authenticate manager. manager password = "manager"
        System.out.print("Manager password: ");
        setManagerStatus(input.next());
    }

    // method for login
    public void login() {
        // get username
        System.out.print("\nPlease login...\n\nUsername: ");
        setUsername(input.next());

        // get password
        System.out.print("Password: ");
        setPassword(input.next());

        // if username/password combination exists, login
        if (Library.userDatabase.search(username, password) == true) {
            System.out.println("\nLogin successful!");
            setLoggedIn(true);
        }
        else {
            System.out.println("\nUsername and password do not match!\n");
            login();
        }
    }

    // method for logout
    public void logout() {
        setLoggedIn(false);
    }

    // SETTERS
    // username setter
    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // firstName setter
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    // lastName setter
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    // email setter
    public void setEmail(String email) {
        this.email = email;
    }

    // loggedIn setter
    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }

    // managerStatus setter
    public void setManagerStatus(boolean managerStatus) {
        this.managerStatus = managerStatus;
    }

    // managerStatus setter with password
    public void setManagerStatus(String managerPassword) {
        if (managerPassword.equals("manager")) {
            this.managerStatus = true;
        }
        else {
            this.managerStatus = false;
        }
    }


    // GETTERS
    // username getter
    public String getUsername() {
        return username;
    }

    // password getter
    public String getPassword() {
        return password;
    }

    // firstName getter
    public String getFirstName() {
        return firstName;
    }

    // lastName getter
    public String getLastName() {
        return lastName;
    }

    // email getter
    public String getEmail() {
        return email;
    }

    // loggedIn getter
    public boolean getLoggedIn() {
        return loggedIn;
    }

    // managerStatus getter
    public boolean getManagerStatus() {
        return managerStatus;
    }
}
