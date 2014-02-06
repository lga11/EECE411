package com.rmi.client;

import java.io.BufferedReader;
import java.io.InputStreamReader;
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
		try 
		{
			String chatServerURL = "rmi://localhost/RMIChatServer";
			//Pick up a chat server instance
			ChatServerIF chatServer = (ChatServerIF) Naming.lookup(chatServerURL);
			
			//Asking for user name
			System.out.println("Please enter your name:");
			BufferedReader bufferRead = new BufferedReader(
					new InputStreamReader(System.in));
			String username = bufferRead.readLine();
			System.out.println(username + ", you are now online...");
			
			//Open up a new thread for chat client
			//new Thread(new ChatClient(args[0], chatServer)).start();
			new Thread(new ChatClient(username, chatServer)).start();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		} //End exception
		
	} //End main
} //End ChatClientDriver
