/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author schik
 */

import java.util.ArrayList; // import all necessary libraries
import java.text.DecimalFormat;
import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
public class LoanManager extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(LoanManager.class.getName());
    
    private ArrayList<Loan> trackedLoans; // create lists, variables, and objects for throughout the program
    private ArrayList<String> loanNames;
    private ArrayList<String> loanCards;
    private Loan selectedLoan;
    private Card selectedCard;
    private int intSelectedEditIndex = -1;
    
    private static final DecimalFormat format = new DecimalFormat("###.##"); // format for the values
    
    /**
     * Creates new form LoanCalculator
     */
    public LoanManager() {
        initComponents();
        

        try {
            String strLoansPath = UserManager.getUserFilePath("loans.txt"); 
            File file = new File(strLoansPath); 
            if (!file.exists()) {
                file.createNewFile();
            }
        } catch (Exception e) {}

        trackedLoans = new ArrayList<>(); // create the lists
        loanNames = new ArrayList<>();
        loanCards = new ArrayList<>();
        
        loadLoansFromFile(); // call helper functions
        refreshLoansList();
        clearDetailsDisplay();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenedblRated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlBackground = new javax.swing.JPanel();
        lblTitle = new javax.swing.JLabel();
        lblStatus = new javax.swing.JLabel();
        lblLoansHeader = new javax.swing.JLabel();
        btnCardsManager = new javax.swing.JButton();
        btnAddLoan = new javax.swing.JButton();
        scrList = new javax.swing.JScrollPane();
        lstLoans = new javax.swing.JList<>();
        btnMakePayment = new javax.swing.JButton();
        btnViewDetails = new javax.swing.JButton();
        btnDeleteLoan = new javax.swing.JButton();
        lblHeader = new javax.swing.JLabel();
        lblDetailsHeader = new javax.swing.JLabel();
        lblLoanName = new javax.swing.JLabel();
        lblRemainingBalance = new javax.swing.JLabel();
        lblTotalInterest = new javax.swing.JLabel();
        lblCardUsed = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        lblCalculateHeader = new javax.swing.JLabel();
        btnCalculateInterest = new javax.swing.JButton();
        fldMonths = new javax.swing.JTextField();
        lblMonths = new javax.swing.JLabel();
        lblInterestOutput = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnlBackground.setBackground(new java.awt.Color(153, 153, 255));
        pnlBackground.setPreferredSize(new java.awt.Dimension(914, 578));

        lblTitle.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 36)); // NOI18N
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle.setText("Loans Manager");

        lblStatus.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        lblStatus.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        lblLoansHeader.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        lblLoansHeader.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblLoansHeader.setText("Tracked Loans:");

        btnCardsManager.setBackground(new java.awt.Color(153, 153, 255));
        btnCardsManager.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        btnCardsManager.setText("Go to Cards Manager");
        btnCardsManager.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCardsManagerActionPerformed(evt);
            }
        });

        btnAddLoan.setBackground(new java.awt.Color(153, 153, 255));
        btnAddLoan.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        btnAddLoan.setText("Add/Edit a Loan!");
        btnAddLoan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddLoanActionPerformed(evt);
            }
        });

        scrList.setViewportView(lstLoans);

        btnMakePayment.setBackground(new java.awt.Color(153, 153, 255));
        btnMakePayment.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        btnMakePayment.setText("Make Payment");
        btnMakePayment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMakePaymentActionPerformed(evt);
            }
        });

        btnViewDetails.setBackground(new java.awt.Color(153, 153, 255));
        btnViewDetails.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        btnViewDetails.setText("View Loan Details");
        btnViewDetails.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewDetailsActionPerformed(evt);
            }
        });

        btnDeleteLoan.setBackground(new java.awt.Color(153, 153, 255));
        btnDeleteLoan.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        btnDeleteLoan.setText("Delete Loan");
        btnDeleteLoan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteLoanActionPerformed(evt);
            }
        });

        lblHeader.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        lblHeader.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHeader.setText("Manage student loans, car payments, and other debts");

        lblDetailsHeader.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        lblDetailsHeader.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDetailsHeader.setText("Loan Details:");

        lblLoanName.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        lblLoanName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        lblRemainingBalance.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        lblRemainingBalance.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        lblTotalInterest.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        lblTotalInterest.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        lblCardUsed.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        lblCardUsed.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));

        lblCalculateHeader.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        lblCalculateHeader.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCalculateHeader.setText("Calculate Loan Interest");

        btnCalculateInterest.setBackground(new java.awt.Color(153, 153, 255));
        btnCalculateInterest.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        btnCalculateInterest.setText("Calculate");
        btnCalculateInterest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalculateInterestActionPerformed(evt);
            }
        });

        lblMonths.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        lblMonths.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMonths.setText("Months:");

        lblInterestOutput.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        lblInterestOutput.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout pnlBackgroundLayout = new javax.swing.GroupLayout(pnlBackground);
        pnlBackground.setLayout(pnlBackgroundLayout);
        pnlBackgroundLayout.setHorizontalGroup(
            pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBackgroundLayout.createSequentialGroup()
                .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlBackgroundLayout.createSequentialGroup()
                        .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 872, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCardsManager, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlBackgroundLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblCalculateHeader, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(pnlBackgroundLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblHeader, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBackgroundLayout.createSequentialGroup()
                        .addComponent(lblLoanName, javax.swing.GroupLayout.PREFERRED_SIZE, 445, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblCardUsed, javax.swing.GroupLayout.PREFERRED_SIZE, 445, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBackgroundLayout.createSequentialGroup()
                        .addComponent(lblRemainingBalance, javax.swing.GroupLayout.PREFERRED_SIZE, 445, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblTotalInterest, javax.swing.GroupLayout.PREFERRED_SIZE, 445, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlBackgroundLayout.createSequentialGroup()
                        .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblDetailsHeader, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 862, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(pnlBackgroundLayout.createSequentialGroup()
                                    .addGap(136, 136, 136)
                                    .addComponent(lblMonths)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(fldMonths, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(114, 114, 114)
                                    .addComponent(lblInterestOutput, javax.swing.GroupLayout.PREFERRED_SIZE, 538, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pnlBackgroundLayout.createSequentialGroup()
                                        .addGap(115, 115, 115)
                                        .addComponent(btnViewDetails, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(68, 68, 68)
                                        .addComponent(btnMakePayment, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(62, 62, 62)
                                        .addComponent(btnDeleteLoan, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(pnlBackgroundLayout.createSequentialGroup()
                                        .addComponent(lblLoansHeader, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(44, 44, 44)
                                        .addComponent(scrList, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(44, 44, 44)
                                        .addComponent(btnAddLoan, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(pnlBackgroundLayout.createSequentialGroup()
                                        .addGap(168, 168, 168)
                                        .addComponent(lblStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 862, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(pnlBackgroundLayout.createSequentialGroup()
                .addGap(356, 356, 356)
                .addComponent(btnCalculateInterest, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlBackgroundLayout.setVerticalGroup(
            pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBackgroundLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTitle)
                    .addComponent(btnCardsManager))
                .addGap(12, 12, 12)
                .addComponent(lblHeader)
                .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlBackgroundLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblLoansHeader)
                            .addComponent(scrList, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnlBackgroundLayout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(btnAddLoan)))
                .addGap(18, 18, 18)
                .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnMakePayment)
                        .addComponent(btnViewDetails))
                    .addComponent(btnDeleteLoan))
                .addGap(81, 81, 81)
                .addComponent(lblDetailsHeader)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlBackgroundLayout.createSequentialGroup()
                        .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblLoanName, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCardUsed, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblTotalInterest, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblRemainingBalance, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblCalculateHeader)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(fldMonths, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblMonths)))
                    .addGroup(pnlBackgroundLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(lblInterestOutput, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCalculateInterest)
                .addGap(1, 1, 1)
                .addComponent(lblStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(71, 71, 71))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlBackground, javax.swing.GroupLayout.DEFAULT_SIZE, 1059, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlBackground, javax.swing.GroupLayout.PREFERRED_SIZE, 748, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    // load saved loans from file
    public void loadLoansFromFile() {
        trackedLoans.clear(); // clear all the lists
        loanNames.clear();
        loanCards.clear();

        try {
            String strLoansPath = UserManager.getUserFilePath("loans.txt"); 
            BufferedReader br = new BufferedReader(new FileReader(strLoansPath)); 
            String strLine; 

            while ((strLine = br.readLine()) != null) { // read all the data
                String strName = strLine; // store in variables
                double dblPrincipal = Double.parseDouble(br.readLine());
                double dblRate = Double.parseDouble(br.readLine());
                int intMonths = Integer.parseInt(br.readLine());
                String strCardNum = br.readLine();

                // check if the card still exists
                Card card = findCardByNumber(strCardNum);

                // only add loan if card still exists
                if (card != null) {
                    Loan loan = new Loan(dblPrincipal, dblRate, intMonths);
                    trackedLoans.add(loan);
                    loanNames.add(strName);
                    loanCards.add(strCardNum);
                }
            }

            br.close();

            // save the loans that still have details to the file (deletes loans that dont have a card anymore)
            bubbleSortLoansByBalance(); // sort loans by balance after loading
            saveLoansToFile();

        } catch (Exception e) {}
    }
    // refresh the loans list display
    public void refreshLoansList() {
        String[] loanArray;
        if (trackedLoans.isEmpty()) { // if the loan is empty add that it is empty into the array
            loanArray = new String[]{"No loans tracked yet. Click 'Add/Edit Loans' to get started!"};
        } else { // if it isnt
            loanArray = new String[trackedLoans.size()]; // make the array the size of how many loans we have in the list
            for (int i = 0; i < trackedLoans.size(); i++) { // get all the relevant information into the loan array as a string
                Loan loan = trackedLoans.get(i);
                loanArray[i] = loanNames.get(i) + " - Balance: $" + format.format(loan.getRemainingBalance()) +  " | Payment: $" + format.format(loan.getMonthlyPayment()) + "/month (" + loan.getTermMonths() + " months left)";            
            }
        }
        
        lstLoans.setListData(loanArray); // and set the array into the lst loans so users can select
    }
    
    // clear details display
    private void clearDetailsDisplay() {
        lblRemainingBalance.setText("Remaining Balance:");
        lblLoanName.setText("Select a loan to view details");
        lblTotalInterest.setText("Total Interest Left:");
        lblCardUsed.setText("Paying from:");
    }
    // method to find card by number
    private Card findCardByNumber(String strCardNumber) {
     // linear search through credit cards list
        for (int i = 0; i < CardsManager.listCreditCards.size(); i++) {
            if (CardsManager.listCreditCards.get(i).getNumber().equals(strCardNumber)) {
                return CardsManager.listCreditCards.get(i); // return card found
            }
        }

        // linear search through debit cards list
        for (int i = 0; i < CardsManager.listDebitCards.size(); i++) {
            if (CardsManager.listDebitCards.get(i).getNumber().equals(strCardNumber)) {
                return CardsManager.listDebitCards.get(i); // return card found
            }
        }

        return null; // card not found after searching all lists
    }
    // method to save loans
    private void saveLoansToFile() {
        try {
            String strLoansPath = UserManager.getUserFilePath("loans.txt"); // write to loans.txt of each user
            FileWriter fw = new FileWriter(strLoansPath); 
            
            for (int i = 0; i < trackedLoans.size(); i++) { // for all the loans 
                Loan loan = trackedLoans.get(i); // get all the information and write it
                fw.write(loanNames.get(i) + "\n");
                fw.write(loan.getPrincipal() + "\n");
                fw.write(loan.getInterestRate() + "\n");
                fw.write(loan.getTermMonths() + "\n");
                fw.write(loanCards.get(i) + "\n");
            }
            
            fw.close();
        } catch (Exception e) {
            lblStatus.setText(" Could not save loans!");
        }
    }
    
    private void bubbleSortLoansByBalance() {
        int n = trackedLoans.size();

        // outer loop controls number of passes through the array
        for (int i = 0; i < n - 1; i++) {
            // inner loop performs comparisons and swaps
            // after each pass the largest element goes to correct position
            for (int j = 0; j < n - i - 1; j++) {
                // compare adjacent loans by their remaining balance
                if (trackedLoans.get(j).getRemainingBalance() > trackedLoans.get(j + 1).getRemainingBalance()) {
                    // swap loans in all three parallel arrays to keep them synchronized

                    // swap in trackedLoans
                    Loan tempLoan = trackedLoans.get(j);
                    trackedLoans.set(j, trackedLoans.get(j + 1));
                    trackedLoans.set(j + 1, tempLoan);

                    // swap in loanNames
                    String tempName = loanNames.get(j);
                    loanNames.set(j, loanNames.get(j + 1));
                    loanNames.set(j + 1, tempName);

                    // swap in loanCards
                    String tempCard = loanCards.get(j);
                    loanCards.set(j, loanCards.get(j + 1));
                    loanCards.set(j + 1, tempCard);
                }
            }
        }
    }
    
    private void btnCardsManagerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCardsManagerActionPerformed
        this.dispose(); // switch screens
        CardsManager screen = new CardsManager();
        screen.setVisible(true);
    }//GEN-LAST:event_btnCardsManagerActionPerformed

    private void btnAddLoanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddLoanActionPerformed
        this.dispose(); // switch screens
        AddEditLoan screen = new AddEditLoan();
        screen.setVisible(true);
    }//GEN-LAST:event_btnAddLoanActionPerformed

    private void btnMakePaymentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMakePaymentActionPerformed
        if (selectedLoan == null || selectedCard == null) { // if nothing is selected
            lblStatus.setText("Please view a loan first!");
            return;
        }
        
        // check if payment is affordable
        if (!Loan.canAffordPayment(selectedCard, selectedLoan.getMonthlyPayment())) {
            lblStatus.setText(" Insufficient balance to make payment!");
            return;
        }
        
        // apply payment to card
        boolean blnSuccess = selectedLoan.applyMonthlyPayment(selectedCard);
        
        if (blnSuccess) {
            // update the card in the main list
            CardsManager.writeToFile(selectedCard instanceof CreditCard);
            
            // update remaining balance display
            lblRemainingBalance.setText("Remaining Balance: $" + 
                format.format(selectedLoan.getRemainingBalance()));
            
            // save updated loan
            saveLoansToFile();
            
            // refresh display
            refreshLoansList();
            
            lblStatus.setText("Payment of $" + format.format(selectedLoan.getMonthlyPayment()) + " applied!");
        } else {
            lblStatus.setText(" Payment failed!");
        }
    }//GEN-LAST:event_btnMakePaymentActionPerformed

    private void btnViewDetailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewDetailsActionPerformed
        intSelectedEditIndex = lstLoans.getSelectedIndex();
        
        if (intSelectedEditIndex < 0 || intSelectedEditIndex >= trackedLoans.size()) { // if nothing is selected
            lblStatus.setText(" Please select a loan from the list!");
            return;
        }
        
        selectedLoan = trackedLoans.get(intSelectedEditIndex); // get the loan that is selected
        String strCardNumber = loanCards.get(intSelectedEditIndex); // get the card that is assosciated with that loan
        
        // find the card
        selectedCard = findCardByNumber(strCardNumber);
        
        // display loan details
        lblLoanName.setText("Loan: " + loanNames.get(intSelectedEditIndex));
        lblRemainingBalance.setText("Remaining Balance: $" + format.format(selectedLoan.getRemainingBalance()));
        lblTotalInterest.setText("Total Interest Left: $" + format.format(selectedLoan.getTotalInterest()));
        
        if (selectedCard != null) {
            lblCardUsed.setText("Paying from: " + selectedCard.getName());
        }
        
        lblStatus.setText("Viewing loan details");
    }//GEN-LAST:event_btnViewDetailsActionPerformed

    private void btnDeleteLoanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteLoanActionPerformed
        intSelectedEditIndex = lstLoans.getSelectedIndex();
        
        if (intSelectedEditIndex < 0 || intSelectedEditIndex >= trackedLoans.size()) { // if nothing is selected
            lblStatus.setText(" Please select a loan to delete!");
            return;
        }
        
        trackedLoans.remove(intSelectedEditIndex); // remove everything related to that loan
        loanNames.remove(intSelectedEditIndex);
        loanCards.remove(intSelectedEditIndex);
            
        saveLoansToFile(); // resave the loans
        refreshLoansList(); // refresh the display
        clearDetailsDisplay();
            
        selectedLoan = null; // reset the user selection
        selectedCard = null;
            
        lblStatus.setText("Loan deleted successfully!"); 
    }//GEN-LAST:event_btnDeleteLoanActionPerformed

    private void btnCalculateInterestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalculateInterestActionPerformed
        try {
            int intMonthsLeft = Integer.parseInt(fldMonths.getText().trim());
            intSelectedEditIndex = lstLoans.getSelectedIndex();

            if (intSelectedEditIndex < 0 || intSelectedEditIndex >= trackedLoans.size()) { // if nothing is selected
                lblStatus.setText("Please select a loan from the list!");
                return;
            }

            selectedLoan = trackedLoans.get(intSelectedEditIndex); // get the loan that is selected
           
            double dblInterest = selectedLoan.calculateAccumulatedInterest(intMonthsLeft);  // use the recursive method to calculate accumulated interest

            // format and display the result
            lblInterestOutput.setText("Accumulated interest for " + intMonthsLeft + " months: $" + format.format(dblInterest));
        }
        catch (NumberFormatException e) {
            lblInterestOutput.setText("Please enter a valid number of months!");
        }
    }//GEN-LAST:event_btnCalculateInterestActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new LoanManager().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddLoan;
    private javax.swing.JButton btnCalculateInterest;
    private javax.swing.JButton btnCardsManager;
    private javax.swing.JButton btnDeleteLoan;
    private javax.swing.JButton btnMakePayment;
    private javax.swing.JButton btnViewDetails;
    private javax.swing.JTextField fldMonths;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblCalculateHeader;
    private javax.swing.JLabel lblCardUsed;
    private javax.swing.JLabel lblDetailsHeader;
    private javax.swing.JLabel lblHeader;
    private javax.swing.JLabel lblInterestOutput;
    private javax.swing.JLabel lblLoanName;
    private javax.swing.JLabel lblLoansHeader;
    private javax.swing.JLabel lblMonths;
    private javax.swing.JLabel lblRemainingBalance;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblTotalInterest;
    private javax.swing.JList<String> lstLoans;
    private javax.swing.JPanel pnlBackground;
    private javax.swing.JScrollPane scrList;
    // End of variables declaration//GEN-END:variables
}
