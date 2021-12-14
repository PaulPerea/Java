package menu;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import capa_presentacion.GuiCategoria;
import capa_presentacion.GuiCliente;
import transacciones.GuiVenta;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JDesktopPane;
import java.awt.CardLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MenuPrincipal extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu mnMantenimiento;
	private JMenu mnPrincipales;
	private JMenu mnSecundarios;
	private JMenuItem mntmCategoria;
	private JMenuItem mntmCargo;
	private JMenuItem mntmDistrito;
	private JMenuItem mntmCliente;
	public static JDesktopPane escritorio;
	private JMenu mnNewMenu;
	private JMenu mnNewMenu_1;
	private JMenu mnNewMenu_2;
	private JMenu mnNewMenu_3;
	private JMenu mnNewMenu_4;
	private JMenu mnNewMenu_5;
	private JMenuItem mntmNewMenuItem;
	private JMenuItem mntmNewMenuItem_1;

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GuiCategoria.cate=null;
		GuiCliente.clie=null;
		GuiVenta.venta=null;
		setBounds(100, 100, 590, 625);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnMantenimiento = new JMenu("Mantenimiento");
		menuBar.add(mnMantenimiento);
		
		mnPrincipales = new JMenu("Principales");
		mnMantenimiento.add(mnPrincipales);
		
		mntmCliente = new JMenuItem("Cliente");
		mntmCliente.addActionListener(this);
		mnPrincipales.add(mntmCliente);
		
		mnSecundarios = new JMenu("Secundarios");
		mnMantenimiento.add(mnSecundarios);
		
		mntmCategoria = new JMenuItem("Categoria");
		mntmCategoria.addActionListener(this);
		mnSecundarios.add(mntmCategoria);
		
		mntmCargo = new JMenuItem("Cargo");
		mnSecundarios.add(mntmCargo);
		
		mntmDistrito = new JMenuItem("Distrito");
		mnSecundarios.add(mntmDistrito);
		
		mnNewMenu = new JMenu("Proceso");
		menuBar.add(mnNewMenu);
		
		mnNewMenu_5 = new JMenu("Ventas");
		mnNewMenu.add(mnNewMenu_5);
		
		mntmNewMenuItem = new JMenuItem("Boleta");
		mntmNewMenuItem.addActionListener(this);
		mnNewMenu_5.add(mntmNewMenuItem);
		
		mntmNewMenuItem_1 = new JMenuItem("Factura");
		mnNewMenu_5.add(mntmNewMenuItem_1);
		
		mnNewMenu_1 = new JMenu("Consulta");
		menuBar.add(mnNewMenu_1);
		
		mnNewMenu_2 = new JMenu("Reporte");
		menuBar.add(mnNewMenu_2);
		
		mnNewMenu_3 = new JMenu("Ayuda");
		menuBar.add(mnNewMenu_3);
		
		mnNewMenu_4 = new JMenu("Salir");
		menuBar.add(mnNewMenu_4);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		
		escritorio = new JDesktopPane();
		contentPane.add(escritorio, "name_250618779897647");
	}

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == mntmNewMenuItem) {
			actionPerformedMntmNewMenuItem(arg0);
		}
		if (arg0.getSource() == mntmCliente) {
			actionPerformedMntmCliente(arg0);
		}
		if (arg0.getSource() == mntmCategoria) {
			actionPerformedMntmCategoria(arg0);
		}
	}
	protected void actionPerformedMntmCategoria(ActionEvent arg0) {
	String c=GuiCategoria.cate;
	
	try {
		if(c==null){
			GuiCategoria cat=new GuiCategoria();
			escritorio.add(cat);
			cat.setVisible(true);
		}else
		{
			JOptionPane.showMessageDialog(null, "Ya está activo");
		}
		
		
		
	} catch (Exception e) {

	}
	
		
		
		
	}
	protected void actionPerformedMntmCliente(ActionEvent arg0) {
		String c=GuiCliente.clie;
		try {
			if(c==null) {
				GuiCliente cli=new GuiCliente();
				escritorio.add(cli);
				cli.setVisible(true);
			}else
			{
				JOptionPane.showMessageDialog(null, "Ya está activo");
			}
		} catch(Exception e) {
			
		}
	}
	protected void actionPerformedMntmNewMenuItem(ActionEvent arg0) {
		String b=GuiVenta.venta;
		try {
			if(b==null) {
				GuiVenta v=new GuiVenta();
				escritorio.add(v);
				v.setVisible(true);
			}else
			{
				JOptionPane.showMessageDialog(null, "Ya está activo");
			}
		} catch(Exception e) {
			
		}
	}
}
