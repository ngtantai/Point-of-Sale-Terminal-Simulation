
package RMI;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author Jose Ortiz Costa
 */
public class Server extends UnicastRemoteObject implements ServerInterface {

    public Server() throws RemoteException {
        super();
    }

    @Override
    public double add(double a, double b) throws RemoteException {
        return a + b;
    }

    public void addServerSecurity() {
        /*
	     * Add extra security to server
         */
        if (System.getSecurityManager() == null) {
            SecurityManager sm = new SecurityManager();
            System.setSecurityManager(sm);
        }
    }

    public void registerServer() {
        /*
	     * Registers the server 
         */
        try {
            Server server = new Server();
            Registry reg = LocateRegistry.createRegistry(19667);
            reg.rebind("Store", server);
        } catch (RemoteException e) {
            System.out.println("Error while adding server \n"
                    + "Detailed Error: " + e.getMessage());
        }

    }

    public static void main(String args[]) {
        /*
	     * The main method register the server
	     * and start running the server
         */
        try {
            Server g = new Server();
            //g.addServerSecurity();
            g.registerServer();
            System.out.println("Server has been registered Succesfully now run the client");
        } catch (RemoteException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
