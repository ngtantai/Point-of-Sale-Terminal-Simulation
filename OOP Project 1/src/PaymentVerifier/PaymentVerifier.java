/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PaymentVerifier;

/**
 *
 * @author mac
 */
import java.util.Random;
import oop.project.pkg1.transaction.Invoice;


public class PaymentVerifier {
    private Random randomGen;
    private int randomChance;
    private Invoice invoice;
    
    public PaymentVerifier(){
        randomGen = new Random();
    }
    
    public boolean verify(Invoice invoice){
        
        
        randomChance = randomGen.nextInt(9);
        
        if(randomChance == 0 || (invoice.getAmountReturned() < 0)){
            
            return false;
        }else{
            return true;
        }
        

    }
    
}
