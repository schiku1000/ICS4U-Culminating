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
		String[] strTempCredit = new String[6]; 
                
                // A try and except is used here to catch if readLine() errors (null)
                try {
                    for (int i = 0; i < strTempCredit.length; i++) {
                        strTempCredit[i] = readCred; // set each element of the temporary array as the line read by the bufferedReader
                        readCred = brCred.readLine(); // move onto the next line 
                    }
                } catch (Exception e) { // if it runs out of lines
                    boolRunning = false; // Make sure the boolean is set as false so that the loop stops running 
                } 
                
                // add to the credit card list using the values we found in the for loop, and have saved in the array
                // most of the values are string, but some like the CVV and Balance have to be in short/long form as they are numbers
                listCreditCards.add(new CreditCard(strTempCredit[0], strTempCredit[1], strTempCredit[2], strTempCredit[3], Short.parseShort(strTempCredit[4]), Double.parseDouble(strTempCredit[5])));
            }
            
            brCred.close(); // close the reader
            
            // #2: Now do the same thing for the debit cards
            BufferedReader brDeb = new BufferedReader(new FileReader("Debit Cards.txt"));
            String readDeb = brDeb.readLine();
            
            
        
        } catch (Exception e) {}
    }
    
    public CardsManager() {
	// First, try creating the files to hold it if they do not currently exist
        // The reason why this is here and not in the addCards() function is because of efficiency. 
        // This only has to run once per program, whereas the addCards() function will be run multiple times. 
	try {
	    FileWriter fwCred = new FileWriter("Credit Cards.txt");
            FileWriter fwDeb = new FileWriter("Debit Cards.txt"); 
            
            // close the fileWritter objects to save memory
            fwCred.close(); 
            fwDeb.close(); 
	} catch (Exception e) { // If it fails to create a fileWritter object for either file, throw an eror 
            lblDisplayError.setText("ERROR: Error reading/writting files, please restart application!"); 
        }
        
        // Run the method to add the cards to a global arrayList, as well as print them on the GUI for the user to view, edit, or delete.
        addCards(); 
	initComponents();
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

        btnCredit3.setText("jButton2");

        btnCredit1.setText("jButton2");
        btnCredit1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCredit1ActionPerformed(evt);
            }
        });

        btnCredit2.setText("d");

        btnDebit3.setText("jButton2");
        btnDebit3.setEnabled(false);

        btnDebit2.setText("d");

        btnDebit1.setText("jButton2");

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
                .addGap(71, 71, 71)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(100, 100, 100))
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(152, 152, 152)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnCredit2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCredit1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCredit3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 116, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnDebit2, javax.swing.GroupLayout.DEFAULT_SIZE, 234, Short.MAX_VALUE)
                    .addComponent(btnDebit1, javax.swing.GroupLayout.DEFAULT_SIZE, 234, Short.MAX_VALUE)
                    .addComponent(btnDebit3, javax.swing.GroupLayout.DEFAULT_SIZE, 234, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(142, 142, 142))
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
                        .addGap(14, 14, 14)
                        .addComponent(jButton1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btnCredit1, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCredit2, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)
                        .addComponent(btnCredit3, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btnDebit1, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnDebit2, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)
                        .addComponent(btnDebit3, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(lblDisplayError)
                .addGap(12, 12, 12))
        );

        btnDebit3.setVisible(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
