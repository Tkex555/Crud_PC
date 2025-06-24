package DAO;

import conexion.conexion;
import mundo.Inventario;
import java.sql.*;
import java.util.*;

/**
 * Clase que implementa las operaciones de acceso a datos para el inventario.
 * Contiene métodos para obtener, agregar, actualizar y eliminar registros de inventario en la base de datos.
 */
public class InventarioDAOimpl implements InventarioDAO {
    /**
     * Método para obtener todos los registros de inventario de la base de datos.
     * Este método establece una conexión con la base de datos, ejecuta una consulta SQL
     * y devuelve una lista de objetos Inventario.
     * @return List<Inventario> - Lista de todos los registros de inventario disponibles en la base de datos.
     */
	@Override
    public List<Inventario> obtenerTodos() {
        List<Inventario> lista = new ArrayList<>();
        String sql = "SELECT * FROM inventario";
        try (Connection con = conexion.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Inventario inv = new Inventario(
                    rs.getInt("id"),
                    rs.getInt("id_producto"),
                    rs.getInt("stock_actual"),
                    rs.getInt("stock_minimo"),
                    rs.getInt("stock_maximo"),
                    rs.getTimestamp("fecha_ultima_actualizacion")
                );
                lista.add(inv);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }
	
		/**
	 * Método para obtener un registro de inventario por su ID.
	 * Este método establece una conexión con la base de datos, ejecuta una consulta SQL
	 * y devuelve un objeto Inventario correspondiente al ID proporcionado.
	 * @param id - Identificador único del inventario a buscar.
	 * @return Inventario - Objeto que representa el registro de inventario encontrado, o null si no se encuentra.
	 */
    @Override
    public Inventario obtenerPorId(int id) {
        String sql = "SELECT * FROM inventario WHERE id = ?";
        try (Connection con = conexion.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new Inventario(
                        rs.getInt("id"),
                        rs.getInt("id_producto"),
                        rs.getInt("stock_actual"),
                        rs.getInt("stock_minimo"),
                        rs.getInt("stock_maximo"),
                        rs.getTimestamp("fecha_ultima_actualizacion")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    /**
     * Método para agregar un nuevo registro de inventario a la base de datos.
     * Este método establece una conexión con la base de datos, prepara una sentencia SQL
     * y ejecuta la inserción del nuevo inventario.
     * @param inventario - Objeto Inventario que contiene los datos a insertar.
     */
    @Override
    public void agregar(Inventario inventario) {
        String sql = "INSERT INTO inventario (id_producto, stock_actual, stock_minimo, stock_maximo, fecha_ultima_actualizacion) VALUES (?, ?, ?, ?, ?)";
        try (Connection con = conexion.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, inventario.getIdProducto());
            ps.setInt(2, inventario.getStockActual());
            ps.setInt(3, inventario.getStockMinimo());
            ps.setInt(4, inventario.getStockMaximo());
            ps.setTimestamp(5, new java.sql.Timestamp(inventario.getFechaUltimaActualizacion().getTime()));
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    /**
	 * Método para actualizar un registro de inventario existente en la base de datos.
	 * Este método establece una conexión con la base de datos, prepara una sentencia SQL
	 * y ejecuta la actualización del inventario.
	 * @param inventario - Objeto Inventario que contiene los datos a actualizar.
	 */
    @Override
    public void actualizar(Inventario inventario) {
        String sql = "UPDATE inventario SET stock_actual=?, stock_minimo=?, stock_maximo=?, fecha_ultima_actualizacion=? WHERE id=?";
        try (Connection con = conexion.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, inventario.getStockActual());
            ps.setInt(2, inventario.getStockMinimo());
            ps.setInt(3, inventario.getStockMaximo());
            ps.setTimestamp(4, new java.sql.Timestamp(inventario.getFechaUltimaActualizacion().getTime()));
            ps.setInt(5, inventario.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    /**
	 * Método para eliminar un registro de inventario por su ID.
	 * Este método establece una conexión con la base de datos, prepara una sentencia SQL
	 * y ejecuta la eliminación del inventario correspondiente al ID proporcionado.
	 * @param id - Identificador único del inventario a eliminar.
	 */
    @Override
    public void eliminar(int id) {
        String sql = "DELETE FROM inventario WHERE id=?";
        try (Connection con = conexion.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
