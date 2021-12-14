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
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

public class GuiCategoria extends JInternalFrame implements ActionListener, InternalFrameListener, KeyListener, MouseListener {
	//Declarando y creando un objeto basado a la clase clsCategoria
	ClsCategoria objCat = new ClsCategoria();
	String []misdatos=new String[2];
	
	
	private JPanel panel;
	private JLabel lblCodigo;
	private JLabel lblNombre;
	private JTextField txtCodigo;
	private JTextField txtNombre;
	private JLabel lblBuscar;
	private JTextField txtBuscar;
	private JPanel panel_2;
	private JButton btnNuevo;
	private JTable tblCategoria;
	private JScrollPane scrollPane;
	private JButton btnGrabar;
	private JButton btnCancelar;
	private JButton btnEliminar;
	private JButton btnCerrar;
	private JCheckBox cbxEditar;

	DefaultTableModel mimodelo;
	
	public static String cate="";
	String estado="";	
	Categoria cat;
	
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


	
	
	
	public GuiCategoria() {
		setClosable(true);
		addInternalFrameListener(this);
		cate="cate";
		mimodelo=new DefaultTableModel();
		setTitle("Mantenimiento de categoria");
		setBounds(100, 100, 477, 512);
		getContentPane().setLayout(null);
		
		panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Categoria", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 11, 318, 130);
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
		
		cbxEditar = new JCheckBox("Editar");
		cbxEditar.addActionListener(this);
		cbxEditar.setBounds(203, 24, 72, 23);
		panel.add(cbxEditar);
		
		lblBuscar = new JLabel("Buscar");
		lblBuscar.setBounds(10, 174, 46, 14);
		getContentPane().add(lblBuscar);
		
		txtBuscar = new JTextField();
		txtBuscar.addKeyListener(this);
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
		
		tblCategoria = new JTable();
		tblCategoria.addMouseListener(this);
		scrollPane.setViewportView(tblCategoria);
		CrearEncabezado();
		ListarCategoria(txtBuscar);
		DesHabilitarCajas();

	}
	
	void CrearEncabezado(){
	 mimodelo.addColumn("Codigo");  //Los nombre del encabezado
	 mimodelo.addColumn("Nombre");
	 tblCategoria.setModel(mimodelo);
	}
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == cbxEditar) {
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
		Nuevo();
		
	}
	
	protected void actionPerformedBtnGrabar(ActionEvent arg0) {
		Grabar();
		
	}
	
	
	protected void actionPerformedBtnCancelar(ActionEvent arg0) {
		Cancelar();
		
	}
	
	
	
	
	protected void actionPerformedBtnEliminar(ActionEvent arg0) {
	
		Eliminar();
		
	}
	
	
	
	
	protected void actionPerformedBtnCerrar(ActionEvent arg0) {
		
		Cerrar();
		
	}
	
	
	protected void actionPerformedChckbxEditar(ActionEvent arg0) {
		
		if(cbxEditar.isSelected()) {
			estado="Actualizar";
			btnGrabar.setText("Actualizar");
			HabilitarCaja();
			txtCodigo.setEnabled(false);
		}
		else {
			estado="Grabar";
			btnGrabar.setText("Grabar");
			LimpiarCajas();
			DesHabilitarCajas();
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
	//Metodo para listar y buscar los datos de categoria
	void ListarCategoria(JTextField buscame) {
		try {
			objCat.sql="select COD_CATE,NOMBRE_CATE from CATEGORIA WHERE (cod_cate like'"+
						buscame.getText()+"%' or nombre_cate like'"+buscame.getText()+"%')order by cod_cate"; //no interesa si esta en min o mayus
			objCat.ListadoCategorias(mimodelo, misdatos, objCat.sql); //es la jtable , los datos que son de COD_CATE,NOMBRE_CATE from osea 2, y sql de arribita
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	void LimpiarCajas() {
		txtCodigo.setText("");
		txtNombre.setText("");
		txtCodigo.requestFocus();
		
	}
	void Nuevo() {
		estado="Grabar";
		btnGrabar.setText("Grabar");
		HabilitarCaja();
		LimpiarCajas();
		
	}
	void Grabar() {
		int mensaje;
		String cod,nom;
		cod=txtCodigo.getText();
		nom=txtNombre.getText();
		if(estado.equalsIgnoreCase("Grabar")) {
			mensaje=JOptionPane.showConfirmDialog(null, "Desea Grabar..?","Sistema de Ventas",
													JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE);
				//ahora validamos el mensaje
			if(mensaje==JOptionPane.YES_OPTION) {
				cat=new Categoria(cod, nom);
				int salida=objCat.RegistrarCategoria(cat);
				if(salida>0)
					mensaje("Registrado correctamente");
					
				else
					mensaje("Error en el registro");
				ListarCategoria(txtBuscar);
				DesHabilitarCajas();
			}
		}
		else if(estado.equalsIgnoreCase("Actualizar")) {
			mensaje=JOptionPane.showConfirmDialog(null, "Desea Actualizar..?","Sistema de Ventas",
					JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE);
				if(mensaje==JOptionPane.YES_OPTION) {
					cat=new Categoria(cod, nom);
					int salida=objCat.ActualizarCategoria(cat);
					if(salida>0)
						mensaje("Actualizado Correctamente");
					else 
						mensaje("Error en la actualizacion");
					ListarCategoria(txtBuscar); 
					LimpiarCajas();
					DesHabilitarCajas();
					cbxEditar.setSelected(false);
				}
		}
	}
	void Eliminar() {
		if(!txtCodigo.getText().equals("")) {//se refiere si en el txt codigo tiene codigo no se elimina, de lo contrario si
			
			int	mensaje=JOptionPane.showConfirmDialog(null, "Esta seguro de eliminar este registro?","Sistema de Ventas",
					JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE);
				if(mensaje == JOptionPane.YES_OPTION) {
					cat=new Categoria();
					cat.setCodCate(txtCodigo.getText()); //gettext es lo que insertaste en la caja
					
					int salida=objCat.EliminarCategoria(cat);
					
					if(salida > 0)  //si es mayor a 0 es exito , de lo contrario es fracaso
						mensaje("Eliminado correctamente...");
					else mensaje("Error al eliminar...");
					ListarCategoria(txtBuscar);	
				}
		}
			
	}
	void Cancelar() {
		LimpiarCajas();
		DesHabilitarCajas();
				
	}
	void Cerrar() {
		int	mensaje=JOptionPane.showConfirmDialog(null, "Esta seguro de cerrar?","Sistema de Ventas",
				JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE);

		if(mensaje==JOptionPane.YES_OPTION)
			dispose();
			cate=null;
		
	}
	void HabilitarCaja() {
		txtCodigo.setEnabled(true);
		txtNombre.setEnabled(true);
	}
	void DesHabilitarCajas() {
		txtCodigo.setEnabled(false);
		txtNombre.setEnabled(false);
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
		
		ListarCategoria(txtBuscar);
	}
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == tblCategoria) {
			mouseClickedTblCategoria(e);
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
	protected void mouseClickedTblCategoria(MouseEvent e) {
		if(mimodelo.getRowCount()>0) {
			int fila=tblCategoria.rowAtPoint(e.getPoint());
			//JOptionPane.showMessageDialog(null, fila);
			txtCodigo.setText(tblCategoria.getValueAt(fila, 0).toString());
			txtNombre.setText(tblCategoria.getValueAt(fila, 1).toString());
		}
	}
}
