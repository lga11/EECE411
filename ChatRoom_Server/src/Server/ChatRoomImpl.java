package Server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import Interface.ChatRoomInterface;
import Interface.ChatUserInterface;

public class ChatRoomImpl extends UnicastRemoteObject implements
		ChatRoomInterface {

	private static final long serialVersionUID = 1L;
	private List<Object> clients;
	private String message;

	protected ChatRoomImpl() throws RemoteException {
		super();
		this.clients = new ArrayList<Object>();
	}

	public void broadcastMessage() throws RemoteException {
		for (Object client : this.clients) {
			if (!(client instanceof ChatUserInterface))
				System.out.println("Wrong type of client");

			if (((ChatUserInterface) client).broadCastMessage(this.message))
				System.out.println("broadcast succeed");
			else
				System.out.println("boradcast failed");
		}

	}

	@Override
	public boolean register(ChatUserInterface client) throws RemoteException {
		if (client == null) {
			return false;
		}

		this.clients.add(client);
		return true;
	}

	@Override
	public void sendMessage(String message) throws RemoteException {
		if (message == null)
			return;

		this.message = message;

		this.broadcastMessage();
	}

}
