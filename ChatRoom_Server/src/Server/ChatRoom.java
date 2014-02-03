package Server;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import Interface.ChatRoomInterface;


public class ChatRoom extends UnicastRemoteObject implements ChatRoomInterface {
	
	private Object client;

	protected ChatRoom() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public void broadcastMessage() throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean register(Object client) throws RemoteException {
		if(client == null){
			return false;
		}
		
		this.client = client;
		
		return true;
		
	}

	@Override
	public void sendMessage(String message) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

}
