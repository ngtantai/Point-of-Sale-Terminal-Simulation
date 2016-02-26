
package GUI;

import Transactions.Invoice;
import Transactions.Transaction;

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
    
    /**
     * <p>This method is invoked by the supposed 'PAY' button of this class.
     * It will create a Transaction and attempt to get an Invoice from the
     * StoreServer.</p>
     */
    private void paymentExecute(){
        
        //TODO: Get the CartPanel product list.
        //TODO: Get the Customer instance from CustomerInfoPanel.
        
        //ArrayList<Product> products; //retrieved from CartPanel
        //Customer customer;      //retrieved from CustomerInfoPanel
        //Payment payment;        //information is here in this class.
        
        
        //Transaction transaction;
        //Invoice invoice;
        //Server.StoreServer storeServer;    //for the purposes of testing
        
        //TODO: comment out this line below later.
        popup.display("PRINT INVOICE STRING HERE");
    }
    
    /**
     * <p>This is a nested inner class which purpose is to display the 
     * invoice/receipt in a pop up window. This first class extends JFrame, the
     * next extends JPanel, both of which combine and are only used in the 
     * PaymentPanel class. An instance of this class is used in the 
     * paymentExecute() method of PaymentPanel.</p>
     */
    private class InvoicePopUp extends javax.swing.JFrame{
        
        private InvoicePopUpPanel invoicePopUpPanel;
                
        private InvoicePopUp(){
            invoicePopUpPanel = new InvoicePopUpPanel();
            
            this.setTitle("Invoice");
            this.setDefaultCloseOperation(javax.swing.JFrame.DISPOSE_ON_CLOSE);
            this.setResizable(true);
            this.setLocationRelativeTo(null);
            this.setMinimumSize(new java.awt.Dimension(300, 480));
            this.setFocusable(false);
            this.setContentPane(invoicePopUpPanel);
            this.pack();
        }
        
        /**
	 * <p>Display the string that was passed in this constructor.</p>
	 * @param invoiceToPrint - string to display in the TextArea
	 */
	private void display(String invoiceToPrint){
            invoicePopUpPanel.setTextArea(invoiceToPrint);
            this.setVisible(true);
	}
        
        /**
         * <p>This class extends JPanel which is attached to InvoicePopUp.
         * It holds the text area of which the invoice/receipt is displayed.</p>
         */
        private class InvoicePopUpPanel extends javax.swing.JPanel{
            
            private javax.swing.JTextArea invoiceTextArea;
            
            private InvoicePopUpPanel(){
                invoiceTextArea = new javax.swing.JTextArea();
		invoiceTextArea.setEditable(false);
		
		this.setLayout(new java.awt.BorderLayout());
		this.add(invoiceTextArea, java.awt.BorderLayout.CENTER);
            }
            
            private void setTextArea(String text){
                invoiceTextArea.setText(text);
            }
        }
    }
    
    //This is for testing PaymentPanel only. Run and click the PAY button.
    /*
    public static void main(String[] args){
        javax.swing.JFrame dummyFrame = new javax.swing.JFrame();
        PaymentPanel paymentPanel = new PaymentPanel();
        
        dummyFrame.setTitle("PaymentPanel Tester");
        dummyFrame.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        dummyFrame.setResizable(true);
        dummyFrame.setVisible(true);
        dummyFrame.setLocationRelativeTo(null);
        dummyFrame.setMinimumSize(new java.awt.Dimension(640, 480));
        dummyFrame.setFocusable(false);
        dummyFrame.setContentPane(paymentPanel);
        dummyFrame.pack();
        
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

        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jPanel1 = new javax.swing.JPanel();
        cashRadioBtn = new javax.swing.JRadioButton();
        checkRadioBtn = new javax.swing.JRadioButton();
        creditRadioBtn = new javax.swing.JRadioButton();
        jSeparator3 = new javax.swing.JSeparator();
        payBtn = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(721, 689));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "PAYMENT", 0, 0, new java.awt.Font("Sylfaen", 1, 20))); // NOI18N

        cashRadioBtn.setText("Cash");
        cashRadioBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cashRadioBtnActionPerformed(evt);
            }
        });

        checkRadioBtn.setText("Check");

        creditRadioBtn.setSelected(true);
        creditRadioBtn.setText("Credit");

        jSeparator3.setOrientation(javax.swing.SwingConstants.VERTICAL);

        payBtn.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        payBtn.setForeground(new java.awt.Color(255, 0, 51));
        payBtn.setText("PAY");
        payBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                payBtnActionPerformed(evt);
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
                .addGap(96, 96, 96)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(payBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(68, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator3)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(cashRadioBtn)
                                    .addComponent(checkRadioBtn)
                                    .addComponent(creditRadioBtn)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(payBtn)))
                        .addGap(0, 27, Short.MAX_VALUE)))
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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton cashRadioBtn;
    private javax.swing.JRadioButton checkRadioBtn;
    private javax.swing.JRadioButton creditRadioBtn;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JButton payBtn;
    // End of variables declaration//GEN-END:variables
}
