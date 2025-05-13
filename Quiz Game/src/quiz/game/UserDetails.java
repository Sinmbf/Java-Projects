package quiz.game;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class UserDetails {

    // Method to save user score to a file
    public static void saveScores(String username, int score, String playDate, String playTime) {
        // File path where scores are stored
        String filePath = "scores.txt";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            // Write username and score in the file
            writer.write(username + ", " + score + ", " + playDate + " " + playTime);
            writer.newLine(); // Move to the next line for a new record
            System.out.println("Score saved successfully!");
        } catch (IOException e) {
            System.out.println("An error occurred while saving the score: " + e.getMessage());
        }
    }

    public static void readScores() {
        String filePath = "scores.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            System.out.println("Scores:");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file: " + e.getMessage());
        }
    }
}
