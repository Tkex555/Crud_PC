package interfaz;

import DAO.ProductoDAO;
import DAO.ProductoDAOimpl;
import DAO.CategoriaDAO;
import DAO.MarcaDAO;
import DAO.InventarioUpdater;
import mundo.Producto;
import mundo.Categoria;
import mundo.Marca;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.*;


// Panel para editar productos y actualizar inventario
/**
 * Panel para editar un producto existente en el sistema.
 * Este panel permite modificar los detalles del producto,
 * cambiar la imagen y actualizar la información en la base de datos.
 */
public class panelEditarProducto extends JPanel {
	
	private JTextField txtNombre, txtModelo, txtPrecio, txtStock;
    private JTextArea txtDescripcion, txtEspecificaciones;
    private JComboBox<Categoria> comboCategoria;
    private JComboBox<Marca> comboMarca;
    private JLabel lblImagenPreview;
    private JButton btnSeleccionarImagen, btnActualizar;
    private String rutaImagenSeleccionada = "";
    private Producto producto;
    
    private PanelProductos panelProductos;
    private JFrame ventana;
    
    /**
	 * Constructor del panel para editar un producto existente.
	 * @param productoExistente El producto a editar.
	 * @param panelProductos El panel donde se mostrarán los productos.
	 * @param ventana La ventana principal de la aplicación.
	 */
    public panelEditarProducto(Producto productoExistente, PanelProductos panelProductos, JFrame ventana) {
        this.producto = productoExistente;
        this.panelProductos = panelProductos;
        this.ventana = ventana;
        
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 10, 5, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        txtNombre = new JTextField(producto.getNombre());
        txtModelo = new JTextField(producto.getModelo());
        txtPrecio = new JTextField(String.valueOf(producto.getPrecio()));
        txtStock = new JTextField(String.valueOf(producto.getStock()));
        txtDescripcion = new JTextArea(producto.getDescripcion(), 3, 20);
        txtDescripcion.setLineWrap(true);
        txtDescripcion.setWrapStyleWord(true);
        txtEspecificaciones = new JTextArea(producto.getEspecificaciones_tecnicas(), 3, 20);
        txtEspecificaciones.setLineWrap(true);
        txtEspecificaciones.setWrapStyleWord(true);

        // Llenar ComboBox de categorías con objetos Categoria
        comboCategoria = new JComboBox<>();
        CategoriaDAO categoriaDAO = new CategoriaDAO();
        java.util.List<Categoria> categorias = categoriaDAO.obtenerTodas();
        for (Categoria c : categorias) {
            comboCategoria.addItem(c);
        }
        // Seleccionar la categoría correspondiente al producto
        for (int i = 0; i < comboCategoria.getItemCount(); i++) {
            if (comboCategoria.getItemAt(i).getId() == producto.getId_categoria()) {
                comboCategoria.setSelectedIndex(i);
                break;
            }
        }
        // Llenar ComboBox de marcas con objetos Marca
        comboMarca = new JComboBox<>();
        MarcaDAO marcaDAO = new MarcaDAO();
        java.util.List<Marca> marcas = marcaDAO.obtenerTodas();
        for (Marca m : marcas) {
            comboMarca.addItem(m);
        }
        // Seleccionar la marca correspondiente al producto
        for (int i = 0; i < comboMarca.getItemCount(); i++) {
            if (comboMarca.getItemAt(i).getId_marca() == producto.getId_marca()) {
                comboMarca.setSelectedIndex(i);
                break;
            }
        }

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
    
    /**
	 * Método auxiliar para agregar una etiqueta y un componente al panel con GridBagLayout.
	 * @param gbc Las restricciones de GridBagConstraints.
	 * @param label El texto de la etiqueta.
	 * @param comp El componente a agregar.
	 * @param y La posición vertical en el GridBagLayout.
	 */
    private void addLabelAndComponent(GridBagConstraints gbc, String label, Component comp, int y) {
        gbc.gridx = 0;
        gbc.gridy = y;
        add(new JLabel(label), gbc);
        gbc.gridx = 1;
        add(comp, gbc);
    }
    
    /**
	 * Método para seleccionar una imagen desde el sistema de archivos.
	 * Copia la imagen seleccionada a la carpeta "data/imagenes" y actualiza la vista previa.
	 */
    private void seleccionarImagen() {
        JFileChooser fileChooser = new JFileChooser();
        int resultado = fileChooser.showOpenDialog(this);
        if (resultado == JFileChooser.APPROVE_OPTION) {
            File archivo = fileChooser.getSelectedFile();
            File destino = new File("data/imagenes/" + archivo.getName());

            try {
                Files.copy(archivo.toPath(), destino.toPath(), StandardCopyOption.REPLACE_EXISTING);
                rutaImagenSeleccionada = destino.getPath();
                ImageIcon icon = new ImageIcon(new ImageIcon(rutaImagenSeleccionada).getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH));
                lblImagenPreview.setIcon(icon);
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, "Error al copiar imagen: " + e.getMessage());
            }
        }
    }
    
    /**
     * Método para actualizar el producto con los datos ingresados en el formulario.
     * Actualiza la información del producto en la base de datos y en el inventario.
     * Si no se selecciona una nueva imagen, se mantiene la imagen actual.
     * Actualiza la vista previa de la imagen en el panel principal si existe.
     */
    private void actualizarProducto() {
        try {
            producto.setNombre(txtNombre.getText());
            producto.setModelo(txtModelo.getText());
            producto.setPrecio(Double.parseDouble(txtPrecio.getText()));
            producto.setStock(Integer.parseInt(txtStock.getText()));
            producto.setDescripcion(txtDescripcion.getText());
            producto.setEspecificaciones_tecnicas(txtEspecificaciones.getText());
            // Obtener el ID de la categoría seleccionada
            Categoria categoriaSeleccionada = (Categoria) comboCategoria.getSelectedItem();
            producto.setId_categoria(categoriaSeleccionada.getId());
            // Obtener el ID de la marca seleccionada
            Marca marcaSeleccionada = (Marca) comboMarca.getSelectedItem();
            producto.setId_marca(marcaSeleccionada.getId_marca());

            // Si no se seleccionó una nueva imagen, usa la actual
            if (rutaImagenSeleccionada == null || rutaImagenSeleccionada.isEmpty()) {
                producto.setImagen_url(producto.getImagen_url());
            } else {
                producto.setImagen_url(rutaImagenSeleccionada);
            }

            ProductoDAO dao = new ProductoDAOimpl();
            dao.actualizar(producto);

            // Actualizar inventario
            InventarioUpdater.actualizarInventarioPorProducto(producto.getId(), producto.getStock());

            // Actualiza la vista previa de la imagen en el panel principal si existe
            if (producto.getImagen_url() != null && !producto.getImagen_url().isEmpty()) {
                ImageIcon icon = new ImageIcon(new ImageIcon(producto.getImagen_url()).getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH));
                lblImagenPreview.setIcon(icon);
            } else {
                lblImagenPreview.setIcon(null);
            }

            panelProductos.cargarProductos(""); // Actualiza la tabla
            JOptionPane.showMessageDialog(this, "Producto actualizado correctamente.");

            if (ventana != null && ventana != SwingUtilities.getWindowAncestor(this)) {
                ventana.dispose(); // solo si fue abierto en una ventana secundaria
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al actualizar: " + e.getMessage());
        }
    }

}
