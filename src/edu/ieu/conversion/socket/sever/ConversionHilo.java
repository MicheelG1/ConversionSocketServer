package edu.ieu.conversion.socket.sever;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ConversionHilo extends Thread {
	private Socket clientSocket;
	private PrintWriter out;
	private BufferedReader in;
	
	public ConversionHilo(Socket socket) {
		this.clientSocket = socket;
	}
	
	@Override
	public void run() {		
		try {
			out = new PrintWriter( clientSocket.getOutputStream(), true );
			in = new BufferedReader(new InputStreamReader( clientSocket.getInputStream() ) );
			
			String monedaIdAndCantidad;
			while( (monedaIdAndCantidad = in.readLine()) != null) {
				System.out.println("recibido del cliente_:" + monedaIdAndCantidad);
				String[] arregloValores = monedaIdAndCantidad.split(";");
				String monedaId = arregloValores[0];
				String cantidad = arregloValores[1];
								
				TipoCambio tipoCambio = buscarTipoCambioPorId(monedaId);
				Double cantidadDouble = Double.parseDouble(cantidad);		       
				if(tipoCambio == null) {
					out.println("No existe la conversion " + monedaId);
				}else {
					double resultado = cantidadDouble * tipoCambio.getFactorConversion();
					String factorConversion = String.valueOf(tipoCambio.getFactorConversion());
					String resultadoString = String.valueOf(resultado);
					out.println( factorConversion +";"+resultadoString );					
				}				
			}
			in.close();
			out.close();
			clientSocket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public TipoCambio buscarTipoCambioPorId(String id) {
		return ConversionServer.cambioMoneda.get(id);		
	}
	
	public void void1() {
		short x = 125;
		long y = x; // Wide
		
		int z = (int) y; // Narrow
	}
}

