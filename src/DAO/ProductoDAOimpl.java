package DAO;

import java.sql.Connection;
import java.util.List;
import java.sql.*;
import java.util.ArrayList;

import conexion.conexion;
import mundo.Producto;


public class ProductoDAOimpl implements ProductoDAO {
	
	private Connection conn;

    public ProductoDAOimpl() {
        this.conn = conexion.getConnection();
        if (this.conn == null) {
            System.out.println("La conexión es nula. Verifica los datos.");
        }
    }

    @Override
    public void agregar(Producto producto) {
        String sql = "INSERT INTO productos (nombre, modelo, descripcion, precio, stock, especificaciones_tecnicas, id_categoria, id_marca) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, producto.getNombre());
            stmt.setString(2, producto.getModelo());
            stmt.setString(3, producto.getDescripcion());
            stmt.setDouble(4, producto.getPrecio());
            stmt.setInt(5, producto.getStock());
            stmt.setString(6, producto.getEspecificaciones_tecnicas());
            stmt.setInt(7, producto.getId_categoria());
            stmt.setInt(8, producto.getId_marca());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al agregar producto: " + e.getMessage());
        }
    }

	
	@Override
	public void actualizar(Producto producto) {
		// TODO Auto-generated method stub
	}
	
	@Override
	public void eliminar(int id) {
		// TODO Auto-generated method stub
	}
	
	@Override
	public Producto buscarPorId(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public List<Producto> listar() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public List<Producto> buscarPorNombre(String nombre) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
