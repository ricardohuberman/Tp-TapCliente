package Pedido.UI;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;

public class BrowsePedidoPanelSouth extends JPanel{
	private static final long serialVersionUID = 2269968316989830979L;
	private JTextField seleccion;
	private JTextField columna1;
	private JTextField columna2;
	private JTextField columna3;
	public BrowsePedidoPanelSouth(FrameBrowsePedido frame,JTable table){
		seleccion = new JTextField();
		columna1 = new JTextField();
		columna2 = new JTextField();
		columna3 = new JTextField();
		JPanel panelCenter = new JPanel();
		panelCenter.setLayout(new GridLayout(1,3));
		JButton addButton = new JButton("Agregar");
		JButton updButton = new JButton("Modificar");
		updButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//int registro = table.getSelectedRow();
				//seleccion.setText(String.valueOf(registro));
				//String texto = (String) table.getValueAt(registro, 0);
				//columna1.setText(texto);
				//texto = (String) table.getValueAt(registro, 1);
				//columna2.setText(texto);
				//texto = (String) table.getValueAt(registro, 2);
				//columna3.setText(texto);
			}
		});
		JButton delButton = new JButton("Eliminar");
		panelCenter.add(addButton);
		panelCenter.add(updButton);
		panelCenter.add(delButton);
//		panelCenter.add(seleccion);
//		panelCenter.add(columna1);
//		panelCenter.add(columna2);
//		panelCenter.add(columna3);
		add(panelCenter,BorderLayout.CENTER);
		setSize(100, 500);
		setLayout(new GridLayout(1, 1));
		JButton exitButton = new JButton("Salir");
		exitButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		JPanel panelSouth = new JPanel();
		panelSouth.add(exitButton);
		add(panelSouth,BorderLayout.SOUTH);
	}
}
