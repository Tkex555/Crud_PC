package mundo;

public class Producto {

	private int id;
	private String nombre;
	private String descripcion;
	private double precio;
	private int stock;
	private String especicaiones_tecnicas;
	private int id_categoria;
	private int id_marca;
	private Date fecha_creacion;
	private Date fecha_actualizacion;
	
	public Producto(int id, String nombre, String modelo, String descripcion, 
            double precio, int stock, String especificaciones_tecnicas, 
            int id_categoria, int id_marca) 
	{
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
		this.stock = stock;
		this.especicaiones_tecnicas = especificaciones_tecnicas;
		this.id_categoria = id_categoria;
		this.id_marca = id_marca;
		this.fecha_creacion = new Date();
		this.fecha_actualizacion = new Date();
	}
	
	
	public int getId() 
	{
		return id;
	}
	
	public void setId(int id) 
	{
		this.id = id;
	}
}
