package advancequizgame.Utilities;

import java.io.*;

public class AdminCredentials {

    private static final String FILE_NAME = "admin_credentials.txt";

    // Save admin credentials
    private static void saveAdminCredentials(String username, String password) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            writer.write("Username: " + username);
            writer.newLine();
            writer.write("Password: " + password);
            System.out.println("Credentials saved successfully");
        } catch (IOException e) {
            System.out.println("Error saving credentials: " + e.getMessage());
        }
    }

    // Read admin credentials
    public static String[] readAdminCredentials() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            String lineArr[]={},credentials[]=new String[2];
            int count=0;
            while ((line = reader.readLine()) != null) {
                lineArr=line.split(": ");
                credentials[count]=lineArr[1];
                count++;
            }
           return credentials;    

        } catch (IOException e) {
            System.out.println("Error reading credentials: " + e.getMessage());
            return null;
        }
    }

    public static void main(String[] args) {
        saveAdminCredentials("Sinmbf", "sinmbflost12345");
    }
}
