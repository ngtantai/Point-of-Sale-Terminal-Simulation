
package RMI;
import java.rmi.*;
import Catalog.*;
import Transactions.Invoice;
import Transactions.Transaction;

/**
 *
 * @author jose Ortiz
 */
public interface ServerInterface extends Remote
{

    
    Stock getCatalog() throws RemoteException;
    
    Invoice verifyTransaction(Transaction transaction) throws RemoteException;
    
            
}
