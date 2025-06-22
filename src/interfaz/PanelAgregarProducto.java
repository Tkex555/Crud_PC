package interfaz;

import mundo.Producto;
import DAO.ProductoDAO;
import DAO.ProductoDAOimpl;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.*;

public class PanelAgregarProducto extends JPanel {

    private JTextField txtNombre, txtModelo, txtPrecio, txtStock;
    private JTextArea txtDescripcion, txtEspecificaciones;
    private JComboBox<String> comboCategoria, comboMarca;
    private JLabel lblImagen, lblImagenPreview;
    private JButton btnSeleccionarImagen, btnGuardar;
    private String rutaImagenSeleccionada = "";

    public PanelAgregarProducto() {
        setLayout(new GridBagLayout());
        setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(new Color(100, 149, 237), 2, true),
                "Agregar Producto",
                javax.swing.border.TitledBorder.CENTER,
                javax.swing.border.TitledBorder.TOP,
                new Font("Arial", Font.BOLD, 18),
                new Color(100, 149, 237)
            ));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 10, 5, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        txtNombre = new JTextField();
        txtModelo = new JTextField();
        txtPrecio = new JTextField();
        txtStock = new JTextField();
        txtDescripcion = new JTextArea(3, 20);
        txtEspecificaciones = new JTextArea(3, 20);
        comboCategoria = new JComboBox<>(new String[]{"1", "2"});
        comboMarca = new JComboBox<>(new String[]{"1", "2"});

        lblImagen = new JLabel("Sin imagen");
        lblImagenPreview = new JLabel();
        lblImagenPreview.setPreferredSize(new Dimension(100, 100));
        lblImagenPreview.setBorder(BorderFactory.createLineBorder(Color.GRAY));

        btnSeleccionarImagen = new JButton("Seleccionar Imagen");
        btnGuardar = new JButton("Guardar Producto");

        int y = 0;

        addLabelAndComponent(gbc, "Nombre:", txtNombre, y++);
        addLabelAndComponent(gbc, "Modelo:", txtModelo, y++);
        addLabelAndComponent(gbc, "Precio:", txtPrecio, y++);
        addLabelAndComponent(gbc, "Stock:", txtStock, y++);
        addLabelAndComponent(gbc, "Descripción:", new JScrollPane(txtDescripcion), y++);
        addLabelAndComponent(gbc, "Especificaciones:", new JScrollPane(txtEspecificaciones), y++);
        addLabelAndComponent(gbc, "Categoría:", comboCategoria, y++);
        addLabelAndComponent(gbc, "Marca:", comboMarca, y++);
        addLabelAndComponent(gbc, "Imagen:", btnSeleccionarImagen, y++);
        addLabelAndComponent(gbc, "", lblImagenPreview, y++);

        gbc.gridx = 1;
        gbc.gridy = y;
        add(btnGuardar, gbc);

        btnSeleccionarImagen.addActionListener(e -> seleccionarImagen());
        btnGuardar.addActionListener(e -> guardarProducto());
    }

    private void addLabelAndComponent(GridBagConstraints gbc, String label, Component comp, int y) {
        gbc.gridx = 0;
        gbc.gridy = y;
        add(new JLabel(label), gbc);

        gbc.gridx = 1;
        add(comp, gbc);
    }

    private void seleccionarImagen() {
        JFileChooser fileChooser = new JFileChooser();
        int resultado = fileChooser.showOpenDialog(this);
        if (resultado == JFileChooser.APPROVE_OPTION) {
            File archivo = fileChooser.getSelectedFile();
            File destino = new File("data/imagenes/" + archivo.getName());

            try {
                Files.copy(archivo.toPath(), destino.toPath(), StandardCopyOption.REPLACE_EXISTING);
                rutaImagenSeleccionada = destino.getPath();

                ImageIcon icon = new ImageIcon(new ImageIcon(rutaImagenSeleccionada)
                        .getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH));
                lblImagenPreview.setIcon(icon);
                lblImagen.setText(archivo.getName());

            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, "Error al copiar imagen: " + e.getMessage());
            }
        }
    }

    private void guardarProducto() {
        try {
            Producto producto = new Producto();
            producto.setNombre(txtNombre.getText());
            producto.setModelo(txtModelo.getText());
            producto.setPrecio(Double.parseDouble(txtPrecio.getText()));
            producto.setStock(Integer.parseInt(txtStock.getText()));
            producto.setDescripcion(txtDescripcion.getText());
            producto.setEspecificaciones_tecnicas(txtEspecificaciones.getText());
            producto.setId_categoria(Integer.parseInt((String) comboCategoria.getSelectedItem()));
            producto.setId_marca(Integer.parseInt((String) comboMarca.getSelectedItem()));
            producto.setImagen_url(rutaImagenSeleccionada);

            ProductoDAO dao = new ProductoDAOimpl();
            dao.agregar(producto);

            JOptionPane.showMessageDialog(this, "Producto guardado correctamente.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al guardar: " + e.getMessage());
        }
    }
}
