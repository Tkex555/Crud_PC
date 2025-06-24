package DAO;

import java.sql.Connection;
import java.util.List;
import java.sql.*;
import java.util.ArrayList;

import conexion.conexion;
import mundo.Producto;

/** Clase que maneja las operaciones de acceso a datos para los productos.
 * Contiene métodos para agregar, actualizar, eliminar, buscar por ID, listar y buscar por nombre productos.
 * Esta clase se conecta a una base de datos MySQL y ejecuta consultas SQL.
 */
public class ProductoDAOimpl implements ProductoDAO {
	
		/**
	 * Conexión a la base de datos.
	 * Se inicializa al crear una instancia de ProductoDAOimpl.
	 */
	private Connection conn;
	
	/**
	 * Constructor de la clase ProductoDAOimpl.
	 * Inicializa la conexión a la base de datos utilizando la clase conexion.
	 * Si la conexión es nula, imprime un mensaje de error.
	 */
    public ProductoDAOimpl() {
        this.conn = conexion.getConnection();
        if (this.conn == null) {
            System.out.println("La conexión es nula. Verifica los datos.");
        }
    }
    
    /**
	 * Método para agregar un nuevo producto a la base de datos.
	 * Este método establece una conexión con la base de datos, prepara una consulta SQL
	 * y ejecuta la inserción del producto proporcionado.
	 * @param producto - Objeto Producto que contiene los datos del producto a agregar.
	 */
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
    
    /**
     * Método para actualizar un producto existente en la base de datos.
     * Este método establece una conexión con la base de datos, prepara una consulta SQL
     * y ejecuta la actualización del producto proporcionado.
     * @param producto - Objeto Producto que contiene los datos del producto a actualizar.
     */
    @Override
    public void actualizar(Producto producto) {
        String sql = "UPDATE productos SET nombre = ?, modelo = ?, descripcion = ?, precio = ?, stock = ?, especificaciones_tecnicas = ?, id_categoria = ?, id_marca = ?, imagen_url = ? WHERE id = ?";

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
            stmt.setInt(10, producto.getId());

            stmt.executeUpdate();
            System.out.println("Producto actualizado correctamente.");
        } catch (SQLException e) {
            System.out.println("Error al actualizar producto: " + e.getMessage());
        }
    }
    
    /**
	 * Método para eliminar un producto de la base de datos.
	 * Este método establece una conexión con la base de datos, prepara una consulta SQL
	 * y ejecuta la eliminación del producto con el ID proporcionado.
	 * @param id - Identificador único del producto a eliminar.
	 */
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
    
    /**
	 * Método para buscar un producto por su ID.
	 * Este método establece una conexión con la base de datos, prepara una consulta SQL
	 * y devuelve el producto correspondiente al ID proporcionado.
	 * @param id - Identificador único del producto a buscar.
	 * @return Producto - Objeto Producto que contiene los datos del producto encontrado, o null si no se encuentra.
	 */
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
    
    /**
     * Método para listar todos los productos de la base de datos.
     * Este método establece una conexión con la base de datos, ejecuta una consulta SQL
     * y devuelve una lista de todos los productos disponibles.
     * @return List<Producto> - Lista de todos los productos disponibles en la base de datos.
     */
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
	
	/**
	 * Método para buscar productos por nombre.
	 * Este método establece una conexión con la base de datos, prepara una consulta SQL
	 * y devuelve una lista de productos cuyos nombres coinciden con el criterio de búsqueda.
	 * @param nombre - Nombre o parte del nombre del producto a buscar.
	 * @return List<Producto> - Lista de productos que coinciden con el nombre proporcionado.
	 */
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
