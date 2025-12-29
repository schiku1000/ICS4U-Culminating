import java.io.*; // Required for reading and writting to the file 

public class EditCard extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(CardsManager.class.getName());

    public EditCard() {
	initComponents();
    }
    
    // This boolean will hold whether the card currently being edited is a credit card or a debit card. 
    // If it is true, it is a credit card, and if it's false, it is a debit card 
    boolean boolCredit;
    
    // This byte character will hold which card it is 
    // E.g. Credit Card #2 would have 2 saved here. 
    byte bytCard; 
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlBackground = new javax.swing.JPanel();
        lblTitle = new javax.swing.JLabel();
        btnSave = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        lblName = new javax.swing.JLabel();
        lblType = new javax.swing.JLabel();
        lblBank = new javax.swing.JLabel();
        txtBank = new javax.swing.JTextField();
        txtName = new javax.swing.JTextField();
        lblNumber = new javax.swing.JLabel();
        lblDate = new javax.swing.JLabel();
        lblCVV = new javax.swing.JLabel();
        txtNumber = new javax.swing.JTextField();
        txtDate = new javax.swing.JTextField();
        txtCVV = new javax.swing.JTextField();
        txtCardType = new javax.swing.JTextField();
        btnDelete = new javax.swing.JButton();
        lblDisplayOut = new javax.swing.JLabel();
        lblDetailHeader = new javax.swing.JLabel();
        lblBalanceEdit = new javax.swing.JLabel();
        lblCurrent = new javax.swing.JLabel();
        txtBalance = new javax.swing.JTextField();
        lblAdd = new javax.swing.JLabel();
        lblRemove = new javax.swing.JLabel();
        txtAdd = new javax.swing.JTextField();
        txtRemove = new javax.swing.JTextField();
        lblNewTitle = new javax.swing.JLabel();
        txtNewBalance = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnlBackground.setBackground(new java.awt.Color(153, 153, 255));

        lblTitle.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 36)); // NOI18N
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle.setText("Edit/View Card");

        btnSave.setBackground(new java.awt.Color(153, 153, 255));
        btnSave.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        btnSave.setText("Save Changes");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

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

        lblType.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        lblType.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblType.setText("Card Type:");

        lblBank.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        lblBank.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblBank.setText("Card Issuer (Bank Affiliated):");

        txtBank.setEditable(false);
        txtBank.setBackground(new java.awt.Color(153, 153, 255));

        txtName.setEditable(false);
        txtName.setBackground(new java.awt.Color(153, 153, 255));

        lblNumber.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        lblNumber.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblNumber.setText("Card Number:");

        lblDate.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        lblDate.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblDate.setText("Expiry Date (FORMAT: MM/YY):");

        lblCVV.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        lblCVV.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblCVV.setText("CVV:");

        txtNumber.setEditable(false);
        txtNumber.setBackground(new java.awt.Color(153, 153, 255));

        txtDate.setEditable(false);
        txtDate.setBackground(new java.awt.Color(153, 153, 255));

        txtCVV.setEditable(false);
        txtCVV.setBackground(new java.awt.Color(153, 153, 255));

        txtCardType.setEditable(false);
        txtCardType.setBackground(new java.awt.Color(153, 153, 255));

        btnDelete.setBackground(new java.awt.Color(153, 153, 255));
        btnDelete.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        btnDelete.setText("Delete Card (CANNOT UNDO)");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        lblDisplayOut.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        lblDisplayOut.setForeground(new java.awt.Color(153, 102, 0));
        lblDisplayOut.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        lblDetailHeader.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 24)); // NOI18N
        lblDetailHeader.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDetailHeader.setText("Card Details:");

        lblBalanceEdit.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 24)); // NOI18N
        lblBalanceEdit.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblBalanceEdit.setText("Edit Balance/Credit Limit:");

        lblCurrent.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        lblCurrent.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCurrent.setText("Current Balance:/Limit");

        txtBalance.setEditable(false);
        txtBalance.setBackground(new java.awt.Color(153, 153, 255));

        lblAdd.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        lblAdd.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAdd.setText("Add to Balance/Limit:");

        lblRemove.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        lblRemove.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblRemove.setText("Remove from Balance/Limit:");

        txtAdd.setBackground(new java.awt.Color(153, 153, 255));

        txtRemove.setBackground(new java.awt.Color(153, 153, 255));

        lblNewTitle.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        lblNewTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNewTitle.setText("New Balance/Limit:");

        txtNewBalance.setEditable(false);
        txtNewBalance.setBackground(new java.awt.Color(153, 153, 255));

        javax.swing.GroupLayout pnlBackgroundLayout = new javax.swing.GroupLayout(pnlBackground);
        pnlBackground.setLayout(pnlBackgroundLayout);
        pnlBackgroundLayout.setHorizontalGroup(
            pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnlBackgroundLayout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblBank)
                    .addComponent(lblType)
                    .addComponent(lblNumber)
                    .addComponent(lblDate)
                    .addComponent(lblCVV)
                    .addComponent(lblName))
                .addGap(18, 18, 18)
                .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlBackgroundLayout.createSequentialGroup()
                        .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(pnlBackgroundLayout.createSequentialGroup()
                                .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblCurrent))
                            .addGroup(pnlBackgroundLayout.createSequentialGroup()
                                .addComponent(txtCardType, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtBalance, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(73, 73, 73))
                    .addGroup(pnlBackgroundLayout.createSequentialGroup()
                        .addComponent(txtDate, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(128, 128, 128))
                    .addGroup(pnlBackgroundLayout.createSequentialGroup()
                        .addComponent(txtCVV, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnDelete)
                        .addGap(97, 97, 97))
                    .addGroup(pnlBackgroundLayout.createSequentialGroup()
                        .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtBank, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBackgroundLayout.createSequentialGroup()
                                .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(pnlBackgroundLayout.createSequentialGroup()
                                        .addComponent(lblAdd)
                                        .addGap(16, 16, 16))
                                    .addGroup(pnlBackgroundLayout.createSequentialGroup()
                                        .addGap(16, 16, 16)
                                        .addComponent(txtAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(56, 56, 56)
                                .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lblRemove, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtRemove, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(19, 19, 19))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBackgroundLayout.createSequentialGroup()
                                .addComponent(lblNewTitle)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNewBalance, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(36, 36, 36))))))
            .addGroup(pnlBackgroundLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(lblDetailHeader, javax.swing.GroupLayout.PREFERRED_SIZE, 433, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblBalanceEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 433, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 6, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBackgroundLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblDisplayOut, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(pnlBackgroundLayout.createSequentialGroup()
                .addGap(372, 372, 372)
                .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlBackgroundLayout.setVerticalGroup(
            pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBackgroundLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(lblTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlBackgroundLayout.createSequentialGroup()
                        .addComponent(lblDetailHeader)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblName)
                            .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCardType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblType))
                        .addGap(18, 18, 18)
                        .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblBank)
                            .addComponent(txtBank, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblNumber)
                            .addComponent(txtNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblDate)
                            .addComponent(txtDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCVV)
                            .addComponent(txtCVV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pnlBackgroundLayout.createSequentialGroup()
                        .addComponent(lblBalanceEdit)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCurrent)
                            .addComponent(txtBalance, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(pnlBackgroundLayout.createSequentialGroup()
                                .addComponent(lblAdd)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtAdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlBackgroundLayout.createSequentialGroup()
                                .addComponent(lblRemove)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtRemove, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                        .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblNewTitle)
                            .addComponent(txtNewBalance, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(btnSave)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDelete)
                        .addGap(77, 77, 77)))
                .addComponent(btnBack)
                .addGap(18, 18, 18)
                .addComponent(lblDisplayOut)
                .addGap(11, 11, 11))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlBackground, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlBackground, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // When the back button is clicked, go back to the main screen (Cards Manager) 
	this.dispose(); // dispose the current screen
	
	// Create a new object for the class
	CardsManager screen = new CardsManager(); 
	screen.setVisible(true);
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // Use the boolean we saved earlier to know whether to delete from credit card or debit card list 
	if (boolCredit) {
	    // Since the list is static, we can directly access it using the class name 
	    CardsManager.listCreditCards.remove(bytCard);
	 
	    // Now that it is removed from the list, rewrite the file without it 
	    try {
		// Clear the file, then write to it: 
		FileWriter fwCred = new FileWriter("Credit Cards.txt");
		for (int i = 0; i < CardsManager.listCreditCards.size(); i++) {
		    fwCred.write(CardsManager.listCreditCards.get(i).toString());
		}
		
		fwCred.close(); // close the writter to prevent data loss and memory leaks
		
	    } catch (IOException e) {}
	} else {
	    // Since the list is static, we can directly access it using the class name 
	    CardsManager.listDebitCards.remove(bytCard);
	 
	    // Now that it is removed from the list, rewrite the file without it 
	    try {
		// Clear the file, then write to it: 
		FileWriter fwDeb = new FileWriter("Debit Cards.txt");
		for (int i = 0; i < CardsManager.listDebitCards.size(); i++) {
		    fwDeb.write(CardsManager.listDebitCards.get(i).toString());
		}
		
		fwDeb.close(); // close the writter to prevent data loss and memory leaks
		
	    } catch (IOException e) {}
	}
    }//GEN-LAST:event_btnDeleteActionPerformed

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
	java.awt.EventQueue.invokeLater(() -> new EditCard().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnSave;
    private javax.swing.JLabel lblAdd;
    private javax.swing.JLabel lblBalanceEdit;
    private javax.swing.JLabel lblBank;
    private javax.swing.JLabel lblCVV;
    private javax.swing.JLabel lblCurrent;
    private javax.swing.JLabel lblDate;
    private javax.swing.JLabel lblDetailHeader;
    private javax.swing.JLabel lblDisplayOut;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblNewTitle;
    private javax.swing.JLabel lblNumber;
    private javax.swing.JLabel lblRemove;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblType;
    private javax.swing.JPanel pnlBackground;
    private javax.swing.JTextField txtAdd;
    javax.swing.JTextField txtBalance;
    javax.swing.JTextField txtBank;
    javax.swing.JTextField txtCVV;
    javax.swing.JTextField txtCardType;
    javax.swing.JTextField txtDate;
    javax.swing.JTextField txtName;
    private javax.swing.JTextField txtNewBalance;
    javax.swing.JTextField txtNumber;
    private javax.swing.JTextField txtRemove;
    // End of variables declaration//GEN-END:variables
}
