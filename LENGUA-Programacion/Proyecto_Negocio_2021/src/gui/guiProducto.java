package gui;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JButton;
import javax.swing.event.InternalFrameListener;
import javax.swing.event.InternalFrameEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class guiProducto extends JInternalFrame implements InternalFrameListener, ActionListener {

	public static String pro;
	private JButton btnCerrar;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					guiProducto frame = new guiProducto();
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
	public guiProducto() {
		addInternalFrameListener(this);
		
		pro="pro";
		setMaximizable(true);
		setClosable(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(this);
		btnCerrar.setBounds(325, 226, 97, 25);
		getContentPane().add(btnCerrar);

	}

	public void internalFrameActivated(InternalFrameEvent e) {
	}
	public void internalFrameClosed(InternalFrameEvent e) {
	}
	public void internalFrameClosing(InternalFrameEvent e) {
		if (e.getSource() == this) {
			internalFrameClosingThis(e);
		}
	}
	public void internalFrameDeactivated(InternalFrameEvent e) {
	}
	public void internalFrameDeiconified(InternalFrameEvent e) {
	}
	public void internalFrameIconified(InternalFrameEvent e) {
	}
	public void internalFrameOpened(InternalFrameEvent e) {
	}
	protected void internalFrameClosingThis(InternalFrameEvent e) {
		
		pro=null;
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCerrar) {
			actionPerformedBtnCerrar(e);
		}
	}
	protected void actionPerformedBtnCerrar(ActionEvent e) {
		
		pro=null;
		dispose();
	}
}
