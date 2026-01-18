package com.mycompany.studentfinancetracker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;

/* =======================
   Goal class
   ======================= */
class Goal {

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

/* =======================
   GoalManager class
   ======================= */
class GoalManager {

    private ArrayList<Goal> goals = new ArrayList<>();

    public GoalManager() {
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
        try (PrintWriter pw = new PrintWriter(new FileWriter("goals.txt"))) {
            for (Goal g : goals) {
                pw.println(g.toFileString());
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error saving goals.");
        }
    }

    private void loadGoals() {
        File file = new File("goals.txt");
        if (!file.exists()) return;

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                goals.add(Goal.fromFileString(line));
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error loading goals.");
        }
    }
}

/* =======================
   MAIN GUI CLASS
   ======================= */
public class StudentFinanceTracker extends JFrame {

    private GoalManager manager;
    private DefaultListModel<Goal> listModel;
    private JList<Goal> goalList;
    
    public StudentFinanceTracker() {

        manager = new GoalManager();

        setTitle("Student Finance Tracker");
        setSize(450, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        listModel = new DefaultListModel<>();
        goalList = new JList<>(listModel);

        for (Goal g : manager.getGoals()) {
            listModel.addElement(g);
        }

        add(new JScrollPane(goalList), BorderLayout.CENTER);

        JPanel inputPanel = new JPanel(new GridLayout(4, 2, 5, 5));

        JTextField nameField = new JTextField();
        JTextField amountField = new JTextField();

        JComboBox<String> typeBox = new JComboBox<>();
        typeBox.addItem("Short-Term");
        typeBox.addItem("Long-Term");

        JButton addButton = new JButton("Add Goal");

        inputPanel.add(new JLabel("Goal Name:"));
        inputPanel.add(nameField);
        inputPanel.add(new JLabel("Target Amount ($):"));
        inputPanel.add(amountField);
        inputPanel.add(new JLabel("Goal Type:"));
        inputPanel.add(typeBox);
        inputPanel.add(new JLabel(""));
        inputPanel.add(addButton);

        add(inputPanel, BorderLayout.SOUTH);

        /* ========= ERROR HANDLING ========= */
        addButton.addActionListener(e -> {
            String name = nameField.getText().trim();
            String amountText = amountField.getText().trim();

            if (name.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Goal name cannot be empty.");
                return;
            }

            double amount;
            try {
                amount = Double.parseDouble(amountText);
                if (amount <= 0) throw new NumberFormatException();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Enter a valid positive number.");
                return;
            }

            Goal g = new Goal(name, amount, typeBox.getSelectedItem().toString());
            manager.addGoal(g);
            listModel.addElement(g);

            nameField.setText("");
            amountField.setText("");
        });

        setVisible(true);
    }

    /* ========= MAIN METHOD ========= */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new StudentFinanceTracker());
    }
}
