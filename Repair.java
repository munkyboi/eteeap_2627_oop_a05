public abstract class Repair {
    private final int id;
    private final String customerName;
    private final String problem;

    public Repair(int id, String customerName, String problem) {
        this.id = id;
        this.customerName = customerName;
        this.problem = problem;
    }

    public int getId() {
        return id;
    }

    protected void displayBasicDetails() {
        System.out.println("ID: " + id);
        System.out.println("Customer: " + customerName);
        System.out.println("Problem: " + problem);
    }
}
