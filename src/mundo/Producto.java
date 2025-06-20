package mundo;

public class Producto {

	private int id;
	private String nombre;
	private String descripcion;
	private String modelo;
	private double precio;
	private int stock;
	private String especificaciones_tecnicas;
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
		this.modelo = modelo;
		this.precio = precio;
		this.stock = stock;
		this.especificaciones_tecnicas = especificaciones_tecnicas;
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
	
	public String getNombre() 
	{
		return nombre;
	}
	
	
	public void setNombre(String nombre) 
	{
		this.nombre = nombre;
	}
	
	
	public String getModelo() 
	{
        return modelo;
    }

    public void setModelo(String modelo) 
    {
        this.modelo = modelo;
    }

    public String getDescripcion() 
    {
        return descripcion;
    }

    public void setDescripcion(String descripcion) 
    {
        this.descripcion = descripcion;
    }

    public double getPrecio() 
    {
        return precio;
    }
    
    public void setPrecio(double precio) 
    {
        this.precio = precio;
    }

    public int getStock() 
    {
        return stock;
    }

    public void setStock(int stock) 
    {
        this.stock = stock;
    }

    public String getEspecificaciones_tecnicas() 
    {
        return especificaciones_tecnicas;
    }

    public void setEspecificaciones_tecnicas(String especificaciones_tecnicas) 
    {
        this.especificaciones_tecnicas = especificaciones_tecnicas;
    }

    public int getId_categoria() 
    {
        return id_categoria;
    }

    public void setId_categoria(int id_categoria) 
    {
        this.id_categoria = id_categoria;
    }

    public int getId_marca() 
    {
        return id_marca;
    }

    public void setId_marca(int id_marca) 
    {
        this.id_marca = id_marca;
    }
}
