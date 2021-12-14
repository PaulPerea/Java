package gui;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.event.InternalFrameListener;
import javax.swing.event.InternalFrameEvent;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class guiClientes extends JInternalFrame implements InternalFrameListener, ActionListener {
	
	public static String clie;
	private JButton btnCerrar;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					guiClientes frame = new guiClientes();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public guiClientes() {
		addInternalFrameListener(this);
		
		clie="clie";
		setClosable(true);
		setMaximizable(true);
		setBounds(100, 100, 772, 566);
		getContentPane().setLayout(null);
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(this);
		btnCerrar.setBounds(636, 492, 97, 25);
		getContentPane().add(btnCerrar);

	}

	public void internalFrameActivated(InternalFrameEvent arg0) {
	}
	public void internalFrameClosed(InternalFrameEvent arg0) {
	}
	public void internalFrameClosing(InternalFrameEvent arg0) {
		if (arg0.getSource() == this) {
			internalFrameClosingThis(arg0);
		}
	}
	public void internalFrameDeactivated(InternalFrameEvent arg0) {
	}
	public void internalFrameDeiconified(InternalFrameEvent arg0) {
	}
	public void internalFrameIconified(InternalFrameEvent arg0) {
	}
	public void internalFrameOpened(InternalFrameEvent arg0) {
	}
	protected void internalFrameClosingThis(InternalFrameEvent arg0) {
		
		clie=null;
	}
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnCerrar) {
			actionPerformedBtnCerrar(arg0);
		}
	}
	protected void actionPerformedBtnCerrar(ActionEvent arg0) {
		clie=null;
		dispose();
	}
}
