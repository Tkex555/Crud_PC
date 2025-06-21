
package interfaz;

import DAO.ProductoDAO;
import DAO.ProductoDAOimpl;
import mundo.Producto;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class PanelProductos extends JPanel {

    private JTable tabla;
    private DefaultTableModel modeloTabla;
    private JTextField txtBuscar;
    private JButton btnBuscar, btnAgregar;
    private JLabel lblImagenSeleccionada;

    public PanelProductos() {
        setLayout(new BorderLayout());

        // Top panel: búsqueda y agregar
        JPanel panelSuperior = new JPanel(new FlowLayout(FlowLayout.LEFT));
        txtBuscar = new JTextField(20);
        btnBuscar = new JButton("Buscar");
        btnAgregar = new JButton("Agregar Producto");
        JButton btnEliminar = new JButton("Eliminar seleccionado");
        
        panelSuperior.add(new JLabel("Buscar:"));
        panelSuperior.add(txtBuscar);
        panelSuperior.add(btnBuscar);
        panelSuperior.add(btnAgregar);
        panelSuperior.add(btnEliminar);
        
        // Modelo de tabla con imagen
        modeloTabla = new DefaultTableModel(new String[]{"ID", "Nombre", "Modelo", "Precio", "Imagen"}, 0) {
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                if (columnIndex == 4) return ImageIcon.class;
                return Object.class;
            }

            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // todas las celdas no editables
            }
        };

        tabla = new JTable(modeloTabla);
        tabla.setRowHeight(60);

        // Imagen seleccionada
        lblImagenSeleccionada = new JLabel("Vista previa de la imagen");
        lblImagenSeleccionada.setHorizontalAlignment(JLabel.CENTER);
        lblImagenSeleccionada.setPreferredSize(new Dimension(200, 200));

        // Añadir al panel principal
        add(panelSuperior, BorderLayout.NORTH);
        add(new JScrollPane(tabla), BorderLayout.CENTER);
        add(lblImagenSeleccionada, BorderLayout.SOUTH);

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

        // Mostrar imagen al seleccionar
        tabla.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                int fila = tabla.getSelectedRow();
                if (fila >= 0) {
                    int id = (int) tabla.getValueAt(fila, 0);
                    ProductoDAO dao = new ProductoDAOimpl();
                    Producto p = dao.buscarPorId(id);

                    if (p != null && p.getImagen_url() != null) {
                        ImageIcon icono = new ImageIcon(p.getImagen_url());
                        Image img = icono.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
                        lblImagenSeleccionada.setIcon(new ImageIcon(img));
                        lblImagenSeleccionada.setText("");
                    } else {
                        lblImagenSeleccionada.setIcon(null);
                        lblImagenSeleccionada.setText("Sin imagen");
                    }
                }
            }
        });
    }

    private void cargarProductos(String filtroNombre) {
        modeloTabla.setRowCount(0); // limpiar
        ProductoDAO dao = new ProductoDAOimpl();
        List<Producto> lista = filtroNombre.isEmpty() ? dao.listar() : dao.buscarPorNombre(filtroNombre);

        for (Producto p : lista) {
            ImageIcon icono = null;
            if (p.getImagen_url() != null && !p.getImagen_url().isEmpty()) {
                Image img = new ImageIcon(p.getImagen_url()).getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH);
                icono = new ImageIcon(img);
            }
            modeloTabla.addRow(new Object[]{
                p.getId(),
                p.getNombre(),
                p.getModelo(),
                p.getPrecio(),
                icono
            });
        }
    }
}
