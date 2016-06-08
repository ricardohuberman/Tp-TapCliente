package Pedido.UI;

import javax.swing.JButton;
import javax.swing.JPanel;

public class PanelPedidoNorth extends JPanel {
	private JButton btnConsultarPedidos;
	private static final long serialVersionUID = 6972249686791655773L;

	public PanelPedidoNorth(){
		btnConsultarPedidos = new JButton("Consultar Pedidos");
		add(btnConsultarPedidos);
	}
	public JButton getBtnConsultar(){
		return btnConsultarPedidos;
	}
}
