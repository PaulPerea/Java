package transacciones;

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



import capa_logica.ClsCliente;
import entidad.Cliente;
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
import java.awt.Font;
import javax.swing.border.LineBorder;
import javax.swing.border.BevelBorder;
import java.awt.SystemColor;




public class GuiVenta extends JInternalFrame implements ActionListener, InternalFrameListener, KeyListener, MouseListener {
	private JPanel panel;
	private JLabel lblCodigo;
	private JLabel lblCliente;
	private JTextField txtDNI;

	DefaultTableModel modelocliente;
	DefaultTableModel modeloproducto;
	DefaultTableModel modelodetalle;
	
	public static String venta="";
		
	
	String []datosclie=new String[4];
	
	String []datospro=new String[4];
	

	

	
	Cliente objClie;
	

		
	ResultSet rs;//recoger los datos
	
	
	Utilidades objU=new Utilidades();
	
	
	String estado="";
	
	private JLabel lblPrecioUnit;
	private JTextField txtDireccion;
	private JTextField txtCliente;
	private JLabel lblTotal;
	private JTextField txtTotal;
	private JPanel panel_1;
	private JLabel lblCodigo_1;
	private JLabel lblDescripcin;
	private JTextField txtCodigo;
	private JTextField txtDescripcion;
	private JLabel lblPrecio;
	private JTextField txtPrecio;
	private JTextField textField_3;
	private JLabel label_3;
	private JLabel lblCantidad;
	private JTextField txtCantidad;
	private JButton btnAdicionar;
	private JLabel lblTipoDePago;
	private JComboBox cboTP;
	private JLabel lblNewLabel;
	private JComboBox cboEstado;
	private JPanel panel_3;
	private JTable tblDetalle;
	private JScrollPane scrollPane;
	private JPanel panel_4;
	private JLabel lblBuscar;
	private JTextField txtBuscarCliente;
	private JTable tblBuscarCliente;
	private JScrollPane scrollPane_1;
	private JPanel panel_5;
	private JLabel lblCategoria;
	private JLabel lblBuscar_1;
	private JTextField txtBuscarProducto;
	private JTable tblBuscaProducto;
	private JScrollPane scrollPane_2;
	private JLabel lblVentaDeProductos;
	private JPanel panel_6;
	private JLabel lblRuc;
	private JLabel lblBoletaDeVenta;
	private JLabel lblNro;
	private JTextField txtNumero;
	private JLabel lblFechaVenta;
	private JLabel lblAvPrceresDe;
	private JLabel lblTelf;
	private JComboBox cboCat;
	private JPanel panel_2;
	private JButton btnNuevo;
	private JButton btnGrabar;
	private JButton btnCancelar;
	private JButton btnImprimir;
	private JButton btnCerrar;
	private JPanel panel_7;
	
	
	
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


	
	
	
	public GuiVenta() {
		setMaximizable(true);
		setClosable(true);
		addInternalFrameListener(this);
		venta="clie";
		
		setTitle("Registro de venta");
		setBounds(100, 100, 1049, 643);
		getContentPane().setLayout(null);
		
		panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Cliente", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(10, 93, 362, 112);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		lblCodigo = new JLabel("DNI");
		lblCodigo.setBounds(10, 33, 61, 14);
		panel.add(lblCodigo);
		
		lblCliente = new JLabel("Cliente");
		lblCliente.setBounds(10, 58, 61, 14);
		panel.add(lblCliente);
		
		txtDNI = new JTextField();
		txtDNI.setBounds(98, 30, 109, 20);
		panel.add(txtDNI);
		txtDNI.setColumns(10);
		
		lblPrecioUnit = new JLabel("Direcci\u00F3n");
		lblPrecioUnit.setBounds(10, 83, 72, 14);
		panel.add(lblPrecioUnit);
		
		txtDireccion = new JTextField();
		txtDireccion.setColumns(10);
		txtDireccion.setBounds(98, 80, 241, 20);
		panel.add(txtDireccion);
		
		txtCliente = new JTextField();
		txtCliente.setColumns(10);
		txtCliente.setBounds(98, 55, 241, 20);
		panel.add(txtCliente);
		
		lblTotal = new JLabel("Total");
		lblTotal.setBounds(297, 592, 46, 14);
		getContentPane().add(lblTotal);
		
		txtTotal = new JTextField();
		txtTotal.setBounds(392, 589, 79, 20);
		getContentPane().add(txtTotal);
		txtTotal.setColumns(10);
		
		panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Producto", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(10, 268, 472, 112);
		getContentPane().add(panel_1);
		
		lblCodigo_1 = new JLabel("Codigo");
		lblCodigo_1.setBounds(10, 33, 61, 14);
		panel_1.add(lblCodigo_1);
		
		lblDescripcin = new JLabel("Descripci\u00F3n");
		lblDescripcin.setBounds(10, 58, 61, 14);
		panel_1.add(lblDescripcin);
		
		txtCodigo = new JTextField();
		txtCodigo.setColumns(10);
		txtCodigo.setBounds(98, 30, 109, 20);
		panel_1.add(txtCodigo);
		
		txtDescripcion = new JTextField();
		txtDescripcion.setColumns(10);
		txtDescripcion.setBounds(98, 55, 298, 20);
		panel_1.add(txtDescripcion);
		
		lblPrecio = new JLabel("Precio");
		lblPrecio.setBounds(10, 83, 72, 14);
		panel_1.add(lblPrecio);
		
		txtPrecio = new JTextField();
		txtPrecio.setColumns(10);
		txtPrecio.setBounds(98, 80, 72, 20);
		panel_1.add(txtPrecio);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(98, 55, 298, 20);
		panel_1.add(textField_3);
		
		label_3 = new JLabel("");
		label_3.setBounds(294, 216, 102, 25);
		panel_1.add(label_3);
		
		lblCantidad = new JLabel("Cant.");
		lblCantidad.setBounds(193, 83, 46, 14);
		panel_1.add(lblCantidad);
		
		txtCantidad = new JTextField();
		txtCantidad.setBounds(249, 80, 61, 20);
		panel_1.add(txtCantidad);
		txtCantidad.setColumns(10);
		
		btnAdicionar = new JButton("Adicionar");
		btnAdicionar.addActionListener(this);
		btnAdicionar.setBounds(320, 79, 102, 23);
		panel_1.add(btnAdicionar);
		
		lblTipoDePago = new JLabel("Tipo de pago");
		lblTipoDePago.setBounds(20, 216, 91, 14);
		getContentPane().add(lblTipoDePago);
		
		cboTP = new JComboBox();
		cboTP.setModel(new DefaultComboBoxModel(new String[] {"Seleccione", "Efectivo", "Cheque", "Tarjeta"}));
		cboTP.setBounds(121, 213, 142, 20);
		getContentPane().add(cboTP);
		
		lblNewLabel = new JLabel("Estado");
		lblNewLabel.setBounds(273, 216, 59, 14);
		getContentPane().add(lblNewLabel);
		
		cboEstado = new JComboBox();
		cboEstado.setModel(new DefaultComboBoxModel(new String[] {"Seleccione", "Aceptado", "Pendiente"}));
		cboEstado.setBounds(315, 213, 111, 20);
		getContentPane().add(cboEstado);
		
		panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(null, "Detalle del producto", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_3.setBounds(10, 390, 461, 202);
		getContentPane().add(panel_3);
		panel_3.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 23, 451, 168);
		panel_3.add(scrollPane);
		
		tblDetalle = new JTable();
		scrollPane.setViewportView(tblDetalle);
		
		panel_4 = new JPanel();
		panel_4.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Cliente", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_4.setBounds(544, 108, 479, 196);
		getContentPane().add(panel_4);
		panel_4.setLayout(null);
		
		lblBuscar = new JLabel("Buscar");
		lblBuscar.setBounds(10, 24, 46, 14);
		panel_4.add(lblBuscar);
		
		txtBuscarCliente = new JTextField();
		txtBuscarCliente.addKeyListener(this);
		txtBuscarCliente.setBounds(66, 21, 403, 20);
		panel_4.add(txtBuscarCliente);
		txtBuscarCliente.setColumns(10);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 63, 459, 122);
		panel_4.add(scrollPane_1);
		
		tblBuscarCliente = new JTable();
		tblBuscarCliente.addMouseListener(this);
		scrollPane_1.setViewportView(tblBuscarCliente);
		
		panel_5 = new JPanel();
		panel_5.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Producto", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_5.setBounds(544, 315, 479, 277);
		getContentPane().add(panel_5);
		panel_5.setLayout(null);
		
		lblCategoria = new JLabel("Categoria");
		lblCategoria.setBounds(10, 31, 75, 14);
		panel_5.add(lblCategoria);
		
		lblBuscar_1 = new JLabel("Buscar");
		lblBuscar_1.setBounds(10, 67, 46, 14);
		panel_5.add(lblBuscar_1);
		
		txtBuscarProducto = new JTextField();
		txtBuscarProducto.addKeyListener(this);
		txtBuscarProducto.setBounds(95, 64, 374, 20);
		panel_5.add(txtBuscarProducto);
		txtBuscarProducto.setColumns(10);
		
		scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(10, 111, 459, 155);
		panel_5.add(scrollPane_2);
		
		tblBuscaProducto = new JTable();
		tblBuscaProducto.addMouseListener(this);
		scrollPane_2.setViewportView(tblBuscaProducto);
		
		cboCat = new JComboBox();
		cboCat.addActionListener(this);
		cboCat.setBounds(95, 28, 374, 20);
		panel_5.add(cboCat);
		
		lblVentaDeProductos = new JLabel("Venta de productos  al por mayor y menor\r\n");
		lblVentaDeProductos.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblVentaDeProductos.setBounds(56, 11, 316, 30);
		getContentPane().add(lblVentaDeProductos);
		
		panel_6 = new JPanel();
		panel_6.setBorder(new TitledBorder(new LineBorder(new Color(171, 173, 179)), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_6.setBounds(376, 11, 158, 116);
		getContentPane().add(panel_6);
		panel_6.setLayout(null);
		
		lblRuc = new JLabel("RUC: 20401381297");
		lblRuc.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblRuc.setBounds(29, 11, 134, 14);
		panel_6.add(lblRuc);
		
		lblBoletaDeVenta = new JLabel("BOLETA DE VENTA");
		lblBoletaDeVenta.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblBoletaDeVenta.setBounds(34, 36, 110, 14);
		panel_6.add(lblBoletaDeVenta);
		
		lblNro = new JLabel("NRO");
		lblNro.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNro.setBounds(10, 61, 50, 32);
		panel_6.add(lblNro);
		
		txtNumero = new JTextField();
		txtNumero.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtNumero.setBounds(44, 67, 110, 26);
		panel_6.add(txtNumero);
		txtNumero.setColumns(10);
		
		panel_7 = new JPanel();
		panel_7.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Fecha venta", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_7.setBounds(376, 137, 158, 43);
		getContentPane().add(panel_7);
		panel_7.setLayout(null);
		
		lblFechaVenta = new JLabel("");
		lblFechaVenta.setBounds(6, 16, 109, 20);
		panel_7.add(lblFechaVenta);
		lblFechaVenta.setBackground(new Color(211, 211, 211));
		lblFechaVenta.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		lblAvPrceresDe = new JLabel("Av. Pr\u00F3ceres de la Independencia # 1245");
		lblAvPrceresDe.setBounds(108, 45, 258, 14);
		getContentPane().add(lblAvPrceresDe);
		
		lblTelf = new JLabel("Telf: 990990215 - 989435229");
		lblTelf.setBounds(132, 70, 173, 14);
		getContentPane().add(lblTelf);
		
		panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBounds(544, 10, 479, 44);
		getContentPane().add(panel_2);
		
		btnNuevo = new JButton("Nuevo");
		btnNuevo.addActionListener(this);
		btnNuevo.setBounds(10, 11, 90, 23);
		panel_2.add(btnNuevo);
		
		btnGrabar = new JButton("Grabar");
		btnGrabar.addActionListener(this);
		btnGrabar.setBounds(110, 11, 92, 23);
		panel_2.add(btnGrabar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(this);
		btnCancelar.setBounds(212, 11, 92, 23);
		panel_2.add(btnCancelar);
		
		btnImprimir = new JButton("Imprimir");
		btnImprimir.addActionListener(this);
		btnImprimir.setBounds(305, 11, 83, 23);
		panel_2.add(btnImprimir);
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(this);
		btnCerrar.setBounds(394, 11, 75, 23);
		panel_2.add(btnCerrar);
		
		CrearEncabezadoCliente();
		CrearEncabezadoProducto();
		CrearEncabezadoDetalle();
		DeshabilitarControles();
		DeshabilitarControles2();
		cargarCategoria();
		BuscarCliente(txtBuscarCliente);
		
		lblFechaVenta.setText(objU.FechaActual());
	}
	

	void CrearEncabezadoDetalle(){
		modelodetalle=new DefaultTableModel();
		modelodetalle.addColumn("Codigo");
		modelodetalle.addColumn("Descripcion");
		modelodetalle.addColumn("Precio");
		modelodetalle.addColumn("Cant");
		modelodetalle.addColumn("Subtotal");
		tblDetalle.setModel(modelodetalle);
	}
	
	
	void CrearEncabezadoCliente(){
		modelocliente=new DefaultTableModel();
		modelocliente.addColumn("DNI");
		modelocliente.addColumn("Apellidos");
		modelocliente.addColumn("Nombres");
		modelocliente.addColumn("Direccion");
		tblBuscarCliente.setModel(modelocliente);
	}
	
	
	void CrearEncabezadoProducto(){
		modeloproducto=new DefaultTableModel();
		modeloproducto.addColumn("Codigo");
		modeloproducto.addColumn("Descripcion");
		modeloproducto.addColumn("Precio");
		modeloproducto.addColumn("Stock");
		tblBuscaProducto.setModel(modeloproducto);
	}
	
	
	
	
	
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnAdicionar) {
			actionPerformedBtnAdicionar(arg0);
		}
		if (arg0.getSource() == cboCat) {
			actionPerformedCboCat(arg0);
		}
		if (arg0.getSource() == btnImprimir) {
			actionPerformedBtnImprimir(arg0);
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
		if (arg0.getSource() == btnCerrar) {
			actionPerformedBtnCerrar(arg0);
		}
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
		venta=null;
		
	}
	
	
	void DeshabilitarControles2(){
	txtBuscarCliente.setEnabled(false);
	cboEstado.setEnabled(false);
	cboTP.setEnabled(false);
	cboCat.setEnabled(false);
	txtCantidad.setEnabled(false);
	txtBuscarProducto.setEnabled(false);
	btnAdicionar.setEnabled(false);
	
	}
	
	
	void DeshabilitarControles(){
	txtNumero.setEnabled(false);
	txtDNI.setEnabled(false);
	txtCliente.setEnabled(false);
	txtDireccion.setEnabled(false);
	txtCodigo.setEnabled(false);
	txtDescripcion.setEnabled(false);
	txtPrecio.setEnabled(false);
	txtTotal.setEnabled(false);
	
	}
	
	
	
	void HabilitarControles(){
		txtBuscarCliente.setEnabled(true);
		cboEstado.setEnabled(true);
		cboTP.setEnabled(true);
		cboCat.setEnabled(true);
		txtCantidad.setEnabled(true);
		txtBuscarProducto.setEnabled(true);
		btnAdicionar.setEnabled(true);
		
	
	}
	
	
	
	
	
	
	
	
	
	
	
	void mensaje(String men){
		JOptionPane.showMessageDialog(null, men);
	}
	
	String LeerDNI(){
		return txtDNI.getText().trim().trim();
	}
	
	
	
	
	
	String LeerNombres(){
		return txtDireccion.getText().trim();
	}
	
	
	String LeerDireccion(){
		return txtCliente.getText();
	}
	
	
	
	
	String LeerNumeroBoleta(){
		return txtNumero.getText().trim();
	}
	
	
	String LeerDni(){
		return txtDNI.getText().trim();
	}
	
	
	String LeerCodigoProd(){
		return txtCodigo.getText().trim();
	}
	
	
	String LeerDescripcion(){
		return txtDescripcion.getText().trim();
	}
	
	
	double LeerPrecio(){
		return Double.parseDouble(txtPrecio.getText());
	}
	
	
	int LeerCantidad(){
		return Integer.parseInt(txtCantidad.getText());
	}
	
	
	String LeerTP(){
		return cboTP.getSelectedItem().toString();
	}
	
	
	String LeerEstado(){
		return cboEstado.getSelectedItem().toString();
	}
	
	
	void limpiar(){
		txtNumero.setText("");
		txtBuscarCliente.setText("");
		txtBuscarProducto.setText("");
		txtCantidad.setText("");
		txtCliente.setText("");
		txtCodigo.setText("");
		txtDireccion.setText("");
		txtDNI.setText("");
		txtPrecio.setText("");
		txtCantidad.setText("");
		txtTotal.setText("");
		cboCat.setSelectedIndex(0);
		cboEstado.setSelectedIndex(0);
		cboTP.setSelectedIndex(0);
		objU.LimpiarTabla(modelocliente);
		objU.LimpiarTabla(modelodetalle);
		objU.LimpiarTabla(modeloproducto);
	}
	
	
	void Nuevo(){
		estado="Grabar";
		btnGrabar.setText("Grabar");
		HabilitarControles();
		limpiar();
		
		
	}
	void LimpiarCajasProducto() {
		txtCodigo.setText("");
		txtDescripcion.setText("");
		txtPrecio.setText("");
		txtCantidad.setText("");
	}
		
	void Grabar(){
	
		
		
	}
	
	
	
	void cancelar(){
		
	}
	
	
	void imprimir(){
		
	}
	
	
	void cerrar(){
		
	}
	
	
	
	
	
	public void keyPressed(KeyEvent arg0) {
	}
	public void keyReleased(KeyEvent arg0) {
		if (arg0.getSource() == txtBuscarProducto) {
			keyReleasedTxtBuscarProducto(arg0);
		}
		if (arg0.getSource() == txtBuscarCliente) {
			keyReleasedTxtBuscarCliente(arg0);
		}
	}
	public void keyTyped(KeyEvent arg0) {
	}
	public void mouseClicked(MouseEvent arg0) {
		if (arg0.getSource() == tblBuscaProducto) {
			mouseClickedTblBuscaProducto(arg0);
		}
		if (arg0.getSource() == tblBuscarCliente) {
			mouseClickedTblBuscarCliente(arg0);
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
	
	
	void cargarCategoria(){
		try {
			rs=objU.ListadoCategorias();
			cboCat.addItem("Seleccione");
			
			while(rs.next()){
			cboCat.addItem(rs.getString("nombre_cate"));	
			}
		} catch (Exception e) {
		}

	}
	
	void BuscarCliente(JTextField buscame) {
		try {
			objU.BuscaCliente(modelocliente, datosclie, buscame.getText());
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	void BuscarProducto(JComboBox cate, JTextField buscame) {
		try {
			objU.BuscaProducto(modeloproducto, datospro, cate.getSelectedItem().toString(), buscame.getText());
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	void AdicionarProducto() {
		try {
			String codp=LeerCodigoProd();
			double pu=LeerPrecio();
			int cant=LeerCantidad();
			String descrip=LeerDescripcion();
			double importe;
			double total=0; //es acumulador por que sumara todos los importes
			
			if(txtCantidad.getText().length()>0) {
				int confirma=JOptionPane.showConfirmDialog(null, "Estas seguro de adicionar el producto ...?","Sistema de ventas"
															,JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
				if(confirma==JOptionPane.YES_OPTION) {
					importe=pu*cant;
					Object []misdatos= {
										codp,descrip,pu,cant,importe //El mismo orden del jtable
										};	
					modelodetalle.addRow(misdatos);
					for(int i=0; i<tblDetalle.getRowCount(); i++) { //osea la cantidad de filas que hay en la tabla detalle
						
						total+=Double.parseDouble(tblDetalle.getValueAt(i, 4).toString());
					}
					txtTotal.setText(""+total);
				}
			 }
		} catch (Exception e) {
			mensaje("Falta ingresar datos necesarios");
		}
	}
	
	protected void actionPerformedBtnNuevo(ActionEvent arg0) {
		
		Nuevo();
		
		
	}
	
	protected void actionPerformedBtnGrabar(ActionEvent arg0) {
		
		
		
		
	}
	

	protected void actionPerformedBtnCancelar(ActionEvent arg0) {
		
		
	}
	protected void actionPerformedBtnImprimir(ActionEvent arg0) {
		
		
		
	}
	
	
	protected void actionPerformedBtnCerrar(ActionEvent arg0) {
		
		
		
	}
	
	protected void keyReleasedTxtBuscarCliente(KeyEvent arg0) {
		BuscarCliente(txtBuscarCliente);
	}
	protected void actionPerformedCboCat(ActionEvent arg0) {
		BuscarProducto(cboCat, txtBuscarProducto);
	}
	protected void keyReleasedTxtBuscarProducto(KeyEvent arg0) {
		BuscarProducto(cboCat, txtBuscarProducto);
	}
	protected void mouseClickedTblBuscarCliente(MouseEvent arg0) {
		int fila=tblBuscarCliente.rowAtPoint(arg0.getPoint());
		if(modelocliente.getRowCount()>0) {
			txtDNI.setText(tblBuscarCliente.getValueAt(fila, 0).toString());
			txtCliente.setText(tblBuscarCliente.getValueAt(fila, 1).toString());
			txtDireccion.setText(tblBuscarCliente.getValueAt(fila, 2).toString());
		}
	}
	protected void mouseClickedTblBuscaProducto(MouseEvent arg0) {
		int fila=tblBuscaProducto.rowAtPoint(arg0.getPoint());
		if(modeloproducto.getRowCount()>0) {
			txtCodigo.setText(tblBuscaProducto.getValueAt(fila, 0).toString());
			txtDescripcion.setText(tblBuscaProducto.getValueAt(fila, 1).toString());
			txtPrecio.setText(tblBuscaProducto.getValueAt(fila, 2).toString());
			txtCantidad.setText("");
			txtCantidad.requestFocus();
		}		
	}
	protected void actionPerformedBtnAdicionar(ActionEvent arg0) {
		AdicionarProducto();
		LimpiarCajasProducto();
	}
}














