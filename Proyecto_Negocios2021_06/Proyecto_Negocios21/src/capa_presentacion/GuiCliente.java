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



//import capa_logica.ModelCliente;
import entidad.Cliente;
//import utilidades.Util;
import capa_logica.ClsCliente;
import util.Utilidades;



import javax.swing.table.DefaultTableModel;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JComboBox;
import java.awt.event.MouseListener;
import java.sql.ResultSet;
import java.awt.event.MouseEvent;
import javax.swing.DefaultComboBoxModel;




public class GuiCliente extends JInternalFrame implements ActionListener, InternalFrameListener, KeyListener, MouseListener {
	private JPanel panel;
	private JLabel lblCodigo;
	private JLabel lblNombre;
	private JTextField txtDNI;
	private JTextField txtApellidos;
	private JPanel panel_2;
	private JButton btnNuevo;
	private JButton btnGrabar;
	private JButton btnCancelar;
	private JButton btnEliminar;
	private JButton btnCerrar;
	private JCheckBox cbkEditar;

	DefaultTableModel mimodelo;
	
	public static String clie="";
		
	//Creando un arreglo para indicar la cantidad de columnas del modelo
	String []datosclie=new String[6]; //por que cuando se va a mostrar el al tabla se mostrara de select * from cliente
	

	
	//Declarar un objeto para la clase Producto
	
	Cliente objClie;
	
	//Declarar y crear un objeto para la clase ModelCliente
	
	//ModelCliente objModelClie=new ModelCliente();
	ClsCliente objCL = new ClsCliente();
	
	
	
	String estado="";
	
	ResultSet rs;
	
	Utilidades objU= new Utilidades();
	
	
	private JLabel lblPrecioUnit;
	private JTextField txtNombres;
	private JLabel lblStock;
	private JTextField txtDireccion;
	private JLabel lblProcedencia;
	private JLabel lblCategoria;
	private JComboBox cboDistrito;
	private JLabel lblCodDist;
	private JTextField txtMovil;
	private JButton btnConsultar;
	private JTable tblClientes;
	private JScrollPane scrollPane;
	
	
	
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


	
	
	
	public GuiCliente() {
		setClosable(true);
		addInternalFrameListener(this);
		clie="clie";
		mimodelo=new DefaultTableModel();
		setTitle("Mantenimiento de cliente");
		setBounds(100, 100, 661, 585);
		getContentPane().setLayout(null);
		
		panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Cliente", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(10, 11, 472, 286);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		lblCodigo = new JLabel("DNI");
		lblCodigo.setBounds(10, 33, 61, 14);
		panel.add(lblCodigo);
		
		lblNombre = new JLabel("Apellidos");
		lblNombre.setBounds(10, 76, 61, 14);
		panel.add(lblNombre);
		
		txtDNI = new JTextField();
		txtDNI.setBounds(98, 27, 86, 20);
		panel.add(txtDNI);
		txtDNI.setColumns(10);
		
		txtApellidos = new JTextField();
		txtApellidos.setBounds(98, 70, 298, 20);
		panel.add(txtApellidos);
		txtApellidos.setColumns(10);
		
		cbkEditar = new JCheckBox("Editar");
		cbkEditar.addActionListener(this);
		cbkEditar.setBounds(203, 24, 72, 23);
		panel.add(cbkEditar);
		
		lblPrecioUnit = new JLabel("Nombres");
		lblPrecioUnit.setBounds(10, 113, 72, 14);
		panel.add(lblPrecioUnit);
		
		txtNombres = new JTextField();
		txtNombres.setColumns(10);
		txtNombres.setBounds(98, 101, 298, 20);
		panel.add(txtNombres);
		
		lblStock = new JLabel("Direcci\u00F3n");
		lblStock.setBounds(10, 146, 61, 14);
		panel.add(lblStock);
		
		txtDireccion = new JTextField();
		txtDireccion.setColumns(10);
		txtDireccion.setBounds(98, 140, 298, 20);
		panel.add(txtDireccion);
		
		lblProcedencia = new JLabel("Telef_M\u00F3vil");
		lblProcedencia.setBounds(10, 180, 72, 14);
		panel.add(lblProcedencia);
		
		lblCategoria = new JLabel("Distrito");
		lblCategoria.setBounds(10, 219, 61, 14);
		panel.add(lblCategoria);
		
		cboDistrito = new JComboBox();
		cboDistrito.addActionListener(this);
		cboDistrito.setBounds(98, 216, 188, 20);
		panel.add(cboDistrito);
		
		lblCodDist = new JLabel("");
		lblCodDist.setBounds(294, 216, 102, 25);
		panel.add(lblCodDist);
		
		txtMovil = new JTextField();
		txtMovil.setColumns(10);
		txtMovil.setBounds(98, 177, 188, 20);
		panel.add(txtMovil);
		
		panel_2 = new JPanel();
		panel_2.setBounds(492, 45, 113, 252);
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
		btnCancelar.setBounds(10, 124, 89, 23);
		panel_2.add(btnCancelar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(this);
		btnEliminar.setBounds(10, 149, 89, 23);
		panel_2.add(btnEliminar);
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(this);
		btnCerrar.setBounds(10, 183, 89, 23);
		panel_2.add(btnCerrar);
		
		btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(this);
		btnConsultar.setBounds(10, 90, 89, 23);
		panel_2.add(btnConsultar);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 308, 564, 214);
		getContentPane().add(scrollPane);
		
		tblClientes = new JTable();
		tblClientes.addMouseListener(this);
		scrollPane.setViewportView(tblClientes);
		CrearEncabezado();
		ListarClientes();
		cargarDistrito();
		DeshabilitarCajas();

	}
	
	void CrearEncabezado(){
	 mimodelo.addColumn("DNI");
	 mimodelo.addColumn("Apellidos");
	 mimodelo.addColumn("Nombres");
	 mimodelo.addColumn("Dirección");
	 mimodelo.addColumn("Móvil");
	 mimodelo.addColumn("Dirección");
	 tblClientes.setModel(mimodelo);
	}
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnConsultar) {
			actionPerformedBtnConsultar(arg0);
		}
		if (arg0.getSource() == cboDistrito) {
			actionPerformedCboCategoria(arg0);
		}
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
		nuevo();
	}
	
	protected void actionPerformedBtnGrabar(ActionEvent arg0) {
	
		Grabar();
		
	}
	
	
	protected void actionPerformedBtnCancelar(ActionEvent arg0) {
		
		
	}
	
	
	
	
	protected void actionPerformedBtnEliminar(ActionEvent arg0) {
	
		
		
	}
	
	
	
	
	protected void actionPerformedBtnCerrar(ActionEvent arg0) {
		
	clie=null;
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
		clie=null;
		
	}
	void mensaje(String men){
		JOptionPane.showMessageDialog(null, men);
	}
	
	String LeerDNI(){
		return txtDNI.getText().trim();
	}
	
	
	String LeerApellidos(){
		return txtApellidos.getText().trim();
	}
	
	
	String LeerNombres(){
		return txtNombres.getText();
	}
	
	
	String LeerDireccion(){
		return txtDireccion.getText();
	}
	
	
	String LeerMovil(){
		return txtMovil.getText().trim();
	}
	
	
	String LeerCodigoDistrito(){
		return lblCodDist.getText();
	}
	
	
	
	//aquiiiiiiiiiiiiii

	void ListarClientes(){
		try {
			objCL.ListadoCliente(mimodelo, datosclie);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	
	
	void cargarDistrito(){

		try {
			rs=objU.ListadoDistrito();
			cboDistrito.addItem("Seleccione");
			while(rs.next()) {
				cboDistrito.addItem(rs.getString("NOMBRE_DISTRITO"));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	
	
	
	void ConsultarClienteXdni(){
		
		try { 
            String busca=JOptionPane.showInputDialog("Ingrese DNI A Buscar"); 
            rs=objCL.ConsultarClientexDNI(busca); 
	            while(rs.next()){
	                   txtDNI.setText(rs.getString("DNI")); 
	                   txtApellidos.setText(rs.getString("APELLIDOS"));
	                   txtNombres.setText(rs.getString("NOMBRES"));
	                   txtDireccion.setText(rs.getString("DIRECCION"));
	                   txtMovil.setText(rs.getString("TELE_MOVIL"));
	                  cboDistrito.setSelectedItem(rs.getString("NOMBRE_DISTRITO"));
	                   } 
	            } catch (Exception e) { 
                   

            } 
     finally { 
            try { 
                   if (rs!=null)rs.close(); 
                   } 
            catch (Exception e2) 
            { System.out.println("Error al cerrar"+e2.getMessage());
            
            }//fin del finally 

     }
		
	}
	
	
	
	
	
	
	void habilitarCajas(){
		txtDNI.setEnabled(true);
		txtApellidos.setEnabled(true);
		txtNombres.setEnabled(true);
		txtDireccion.setEnabled(true);
		txtMovil.setEnabled(true);
		cboDistrito.setEnabled(true);
		
	}
	
	
	void DeshabilitarCajas(){
		txtDNI.setEnabled(false);
		txtApellidos.setEnabled(false);
		txtNombres.setEnabled(false);
		txtDireccion.setEnabled(false);
		txtMovil.setEnabled(false);
		cboDistrito.setEnabled(false);
	}
	
		
	void nuevo(){
	 estado="Grabar";
	 btnGrabar.setText("Grabar");
	 habilitarCajas();
	 txtDNI.setText("");
	 txtApellidos.setText("");
	 txtNombres.setText("");
	 txtDireccion.setText("");
	 txtMovil.setText("");
	 cboDistrito.setSelectedIndex(0);
	 txtDNI.requestFocus();
	}
	
		
	void Grabar(){
	
		String numDNI=LeerDNI();
        String ape=LeerApellidos(); 
        String nom=LeerNombres(); 
        String direc=LeerDireccion(); 
        String mov=LeerMovil(); 
        String coddis=lblCodDist.getText(); 
        int confirma; 
        if(estado.equalsIgnoreCase("Grabar")){ 
               confirma=JOptionPane.showConfirmDialog(null, "Esta seguro de grabar..?", "Sistema de venta",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE); 
               //validando confirma 
               if(confirma==JOptionPane.YES_OPTION){ 
                      objClie=new Cliente(numDNI, ape, nom, direc, mov, coddis); 
                      int salida=objCL.RegistrarCliente(objClie); 
                      //validamos salida 
                      if(salida>0){ 
                             mensaje("Registrado correctamente"); 
                             nuevo();
                             DeshabilitarCajas(); 
                             ListarClientes(); 
                      }
                      else { 
                             mensaje("Error en el registro"); 
                      } 

               } 

        }//fin de la pregunta estado  
		
	}
	
	
	
	void cancelar(){
		
	}
	
	
	void eliminar(){
		
	}
	
	
	void cerrar(){
		
	}
	
	
	
	
	
	public void keyPressed(KeyEvent arg0) {
	}
	public void keyReleased(KeyEvent arg0) {
	}
	public void keyTyped(KeyEvent arg0) {
	}
	public void mouseClicked(MouseEvent arg0) {
		if (arg0.getSource() == tblClientes) {
			mouseClickedTblClientes(arg0);
		}
	}
	public void mouseEntered(MouseEvent arg0) {
	}
	public void mouseExited(MouseEvent arg0) {
	}
	public void mousePressed(MouseEvent arg0) {
	}
	public void mouseReleased(MouseEvent e) {
	}
	protected void actionPerformedCboCategoria(ActionEvent arg0) {
		
		lblCodDist.setText(""+Utilidades.MostrarCodigoDistrito(cboDistrito.getSelectedItem().toString()));
		
	}
	protected void actionPerformedBtnConsultar(ActionEvent arg0) {
		
		
	ConsultarClienteXdni();
		
		
		
	}
	protected void mouseClickedTblClientes(MouseEvent e) {
		
		if(mimodelo.getRowCount()>0){
		
		int fila=tblClientes.rowAtPoint(e.getPoint());
		txtDNI.setText(tblClientes.getValueAt(fila, 0).toString());
		txtApellidos.setText(tblClientes.getValueAt(fila, 1).toString());
		txtNombres.setText(tblClientes.getValueAt(fila, 2).toString());
		txtDireccion.setText(tblClientes.getValueAt(fila, 3).toString());
		txtMovil.setText(tblClientes.getValueAt(fila, 4).toString());

		cboDistrito.setSelectedItem(tblClientes.getValueAt(fila, 5).toString());
		

		}
		
		
	}
}














