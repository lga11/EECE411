package com.rmi.client;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;
import com.rmi.server.ChatServerIF;

public class ChatClient extends UnicastRemoteObject implements ChatClientIF, Runnable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ChatServerIF chatServer;
	private String name = null;

	//Take in the name of the chat client and the server
	protected ChatClient(String name, ChatServerIF chatServer) throws RemoteException 
	{
		this.name = name;
		this.chatServer = chatServer;
		chatServer.registerChatClient(this);
	}

	public void retrieveMessage(String message) throws RemoteException 
	{
		//Once the message is retrieved, message will be displayed
		System.out.println(message);
		
	} //End retrieve message

	public void run() 
	{
		//Run as threads
		Scanner scanner = new Scanner(System.in);
		String message;
		while (true)
		{
			message = scanner.nextLine();
			try{
				//Broadcasting messages
				chatServer.broadcastMessage(name + " : " + message);
			} catch (RemoteException e){
				e.printStackTrace();
			}
		} //End while loop
	} //End runnable

} //End ChatClient
