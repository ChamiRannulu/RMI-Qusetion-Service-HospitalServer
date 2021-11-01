package rmi_server;

import java.net.MalformedURLException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;


public class StartServer {

    static Registry reg;

    public static String serverStatus = "not runnting";

    private StartServer() {
    }
    private static final StartServer ss = new StartServer();

    public static StartServer getInstance() {
        return ss;
    }

    public int Start() throws MalformedURLException {
        if (serverStatus.equals("running")) {
            return 2;
        } else {
            try {
                RemoteQuestionsImplementation qs = new RemoteQuestionsImplementation();
                Registry reg = LocateRegistry.createRegistry(1099);

                reg.rebind("Service", qs);

                System.out.println("Service started. Welcome to the RMI Service!");
                serverStatus = "running";
                return 1;

            } catch (RemoteException e) {
                System.out.println("An error occured: " + e.toString());
                e.printStackTrace();
                return 0;
            }
        }
    }

}
