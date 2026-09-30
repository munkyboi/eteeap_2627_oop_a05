public class UmbrellaRepair extends Repair implements RepairTask {
    private final String umbrellaType;

    public UmbrellaRepair(int id, String customerName, String problem, String umbrellaType) {
        super(id, customerName, problem);
        this.umbrellaType = umbrellaType;
    }

    @Override
    public void displayDetails() {
        System.out.println("\n--- Umbrella Repair ---");
        displayBasicDetails();
        System.out.println("Umbrella type: " + umbrellaType);
    }
}
