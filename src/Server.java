import java.rmi.Naming;

import remoteObjects.Counter;



public class Server {
	/**
	 * Remote object.
	 */
	private Counter counter;
	
	public Server(){
		try{
			counter = new Counter();
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	public static void main(String args[]){
		System.setSecurityManager(new SecurityManager());
		Server server = new Server();
		try{
			String registryServerName = "localhost";
			String serviceName = "CounterService";
			Naming.rebind("//" + registryServerName + "/" + serviceName, server.counter);
			System.out.println("Binding ok !");
			
			
		} catch (Exception e){
			System.err.println("Exception:" + e.toString());
			e.printStackTrace();
		}
		
	}
}
