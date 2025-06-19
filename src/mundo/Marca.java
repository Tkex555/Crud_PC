package mundo;

public class Marca {
	
	private int id;
	private String nombre;
	private String descripcion;
	private String estado;
	
	
	public Marca(int id, String nombre, String descripcion, String estado) {
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.estado = estado;
	}
	
	
	public int getId_marca() 
	{
		return id;
	}
	
	public void setId_marca(int id) 
	{
		this.id = id;
	}
	
	public String getNombre() 
	{
		return nombre;
	}
	
	
	public void setNombre(String nombre) 
	{
		this.nombre = nombre;
	}
	
	
	public String getDescripcion() 
	{
		return descripcion;
	}
	
	
	public void setDescripcion(String descripcion) 
	{
		this.descripcion = descripcion;
	}
	
	
	public boolean isEstado() 
	{
		return estado;
	}
	
	
	
}
