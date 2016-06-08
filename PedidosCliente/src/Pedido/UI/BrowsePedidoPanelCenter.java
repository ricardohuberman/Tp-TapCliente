package Pedido.UI;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

public class BrowsePedidoPanelCenter extends JPanel {
	private static final long serialVersionUID = -4339985920761727396L;
	public BrowsePedidoPanelCenter(){
		JPanel north = new JPanel();
		JButton searchButton = new JButton("Consultar Pedidos");
		north.add(searchButton);
		add(north,BorderLayout.NORTH);
		BrowsePedidoFrameCentral center = new BrowsePedidoFrameCentral();
		add(center,BorderLayout.CENTER);
		JPanel south = new JPanel(new GridLayout(2, 3));
		add(south,BorderLayout.SOUTH);
	}
}
