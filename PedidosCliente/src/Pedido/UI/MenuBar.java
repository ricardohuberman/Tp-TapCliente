package Pedido.UI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MenuBar extends JMenuBar{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2617453441409885927L;
	public MenuBar()
	{		
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
		add(file);
		JMenu pedidos = new JMenu("Pedidos");
		JMenuItem conPedido = new JMenuItem("Consultar");
		conPedido.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent event){
				FramePedido pedido = new FramePedido();
				pedido.setLocationRelativeTo(null);
				pedido.setVisible(true);
			}
		});
		pedidos.add(conPedido);
		pedidos.addSeparator();
		JMenuItem addPedido = new JMenuItem("Agregar Pedido");
		pedidos.add(addPedido);
		pedidos.addSeparator();
		JMenuItem delPedido = new JMenuItem("Borrar Pedido");
		pedidos.add(delPedido);
		pedidos.addSeparator();
		JMenuItem updPedido = new JMenuItem("Modificar Pedido");
		pedidos.add(updPedido);
		add(pedidos);
	}
}
