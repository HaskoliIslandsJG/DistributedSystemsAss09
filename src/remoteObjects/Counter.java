package remoteObjects;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Counter extends UnicastRemoteObject implements CounterRemoteInterface,Serializable{
	private int count = 0;
	
	
	public Counter() throws RemoteException {
		super();
	}
	
	public void incrementCounter () throws RemoteException{
		count++;
	}
	
	public int getCount() throws RemoteException{
		return count;
	}
	
	public void printCounter() throws RemoteException{
		System.out.println("The value of the count is : " + count + "." );
	}
}
