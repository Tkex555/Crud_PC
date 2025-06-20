package mundo;

import java.util.Date;

public class Marca {
	
	private int id;
	private String nombre;
	private String pais_origen;
	private String descripcion;
	private String fecha_creacion;
	
	
	public Marca(int id, String nombre, String pais_origen, String descripcion, String fecha_creacion) {
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
	
	
	public boolean setEstado(boolean estado) 
	{
		this.estado = estado;
	}
	
	
	public String toString() {
        return "Marca{" +
                "id_marca=" + id +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", estado=" + estado +
                '}';
    }
}
