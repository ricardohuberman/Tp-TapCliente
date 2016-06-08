package Pedido.UI;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class BrowsePedidoFrameCentral extends JFrame{
	private static final long serialVersionUID = -1597709090925838714L;
	private JTable table;
	public BrowsePedidoFrameCentral(){
		Object[] columnNames = {"Ricardo","Miguel","Huberman"};
		Object[][] data = new Object[][]{{"Hola","Como","Estas"},{"Hola","Como","Estas"},{"Hola","Como","Estas"},{"Hola","Como","Estas"},{"Hola","Como","Estas"},{"Hola","Como","Estas"},{"Hola","Como","Estas"},{"Hola","Como","Estas"},{"Hola","Como","Estas"},{"Hola","Como","Estas"},{"Hola","Como","Estas"},{"Hola","Como","Estas"},{"Hola","Como","Estas"},{"Hola","Como","Estas"},{"Hola","Como","Estas"}};
		BrowsePedidoTable model = new BrowsePedidoTable(data, columnNames);
		table = new JTable(model);
		getContentPane().add(new JScrollPane(table),BorderLayout.CENTER);
		setSize(300, 100);
	}
	
	public JTable getTable(){
		return table;
	}
}
