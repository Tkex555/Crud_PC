package mundo;

import java.util.Date;

public class Categoria {
	private int id;
	private String nombre;
	private Date fecha_creacion;
	private String descripcion;

	public Categoria(int id, String nombre, Date fecha_creacion, String descripcion) {
		this.id = id;
		this.nombre = nombre;
		this.fecha_creacion = fecha_creacion;
		this.descripcion = descripcion;
	}
	
	
	public int getId() 
	{
		return id;
	}
	
	public void setId(int id) 
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

}
