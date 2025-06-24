package interfaz;

import DAO.InventarioDAO;
import DAO.InventarioDAOimpl;
import mundo.Inventario;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class PanelInventario extends JPanel {
    private JTable tabla;
    private DefaultTableModel modelo;
    private InventarioDAO inventarioDAO = new InventarioDAOimpl();

    public PanelInventario() {
        setLayout(new BorderLayout());
        modelo = new DefaultTableModel();
        modelo.setColumnIdentifiers(new Object[]{
                "ID", "ID Producto", "Stock Actual", "Stock Mínimo", "Stock Máximo", "Fecha Última Actualización"
        });
        tabla = new JTable(modelo);
        JScrollPane scroll = new JScrollPane(tabla);
        add(scroll, BorderLayout.CENTER);
        cargarDatos();
    }

    public void cargarDatos() {
        modelo.setRowCount(0);
        List<Inventario> lista = inventarioDAO.obtenerTodos();
        for (Inventario inv : lista) {
            modelo.addRow(new Object[]{
                    inv.getId(),
                    inv.getIdProducto(),
                    inv.getStockActual(),
                    inv.getStockMinimo(),
                    inv.getStockMaximo(),
                    inv.getFechaUltimaActualizacion()
            });
        }
    }
}
