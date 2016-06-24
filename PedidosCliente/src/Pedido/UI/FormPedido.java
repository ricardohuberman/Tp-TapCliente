package Pedido.UI;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Pedido.Core.PedidoDto;

public class FormPedido extends JFrame{
	private static final long serialVersionUID = 463054680201498133L;
	private JTextField textComida;
	private JTextField textCalle;
	private JTextField textNombre;
	private JTextField textTelefono;
	private JTextField textAltura;
	private JTextField textPiso;
	private PedidoDto pedidoForm;
	public FormPedido(){
		Initialize();
		pedidoForm = new PedidoDto();
	}
	public FormPedido(PedidoDto pedido, int request){
		Initialize();
		pedidoForm = pedido;
		textComida.setText(pedido.getComida());
		textCalle.setText(pedido.getCliente().getDireccion().getCalle());
		textNombre.setText(pedido.getCliente().getNombre());
		textTelefono.setText(pedido.getCliente().getTelefono());
		textAltura.setText(String.valueOf(pedido.getCliente().getDireccion().getAltura()));
		textPiso.setText(pedido.getCliente().getDireccion().getPiso());
	}
	
	private void Initialize(){
		textComida = new JTextField();
		textCalle = new JTextField();
		textNombre = new JTextField();
		textTelefono = new JTextField();
		textAltura = new JTextField();
		textPiso = new JTextField();
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);		
		setSize(500, 300);
		setLocationRelativeTo(null);
		setLayout(new GridLayout(7, 2));
		add(new JLabel("Nombre:"));
		add(textNombre);
		add(new JLabel("Calle:"));
		add(textCalle);
		add(new JLabel("Altura:"));
		add(textAltura);
		add(new JLabel("Piso:"));
		add(textPiso);
		add(new JLabel("Telefono:"));
		add(textTelefono);
		add(new JLabel("Comida:"));
		add(textComida);
		JButton saveButton = new JButton("Guardar");
		saveButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				setPedidoForm();
				dispose();
			}
		});
		add(saveButton);
		JButton cancelButton = new JButton("Cancelar");
		cancelButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		add(cancelButton);
	}
	public PedidoDto getPedidoForm() {
		return pedidoForm;
	}
	
	private void setPedidoForm() {
		this.pedidoForm.getCliente().getDireccion().setAltura(Integer.parseInt(textAltura.getText()));
		this.pedidoForm.getCliente().getDireccion().setCalle(textCalle.getText());
		this.pedidoForm.getCliente().getDireccion().setPiso(textPiso.getText());
		this.pedidoForm.getCliente().setNombre(textNombre.getText());
		this.pedidoForm.getCliente().setTelefono(textTelefono.getText());
		this.pedidoForm.setComida(textComida.getText());
	}
}
