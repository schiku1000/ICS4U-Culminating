import java.text.DecimalFormat; // required for rounding

public class AddCard extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(CardsManager.class.getName());

    public AddCard() {
	initComponents();
    }

    // Create a decimal format 
    DecimalFormat df = new DecimalFormat("0.00"); 
    
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
	// Create another boolean to save whether it is a credit card or debit card being added
	boolean boolCredit;
	
	// First check: Create a string variable for every input (except card type)  
	// 7 total values
	String strName = txtName.getText().trim(); 
	String strBalance = txtLimit.getText().trim(); 
	String strBank = txtBank.getText().trim();
	String strNumber = txtNumber.getText().trim(); 
	String strCVV = txtCVV.getText().trim(); 
	String strDate = txtDate.getText().trim().replace("/", ""); // Replace the dash with nothing (I want the input to only be numbers for the checks) 
	
	// First check, make sure values aren't blank
	if (strName.equals("") || strBalance.equals("") || strBank.equals("") || strNumber.equals("") || strCVV.equals("") || strDate.equals("")) {
	    lblDisplayError.setText("ERROR: Please make sure none of your inputs are blank!");
	    return; // break out of the function
	}
	
	// This section is not a check, it just makes sure the name and card issuer are capitalized. 
	// We will do this using a temporary string value, and a temporary boolean to know whether it is the first letter or not 
	boolean boolFirstLetter = true; 
	String strTempName = "";
	
	// Create a for loop to iterate through the name, and capitalize
	for (int i = 0; i < strName.length(); i++) {
	    if (strName.charAt(i) != ' ') {
		if (boolFirstLetter) { // if it is the first letter 
		    strTempName += Character.toString(strName.charAt(i)).toUpperCase(); // Add the character to the string (must parse first, and capitalize it) 
		    boolFirstLetter = false; // Set the boolean as false now as it is no longer the first letter of the word 
		} else {
		    strTempName += Character.toString(strName.charAt(i)); // Add the character to the string (must parse first) 
		}
	    } else {
		strTempName += " "; // add a space to the name 
		boolFirstLetter = true; // set the first letter boolean as true as it is now moving onto the next word 
	    }
	}
	
	strName = strTempName; // Replace the strName with the new edited name 
	
	// Reset the variables for the bank name check again, then use the same logic again 
	boolFirstLetter = true; 
	strTempName = "";
	
	// Create a for loop to iterate through the name, and capitalize
	for (int i = 0; i < strBank.length(); i++) {
	    if (strBank.charAt(i) != ' ') {
		if (boolFirstLetter) { // if it is the first letter 
		    strTempName += Character.toString(strBank.charAt(i)).toUpperCase(); // Add the character to the string (must parse first, and capitalize it) 
		    boolFirstLetter = false; // Set the boolean as false now as it is no longer the first letter of the word 
		} else {
		    strTempName += Character.toString(strBank.charAt(i)); // Add the character to the string (must parse first) 
		}
	    } else {
		strTempName += " "; // add a space to the name 
		boolFirstLetter = true; // set the first letter boolean as true as it is now moving onto the next word 
	    }
	}
	
	strBank = strTempName; // Replace the strBank with the new edited card issuer name  
	
	// Second Check: Make sure the inputted name & card issuer name only consists of letters, and that the name has a space in it (to signify first and last name) 
	// Do not add a limit to spaces because they could have multiple "middle" names. 
	// Also allow dashes for those who have a joint last name (e.g. Johnson-Smith)
	int intSpaceCounter = 0; // this is the counter we will be using to count the number of spaces in the name 
	
	// Basically, this for loop just makes sure that every single character is a valid English letter by checking if the index of the character within a string consisting of all English letters is not -1. 
	for (int i = 0; i < strName.length(); i++) {
	    // This first if statement will make sure the name only consists of English characters. 
	    if ("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ- ".indexOf(strName.charAt(i)) < 0) {
		lblDisplayError.setText("ERROR: Please make sure the inputted name only has english characters!");
		return; // break out of the function
	    }
	    
	    // This second if statement will count the number of spaces.
	    if (strName.charAt(i) == ' ') {
		intSpaceCounter++; // Add one to the space counter 
	    }
	}
	
	// Now, make sure the name has more than one space
	if (intSpaceCounter < 1) {
	    lblDisplayError.setText("ERROR: Please make sure you input your full legal name (not just first name)!"); 
	    return; // break out of the function
	}
	
	// Do the same for loop again (without the space requirement) for the bank name
	for (int i = 0; i < strBank.length(); i++) {
	    // This if statement will make sure the card issuer name only consists of English characters. 
	    if ("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ- ".indexOf(strBank.charAt(i)) < 0) {
		lblDisplayError.setText("ERROR: Please make sure the inputted card issuer name only has english characters!");
		return; // break out of the function
	    }
	}
	
	// Third check: Make sure all the number values are the proper types (e.g. strNumber can be parsed into a double; doesn't have dollar sign) 
	try {
	    // To do this, try parsing them into either a double, or an integer!
	    // If they fail, that would mean that they do not only have number characters!
	    Integer.valueOf(strCVV); 
	    Long.valueOf(strNumber);
	    Integer.valueOf(strDate); 
	    Double.valueOf(strBalance); 
	    
	    // Make sure the CVV is 3 - 4 characters
	    if (strCVV.length() < 3 || strCVV.length() > 4) {
		lblDisplayError.setText("ERROR: Please make sure your CVV is 3 - 4 numbers long!"); 
		return; // break out of the method 
	    }
	    
	    // Make sure the card number is between 15 - 19 numbers long (found this via researching) 
	    if (strNumber.length() < 15 || strNumber.length() > 19 ) {
		lblDisplayError.setText("ERROR: Please make sure your card # is 15 - 19 numbers long!"); 
		return; // break out of the method 
	    }
	    
	} catch (NumberFormatException e ) { // If it fails turning the strings into numbers: 
	    lblDisplayError.setText("ERROR: Make sure your CVV, balance, expiry date, and card # only consist of numbers!");
	    return; // break out of the method
	}

	// Fourth check: Make sure the type was selected/is valid
	// Use an if-else statement to find out whether it is a credit or debit card 
	if (btnCredit.isSelected() && CardsManager.listCreditCards.size() < 3) {
	    boolCredit = true; 
	} else if (btnDebit.isSelected() && CardsManager.listDebitCards.size() < 3) {
	    boolCredit = false; 
	} else { // This means either they didn't choose whether it's a credit or debit card, OR it is at its max, so it is INVALID. 
	    lblDisplayError.setText("ERROR: Please make sure you select a card type, and that there are less than 3 of that type!"); 
	    return; // break out of the loop 
	}
	    
	// Fifth check: Make sure the inputted card number is NOT a duplicate 
	// We made sure to check both the debit and credit card lists!
	// Use a for loop to iterate through the lists of credit cards
	for (int i = 0; i < CardsManager.listCreditCards.size(); i++) {
	    if (strNumber.equals(CardsManager.listCreditCards.get(i).getNumber())) {
		lblDisplayError.setText("ERROR: Card already added (Same card #)!"); 
		return; // break out of the method.
	    }
	}
	
	// Use a for loop to iterate through the lists of debit cards
	for (int i = 0; i < CardsManager.listDebitCards.size(); i++) {
	    if (strNumber.equals(CardsManager.listDebitCards.get(i).getNumber())) {
		lblDisplayError.setText("ERROR: Card already added (Same card #)!"); 
		return; // break out of the method.
	    }
	}
	
	// Sixth and final check: Make sure that the date inputted for the expiry is valid 
	// First, make sure the length is 4 using an if statement, otherwise there's no need for other checks
	// Also make sure that the year inputted is between 26 and 30 (2026 and 2030), and that the months are from 01 - 12
	if (strDate.length() != 4 || Integer.parseInt(strDate.substring(0, 2)) < 0 || Integer.parseInt(strDate.substring(0, 2)) > 12 || Integer.parseInt(strDate.substring(2)) < 26 || Integer.parseInt(strDate.substring(2)) > 30 ) {
	    lblDisplayError.setText("ERROR: Make sure the expiry date is within 2030, and follows the format!");
	    return; // break out of the method 
	} 
	
	// Now that everything has been verified, add the new card to the list, then write to the file. 
	// Use the boolean we created earlier to know whether it is a credit or debit card
	if (boolCredit) {
	    CardsManager.listCreditCards.add(new CreditCard(strName, strBank, strNumber, strDate.substring(0, 2) + "/" + strDate.substring(2), strCVV, df.format(Double.parseDouble(strBalance))));
	} else {
	    CardsManager.listDebitCards.add(new DebitCard(strName, strBank, strNumber, strDate.substring(0, 2) + "/" + strDate.substring(2), strCVV, df.format(Double.parseDouble(strBalance))));
	}
	
	// Write to the file 
	CardsManager.writeToFile(boolCredit);
	
	// Finally, go back to cards manager
	this.dispose(); // dispose the current screen
	CardsManager screen = new CardsManager(); 
	screen.setVisible(true); // make the new screen visible
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
