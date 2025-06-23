package mundo;

import java.util.Date;

public class Categoria {
	private int id;
	private String nombre;
	private Date fecha_creacion;
	private String descripcion;

	public Categoria(int id, String nombre, String descripcion, Date fecha_creacion) {
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.fecha_creacion = fecha_creacion;
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
	
	public Date getFecha_creacion() 
	{
		return fecha_creacion;
	}
	
	
	public void setFecha_creacion(Date fecha_creacion) 
	{
		this.fecha_creacion = fecha_creacion;
	}
	
	public String getDescripcion() 
	{
		return descripcion;
	}
	
	public void setDescripcion(String descripcion) 
	{
		this.descripcion = descripcion;
	}
	
	@Override
	public String toString() {
	    return nombre;
	}

}
