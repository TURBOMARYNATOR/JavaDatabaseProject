import java.util.Scanner;

class Choice {
    Scanner scanner = new Scanner(System.in);
    void choiceMenu() {
        System.out.println("What would you like to do?");
        System.out.println("1. INSERT");
        System.out.println("2. DELETE");
        System.out.println("3. UPDATE");
    }
    String getChoice() {
        return scanner.nextLine();
    }
}
