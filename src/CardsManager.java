// here are the classes we will be importing for the application 
import java.io.*; // for file reading and writing 
import java.util.*; // mostly for arrayList 
import java.text.DecimalFormat; // for rounding 

public class CardsManager extends javax.swing.JFrame {   
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(CardsManager.class.getName());

    // create a list for cards
    static ArrayList<CreditCard> listCreditCards = new ArrayList<>(); 
    static ArrayList<DebitCard> listDebitCards = new ArrayList<>();
    
    // Create a method to edit the cards on screen
    public void addCards() {
        
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
                
                // add to the credit card list using the values we found in the for loop, and have saved in the array
                // most of the values are string, but some like the CVV and Balance have to be in short/long form as they are numbers
                listCreditCards.add(new CreditCard(strTemp[0], strTemp[1], strTemp[2], strTemp[3], Short.parseShort(strTemp[4]), Double.parseDouble(strTemp[5])));
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
		
		// add to the debit card list using the values we found in the for loop, and have saved in the array
                // most of the values are string, but some like the CVV and Balance have to be in short/long form as they are numbers
                listDebitCards.add(new DebitCard(strTemp[0], strTemp[1], strTemp[2], strTemp[3], Short.parseShort(strTemp[4]), Double.parseDouble(strTemp[5])));
	    }
            
        
        } catch (Exception e) {}
	
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
	// First, try creating the files to hold it if they do not currently exist
        // The reason why this is here and not in the addCards() function is because of efficiency. 
        // This only has to run once per program, whereas the addCards() function will be run multiple times. 
	try {
	    BufferedReader br1 = new BufferedReader(new FileReader("Credit Cards.txt")); 
	    BufferedReader br2 = new BufferedReader(new FileReader("Credit Cards.txt")); 
	    
	    // Check to see if the files are empty/null, if they aren't don't change them. 
	    if (br1.readLine() == null) { 
		FileWriter fwCred = new FileWriter("Credit Cards.txt");
		
		// close the fileWritter objects to save memory
		fwCred.close(); 
	    }
	    
	    if (br1.readLine() == null) { 
		FileWriter fwDeb = new FileWriter("Debit Cards.txt"); 
		fwDeb.close(); 
	    } 
            
	    // close the readers to save memory
	    br1.close(); 
	    br2.close(); 
	    
	    // Make the files read-only so they cannot be edited by the user 
	    File fileCredit = new File("Credit Cards.txt"); 
	    File fileDebit = new File("Debit Cards.txt");
	    fileCredit.setReadOnly();
	    fileDebit.setReadOnly(); 
            
	} catch (Exception e) { // If it fails to create a fileWritter object for either file, throw an eror 
            lblDisplayError.setText("ERROR: Error reading/writting files, please restart application!"); 
        }
        
	initComponents(); // generated UI initializer
	
	// Run the method to add the cards to a global arrayList, as well as print them on the GUI for the user to view, edit, or delete.
        addCards(); 
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        btnCredit3 = new javax.swing.JButton();
        btnCredit1 = new javax.swing.JButton();
        btnCredit2 = new javax.swing.JButton();
        btnDebit3 = new javax.swing.JButton();
        btnDebit2 = new javax.swing.JButton();
        btnDebit1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblDisplayError = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 153, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(914, 578));

        jLabel1.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Cards Manager");

        jButton1.setBackground(new java.awt.Color(153, 153, 255));
        jButton1.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        jButton1.setText("Add A New Card!");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("* You can have a maximum of 3 credit cards, and 3 debit cards! *");

        btnCredit3.setText("No Card Entered");
        btnCredit3.setEnabled(false);

        btnCredit1.setText("No Card Entered");
        btnCredit1.setEnabled(false);
        btnCredit1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCredit1ActionPerformed(evt);
            }
        });

        btnCredit2.setText("No Card Entered");
        btnCredit2.setEnabled(false);

        btnDebit3.setText("No Card Entered");
        btnDebit3.setEnabled(false);

        btnDebit2.setText("No Card Entered");
        btnDebit2.setEnabled(false);

        btnDebit1.setText("No Card Entered");
        btnDebit1.setEnabled(false);

        jLabel3.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Credit Cards:");

        jLabel4.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Debit Cards:");

        lblDisplayError.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        lblDisplayError.setForeground(new java.awt.Color(204, 0, 0));
        lblDisplayError.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDisplayError.setText("this textspace will hold errors");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(99, 99, 99)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49))
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(124, 124, 124)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnCredit2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCredit1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCredit3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 238, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnDebit2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDebit1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDebit3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(100, 100, 100))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(lblDisplayError, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jLabel1))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton1)))
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCredit1, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDebit1, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCredit2, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDebit2, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
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
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 930, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 641, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnCredit1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCredit1ActionPerformed
        btnDebit3.setVisible(true); 
    }//GEN-LAST:event_btnCredit1ActionPerformed

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
    private javax.swing.JButton btnCredit1;
    private javax.swing.JButton btnCredit2;
    private javax.swing.JButton btnCredit3;
    private javax.swing.JButton btnDebit1;
    private javax.swing.JButton btnDebit2;
    private javax.swing.JButton btnDebit3;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblDisplayError;
    // End of variables declaration//GEN-END:variables
}
