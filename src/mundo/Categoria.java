package mundo;

import java.util.Date;
/*
 * Clase que representa una categoría de productos.
 * Contiene información como el ID, nombre, fecha de creación y descripción.
 * Esta clase es utilizada para gestionar las categorías de productos en la aplicación.
 */
public class Categoria {
	/* * Atributos de la clase Categoria:
	 * - id: Identificador único de la categoría.
	 * - nombre: Nombre de la categoría.
	 * - fecha_creacion: Fecha en que se creó la categoría.
	 * - descripcion: Descripción de la categoría.
	 */
	private int id;
	private String nombre;
	private Date fecha_creacion;
	private String descripcion;
	
	/*
	 * Constructor por defecto de la clase Categoria.
	 * Inicializa los atributos a valores por defecto.
	 * Este constructor es útil para crear instancias de la clase sin necesidad de proporcionar valores iniciales.
	 */
	public Categoria(int id, String nombre, String descripcion, Date fecha_creacion) {
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.fecha_creacion = fecha_creacion;
	}
	
	/*
	 * metodo getId()
	 * Devuelve el identificador único de la categoría.
	 */
	public int getId() 
	{
		return id;
	}
	
	/*
	 * metodo setId(int id)
	 * Establece el identificador único de la categoría.
	 * @param id: El nuevo identificador de la categoría.
	 */
	public void setId(int id) 
	{
		this.id = id;
	}
	
	/*
	 * metodo getNombre()
	 * Devuelve el nombre de la categoría.
	 */
	public String getNombre() 
	{
		return nombre;
	}
	
	/*
	 * metodo setNombre(String nombre)
	 * Establece el nombre de la categoría.
	 * @param nombre: El nuevo nombre de la categoría.
	 */
	public void setNombre(String nombre) 
	{
		this.nombre = nombre;
	}
	
	/*
	 * metodo getFecha_creacion()
	 * Devuelve la fecha de creación de la categoría.
	 */
	public Date getFecha_creacion() 
	{
		return fecha_creacion;
	}
	
	
	/*
	 * metodo setFecha_creacion(Date fecha_creacion)
	 * Establece la fecha de creación de la categoría.
	 * @param fecha_creacion: La nueva fecha de creación de la categoría.
	 */
	public void setFecha_creacion(Date fecha_creacion) 
	{
		this.fecha_creacion = fecha_creacion;
	}
	
	/*
	 * metodo getDescripcion()
	 * Devuelve la descripción de la categoría.
	 */
	public String getDescripcion() 
	{
		return descripcion;
	}
	
	/*
	 * metodo setDescripcion(String descripcion)
	 * Establece la descripción de la categoría.
	 * @param descripcion: La nueva descripción de la categoría.
	 */
	public void setDescripcion(String descripcion) 
	{
		this.descripcion = descripcion;
	}
	
	/*
	 * metodo toString()
	 * Devuelve una representación en cadena de la categoría.
	 * Utilizado para mostrar información de la categoría de manera legible.
	 */
	@Override
	public String toString() {
	    return nombre;
	}

}
