/* CustomerDatabase.java
 *
 * Subclass for the customer database in the library
 * (extends Database superclass).
 *
 * @author Matthew Scott Levan
 * @version 03/20/2015
 * @semester Spring 2015
 */
 
import java.util.*;
import java.io.*;

public class UserDatabase extends Database {
    // file name for storing the customer database
    private String fileName = "user_database.txt";

    // Scanner object for customer keyboard input
    private Scanner input = new Scanner(System.in);

    // default constructor
    public UserDatabase() {}

    // abstract method implementation for browseing customer information
    // from a text file fileName
    public void read() {

    }

    // abstract method implementation for writing customer information
    // to a text file fileName, returns true if successful, false if not
    public void write(User user) {
        // use try/catch block in case of file not found and/or IO error(s)
        try {
            // FILE WRITER
            // FileWriter writes text
            FileWriter fw = new FileWriter(fileName, true);
            // always wrap FileWriter in a BufferedWriter
            BufferedWriter bw = new BufferedWriter(fw);
            // always wrap BufferedWriter in a PrintWriter
            PrintWriter pw = new PrintWriter(bw);

            // username
            pw.print("USERNAME: ");
            pw.print(user.getUsername());

            // password
            pw.print(" PASSWORD: ");
            pw.print(user.getPassword());

            // first name
            pw.print(" FIRST: ");
            pw.print(user.getFirstName());

            // last name
            pw.print(" LAST: ");
            pw.print(user.getLastName());

            // email
            pw.print(" EMAIL: ");
            pw.print(user.getEmail());

            // logged in
            pw.print(" LOGGEDIN: ");
            if (user.getLoggedIn() == true) {
                pw.print("TRUE");
            }
            else {
                pw.print("FALSE");
            }

            // manager status
            if (user.getManagerStatus() == true) {
                pw.print(" MANAGER");
            }
            else {
                pw.print(" CUSTOMER");
            }

            pw.println("");

            pw.close();
            bw.close();
            fw.close();

        // catch file not found error
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        // catch IO error (bad input/output)
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // for verifying username and password during login
    public boolean search(String username, String password) {
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

                // check if username and password combo match
                for (int i = 0; i < wordList.length; i++) {
                    if (wordList[i].equals("MANAGER")) { // if manager exists in a user's info
                        Library.user.setManagerStatus(true); // make the user a manager
                    }
                    if (wordList[i].equals("USERNAME:")) { // find username field
                        if (username.equals(wordList[i+1])) { // check username
                            for (int j = 0; j <= wordList.length - 1; j++) { // iterate through wordList
                                if (wordList[j].equals("PASSWORD:")) { // find password field
                                    if (password.equals(wordList[j+1])) { // check password
                                        return true;
                                    }
                                }
                            }
                        }
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

        return false; // if username/password do no match, return false
    }
}
