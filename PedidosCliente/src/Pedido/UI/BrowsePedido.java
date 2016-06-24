package Pedido.UI;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Pedido.Core.PedidoDto;

public class BrowsePedido extends JDialog {
	private static final long serialVersionUID = -3143943641777628664L;
	private JTable table;
	public BrowsePedido(){
		setSize(100,600);
		setResizable(false);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
//*******************************Armo Panel Norte		
		JPanel panelNorth = new JPanel();
		JButton btnConsultarPedidos = new JButton("Consultar Pedidos");
		btnConsultarPedidos.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
				int filas=table.getRowCount();
	            for (int i = 0;filas>i; i++) {
	            	tableModel.removeRow(0);
	            }
				Object[] data = new Object[]{"1","1","1"};
				tableModel.addRow(data);
				tableModel.fireTableDataChanged();
//				ArmoTable(data);

			}
		});
		panelNorth.add(btnConsultarPedidos);
		getContentPane().add(panelNorth,BorderLayout.NORTH);
//****************************************************************************************************************
//*******************************Armo Panel Central		
		Object[][] data = new Object[][]{{"Hola","Como","Estas"},{"Hola","Como","Estas"},{"Hola","Como","Estas"},{"Hola","Como","Estas"},{"Hola","Como","Estas"},{"Hola","Como","Estas"},{"Hola","Como","Estas"},{"Hola","Como","Estas"},{"Hola","Como","Estas"},{"Hola","Como","Estas"},{"Hola","Como","Estas"},{"Hola","Como","Estas"},{"Hola","Como","Estas"},{"Hola","Como","Estas"},{"Hola","Como","Estas"}};
		ArmoTable(data);
//****************************************************************************************************************
//*******************************Armo Panel Sur		
		JPanel panelSur = new JPanel();
		JTextField seleccion = new JTextField();
		JPanel panelSurNorth = new JPanel();
		panelSurNorth.setLayout(new GridLayout(1,3));
		JButton addButton = new JButton("Agregar");
		JButton updButton = new JButton("Modificar");
		updButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				PedidoDto pedido = new PedidoDto();
				int registro = table.getSelectedRow();
				seleccion.setText(String.valueOf(registro));
				String texto = (String) table.getValueAt(registro, 0);
				pedido.getCliente().setNombre(texto);
				texto = (String) table.getValueAt(registro, 1);
				pedido.getCliente().setTelefono(texto);
				texto = (String) table.getValueAt(registro, 2);
				pedido.setComida(texto);
				FormPedido form = new FormPedido(pedido,2);
				form.setVisible(true);
				pedido = form.getPedidoForm();
			}
		});
		JButton delButton = new JButton("Eliminar");
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
		Object[] columnNames = {"Ricardo","Miguel","Huberman"};
		DefaultTableModelPedido model = new DefaultTableModelPedido(data, columnNames);
		model.fireTableDataChanged();
		table = new JTable(model);
		getContentPane().add(new JScrollPane(table),BorderLayout.CENTER);
	}
}
