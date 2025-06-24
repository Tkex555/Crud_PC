package mundo;

import java.util.Date;
/**
 * Clase que representa una categoría de productos.
 * Contiene información como el ID, nombre, fecha de creación y descripción.
 * Esta clase es utilizada para gestionar las categorías de productos en la aplicación.
*/
public class Marca {
	/**
	 * Atributos de la clase Marca:
	 * - id: Identificador único de la marca.
	 * - nombre: Nombre de la marca.
	 * - pais_origen: País de origen de la marca.
	 * - descripcion: Descripción de la marca.
	 * - fecha_creacion: Fecha en que se creó la marca.
	 */
	private int id;
	private String nombre;
	private String pais_origen;
	private String descripcion;
	private Date fecha_creacion;
	
	/**
	 * Constructor por defecto de la clase Marca.
	 * Inicializa los atributos a valores por defecto.
	 * Este constructor es útil para crear instancias de la clase sin necesidad de proporcionar valores iniciales.
	 */
	public Marca(int id, String nombre, String pais_origen, String descripcion, Date fecha_creacion) {
		this.id = id;
		this.nombre = nombre;
		this.pais_origen = pais_origen;
		this.descripcion = descripcion;
		this.fecha_creacion = fecha_creacion;
	}
	
	/**
	 * Método getId_marca()
	 * Devuelve el identificador único de la marca.
	 * @return id: Identificador de la marca.
	 */
	public int getId_marca() 
	{
		return id;
	}
	
	/**
	 * Método setId_marca(int id)
	 * Establece el identificador único de la marca.
	 * @param id: El nuevo identificador de la marca.
	 */
	public void setId_marca(int id) 
	{
		this.id = id;
	}
	
	/**
	 * Método getNombre()
	 * Devuelve el nombre de la marca.
	 * @return nombre: Nombre de la marca.
	 */
	public String getNombre() 
	{
		return nombre;
	}
	
	
	/**
	 * Método setNombre(String nombre)
	 * Establece el nombre de la marca.
	 * @param nombre: El nuevo nombre de la marca.
	 */
	public void setNombre(String nombre) 
	{
		this.nombre = nombre;
	}
	
	/**
	 * Método getPais_origen()
	 * Devuelve el país de origen de la marca.
	 * @return pais_origen: País de origen de la marca.
	 */
	public String getPais_origen() 
	{
		return pais_origen;
	}
	
	/**
	 * Método setPais_origen(String pais_origen)
	 * Establece el país de origen de la marca.
	 * @param pais_origen: El nuevo país de origen de la marca.
	 */
	public void setPais_origen(String pais_origen) 
	{
		this.pais_origen = pais_origen;
	}
	
	/**
	 * Método getDescripcion()
	 * Devuelve la descripción de la marca.
	 * @return descripcion: Descripción de la marca.
	 */
	public String getDescripcion() 
	{
		return descripcion;
	}
	
	/**
	 * Método setDescripcion(String descripcion)
	 * Establece la descripción de la marca.
	 * @param descripcion: La nueva descripción de la marca.
	 */
	public void setDescripcion(String descripcion) 
	{
		this.descripcion = descripcion;
	}
	
	/**
	 * Método getFecha_creacion()
	 * Devuelve la fecha de creación de la marca.
	 * @return fecha_creacion: Fecha de creación de la marca.
	 */
	public Date getFecha_creacion() 
	{
		return fecha_creacion;
	}
	
	/**
	 * Método setFecha_creacion()
	 * Establece la fecha de creación de la marca.
	 * @param fecha_creacion
	 */
	public void setFecha_creacion(Date fecha_creacion) 
	{
		this.fecha_creacion = fecha_creacion;
	}
	
	/**
	 * Método toString()
	 * 
	 */
	@Override
	public String toString() {
	    return nombre;
	}
}
