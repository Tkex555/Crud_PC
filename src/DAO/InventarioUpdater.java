package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import conexion.conexion;

public class InventarioUpdater {
    // Lógica para actualizar los valores de inventario según el stock del producto
    // Commit: Sincronización de inventario con productos
    public static void actualizarInventarioPorProducto(int idProducto, int nuevoStock) {
        try (Connection con = conexion.getConnection();
             PreparedStatement ps = con.prepareStatement("SELECT stock_actual, stock_minimo, stock_maximo FROM inventario WHERE id_producto = ?");) {
            ps.setInt(1, idProducto);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    int stockActual = rs.getInt("stock_actual");
                    int stockMinimo = rs.getInt("stock_minimo");
                    int stockMaximo = rs.getInt("stock_maximo");
                    int nuevoMin = Math.min(stockMinimo, nuevoStock);
                    int nuevoMax = Math.max(stockMaximo, nuevoStock);
                    try (PreparedStatement psUpdate = con.prepareStatement(
                        "UPDATE inventario SET stock_actual=?, stock_minimo=?, stock_maximo=?, fecha_ultima_actualizacion=NOW() WHERE id_producto=?")) {
                        psUpdate.setInt(1, nuevoStock);
                        psUpdate.setInt(2, nuevoMin);
                        psUpdate.setInt(3, nuevoMax);
                        psUpdate.setInt(4, idProducto);
                        psUpdate.executeUpdate();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
