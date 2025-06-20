package interfaz;

import DAO.ProductoDAO;
import DAO.ProductoDAOimpl;
import mundo.Producto;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class PanelProductos extends JPanel {

    private JTable tabla;
    private DefaultTableModel modeloTabla;
    private JTextField txtBuscar;
    private JButton btnBuscar, btnAgregar;

    public PanelProductos() {
        setLayout(new BorderLayout());

        // Top panel: búsqueda y agregar
        JPanel panelSuperior = new JPanel(new FlowLayout(FlowLayout.LEFT));
        txtBuscar = new JTextField(20);
        btnBuscar = new JButton("Buscar");
        btnAgregar = new JButton("Agregar Producto");

        panelSuperior.add(new JLabel("Buscar:"));
        panelSuperior.add(txtBuscar);
        panelSuperior.add(btnBuscar);
        panelSuperior.add(btnAgregar);

        // Tabla
        modeloTabla = new DefaultTableModel(new String[]{"ID", "Nombre", "Modelo", "Precio"}, 0);
        tabla = new JTable(modeloTabla);

        // Añadir al panel principal
        add(panelSuperior, BorderLayout.NORTH);
        add(new JScrollPane(tabla), BorderLayout.CENTER);

        // Cargar datos al iniciar
        cargarProductos("");

        // Acción botón Buscar
        btnBuscar.addActionListener(e -> {
            String nombre = txtBuscar.getText().trim();
            cargarProductos(nombre);
        });

        // Acción botón Agregar
        btnAgregar.addActionListener(e -> {
            JFrame frame = new JFrame("Agregar Producto");
            frame.add(new PanelAgregarProducto());
            frame.setSize(500, 500);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });

        // Futuro: puedes agregar botón Editar / Eliminar por fila si quieres
    }

    private void cargarProductos(String filtroNombre) {
        modeloTabla.setRowCount(0); // limpiar
        ProductoDAO dao = new ProductoDAOimpl();
        List<Producto> lista = filtroNombre.isEmpty() ? dao.listar() : dao.buscarPorNombre(filtroNombre);

        for (Producto p : lista) {
            modeloTabla.addRow(new Object[]{
                p.getId(),
                p.getNombre(),
                p.getModelo(),
                p.getPrecio()
            });
        }
    }
}
