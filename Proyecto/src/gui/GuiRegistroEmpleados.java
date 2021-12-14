package gui;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.InternalFrameEvent;
import javax.swing.table.DefaultTableModel;

import capa_logica.ClsEmpleado;
import entidades.Cliente;
import entidades.Empleado;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import java.awt.Color;

import validaciones.ClsValidacionesEmpleado;
import java.awt.event.KeyListener;
import javax.swing.JCheckBox;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

public class GuiRegistroEmpleados extends JInternalFrame implements ActionListener, KeyListener, MouseListener {
	ClsValidacionesEmpleado Vpro = new ClsValidacionesEmpleado();
	ClsEmpleado objEmp=new ClsEmpleado();
	String [] misdatos=new String[6];
	
	
	private JLabel lblNombre;
	private JLabel lblApellido;
	private JLabel lblDni;
	private JLabel lblCargo;
	private JLabel lblEdad;
	private JLabel lblId;
	private JTextField txtnombre;
	private JTextField txtApellidos;
	private JTextField txtDni;
	private JTextField txtCargo;
	private JTextField txtedad;
	private JTextField txtID;
	private JButton btnAgregar;
	private JButton btnNuevo;
	private JButton btnCancelar;
	private JButton btnEliminar;
	private final JTable table = new JTable();
	private JScrollPane scrollPane;
	
	private JCheckBox cboEditar;
	private JButton btnCerrar;
	
	DefaultTableModel mimodelo;
	
	String estado="";
	Empleado emp;
	public static String Emp=""; //enlace
	private JLabel lblBuscar;
	private JTextField txtBuscar;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiRegistroEmpleados frame = new GuiRegistroEmpleados();
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
	public GuiRegistroEmpleados() {
		getContentPane().setBackground(new Color(245, 245, 220));
		Emp="Emp";
		setMaximizable(true);
		setClosable(true);
		setTitle("Registro Empleado");
		setBounds(100, 100, 639, 528);
		getContentPane().setLayout(null);
		
		mimodelo=new DefaultTableModel();
		lblNombre = new JLabel("Nombres");
		lblNombre.setBounds(10, 14, 60, 14);
		getContentPane().add(lblNombre);
		
		lblApellido = new JLabel("Apellidos");
		lblApellido.setBounds(10, 50, 60, 14);
		getContentPane().add(lblApellido);
		
		lblDni = new JLabel("DNI");
		lblDni.setBounds(10, 89, 60, 14);
		getContentPane().add(lblDni);
		
		lblCargo =  new JLabel("Cargo");
		lblCargo.setBounds(10, 117, 60, 14);
		getContentPane().add(lblCargo);
		
		lblEdad = new JLabel("Edad");
		lblEdad.setBounds(325, 34, 46, 14);
		getContentPane().add(lblEdad);
		
		lblId = new JLabel("ID");
		lblId.setBounds(325, 62, 46, 14);
		getContentPane().add(lblId);
		
		txtnombre = new JTextField();
		txtnombre.addKeyListener(this);
		txtnombre.setColumns(10);
		txtnombre.setBounds(66, 11, 222, 20);
		getContentPane().add(txtnombre);
		
		txtApellidos = new JTextField();
		txtApellidos.addKeyListener(this);
		txtApellidos.setColumns(10);
		txtApellidos.setBounds(66, 48, 222, 20);
		getContentPane().add(txtApellidos);
		
		txtDni = new JTextField();
		txtDni.addKeyListener(this);
		txtDni.setColumns(10);
		txtDni.setBounds(66, 87, 222, 20);
		getContentPane().add(txtDni);
		
		txtCargo = new JTextField();
		txtCargo.addKeyListener(this);
		txtCargo.setColumns(10);
		txtCargo.setBounds(66, 114, 222, 20);
		getContentPane().add(txtCargo);
		
		txtedad = new JTextField();
		txtedad.addKeyListener(this);
		txtedad.setColumns(10);
		txtedad.setBounds(368, 32, 53, 20);
		getContentPane().add(txtedad);
		
		txtID = new JTextField();
		txtID.addKeyListener(this);
		txtID.setColumns(10);
		txtID.setBounds(368, 58, 53, 20);
		getContentPane().add(txtID);
		
		btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(this);
		btnAgregar.setBounds(503, 10, 118, 23);
		getContentPane().add(btnAgregar);
		
		btnNuevo = new JButton("Nuevo");
		btnNuevo.addActionListener(this);
		btnNuevo.setBounds(503, 46, 118, 23);
		getContentPane().add(btnNuevo);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(this);
		btnCancelar.setBounds(503, 85, 118, 23);
		getContentPane().add(btnCancelar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(this);
		btnEliminar.setBounds(503, 118, 118, 23);
		getContentPane().add(btnEliminar);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 180, 611, 309);
		getContentPane().add(scrollPane);
		table.addMouseListener(this);
		scrollPane.setViewportView(table);
		
		cboEditar = new JCheckBox("Editar");
		cboEditar.addActionListener(this);
		cboEditar.setBounds(325, 114, 93, 21);
		getContentPane().add(cboEditar);
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(this);
		btnCerrar.setBounds(503, 151, 118, 23);
		getContentPane().add(btnCerrar);
		
		lblBuscar = new JLabel("Buscar");
		lblBuscar.setBounds(325, 90, 46, 14);
		getContentPane().add(lblBuscar);
		
		txtBuscar = new JTextField();
		txtBuscar.addKeyListener(this);
		txtBuscar.setColumns(10);
		txtBuscar.setBounds(368, 87, 77, 20);
		getContentPane().add(txtBuscar);

		CrearEncabezado();
		listarEmpleado(txtBuscar);
		DesHabilitarCajas();
	}
	void CrearEncabezado(){
		
		 mimodelo.addColumn("Nombre");
		 mimodelo.addColumn("Apellido");
		 mimodelo.addColumn("DNI");
		 mimodelo.addColumn("CARGO");
		 mimodelo.addColumn("Edad");
		 mimodelo.addColumn("ID");
		 table.setModel(mimodelo);	
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == cboEditar) {
			actionPerformedCboEditar(e);
		}
		if (e.getSource() == btnCerrar) {
			actionPerformedBtnCerrar(e);
		}
		if (e.getSource() == btnNuevo) {
			actionPerformedBtnNuevo(e);
		}
		if (e.getSource() == btnAgregar) {
			actionPerformedBtnAgregar(e);
		}
		if (e.getSource() == btnEliminar) {
			actionPerformedBtnEliminar(e);
		}
		if (e.getSource() == btnCancelar) {
			actionPerformedBtnCancelar(e);
		}
		
	}
	protected void actionPerformedBtnCancelar(ActionEvent e) {
		Cancelar();
	}
	protected void actionPerformedBtnEliminar(ActionEvent e) {
		Eliminar();
	}
	String Leerid() {
		return txtID.getText().trim();
	}
	String Leernom() {
		return txtnombre.getText().trim();
	}
	String leerApe() {
		return txtApellidos.getText().trim();
	}
	String leerdni() {
		return txtDni.getText().trim();
	}
	String leerEdad() {
		return txtedad.getText().trim();
	}
	String leerCargo() {
		return txtCargo.getText().trim();
	}
	void listarEmpleado(JTextField buscame) {
		try {
			objEmp.sql="select nom_emp,ape_emp,dni_emp,cargo_emp,edad_emp,id_emp from EMPLEADO WHERE (nom_emp like'"+buscame.getText()+"%' or ape_emp like'" + buscame.getText() +"%'or dni_emp like'" + buscame.getText() +"%'or cargo_emp like'" + buscame.getText() +"%' or edad_emp like'" +
					buscame.getText() +"%' or id_emp like'" + buscame.getText() +"%' )order by id_emp"; //no interesa si esta en min o mayus
			objEmp.ListadoEmpleado(mimodelo, misdatos, objEmp.sql); //es la jtable , los datos que son de COD_CATE,NOMBRE_CATE from osea 2, y sql de arribita
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	void LimpiarCajas() {
		txtID.setText("");
		txtnombre.setText("");
		txtApellidos.setText("");
		txtDni.setText("");
		txtCargo.setText("");
		txtedad.setText("");
		txtID.requestFocus();
		
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
	void mensaje(String men){
		JOptionPane.showMessageDialog(null, men);
	}
	void Cerrar() {
		int	mensaje=JOptionPane.showConfirmDialog(null, "Esta seguro de cerrar?","Sistema de Empleado",
				JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE);

		if(mensaje==JOptionPane.YES_OPTION)
			dispose();
			emp=null;
		
	}
	void Eliminar() {
		if(!txtID.getText().equals("")) {//se refiere si en el txt codigo tiene codigo no se elimina, de lo contrario si
			
			int	mensaje=JOptionPane.showConfirmDialog(null, "Esta seguro de eliminar este registro?","Sistema de Empleado",
					JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE);
				if(mensaje == JOptionPane.YES_OPTION) {
					emp=new Empleado();
					emp.setId(txtID.getText()); //gettext es lo que insertaste en la caja
					
					int salida=objEmp.EliminarEmpleado(emp);
					
					if(salida > 0)  //si es mayor a 0 es exito , de lo contrario es fracaso
						mensaje("Eliminado correctamente...");
					else mensaje("Error al eliminar...");
					listarEmpleado(txtBuscar);	
					}
			}
				
		}
	void Grabar() {
		int mensaje;
		String nom,ape,dni,edad,id,cargo;
		nom=txtnombre.getText();
		ape=txtApellidos.getText();
		dni=txtDni.getText();
		edad=txtedad.getText();
		id=txtID.getText();
		cargo=txtCargo.getText();
		if(estado.equalsIgnoreCase("Grabar")) {
			mensaje=JOptionPane.showConfirmDialog(null, "Desea Grabar..?","Sistema de Empleado",
													JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE);
				//ahora validamos el mensaje
			if(mensaje==JOptionPane.YES_OPTION) {
				emp=new Empleado( nom,ape, dni,cargo, edad,id);
				int salida=objEmp.RegistrarEmpleado(emp);
				if(salida>0)
					mensaje("Registrado correctamente");
					
				else
					mensaje("Error en el registro");
				listarEmpleado(txtBuscar);
				DesHabilitarCajas();
			}
		}
		else if(estado.equalsIgnoreCase("Actualizar")) {
			mensaje=JOptionPane.showConfirmDialog(null, "Desea Actualizar..?","Sistema de Empleado",
					JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE);
				if(mensaje==JOptionPane.YES_OPTION) {
					emp=new Empleado( nom,ape, dni,cargo, edad,id);
					int salida=objEmp.ActualizarEmpleado(emp);
					if(salida>0)
						mensaje("Actualizado Correctamente");
					else 
						mensaje("Error en la actualizacion");
					listarEmpleado(txtBuscar); 
					LimpiarCajas();
					DesHabilitarCajas();
					cboEditar.setSelected(false);
				}
		}
	}
	void HabilitarCaja() {
		txtID.setEnabled(true);
		txtnombre.setEnabled(true);
		txtApellidos.setEnabled(true);
		txtDni.setEnabled(true);
		txtCargo.setEnabled(true);
		txtedad.setEnabled(true);
	}
	void DesHabilitarCajas() {
		txtID.setEnabled(false);
		txtnombre.setEnabled(false);
		txtApellidos.setEnabled(false);
		txtDni.setEnabled(false);
		txtCargo.setEnabled(false);
		txtedad.setEnabled(false);
	}
	
	public void keyPressed(KeyEvent e) {
	}
	public void keyReleased(KeyEvent e) {
		if (e.getSource() == txtBuscar) {
			keyReleasedTxtBuscar(e);
		}
	}
	public void keyTyped(KeyEvent e) {
		if (e.getSource() == txtID) {
			keyTypedTxtID(e);
		}
		if (e.getSource() == txtedad) {
			keyTypedTextField_4(e);
		}
		if (e.getSource() == txtCargo) {
			keyTypedTxtCargo(e);
		}
		if (e.getSource() == txtDni) {
			keyTypedTxtDni(e);
		}
		if (e.getSource() == txtApellidos) {
			keyTypedTxtApellidos(e);
		}
		if (e.getSource() == txtnombre) {
			keyTypedTxtnombre(e);
		}
	}
	protected void keyTypedTxtnombre(KeyEvent e) {
		Vpro.ValidarNombres(txtnombre, e);
	}
	protected void keyTypedTxtApellidos(KeyEvent e) {
		Vpro.ValidarApellidos(txtApellidos, e);
	}
	protected void keyTypedTxtDni(KeyEvent e) {
		Vpro.ValidarDNI(txtDni, e);
	}
	
	protected void keyTypedTxtCargo(KeyEvent e) {
		Vpro.ValidarCargo(txtCargo, e);
	}
	protected void keyTypedTextField_4(KeyEvent e) {
		Vpro.validaEdad(txtedad, e);
	}
	protected void keyTypedTxtID(KeyEvent e) {
		Vpro.ValidarCodigo(txtID, e);
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
			txtnombre.setText(table.getValueAt(fila, 0).toString());
			txtApellidos.setText(table.getValueAt(fila, 1).toString());
			txtDni.setText(table.getValueAt(fila, 2).toString());
			txtCargo.setText(table.getValueAt(fila, 3).toString());
			txtedad.setText(table.getValueAt(fila, 4).toString());
			txtID.setText(table.getValueAt(fila, 5).toString());
		}
	}
	protected void keyReleasedTxtBuscar(KeyEvent e) {
		listarEmpleado(txtBuscar);
	}
	protected void actionPerformedBtnAgregar(ActionEvent e) {
		Grabar();
	}
	protected void actionPerformedBtnNuevo(ActionEvent e) {
		Nuevo();
	}
	
	protected void actionPerformedBtnCerrar(ActionEvent e) {
		Cerrar();
	}
	protected void actionPerformedCboEditar(ActionEvent e) {
		if(cboEditar.isSelected()) {
			estado="Actualizar";
			btnAgregar.setText("Actualizar");
			HabilitarCaja();
			txtID.setEnabled(false);
		}
		else {
			estado="Grabar";
			btnAgregar.setText("Grabar");
			LimpiarCajas();
			DesHabilitarCajas();
		}
	}
}
