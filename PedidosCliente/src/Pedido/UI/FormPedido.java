package Pedido.UI;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Pedido.Core.LocalRequest;
import Pedido.Core.PedidoDto;

public class FormPedido extends JDialog{
	private static final long serialVersionUID = 463054680201498133L;
	private JTextField textComida;
	private JTextField textCalle;
	private JTextField textNombre;
	private JTextField textTelefono;
	private JTextField textAltura;
	private JTextField textPiso;
	private PedidoDto pedidoForm;
	private LocalRequest request;
	public FormPedido(){
		Initialize();
		pedidoForm = new PedidoDto();
		request = LocalRequest.Insertar;
	}
	public FormPedido(PedidoDto pedido){
		Initialize();
		request = LocalRequest.Modificar;
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
				setPedidoForm();
				if(request == LocalRequest.Insertar){
					//TODO Llamo al metodo del REST para agregar el pedido
				}else if(request == LocalRequest.Modificar){
					//TODO Llamo al metodo del REST para informar la modificacion
				}
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
	private PedidoDto getPedidoForm() {
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
	
	public void DeletePedido(int registro)
	{
		//TODO Llamo al metodo del REST para informar la BAJA del pedido
	}
}
