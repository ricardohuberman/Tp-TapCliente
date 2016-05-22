package Pedido.UI;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class FramePedido extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3143943641777628664L;

	public FramePedido(){
		setSize(400,300);
		setResizable(false);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		BrwPedido pedido = new BrwPedido(this);
		add(pedido,BorderLayout.SOUTH);
	}
}
