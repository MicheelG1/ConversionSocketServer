package edu.ieu.conversion.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextPane;

import edu.ieu.conversion.socket.sever.ConversionServer;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ServidorGUI {
	private ConversionServer conversionServer = new ConversionServer(6000);
	private JFrame frmServidorConversion;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ServidorGUI window = new ServidorGUI();
					window.frmServidorConversion.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ServidorGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmServidorConversion = new JFrame();
		frmServidorConversion.setTitle("Servidor Conversion");
		frmServidorConversion.setBounds(100, 100, 645, 452);
		frmServidorConversion.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JTextPane textPaneSalida = new JTextPane();
		textPaneSalida.setFont(new Font("Tahoma", Font.PLAIN, 16));
		frmServidorConversion.getContentPane().add(textPaneSalida, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		frmServidorConversion.getContentPane().add(panel, BorderLayout.SOUTH);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnIniciarServidor = new JButton("Iniciar Servidor");
		btnIniciarServidor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Servicio inicializado...");
				textPaneSalida.setText( textPaneSalida.getText() + "\n Servicio inicializado... \n");
				conversionServer.start();								
			}
		});
		btnIniciarServidor.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel.add(btnIniciarServidor);
		
		JButton btnDetenerServidor = new JButton("Detener Servidor");
		btnDetenerServidor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {							
				conversionServer.stopServer();;
				textPaneSalida.setText( textPaneSalida.getText() + "\n Servicio Detenido... \n");
				System.out.println("Servicio Detenido...");
			}
		});
		btnDetenerServidor.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel.add(btnDetenerServidor);
		
		JButton btnSalirApp = new JButton("Salir de la App");
		btnSalirApp.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel.add(btnSalirApp);
	}

}

