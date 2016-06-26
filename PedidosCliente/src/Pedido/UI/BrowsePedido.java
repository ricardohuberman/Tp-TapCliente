package Pedido.UI;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Pedido.Core.PedidoDto;

public class BrowsePedido extends JFrame {
	private static final long serialVersionUID = -3143943641777628664L;
	private JTable table;
	private JTextField seleccion;
	public BrowsePedido(){
		setSize(100,600);
		setResizable(false);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setTitle("Consulta de Pedidos");
//*******************************Armo Panel Norte		
		JPanel panelNorth = new JPanel();
		JButton btnConsultarPedidos = new JButton("Consultar Pedidos");
		btnConsultarPedidos.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ActualizoTabla();
			}
		});
		panelNorth.add(btnConsultarPedidos);
		getContentPane().add(panelNorth,BorderLayout.NORTH);
//****************************************************************************************************************
//*******************************Armo Panel Central		
		Object[][] data = new Object[][]{{"Ricardo","15-3452-8475","Yerbal","985","PB","Milanesa a la Paroisien","1"},{"Fernando","15-6985-1302","Av. Cabildo","3952","1-A","Parrillada para 2","2"}};
		ArmoTable(data);
//****************************************************************************************************************
//*******************************Armo Panel Sur		
		JPanel panelSur = new JPanel();
		seleccion = new JTextField();
		JPanel panelSurNorth = new JPanel();
		panelSurNorth.setLayout(new GridLayout(1,3));
		JButton addButton = new JButton("Agregar");
		addButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				FormPedido form = new FormPedido();
				form.setVisible(true);
				ActualizoTabla();
			}
		});
		JButton updButton = new JButton("Modificar");
		updButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				PedidoDto pedido = new PedidoDto();
				int registro = table.getSelectedRow();
				if(registro == -1){
					JOptionPane mensaje = new JOptionPane();
					mensaje.showMessageDialog(null, "Debe Seleccionar un registro");
					return;
				}
				seleccion.setText(String.valueOf(registro));
				String texto = (String) table.getValueAt(registro, 0);
				pedido.getCliente().setNombre(texto);
				texto = (String) table.getValueAt(registro, 1);
				pedido.getCliente().setTelefono(texto);
				texto = (String) table.getValueAt(registro, 2);
				pedido.getCliente().getDireccion().setCalle(texto);
				texto = (String) table.getValueAt(registro, 3);
				pedido.getCliente().getDireccion().setAltura(Integer.parseInt(texto));
				texto = (String) table.getValueAt(registro, 4);
				pedido.getCliente().getDireccion().setPiso(texto);
				texto = (String) table.getValueAt(registro, 5);
				pedido.setComida(texto);
				texto = (String) table.getValueAt(registro, 6);
				pedido.setIdPedido(Integer.parseInt(texto));
				FormPedido form = new FormPedido(pedido);
				form.setVisible(true);
				ActualizoTabla();
			}
		});
		JButton delButton = new JButton("Eliminar");
		delButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int registro = table.getSelectedRow();
				if(registro == -1){
					JOptionPane mensaje = new JOptionPane();
					mensaje.showMessageDialog(null, "Debe Seleccionar un registro");
					return;
				}
				JOptionPane mensaje = new JOptionPane();
				int respuesta = mensaje.showConfirmDialog(null,"Esta seguro que desea eliminar el registro?");
				if(respuesta == JOptionPane.YES_OPTION)	{
					//Do something
					String texto = (String) table.getValueAt(registro, 6);
					FormPedido pedidoForm = new FormPedido();
					pedidoForm.DeletePedido(Integer.parseInt(texto));
					ActualizoTabla();
				}
			}
		});
		panelSurNorth.add(addButton);
		panelSurNorth.add(updButton);
		panelSurNorth.add(delButton);
		panelSur.add(panelSurNorth,BorderLayout.NORTH);
		panelSur.setSize(100, 500);
		panelSur.setLayout(new GridLayout(1, 1));
		JButton exitButton = new JButton("Salir");
		exitButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		JPanel panelSurSouth = new JPanel();
		panelSurSouth.add(exitButton);
		panelSur.add(panelSurSouth,BorderLayout.SOUTH);

		getContentPane().add(panelSur,BorderLayout.SOUTH);
//****************************************************************************************************************
		pack();
	}
	
	private void ArmoTable(Object[][] data)
	{
		Object[] columnNames = {"Nombre","Telefono","Calle","Numero","Piso","Comida","Registro"};
		DefaultTableModelPedido model = new DefaultTableModelPedido(data, columnNames);
		model.fireTableDataChanged();
		table = new JTable(model);
		getContentPane().add(new JScrollPane(table),BorderLayout.CENTER);
	}
	
	private void ActualizoTabla(){
		//TODO Tengo que llamar al REST para traerme los pedidos
		DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
		int filas=table.getRowCount();
        for (int i = 0;filas>i; i++) {
        	tableModel.removeRow(0);
        }
		Object[] data = new Object[]{"Martin","15-4582-4581","Itahualpa","1520","8-B","Pollo al Spiedo","3"};
		tableModel.addRow(data);
		tableModel.fireTableDataChanged();
		seleccion.setText("");
	}
}
