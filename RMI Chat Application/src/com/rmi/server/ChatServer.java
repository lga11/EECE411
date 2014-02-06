package com.rmi.server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import com.rmi.client.ChatClientIF;

public class ChatServer extends UnicastRemoteObject implements ChatServerIF{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<ChatClientIF> chatClients;

	protected ChatServer() throws RemoteException 
	{
		chatClients = new ArrayList<ChatClientIF>();
	}

	public synchronized void registerChatClient(ChatClientIF chatClient)
			throws RemoteException 
	{
		//To add a chat client instance to the chatClients array list
		this.chatClients.add(chatClient);
		
	} //End Register

	public synchronized void broadcastMessage(String message) throws RemoteException {
		//Going through all chat clients, each client is going to retrieve messages from others
		int i = 0;
		while (i < chatClients.size())
		{
			chatClients.get(i++).retrieveMessage(message);
		}
		
	} //End broadcast

} //End ChatServer
