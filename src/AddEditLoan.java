import java.util.ArrayList;
import java.text.DecimalFormat;

public class AddEditLoan extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(AddEditLoan.class.getName());
    private ArrayList<Loan> trackedLoans;
    private ArrayList<String> loanNames;
    private ArrayList<String> loanCards;
    private int intSelectedEditIndex = -1;
    
    private static final DecimalFormat format = new DecimalFormat("###.##");
    
    /**
     * Creates new form AddEditLoan
     */
    public AddEditLoan() {
        initComponents();
        trackedLoans = new ArrayList<>();
        loanNames = new ArrayList<>();
        loanCards = new ArrayList<>();
       
        try {
            java.io.File file = new java.io.File("Loans.txt");
            if (!file.exists()) {
                file.createNewFile();
            }
        } catch (Exception e) {}
        
        
        populateCardDropdowns();
        loadLoansFromFile();
        refreshExistingLoansList();
        setEditFieldsEnabled(false);
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
        btnLoanManager = new javax.swing.JButton();
        lblAddHeader = new javax.swing.JLabel();
        lblAmountOwed = new javax.swing.JLabel();
        lblEditRate = new javax.swing.JLabel();
        lblMonthsLeft = new javax.swing.JLabel();
        lblPayFromCard = new javax.swing.JLabel();
        cmbSelectCard = new javax.swing.JComboBox<>();
        txtLoanAmount = new javax.swing.JTextField();
        txtLoanName = new javax.swing.JTextField();
        txtLoanTerm = new javax.swing.JTextField();
        btnAddLoan = new javax.swing.JButton();
        lblEditHeader = new javax.swing.JLabel();
        lblEditAmountOwned = new javax.swing.JLabel();
        lblEditLoanName = new javax.swing.JLabel();
        lblEditMonthsLeft = new javax.swing.JLabel();
        lblEditPayFromCard = new javax.swing.JLabel();
        cmbEditCard = new javax.swing.JComboBox<>();
        txtEditName = new javax.swing.JTextField();
        txtEditTerm = new javax.swing.JTextField();
        txtEditAmount = new javax.swing.JTextField();
        btnSaveChanges = new javax.swing.JButton();
        scrList = new javax.swing.JScrollPane();
        lstExistingLoans = new javax.swing.JList<>();
        lblLoanName = new javax.swing.JLabel();
        lblRate = new javax.swing.JLabel();
        txtInterestRate = new javax.swing.JTextField();
        txtEditRate = new javax.swing.JTextField();
        btnCancelEdit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnlBackground.setBackground(new java.awt.Color(153, 153, 255));
        pnlBackground.setPreferredSize(new java.awt.Dimension(914, 578));

        lblTitle.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 36)); // NOI18N
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle.setText("Add/Edit Loans");

        lblStatus.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        lblStatus.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        btnLoanManager.setBackground(new java.awt.Color(153, 153, 255));
        btnLoanManager.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        btnLoanManager.setText("Go to Loan Manager");
        btnLoanManager.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoanManagerActionPerformed(evt);
            }
        });

        lblAddHeader.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        lblAddHeader.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAddHeader.setText("Add A New Loan:");

        lblAmountOwed.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        lblAmountOwed.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAmountOwed.setText("Amount Owed:");

        lblEditRate.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        lblEditRate.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblEditRate.setText("Rate:");

        lblMonthsLeft.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        lblMonthsLeft.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMonthsLeft.setText("Months Left:");

        lblPayFromCard.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        lblPayFromCard.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPayFromCard.setText("Pay from Card:");

        btnAddLoan.setBackground(new java.awt.Color(153, 153, 255));
        btnAddLoan.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        btnAddLoan.setText("Add Loan");
        btnAddLoan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddLoanActionPerformed(evt);
            }
        });

        lblEditHeader.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        lblEditHeader.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblEditHeader.setText("Edit a Loan:");

        lblEditAmountOwned.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        lblEditAmountOwned.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblEditAmountOwned.setText("Amount Owed:");

        lblEditLoanName.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        lblEditLoanName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblEditLoanName.setText("Loan Name:");

        lblEditMonthsLeft.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        lblEditMonthsLeft.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblEditMonthsLeft.setText("Months Left:");

        lblEditPayFromCard.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        lblEditPayFromCard.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblEditPayFromCard.setText("Pay from Card:");

        btnSaveChanges.setBackground(new java.awt.Color(153, 153, 255));
        btnSaveChanges.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        btnSaveChanges.setText("Save Changes");
        btnSaveChanges.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveChangesActionPerformed(evt);
            }
        });

        lstExistingLoans.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lstExistingLoansMouseClicked(evt);
            }
        });
        scrList.setViewportView(lstExistingLoans);

        lblLoanName.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        lblLoanName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblLoanName.setText("Loan Name:");

        lblRate.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        lblRate.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblRate.setText("Rate:");

        btnCancelEdit.setBackground(new java.awt.Color(153, 153, 255));
        btnCancelEdit.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        btnCancelEdit.setText("Cancel Edit");
        btnCancelEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelEditActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlBackgroundLayout = new javax.swing.GroupLayout(pnlBackground);
        pnlBackground.setLayout(pnlBackgroundLayout);
        pnlBackgroundLayout.setHorizontalGroup(
            pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBackgroundLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlBackgroundLayout.createSequentialGroup()
                        .addGap(187, 187, 187)
                        .addComponent(lblStatus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pnlBackgroundLayout.createSequentialGroup()
                        .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblAddHeader, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pnlBackgroundLayout.createSequentialGroup()
                                .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblEditHeader, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(pnlBackgroundLayout.createSequentialGroup()
                                        .addGap(40, 40, 40)
                                        .addComponent(btnAddLoan, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(scrList, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(pnlBackgroundLayout.createSequentialGroup()
                .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlBackgroundLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblEditLoanName, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtEditName, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblEditRate, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtEditRate, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlBackgroundLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(lblEditPayFromCard, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbEditCard, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlBackgroundLayout.createSequentialGroup()
                        .addComponent(lblEditMonthsLeft, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtEditTerm, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlBackgroundLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblEditAmountOwned, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtEditAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlBackgroundLayout.createSequentialGroup()
                        .addGap(346, 346, 346)
                        .addComponent(lblTitle)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(pnlBackgroundLayout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(btnSaveChanges, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(btnCancelEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(pnlBackgroundLayout.createSequentialGroup()
                .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlBackgroundLayout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlBackgroundLayout.createSequentialGroup()
                                .addComponent(lblMonthsLeft, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtLoanTerm, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlBackgroundLayout.createSequentialGroup()
                                .addComponent(lblAmountOwed, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtLoanAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlBackgroundLayout.createSequentialGroup()
                                .addComponent(lblPayFromCard, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cmbSelectCard, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(pnlBackgroundLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblLoanName, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtLoanName, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 82, Short.MAX_VALUE)
                .addComponent(txtInterestRate, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(167, 167, 167))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBackgroundLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnLoanManager, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(304, 304, 304))
            .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBackgroundLayout.createSequentialGroup()
                    .addContainerGap(578, Short.MAX_VALUE)
                    .addComponent(lblRate, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(246, 246, 246)))
        );
        pnlBackgroundLayout.setVerticalGroup(
            pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBackgroundLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitle)
                .addGap(13, 13, 13)
                .addComponent(lblAddHeader)
                .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlBackgroundLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtLoanName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblLoanName))
                        .addGap(4, 4, 4)
                        .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblAmountOwed)
                            .addComponent(txtLoanAmount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnlBackgroundLayout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(txtInterestRate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMonthsLeft)
                    .addComponent(txtLoanTerm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPayFromCard)
                    .addComponent(cmbSelectCard, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addComponent(btnAddLoan)
                .addGap(18, 18, 18)
                .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblEditHeader)
                    .addComponent(scrList, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEditName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblEditLoanName)
                    .addComponent(lblEditRate)
                    .addComponent(txtEditRate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEditAmountOwned)
                    .addComponent(txtEditAmount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEditMonthsLeft)
                    .addComponent(txtEditTerm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEditPayFromCard)
                    .addComponent(cmbEditCard, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSaveChanges)
                    .addComponent(btnCancelEdit))
                .addGap(46, 46, 46)
                .addComponent(lblStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(btnLoanManager)
                .addContainerGap())
            .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlBackgroundLayout.createSequentialGroup()
                    .addGap(114, 114, 114)
                    .addComponent(lblRate)
                    .addContainerGap(558, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlBackground, javax.swing.GroupLayout.DEFAULT_SIZE, 895, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlBackground, javax.swing.GroupLayout.DEFAULT_SIZE, 720, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Load saved loans from file
    private void loadLoansFromFile() {
        trackedLoans.clear();
        loanNames.clear();
        loanCards.clear();
        
        try {
            java.io.BufferedReader br = new java.io.BufferedReader(
                new java.io.FileReader("Loans.txt")
            );
            String line;
            
            while ((line = br.readLine()) != null) {
                String strName = line;
                double principal = Double.parseDouble(br.readLine());
                double dblRate = Double.parseDouble(br.readLine());
                int intMonths = Integer.parseInt(br.readLine());
                String cardNum = br.readLine();
                
                Loan loan = new Loan(principal, dblRate, intMonths);
                trackedLoans.add(loan);
                loanNames.add(strName);
                loanCards.add(cardNum);
            }
            
            br.close();
        } catch (Exception e) {
            // no file
        }
    }
    
    // Save all loans to file
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
    
    // Populate both card dropdowns
    private void populateCardDropdowns() {
        cmbSelectCard.removeAllItems();
        cmbEditCard.removeAllItems();
        
        for (CreditCard card : CardsManager.listCreditCards) {
            String item = "Credit: " + card.getName() + " - " + card.getNumber();
            cmbSelectCard.addItem(item);
            cmbEditCard.addItem(item);
        }
        
        for (DebitCard card : CardsManager.listDebitCards) {
            String item = "Debit: " + card.getName() + " - " + card.getNumber();
            cmbSelectCard.addItem(item);
            cmbEditCard.addItem(item);
        }
    }
    
    // refresh existing loans list
    private void refreshExistingLoansList() {
        String[] loanArray;
        
        if (trackedLoans.isEmpty()) {
            loanArray = new String[]{"No loans to edit yet."};
        } else {
            loanArray = new String[trackedLoans.size()];
            for (int i = 0; i < trackedLoans.size(); i++) {
                Loan loan = trackedLoans.get(i);
                loanArray[i] = loanNames.get(i) + " - $" + format.format(loan.getMonthlyPayment()) + "/month";
            }
        }
        
        lstExistingLoans.setListData(loanArray);
    }
    
    private void setEditFieldsEnabled(boolean enabled) {
        txtEditName.setEnabled(enabled);
        txtEditAmount.setEnabled(enabled);
        txtEditRate.setEnabled(enabled);
        txtEditTerm.setEnabled(enabled);
        cmbEditCard.setEnabled(enabled);
        btnSaveChanges.setEnabled(enabled);
        btnCancelEdit.setEnabled(enabled);
    }
    
    private void clearEditFields() {
        txtEditName.setText("");
        txtEditAmount.setText("");
        txtEditRate.setText("");
        txtEditTerm.setText("");
    }
    
    
    private void btnLoanManagerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoanManagerActionPerformed
        this.dispose();
        LoanManager screen = new LoanManager();
        screen.setVisible(true);
    }//GEN-LAST:event_btnLoanManagerActionPerformed

    private void btnAddLoanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddLoanActionPerformed
        try {
            String strName = txtLoanName.getText().trim();
            double dblBalance = Double.parseDouble(txtLoanAmount.getText());
            double dblRate = Double.parseDouble(txtInterestRate.getText());
            int intMonths = (int) Double.parseDouble(txtLoanTerm.getText());    
            
            // Validate inputs
            if (strName.isEmpty()) {
                lblStatus.setText(" Please enter a loan strName!");
                return;
            }
            
            if (dblBalance <= 0 || intMonths <= 0 || dblRate < 0) {
                lblStatus.setText(" Please enter valid positive numbers!");
                return;
            }
            
            if (cmbSelectCard.getSelectedItem() == null) {
                lblStatus.setText(" Please select a card for payments!");
                return;
            }
            
            // Get selected card number
            String strSelection = (String) cmbSelectCard.getSelectedItem();
            String strCardNumber = strSelection.substring(strSelection.lastIndexOf("-") + 2);
            
            // Create and add loan
            Loan newLoan = new Loan(dblBalance, dblRate, intMonths);
            trackedLoans.add(newLoan);
            loanNames.add(strName);
            loanCards.add(strCardNumber);
            
            // Save to file
            saveLoansToFile();
            
            // Refresh display
            refreshExistingLoansList();
            
            // Clear inputs
            txtLoanName.setText("");
            txtLoanAmount.setText("");
            txtInterestRate.setText("");
            txtLoanTerm.setText("");
            
            lblStatus.setText("Loan added!");
            
        } catch (NumberFormatException e) {
            lblStatus.setText(" Please enter valid numbers!");
        }
    }//GEN-LAST:event_btnAddLoanActionPerformed

    private void btnSaveChangesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveChangesActionPerformed
        if (intSelectedEditIndex < 0 || intSelectedEditIndex >= trackedLoans.size()) {
            lblStatus.setText(" Please select a loan to edit!");
            return;
        }
        
        try {
            String strName = txtEditName.getText().trim();
            double dblBalance = Double.parseDouble(txtEditAmount.getText());
            double dblRate = Double.parseDouble(txtEditRate.getText());
            int intMonths = (int) Double.parseDouble(txtEditTerm.getText());
            
            if (strName.isEmpty()) {
                lblStatus.setText(" Please enter a loan strName!");
                return;
            }
            
            if (dblBalance <= 0 || intMonths <= 0 || dblRate < 0) {
                lblStatus.setText(" Please enter valid positive numbers!");
                return;
            }
            
            if (cmbEditCard.getSelectedItem() == null) {
                lblStatus.setText(" Please select a card!");
                return;
            }
            
            // Get card number
            String strSelection = (String) cmbEditCard.getSelectedItem();
            String strCardNumber = strSelection.substring(strSelection.lastIndexOf("-") + 2);
            
            // Update loan
            Loan updatedLoan = new Loan(dblBalance, dblRate, intMonths);
            trackedLoans.set(intSelectedEditIndex, updatedLoan);
            loanNames.set(intSelectedEditIndex, strName);
            loanCards.set(intSelectedEditIndex, strCardNumber);
            
            // Save to file
            saveLoansToFile();
            
            // Refresh display
            refreshExistingLoansList();
            
            // Clear edit fields
            clearEditFields();
            setEditFieldsEnabled(false);
            intSelectedEditIndex = -1;
            
            lblStatus.setText("Loan updated successfully!");
            
        } catch (NumberFormatException e) {
            lblStatus.setText(" Please enter valid numbers!");
        }
    }//GEN-LAST:event_btnSaveChangesActionPerformed

    private void lstExistingLoansMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lstExistingLoansMouseClicked
        intSelectedEditIndex = lstExistingLoans.getSelectedIndex();
        
        if (intSelectedEditIndex < 0 || intSelectedEditIndex >= trackedLoans.size()) {
            return;
        }
        
        // populate edit fields
        Loan loan = trackedLoans.get(intSelectedEditIndex);
        txtEditName.setText(loanNames.get(intSelectedEditIndex));
        txtEditAmount.setText(String.valueOf(loan.getPrincipal()));
        txtEditRate.setText(String.valueOf(loan.getInterestRate()));
        txtEditTerm.setText(String.valueOf(loan.getTermMonths()));
        
        // select the correct card in dropdown
        String cardNum = loanCards.get(intSelectedEditIndex);
        for (int i = 0; i < cmbEditCard.getItemCount(); i++) {
            String item = cmbEditCard.getItemAt(i);
            if (item.contains(cardNum)) {
                cmbEditCard.setSelectedIndex(i);
                break;
            }
        }
        
        setEditFieldsEnabled(true);
        lblStatus.setText("Editing: " + loanNames.get(intSelectedEditIndex));
    }//GEN-LAST:event_lstExistingLoansMouseClicked

    private void btnCancelEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelEditActionPerformed
        clearEditFields();
        setEditFieldsEnabled(false);
        intSelectedEditIndex = -1;
        lstExistingLoans.clearSelection();
        lblStatus.setText("Edit cancelled");
    }//GEN-LAST:event_btnCancelEditActionPerformed

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
        java.awt.EventQueue.invokeLater(() -> new AddEditLoan().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddLoan;
    private javax.swing.JButton btnCancelEdit;
    private javax.swing.JButton btnLoanManager;
    private javax.swing.JButton btnSaveChanges;
    private javax.swing.JComboBox<String> cmbEditCard;
    private javax.swing.JComboBox<String> cmbSelectCard;
    private javax.swing.JLabel lblAddHeader;
    private javax.swing.JLabel lblAmountOwed;
    private javax.swing.JLabel lblEditAmountOwned;
    private javax.swing.JLabel lblEditHeader;
    private javax.swing.JLabel lblEditLoanName;
    private javax.swing.JLabel lblEditMonthsLeft;
    private javax.swing.JLabel lblEditPayFromCard;
    private javax.swing.JLabel lblEditRate;
    private javax.swing.JLabel lblLoanName;
    private javax.swing.JLabel lblMonthsLeft;
    private javax.swing.JLabel lblPayFromCard;
    private javax.swing.JLabel lblRate;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JList<String> lstExistingLoans;
    private javax.swing.JPanel pnlBackground;
    private javax.swing.JScrollPane scrList;
    private javax.swing.JTextField txtEditAmount;
    private javax.swing.JTextField txtEditName;
    private javax.swing.JTextField txtEditRate;
    private javax.swing.JTextField txtEditTerm;
    private javax.swing.JTextField txtInterestRate;
    private javax.swing.JTextField txtLoanAmount;
    private javax.swing.JTextField txtLoanName;
    private javax.swing.JTextField txtLoanTerm;
    // End of variables declaration//GEN-END:variables
}
