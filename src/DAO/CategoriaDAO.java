package DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import mundo.Categoria;

public class CategoriaDAO {
    // Devuelve todas las categorías de la base de datos
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
		// TODO Auto-generated method stub

	}

}
