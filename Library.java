/* Library.java
 *
 * Driver class for the library management system.
 *
 * @author Matthew Scott Levan
 * @version 03/20/2015
 * @semester Spring 2015
 */

import java.util.*;
import java.io.*;

public class Library {
    protected static User user = new User();
    protected static Book book = new Book();
    protected static UserDatabase userDatabase = new UserDatabase();
    protected static ItemDatabase itemDatabase = new ItemDatabase();

    protected static Character userChar = null;

    public static void main(String[] args) {
        // print a welcome message
        System.out.println("Welcome to the library!");

        // register, customer login, or manager login
        if (authenticateUser() == true) {
            // customers: search, displayfeatured items, return item,
            // managers: (all customer actions), register item
            chooseActivity();
        }
    }

    // return true if successful, false if not
    public static boolean authenticateUser() {
        // print welcome message
        System.out.print("Press 'R' to register or 'L' to login: ");

        // getUserChar
        userChar = getUserChar();

        // switch statement with uppercase userChar
        switch (userChar) {
            // if user input is an 'R' (register)
            case ('R'):
                // register
                user.register();
                userDatabase.write(user);
                user.login();
                break;

            // if user input is an 'L' (login)
            case ('L'):
                // login
                user.login();
                break;

            // default: break;
            default:
                return false;
        }

        return true;
    }

    // method for users to choose a library activity
    public static void chooseActivity() {
        // activity chooser message
        // check if manager
        if (user.getManagerStatus() == true) {
            // include manager tools option
            System.out.print("\nPress 'S' to search the library or 'M' for manager tools: ");
        }
        else {
            // message for customers (not managers)
            System.out.print("\nPress 'S' to search the library: ");
        }

        // getUserChar
        userChar = getUserChar();

        // switch statement with uppercase userChar
        switch (userChar) {
            // if user input is an 'S' (search)
            case ('S'):
                //itemDatabase.search();
                break;
            // if user input is an 'M' (manager tools)
            case ('M'):
                manageLibrary();
                break;
            // default: break;
            default:
                break;
        }
    }

    public static void manageLibrary() {
        System.out.print("\nPress 'R' to register a new book or 'B' to go back: ");

        // getUserChar
        userChar = getUserChar();

        // switch statement with uppercase userChar
        switch (userChar) {
            // if user input is an 'R' (register new item)
            case ('R'):
                book.register();
                manageLibrary();
                break;
            case ('B'):
                chooseActivity();
                break;
            default:
                break;
        }
    }

    public static Character getUserChar() {
        Scanner input = new Scanner(System.in);
        Character c = input.next().charAt(0);
        c = Character.toUpperCase(c);
        return c;
    }
}
