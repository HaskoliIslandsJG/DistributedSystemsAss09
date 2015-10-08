package remoteObjects;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface CounterRemoteInterface extends Remote{
	void incrementCounter () throws RemoteException;
	int getCount() throws RemoteException;
	void printCounter() throws RemoteException;
}
