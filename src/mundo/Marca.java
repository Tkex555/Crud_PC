package mundo;

import java.util.Date;

public class Marca {
	
	private int id;
	private String nombre;
	private String pais_origen;
	private String descripcion;
	private Date fecha_creacion;
	
	
	public Marca(int id, String nombre, String pais_origen, String descripcion, Date fecha_creacion) {
		this.id = id;
		this.nombre = nombre;
		this.pais_origen = pais_origen;
		this.descripcion = descripcion;
		this.fecha_creacion = fecha_creacion;
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
	
	public String getPais_origen() 
	{
		return pais_origen;
	}
	
	public void setPais_origen(String pais_origen) 
	{
		this.pais_origen = pais_origen;
	}
	
	
	public String getDescripcion() 
	{
		return descripcion;
	}
	
	public void setDescripcion(String descripcion) 
	{
		this.descripcion = descripcion;
	}
	
	
	public Date getFecha_creacion() 
	{
		return fecha_creacion;
	}
	
	
	public void setFecha_creacion(Date fecha_creacion) 
	{
		this.fecha_creacion = fecha_creacion;
	}
	
	
	public String toString() {
        return "Marca{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", pais_origen='" + pais_origen + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", fecha_creacion=" + fecha_creacion +
                '}';
    }
}
