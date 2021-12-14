package gui;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;

public class guiReporteVentas extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					guiReporteVentas frame = new guiReporteVentas();
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
	public guiReporteVentas() {
		setClosable(true);
		setMaximizable(true);
		setBounds(100, 100, 450, 300);

	}

}
