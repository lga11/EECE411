package Interface;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ChatUserInterface extends Remote{
	public boolean broadCastMessage(String message) throws RemoteException;
}
