package Client;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.rmi.Naming;
import java.rmi.RemoteException;

import Interface.ChatRoomInterface;
import Interface.ChatUserInterface;

public class Client implements ChatUserInterface{

	private ChatRoomInterface chatRoom;
	private String userName;

	public Client(String userName) {
		this.userName = userName;
	}

	private void connect(ChatRoomInterface chatRoom) {
		this.chatRoom = chatRoom;

	}

	private void send(String message) {
		if (message == null) {
			return;
		}

		try {
			this.chatRoom.sendMessage(message);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] argv) {
		try {
			ChatRoomInterface chatRoom = (ChatRoomInterface) Naming.lookup("");
			Client client = new Client("ME");
			client.connect(chatRoom);

			System.out.println("Connected to chat room : ");
			BufferedReader bufferRead = new BufferedReader(
					new InputStreamReader(System.in));
			String s = bufferRead.readLine();
			client.send(s);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean broadCastMessage() {
		// TODO Auto-generated method stub
		return false;
	}

}
