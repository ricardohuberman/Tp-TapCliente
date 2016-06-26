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
import Pedido.RestService.PedidoService;

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
	private PedidoService pedidoService;
	private boolean estado;
	public FormPedido(){
		request = LocalRequest.Insertar;
		Initialize();
		pedidoForm = new PedidoDto();
	}
	public FormPedido(PedidoDto pedido){
		request = LocalRequest.Modificar;
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
		estado = true;
		pedidoService = new PedidoService();
		setTitle(request.toString() + " Pedido");
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
					pedidoService.addPedido(pedidoForm);
				}else if(request == LocalRequest.Modificar){
					pedidoService.modifyPedido(pedidoForm);
				}
				estado = false;
				dispose();
			}
		});
		add(saveButton);
		JButton cancelButton = new JButton("Cancelar");
		cancelButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				estado = false;
				dispose();
			}
		});
		add(cancelButton);
	}

	public boolean GetEstado()
	{
		return estado;
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
