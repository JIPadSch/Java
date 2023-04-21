package Modelo;

public class Item {
	
	private Producto producto;
	private int cantidad;
	
	
	
	public Item() {
		//super();
	}

	public Item(Producto producto, int cantidad) {
		//super();
		this.producto = producto;
		this.cantidad = cantidad;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	public String calcularTotal() {
		double total = this.getCantidad() * this.getProducto().getPrecio();
				
		if(this.getCantidad() >= 10) {
			total = total-(total*30/100);
		}
		//return this.producto.getPrecio()*this.cantidad;		
		return String.valueOf(total);
	}
	
	
}
