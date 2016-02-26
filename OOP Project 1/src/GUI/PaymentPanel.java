
package GUI;

import Transactions.Invoice;
import Transactions.Payment;
import Transactions.Transaction;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;

/**
 *
 * @author Jose Ortiz Costa
 */
public class PaymentPanel extends javax.swing.JPanel {
    private PostGUI masterPost; //reference to the parent master GUI
    private InvoicePopUp popup;

    /**
     *  Only contains functionality used on the Payment Panel
     */
    public PaymentPanel(PostGUI _masterPost) {

        masterPost = _masterPost;
        popup = new InvoicePopUp();
        initComponents();
    }
    
    public int getPaymentType(){
        if(creditRadioBtn.isSelected()){
            return Payment.CREDIT;
        }else if(cashRadioBtn.isSelected()){
            return Payment.CASH;
        }else{
            return Payment.CHECK;
        }
    }
    
    public int getCreditCardNumber(){
        return Integer.parseInt(creditCardNumber.getText());
    }
    /**
     * <p>This method is invoked by the supposed 'PAY' button of this class.
     * It will create a Transaction and attempt to get an Invoice from the
     * StoreServer.</p>
     */
    private void paymentExecute(){
        
        try{
            Integer.parseInt(creditCardNumber.getText());
            Invoice invoice = new Invoice(masterPost.remoteVerifyTransaction(), masterPost.getStoreName());
            System.out.println("payment went through");
            
            //popup.display(invoice.toString()); //output invoice in pop up.
        } catch (NumberFormatException e) {

            JOptionPane.showMessageDialog(null,
                    "Invalid Credit Card Number",
                    "Payment Error",
                    JOptionPane.ERROR_MESSAGE);
        }
        
    }
    
    /**
     * <p>This is a nested inner class which purpose is to display the 
     * invoice/receipt in a pop up window. This first class extends JFrame, the
     * next extends JPanel, both of which combine and are only used in the 
     * PaymentPanel class. An instance of this class is used in the 
     * paymentExecute() method of PaymentPanel.</p>
     */
    public class InvoicePopUp extends javax.swing.JFrame{
        
        private InvoicePopUpPanel invoicePopUpPanel;
                
        public InvoicePopUp(){
            invoicePopUpPanel = new InvoicePopUpPanel();
            
            this.setTitle("Invoice");
            this.setDefaultCloseOperation(javax.swing.JFrame.DISPOSE_ON_CLOSE);
            this.setResizable(true);
            this.setLocationRelativeTo(null);
            this.setMinimumSize(new java.awt.Dimension(500, 350));
            this.setFocusable(false);
            this.setContentPane(invoicePopUpPanel);
            this.pack();
        }
        
        /**
	 * <p>Display the string that was passed in this method.</p>
	 * @param invoiceToPrint - string to display in the TextArea
	 */
	public void display(String invoiceToPrint){
            invoicePopUpPanel.setTextArea(invoiceToPrint);
            this.setVisible(true);
	}
        
        /**
         * <p>This class extends JPanel which is attached to InvoicePopUp.
         * It holds the text area of which the invoice/receipt is displayed.</p>
         */
        private class InvoicePopUpPanel extends javax.swing.JPanel{
            private javax.swing.JScrollPane invoiceScrollPane;
            private javax.swing.JTextArea invoiceTextArea;
            
            private InvoicePopUpPanel(){
                invoiceTextArea = new javax.swing.JTextArea();
                invoiceScrollPane = new javax.swing.JScrollPane();
                invoiceScrollPane.setViewportView(invoiceTextArea);
		invoiceTextArea.setEditable(false);
		invoiceTextArea.setFont(new java.awt.Font("Monospaced", java.awt.Font.PLAIN, 12));
                
		this.setLayout(new java.awt.BorderLayout());
                this.add(invoiceScrollPane, java.awt.BorderLayout.CENTER);
            }
            
            private void setTextArea(String text){
                invoiceTextArea.setText(text);
            }
        }
    }
    
    //This is for testing the InvoicePopUp only.
    /*
    public static void main(String[] args) throws java.rmi.RemoteException{
        javax.swing.JFrame dummyFrame = new javax.swing.JFrame();
        PaymentPanel paymentPanel = new PaymentPanel(new PostGUI());
        
        dummyFrame.setTitle("PaymentPanel Tester");
        dummyFrame.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        dummyFrame.setResizable(true);
        dummyFrame.setVisible(true);
        dummyFrame.setLocationRelativeTo(null);
        dummyFrame.setMinimumSize(new java.awt.Dimension(640, 480));
        dummyFrame.setFocusable(false);
        dummyFrame.setContentPane(paymentPanel);
        dummyFrame.pack();
        
        Transactions.Customer customer = new Transactions.Customer("John Doe");
        Transactions.Payment payment = new Transactions.Payment(Payment.CASH, 200.0);
        java.util.ArrayList<Catalog.Product> products = new java.util.ArrayList<Catalog.Product>();
        for(int i = 0; i < 30; i++){
            products.add(new Catalog.Product("1111", "air", 200.0));
        }
        Transaction transaction = new Transaction(customer, payment, products);
        Invoice invoiceTest = new Invoice(transaction,"WALLYMART");
        
        PaymentPanel.InvoicePopUp popup = paymentPanel.new InvoicePopUp();
        
        System.out.println(invoiceTest.toString());
        popup.display(invoiceTest.toString());
    }
    */
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        paymentType = new javax.swing.ButtonGroup();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jPanel1 = new javax.swing.JPanel();
        cashRadioBtn = new javax.swing.JRadioButton();
        checkRadioBtn = new javax.swing.JRadioButton();
        creditRadioBtn = new javax.swing.JRadioButton();
        jSeparator3 = new javax.swing.JSeparator();
        payBtn = new javax.swing.JButton();
        cardNumLabel = new javax.swing.JLabel();
        creditCardNumber = new javax.swing.JTextField();

        setPreferredSize(new java.awt.Dimension(721, 689));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "PAYMENT", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Sylfaen", 1, 20))); // NOI18N
        jPanel1.setToolTipText("Enter Your Credit Card number");
        jPanel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel1.setDoubleBuffered(false);

        paymentType.add(cashRadioBtn);
        cashRadioBtn.setText("Cash");
        cashRadioBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cashRadioBtnActionPerformed(evt);
                onCashSelect(evt);
            }
        });

        paymentType.add(checkRadioBtn);
        checkRadioBtn.setText("Check");
        checkRadioBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onCheckSelect(evt);
            }
        });

        paymentType.add(creditRadioBtn);
        creditRadioBtn.setSelected(true);
        creditRadioBtn.setText("Credit");
        creditRadioBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onCreditSelect(evt);
            }
        });

        jSeparator3.setOrientation(javax.swing.SwingConstants.VERTICAL);

        payBtn.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        payBtn.setForeground(new java.awt.Color(255, 0, 51));
        payBtn.setText("PAY");
        payBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                payBtnActionPerformed(evt);
            }
        });

        cardNumLabel.setText("Card Number (numbers Only)");

        creditCardNumber.setToolTipText("card num");
        creditCardNumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                creditCardNumberActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cashRadioBtn)
                .addGap(53, 53, 53)
                .addComponent(checkRadioBtn)
                .addGap(54, 54, 54)
                .addComponent(creditRadioBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cardNumLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(creditCardNumber))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(payBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator3)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(cardNumLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(cashRadioBtn)
                                    .addComponent(checkRadioBtn)
                                    .addComponent(creditRadioBtn)
                                    .addComponent(creditCardNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(payBtn)))
                        .addGap(0, 25, Short.MAX_VALUE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator2)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jSeparator1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cashRadioBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cashRadioBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cashRadioBtnActionPerformed

    private void payBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_payBtnActionPerformed
        paymentExecute();
    }//GEN-LAST:event_payBtnActionPerformed

    private void onCreditSelect(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_onCreditSelect
        if(!creditCardNumber.isEnabled()){
            creditCardNumber.setEnabled(true);
        }

    }//GEN-LAST:event_onCreditSelect

    private void onCheckSelect(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_onCheckSelect
        if(creditCardNumber.isEnabled()){
            creditCardNumber.setEnabled(false);
        }
    }//GEN-LAST:event_onCheckSelect

    private void onCashSelect(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_onCashSelect
        if(creditCardNumber.isEnabled()){
            creditCardNumber.setEnabled(false);
        }
    }//GEN-LAST:event_onCashSelect

    private void creditCardNumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_creditCardNumberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_creditCardNumberActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel cardNumLabel;
    private javax.swing.JRadioButton cashRadioBtn;
    private javax.swing.JRadioButton checkRadioBtn;
    private javax.swing.JTextField creditCardNumber;
    private javax.swing.JRadioButton creditRadioBtn;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JButton payBtn;
    private javax.swing.ButtonGroup paymentType;
    // End of variables declaration//GEN-END:variables
}
