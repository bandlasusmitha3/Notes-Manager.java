import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class NotesManager {
    private static final String FILE_NAME = "notes.txt";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        NotesManager manager = new NotesManager();

        while (true) {
            System.out.println("Notes Manager");
            System.out.println("1. Add Note");
            System.out.println("2. Read Notes");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            String option = scanner.nextLine();

            switch (option) {
                case "1":
                    System.out.print("Enter your note: ");
                    String note = scanner.nextLine();
                    manager.addNote(note);
                    break;
                case "2":
                    System.out.println("Notes in file:");
                    manager.readNotes();
                    break;
                case "3":
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    public void addNote(String note) {
        try (FileWriter writer = new FileWriter(FILE_NAME, true)) {
            writer.write(note + System.lineSeparator());
            System.out.println("Note added successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred while writing the note: " + e.getMessage());
        }
    }

    public void readNotes() {
        try (FileReader reader = new FileReader(FILE_NAME);
             Scanner fileScanner = new Scanner(reader)) {
            while (fileScanner.hasNextLine()) {
                System.out.println(fileScanner.nextLine());
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading the notes: " + e.getMessage());
        }
    }
}
