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


public class PaymentVerifier {
    private Random randomGen;
    private int randomChance;
    
    public PaymentVerifier(){
        randomGen = new Random();
    }
    
    public boolean verifyPayment(){
        
        
        randomChance = randomGen.nextInt(9);
        
        if(randomChance == 0){
            
            return false;
        }else{
            return true;
        }
        

    }
    
}
