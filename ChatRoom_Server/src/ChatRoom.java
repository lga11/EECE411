import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;


public class ChatRoom extends UnicastRemoteObject implements ChatRoomInterface {

	protected ChatRoom() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void connect(String name) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sendMessage(String message) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void broadcastMessage() throws RemoteException {
		// TODO Auto-generated method stub
		
	}

}
