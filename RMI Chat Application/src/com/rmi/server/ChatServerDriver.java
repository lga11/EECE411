package com.rmi.server;

import java.net.InetAddress;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;

/*
 * Main Class
 */
public class ChatServerDriver 
{
	public static void main(String[] args) throws RemoteException, MalformedURLException
	{
		try 
		{
			if (System.getSecurityManager() == null) 
			{
				System.setSecurityManager(new RMISecurityManager());
			}
			
			String serverHostName = InetAddress.getLocalHost().getHostName();
			String serverIpAddress = InetAddress.getLocalHost()
					.getHostAddress();
			
			Naming.rebind("RMIChatServer", new ChatServer());
			System.out.println("ChatRoom is running on server : "
					+ serverHostName + " @ " + serverIpAddress);
		}
		catch (Exception e) 
		{
			System.out.println("ChatRoom Server failed: " + e);
		}
	} //End main
} //End ChatServerDriver
