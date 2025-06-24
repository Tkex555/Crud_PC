package DAO;

import conexion.conexion;
import mundo.Inventario;
import java.sql.*;
import java.util.*;

public class InventarioDAOimpl implements InventarioDAO {
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

    @Override
    public void actualizar(Inventario inventario) {
        String sql = "UPDATE inventario SET id_producto=?, stock_actual=?, stock_minimo=?, stock_maximo=?, fecha_ultima_actualizacion=? WHERE id=?";
        try (Connection con = conexion.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, inventario.getIdProducto());
            ps.setInt(2, inventario.getStockActual());
            ps.setInt(3, inventario.getStockMinimo());
            ps.setInt(4, inventario.getStockMaximo());
            ps.setTimestamp(5, new java.sql.Timestamp(inventario.getFechaUltimaActualizacion().getTime()));
            ps.setInt(6, inventario.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

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
