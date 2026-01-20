/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author schik
 */
import java.io.*;

public class UserManager {
    private static final String strUsersDir = "Users"; // main directory for all users
    private static final String strUsersFile = "Users/users.txt"; // file storing all user credentials
    private static String strCurrentUsername = ""; // track currently logged in user
    
    // method to create necessary directories and files if they don't exist
    public static void initializeDirectories() {
        File UsersDir = new File(strUsersDir); // create File object for Users directory
        if (!UsersDir.exists()) { // check if directory exists
            UsersDir.mkdir(); // create directory if it doesn't exist
        }
        
        File UsersFile = new File(strUsersFile); // create File object for users.txt
        if (!UsersFile.exists()) { // check if file exists
            try {
                UsersFile.createNewFile(); // create file if it doesn't exist
            } catch (IOException e) {
                e.printStackTrace(); // print error if file creation fails
            }
        }
    }
    
    // method to register a new user
    public static boolean registerUser(String strUsername, String strPassword) {
        try {
            // check if username already exists
            if (userExists(strUsername)) {
                return false; // if username is taken
            }
            
            // write user credentials to users.txt file
            FileWriter fwUsers = new FileWriter(strUsersFile, true); 
            fwUsers.write(strUsername + "," + strPassword + "\n"); // username,password
            fwUsers.close(); // close file writer
            
            // create user's directory
            String strUserDirPath = strUsersDir + "/" + strUsername; // build directory path
            File UserDir = new File(strUserDirPath); // create File object for user directory
            UserDir.mkdir(); // create the directory
            
            // create empty data files for the user
            createUserFiles(strUsername);
            
            return true; // registration successful
            
        } catch (IOException e) {
            e.printStackTrace(); // print error if file operations fail
            return false; // registration failed
        }
    }
    
    // method to validate user login credentials
    public static boolean validateLogin(String strUsername, String strPassword) {
        try {
            File file = new File(strUsersFile); // Open users.txt file
            if (!file.exists()) { // check if file exists
                return false; // No users registered 
            }
            
            // read file line by line
            BufferedReader br = new BufferedReader(new FileReader(file));
            String strLine;
            
            while ((strLine = br.readLine()) != null) { // read each line
                String[] arrParts = strLine.split(","); // Split line by comma
                // check if username and password match
                if (arrParts[0].equals(strUsername) && arrParts[1].equals(strPassword)) {
                    br.close(); // close reader
                    strCurrentUsername = strUsername; // Set current user
                    return true; // Login successful
                }
            }
            br.close(); // close reader
            
        } catch (IOException e) {
            e.printStackTrace(); // print error if file reading fails
        }
        return false; 
    }
    
    // helper method to check if a username already exists
    private static boolean userExists(String strUsername) {
        try { 
            File file = new File(strUsersFile); // open users.txt file
            if (!file.exists()) { // if file doesn't exist
                return false; // No users exist yet
            }
            
            // Read file to check for existing username
            BufferedReader br = new BufferedReader(new FileReader(file));
            String strLine;
            
            while ((strLine = br.readLine()) != null) { // read each line
                String[] arrParts = strLine.split(","); // split by comma
                if (arrParts[0].equals(strUsername)) { // check if username matches
                    br.close(); // close reader
                    return true; // username exists
                }
            }
            br.close(); // Close reader
            
        } catch (IOException e) {
            e.printStackTrace(); // print error if file reading fails
        }
        return false; // usrname doesn't exist
    }
    
    // helper method to create empty data files for a new user
    private static void createUserFiles(String strUsername) {
        String strUserDir = strUsersDir + "/" + strUsername + "/"; // build user directory path
        
        try {
            // create and immediately close three empty files for user data
            new FileWriter(strUserDir + "loans.txt").close(); // Loans file
            new FileWriter(strUserDir + "goals.txt").close(); // Goals file
            
        } catch (IOException e) {
            e.printStackTrace(); // print error if file creation fails
        }
    }
    
    // Getters & setters
    public static String getCurrentUser() {
        return strCurrentUsername; 
    }
    public static void setCurrentUser(String strUsername) {
        strCurrentUsername = strUsername; 
    }
    
    public static String getUserFilePath(String strFilename) {
        return strUsersDir + "/" + strCurrentUsername + "/" + strFilename;
    }
    
    public static String getUserDirectory() {
        return strUsersDir + "/" + strCurrentUsername + "/";
    }
}