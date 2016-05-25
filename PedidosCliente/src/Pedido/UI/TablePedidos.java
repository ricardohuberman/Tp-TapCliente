package Pedido.UI;

import java.awt.Color;
import java.util.Arrays;
import java.util.Vector;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;

public class TablePedidos extends JTable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3300587217334031944L;

	public TablePedidos(DefaultTableModel model){
		super(model);
		setFillsViewportHeight(true);
		setBounds(25, 50, 950, 600);
		//setBackground(Color.gray);
		setRowHeight(23);    
		setVisible(true);
	}
}
