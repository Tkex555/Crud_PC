package DAO;

import conexion.conexion;
import mundo.Usuario;

import java.sql.*;

public class UsuarioDAOimpl implements UsuarioDAO {

    private Connection conn;

    public UsuarioDAOimpl() {
        this.conn = conexion.getConnection();
        if (this.conn == null) {
            System.out.println("La conexión es nula. Verifica los datos.");
        }
    }

    @Override
    public void registrar(Usuario usuario) {
        String sql = "INSERT INTO usuarios (id_persona, usuario, password_hash, rol) VALUES (?, ?, ?, ?)";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, usuario.getPersona().getId());
            stmt.setString(2, usuario.getUsuario());
            stmt.setString(3, usuario.getContraseña());
            stmt.setString(4, usuario.getRol());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al registrar usuario: " + e.getMessage());
        }
    }

	@Override
	public Usuario iniciarSesion(String usuario, String passwordHash) {
		return null;
	}

	@Override
	public Usuario buscarPorId(int id) {
		return null;
	}

	@Override
	public boolean existeUsuario(String usuario) {
		return false;
	}

    // Otros métodos...
}
