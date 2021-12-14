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

import entidad.Categoria;
import capa_logica.ClsCategoria;
import javax.swing.table.DefaultTableModel;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;




public class GuiProducto extends JInternalFrame implements ActionListener, InternalFrameListener, KeyListener {
	private JPanel panel;
	private JLabel lblCodigo;
	private JLabel lblNombre;
	private JTextField txtCodigo;
	private JTextField txtDescripcion;
	private JLabel lblBuscar;
	private JTextField txtBuscar;
	private JPanel panel_2;
	private JButton btnNuevo;
	private JTable tblProducto;
	private JScrollPane scrollPane;
	private JButton btnGrabar;
	private JButton btnCancelar;
	private JButton btnEliminar;
	private JButton btnCerrar;
	private JCheckBox cbkEditar;

	DefaultTableModel mimodelo;
	
	public static String pro="";
		
	//Creando un arreglo para indicar la cantidad de columnas del modelo
	//String []datos=new String[2];
	
	private JLabel lblPrecioUnit;
	private JTextField txtPrecio;
	private JLabel lblStock;
	private JTextField txtStock;
	private JLabel lblProcedencia;
	private JComboBox cboProcedencia;
	private JLabel lblCategoria;
	private JComboBox cboCategoria;
	private JLabel lblCodCate;
	
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	
	
	
	public GuiProducto() {
		setClosable(true);
		addInternalFrameListener(this);
		pro="pro";
		mimodelo=new DefaultTableModel();
		setTitle("Mantenimiento de producto");
		setBounds(100, 100, 661, 585);
		getContentPane().setLayout(null);
		
		panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Producto", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(10, 11, 472, 244);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		lblCodigo = new JLabel("Codigo");
		lblCodigo.setBounds(10, 33, 61, 14);
		panel.add(lblCodigo);
		
		lblNombre = new JLabel("Descripci\u00F3n");
		lblNombre.setBounds(10, 76, 61, 14);
		panel.add(lblNombre);
		
		txtCodigo = new JTextField();
		txtCodigo.setBounds(98, 27, 86, 20);
		panel.add(txtCodigo);
		txtCodigo.setColumns(10);
		
		txtDescripcion = new JTextField();
		txtDescripcion.setBounds(98, 70, 298, 20);
		panel.add(txtDescripcion);
		txtDescripcion.setColumns(10);
		
		cbkEditar = new JCheckBox("Editar");
		cbkEditar.addActionListener(this);
		cbkEditar.setBounds(203, 24, 72, 23);
		panel.add(cbkEditar);
		
		lblPrecioUnit = new JLabel("Precio Unit");
		lblPrecioUnit.setBounds(10, 113, 72, 14);
		panel.add(lblPrecioUnit);
		
		txtPrecio = new JTextField();
		txtPrecio.setColumns(10);
		txtPrecio.setBounds(98, 101, 86, 20);
		panel.add(txtPrecio);
		
		lblStock = new JLabel("Stock");
		lblStock.setBounds(10, 146, 61, 14);
		panel.add(lblStock);
		
		txtStock = new JTextField();
		txtStock.setColumns(10);
		txtStock.setBounds(98, 140, 86, 20);
		panel.add(txtStock);
		
		lblProcedencia = new JLabel("Procedencia");
		lblProcedencia.setBounds(10, 180, 72, 14);
		panel.add(lblProcedencia);
		
		cboProcedencia = new JComboBox();
		cboProcedencia.setModel(new DefaultComboBoxModel(new String[] {"[Seleccione]", "NACIONAL", "IMPORTADO"}));
		cboProcedencia.setBounds(98, 177, 188, 20);
		panel.add(cboProcedencia);
		
		lblCategoria = new JLabel("Categoria");
		lblCategoria.setBounds(10, 219, 61, 14);
		panel.add(lblCategoria);
		
		cboCategoria = new JComboBox();
		cboCategoria.setBounds(98, 216, 188, 20);
		panel.add(cboCategoria);
		
		lblCodCate = new JLabel("");
		lblCodCate.setBounds(294, 216, 72, 25);
		panel.add(lblCodCate);
		
		lblBuscar = new JLabel("Buscar");
		lblBuscar.setBounds(10, 280, 46, 14);
		getContentPane().add(lblBuscar);
		
		txtBuscar = new JTextField();
		txtBuscar.addKeyListener(this);
		txtBuscar.setBounds(58, 277, 522, 20);
		getContentPane().add(txtBuscar);
		txtBuscar.setColumns(10);
		
		panel_2 = new JPanel();
		panel_2.setBounds(492, 45, 113, 202);
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
		scrollPane.setBounds(10, 308, 595, 216);
		getContentPane().add(scrollPane);
		
		tblProducto = new JTable();
		scrollPane.setViewportView(tblProducto);
		CrearEncabezado();
	

	}
	
	void CrearEncabezado(){
	 mimodelo.addColumn("Codigo");
	 mimodelo.addColumn("Descripción");
	 mimodelo.addColumn("Precio");
	 mimodelo.addColumn("Stock");
	 mimodelo.addColumn("Procedencia");
	 mimodelo.addColumn("Categoria");
	 tblProducto.setModel(mimodelo);
	}
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == cbkEditar) {
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
		
	pro=null;
	dispose();
		
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
		pro=null;
		
	}
	
	
	
	void mensaje(String men){
		JOptionPane.showMessageDialog(null, men);
	}
	
	String LeerCodigo(){
		return txtCodigo.getText().trim();
	}
	
	
	String LeerDescripcion(){
		return txtDescripcion.getText().trim();
	}
	
	
	double LeerPrecio(){
		return Double.parseDouble(txtPrecio.getText());
	}
	
	
	int LeerStock(){
		return Integer.parseInt(txtStock.getText());
	}
	
	
	String LeerProcedencia(){
		return cboProcedencia.getSelectedItem().toString();
	}
	
	
	String LeerCategoria(){
		return lblCodCate.getText();
	}
	
	
	
	//aquiiiiiiiiiiiiii

	
	
	
	
	
	
	
	
	public void keyPressed(KeyEvent arg0) {
	}
	public void keyReleased(KeyEvent arg0) {
		if (arg0.getSource() == txtBuscar) {
			keyReleasedTxtBuscar(arg0);
		}
	}
	public void keyTyped(KeyEvent arg0) {
	}
	protected void keyReleasedTxtBuscar(KeyEvent arg0) {
		
		
		
	}
}
