package DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import mundo.Categoria;

/**
 * Clase que maneja las operaciones de acceso a datos para las categorías.
 * Contiene métodos para obtener todas las categorías de la base de datos.
 * Esta clase se conecta a una base de datos MySQL y ejecuta consultas SQL
 */
public class CategoriaDAO {
    // Devuelve todas las categorías de la base de datos
	/**
	 * Método para obtener todas las categorías de la base de datos.
	 * Este método establece una conexión con la base de datos, ejecuta una consulta SQL
	 * @return List<Categoria> - Lista de todas las categorías disponibles en la base de datos.
	 */
    public List<Categoria> obtenerTodas() {
        List<Categoria> lista = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/crud_pc", "root", "");
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery("SELECT * FROM categorias")) {
            while (rs.next()) {
                Categoria c = new Categoria(
                    rs.getInt("id"),
                    rs.getString("nombre"),
                    rs.getString("descripcion"),
                    rs.getDate("fecha_creacion")
                );
                lista.add(c);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

	public static void main(String[] args) {
		

	}

}
