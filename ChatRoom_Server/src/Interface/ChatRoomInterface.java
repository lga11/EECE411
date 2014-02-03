package Interface;
import java.rmi.Remote;
import java.rmi.RemoteException;


public interface ChatRoomInterface extends Remote{
	public boolean register(ChatUserInterface client) throws RemoteException;
	public void sendMessage(String message) throws RemoteException;
}
