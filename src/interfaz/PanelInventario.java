package interfaz;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;
import conexion.conexion;

// Panel para mostrar y refrescar el inventario de productos
/**
 * Panel que muestra una tabla con el inventario de productos,
 * permitiendo refrescar los datos y agregar inventario para el último producto.
 */
public class PanelInventario extends JPanel {
    private JTable tabla;
    private DefaultTableModel modelo;
    
    /**
     * Constructor del panel de inventario.
     * Inicializa el layout, la tabla y carga los datos del inventario.
     * Este panel se utiliza para visualizar el inventario de productos
     */
    public PanelInventario() {
        setLayout(new BorderLayout());
        modelo = new DefaultTableModel();
        modelo.setColumnIdentifiers(new Object[]{
                "ID Producto", "Nombre Producto", "Stock Actual", "Stock Mínimo", "Stock Máximo"
        });
        tabla = new JTable(modelo);
        JScrollPane scroll = new JScrollPane(tabla);
        add(scroll, BorderLayout.CENTER);
        cargarDatos();
    }
    
    /**
	 * Carga los datos del inventario desde la base de datos y los muestra en la tabla.
	 * Este método se encarga de ejecutar una consulta SQL para obtener los productos
	 * y sus respectivos stocks, y luego actualiza el modelo de la tabla.
	 */
    public void cargarDatos() {
        modelo.setRowCount(0);
        String sql = "SELECT p.id AS id_producto, p.nombre, i.stock_actual, i.stock_minimo, i.stock_maximo " +
                "FROM productos p LEFT JOIN inventario i ON p.id = i.id_producto";
        try (Connection con = conexion.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                modelo.addRow(new Object[]{
                        rs.getInt("id_producto"),
                        rs.getString("nombre"),
                        rs.getObject("stock_actual") != null ? rs.getInt("stock_actual") : "",
                        rs.getObject("stock_minimo") != null ? rs.getInt("stock_minimo") : "",
                        rs.getObject("stock_maximo") != null ? rs.getInt("stock_maximo") : ""
                });
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // Forzar refresco visual
        modelo.fireTableDataChanged();
        tabla.repaint();
    }
    
    /**
	 * Refresca los datos del inventario en la tabla.
	 * Este método se puede llamar para actualizar la vista con los datos más recientes de la base de datos.
	 */
    public void refrescar() {
        cargarDatos();
    }
    
    /**
     * Agrega un inventario para el último producto registrado en la base de datos.
     * Este método busca el último producto por ID y asegura que tenga un registro de inventario,
     * inicializando el stock actual, mínimo y máximo si no existe.
     * Este método se utiliza para garantizar que todos los productos tengan un inventario asociado,
     * especialmente útil al agregar nuevos productos.
     */
    public void agregarInventarioParaUltimoProducto() {
        try (Connection con = conexion.getConnection();
             PreparedStatement ps = con.prepareStatement("SELECT id FROM productos ORDER BY id DESC LIMIT 1");
             ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                int idProducto = rs.getInt("id");
                // Insertar inventario para ese producto si no existe
                String sqlInsert = "INSERT IGNORE INTO inventario (id_producto, stock_actual, stock_minimo, stock_maximo) VALUES (?, 0, 0, 100)";
                try (PreparedStatement psInsert = con.prepareStatement(sqlInsert)) {
                    psInsert.setInt(1, idProducto);
                    psInsert.executeUpdate();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
