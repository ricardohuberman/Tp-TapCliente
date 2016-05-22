package Pedido.UI;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class BrwPedido extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2269968316989830979L;

	public BrwPedido(FramePedido frame){
		setSize(100, 50);
		
		setLayout(new GridLayout(1, 1));
		JButton exitButton = new JButton("Salir");
		exitButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		add(exitButton,BorderLayout.SOUTH);
	}
}
