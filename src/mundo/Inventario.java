package mundo;

import java.util.Date;

public class Inventario {
    private int id;
    private int idProducto;
    private int stockActual;
    private int stockMinimo;
    private int stockMaximo;
    private Date fechaUltimaActualizacion;

    public Inventario() {}

    public Inventario(int id, int idProducto, int stockActual, int stockMinimo, int stockMaximo, Date fechaUltimaActualizacion) {
        this.id = id;
        this.idProducto = idProducto;
        this.stockActual = stockActual;
        this.stockMinimo = stockMinimo;
        this.stockMaximo = stockMaximo;
        this.fechaUltimaActualizacion = fechaUltimaActualizacion;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getIdProducto() { return idProducto; }
    public void setIdProducto(int idProducto) { this.idProducto = idProducto; }

    public int getStockActual() { return stockActual; }
    public void setStockActual(int stockActual) { this.stockActual = stockActual; }

    public int getStockMinimo() { return stockMinimo; }
    public void setStockMinimo(int stockMinimo) { this.stockMinimo = stockMinimo; }

    public int getStockMaximo() { return stockMaximo; }
    public void setStockMaximo(int stockMaximo) { this.stockMaximo = stockMaximo; }

    public Date getFechaUltimaActualizacion() { return fechaUltimaActualizacion; }
    public void setFechaUltimaActualizacion(Date fechaUltimaActualizacion) { this.fechaUltimaActualizacion = fechaUltimaActualizacion; }
}
