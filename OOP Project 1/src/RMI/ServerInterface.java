
package RMI;
import java.rmi.*;
import Catalog.*;
import Transactions.*;


/**
 *
 * @author jose Ortiz
 */
public interface ServerInterface extends Remote
{

    Stock getCatalog() throws RemoteException;
    
    boolean verifyTransaction(Transaction transaction) throws RemoteException;
    
    String getRemoteStoreName() throws RemoteException;
    
            
}
