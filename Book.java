/* Book.java
 *
 * Subclass for all books in the library management system
 * (extends Item superclass).
 *
 * @author Matthew Scott Levan
 * @version 03/20/2015
 * @semester Spring 2015
 */

import java.util.*;
import java.io.*;
import java.text.*;

public class Book extends Item {
    // Scanner object for getting user keyboard input
    Scanner input = new Scanner(System.in);

    // returns true for success, false for otherwise
    public void register() {
        System.out.println("\nPlease enter the book's information...\n");

        // set author
        System.out.print("Author last name: ");
        setAuthor(input.nextLine());

        // set title
        System.out.print("Title: ");
        super.setTitle(input.nextLine());

        // set ISBN
        System.out.print("ISBN: ");
        setISBN(input.next());

        // set item type
        super.setItemType("Book");

        // set pages
        System.out.print("Number of pages: ");
        super.setPages(Integer.parseInt(input.next()));

        // set availability
        super.setAvailability(true);

        // set due date
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        Calendar cal = Calendar.getInstance();

        cal.setTime(date);
        cal.add(Calendar.DATE, 14); // add 14 days to current date

        String dueDate = sdf.format(cal.getTime());

        super.setDueDate(dueDate);

        if (Library.itemDatabase.write(Library.book) == true) {
            System.out.println("\nBook added successfully. Thank you!");
        }
    }

    // SETTERS
    // set author
    public void setAuthor(String author) {
        this.author = author;
    }

    // set ISBN
    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    // GETTERS
    // get author
    public String getAuthor() {
        return author;
    }

    // get ISBN
    public String getISBN() {
        return ISBN;
    }
}
