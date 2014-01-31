/*******************************************************************************
 * This code is distributed under GPL v2 licence.
 * 
 * This code is provided solely "as is". 
 * There is no warranty or other guarantee of fitness of this code.
 * The author disclaims all responsibility and liability 
 * with respect to this code's usage
 * or its effect upon hardware or computer systems.
 * 
 * author: Huu-Nghia Nguyen
 * email : nhnghia@me.com
 ******************************************************************************/
/**
 * Jun 19, 2012 12:09:50 AM
 * @author nhnghia
 */
package fr.lri.schora.util;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.List;

public class Broadcast extends Thread{
	private static final int MaxBackLog = 5;
	int port;
	private ServerSocket multicast;
	private List<Socket> clientLst;
	
	public Broadcast(){
		isStopping = true;
	}
	
	public synchronized void setPort(int port) throws IOException{
		close();
		
		this.port = port;
		multicast = new ServerSocket(port, MaxBackLog);
		clientLst = new ArrayList<Socket>();
		this.setName("Broadcast");
		
		if (isStopping)
			this.start();
	}
	
	boolean isStopping;
	
	public void run() {
		isStopping = false;
		try {
			Print.println(String.format("Waiting a connection at the port %d...", port));
			while (!isStopping) {
				Socket client = multicast.accept();

				//String str = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<trace>\n";
				//client.getOutputStream().write(str.getBytes());
				//client.getOutputStream().flush();
				
				clientLst.add(client);
				Print.println(" --> a client joined");
				
				String data = "HTTP/1.1 200 OK\n";
				data += "Content-Type: application/xml\n\n";
				client.getOutputStream().write(data.getBytes());
			}
		}catch(SocketException ex){
			//not necessary since it is throw when multicast is closed
			//Debug.print(ex);
		}catch (Exception ioe) {
			Debug.print(ioe);
		}
	}
	
	public void broadcast(String data) {
		if (data == null || data.length() == 0)
			return;
		if (clientLst == null || clientLst.size() == 0)
			return;
		int n = clientLst.size();
		
		for (int i=0; i<n; i++){
			Socket client = clientLst.get(i);
			try {
				//Debug.println(String.format("Write data to client %s", client.getRemoteSocketAddress().toString()));
				client.getOutputStream().write(data.getBytes());
				client.getOutputStream().flush();
			} catch (SocketException e){
				Print.println(" --> a client exited");
				clientLst.remove(client);
				n --;
			} catch (Exception ex) {
				Debug.print(ex);
			}
		}
	}
	
	public void close(){
		try{
			//broadcast("\n</trace>");
			if (clientLst != null){
				for (Socket client:clientLst)
					if (!client.isClosed())
						client.close();
				clientLst.clear();
				clientLst = null;
			}
			multicast.close();
		}catch (Exception ex){
		}
	}
}
