import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;

/*
 * This class represents a financial goal.
 * It is used for both short-term and long-term goals.
 */
class Goal {

    private String name;
    private double targetAmount;
    private double savedAmount;
    private String type; // Short-Term or Long-Term

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

    public String toString() {
        return name + " (" + type + ")  $" + savedAmount + "/" + targetAmount +
                (isComplete() ? "  [Complete]" : "");
    }
}

/*
 * This class manages all goals and handles file reading and writing.
 */
class GoalManager {

    private ArrayList<Goal> goals;

    public GoalManager() {
        goals = new ArrayList<>();
        loadGoals();
    }

    public void addGoal(Goal g) {
        goals.add(g);
        saveGoals();
    }

    public ArrayList<Goal> getGoals() {
        return goals;
    }

    private void saveGoals() {
        try {
            PrintWriter pw = new PrintWriter(new FileWriter("goals.txt"));
            for (Goal g : goals) {
                pw.println(g.toFileString());
            }
            pw.close();
        } catch (IOException e) {
            System.out.println("Error saving goals");
        }
    }

    private void loadGoals() {
        File file = new File("goals.txt");
        if (!file.exists()) {
            return;
        }

        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            while ((line = br.readLine()) != null) {
                goals.add(Goal.fromFileString(line));
            }
            br.close();
        } catch (IOException e) {
            System.out.println("Error loading goals");
        }
    }
}

/*
 * Main application with GUI
 */
public class SimpliFiGoals extends JFrame {

    private GoalManager manager;
    private DefaultListModel<Goal> listModel;
    private JList<Goal> goalList;

    public SimpliFiGoals() {

        manager = new GoalManager();

        setTitle("SimpliFi - Goals & Budgeting");
        setSize(450, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        listModel = new DefaultListModel<>();
        goalList = new JList<>(listModel);

        for (Goal g : manager.getGoals()) {
            listModel.addElement(g);
        }

        mainPanel.add(new JScrollPane(goalList), BorderLayout.CENTER);

        // Input panel
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(4, 2));

        JTextField nameField = new JTextField();
        JTextField amountField = new JTextField();

        JComboBox<String> typeBox = new JComboBox<>();
        typeBox.addItem("Short-Term");
        typeBox.addItem("Long-Term");

        JButton addButton = new JButton("Add Goal");

        inputPanel.add(new JLabel("Goal Name:"));
        inputPanel.add(nameField);
        inputPanel.add(new JLabel("Target Amount:"));
        inputPanel.add(amountField);
        inputPanel.add(new JLabel("Goal Type:"));
        inputPanel.add(typeBox);
        inputPanel.add(new JLabel(""));
        inputPanel.add(addButton);

        mainPanel.add(inputPanel, BorderLayout.SOUTH);

        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                double amount = Double.parseDouble(amountField.getText());
                String type = typeBox.getSelectedItem().toString();

                Goal g = new Goal(name, amount, type);
                manager.addGoal(g);
                listModel.addElement(g);

                nameField.setText("");
                amountField.setText("");
            }
        });

        add(mainPanel);
        setVisible(true);
    }

    public static void main(String[] args) {
        new SimpliFiGoals();
    }
}
