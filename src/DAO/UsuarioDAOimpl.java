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
    }

	@Override
	public Usuario iniciarSesion(String usuario, String contraseña) {
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
}
