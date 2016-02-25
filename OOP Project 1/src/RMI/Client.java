package RMI;
import Catalog.*;
import Transactions.*;
import java.io.Serializable;
import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author Jose Ortiz Costa
 */
public class Client implements Serializable
{
    public Client ()
    {
        
    }
    public void initClient ()
    {
        /* 
         *  Gets the server registry, and starts 
         *  interaction with it
        */
        try 
    	{
            
           Registry myReg;
           ServerInterface si;
           myReg = LocateRegistry.getRegistry("127.0.0.1",19667 );
           si = (ServerInterface) myReg.lookup("Store");
           System.out.println("Client succesfully working and connected to the server");
           //double test = si.add(4.00, 5.00);
           
           try{
               Stock testCatalog = si.getCatalog();
               System.out.println(testCatalog.toString());
           }catch(RemoteException e){
               System.out.println("Couldn't get catalog :( " + e.getMessage());
           }
           
           try{
               boolean isValid = si.verifyTransaction(new Transaction());
           }catch(RemoteException e){
               System.out.println("Couldn't verify transaction :( " + e.getMessage());
           }
            
        } 
    	catch (RemoteException e) 
        {
    	    System.out.println("Error while recieving " + 
                               "data from the server\n " + 
    	                       " Detailed Error: " +
                               e.getMessage());
    	} 
    	catch (NotBoundException e) 
        {
    	    System.out.println("Error while recieving " +
                               "data from the server\n " + 
    	                       "Detailed Error: " +
                               e.getMessage());
        }
    }
    
    public static void main (String args [])
    {
        // initializes the client
        Client client = new Client();
    	client.initClient();
    }
    
    
}
