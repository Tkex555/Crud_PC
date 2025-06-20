package DAO;

import java.sql.Connection;
import java.util.List;

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
		// TODO Auto-generated method stub
	}
}
