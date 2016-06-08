package Pedido.UI;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class FrameBrowsePedido extends JFrame {
	private static final long serialVersionUID = -3143943641777628664L;
	public FrameBrowsePedido(){
		setSize(900,600);
		setResizable(false);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		PanelPedidoNorth north = new PanelPedidoNorth();
		add(north,BorderLayout.NORTH);
		Object[] columnNames = {"Ricardo","Miguel","Huberman"};
		Object[][] data = new Object[][]{{"Hola","Como","Estas"},{"Hola","Como","Estas"},{"Hola","Como","Estas"},{"Hola","Como","Estas"},{"Hola","Como","Estas"},{"Hola","Como","Estas"},{"Hola","Como","Estas"},{"Hola","Como","Estas"},{"Hola","Como","Estas"},{"Hola","Como","Estas"},{"Hola","Como","Estas"},{"Hola","Como","Estas"},{"Hola","Como","Estas"},{"Hola","Como","Estas"},{"Hola","Como","Estas"}};
		BrowsePedidoTable model = new BrowsePedidoTable(data, columnNames);
		JTable table = new JTable(model);
		getContentPane().add(new JScrollPane(table),BorderLayout.CENTER);
		BrowsePedidoPanelSouth pedido = new BrowsePedidoPanelSouth(this,table);
		getContentPane().add(pedido,BorderLayout.SOUTH);
		pack();
	}
}
