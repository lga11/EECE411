package Server;

import java.rmi.Naming;
import java.rmi.RMISecurityManager;

public class ChatRoomServer {
	public static void main(String[] argv) {
		try {
			if (System.getSecurityManager() == null) {
				System.setSecurityManager(new RMISecurityManager());
			}

			ChatRoom chatRoom = new ChatRoom();
			Naming.rebind("rmi://localhost/ChatRoom", chatRoom);

			System.out.println("ChatRoom Server is ready.");
		} catch (Exception e) {
			System.out.println("ChatRoom Server failed: " + e);
		}
	}
}
