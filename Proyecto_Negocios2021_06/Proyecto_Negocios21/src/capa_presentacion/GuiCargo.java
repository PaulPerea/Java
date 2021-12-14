package capa_presentacion;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.InternalFrameListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.event.InternalFrameEvent;
import javax.swing.UIManager;
import java.awt.Color;

public class GuiCargo extends JInternalFrame implements ActionListener, InternalFrameListener {
	private JPanel panel;
	private JLabel lblCodigo;
	private JLabel lblNombre;
	private JTextField txtCodigo;
	private JTextField txtNombre;
	private JLabel lblBuscar;
	private JTextField txtBuscar;
	private JPanel panel_2;
	private JButton btnNuevo;
	private JTable tblCargo;
	private JScrollPane scrollPane;
	private JButton btnGrabar;
	private JButton btnCancelar;
	private JButton btnEliminar;
	private JButton btnCerrar;
	private JCheckBox chckbxEditar;

	DefaultTableModel mimodelo;
	
	public static String cate="";
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//GuiCategoria frame = new GuiCategoria();
					//frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	
	
	
	public GuiCargo() {
		setClosable(true);
		addInternalFrameListener(this);
		cate="cate";
		mimodelo=new DefaultTableModel();
		setTitle("Mantenimiento de cargo");
		setBounds(100, 100, 477, 512);
		getContentPane().setLayout(null);
		
		panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Cargo", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(10, 11, 307, 128);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		lblCodigo = new JLabel("Codigo");
		lblCodigo.setBounds(10, 33, 61, 14);
		panel.add(lblCodigo);
		
		lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(10, 76, 61, 14);
		panel.add(lblNombre);
		
		txtCodigo = new JTextField();
		txtCodigo.setBounds(86, 30, 86, 20);
		panel.add(txtCodigo);
		txtCodigo.setColumns(10);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(89, 73, 218, 20);
		panel.add(txtNombre);
		txtNombre.setColumns(10);
		
		chckbxEditar = new JCheckBox("Editar");
		chckbxEditar.addActionListener(this);
		chckbxEditar.setBounds(203, 24, 72, 23);
		panel.add(chckbxEditar);
		
		lblBuscar = new JLabel("Buscar");
		lblBuscar.setBounds(10, 174, 46, 14);
		getContentPane().add(lblBuscar);
		
		txtBuscar = new JTextField();
		txtBuscar.setBounds(47, 170, 270, 20);
		getContentPane().add(txtBuscar);
		txtBuscar.setColumns(10);
		
		panel_2 = new JPanel();
		panel_2.setBounds(338, 34, 113, 424);
		getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		btnNuevo = new JButton("Nuevo");
		btnNuevo.addActionListener(this);
		btnNuevo.setBounds(10, 11, 89, 23);
		panel_2.add(btnNuevo);
		
		btnGrabar = new JButton("Grabar");
		btnGrabar.addActionListener(this);
		btnGrabar.setBounds(10, 45, 89, 23);
		panel_2.add(btnGrabar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(this);
		btnCancelar.setBounds(10, 79, 89, 23);
		panel_2.add(btnCancelar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(this);
		btnEliminar.setBounds(10, 113, 89, 23);
		panel_2.add(btnEliminar);
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(this);
		btnCerrar.setBounds(10, 147, 89, 23);
		panel_2.add(btnCerrar);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 211, 312, 247);
		getContentPane().add(scrollPane);
		
		tblCargo = new JTable();
		scrollPane.setViewportView(tblCargo);
		CrearEncabezado();

	}
	
	void CrearEncabezado(){
	 mimodelo.addColumn("Codigo");
	 mimodelo.addColumn("Nombre");
	 tblCargo.setModel(mimodelo);
	}
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == chckbxEditar) {
			actionPerformedChckbxEditar(arg0);
		}
		if (arg0.getSource() == btnCerrar) {
			actionPerformedBtnCerrar(arg0);
		}
		if (arg0.getSource() == btnEliminar) {
			actionPerformedBtnEliminar(arg0);
		}
		if (arg0.getSource() == btnCancelar) {
			actionPerformedBtnCancelar(arg0);
		}
		if (arg0.getSource() == btnGrabar) {
			actionPerformedBtnGrabar(arg0);
		}
		if (arg0.getSource() == btnNuevo) {
			actionPerformedBtnNuevo(arg0);
		}
	}
	
	protected void actionPerformedBtnNuevo(ActionEvent arg0) {
		
		
	}
	
	protected void actionPerformedBtnGrabar(ActionEvent arg0) {
		
		
	}
	
	
	protected void actionPerformedBtnCancelar(ActionEvent arg0) {
		
		
	}
	
	
	
	
	protected void actionPerformedBtnEliminar(ActionEvent arg0) {
	
		
		
	}
	
	
	
	
	protected void actionPerformedBtnCerrar(ActionEvent arg0) {
		
		
		
	}
	
	
	protected void actionPerformedChckbxEditar(ActionEvent arg0) {
		
		
		
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
         dispose();
		cate=null;
		
	}
	
	
	
	void mensaje(String men){
		JOptionPane.showMessageDialog(null, men);
	}
	
	String LeerCodigo(){
		return txtCodigo.getText().trim();
	}
	
	
	String LeerNombre(){
		return txtNombre.getText().trim();
	}
	
	//aquiiiiiiiiiiiiii
	
	
	
	
	
	
}
