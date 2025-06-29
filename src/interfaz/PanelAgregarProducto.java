package interfaz;

import mundo.Producto;
import DAO.ProductoDAO;
import DAO.ProductoDAOimpl;
import DAO.CategoriaDAO;
import DAO.MarcaDAO;
import mundo.Categoria;
import mundo.Marca;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

// Panel para agregar productos y crear inventario inicial
/**
 * Panel para agregar un nuevo producto al sistema.
 * Este panel permite ingresar los detalles del producto,
 * seleccionar una imagen y guardar el producto en la base de datos.
 */
public class PanelAgregarProducto extends JPanel {

    private JTextField txtNombre, txtModelo, txtPrecio, txtStock;
    private JTextArea txtDescripcion, txtEspecificaciones;
    private JComboBox<Categoria> comboCategoria;
    private JComboBox<Marca> comboMarca;
    private JLabel lblImagen, lblImagenPreview;
    private JButton btnSeleccionarImagen, btnGuardar;
    private String rutaImagenSeleccionada = "";

    private PanelProductos panelProductos;
    private JFrame ventana;
    
    /**
	 * Constructor del panel para agregar un nuevo producto.
	 * @param panelProductos El panel donde se mostrarán los productos.
	 * @param ventana La ventana principal de la aplicación, si es que se abre en una ventana secundaria.
	 */
    public PanelAgregarProducto(PanelProductos panelProductos, JFrame ventana) {
        this.panelProductos = panelProductos;
        this.ventana = ventana;

        setLayout(new GridBagLayout());
        setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(new Color(100, 149, 237), 2, true),
                "Agregar PC",
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
        txtDescripcion.setLineWrap(true);
        txtDescripcion.setWrapStyleWord(true);
        txtEspecificaciones = new JTextArea(3, 20);
        txtEspecificaciones.setLineWrap(true);
        txtEspecificaciones.setWrapStyleWord(true);
        comboCategoria = new JComboBox<>();
        // Llenar ComboBox de marcas con objetos Marca
        comboMarca = new JComboBox<>();
        MarcaDAO marcaDAO = new MarcaDAO();
        java.util.List<Marca> marcas = marcaDAO.obtenerTodas();
        for (Marca m : marcas) {
            comboMarca.addItem(m);
        }

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

        // Llenar ComboBox de categorías con objetos Categoria
        CategoriaDAO categoriaDAO = new CategoriaDAO();
        java.util.List<Categoria> categorias = categoriaDAO.obtenerTodas();
        for (Categoria c : categorias) {
            comboCategoria.addItem(c);
        }

        btnSeleccionarImagen.addActionListener(e -> seleccionarImagen());
        btnGuardar.addActionListener(e -> guardarProducto());
    }
    
    /**
	 * Método auxiliar para agregar una etiqueta y un componente al panel con GridBagLayout.
	 * @param gbc GridBagConstraints para posicionar los componentes.
	 * @param label Texto de la etiqueta.
	 * @param comp Componente a agregar (JTextField, JComboBox, etc.).
	 * @param y Fila en la que se agregará el componente.
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
	 * Utiliza JFileChooser para permitir al usuario seleccionar un archivo de imagen.
	 * La imagen seleccionada se copia a un directorio específico y se muestra en el panel.
	 */
    private void seleccionarImagen() {
        JFileChooser fileChooser = new JFileChooser();
        
        // Crear un filtro para solo permitir imágenes JPG y PNG
        fileChooser.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("Imágenes JPG/PNG", "jpg", "png"));
        
        int resultado = fileChooser.showOpenDialog(this);
        if (resultado == JFileChooser.APPROVE_OPTION) {
            File archivo = fileChooser.getSelectedFile();
            
            // Validar que la extensión sea .jpg o .png
            String extension = getFileExtension(archivo);
            if (extension.equals("jpg") || extension.equals("png")) {
                File destino = new File("data/imagenes/" + archivo.getName());
                try {
                    Files.copy(archivo.toPath(), destino.toPath(), StandardCopyOption.REPLACE_EXISTING);
                    rutaImagenSeleccionada = destino.getPath();
                    ImageIcon icon = new ImageIcon(new ImageIcon(rutaImagenSeleccionada)
                            .getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH));
                    lblImagenPreview.setIcon(icon);
                } catch (IOException e) {
                    JOptionPane.showMessageDialog(this, "Error al copiar imagen: " + e.getMessage());
                }
            } else {
                JOptionPane.showMessageDialog(this, "Solo se permiten archivos JPG y PNG.");
            }
        }
    }

    // Método auxiliar para obtener la extensión del archivo
    private String getFileExtension(File file) {
        String nombreArchivo = file.getName();
        int index = nombreArchivo.lastIndexOf('.');
        if (index > 0) {
            return nombreArchivo.substring(index + 1).toLowerCase();
        }
        return "";
    }

    
    /**
     * Método para guardar un nuevo producto en la base de datos.
     * Este método recoge los datos ingresados en los campos del formulario,
     * crea un objeto Producto y lo guarda en la base de datos.
     */
    private void guardarProducto() {
        try {
            Producto producto = new Producto();
            producto.setNombre(txtNombre.getText());
            producto.setModelo(txtModelo.getText());
            producto.setPrecio(Double.parseDouble(txtPrecio.getText()));
            int stock = Integer.parseInt(txtStock.getText());
            producto.setStock(stock);
            producto.setDescripcion(txtDescripcion.getText());
            producto.setEspecificaciones_tecnicas(txtEspecificaciones.getText());
            // Obtener el ID de la categoría seleccionada
            Categoria categoriaSeleccionada = (Categoria) comboCategoria.getSelectedItem();
            producto.setId_categoria(categoriaSeleccionada.getId());
            // Obtener el ID de la marca seleccionada
            Marca marcaSeleccionada = (Marca) comboMarca.getSelectedItem();
            producto.setId_marca(marcaSeleccionada.getId_marca());
            producto.setImagen_url(rutaImagenSeleccionada);

            ProductoDAO dao = new ProductoDAOimpl();
            dao.agregar(producto);

            // Obtener el id del producto recién insertado
            int idProducto = -1;
            try (Connection con = conexion.conexion.getConnection();
                 PreparedStatement ps = con.prepareStatement("SELECT id FROM productos ORDER BY id DESC LIMIT 1");
                 ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    idProducto = rs.getInt("id");
                }
            }
            if (idProducto != -1) {
                // Insertar en inventario con stock_actual igual al stock inicial, y min/max igual al stock inicial
                try (Connection con = conexion.conexion.getConnection();
                     PreparedStatement ps = con.prepareStatement(
                        "INSERT INTO inventario (id_producto, stock_actual, stock_minimo, stock_maximo) VALUES (?, ?, ?, ?)")
                ) {
                    ps.setInt(1, idProducto);
                    ps.setInt(2, stock);
                    ps.setInt(3, stock);
                    ps.setInt(4, stock);
                    ps.executeUpdate();
                }
            }

            JOptionPane.showMessageDialog(this, "Producto guardado correctamente.");
            panelProductos.cargarProductos("");

            if (ventana != null && ventana != SwingUtilities.getWindowAncestor(this)) {
                ventana.dispose(); // solo si fue abierto en una ventana secundaria
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al guardar: " + e.getMessage());
        }
    }
}
