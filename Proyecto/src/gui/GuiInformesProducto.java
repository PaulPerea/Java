package gui;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import capa_logica.ClsProducto;

import javax.swing.JScrollPane;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

public class GuiInformesProducto extends JInternalFrame implements KeyListener, MouseListener {
	private JTable table;
	private JLabel lblNewLabel;
	private JTextField txtBuscar;
	private JScrollPane scrollPane;
	
	DefaultTableModel mimodelo;

	ClsProducto objPro = new ClsProducto();
	String []misdatos = new String[5];
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiInformesProducto frame = new GuiInformesProducto();
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
	public GuiInformesProducto() {
		setIconifiable(true);
		setClosable(true);
		mimodelo=new DefaultTableModel();
		setTitle("Informe Producto");
		setBounds(100, 100, 732, 619);
		getContentPane().setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(11, 69, 699, 511);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(this);
		scrollPane.setViewportView(table);
		
		lblNewLabel = new JLabel("Buscar");
		lblNewLabel.setBounds(10, 25, 69, 13);
		getContentPane().add(lblNewLabel);
		
		txtBuscar = new JTextField();
		txtBuscar.addKeyListener(this);
		txtBuscar.setColumns(10);
		txtBuscar.setBounds(65, 22, 96, 19);
		getContentPane().add(txtBuscar);
		CrearEncabezado();
		listarProducto(txtBuscar);
	}
	void CrearEncabezado(){
		
		 mimodelo.addColumn("Descripción");
		 mimodelo.addColumn("Cantidad");
		 mimodelo.addColumn("Nombre Proveedor");
		 mimodelo.addColumn("ID");
		 table.setModel(mimodelo);	
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
		listarProducto(txtBuscar);
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
	
	}
}
