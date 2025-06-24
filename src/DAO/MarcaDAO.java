package DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import mundo.Marca;

/**
 * Clase que maneja las operaciones de acceso a datos para las marcas.
 * Contiene métodos para obtener todas las marcas de la base de datos.
 * Esta clase se conecta a una base de datos MySQL y ejecuta consultas SQL
 */
public class MarcaDAO {
    // Devuelve todas las marcas de la base de datos
		/**
	 * Método para obtener todas las marcas de la base de datos.
	 * Este método establece una conexión con la base de datos, ejecuta una consulta SQL
	 * y devuelve una lista de objetos Marca.
	 * @return List<Marca> - Lista de todas las marcas disponibles en la base de datos.
	 */
    public List<Marca> obtenerTodas() {
        List<Marca> lista = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/crud_pc", "root", "");
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery("SELECT * FROM marcas")) {
            while (rs.next()) {
                Marca m = new Marca(
                    rs.getInt("id"),
                    rs.getString("nombre"),
                    rs.getString("pais_origen"),
                    rs.getString("descripcion"),
                    rs.getDate("fecha_creacion")
                );
                lista.add(m);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
