package edu.ieu.conversion.socket.sever;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.HashMap;
import java.util.Map;

public class ConversionServer extends Thread{
	public static Map<String, TipoCambio> cambioMoneda = new HashMap<String, TipoCambio>();
	private ServerSocket serverSocket;
	private int port;
	public ConversionServer(int port) {
		this.port = port;
		TipoCambio tipo1 = new TipoCambio("USD-HKD","USD","HKD", 7.76275d);
		TipoCambio tipo2 = new TipoCambio("HKD-USD","HKD","USD", 0.12882d);
		cambioMoneda.put( tipo1.getId(), tipo1);
		cambioMoneda.put( tipo2.getId(), tipo2);
		
		TipoCambio tipo3 = new TipoCambio("USD-EUR","USD","EUR", 0.83850d);
		TipoCambio tipo4 = new TipoCambio("EUR-USD","EUR","USD", 1.19260d);
		cambioMoneda.put( tipo3.getId(), tipo3);
		cambioMoneda.put( tipo4.getId(), tipo4);
		
		TipoCambio tipo5 = new TipoCambio("HKD-EUR","HKD","EUR", 0.108011d);
		TipoCambio tipo6 = new TipoCambio("EUR-HKD","EUR","HKD", 9.2583d);
		cambioMoneda.put( tipo5.getId(), tipo5);
		cambioMoneda.put( tipo6.getId(), tipo6);		
	}
	
	@Override
	public void run() {
		startServer();
	}
	
	public void startServer() {
		try {
			serverSocket = new ServerSocket(port);
			while(true) {
				new ConversionHilo(serverSocket.accept()).start();
			}
		}catch(IOException ex) {
			ex.printStackTrace();
		}
	}
		
	public void stopServer() {
		try {
			serverSocket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}	
}

