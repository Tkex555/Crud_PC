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
	
	public String toString() {
        return "Categoria{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", fecha_creacion=" + fecha_creacion +
                '}';
    }

}
