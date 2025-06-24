package DAO;

import java.util.List;
import mundo.Inventario;

public interface InventarioDAO {
    List<Inventario> obtenerTodos();
    Inventario obtenerPorId(int id);
    void agregar(Inventario inventario);
    void actualizar(Inventario inventario);
    void eliminar(int id);
}
