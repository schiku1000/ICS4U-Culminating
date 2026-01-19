import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;  

public class GoalManager extends JFrame {

    // ---------------- DATA ----------------
    private ArrayList<GoalItem> goals = new ArrayList<>();

    // ---------------- GUI COMPONENTS ----------------
    private JList<String> lstGoals;
    private DefaultListModel<String> listModel;

    private JLabel lblGoalDetails;
    private JLabel lblStatus;

    private JButton btnViewDetails;
    private JButton btnDeleteGoal;
    private JButton btnAddGoal;

    // ---------------- GOAL CLASS ----------------
    private static class GoalItem {
        String description;
        double targetAmount;
        String goalType; // Short Term / Long Term

        GoalItem(String description, double targetAmount, String goalType) {
            this.description = description;
            this.targetAmount = targetAmount;
            this.goalType = goalType;
        }

        String toFileString() {
            return description + "|" + targetAmount + "|" + goalType;
        }

        static GoalItem fromFileString(String line) {
            String[] parts = line.split("\\|");
            return new GoalItem(
                    parts[0],
                    Double.parseDouble(parts[1]),
                    parts[2]
            );
        }
    }

    // ---------------- CONSTRUCTOR ----------------
    public GoalManager() {
        initComponents();
        loadGoals();
        refreshGoalList();
    }

    // ---------------- GUI SETUP ----------------
    private void initComponents() {

        setTitle("Goals Manager");
        setSize(650, 620);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        Color bgPurple = new Color(155, 155, 255);
        Color darkBox = new Color(40, 40, 40);
        getContentPane().setBackground(bgPurple);

        // ---------- TITLE ----------
        JLabel lblTitle = new JLabel("Goals Manager");
        lblTitle.setFont(new Font("Arial", Font.BOLD, 28));
        lblTitle.setForeground(Color.WHITE);
        lblTitle.setBounds(210, 20, 300, 40);
        add(lblTitle);

        JLabel lblSubtitle = new JLabel("Manage your personal goals!");
        lblSubtitle.setForeground(Color.WHITE);
        lblSubtitle.setBounds(225, 60, 300, 20);
        add(lblSubtitle);

        // ---------- TRACKED GOALS ----------
        JLabel lblTracked = new JLabel("Tracked Goals:");
        lblTracked.setForeground(Color.WHITE);
        lblTracked.setBounds(50, 120, 150, 20);
        add(lblTracked);

        listModel = new DefaultListModel<>();
        lstGoals = new JList<>(listModel);
        lstGoals.setBackground(darkBox);
        lstGoals.setForeground(Color.WHITE);

        JScrollPane scroll = new JScrollPane(lstGoals);
        scroll.setBounds(220, 120, 200, 120);
        add(scroll);

        // ---------- RIGHT LABEL ----------
        JLabel lblAddEdit = new JLabel("Add/Edit a Goal!");
        lblAddEdit.setForeground(Color.WHITE);
        lblAddEdit.setBounds(460, 120, 150, 20);
        add(lblAddEdit);

        // ---------- BUTTONS ----------
        btnViewDetails = new JButton("View Goal Details");
        btnViewDetails.setBounds(80, 260, 150, 30);
        add(btnViewDetails);

        btnAddGoal = new JButton("Add Goal");
        btnAddGoal.setBounds(250, 260, 150, 30);
        add(btnAddGoal);

        btnDeleteGoal = new JButton("Delete Goal");
        btnDeleteGoal.setBounds(420, 260, 150, 30);
        add(btnDeleteGoal);

        // ---------- GOAL DETAILS ----------
        JLabel lblDetailsTitle = new JLabel("Goal Details:");
        lblDetailsTitle.setForeground(Color.WHITE);
        lblDetailsTitle.setBounds(50, 320, 150, 20);
        add(lblDetailsTitle);

        lblGoalDetails = new JLabel("Select a goal to view details.");
        lblGoalDetails.setForeground(Color.WHITE);
        lblGoalDetails.setBounds(70, 350, 520, 60);
        add(lblGoalDetails);

        // ---------- STATUS ----------
        lblStatus = new JLabel("Ready");
        lblStatus.setForeground(Color.WHITE);
        lblStatus.setBounds(50, 520, 400, 20);
        add(lblStatus);

        // ---------- ACTIONS ----------
        btnAddGoal.addActionListener(e -> addGoal());
        btnViewDetails.addActionListener(e -> viewGoalDetails());
        btnDeleteGoal.addActionListener(e -> deleteGoal());
    }

    // ---------------- LOGIC ----------------
    private void refreshGoalList() {
        listModel.clear();
        for (GoalItem g : goals) {
            listModel.addElement(g.description);
        }
    }

    private void addGoal() {

        JTextField fldDescription = new JTextField();
        JTextField fldAmount = new JTextField();
        JComboBox<String> cboType = new JComboBox<>(
                new String[]{"Short Term", "Long Term"}
        );

        Object[] message = {
                "Goal Description:", fldDescription,
                "Target Amount ($):", fldAmount,
                "Goal Type:", cboType
        };

        int option = JOptionPane.showConfirmDialog(
                this, message, "Add Goal", JOptionPane.OK_CANCEL_OPTION
        );

        if (option != JOptionPane.OK_OPTION) {
            lblStatus.setText("Goal not added.");
            return;
        }

        try {
            String desc = fldDescription.getText().trim();
            double amount = Double.parseDouble(fldAmount.getText());
            String type = cboType.getSelectedItem().toString();

            if (desc.isEmpty()) {
                lblStatus.setText("Goal description required.");
                return;
            }

            goals.add(new GoalItem(desc, amount, type));
            saveGoals();
            refreshGoalList();

            lblStatus.setText("Goal added successfully.");

        } catch (NumberFormatException e) {
            lblStatus.setText("Invalid target amount.");
        }
    }

    private void viewGoalDetails() {
        int index = lstGoals.getSelectedIndex();

        if (index == -1) {
            lblStatus.setText("Please select a goal.");
            return;
        }

        GoalItem g = goals.get(index);

        lblGoalDetails.setText(
                "<html>• " + g.description +
                "<br>Target Amount: $" + g.targetAmount +
                "<br>Goal Type: " + g.goalType + "</html>"
        );

        lblStatus.setText("Goal details displayed.");
    }

    private void deleteGoal() {
        int index = lstGoals.getSelectedIndex();

        if (index == -1) {
            lblStatus.setText("Select a goal first.");
            return;
        }

        goals.remove(index);
        saveGoals();
        refreshGoalList();

        lblGoalDetails.setText("Goal deleted.");
        lblStatus.setText("Goal removed.");
    }

    // ---------------- FILE HANDLING ----------------
    private void saveGoals() {
        try (PrintWriter pw = new PrintWriter(new FileWriter("goals.txt"))) {
            for (GoalItem g : goals) {
                pw.println(g.toFileString());
            }
        } catch (IOException e) {
            lblStatus.setText("Error saving goals.");
        }
    }

    private void loadGoals() {
        File file = new File("goals.txt");
        if (!file.exists()) return;

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                goals.add(GoalItem.fromFileString(line));
            }
        } catch (IOException e) {
            lblStatus.setText("Error loading goals.");
        }
    }

    // ---------------- MAIN ----------------
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new GoalManager().setVisible(true));
    }
}
