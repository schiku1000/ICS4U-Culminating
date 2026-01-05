/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author schik
 */

import java.util.ArrayList;

public class LoanManager extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(LoanManager.class.getName());
    
    private ArrayList<Loan> trackedLoans;
    private ArrayList<String> loanNames;
    private ArrayList<String> loanCards;
    private Loan selectedLoan;
    private Card selectedCard;
    private int intSelectedEditIndex = -1;
    
    /**
     * Creates new form LoanCalculator
     */
    public LoanManager() {
        initComponents();

        trackedLoans = new ArrayList<>();
        loanNames = new ArrayList<>();
        loanCards = new ArrayList<>();
        
        loadLoansFromFile();
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

        javax.swing.GroupLayout pnlBackgroundLayout = new javax.swing.GroupLayout(pnlBackground);
        pnlBackground.setLayout(pnlBackgroundLayout);
        pnlBackgroundLayout.setHorizontalGroup(
            pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBackgroundLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblStatus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBackgroundLayout.createSequentialGroup()
                .addGap(421, 421, 421)
                .addComponent(lblTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAddLoan, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(172, 172, 172))
            .addGroup(pnlBackgroundLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblHeader, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(107, 107, 107))
            .addGroup(pnlBackgroundLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlBackgroundLayout.createSequentialGroup()
                        .addComponent(lblLoanName, javax.swing.GroupLayout.PREFERRED_SIZE, 445, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblCardUsed, javax.swing.GroupLayout.PREFERRED_SIZE, 445, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlBackgroundLayout.createSequentialGroup()
                        .addComponent(lblRemainingBalance, javax.swing.GroupLayout.PREFERRED_SIZE, 445, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblTotalInterest, javax.swing.GroupLayout.PREFERRED_SIZE, 445, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(pnlBackgroundLayout.createSequentialGroup()
                .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlBackgroundLayout.createSequentialGroup()
                        .addGap(255, 255, 255)
                        .addComponent(btnViewDetails, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43)
                        .addComponent(btnMakePayment, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43)
                        .addComponent(btnDeleteLoan, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlBackgroundLayout.createSequentialGroup()
                        .addGap(161, 161, 161)
                        .addComponent(lblLoansHeader, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(scrList, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlBackgroundLayout.createSequentialGroup()
                        .addGap(454, 454, 454)
                        .addComponent(btnCardsManager, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlBackgroundLayout.createSequentialGroup()
                    .addGap(134, 134, 134)
                    .addComponent(lblDetailsHeader, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(723, Short.MAX_VALUE)))
        );
        pnlBackgroundLayout.setVerticalGroup(
            pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBackgroundLayout.createSequentialGroup()
                .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlBackgroundLayout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(lblTitle))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBackgroundLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnAddLoan)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblHeader)
                .addGap(24, 24, 24)
                .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblLoansHeader)
                    .addComponent(scrList, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnViewDetails)
                    .addComponent(btnDeleteLoan)
                    .addComponent(btnMakePayment))
                .addGap(118, 118, 118)
                .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblLoanName, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCardUsed, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblTotalInterest, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblRemainingBalance, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(btnCardsManager)
                .addGap(18, 18, 18))
            .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBackgroundLayout.createSequentialGroup()
                    .addContainerGap(359, Short.MAX_VALUE)
                    .addComponent(lblDetailsHeader)
                    .addGap(231, 231, 231)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlBackground, javax.swing.GroupLayout.PREFERRED_SIZE, 930, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlBackground, javax.swing.GroupLayout.DEFAULT_SIZE, 647, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    // load saved loans from file
    public void loadLoansFromFile() {
        trackedLoans.clear();
        loanNames.clear();
        loanCards.clear();
        
        try {
            java.io.BufferedReader br = new java.io.BufferedReader(new java.io.FileReader("Loans.txt"));
            String line;
            
            while ((line = br.readLine()) != null) {
                String strName = line;
                double dblPrincipal = Double.parseDouble(br.readLine());
                double dblRate = Double.parseDouble(br.readLine());
                int intMonths = Integer.parseInt(br.readLine());
                String strCardNum = br.readLine();
                
                Loan loan = new Loan(dblPrincipal, dblRate, intMonths);
                trackedLoans.add(loan);
                loanNames.add(strName);
                loanCards.add(strCardNum);
            }
            
            br.close();
        } catch (Exception e) {
            // do absolutely nothing
        }
    }
    
    // refresh the loans list display
    public void refreshLoansList() {
        String[] loanArray;
        if (trackedLoans.isEmpty()) {
            loanArray = new String[]{"No loans tracked yet. Click 'Add/Edit Loans' to get started!"};
        } else {
            loanArray = new String[trackedLoans.size()];
            for (int i = 0; i < trackedLoans.size(); i++) {
                Loan loan = trackedLoans.get(i);
                loanArray[i] = loanNames.get(i) + " - $" + loan.getMonthlyPayment() + "/month (" + loan.getTermMonths() + " months left)";
            }
        }
        
        lstLoans.setListData(loanArray);
    }
    
    // clear details display
    private void clearDetailsDisplay() {
        lblRemainingBalance.setText("Remaining Balance:");
        lblLoanName.setText("Select a loan to view details");
        lblTotalInterest.setText("Total Interest Left:");
        lblCardUsed.setText("Paying from:");
    }
    
    private Card findCardByNumber(String strCardNumber) {
        for (CreditCard card : CardsManager.listCreditCards) {
            if (card.getNumber().equals(strCardNumber)) {
                return card;
            }
        }
        
        for (DebitCard card : CardsManager.listDebitCards) {
            if (card.getNumber().equals(strCardNumber)) {
                return card;
            }
        }
        
        return null;
    }
    
    private void saveLoansToFile() {
        try {
            java.io.FileWriter fw = new java.io.FileWriter("Loans.txt");
            
            for (int i = 0; i < trackedLoans.size(); i++) {
                Loan loan = trackedLoans.get(i);
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
    
    
    private void btnCardsManagerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCardsManagerActionPerformed
        this.dispose();
        CardsManager screen = new CardsManager();
        screen.setVisible(true);
    }//GEN-LAST:event_btnCardsManagerActionPerformed

    private void btnAddLoanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddLoanActionPerformed
        this.dispose();
        AddEditLoan screen = new AddEditLoan();
        screen.setVisible(true);
    }//GEN-LAST:event_btnAddLoanActionPerformed

    private void btnMakePaymentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMakePaymentActionPerformed
        if (selectedLoan == null || selectedCard == null) {
            lblStatus.setText(" Please view a loan first!");
            return;
        }
        
        // check if payment is affordable
        if (!Loan.canAffordPayment(selectedCard, selectedLoan.getMonthlyPayment())) {
            lblStatus.setText(" Insufficient balance to make payment!");
            return;
        }
        
        // Apply payment to card
        boolean blnSuccess = selectedLoan.applyMonthlyPayment(selectedCard);
        
        if (blnSuccess) {
            // update the card in the main list
            CardsManager.writeToFile(selectedCard instanceof CreditCard);
            
            // update remaining balance display
            lblRemainingBalance.setText("Remaining Balance: $" + 
                String.format("%.2f", selectedLoan.getRemainingBalance()));
            
            // save updated loan
            saveLoansToFile();
            
            // refresh display
            refreshLoansList();
            
            lblStatus.setText("Payment of $" + 
                String.format("%.2f", selectedLoan.getMonthlyPayment()) + " applied!");
        } else {
            lblStatus.setText(" Payment failed!");
        }
    }//GEN-LAST:event_btnMakePaymentActionPerformed

    private void btnViewDetailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewDetailsActionPerformed
        intSelectedEditIndex = lstLoans.getSelectedIndex();
        
        if (intSelectedEditIndex < 0 || intSelectedEditIndex >= trackedLoans.size()) {
            lblStatus.setText(" Please select a loan from the list!");
            return;
        }
        
        selectedLoan = trackedLoans.get(intSelectedEditIndex);
        String strCardNumber = loanCards.get(intSelectedEditIndex);
        
        // Find the card
        selectedCard = findCardByNumber(strCardNumber);
        
        // display loan details
        lblLoanName.setText("Loan: " + loanNames.get(intSelectedEditIndex));
        lblRemainingBalance.setText("Remaining Balance: $" + 
            String.format("%.2f", selectedLoan.getRemainingBalance()));
        lblTotalInterest.setText("Total Interest Left: $" + 
            String.format("%.2f", selectedLoan.getTotalInterest()));
        
        if (selectedCard != null) {
            lblCardUsed.setText("Paying from: " + selectedCard.getName());
        } else {
            lblCardUsed.setText("Paying from: Card not found");
        }
        
        lblStatus.setText("Viewing loan details");
    }//GEN-LAST:event_btnViewDetailsActionPerformed

    private void btnDeleteLoanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteLoanActionPerformed
        intSelectedEditIndex = lstLoans.getSelectedIndex();
        
        if (intSelectedEditIndex < 0 || intSelectedEditIndex >= trackedLoans.size()) {
            lblStatus.setText(" Please select a loan to delete!");
            return;
        }
        
        trackedLoans.remove(intSelectedEditIndex);
        loanNames.remove(intSelectedEditIndex);
        loanCards.remove(intSelectedEditIndex);
            
        saveLoansToFile();
        refreshLoansList();
        clearDetailsDisplay();
            
        selectedLoan = null;
        selectedCard = null;
            
        lblStatus.setText("Loan deleted successfully!"); 
    }//GEN-LAST:event_btnDeleteLoanActionPerformed

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
    private javax.swing.JButton btnCardsManager;
    private javax.swing.JButton btnDeleteLoan;
    private javax.swing.JButton btnMakePayment;
    private javax.swing.JButton btnViewDetails;
    private javax.swing.JLabel lblCardUsed;
    private javax.swing.JLabel lblDetailsHeader;
    private javax.swing.JLabel lblHeader;
    private javax.swing.JLabel lblLoanName;
    private javax.swing.JLabel lblLoansHeader;
    private javax.swing.JLabel lblRemainingBalance;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblTotalInterest;
    private javax.swing.JList<String> lstLoans;
    private javax.swing.JPanel pnlBackground;
    private javax.swing.JScrollPane scrList;
    // End of variables declaration//GEN-END:variables
}
