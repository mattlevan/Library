/* ItemDatabase.java
 *
 * Subclass for the item database in the library
 * (extends Database superclass).
 *
 * @author Matthew Scott Levan
 * @version 03/20/2015
 * @semester Spring 2015
 */

import java.util.*;
import java.io.*;

public class ItemDatabase extends Database {
    private String fileName = "item_database.txt";

    // default constructor
    public ItemDatabase() {

    }

    // abstract method implementation for reading item information
    // from a text file fileName
    public void read() {

    }

    // abstract method implementation for writing item information
    // to a text file fileName
    public boolean write(Item item) {
        Book book = (Book) item;

        // use try/catch block in case of file not found and/or IO error(s)
        try {
            // FILE WRITER
            // FileWriter writes text
            FileWriter fw = new FileWriter(fileName, true);
            // always wrap FileWriter in a BufferedWriter
            BufferedWriter bw = new BufferedWriter(fw);
            // always wrap BufferedWriter in a PrintWriter
            PrintWriter pw = new PrintWriter(bw);

            // author
            pw.print("AUTHOR: ");
            pw.print(book.getAuthor());

            // title
            pw.print(" TITLE: ");
            pw.print(book.getTitle());

            // ISBN
            pw.print(" ISBN: ");
            pw.print(book.getISBN());

            // item type
            pw.print(" TYPE: ");
            pw.print(book.getItemType());

            // page number
            pw.print(" PAGES: ");
            pw.print(book.getPages());

            // due date
            pw.print(" DUE: ");
            pw.print(book.getDueDate());

            // availability
            if (book.getAvailability() == true) {
                pw.print(" AVAILABLE");
            }
            else {
                pw.print(" UNAVAILABLE");
            }

            pw.println("");

            pw.close();
            bw.close();
            fw.close();

            return true;

        // catch file not found error
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        // catch IO error (bad input/output)
        } catch (IOException e) {
            e.printStackTrace();
        }

        return false;
    }

    // abstract method implementation for searching through items
    // stored within a text file fileName, returns true if found a match
    // and false if not
    public boolean search(Item item) {
        System.out.println("Enter a keyword and press ENTER to search: ");

        Scanner input = new Scanner(System.in); // declare keyboard input Scanner
        String keyword = input.next(); // get keyword from user keyboard
        String line; // String variable for storing lines from text file

        // use try/catch block in case of file not found and/or IO error(s)
        try {
            // FileReader reads text in standard encoding (UTF-8)
            FileReader fileReader = new FileReader(fileName);
            // always wrap FileReader in a BufferedReader
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            // get one line at a time from the file until none are left (null)
            while ((line = bufferedReader.readLine()) != null) {
                // instantiate a temporary String[] to store each word in the
                // line by using the built-in method split()
                String[] wordList = line.split(" ");

                // for each word in the wordList
                for (String word : wordList) {
                    // check if keyword matches the current word
                    if (keyword.equals(word)) {
                        // if yes, print the line of all item's info
                        System.out.println(line);
                        return true;
                    }
                }
            }

        // catch file not found error
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        // catch IO error (bad input/output)
        } catch (IOException e) {
            e.printStackTrace();
        }

        return false;
    }
}
