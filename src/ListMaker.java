import java.util.ArrayList;
import java.util.Scanner;

public class ListMaker {
    private static ArrayList<String> itemList = new ArrayList<>();
    private static Scanner inputScanner = new Scanner(System.in);
    public static void main(String[] args) {
        while (true) {
            displayMenu();

            String choice = SafeInput.getRegExString(inputScanner, "Enter your choice: [AaDdPpQq]", "[AaDdPpQq]");
            switch (choice.toUpperCase()) {
                case "A":
                    addItem();
                    break;
                case "D":
                    deleteItem();
                    break;
                case "P":
                    printList();
                    break;
                case "Q":
                    if (SafeInput.getYNConfirm(inputScanner, "Are you sure you want to quit program? [Y/N]")) {
                        return;
                    }
                    break;
                default:
                    System.out.println("Invalid choice. try again.");
            }
        }
    }

    private static void addItem() {
        System.out.println("Add Items to the List (Type 'Q' to stop adding items)");

        while (true) {
            String item = SafeInput.getNonZeroLenString(inputScanner, "Enter an item (or 'Q' to stop adding):");
            if (item.equalsIgnoreCase("Q")) {
                break;
            }
            itemList.add(item);
        }

        System.out.println("Items on the list.");
    }

    private static void displayMenu() {
        System.out.println("Menu:");
        System.out.println("A - Add  item to the list");
        System.out.println("D - Delete item from  list");
        System.out.println("P - Print the list");
        System.out.println("Q - Quit/Stop");

        if (!itemList.isEmpty()) {
            System.out.println("\nCurrent List of Items:");
            for (int i = 0; i < itemList.size(); i++) {
                System.out.println((i + 1) + ". " + itemList.get(i));
            }
        }
    }

    private static void deleteItem() {
        if (itemList.isEmpty()) {
            System.out.println("list is empty.");
            return;
        }

        printNumberedItems();

        int itemNumber = SafeInput.getRangedInt(inputScanner, "Enter the number of the item you would like to delete", 1, itemList.size());
        String deletedItem = itemList.remove(itemNumber - 1);
        System.out.println("Item deleted: " + deletedItem);
    }

    private static void printList() {
        if (itemList.isEmpty()) {
            System.out.println("list is empty.");
        } else {
            System.out.println("List items:");
            for (String item : itemList) {
                System.out.println(item);
            }
        }
    }

    private static void printNumberedItems() {
        System.out.println("List items (numbered):");
        for (int i = 0; i < itemList.size(); i++) {
            System.out.println((i + 1) + ". " + itemList.get(i));
        }
    }
}
