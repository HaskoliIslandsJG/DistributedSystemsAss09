import java.rmi.Naming;

import remoteObjects.CounterRemoteInterface;

/**
 * Class ClientSample to call the method with RMI.
 * @author jeje
 *
 */
public class Client {
	private final String serviceName = "CounterService";
	private String registryServerName;
	
	private void doOperation(){
		try {
			CounterRemoteInterface counterProxy = (CounterRemoteInterface)Naming.lookup("//" + registryServerName + "/" + serviceName);
			
			int currentValue = counterProxy.getCount();
			System.out.println("The current value is " + currentValue + ".");
			
			counterProxy.incrementCounter();
			counterProxy.printCounter();
			
			currentValue = counterProxy.getCount();
			System.out.println("Then the value after incrementing it is " + currentValue + ".");
			
		} catch (Exception e){
			System.err.println("Exception:" + e.toString());
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args){
		if(args.length != 1){
			System.out.println("You should give the server name in parameter.");
			return;
		}
		
		System.setSecurityManager(new SecurityManager());
		Client client = new Client();
		client.registryServerName = args[0];
		
		
		client.doOperation();
	}
}
