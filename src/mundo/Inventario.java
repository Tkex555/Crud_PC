package mundo;

import java.util.Date;
/**
 * Clase que representa una categoría de productos.
 * Contiene información como el ID, nombre, fecha de creación y descripción.
 * Esta clase es utilizada para gestionar las categorías de productos en la aplicación.
 */
public class Inventario {
	
	/**
	 * Atributos de la clase Inventario:
	 * - id: Identificador único del inventario.
	 * - idProducto: Identificador del producto asociado al inventario.
	 * - stockActual: Cantidad actual de stock del producto.
	 * - stockMinimo: Cantidad mínima de stock permitida.
	 * - stockMaximo: Cantidad máxima de stock permitida.
	 * - fechaUltimaActualizacion: Fecha de la última actualización del inventario.
	 */
    private int id;
    private int idProducto;
    private int stockActual;
    private int stockMinimo;
    private int stockMaximo;
    private Date fechaUltimaActualizacion;
    
    /**
	 * Constructor por defecto de la clase Inventario.
	 * Inicializa los atributos a valores por defecto.
	 * Este constructor es útil para crear instancias de la clase sin necesidad de proporcionar valores iniciales.
	 */
    public Inventario() {}
    
    /**
	 * Constructor de la clase Inventario.
	 * Inicializa los atributos del inventario con los valores proporcionados.
	 * @param id: Identificador único del inventario.
	 * @param idProducto: Identificador del producto asociado al inventario.
	 * @param stockActual: Cantidad actual de stock del producto.
	 * @param stockMinimo: Cantidad mínima de stock permitida.
	 * @param stockMaximo: Cantidad máxima de stock permitida.
	 * @param fechaUltimaActualizacion: Fecha de la última actualización del inventario.
	 */
    public Inventario(int id, int idProducto, int stockActual, int stockMinimo, int stockMaximo, Date fechaUltimaActualizacion) {
        this.id = id;
        this.idProducto = idProducto;
        this.stockActual = stockActual;
        this.stockMinimo = stockMinimo;
        this.stockMaximo = stockMaximo;
        this.fechaUltimaActualizacion = fechaUltimaActualizacion;
    }
    
    // Métodos getter y setter para los atributos de la clase Inventario
    /**
     * Método getId()
     * Devuelve el identificador único del inventario.
     */
    public int getId() { return id; }
    
    /**
	 * Método setId(int id)
	 * Establece el identificador único del inventario.
	 * @param id: El nuevo identificador del inventario.
	 */
    public void setId(int id) { this.id = id; }
    
    /**
	 * Método getIdProducto()
	 * Devuelve el identificador del producto asociado al inventario.
	 */
    public int getIdProducto() { return idProducto; }
    
    /**
     * Método setIdProducto(int idProducto)
     * Establece el identificador del producto asociado al inventario.
     */
    public void setIdProducto(int idProducto) { this.idProducto = idProducto; }
    
    /**
	 * Método getStockActual()
	 * Devuelve la cantidad actual de stock del producto.
	 */
    public int getStockActual() { return stockActual; }
    
    /**
	 * Método setStockActual(int stockActual)
	 * Establece la cantidad actual de stock del producto.
	 * @param stockActual: La nueva cantidad de stock actual del producto.
	 */
    public void setStockActual(int stockActual) { this.stockActual = stockActual; }
    
    /**
	 * Método getStockMinimo()
	 * Devuelve la cantidad mínima de stock permitida.
	 */
    public int getStockMinimo() { return stockMinimo; }
    
    /**
     * Método setStockMinimo(int stockMinimo)
     */
    public void setStockMinimo(int stockMinimo) { this.stockMinimo = stockMinimo; }
    
    /**
     * Método getStockMaximo()
     * Devuelve la cantidad máxima de stock permitida.
     */
    public int getStockMaximo() { return stockMaximo; }
    
    /**
	 * Método setStockMaximo(int stockMaximo)
	 * Establece la cantidad máxima de stock permitida.
	 * @param stockMaximo: La nueva cantidad máxima de stock del producto.
	 */
    public void setStockMaximo(int stockMaximo) { this.stockMaximo = stockMaximo; }
    
    /**
	 * Método getFechaUltimaActualizacion()
	 * Devuelve la fecha de la última actualización del inventario.
	 */
    public Date getFechaUltimaActualizacion() { return fechaUltimaActualizacion; }
    
    /**
     * Método setFechaUltimaActualizacion(Date fechaUltimaActualizacion)
     * Establece la fecha de la última actualización del inventario.
     */
    public void setFechaUltimaActualizacion(Date fechaUltimaActualizacion) { this.fechaUltimaActualizacion = fechaUltimaActualizacion; }
}
