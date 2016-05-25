package Pedido.UI;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class PanelPedidoCenter extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4339985920761727396L;
	private JTextField seleccion;
	private JTextField columna1;
	private JTextField columna2;
	private JTextField columna3;
	public PanelPedidoCenter(){
		seleccion = new JTextField();
		columna1 = new JTextField();
		columna2 = new JTextField();
		columna3 = new JTextField();
		JPanel north = new JPanel();
		JButton searchButton = new JButton("Consultar Pedidos");
		north.add(searchButton);
		add(north,BorderLayout.NORTH);
		JPanel center = new JPanel();
		String columnNames[] = {"Ricardo","Miguel","Huberman"};
		Object[][] data = new Object[][]{{"Hola","Como","Estas"},{"Hola","Como","Estas"},{"Hola","Como","Estas"},{"Hola","Como","Estas"},{"Hola","Como","Estas"},{"Hola","Como","Estas"},{"Hola","Como","Estas"},{"Hola","Como","Estas"},{"Hola","Como","Estas"},{"Hola","Como","Estas"},{"Hola","Como","Estas"},{"Hola","Como","Estas"},{"Hola","Como","Estas"},{"Hola","Como","Estas"},{"Hola","Como","Estas"}};
		DefaultTableModel model = new DefaultTableModel(data, columnNames);
		TablePedidos table = new TablePedidos(model);
		ScrollPane scroll = new ScrollPane();
		scroll.add(table);
		scroll.setSize(900, 400);
		center.add(scroll);
		add(center,BorderLayout.CENTER);
		JPanel south = new JPanel(new GridLayout(2, 3));
		JButton addButton = new JButton("Agregar");
		JButton updButton = new JButton("Modificar");
		updButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int registro = table.getSelectedRow();
				seleccion.setText(String.valueOf(registro));
				String texto = (String) table.getValueAt(registro, 0);
				columna1.setText(texto);
				texto = (String) table.getValueAt(registro, 1);
				columna2.setText(texto);
				texto = (String) table.getValueAt(registro, 2);
				columna3.setText(texto);
			}
		});
		JButton delButton = new JButton("Eliminar");
		south.add(addButton);
		south.add(updButton);
		south.add(delButton);
		south.add(seleccion);
		south.add(columna1);
		south.add(columna2);
		south.add(columna3);
		add(south,BorderLayout.SOUTH);
	}
}
