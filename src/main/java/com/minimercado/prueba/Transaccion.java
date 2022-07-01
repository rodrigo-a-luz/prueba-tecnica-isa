package com.minimercado.prueba;

import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "transaccion")
public class Transaccion {
	
	@Temporal(TemporalType.DATE)
	@Column(name = "fecha")
	private Date fecha;					// fecha de la venta
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int numero;				// unico en el sistema (identifica la transaccion)
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Linea> lineas;			// Lista de Lineas 
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Producto producto;

	public Transaccion() {
		this.fecha = null;
		this.numero = 0;
		this.lineas = null;
		this.producto = null;
	}

	public Transaccion(Date fecha, int numero, List<Linea> lineas, Producto producto) {
		this.fecha = fecha;
		this.numero = numero;
		this.lineas = lineas;
		this.producto = producto;
	}

	public Transaccion(Date fecha, List<Linea> lineas, Producto producto) {
		this.fecha = fecha;
		this.numero = 0;
		this.lineas = lineas;
		this.producto = producto;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public List<Linea> getLineas() {
		return lineas;
	}

	public void setLineas(List<Linea> lineas) {
		this.lineas = lineas;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

}
