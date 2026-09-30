import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final ArrayList<RepairTask> repairs = new ArrayList<>();
    private static int nextId = 1;

    public static void main(String[] args) {
        boolean running = true;

        while (running) {
            System.out.println("\n=== Yospatos ===");
            System.out.println("1. Add");
            System.out.println("2. View");
            System.out.println("3. Search");
            System.out.println("4. Delete");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            switch (scanner.nextLine().trim()) {
                case "1":
                    addRepair();
                    break;
                case "2":
                    viewRepairs();
                    break;
                case "3":
                    searchRepair();
                    break;
                case "4":
                    deleteRepair();
                    break;
                case "5":
                    running = false;
                    System.out.println("Thank you for using Yospatos!");
                    break;
                default:
                    System.out.println("Please choose an option from 1 to 5.");
            }
        }
        scanner.close();
    }

    private static void addRepair() {
        System.out.println("1. Shoe repair");
        System.out.println("2. Umbrella repair");
        System.out.print("Choose a repair type: ");
        String choice = scanner.nextLine().trim();

        if (!choice.equals("1") && !choice.equals("2")) {
            System.out.println("Invalid repair type.");
            return;
        }

        String customer = readRequired("Customer name: ");
        String problem = readRequired("Problem: ");
        RepairTask repair;

        if (choice.equals("1")) {
            String type = readRequired("Shoe type: ");
            repair = new ShoeRepair(nextId, customer, problem, type);
        } else {
            String type = readRequired("Umbrella type: ");
            repair = new UmbrellaRepair(nextId, customer, problem, type);
        }

        repairs.add(repair);
        System.out.println("Repair added. ID: " + nextId);
        nextId++;
    }

    private static void viewRepairs() {
        if (repairs.isEmpty()) {
            System.out.println("No repairs recorded.");
            return;
        }
        for (RepairTask repair : repairs) {
            repair.displayDetails();
        }
    }

    private static RepairTask findRepair() {
        System.out.print("Enter repair ID: ");
        String id = scanner.nextLine().trim();
        for (RepairTask repair : repairs) {
            if (Integer.toString(repair.getId()).equals(id)) {
                return repair;
            }
        }
        return null;
    }

    private static void searchRepair() {
        RepairTask repair = findRepair();
        if (repair == null) {
            System.out.println("Repair not found.");
        } else {
            repair.displayDetails();
        }
    }

    private static void deleteRepair() {
        RepairTask repair = findRepair();
        if (repair == null) {
            System.out.println("Repair not found.");
        } else {
            repairs.remove(repair);
            System.out.println("Repair deleted.");
        }
    }

    private static String readRequired(String prompt) {
        String value = "";
        while (value.isEmpty()) {
            System.out.print(prompt);
            value = scanner.nextLine().trim();
            if (value.isEmpty()) {
                System.out.println("Please enter a value.");
            }
        }
        return value;
    }
}
