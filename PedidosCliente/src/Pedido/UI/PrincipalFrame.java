package Pedido.UI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class PrincipalFrame extends JFrame {
	private static final long serialVersionUID = 5578560817969394161L;
	public PrincipalFrame()
	{
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		JMenuBar menuBar = ArmoMenuToolbar();
		setJMenuBar(menuBar);
		setTitle("Sistema de Pedidos");
	}
	
	private JMenuBar ArmoMenuToolbar()
	{
		JMenuBar menuToolbar = new JMenuBar();
		JMenu file = new JMenu("File");
		file.setMnemonic(KeyEvent.VK_F);
		ImageIcon icon = new ImageIcon("exit.png");
        JMenuItem eMenuItem = new JMenuItem("Exit", icon);
        eMenuItem.setMnemonic(KeyEvent.VK_E);
        eMenuItem.setToolTipText("Exit application");
        eMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                System.exit(0);
            }
        });
        file.add(eMenuItem);
        menuToolbar.add(file);
		JMenu pedidos = new JMenu("Pedidos");
		JMenuItem conPedido = new JMenuItem("Consultar");
		conPedido.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent event){
				BrowsePedido pedido = new BrowsePedido();
				pedido.setLocationRelativeTo(null);
				pedido.setVisible(true);
			}
		});
		pedidos.add(conPedido);
		menuToolbar.add(pedidos);
		return menuToolbar;
	}
	
}
