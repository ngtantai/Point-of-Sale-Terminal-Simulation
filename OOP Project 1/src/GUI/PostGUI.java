package GUI;

import Catalog.Product;
import Catalog.Stock;
import RMI.Client;
import RMI.ServerInterface;
import Transactions.Customer;
import Transactions.Invoice;
import Transactions.Payment;
import Transactions.Transaction;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Jose Ortiz This class contains the logic to arrange all the panels
 * around the frame and show them in screen. No other logic need to be added to
 * this class. All the functionality logic goes inside the panels class
 * importing the correct packages.
 */
public class PostGUI extends javax.swing.JFrame {
    Stock localCatalog;
    CustomerInfoPanel customerInfoPanel;
    InventoryPanel inventoryPanel;
    PaymentPanel paymentPanel;
    CartPanel cartPanel;
    ServerInterface si;
    public String storeName;
    static int productSelected = 0;
    
    final int CONNECTION = 0;
    final int VALITADION = 1;

    /**
     * Creates new form PostGUI
     */
    public PostGUI() throws RemoteException {
        connect();
        localCatalog = si.getCatalog();
        initPanels();
        initComponents();

    }
    
    public Stock getLocalCatalog(){
        return localCatalog;
    }
    
    public void clearAll(){
        cartPanel.clear();
        customerInfoPanel.clear();
        paymentPanel.clear();
    }
    
    
    public Transaction remoteVerifyTransaction(){
        //perform checks first
        //-cart has items
        //name entered
        //credit card number enterd
        
        boolean wasProcessed = false;
        ArrayList <Product> cartProducts = cartPanel.getProductsFromCart();
        double total = Payment.calculateTotal(cartProducts);
        Customer customer = customerInfoPanel.getCustomer();
        Payment payment;
        
        if(customer.getName().equals("")){
            JOptionPane.showMessageDialog(null,
                    "No Customer Name Entered",
                    "Customer Error",
                    JOptionPane.WARNING_MESSAGE);
            return null;
        }else if(cartProducts.isEmpty()){
            JOptionPane.showMessageDialog(null,
                    "No items in Cart.",
                    "Cart Error",
                    JOptionPane.WARNING_MESSAGE);
            return null;
        }else if(paymentPanel.getPaymentType() == Payment.CREDIT && !paymentPanel.validateCreditCardNumber()){
            JOptionPane.showMessageDialog(null,
                    "Invalid Credit Card Number",
                    "Payment Error",
                    JOptionPane.WARNING_MESSAGE);
            return null;
        }
        
        
        if(paymentPanel.getPaymentType() == Payment.CREDIT){
            payment = new Payment(paymentPanel.getPaymentType() , total , paymentPanel.getCreditCardNumber());
        }else{
            payment = new Payment(paymentPanel.getPaymentType() , total);
        }
        
        Transaction transaction = new Transaction(customer, payment,  cartProducts);
        int choice;
        Object[] options = {
            "Retry",
            "Cancel"
        };
        
        
        while(!wasProcessed){
            try {
                
                transaction.setValid(si.verifyTransaction(transaction));
                clearAll();
                wasProcessed = true;
                
            } catch (RemoteException  e) {

                choice = JOptionPane.showOptionDialog(null,
                        "Connection Not Possible",
                        "Connection Manager",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.WARNING_MESSAGE,
                        null,
                        options,
                        options[0]);

                if (choice == 1) {
                    return null;
                }
            }
        }
        return transaction;
    }

    private void connect() {

        boolean connected = false;
        int choice;

        Object[] options = {
            "Retry",
            "Cancel"
        };

        while (!connected) {

            try {

                Registry myReg;
                myReg = LocateRegistry.getRegistry("127.0.0.1", 19667);
                si = (ServerInterface) myReg.lookup("Store");
                connected = true;
                
                try{
                    storeName = si.getRemoteStoreName();
                }catch (RemoteException e){
                    storeName = "";
                }

            } catch (RemoteException | NotBoundException e) {

                choice = JOptionPane.showOptionDialog(null,
                        "Connection Not Possible",
                        "Connection Manager",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.WARNING_MESSAGE,
                        null,
                        options,
                        options[0]);

                if (choice == 1) {
                    System.exit(1);
                }
            }

        }

    }

    public String getStoreName(){
        
        return this.storeName;
        
    }

    // Init all the panels 
    private void initPanels() throws RemoteException {
        // IMPORTANT NOTE:  you'll still need to create the layouts here to 
        // arrange these panels in the way you need
        customerInfoPanel = new CustomerInfoPanel(this);
        inventoryPanel = new InventoryPanel(this);
        paymentPanel = new PaymentPanel(this);
        cartPanel = new CartPanel(this);
        this.add(customerInfoPanel);
        this.pack();
        this.add(inventoryPanel);
        this.pack();
        this.add(cartPanel);
        this.pack();
        this.add(paymentPanel);
        this.pack();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 715, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 670, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PostGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PostGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PostGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PostGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new PostGUI().setVisible(true);
                } catch (RemoteException ex) {
                    Logger.getLogger(PostGUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
