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
        String sql = "INSERT INTO productos (nombre, modelo, descripcion, precio, stock, especificaciones_tecnicas, id_categoria, id_marca, imagen_url) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, producto.getNombre());
            stmt.setString(2, producto.getModelo());
            stmt.setString(3, producto.getDescripcion());
            stmt.setDouble(4, producto.getPrecio());
            stmt.setInt(5, producto.getStock());
            stmt.setString(6, producto.getEspecificaciones_tecnicas());
            stmt.setInt(7, producto.getId_categoria());
            stmt.setInt(8, producto.getId_marca());
            stmt.setString(9, producto.getImagen_url());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al agregar producto: " + e.getMessage());
        }
    }

	
    @Override
    public void actualizar(Producto producto) {
        String sql = "UPDATE productos SET nombre = ?, modelo = ?, descripcion = ?, precio = ?, stock = ?, especificaciones_tecnicas = ?, id_categoria = ?, id_marca = ? WHERE id = ?";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, producto.getNombre());
            stmt.setString(2, producto.getModelo());
            stmt.setString(3, producto.getDescripcion());
            stmt.setDouble(4, producto.getPrecio());
            stmt.setInt(5, producto.getStock());
            stmt.setString(6, producto.getEspecificaciones_tecnicas());
            stmt.setInt(7, producto.getId_categoria());
            stmt.setInt(8, producto.getId_marca());
            stmt.setInt(9, producto.getId());

            stmt.executeUpdate();
            System.out.println("Producto actualizado correctamente.");
        } catch (SQLException e) {
            System.out.println("Error al actualizar producto: " + e.getMessage());
        }
    }

    @Override
    public void eliminar(int id) {
        String sql = "DELETE FROM productos WHERE id = ?";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            int filas = stmt.executeUpdate();

            if (filas > 0) {
                System.out.println("Producto eliminado exitosamente.");
            } else {
                System.out.println("No se encontró un producto con ese ID.");
            }
        } catch (SQLException e) {
            System.out.println("Error al eliminar producto: " + e.getMessage());
        }
    }

    @Override
    public Producto buscarPorId(int id) {
        String sql = "SELECT * FROM productos WHERE id = ?";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                // Creamos el objeto producto con base en el constructor que espera solo los IDs de categoría y marca
                Producto producto = new Producto(
                    rs.getInt("id"),
                    rs.getString("nombre"),
                    rs.getString("modelo"),
                    rs.getString("descripcion"),
                    rs.getDouble("precio"),
                    rs.getInt("stock"),
                    rs.getString("especificaciones_tecnicas"),
                    rs.getInt("id_categoria"),
                    rs.getInt("id_marca"),
                    rs.getString("imagen_url") 
                );

                return producto;
            }

        } catch (SQLException e) {
            System.out.println("Error al buscar producto por ID: " + e.getMessage());
        }

        return null;
    }

	@Override
	public List<Producto> listar() {
	    List<Producto> productos = new ArrayList<>();
	    String sql = "SELECT p.*, c.nombre AS nombre_categoria, m.nombre AS nombre_marca " +
	                 "FROM productos p " +
	                 "LEFT JOIN categorias c ON p.id_categoria = c.id " +
	                 "LEFT JOIN marcas m ON p.id_marca = m.id";

	    try (PreparedStatement stmt = conn.prepareStatement(sql);
	         ResultSet rs = stmt.executeQuery()) {

	        while (rs.next()) {
	            Producto p = new Producto(
	                    rs.getInt("id"),
	                    rs.getString("nombre"),
	                    rs.getString("modelo"),
	                    rs.getString("descripcion"),
	                    rs.getDouble("precio"),
	                    rs.getInt("stock"),
	                    rs.getString("especificaciones_tecnicas"),
	                    rs.getInt("id_categoria"),
	                    rs.getInt("id_marca"),
	                    rs.getString("imagen_url")
	                );
	            productos.add(p);
	        }

	    } catch (SQLException e) {
	        System.out.println("Error al listar productos: " + e.getMessage());
	    }

	    return productos;
	}

	
	@Override
	public List<Producto> buscarPorNombre(String nombre) {
	    List<Producto> productos = new ArrayList<>();
	    String sql = "SELECT * FROM productos WHERE nombre LIKE ?";

	    try (PreparedStatement stmt = conn.prepareStatement(sql)) {
	        stmt.setString(1, "%" + nombre + "%");
	        ResultSet rs = stmt.executeQuery();

	        while (rs.next()) {
	            Producto producto = new Producto(
	                rs.getInt("id"),
	                rs.getString("nombre"),
	                rs.getString("modelo"),
	                rs.getString("descripcion"),
	                rs.getDouble("precio"),
	                rs.getInt("stock"),
	                rs.getString("especificaciones_tecnicas"),
	                rs.getInt("id_categoria"),
	                rs.getInt("id_marca"),
	                rs.getString("imagen_url")
	            );

	            productos.add(producto);
	        }

	    } catch (SQLException e) {
	        System.out.println("Error al buscar productos por nombre: " + e.getMessage());
	    }

	    return productos;
	}
	
}
