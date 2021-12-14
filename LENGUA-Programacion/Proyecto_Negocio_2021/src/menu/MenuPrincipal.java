package menu;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import gui.guiClientes;
import gui.guiProducto;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MenuPrincipal extends JFrame implements ActionListener {

	private JPanel contentPane;
	private static JDesktopPane escritorio;
	private JMenuItem mntmClientes;
	private JMenuItem mntmProductos;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuPrincipal frame = new MenuPrincipal();
					frame.setExtendedState(MAXIMIZED_BOTH);
					
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
	public MenuPrincipal() {
		
		guiClientes.clie=null;
		guiProducto.pro=null;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 698, 475);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnSistemas = new JMenu("Sistemas");
		menuBar.add(mnSistemas);
		
		JMenuItem mntmCerrar = new JMenuItem("Cerrar");
		mntmCerrar.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/imagenes/cerrar.png")));
		mntmCerrar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F5, InputEvent.ALT_MASK));
		mnSistemas.add(mntmCerrar);
		
		JMenu mnNewMenu = new JMenu("Mantenimiento\r\n");
		menuBar.add(mnNewMenu);
		
		mntmClientes = new JMenuItem("Clientes");
		mntmClientes.addActionListener(this);
		mntmClientes.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/imagenes/49500_customers_icon.png")));
		mntmClientes.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.ALT_MASK));
		mnNewMenu.add(mntmClientes);
		
		mntmProductos = new JMenuItem("Productos");
		mntmProductos.addActionListener(this);
		mntmProductos.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/imagenes/Productos.png")));
		mntmProductos.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, InputEvent.ALT_MASK));
		mnNewMenu.add(mntmProductos);
		
		JMenu mnReportes = new JMenu("Reportes");
		menuBar.add(mnReportes);
		
		JMenuItem mntmClientes_1 = new JMenuItem("Clientes");
		mntmClientes_1.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/imagenes/ventas.png")));
		mntmClientes_1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK));
		mnReportes.add(mntmClientes_1);
		
		JMenuItem mntmVentas = new JMenuItem("Ventas");
		mntmVentas.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/imagenes/ventas2.png")));
		mntmVentas.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_T, InputEvent.CTRL_MASK));
		mnReportes.add(mntmVentas);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		escritorio = new JDesktopPane();
		contentPane.add(escritorio, BorderLayout.CENTER);
	}

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == mntmProductos) {
			actionPerformedMntmProductos(arg0);
		}
		if (arg0.getSource() == mntmClientes) {
			actionPerformedMntmClientes(arg0);
		}
	}
	protected void actionPerformedMntmClientes(ActionEvent arg0) {
		
		String cl=guiClientes.clie;
		try {
			if(cl==null){
				guiClientes cliente=new guiClientes();
				escritorio.add(cliente);
				cliente.setVisible(true	);
			} else {
				JOptionPane.showMessageDialog(null, "Ya está abierto la ventana");
			}
		} catch (Exception e) {
			// TODO: handle exception
			
		}
	}
	protected void actionPerformedMntmProductos(ActionEvent arg0) {
		String p=guiProducto.pro;
		try {
			if(p==null){
				guiProducto prod=new guiProducto();
				escritorio.add(prod);
				prod.setVisible(true);
			} else {
				JOptionPane.showMessageDialog(null, "Ya está abierto la ventana");
			}
		} catch (Exception e) {
			// TODO: handle exception
			
		}
	}
}
