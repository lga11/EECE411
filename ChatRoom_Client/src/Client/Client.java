package Client;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.rmi.Naming;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import Interface.ChatRoomInterface;
import Interface.ChatUserInterface;

public class Client {
	public static void main(String[] argv) {
		try {

			if (System.getSecurityManager() == null) {
				System.setSecurityManager(new RMISecurityManager());
			}

			ChatRoomInterface chatRoom = (ChatRoomInterface) Naming
					.lookup("rmi://localhost/ChatRoom");

			ChatUserImpl client = new ChatUserImpl("ME");

			if (client.register(chatRoom)) {
				System.out.println("Please enter message");
				BufferedReader bufferRead = new BufferedReader(
						new InputStreamReader(System.in));
				String s = bufferRead.readLine();
				client.send(chatRoom, s);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
