/* =======================
   Goal class
   ======================= */
public class Goal {

    private String name;
    private double targetAmount;
    private double savedAmount;
    private String type;

    public Goal(String name, double targetAmount, String type) {
        this.name = name;
        this.targetAmount = targetAmount;
        this.type = type;
        this.savedAmount = 0;
    }

    public void addMoney(double amount) {
        savedAmount += amount;
    }

    public boolean isComplete() {
        return savedAmount >= targetAmount;
    }

    public String toFileString() {
        return name + "," + targetAmount + "," + savedAmount + "," + type;
    }

    public static Goal fromFileString(String line) {
        String[] parts = line.split(",");
        Goal g = new Goal(parts[0], Double.parseDouble(parts[1]), parts[3]);
        g.savedAmount = Double.parseDouble(parts[2]);
        return g;
    }

    @Override
    public String toString() {
        return name + " (" + type + ")  $" + savedAmount + "/" + targetAmount +
                (isComplete() ? " [Complete]" : "");
    }
}