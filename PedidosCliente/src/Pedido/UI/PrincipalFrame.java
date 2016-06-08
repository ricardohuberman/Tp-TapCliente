package Pedido.UI;

import javax.swing.JFrame;


public class PrincipalFrame extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5578560817969394161L;

	public PrincipalFrame()
	{
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		PrincipalMenuBar menuBar = new PrincipalMenuBar();
		setJMenuBar(menuBar);
	}
	
}
