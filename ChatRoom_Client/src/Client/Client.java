package Client;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.rmi.Naming;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import Interface.ChatRoomInterface;
import Interface.ChatUserInterface;

public class Client extends UnicastRemoteObject implements ChatUserInterface {

	private String userName;

	public Client(String userName) throws RemoteException{
		this.userName = userName;
	}

	private void register(ChatRoomInterface chatRoom) {
		if (chatRoom == null) {
			return;
		}
		try {
			if (!chatRoom.register(this)) {
				System.out.println("Failed to connected to chat room..");
			} else {
				System.out.println("Successed to connected to chat room..");
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}

	}

	private void send(ChatRoomInterface chatRoom, String message) {
		if (message == null || chatRoom == null) {
			return;
		}

		try {
			chatRoom.sendMessage(this.userName + ": " + message);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] argv) {
		try {
			if (System.getSecurityManager() == null) {
				System.setSecurityManager(new RMISecurityManager());
			}
			ChatRoomInterface chatRoom = (ChatRoomInterface) Naming.lookup("rmi://localhost/ChatRoom");
			ChatUserInterface client = new Client("ME");
			
			try {
				if (!chatRoom.register(client)) {
					System.out.println("Failed to connected to chat room..");
				} else {
					System.out.println("Successed to connected to chat room..");
				}
			} catch (RemoteException e) {
				e.printStackTrace();
			}

			BufferedReader bufferRead = new BufferedReader(
					new InputStreamReader(System.in));
			String s = bufferRead.readLine();
			
			try {
				chatRoom.sendMessage("ME" + ": " + s);
			} catch (RemoteException e) {
				e.printStackTrace();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean broadCastMessage(String message) {
		if (message == null)
			return false;

		else {
			System.out.println(message);
			return true;
		}
	}

}
