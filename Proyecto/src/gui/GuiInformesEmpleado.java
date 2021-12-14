package gui;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import capa_logica.ClsEmpleado;

import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class GuiInformesEmpleado extends JInternalFrame implements KeyListener {
	
	ClsEmpleado objEmp=new ClsEmpleado();
	String [] misdatos=new String[6];
	
	private JTable table;
	private JScrollPane scrollPane;
	private JLabel lblNewLabel;
	private JTextField txtBuscar;
	
	DefaultTableModel mimodelo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiInformesEmpleado frame = new GuiInformesEmpleado();
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
	public GuiInformesEmpleado() {
		setIconifiable(true);
		setClosable(true);
		mimodelo=new DefaultTableModel();
		setTitle("Informe Empleado");
		setBounds(100, 100, 733, 594);
		getContentPane().setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 69, 701, 486);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		lblNewLabel = new JLabel("Buscar");
		lblNewLabel.setBounds(10, 26, 69, 13);
		getContentPane().add(lblNewLabel);
		
		txtBuscar = new JTextField();
		txtBuscar.addKeyListener(this);
		txtBuscar.setBounds(65, 23, 96, 19);
		getContentPane().add(txtBuscar);
		txtBuscar.setColumns(10);
		CrearEncabezado();
		listarEmpleado(txtBuscar);
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
	void listarEmpleado(JTextField buscame) {
		try {
			objEmp.sql="select nom_emp,ape_emp,dni_emp,cargo_emp,edad_emp,id_emp from EMPLEADO WHERE (nom_emp like'"+buscame.getText()+"%' or ape_emp like'" + buscame.getText() +"%'or dni_emp like'" + buscame.getText() +"%'or cargo_emp like'" + buscame.getText() +"%' or edad_emp like'" +
					buscame.getText() +"%' or id_emp like'" + buscame.getText() +"%' )order by id_emp"; //no interesa si esta en min o mayus
			objEmp.ListadoEmpleado(mimodelo, misdatos, objEmp.sql); //es la jtable , los datos que son de COD_CATE,NOMBRE_CATE from osea 2, y sql de arribita
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public void keyPressed(KeyEvent e) {
	}
	public void keyReleased(KeyEvent e) {
		if (e.getSource() == txtBuscar) {
			keyReleasedTxtBuscar(e);
		}
	}
	public void keyTyped(KeyEvent e) {
	}
	protected void keyReleasedTxtBuscar(KeyEvent e) {
		listarEmpleado(txtBuscar);
	}
}
