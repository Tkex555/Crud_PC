package DAO;

import mundo.Producto;
import java.util.List;

public interface ProductoDAO {
    void agregar(Producto producto);
    void actualizar(Producto producto);
    void eliminar(int id);
    Producto buscarPorId(int id);
    List<Producto> listar();
    List<Producto> buscarPorNombre(String nombre);
}
