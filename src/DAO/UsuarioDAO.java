package DAO;

import mundo.Usuario;

public interface UsuarioDAO {
    void registrar(Usuario usuario);
    Usuario iniciarSesion(String usuario, String passwordHash);
    Usuario buscarPorId(int id);
    boolean existeUsuario(String usuario);
    
}

