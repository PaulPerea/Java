package gui;

import java.awt.EventQueue;

import validaciones.ClsValidacionesProducto;

import javax.swing.JInternalFrame;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.event.KeyEvent;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

import capa_logica.ClsProducto;
import entidades.Producto;
import javax.swing.JCheckBox;

public class GuiRegistroProductos extends JInternalFrame implements ActionListener, KeyListener,MouseListener {
	
	ClsValidacionesProducto Pro = new ClsValidacionesProducto();
	ClsProducto objPro = new ClsProducto();
	String []misdatos = new String[5];
	
	
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JTextField txtId;
	private JTextField txtDesc;
	private JTextField txtCant;
	private JTextField txtProv;
	private JButton btnAgregar;
	private JButton btnNuevo;
	private JButton btnCancelar;
	private JButton btnCerrar;
	private JTable table;
	private JScrollPane scrollPane;
	
	DefaultTableModel mimodelo;
	String estado="";
	Producto prod;
	private JLabel lblNewLabel_4;
	private JTextField txtBuscar;
	private JCheckBox cboEditar;
	private JButton btnEliminar;
	
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiRegistroProductos frame = new GuiRegistroProductos();
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
	public GuiRegistroProductos() {
		
		mimodelo=new DefaultTableModel();
		getContentPane().setBackground(new Color(240, 248, 255));
		setMaximizable(true);
		setClosable(true);
		setTitle("Registro Producto");
		setBounds(100, 100, 589, 485);
		getContentPane().setLayout(null);
		
		lblNewLabel = new JLabel("ID");
		lblNewLabel.setBounds(10, 13, 45, 13);
		getContentPane().add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Descripci\u00F3n");
		lblNewLabel_1.setBounds(10, 54, 75, 13);
		getContentPane().add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Cantidad");
		lblNewLabel_2.setBounds(10, 97, 59, 13);
		getContentPane().add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("Proveedor");
		lblNewLabel_3.setBounds(10, 136, 75, 13);
		getContentPane().add(lblNewLabel_3);
		
		txtId = new JTextField();
		txtId.addKeyListener(this);
		txtId.setColumns(10);
		txtId.setBounds(95, 7, 162, 19);
		getContentPane().add(txtId);
		
		txtDesc = new JTextField();
		txtDesc.addKeyListener(this);
		txtDesc.setColumns(10);
		txtDesc.setBounds(95, 48, 162, 19);
		getContentPane().add(txtDesc);
		
		txtCant = new JTextField();
		txtCant.addKeyListener(this);
		txtCant.setColumns(10);
		txtCant.setBounds(95, 91, 52, 19);
		getContentPane().add(txtCant);
		
		txtProv = new JTextField();
		txtProv.addKeyListener(this);
		txtProv.setColumns(10);
		txtProv.setBounds(95, 130, 162, 19);
		getContentPane().add(txtProv);
		
		btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(this);
		btnAgregar.setBounds(449, 18, 118, 23);
		getContentPane().add(btnAgregar);
		
		btnNuevo = new JButton("Nuevo");
		btnNuevo.addActionListener(this);
		btnNuevo.setBounds(449, 54, 118, 23);
		getContentPane().add(btnNuevo);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(this);
		btnCancelar.setBounds(449, 131, 118, 23);
		getContentPane().add(btnCancelar);
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(this);
		btnCerrar.setBounds(449, 163, 118, 23);
		getContentPane().add(btnCerrar);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 196, 556, 250);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(this);
		scrollPane.setViewportView(table);
		
		lblNewLabel_4 = new JLabel("Buscar");
		lblNewLabel_4.setBounds(267, 51, 45, 13);
		getContentPane().add(lblNewLabel_4);
		
		txtBuscar = new JTextField();
		txtBuscar.addKeyListener(this);
		txtBuscar.setBounds(309, 48, 75, 19);
		getContentPane().add(txtBuscar);
		txtBuscar.setColumns(10);
		
		cboEditar = new JCheckBox("Editar");
		cboEditar.addActionListener(this);
		cboEditar.setBounds(267, 77, 93, 21);
		getContentPane().add(cboEditar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(this);
		btnEliminar.setBounds(449, 92, 118, 23);
		getContentPane().add(btnEliminar);
		CrearEncabezado();
		listarProducto(txtBuscar);
		DesHabilitarCajas();
		

	}
	void CrearEncabezado(){
		
		 mimodelo.addColumn("Descripción");
		 mimodelo.addColumn("Cantidad");
		 mimodelo.addColumn("Nombre Proveedor");
		 mimodelo.addColumn("ID");
		 table.setModel(mimodelo);	
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCancelar) {
			actionPerformedBtnCancelar(e);
		}
		if (e.getSource() == btnEliminar) {
			actionPerformedBtnEliminar(e);
		}
		if (e.getSource() == btnNuevo) {
			actionPerformedBtnNuevo(e);
		}
		if (e.getSource() == btnAgregar) {
			actionPerformedBtnAgregar(e);
		}
		if (e.getSource() == btnCerrar) {
			actionPerformedBtnCerrar(e);
		}
		if (e.getSource() == cboEditar) {
			actionPerformedChckbxEditar(e);
		}
	}
	protected void actionPerformedChckbxEditar(ActionEvent e) {
		if(cboEditar.isSelected()) {
			estado="Actualizar";
			btnAgregar.setText("Actualizar");
			HabilitarCaja();
			txtId.setEnabled(false);
		}
		else {
			estado="Grabar";
			btnAgregar.setText("Grabar");
			LimpiarCajas();
			DesHabilitarCajas();
		}
	}
	protected void actionPerformedBtnCerrar(ActionEvent e) {
		Cerrar();
		
	}
	String Leerid() {
		return txtId.getText().trim();
	}
	String LeerDes() {
		return txtDesc.getText().trim();
	}
	String LeerCant() {
		return txtCant.getText().trim();
	}
	String LeerProv() {
		return txtProv.getText().trim();
	}
	void mensaje(String men){
		JOptionPane.showMessageDialog(null, men);
	}
	void LimpiarCajas() {
		txtId.setText("");
		txtDesc.setText("");
		txtCant.setText("");
		txtProv.setText("");
		txtId.requestFocus();	
	}
	void listarProducto(JTextField buscame) {
		try {
			objPro.sql="select desc_pro,cant_pro,prov_pro,id_pro from PRODUCTO WHERE (desc_pro like'"+buscame.getText()+"%' or cant_pro like'" + buscame.getText() +"%'or prov_pro like'" + buscame.getText() +"%' or id_pro like'" +
					buscame.getText() +"%' )order by id_pro"; //no interesa si esta en min o mayus
			objPro.ListadoProducto(mimodelo, misdatos, objPro.sql); //es la jtable , los datos que son de COD_CATE,NOMBRE_CATE from osea 2, y sql de arribita
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	void Grabar() {
		int mensaje;
		String desc,cant,pro,id;
		desc=txtDesc.getText();
		cant=txtCant.getText();
		pro=txtProv.getText();
		id=txtId.getText();
		if(estado.equalsIgnoreCase("Grabar")) {
			mensaje=JOptionPane.showConfirmDialog(null, "Desea Grabar..?","Sistema de Producto",
													JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE);
				//ahora validamos el mensaje
			if(mensaje==JOptionPane.YES_OPTION) {
				prod=new Producto(desc,cant,pro,id);
				int salida=objPro.RegistrarProducto(prod);
				if(salida>0)
					mensaje("Registrado correctamente");
					
				else
					mensaje("Error en el registro");
				listarProducto(txtBuscar);
				DesHabilitarCajas();
			}
		}
		else if(estado.equalsIgnoreCase("Actualizar")) {
			mensaje=JOptionPane.showConfirmDialog(null, "Desea Actualizar..?","Sistema de Producto",
					JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE);
				if(mensaje==JOptionPane.YES_OPTION) {
					prod=new Producto(desc,cant,pro,id);
					int salida=objPro.ActualizarProducto(prod);
					if(salida>0)
						mensaje("Actualizado Correctamente");
					else 
						mensaje("Error en la actualizacion");
					listarProducto(txtBuscar); 
					LimpiarCajas();
					DesHabilitarCajas();
					cboEditar.setSelected(false);
				}
		}
	}
	void Eliminar() {
		if(!txtId.getText().equals("")) {//se refiere si en el txt codigo tiene codigo no se elimina, de lo contrario si
			
			int	mensaje=JOptionPane.showConfirmDialog(null, "Esta seguro de eliminar este registro?","Sistema de Producto",
					JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE);
				if(mensaje == JOptionPane.YES_OPTION) {
					prod=new Producto();
					prod.setId(txtId.getText()); //gettext es lo que insertaste en la caja
					
					int salida=objPro.EliminarProducto(prod);
					
					if(salida > 0)  //si es mayor a 0 es exito , de lo contrario es fracaso
						mensaje("Eliminado correctamente...");
					else mensaje("Error al eliminar...");
					listarProducto(txtBuscar);	
					}
			}
				
	}
	void Nuevo() {
		estado="Grabar";
		btnAgregar.setText("Grabar");
		HabilitarCaja();
		LimpiarCajas();
	}
	void Cancelar() {
		LimpiarCajas();
		DesHabilitarCajas();
				
	}
	void Cerrar() {
		int	mensaje=JOptionPane.showConfirmDialog(null, "Esta seguro de cerrar?","Sistema de Producto",
				JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE);

		if(mensaje==JOptionPane.YES_OPTION)
			dispose();
			prod=null;
		
	}
	void HabilitarCaja() {
		txtId.setEnabled(true);
		txtDesc.setEnabled(true);
		txtCant.setEnabled(true);
		txtProv.setEnabled(true);
		
	}
	void DesHabilitarCajas() {
		txtId.setEnabled(false);
		txtDesc.setEnabled(false);
		txtProv.setEnabled(false);
		txtCant.setEnabled(false);
	}
	public void keyPressed(KeyEvent e) {
	}
	public void keyReleased(KeyEvent e) {
		if (e.getSource() == txtBuscar) {
			keyReleasedTxtBuscar(e);
		}
	}
	
	public void keyTyped(KeyEvent e) {
		if (e.getSource() == txtProv) {
			keyTypedTxtProv(e);
		}
		if (e.getSource() == txtCant) {
			keyTypedTxtCant(e);
		}
		if (e.getSource() == txtDesc) {
			keyTypedTxtDesc(e);
		}
		if (e.getSource() == txtId) {
			keyTypedTxtId(e);
		}
	}
	protected void keyReleasedTxtBuscar(KeyEvent e) {
		listarProducto(txtBuscar);
	}
	protected void keyTypedTxtId(KeyEvent e) {
		Pro.ValidarCodigo(txtId, e);
	}
	
	protected void keyTypedTxtDesc(KeyEvent e) {
		Pro.ValidarDescripcion(txtDesc, e);
	}
	
	protected void keyTypedTxtCant(KeyEvent e) {
		Pro.ValidarCantidad(txtCant, e);
	}
	
	protected void keyTypedTxtProv(KeyEvent e) {
		Pro.ValidarProvedor(txtProv, e);
	}
	protected void actionPerformedBtnAgregar(ActionEvent e) {
		Grabar();
	}
	protected void actionPerformedBtnNuevo(ActionEvent e) {
		Nuevo();
	}
	protected void actionPerformedBtnEliminar(ActionEvent e) {
		Eliminar();
	}
	protected void actionPerformedBtnCancelar(ActionEvent e) {
		Cancelar();
	}
	
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == table) {
			mouseClickedTable(e);
		}
	}
	public void mouseEntered(MouseEvent e) {
	}
	public void mouseExited(MouseEvent e) {
	}
	public void mousePressed(MouseEvent e) {
	}
	public void mouseReleased(MouseEvent e) {
	}
	protected void mouseClickedTable(MouseEvent e) {
		if(mimodelo.getRowCount()>0) {
			int fila=table.rowAtPoint(e.getPoint());
			//JOptionPane.showMessageDialog(null, fila);
			txtDesc.setText(table.getValueAt(fila, 0).toString());
			txtCant.setText(table.getValueAt(fila, 1).toString());
			txtProv.setText(table.getValueAt(fila, 2).toString());
			txtId.setText(table.getValueAt(fila, 3).toString());
		}
	}
	
	
}
