public class ShoeRepair extends Repair implements RepairTask {
    private final String shoeType;

    public ShoeRepair(int id, String customerName, String problem, String shoeType) {
        super(id, customerName, problem);
        this.shoeType = shoeType;
    }

    @Override
    public void displayDetails() {
        System.out.println("\n--- Shoe Repair ---");
        displayBasicDetails();
        System.out.println("Shoe type: " + shoeType);
    }
}
