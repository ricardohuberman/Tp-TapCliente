package Pedido.UI;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class BrwPedido extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2269968316989830979L;

	public BrwPedido(){
		setSize(100, 50);
		setLayout(new GridLayout(1, 1));
		JButton exitButton = new JButton("Salir");
		add(exitButton);
	}
}
