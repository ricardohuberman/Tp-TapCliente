package Pedido.UI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.ScrollPane;
import java.util.Arrays;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

public class FramePedido extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3143943641777628664L;

	public FramePedido(){
		setSize(900,600);
		setResizable(false);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		PanelPedidoNorth north = new PanelPedidoNorth();
		add(north,BorderLayout.NORTH);

		PanelPedidoCenter center = new PanelPedidoCenter();
		add(center,BorderLayout.CENTER);
//		pack();
		BrwPedido pedido = new BrwPedido(this);
		add(pedido,BorderLayout.SOUTH);
	}
}
