package gui;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;

public class Nosotro extends JInternalFrame {
	private JPanel panel;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Nosotro frame = new Nosotro();
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
	public Nosotro() {
		setClosable(true);
		setTitle("Nosotros");
		setBounds(100, 100, 460, 284);
		getContentPane().setLayout(null);
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setToolTipText("");
		panel.setForeground(new Color(138, 43, 226));
		panel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Acerca de", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(128, 0, 128)));
		panel.setBounds(37, 23, 365, 169);
		getContentPane().add(panel);
		
		lblNewLabel = new JLabel("Programadores");
		lblNewLabel.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD | Font.ITALIC, 26));
		lblNewLabel.setBounds(59, 13, 215, 36);
		panel.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("-Jean Paul Perea Camacho\r\n");
		lblNewLabel_1.setBounds(12, 62, 179, 16);
		panel.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("-Jonathan carnica guzm\u00E1n");
		lblNewLabel_2.setBounds(12, 88, 179, 16);
		panel.add(lblNewLabel_2);

	}
}
