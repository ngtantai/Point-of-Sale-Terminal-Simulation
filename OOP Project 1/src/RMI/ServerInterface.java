
package RMI;
import java.rmi.*;

/**
 *
 * @author jose Ortiz
 */
public interface ServerInterface extends Remote
{
    double add (double a, double b) throws RemoteException;
    
            
}
