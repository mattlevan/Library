/* Database.java
 *
 * Abstract superclass for user and item databases in the library
 * management system.
 *
 * @author Matthew Scott Levan
 * @version 03/20/2015
 * @semester Spring 2015
 */

import java.util.*;
import java.io.*;

public abstract class Database {
    // for UserDatabase; writes user information to text file
    public void write(User user) {}

    // for ItemDatabase; writes item information to text file
    public boolean write(Item item) { return false; }

    // for UserDatabase; checks for duplicate users in text file
    public boolean search(String username, String password) { return false; }

    // for ItemDatabase; checks for duplicate items in text file
    public boolean search(Item item) { return false; }

    public void browse() {}
}
