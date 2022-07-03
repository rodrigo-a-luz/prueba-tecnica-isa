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
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "transaccion")
public class Transaccion {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int numero;				// unico en el sistema (identifica la transaccion)
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Linea> linea;			// Lista de Lineas

	@Temporal(TemporalType.DATE)
	@Column(name = "fecha")
	private Date fecha; 				// fecha de la venta

	public Transaccion() {
		this.fecha = null;
		this.numero = 0;
		this.linea = null;
	}

	public Transaccion(Date fecha, int numero, List<Linea> lineas) {
		this.fecha = fecha;
		this.numero = numero;
		this.linea = lineas;
	}

	public Transaccion(Date fecha, List<Linea> lineas) {
		this.fecha = fecha;
		this.numero = 0;
		this.linea = lineas;
	}

	public Transaccion(List<Linea> lineas) {
		this.fecha = new Date();
		this.linea = lineas;
		this.numero = 0;
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
		return linea;
	}

	public void setLineas(List<Linea> lineas) {
		this.linea = lineas;
	}

	@Override
	public String toString() {
		return "Transaccion [fecha=" + fecha + ", numero=" + numero + "]";
	}

}
