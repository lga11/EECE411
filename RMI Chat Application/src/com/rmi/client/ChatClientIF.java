package com.rmi.client;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ChatClientIF extends Remote
{
	//To retrieve messages
	void retrieveMessage(String message) throws RemoteException;
	
} //End ChatClientIF
