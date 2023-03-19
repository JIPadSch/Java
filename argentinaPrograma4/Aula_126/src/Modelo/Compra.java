package Modelo;

import java.time.LocalDateTime;

public class Compra {
	
	private double total;
	private Item[] items;
	private LocalDateTime fecha;
	
	public Compra() {
		//this.setFecha(LocalDateTime.now());
		this.fecha = LocalDateTime.now();
		items = new Item [10];
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public Item[] getItems() {
		return items;
	}

	public void setItems(Item[] items) {
		this.items = items;
	}

	public LocalDateTime getFecha() {
		return fecha;
	}

	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}

	public static String calcularTotalCompra() {
		for(int i=0;i<10;i++) {
			Item it = this.getItems()[i];
			if(it!=null) {
				total += it.getCantidad();	
			}
		}
		return String.valueOf(total);
	}
	
}
