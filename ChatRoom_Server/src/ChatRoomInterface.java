import java.rmi.Remote;
import java.rmi.RemoteException;


public interface ChatRoomInterface extends Remote{
	public void connect(String name) throws RemoteException;
	public void sendMessage(String message) throws RemoteException;
	public void broadcastMessage() throws RemoteException;
}
