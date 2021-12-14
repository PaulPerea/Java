package menu;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import gui.GuiInformesCliente;
import gui.GuiInformesEmpleado;
import gui.GuiInformesProducto;
import gui.GuiRegistroCliente;
import gui.GuiRegistroEmpleados;
import gui.GuiRegistroProductos;
import gui.Nosotro;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;

import java.awt.Toolkit;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Menu_principal extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu mnNewMenuArchivo;
	private JMenuItem mntmNewMenuCerrar;
	private JMenu mnNewMenuRegistro;
	private JMenuItem mntmClie;
	private JMenuItem mntmEmp;
	private JMenuItem mntmPro;
	private JMenu mnNewMenu_Info;
	private JMenuItem mntmInfoClie;
	private JMenuItem mntnInfoEmp;
	private JMenuItem mntmInfoProd;
	private JMenu mnNewMenu_Acerca;
	private JMenuItem mntmNewMenuItem_7;
	public static JDesktopPane escritorio;
	private GuiRegistroCliente clie;
	private GuiRegistroEmpleados Emp;
	private GuiRegistroProductos Pro;
	private GuiInformesCliente inClie;
	private GuiInformesEmpleado inEmp;
	private GuiInformesProducto inPro;
	private Nosotro nos;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu_principal frame = new Menu_principal();
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
	public Menu_principal() {
		setBackground(new Color(255, 255, 255));

		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setFont(new Font("Gill Sans MT", Font.BOLD | Font.ITALIC, 16));
	
		setTitle("Menu Principal");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Menu_principal.class.getResource("/imagenes/logo.png")));
		setBounds(100, 100, 641, 497);
		menuBar = new JMenuBar();
		menuBar.setToolTipText("");
		menuBar.setBorderPainted(false);
		menuBar.setBackground(SystemColor.inactiveCaption);
		menuBar.setForeground(new Color(0, 255, 0));
		setJMenuBar(menuBar);
		
		mnNewMenuArchivo = new JMenu("Archivo");
		mnNewMenuArchivo.setForeground(SystemColor.textHighlight);
		mnNewMenuArchivo.setIcon(new ImageIcon(Menu_principal.class.getResource("/imagenes/suspencion.png")));
		menuBar.add(mnNewMenuArchivo);
		
		mntmNewMenuCerrar = new JMenuItem("Cerrar");
		mntmNewMenuCerrar.addActionListener(this);
		mntmNewMenuCerrar.setForeground(new Color(210, 105, 30));
		mntmNewMenuCerrar.setIcon(new ImageIcon(Menu_principal.class.getResource("/imagenes/cerrar.png")));
		mnNewMenuArchivo.add(mntmNewMenuCerrar);
		
		mnNewMenuRegistro = new JMenu("Registros");
		mnNewMenuRegistro.setForeground(SystemColor.textHighlight);
		mnNewMenuRegistro.setIcon(new ImageIcon(Menu_principal.class.getResource("/imagenes/registro.png")));
		menuBar.add(mnNewMenuRegistro);
		
		mntmClie = new JMenuItem("Cliente");
		mntmClie.addActionListener(this);
		mntmClie.setForeground(new Color(128, 128, 0));
		mntmClie.setIcon(new ImageIcon(Menu_principal.class.getResource("/imagenes/cliente-re.png")));
		mnNewMenuRegistro.add(mntmClie);
		
		mntmEmp = new JMenuItem("Empleado");
		mntmEmp.addActionListener(this);
		mntmEmp.setForeground(new Color(128, 128, 0));
		mntmEmp.setIcon(new ImageIcon(Menu_principal.class.getResource("/imagenes/empleado-re.png")));
		mnNewMenuRegistro.add(mntmEmp);
		
		mntmPro = new JMenuItem("Producto");
		mntmPro.addActionListener(this);
		mntmPro.setForeground(new Color(128, 128, 0));
		mntmPro.setIcon(new ImageIcon(Menu_principal.class.getResource("/imagenes/prod-re.png")));
		mnNewMenuRegistro.add(mntmPro);
		
		mnNewMenu_Info = new JMenu("Informe");
		mnNewMenu_Info.setForeground(SystemColor.textHighlight);
		mnNewMenu_Info.setIcon(new ImageIcon(Menu_principal.class.getResource("/imagenes/informe.png")));
		menuBar.add(mnNewMenu_Info);
		
		mntmInfoClie = new JMenuItem("Cliente");
		mntmInfoClie.addActionListener(this);
		mntmInfoClie.setForeground(new Color(50, 205, 50));
		mntmInfoClie.setIcon(new ImageIcon(Menu_principal.class.getResource("/imagenes/clie-in.png")));
		mnNewMenu_Info.add(mntmInfoClie);
		
		mntnInfoEmp = new JMenuItem("Empleado");
		mntnInfoEmp.addActionListener(this);
		mntnInfoEmp.setForeground(new Color(50, 205, 50));
		mntnInfoEmp.setIcon(new ImageIcon(Menu_principal.class.getResource("/imagenes/emp-in.png")));
		mnNewMenu_Info.add(mntnInfoEmp);
		
		mntmInfoProd = new JMenuItem("Producto");
		mntmInfoProd.addActionListener(this);
		mntmInfoProd.setForeground(new Color(50, 205, 50));
		mntmInfoProd.setIcon(new ImageIcon(Menu_principal.class.getResource("/imagenes/prod-in.png")));
		mnNewMenu_Info.add(mntmInfoProd);
		
		mnNewMenu_Acerca = new JMenu("Acerca de ");
		mnNewMenu_Acerca.setForeground(SystemColor.textHighlight);
		mnNewMenu_Acerca.setIcon(new ImageIcon(Menu_principal.class.getResource("/imagenes/acerca.png")));
		menuBar.add(mnNewMenu_Acerca);
		
		mntmNewMenuItem_7 = new JMenuItem("Nosotros");
		mntmNewMenuItem_7.addActionListener(this);
		mntmNewMenuItem_7.setForeground(new Color(255, 0, 255));
		mntmNewMenuItem_7.setIcon(new ImageIcon(Menu_principal.class.getResource("/imagenes/nosotros.png")));
		mnNewMenu_Acerca.add(mntmNewMenuItem_7);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(135, 206, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		

		
		escritorio = new JDesktopPane();
		contentPane.add(escritorio, BorderLayout.CENTER);
	}
	void Cerrar() {
		int	mensaje=JOptionPane.showConfirmDialog(null, "Esta seguro de cerrar el programa ?","Sistema de Registro",
				JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE);

		if(mensaje==JOptionPane.YES_OPTION)
			dispose();
		
	}
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == mntmNewMenuItem_7) {
			actionPerformedMntmNewMenuItem_7(arg0);
		}
		if (arg0.getSource() == mntmInfoProd) {
			actionPerformedMntmInfoProd(arg0);
		}
		if (arg0.getSource() == mntnInfoEmp) {
			actionPerformedMntnInfoEmp(arg0);
		}
		if (arg0.getSource() == mntmInfoClie) {
			actionPerformedMntmInfoClie(arg0);
		}
		if (arg0.getSource() == mntmPro) {
			actionPerformedMntmPro(arg0);
		}
		if (arg0.getSource() == mntmEmp) {
			actionPerformedMntmEmp(arg0);
		}
		if (arg0.getSource() == mntmNewMenuCerrar) {
			actionPerformedMntmNewMenuCerrar(arg0);
		}
		if (arg0.getSource() == mntmClie) {
			actionPerformedmntmClie(arg0);
		}
	}
	
	protected void actionPerformedMntmNewMenuCerrar(ActionEvent arg0) {
		Cerrar();
	}
	protected void actionPerformedmntmClie(ActionEvent arg0) {
		clie=new GuiRegistroCliente();
		contentPane.add(clie);
		clie.setVisible(true);
	}
	protected void actionPerformedMntmEmp(ActionEvent arg0) {
		Emp=new GuiRegistroEmpleados();
		contentPane.add(Emp);
		Emp.setVisible(true);
	}
	protected void actionPerformedMntmPro(ActionEvent arg0) {
		Pro=new GuiRegistroProductos();
		contentPane.add(Pro);
		Pro.setVisible(true);
		
		
	}
	protected void actionPerformedMntmInfoClie(ActionEvent arg0) {
		inClie=new GuiInformesCliente();
		contentPane.add(inClie);
		inClie.setVisible(true);
	}
	protected void actionPerformedMntnInfoEmp(ActionEvent arg0) {
		inEmp=new GuiInformesEmpleado();
		contentPane.add(inEmp);
		inEmp.setVisible(true);
	}
	protected void actionPerformedMntmInfoProd(ActionEvent arg0) {
		inPro=new GuiInformesProducto();
		contentPane.add(inPro);
		inPro.setVisible(true);
	}
	protected void actionPerformedMntmNewMenuItem_7(ActionEvent arg0) {
		nos=new Nosotro();
		contentPane.add(nos);
		nos.setVisible(true);
	}
}
