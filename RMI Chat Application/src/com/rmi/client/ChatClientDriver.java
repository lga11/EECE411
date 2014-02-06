package com.rmi.client;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import com.rmi.server.ChatServerIF;

/*
 * Main Class
 */
public class ChatClientDriver 
{
	public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException
	{
		String chatServerURL = "rmi://localhost/RMIChatServer";
		//Pick up a chat server instance
		ChatServerIF chatServer = (ChatServerIF) Naming.lookup(chatServerURL);
		//Open up a new thread for chat client
		new Thread(new ChatClient(args[0], chatServer)).start();
		
	} //End main
} //End ChatClientDriver
