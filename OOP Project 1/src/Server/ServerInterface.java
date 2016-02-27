
package Server;
import java.rmi.*;
import Catalog.*;
import Transactions.*;


/**
 *
 * @author jose Ortiz
 * 
 * This Interface contains the signature methods that the post (client) and the
 * server (Store) will use to comunicate between them
 */
public interface ServerInterface extends Remote
{

    Stock getCatalog() throws RemoteException;
    
    boolean verifyTransaction(Transaction transaction) throws RemoteException;
    
    String getRemoteStoreName() throws RemoteException;
    
            
}
