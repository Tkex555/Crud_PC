package mundo;

import java.util.Date;
/**
 * Clase que representa un producto en el sistema.
 * Contiene información como el ID, nombre, descripción, modelo, precio, stock,
 * especificaciones técnicas, ID de categoría, ID de marca, URL de imagen,
 * fecha de creación y fecha de actualización.
 */
public class Producto {
	
	/**
	 * Atributos de la clase Producto:
	 * - id: Identificador único del producto.
	 * - nombre: Nombre del producto.
	 * - descripcion: Descripción del producto.
	 * - modelo: Modelo del producto.
	 * - precio: Precio del producto.
	 * - stock: Cantidad disponible en stock.
	 * - especificaciones_tecnicas: Detalles técnicos del producto.
	 * - id_categoria: Identificador de la categoría a la que pertenece el producto.
	 * - id_marca: Identificador de la marca del producto.
	 * - imagen_url: URL de la imagen del producto.
	 * - fecha_creacion: Fecha en que se creó el producto.
	 * - fecha_actualizacion: Fecha de la última actualización del producto.
	 */
	private int id;
	private String nombre;
	private String descripcion;
	private String modelo;
	private double precio;
	private int stock;
	private String especificaciones_tecnicas;
	private int id_categoria;
	private int id_marca;
	private String imagen_url;
	private Date fecha_creacion;
	private Date fecha_actualizacion;
	
	/**
	 * Constructor por defecto de la clase Producto.
	 * Inicializa los atributos a valores por defecto.
	 * Este constructor es útil para crear instancias de la clase sin necesidad de proporcionar valores iniciales.
	 */
	public Producto() {
		
	}
	
	/**
	 * Constructor de la clase Producto.
	 * Inicializa los atributos del producto con los valores proporcionados.
	 * @param id: Identificador único del producto.
	 * @param nombre: Nombre del producto.
	 * @param modelo: Modelo del producto.
	 * @param descripcion: Descripción del producto.
	 * @param precio: Precio del producto.
	 * @param stock: Cantidad disponible en stock.
	 * @param especificaciones_tecnicas: Detalles técnicos del producto.
	 * @param id_categoria: Identificador de la categoría a la que pertenece el producto.
	 * @param id_marca: Identificador de la marca del producto.
	 * @param imagen_url: URL de la imagen del producto.
	 */
	public Producto(int id, String nombre, String modelo, String descripcion, 
            double precio, int stock, String especificaciones_tecnicas, 
            int id_categoria, int id_marca, String imagen_url) 
	{
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.modelo = modelo;
		this.precio = precio;
		this.stock = stock;
		this.especificaciones_tecnicas = especificaciones_tecnicas;
		this.id_categoria = id_categoria;
		this.id_marca = id_marca;
		this.imagen_url = imagen_url;
		this.fecha_creacion = new Date();
		this.fecha_actualizacion = new Date();
	}
	
	/**
	 * Método getId()
	 * Devuelve el identificador único del producto.
	 * @return id: Identificador del producto.
	 */
	public int getId() 
	{
		return id;
	}
	
	/**
	 * Método setId(int id)
	 * Establece el identificador único del producto.
	 * @param id: El nuevo identificador del producto.
	 */
	public void setId(int id) 
	{
		this.id = id;
	}
	
	/**
	 * Método getNombre()
	 * Devuelve el nombre del producto.
	 * @return nombre: Nombre del producto.
	 */
	public String getNombre() 
	{
		return nombre;
	}
	
	/**
	 * Método setNombre(String nombre)
	 * Establece el nombre del producto.
	 * @param nombre: El nuevo nombre del producto.
	 */
	public void setNombre(String nombre) 
	{
		this.nombre = nombre;
	}
	
	/**
	 * Método getModelo()
	 * Devuelve el modelo del producto.
	 * @return modelo: Modelo del producto.
	 */
	public String getModelo() 
	{
        return modelo;
    }
	
	/**
	 * Método setModelo(String modelo)
	 * Establece el modelo del producto.
	 * @param modelo: El nuevo modelo del producto.
	 */
    public void setModelo(String modelo) 
    {
        this.modelo = modelo;
    }
    
    /**
	 * Método getDescripcion()
	 * Devuelve la descripción del producto.
	 * @return descripcion: Descripción del producto.
	 */
    public String getDescripcion() 
    {
        return descripcion;
    }
    
    /**
     * Método setDescripcion(String descripcion)
     * Establece la descripción del producto.
     * @param descripcion
     */
    public void setDescripcion(String descripcion) 
    {
        this.descripcion = descripcion;
    }
    
    /**
	 * Método getPrecio()
	 * Devuelve el precio del producto.
	 * @return precio: Precio del producto.
	 */
    public double getPrecio() 
    {
        return precio;
    }
    
    /**
	 * Método setPrecio(double precio)
	 * Establece el precio del producto.
	 * @param precio: El nuevo precio del producto.
	 */
    public void setPrecio(double precio) 
    {
        this.precio = precio;
    }
    
    /**
     * Método getStock()
     * Devuelve la cantidad disponible en stock del producto.
     * @return stock: Cantidad en stock del producto.
     */
    public int getStock() 
    {
        return stock;
    }
    
    /**
	 * Método setStock(int stock)
	 * Establece la cantidad disponible en stock del producto.
	 * @param stock: La nueva cantidad en stock del producto.
	 */
    public void setStock(int stock) 
    {
        this.stock = stock;
    }
    
    /**
	 * Método getEspecificaciones_tecnicas()
	 * Devuelve las especificaciones técnicas del producto.
	 * @return especificaciones_tecnicas: Detalles técnicos del producto.
	 */
    public String getEspecificaciones_tecnicas() 
    {
        return especificaciones_tecnicas;
    }
    
    /**
     * Método setEspecificaciones_tecnicas(String especificaciones_tecnicas)
     * @param especificaciones_tecnicas
     */
    public void setEspecificaciones_tecnicas(String especificaciones_tecnicas) 
    {
        this.especificaciones_tecnicas = especificaciones_tecnicas;
    }
    
    /**
	 * Método getId_categoria()
	 * Devuelve el identificador de la categoría a la que pertenece el producto.
	 * @return id_categoria: Identificador de la categoría del producto.
	 */
    public int getId_categoria() 
    {
        return id_categoria;
    }
    
    /**
     * Método setId_categoria(int id_categoria)
     * @param id_categoria
     */
    public void setId_categoria(int id_categoria) 
    {
        this.id_categoria = id_categoria;
    }
    
    /**
     * Método getId_marca()
     * Devuelve el identificador de la marca del producto.
     * @return id_marca: Identificador de la marca del producto.
     */
    public int getId_marca() 
    {
        return id_marca;
    }
    
    /**
	 * Método setId_marca(int id_marca)
	 * Establece el identificador de la marca del producto.
	 * @param id_marca: El nuevo identificador de la marca del producto.
	 */
    public void setId_marca(int id_marca) 
    {
        this.id_marca = id_marca;
    }
    
    /**
	 * Método getImagen_url()
	 * Devuelve la URL de la imagen del producto.
	 * @return imagen_url: URL de la imagen del producto.
	 */
    public String getImagen_url() {
		return imagen_url;
	}
    
    /**
     * Método setImagen_url(String imagen_url)
     * Establece la URL de la imagen del producto.
     * @param imagen_url
     */
    public void setImagen_url(String imagen_url) {
    	this.imagen_url = imagen_url;
    }
    
    /**
	 * Método getFecha_creacion()
	 * Devuelve la fecha de creación del producto.
	 * @return fecha_creacion: Fecha de creación del producto.
	 */
    public Date getFecha_creacion() {
        return fecha_creacion;
    }
    
    /**
	 * Método setFecha_creacion(Date fecha_creacion)
	 * Establece la fecha de creación del producto.
	 * @param fecha_creacion
	 */
    public void setFecha_creacion(Date fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }
    
    /**
     * Método getFecha_actualizacion()
     * Devuelve la fecha de la última actualización del producto.
     * @return fecha_actualizacion: Fecha de la última actualización del producto.
     */
    public Date getFecha_actualizacion() {
        return fecha_actualizacion;
    }
    
    /**
	 * Método setFecha_actualizacion(Date fecha_actualizacion)
	 * Establece la fecha de la última actualización del producto.
	 * @param fecha_actualizacion
	 */
    public void setFecha_actualizacion(Date fecha_actualizacion) {
        this.fecha_actualizacion = fecha_actualizacion;
    }
    
    /**
	 * Método toString()
	 * Devuelve una representación en cadena del objeto Producto.
	 * Incluye todos los atributos del producto.
	 * @return Una cadena que representa el producto.
	 */
    public String toString() {
        return "Producto{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", modelo='" + modelo + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", precio=" + precio +
                ", stock=" + stock +
                ", especificaciones_tecnicas='" + especificaciones_tecnicas + '\'' +
                ", id_categoria=" + id_categoria +
                ", id_marca=" + id_marca +
                ", fecha_creacion=" + fecha_creacion +
                ", fecha_actualizacion=" + fecha_actualizacion +
                '}';
    }
}
