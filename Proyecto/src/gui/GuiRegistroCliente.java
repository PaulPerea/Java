package gui;

import java.awt.EventQueue;
import java.awt.event.KeyEvent;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import javax.swing.table.DefaultTableModel;

import capa_logica.ClsCliente;
import entidades.Cliente;
import validaciones.ClsValidacionesCliente;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import java.awt.Color;
import javax.swing.JCheckBox;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.event.KeyListener;

public class GuiRegistroCliente extends JInternalFrame implements ActionListener, KeyListener, MouseListener {
	
	ClsValidacionesCliente VClie = new ClsValidacionesCliente();
	ClsCliente objClie = new ClsCliente();
	String []misdatos=new String[5];
	
	
	
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtDNI;
	private JTextField txtEdad;
	private JTextField txtId;
	private JButton btnAgregar;
	private JButton btnNuevo;
	private JButton btnCancelar;
	private JButton btnCerrar;
	private JLabel lblNewLabel_5;
	private JTable table;
	private JScrollPane scrollPane;
	
	
	DefaultTableModel mimodelo;
	
	String estado="";
	Cliente clie; //entidad
	public static String Clie=""; //enlace
	private JTextField txtBuscar;
	private JLabel lblNewLabel_6;
	private JCheckBox cboEditar;
	private JButton btnEliminar;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//GuiRegistroCliente frame = new GuiRegistroCliente();
					//frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GuiRegistroCliente() {
		Clie="Clie";
		mimodelo=new DefaultTableModel();
		getContentPane().setBackground(new Color(240, 255, 240));
		setBackground(new Color(255, 228, 181));
		setToolTipText("");
		setTitle("Registro Cliente");
		setMaximizable(true);
		setResizable(true);
		setClosable(true);
		
		setBounds(100, 100, 699, 518);
		getContentPane().setLayout(null);
		
		lblNewLabel = new JLabel("Nombres");
		lblNewLabel.setBounds(10, 24, 60, 13);
		getContentPane().add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Apellidos");
		lblNewLabel_1.setBounds(10, 65, 60, 13);
		getContentPane().add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("DNI");
		lblNewLabel_2.setBounds(10, 108, 45, 13);
		getContentPane().add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("Edad");
		lblNewLabel_3.setBounds(10, 147, 45, 13);
		getContentPane().add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("ID");
		lblNewLabel_4.setBounds(262, 30, 45, 13);
		getContentPane().add(lblNewLabel_4);
		
		txtNombre = new JTextField();
		txtNombre.addKeyListener(this);
		txtNombre.setColumns(10);
		txtNombre.setBounds(65, 21, 162, 19);
		getContentPane().add(txtNombre);
		
		txtApellido = new JTextField();
		txtApellido.addKeyListener(this);
		txtApellido.setColumns(10);
		txtApellido.setBounds(65, 62, 162, 19);
		getContentPane().add(txtApellido);
		
		txtDNI = new JTextField();
		txtDNI.addKeyListener(this);
		txtDNI.setColumns(10);
		txtDNI.setBounds(65, 105, 116, 19);
		getContentPane().add(txtDNI);
		
		txtEdad = new JTextField();
		txtEdad.addKeyListener(this);
		txtEdad.setColumns(10);
		txtEdad.setBounds(65, 144, 45, 19);
		getContentPane().add(txtEdad);
		
		txtId = new JTextField();
		txtId.addKeyListener(this);
		txtId.setColumns(10);
		txtId.setBounds(305, 24, 96, 19);
		getContentPane().add(txtId);
		
		btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(this);
		btnAgregar.setBounds(557, 24, 118, 23);
		getContentPane().add(btnAgregar);
		
		btnNuevo = new JButton("Nuevo");
		btnNuevo.addActionListener(this);
		btnNuevo.setBounds(557, 60, 118, 23);
		getContentPane().add(btnNuevo);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(this);
		btnCancelar.setBounds(557, 99, 118, 23);
		getContentPane().add(btnCancelar);
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(this);
		btnCerrar.setBounds(557, 164, 118, 23);
		getContentPane().add(btnCerrar);
		
		lblNewLabel_5 = new JLabel("(Solo 4 digitos)\r\n");
		lblNewLabel_5.setBounds(305, 53, 86, 13);
		getContentPane().add(lblNewLabel_5);
		
		scrollPane = new JScrollPane();
	
		scrollPane.setBounds(10, 197, 667, 282);
		getContentPane().add(scrollPane);
		
		
		
		txtBuscar = new JTextField();
		txtBuscar.addKeyListener(this);
		txtBuscar.setBounds(306, 84, 96, 19);
		getContentPane().add(txtBuscar);
		txtBuscar.setColumns(10);
		
		lblNewLabel_6 = new JLabel("Buscar");
		lblNewLabel_6.setBounds(262, 87, 57, 13);
		getContentPane().add(lblNewLabel_6);
		
		cboEditar = new JCheckBox("Editar");
		cboEditar.addActionListener(this);
		cboEditar.setBounds(308, 122, 93, 21);
		getContentPane().add(cboEditar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(this);
		btnEliminar.setBounds(557, 132, 118, 23);
		getContentPane().add(btnEliminar);
		
		table = new JTable();
		table.addMouseListener(this);
		scrollPane.setViewportView(table);
		
		CrearEncabezado();
		listarCliente(txtBuscar);
		DesHabilitarCajas();
		
	}
	void CrearEncabezado(){
		
		 mimodelo.addColumn("Nombre");
		 mimodelo.addColumn("Apellido");
		 mimodelo.addColumn("DNI");
		 mimodelo.addColumn("Edad");
		 mimodelo.addColumn("ID");
		 table.setModel(mimodelo);	
	}
	

	
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == btnAgregar) {
			actionPerformedbtnAgregar(e);
		}
		if (e.getSource() == btnNuevo) {
			actionPerformedbtnNuevo(e);
		}
		if (e.getSource() == btnCancelar) {
			actionPerformedbtnCancelar(e);
		}
		if (e.getSource() == btnCerrar) {
			actionPerformedbtnCerrar(e);
		}
		if (e.getSource() == btnEliminar) {
			actionPerformedbtnEliminar(e);
		}
		if (e.getSource() == cboEditar) {
			actionPerformedChckbxEditar(e);
		}
	}
	private void actionPerformedbtnEliminar(ActionEvent e) {
		Eliminar();
		
	}

	private void actionPerformedbtnCerrar(ActionEvent e) {
		Cerrar();
	}
	private void actionPerformedbtnCancelar(ActionEvent e) {
		Cancelar();
	}
	private void actionPerformedbtnNuevo(ActionEvent e) {
		Nuevo();
	}

	private void actionPerformedbtnAgregar(ActionEvent e) {
		Grabar();
		
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
	
	String Leerid() {
		return txtId.getText().trim();
	}
	String Leernom() {
		return txtNombre.getText().trim();
	}
	String leerApe() {
		return txtApellido.getText().trim();
	}
	String leerdni() {
		return txtDNI.getText().trim();
	}
	String leerEdad() {
		return txtEdad.getText().trim();
	}
	void listarCliente(JTextField buscame) {
		try {
			objClie.sql="select nom_clie,ape_clie,dni_clie,edad,id from cliente WHERE (nom_clie like'"+buscame.getText()+"%' or ape_clie like'" + buscame.getText() +"%'or dni_clie like'" + buscame.getText() +"%' or edad like'" +
					buscame.getText() +"%' or id like'" + buscame.getText() +"%' )order by id"; //no interesa si esta en min o mayus
			objClie.ListadoCliente(mimodelo, misdatos, objClie.sql); //es la jtable , los datos que son de COD_CATE,NOMBRE_CATE from osea 2, y sql de arribita
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	void mensaje(String men){
		JOptionPane.showMessageDialog(null, men);
	}
	void LimpiarCajas() {
		txtId.setText("");
		txtNombre.setText("");
		txtApellido.setText("");
		txtDNI.setText("");
		txtEdad.setText("");
		txtId.requestFocus();
		
	}
	void Nuevo() {
		estado="Grabar";
		btnAgregar.setText("Grabar");
		HabilitarCaja();
		LimpiarCajas();
	}
	void Grabar() {
		int mensaje;
		String nom,ape,dni,edad,id;
		nom=txtNombre.getText();
		ape=txtApellido.getText();
		dni=txtDNI.getText();
		edad=txtEdad.getText();
		id=txtId.getText();
		if(estado.equalsIgnoreCase("Grabar")) {
			mensaje=JOptionPane.showConfirmDialog(null, "Desea Grabar..?","Sistema de Cliente",
													JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE);
				//ahora validamos el mensaje
			if(mensaje==JOptionPane.YES_OPTION) {
				clie=new Cliente( nom,ape, dni, edad,id);
				int salida=objClie.RegistrarCliente(clie);
				if(salida>0)
					mensaje("Registrado correctamente");
					
				else
					mensaje("Error en el registro");
				listarCliente(txtBuscar);
				DesHabilitarCajas();
			}
		}
		else if(estado.equalsIgnoreCase("Actualizar")) {
			mensaje=JOptionPane.showConfirmDialog(null, "Desea Actualizar..?","Sistema de Cliente",
					JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE);
				if(mensaje==JOptionPane.YES_OPTION) {
					clie=new Cliente(nom,ape, dni, edad,id);
					int salida=objClie.ActualizarCliente(clie);
					if(salida>0)
						mensaje("Actualizado Correctamente");
					else 
						mensaje("Error en la actualizacion");
					listarCliente(txtBuscar); 
					LimpiarCajas();
					DesHabilitarCajas();
					cboEditar.setSelected(false);
				}
		}
	}
	void Eliminar() {
		if(!txtId.getText().equals("")) {//se refiere si en el txt codigo tiene codigo no se elimina, de lo contrario si
			
			int	mensaje=JOptionPane.showConfirmDialog(null, "Esta seguro de eliminar este registro?","Sistema de Cliente",
					JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE);
				if(mensaje == JOptionPane.YES_OPTION) {
					clie=new Cliente();
					clie.setId(txtId.getText()); //gettext es lo que insertaste en la caja
					
					int salida=objClie.EliminarCliente(clie);
					
					if(salida > 0)  //si es mayor a 0 es exito , de lo contrario es fracaso
						mensaje("Eliminado correctamente...");
					else mensaje("Error al eliminar...");
					listarCliente(txtBuscar);	
					}
			}
				
		}
	void Cancelar() {
		LimpiarCajas();
		DesHabilitarCajas();
				
	}
	void Cerrar() {
		int	mensaje=JOptionPane.showConfirmDialog(null, "Esta seguro de cerrar?","Sistema de Cliente",
				JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE);

		if(mensaje==JOptionPane.YES_OPTION)
			dispose();
			clie=null;
		
	}
	void HabilitarCaja() {
		txtId.setEnabled(true);
		txtNombre.setEnabled(true);
		txtApellido.setEnabled(true);
		txtDNI.setEnabled(true);
		txtEdad.setEnabled(true);
	}
	void DesHabilitarCajas() {
		txtId.setEnabled(false);
		txtNombre.setEnabled(false);
		txtApellido.setEnabled(false);
		txtDNI.setEnabled(false);
		txtEdad.setEnabled(false);
	}

	public void keyPressed(KeyEvent e) {
	}
	public void keyReleased(KeyEvent e) {
		if (e.getSource() == txtBuscar) {
			keyReleasedTxtBuscar(e);
		}
		
	}
	public void keyTyped(KeyEvent e) {
		if (e.getSource() == txtDNI) {
			keyTypedTxtDNI(e);
		}
		if (e.getSource() == txtId) {
			keyTypedTxtID(e);
		}
		if (e.getSource() == txtApellido) {
			keyTypedTxtApellido(e);
		}
		if (e.getSource() == txtNombre) {
			keyTypedTxtNombre(e);
		}
		if (e.getSource() == txtEdad) {
			keyTypedEdad(e);
		}
		
	}
	protected void keyTypedTxtNombre(KeyEvent e) {
		VClie.ValidarNombres(txtNombre,e);
	}
	protected void keyTypedTxtApellido(KeyEvent e) {
		VClie.ValidarApellidos(txtApellido, e);
	}
	protected void keyTypedTxtID(KeyEvent e) {
		VClie.ValidarCodigo(txtId, e);
	}
	protected void keyTypedTxtDNI(KeyEvent e) {
		VClie.ValidarDNI(txtDNI, e);
	}
	protected void keyTypedEdad(KeyEvent e) {
		VClie.validaEdad(txtEdad, e);
	}
	protected void keyReleasedTxtBuscar(KeyEvent e) {
		listarCliente(txtBuscar);
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
			txtNombre.setText(table.getValueAt(fila, 0).toString());
			txtApellido.setText(table.getValueAt(fila, 1).toString());
			txtDNI.setText(table.getValueAt(fila, 2).toString());
			txtEdad.setText(table.getValueAt(fila, 3).toString());
			txtId.setText(table.getValueAt(fila, 4).toString());
		}
	}
}
