public class AddCard extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(CardsManager.class.getName());


    public AddCard() {
	initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGrp = new javax.swing.ButtonGroup();
        pnlBackground = new javax.swing.JPanel();
        lblTitle = new javax.swing.JLabel();
        btnAdd = new javax.swing.JButton();
        lblWarning = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();
        lblName = new javax.swing.JLabel();
        lblLimitBalance = new javax.swing.JLabel();
        btnDebit = new javax.swing.JRadioButton();
        btnCredit = new javax.swing.JRadioButton();
        lblType = new javax.swing.JLabel();
        lblBank = new javax.swing.JLabel();
        txtBank = new javax.swing.JTextField();
        txtLimit = new javax.swing.JTextField();
        txtName = new javax.swing.JTextField();
        lblCardNumber = new javax.swing.JLabel();
        lblDate = new javax.swing.JLabel();
        lblCVV = new javax.swing.JLabel();
        txtNumber = new javax.swing.JTextField();
        txtDate = new javax.swing.JTextField();
        txtCVV = new javax.swing.JTextField();
        lblDisplayError = new javax.swing.JLabel();

        btnGrp.add(btnDebit);
        btnGrp.add(btnCredit);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnlBackground.setBackground(new java.awt.Color(153, 153, 255));

        lblTitle.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 36)); // NOI18N
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle.setText("Add a New Card!");

        btnAdd.setBackground(new java.awt.Color(153, 153, 255));
        btnAdd.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        btnAdd.setText("Add the Card!");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        lblWarning.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        lblWarning.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblWarning.setText("* You can have a maximum of 3 credit cards, and 3 debit cards! *");

        btnBack.setBackground(new java.awt.Color(153, 153, 255));
        btnBack.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        lblName.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        lblName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblName.setText("Cardholder Full Legal Name:");

        lblLimitBalance.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        lblLimitBalance.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblLimitBalance.setText("Card Balance/Credit Limit:");

        btnDebit.setText("Debit");

        btnCredit.setText("Credit");

        lblType.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        lblType.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblType.setText("Card Type:");

        lblBank.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        lblBank.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblBank.setText("Card Issuer (Bank Affiliated):");

        txtBank.setBackground(new java.awt.Color(153, 153, 255));

        txtLimit.setBackground(new java.awt.Color(153, 153, 255));

        txtName.setBackground(new java.awt.Color(153, 153, 255));

        lblCardNumber.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        lblCardNumber.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblCardNumber.setText("Card Number:");

        lblDate.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        lblDate.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblDate.setText("Expiry Date (FORMAT: MM/YY):");

        lblCVV.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        lblCVV.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblCVV.setText("CVV:");

        txtNumber.setBackground(new java.awt.Color(153, 153, 255));

        txtDate.setBackground(new java.awt.Color(153, 153, 255));

        txtCVV.setBackground(new java.awt.Color(153, 153, 255));

        lblDisplayError.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        lblDisplayError.setForeground(new java.awt.Color(204, 0, 0));
        lblDisplayError.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout pnlBackgroundLayout = new javax.swing.GroupLayout(pnlBackground);
        pnlBackground.setLayout(pnlBackgroundLayout);
        pnlBackgroundLayout.setHorizontalGroup(
            pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lblWarning, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnlBackgroundLayout.createSequentialGroup()
                .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlBackgroundLayout.createSequentialGroup()
                        .addGap(232, 232, 232)
                        .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(lblBank)
                                .addComponent(lblType)
                                .addComponent(lblCardNumber)
                                .addComponent(lblDate)
                                .addComponent(lblCVV)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlBackgroundLayout.createSequentialGroup()
                                    .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(28, 28, 28))
                                .addComponent(lblName))
                            .addComponent(lblLimitBalance))
                        .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlBackgroundLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pnlBackgroundLayout.createSequentialGroup()
                                        .addComponent(btnDebit)
                                        .addGap(27, 27, 27)
                                        .addComponent(btnCredit))
                                    .addComponent(txtBank, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtLimit, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtDate, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtCVV, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(pnlBackgroundLayout.createSequentialGroup()
                                .addGap(110, 110, 110)
                                .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 194, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBackgroundLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblDisplayError, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pnlBackgroundLayout.setVerticalGroup(
            pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBackgroundLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitle)
                .addGap(11, 11, 11)
                .addComponent(lblWarning)
                .addGap(18, 18, 18)
                .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblName)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtLimit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblLimitBalance))
                .addGap(18, 18, 18)
                .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDebit)
                    .addComponent(btnCredit)
                    .addComponent(lblType))
                .addGap(18, 18, 18)
                .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblBank)
                    .addComponent(txtBank, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblCardNumber)
                    .addComponent(txtNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDate)
                    .addComponent(txtDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCVV)
                    .addComponent(txtCVV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(61, 61, 61)
                .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBack)
                    .addComponent(btnAdd))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 86, Short.MAX_VALUE)
                .addComponent(lblDisplayError)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlBackground, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlBackground, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
	/** 
	 * Make sure hte crdit card number isnt a dupe 
	 * Make sure the name is a string with letters only, with at least 2 seperate strings
	 * make sure CVV, balance, and card number are numbers
	 * make sure cvv is either 3 or 4 numbers (less than 9999 ) 
	 *    -->  maybe turn it into a list or smt and find the length
	 * make sure a radio button is clicked for credit or debit
	 * capitalize name, bank
	 * for date, make sure the / is element 2 of the 5 character array (turn the str into a list)
	 *   --> use a switch statement for all the months, and then make the year be between 26 and 30 (credit/debit cards expire within 5 years)
	 * MAKE SURE to account for either debit or credit being max (check size) 
	 */

	// #1: Create boolean variables which will save whether the current inputs are valid or invalid 
	// boolNameValid makes sure the name consists of only letters, and at least has 2 seperate strings (to signify first and last name) 
	// boolCard makes sure the Card # is not a duplicate, and only consists of numbers
	// boolBankValid will make sure the bank inputted/card issuer's name only consists of letters
	// boolTypeValid will make sure that either the Debit or Credit radio button was selected, and that they aren't at their max capacity
	// boolCVV will make sure the CVV is all numbers, and that it is either 3 or 4 numbers long
	// boolDateValid will make sure the expiry date is valid (Make sure the month is less than 12, and that the expiry year is between 2026 - 2030)
	boolean boolNameValid = true, boolCardValid = true, boolBankValid = true, boolTypeValid = true, boolCVV = true, boolDateValid = false; 
	
	// #2: Create a string variable for every input (except card type)  
	// 7 total values
	String strName = txtName.getText().trim(); // CAPITALIZE LATER
	String strBalance = txtLimit.getText().trim(); 
	String strBank = txtBank.getText().trim(); // CAPITALIZE LATER
	String strNumber = txtNumber.getText().trim(); 
	String strCVV = txtCVV.getText().trim();
	String strDate = txtDate.getText().trim(); 
	
	// Surround the entire verifying process in a while loop to break out of the loop if it ever errors
	// This will allow easy error handling. 
	while(true) {
	    // Use an if-else statement to find out whether it is a credit or debit card 
	    if (btnGrp.getSelection() == btnDebit && CardsManager.listCreditCards.size() < 3) {
		boolean boolCredit = true; 
	    }
	    
	    // Now that everything has been verified, add the new card to the list, then write to the file. 
	    
	    break; // break out of the loop since it is now complete
	}
	
	// All the different error messages
	// These are all customized to tell the user WHICH input specifically is causing the error
	if (!boolTypeValid) {
	    lblDisplayError.setText("ERROR: Make sure the type of card is selected, and it is not at max (3 cards per type)!"); 
	} else if (!boolNameValid) {
	    lblDisplayError.setText("ERROR: Make sure your name only consists of English Letters)!"); 
	} else if (!boolCardValid) {
	    lblDisplayError.setText("ERROR: Make sure your card number is NOT a duplicate, and only consists of numbers!"); 
	} else if (!boolBankValid) {
	    lblDisplayError.setText("ERROR: Make sure your card issuer's name only consists of English Letters)!"); 
	} else if (!boolDateValid) {
	    lblDisplayError.setText("ERROR: Make sure your date is in the given format, and that your expiry year is valid (Between 2026 - 2030)!");
	} else if (!boolCVV) {
	    lblDisplayError.setText("ERROR: Make sure your CVV is either 3 - 4 characters, and only numbers!"); 
	}
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
	// clear textspace
	lblDisplayError.setText("");

	// Dispose of the current screen, and go back to the menu (Cards Manager) 
	this.dispose(); // dispose the current screen
	
	// Create a new object for the class, then turn it into the new screen
	CardsManager screen = new CardsManager(); 
	screen.setVisible(true);
    }//GEN-LAST:event_btnBackActionPerformed

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
	java.awt.EventQueue.invokeLater(() -> new AddCard().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnBack;
    private javax.swing.JRadioButton btnCredit;
    private javax.swing.JRadioButton btnDebit;
    private javax.swing.ButtonGroup btnGrp;
    private javax.swing.JLabel lblBank;
    private javax.swing.JLabel lblCVV;
    private javax.swing.JLabel lblCardNumber;
    private javax.swing.JLabel lblDate;
    private javax.swing.JLabel lblDisplayError;
    private javax.swing.JLabel lblLimitBalance;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblType;
    private javax.swing.JLabel lblWarning;
    private javax.swing.JPanel pnlBackground;
    private javax.swing.JTextField txtBank;
    private javax.swing.JTextField txtCVV;
    private javax.swing.JTextField txtDate;
    private javax.swing.JTextField txtLimit;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtNumber;
    // End of variables declaration//GEN-END:variables
}
