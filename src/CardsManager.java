// here are the classes we will be importing for the application 
import java.io.*; // for file reading and writing 
import java.util.*; // mostly for arrayList 
import java.text.DecimalFormat; // for rounding to 2 decimal places for the balance/credit limit 

public class CardsManager extends javax.swing.JFrame {   
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(CardsManager.class.getName());

    // create a list for cards
    static ArrayList<CreditCard> listCreditCards = new ArrayList<>(); 
    static ArrayList<DebitCard> listDebitCards = new ArrayList<>();
    
    // Create a decimal format 
    DecimalFormat df = new DecimalFormat("0.00"); 
    
    // Create a method to edit the cards on screen
    public void addCards() {
	
	// Clear the lists when initialized 
	listCreditCards.clear(); 
	listDebitCards.clear(); 
	
        // FIRST PART OF THIS METHOD: Add all the cards from the textfile into objects for the program 
        // First, I will do it for the credit cards, and then I will do it for the debit cards  
	// Intialize a bufferedReader 
        try {
            BufferedReader brCred = new BufferedReader(new FileReader("Credit Cards.txt"));
            String readCred = brCred.readLine();
            
            // Create a var which will work like a boolean 
            boolean boolRunning = true; 
            
            // #1: Add to the Credit Card List 
	    while(boolRunning && readCred != null) {
                // this is the list which will hold all of the values of the entered card 
                // the reason why is has a length of 6 is because there are 6 total values for the card.
		String[] strTemp = new String[6]; 
                
                // A try and except is used here to catch if readLine() errors (null)
                try {
                    for (int i = 0; i < strTemp.length; i++) {
                        strTemp[i] = readCred; // set each element of the temporary array as the line read by the bufferedReader
                        readCred = brCred.readLine(); // move onto the next line 
                    }
                } catch (Exception e) { // if it runs out of lines
                    boolRunning = false; // Make sure the boolean is set as false so that the loop stops running 
                } 

		double dblLimit = Double.parseDouble(strTemp[5]); 
		
                // add to the credit card list using the values we found in the for loop, and have saved in the array
                // most of the values are string, but some like the CVV and Balance have to be in short/long form as they are numbers
                listCreditCards.add(new CreditCard(strTemp[0], strTemp[1], strTemp[2], strTemp[3], Short.parseShort(strTemp[4]), df.format(dblLimit)));
            }
            
            brCred.close(); // close the reader
            
            // #2: Now do the same thing for the debit cards
            BufferedReader brDeb = new BufferedReader(new FileReader("Debit Cards.txt"));
            String readDeb = brDeb.readLine();
            boolRunning = true; 
	    
	    // use a while loop to add all the lines of the txt file to the card objects
	    while(boolRunning && readDeb != null) {
		// this is the list which will hold all of the values of the entered card 
                // the reason why is has a length of 6 is because there are 6 total values for the card.
		String[] strTemp = new String[6]; 
		
		// A try and except is used here to catch if readLine() errors (null)
                try {
                    for (int i = 0; i < strTemp.length; i++) {
                        strTemp[i] = readDeb; // set each element of the temporary array as the line read by the bufferedReader
                        readDeb = brDeb.readLine(); // move onto the next line 
                    }
                } catch (Exception e) { // if it runs out of lines
                    boolRunning = false; // Make sure the boolean is set as false so that the loop stops running 
                } 
		
		double dblBalance = Double.parseDouble(strTemp[5]); 
				
		// add to the debit card list using the values we found in the for loop, and have saved in the array
                // most of the values are string, but some like the CVV and Balance have to be in short/long form as they are numbers
                listDebitCards.add(new DebitCard(strTemp[0], strTemp[1], strTemp[2], strTemp[3], Short.parseShort(strTemp[4]), df.format(dblBalance)));
	    }
        
        } catch (IOException | NumberFormatException e) {}
	
	// SECOND PART: Add all of these values to the GUI using buttons 
	// Do this using switch statement to know which cards to enable 
	switch(listCreditCards.size()) {
	    case 0:
		break; // Do nothing; nothing is enabled 
	    case 1: 
		btnCredit1.setEnabled(true);
		btnCredit1.setText("View/Edit Credit Card #1");
		
		break; 
	    case 2: 
		btnCredit1.setEnabled(true);
		btnCredit1.setText("View/Edit Credit Card #1");
		
		btnCredit2.setEnabled(true);
		btnCredit2.setText("View/Edit Credit Card #2");
		
		break; 
	    case 3: 
		btnCredit1.setEnabled(true);
		btnCredit1.setText("View/Edit Credit Card #1");
		
		btnCredit2.setEnabled(true);
		btnCredit2.setText("View/Edit Credit Card #2");
		
		btnCredit3.setEnabled(true);
		btnCredit3.setText("View/Edit Credit Card #3");
		
		break; 
	}
	
	switch(listDebitCards.size()) {
	    case 0:
		break; // Do nothing; nothing is enabled 
	    case 1: 
		btnDebit1.setEnabled(true);
		btnDebit1.setText("View/Edit Debit Card #1");
		
		break; 
	    case 2: 
		btnDebit1.setEnabled(true);
		btnDebit1.setText("View/Edit Debit Card #1");
		
		btnDebit2.setEnabled(true);
		btnDebit2.setText("View/Edit Debit Card #2");
		
		break; 
	    case 3: 
		btnDebit1.setEnabled(true);
		btnDebit1.setText("View/Edit Debit Card #1");
		
		btnDebit2.setEnabled(true);
		btnDebit2.setText("View/Edit Debit Card #2");
		
		btnDebit3.setEnabled(true);
		btnDebit3.setText("View/Edit Debit Card #3");
		
		break; 
	} 
	
    }
    
    public CardsManager() {
	
	initComponents(); // generated UI initializer
	
	// First, try creating the files to hold it if they do not currently exist
        // The reason why this is here and not in the addCards() function is because of efficiency. 
        // This only has to run once per program, whereas the addCards() function will be run multiple times. 
	try {
	    // If the files exist, it will initialize readers for it. 
	    // If they do not exist, it will throw an error. 
	    // That is why it is in a try and catch block, if it errors, it will create the files! 
	    BufferedReader br1 = new BufferedReader(new FileReader("Credit Cards.txt")); 
	    BufferedReader br2 = new BufferedReader(new FileReader("Debit Cards.txt")); 
	    
	} catch (IOException e) { // If it fails to create a fileWritter object for either file, throw an eror 
	    try { // Try and catch required for IOException 
		FileWriter fwCred = new FileWriter("Credit Cards.txt");
		// close the fileWritter objects to save memory
		fwCred.close(); 

		FileWriter fwDeb = new FileWriter("Debit Cards.txt"); 
		// close the fileWritter objects to save memory
		fwDeb.close(); 
	    } catch (IOException d){}
	}
	
	// Run the method to add the cards to a global arrayList, as well as print them on the GUI for the user to view, edit, or delete.
        addCards(); 
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlBackground = new javax.swing.JPanel();
        lblTitle = new javax.swing.JLabel();
        btnAddCard = new javax.swing.JButton();
        lblHeader = new javax.swing.JLabel();
        btnCredit3 = new javax.swing.JButton();
        btnCredit1 = new javax.swing.JButton();
        btnCredit2 = new javax.swing.JButton();
        btnDebit3 = new javax.swing.JButton();
        btnDebit2 = new javax.swing.JButton();
        btnDebit1 = new javax.swing.JButton();
        lblCreditTitle = new javax.swing.JLabel();
        lblDebitTitle = new javax.swing.JLabel();
        lblDisplayError = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnlBackground.setBackground(new java.awt.Color(153, 153, 255));
        pnlBackground.setPreferredSize(new java.awt.Dimension(914, 578));

        lblTitle.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 36)); // NOI18N
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle.setText("Cards Manager");

        btnAddCard.setBackground(new java.awt.Color(153, 153, 255));
        btnAddCard.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        btnAddCard.setText("Add A New Card!");
        btnAddCard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddCardActionPerformed(evt);
            }
        });

        lblHeader.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        lblHeader.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHeader.setText("* You can have a maximum of 3 credit cards, and 3 debit cards! *");

        btnCredit3.setText("No Card Entered");
        btnCredit3.setEnabled(false);
        btnCredit3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCredit3ActionPerformed(evt);
            }
        });

        btnCredit1.setText("No Card Entered");
        btnCredit1.setEnabled(false);
        btnCredit1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCredit1ActionPerformed(evt);
            }
        });

        btnCredit2.setText("No Card Entered");
        btnCredit2.setEnabled(false);
        btnCredit2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCredit2ActionPerformed(evt);
            }
        });

        btnDebit3.setText("No Card Entered");
        btnDebit3.setEnabled(false);
        btnDebit3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDebit3ActionPerformed(evt);
            }
        });

        btnDebit2.setText("No Card Entered");
        btnDebit2.setEnabled(false);
        btnDebit2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDebit2ActionPerformed(evt);
            }
        });

        btnDebit1.setText("No Card Entered");
        btnDebit1.setEnabled(false);
        btnDebit1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDebit1ActionPerformed(evt);
            }
        });

        lblCreditTitle.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        lblCreditTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCreditTitle.setText("Credit Cards:");

        lblDebitTitle.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        lblDebitTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDebitTitle.setText("Debit Cards:");

        lblDisplayError.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        lblDisplayError.setForeground(new java.awt.Color(204, 0, 0));
        lblDisplayError.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDisplayError.setToolTipText("");

        javax.swing.GroupLayout pnlBackgroundLayout = new javax.swing.GroupLayout(pnlBackground);
        pnlBackground.setLayout(pnlBackgroundLayout);
        pnlBackgroundLayout.setHorizontalGroup(
            pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBackgroundLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTitle)
                .addGap(99, 99, 99)
                .addComponent(btnAddCard, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49))
            .addComponent(lblHeader, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnlBackgroundLayout.createSequentialGroup()
                .addGap(124, 124, 124)
                .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnCredit2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCredit1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCredit3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblCreditTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 238, Short.MAX_VALUE)
                .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnDebit2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDebit1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDebit3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDebitTitle, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(100, 100, 100))
            .addGroup(pnlBackgroundLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(lblDisplayError, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
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
                        .addComponent(btnAddCard)))
                .addGap(18, 18, 18)
                .addComponent(lblHeader)
                .addGap(18, 18, 18)
                .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCreditTitle)
                    .addComponent(lblDebitTitle))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCredit1, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDebit1, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCredit2, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDebit2, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCredit3, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDebit3, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(lblDisplayError)
                .addGap(12, 12, 12))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlBackground, javax.swing.GroupLayout.DEFAULT_SIZE, 930, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlBackground, javax.swing.GroupLayout.DEFAULT_SIZE, 641, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddCardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddCardActionPerformed
        // Clear the textspace of errors 
	lblDisplayError.setText(""); 

	// If there are NOT 3 credit, and 3 debit cards, you are allowed to add a card. 
	// This is just because of the limit we added for the application. 
	if (listCreditCards.size() + listDebitCards.size() < 6) {
	    this.dispose(); // Dispose the current screen (The Cards Manager) 

	    // Create a new object the screen (JFrame class) we are going to display 
	    AddCard screen = new AddCard(); 
	    screen.setVisible(true); // Make the screen visible
	} else {
	    lblDisplayError.setText("Cannot add card: You have already reached the maximum amount!"); 
	}
    }//GEN-LAST:event_btnAddCardActionPerformed

    private void btnCredit1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCredit1ActionPerformed
	// First, remove the current screen
	this.dispose(); 
	
	// Now, create an object of the screen we are going to show 
	EditCard screen = new EditCard(); 
	
	// Set the text/details on the card on this screen by using the object we had just created
	screen.txtName.setText(listCreditCards.get(0).getName()); 
	screen.txtBank.setText(listCreditCards.get(0).getBank());
	screen.txtNumber.setText(listCreditCards.get(0).getNumber());
	screen.txtDate.setText(listCreditCards.get(0).getExpiry()); 
	screen.txtCVV.setText(String.valueOf(listCreditCards.get(0).getCVV())); 
	screen.txtBalance.setText("$" + String.valueOf(listCreditCards.get(0).getLimit())); 
	screen.txtCardType.setText("Credit Card");
	screen.boolCredit = true; 
	screen.bytCard = 0; 
	
	// go to the next screen
	screen.setVisible(true);
    }//GEN-LAST:event_btnCredit1ActionPerformed

    private void btnCredit2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCredit2ActionPerformed
        // First, remove the current screen
	this.dispose(); 
	
	// Now, create an object of the screen we are going to show 
	EditCard screen = new EditCard(); 
	
	// Set the text/details on the card on this screen by using the object we had just created
	screen.txtName.setText(listCreditCards.get(1).getName()); 
	screen.txtBank.setText(listCreditCards.get(1).getBank());
	screen.txtNumber.setText(listCreditCards.get(1).getNumber());
	screen.txtDate.setText(listCreditCards.get(1).getExpiry()); 
	screen.txtCVV.setText(String.valueOf(listCreditCards.get(1).getCVV())); 
	screen.txtBalance.setText("$" + String.valueOf(listCreditCards.get(1).getLimit())); 
	screen.txtCardType.setText("Credit Card");
	screen.boolCredit = true; 
	screen.bytCard = 1; 
	
	// go to the next screen
	screen.setVisible(true);
    }//GEN-LAST:event_btnCredit2ActionPerformed

    private void btnCredit3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCredit3ActionPerformed
        // First, remove the current screen
	this.dispose(); 
	
	// Now, create an object of the screen we are going to show 
	EditCard screen = new EditCard(); 
	
	// Set the text/details on the card on this screen by using the object we had just created
	screen.txtName.setText(listCreditCards.get(2).getName()); 
	screen.txtBank.setText(listCreditCards.get(2).getBank());
	screen.txtNumber.setText(listCreditCards.get(2).getNumber());
	screen.txtDate.setText(listCreditCards.get(2).getExpiry()); 
	screen.txtCVV.setText(String.valueOf(listCreditCards.get(2).getCVV())); 
	screen.txtBalance.setText("$" + String.valueOf(listCreditCards.get(2).getLimit())); 
	screen.txtCardType.setText("Credit Card");
	screen.boolCredit = true; 
	screen.bytCard = 2; 
	
	// go to the next screen
	screen.setVisible(true);
    }//GEN-LAST:event_btnCredit3ActionPerformed

    private void btnDebit1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDebit1ActionPerformed
        // First, remove the current screen
	this.dispose(); 
	
	// Now, create an object of the screen we are going to show 
	EditCard screen = new EditCard(); 
	
	// Set the text/details on the card on this screen by using the object we had just created
	screen.txtName.setText(listDebitCards.get(0).getName()); 
	screen.txtBank.setText(listDebitCards.get(0).getBank());
	screen.txtNumber.setText(listDebitCards.get(0).getNumber());
	screen.txtDate.setText(listDebitCards.get(0).getExpiry()); 
	screen.txtCVV.setText(String.valueOf(listDebitCards.get(0).getCVV())); 
	screen.txtBalance.setText("$" + String.valueOf(listDebitCards.get(0).getBalance())); 
	screen.txtCardType.setText("Credit Card");
	screen.boolCredit = false; 
	screen.bytCard = 0; 
	
	// go to the next screen
	screen.setVisible(true);
    }//GEN-LAST:event_btnDebit1ActionPerformed

    private void btnDebit2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDebit2ActionPerformed
        // First, remove the current screen
	this.dispose(); 
	
	// Now, create an object of the screen we are going to show 
	EditCard screen = new EditCard(); 
	
	// Set the text/details on the card on this screen by using the object we had just created
	screen.txtName.setText(listDebitCards.get(1).getName()); 
	screen.txtBank.setText(listDebitCards.get(1).getBank());
	screen.txtNumber.setText(listDebitCards.get(1).getNumber());
	screen.txtDate.setText(listDebitCards.get(1).getExpiry()); 
	screen.txtCVV.setText(String.valueOf(listDebitCards.get(1).getCVV())); 
	screen.txtBalance.setText("$" + String.valueOf(listDebitCards.get(1).getBalance())); 
	screen.txtCardType.setText("Credit Card");
	screen.boolCredit = false; 
	screen.bytCard = 1; 
	
	// go to the next screen
	screen.setVisible(true);
    }//GEN-LAST:event_btnDebit2ActionPerformed

    private void btnDebit3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDebit3ActionPerformed
        // First, remove the current screen
	this.dispose(); 
	
	// Now, create an object of the screen we are going to show 
	EditCard screen = new EditCard(); 
	
	// Set the text/details on the card on this screen by using the object we had just created
	screen.txtName.setText(listDebitCards.get(2).getName()); 
	screen.txtBank.setText(listDebitCards.get(2).getBank());
	screen.txtNumber.setText(listDebitCards.get(2).getNumber());
	screen.txtDate.setText(listDebitCards.get(2).getExpiry()); 
	screen.txtCVV.setText(String.valueOf(listDebitCards.get(2).getCVV())); 
	screen.txtBalance.setText("$" + String.valueOf(listDebitCards.get(2).getBalance())); 
	screen.txtCardType.setText("Credit Card");
	screen.boolCredit = false; 
	screen.bytCard = 2; 
	
	// go to the next screen
	screen.setVisible(true);
    }//GEN-LAST:event_btnDebit3ActionPerformed

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
	java.awt.EventQueue.invokeLater(() -> new CardsManager().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddCard;
    private javax.swing.JButton btnCredit1;
    private javax.swing.JButton btnCredit2;
    private javax.swing.JButton btnCredit3;
    private javax.swing.JButton btnDebit1;
    private javax.swing.JButton btnDebit2;
    private javax.swing.JButton btnDebit3;
    private javax.swing.JLabel lblCreditTitle;
    private javax.swing.JLabel lblDebitTitle;
    private javax.swing.JLabel lblDisplayError;
    private javax.swing.JLabel lblHeader;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JPanel pnlBackground;
    // End of variables declaration//GEN-END:variables
}
