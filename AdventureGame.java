import java.util.Scanner;

public class AdventureGame {

    static Scanner scanner = new Scanner(System.in);
    static String currentRoom = "start";

    public static void main(String[] args) {
        System.out.println("Welcome to the Text Adventure Game!");
        playGame();
    }

    static void playGame() {
        while (true) {
            displayRoom();
            String userChoice = getUserInput();
            handleUserInput(userChoice);
        }
    }

    static void displayRoom() {
        switch (currentRoom) {
            case "start":
                System.out.println("You are in a dark room. There are two doors, one on the left and one on the right.");
                break;
            case "left":
                System.out.println("You entered the room on the left. There is a key on the table.");
                break;
            case "right":
                System.out.println("You entered the room on the right. It's full of treasure!");
                break;
            default:
                System.out.println("Invalid room.");
                break;
        }
    }

    static String getUserInput() {
        System.out.print("Enter your choice: ");
        return scanner.nextLine().toLowerCase();
    }

    static void handleUserInput(String userChoice) {
        switch (currentRoom) {
            case "start":
                if (userChoice.equals("left")) {
                    System.out.println("You chose to go left.");
                    currentRoom = "left";
                } else if (userChoice.equals("right")) {
                    System.out.println("You chose to go right.");
                    currentRoom = "right";
                } else {
                    System.out.println("Invalid choice. Try again.");
                }
                break;
            case "left":
                if (userChoice.equals("take key")) {
                    System.out.println("You took the key. Now, go back to the starting room and choose a door.");
                } else if (userChoice.equals("back")) {
                    System.out.println("You went back to the starting room.");
                    currentRoom = "start";
                } else {
                    System.out.println("Invalid choice. Try again.");
                }
                break;
            case "right":
                if (userChoice.equals("back")) {
                    System.out.println("You went back to the starting room.");
                    currentRoom = "start";
                } else {
                    System.out.println("Invalid choice. Try again.");
                }
                break;
            default:
                System.out.println("Invalid room.");
                break;
        }
    }
}
