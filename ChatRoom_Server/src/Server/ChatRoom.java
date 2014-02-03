package Server;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import Interface.ChatRoomInterface;
import Interface.ChatUserInterface;


public class ChatRoom extends UnicastRemoteObject implements ChatRoomInterface {
	
	private Object client;
	private String message;

	protected ChatRoom() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public void broadcastMessage() throws RemoteException {
		if(!(this.client instanceof ChatUserInterface))
			System.out.println("Wrong type of client");
		
		if(((ChatUserInterface)this.client).broadCastMessage(this.message))
			System.out.println("broadcast succeed");
		else
			System.out.println("boradcast failed");
		
	}

	@Override
	public boolean register(ChatUserInterface client) throws RemoteException {
		if(client == null){
			return false;
		}
		
		this.client = client;
		return true;	
	}

	@Override
	public void sendMessage(String message) throws RemoteException {
		if(message == null)
			return;
		
		this.message = message;
		System.out.println("Message from client: "+ this.message);
		
		this.broadcastMessage();
		
	}

}
