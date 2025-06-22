package interfaz;

import DAO.ProductoDAO;
import DAO.ProductoDAOimpl;
import mundo.Producto;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.*;


public class panelEditarProducto extends JPanel {
	
	private JTextField txtNombre, txtModelo, txtPrecio, txtStock;
    private JTextArea txtDescripcion, txtEspecificaciones;
    private JComboBox<String> comboCategoria, comboMarca;
    private JLabel lblImagenPreview;
    private JButton btnSeleccionarImagen, btnActualizar;
    private String rutaImagenSeleccionada = "";
    private Producto producto;
    
    public panelEditarProducto(Producto productoExistente) {
        this.producto = productoExistente;

        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 10, 5, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        txtNombre = new JTextField(producto.getNombre());
        txtModelo = new JTextField(producto.getModelo());
        txtPrecio = new JTextField(String.valueOf(producto.getPrecio()));
        txtStock = new JTextField(String.valueOf(producto.getStock()));
        txtDescripcion = new JTextArea(producto.getDescripcion(), 3, 20);
        txtEspecificaciones = new JTextArea(producto.getEspecificaciones_tecnicas(), 3, 20);
        comboCategoria = new JComboBox<>(new String[]{"1", "2"});
        comboMarca = new JComboBox<>(new String[]{"1", "2"});

        comboCategoria.setSelectedItem(String.valueOf(producto.getId_categoria()));
        comboMarca.setSelectedItem(String.valueOf(producto.getId_marca()));

        lblImagenPreview = new JLabel();
        lblImagenPreview.setPreferredSize(new Dimension(100, 100));
        lblImagenPreview.setBorder(BorderFactory.createLineBorder(Color.GRAY));

        if (producto.getImagen_url() != null && !producto.getImagen_url().isEmpty()) {
            rutaImagenSeleccionada = producto.getImagen_url();
            ImageIcon icon = new ImageIcon(new ImageIcon(rutaImagenSeleccionada).getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH));
            lblImagenPreview.setIcon(icon);
        }

        btnSeleccionarImagen = new JButton("Cambiar Imagen");
        btnActualizar = new JButton("Actualizar");
        
        int y = 0;

        addLabelAndComponent(gbc, "Nombre:", txtNombre, y++);
        addLabelAndComponent(gbc, "Modelo:", txtModelo, y++);
        addLabelAndComponent(gbc, "Precio:", txtPrecio, y++);
        addLabelAndComponent(gbc, "Stock:", txtStock, y++);
        addLabelAndComponent(gbc, "Descripción:", new JScrollPane(txtDescripcion), y++);
        addLabelAndComponent(gbc, "Especificaciones:", new JScrollPane(txtEspecificaciones), y++);
        addLabelAndComponent(gbc, "Categoría:", comboCategoria, y++);
        addLabelAndComponent(gbc, "Marca:", comboMarca, y++);
        addLabelAndComponent(gbc, "Imagen actual:", lblImagenPreview, y++);
        addLabelAndComponent(gbc, "", btnSeleccionarImagen, y++);
        gbc.gridx = 1;
        gbc.gridy = y;
        add(btnActualizar, gbc);

        btnSeleccionarImagen.addActionListener(e -> seleccionarImagen());
        btnActualizar.addActionListener(e -> actualizarProducto());
    }
}
