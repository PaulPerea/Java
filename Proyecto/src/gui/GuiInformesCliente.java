package gui;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import capa_logica.ClsCliente;

import javax.swing.JScrollPane;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class GuiInformesCliente extends JInternalFrame implements KeyListener {
	ClsCliente objClie = new ClsCliente();
	String []misdatos=new String[5];
	
	private JTable table;
	private JLabel lblNewLabel;
	private JTextField txtBuscar;
	private JScrollPane scrollPane;
	
	DefaultTableModel mimodelo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiInformesCliente frame = new GuiInformesCliente();
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
	public GuiInformesCliente() {
		setIconifiable(true);
		setClosable(true);
		mimodelo=new DefaultTableModel();
		setTitle("Informe Cliente");
		setBounds(100, 100, 736, 663);
		getContentPane().setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 58, 697, 554);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		lblNewLabel = new JLabel("Buscar");
		lblNewLabel.setBounds(10, 13, 69, 13);
		getContentPane().add(lblNewLabel);
		
		txtBuscar = new JTextField();
		txtBuscar.addKeyListener(this);
		txtBuscar.setColumns(10);
		txtBuscar.setBounds(65, 10, 96, 19);
		getContentPane().add(txtBuscar);

		CrearEncabezado();
		listarCliente(txtBuscar);
		
	}
	void CrearEncabezado(){
		
		 mimodelo.addColumn("Nombre");
		 mimodelo.addColumn("Apellido");
		 mimodelo.addColumn("DNI");
		 mimodelo.addColumn("Edad");
		 mimodelo.addColumn("ID");
		 table.setModel(mimodelo);	
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
		listarCliente(txtBuscar);
	}
}
