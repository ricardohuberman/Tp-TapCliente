package Pedido.Core;

import Pedido.Core.DireccionDto;

public class ClienteDto {
	
	public ClienteDto(){
		direccion = new DireccionDto();
	}
	
	private long id;
	private String nombre;
	private DireccionDto direccion;
	private String telefono;
	
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public DireccionDto getDireccion() {
		return direccion;
	}
	public void setDireccion(DireccionDto direccion) {
		this.direccion = direccion;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
}
