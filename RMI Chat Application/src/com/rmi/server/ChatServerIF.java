package com.rmi.server;

import java.rmi.Remote;
import java.rmi.RemoteException;

import com.rmi.client.ChatClientIF;

public interface ChatServerIF extends Remote
{
	//To register chat clients
	void registerChatClient(ChatClientIF chatClient) throws RemoteException;
	//To broadcast messages to different clients
	void broadcastMessage(String message) throws RemoteException;
} //End ChatServerIF
