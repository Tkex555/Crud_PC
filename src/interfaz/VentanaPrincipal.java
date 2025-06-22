package interfaz;

import javax.swing.*;
import java.awt.*;

public class VentanaPrincipal extends JFrame {

    private CardLayout cardLayout;
    private JPanel panelCentral;

    public VentanaPrincipal() {
        setTitle("Gestión de Computadoras");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 600);
        setLocationRelativeTo(null); // Centrar ventana
        setLayout(new BorderLayout());
        setResizable(false);

        // Panel de botones abajo
        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER, 30, 10));
        panelBotones.setBackground(new Color(230, 230, 250));
        panelBotones.setBorder(BorderFactory.createEmptyBorder(20, 10, 20, 10));

        JButton btninicio = new JButton("Inicio");
        JButton btnAgregar = new JButton("Agregar");
        JButton btnListar = new JButton("Listar");
        
        
        //hacer los botones más grandes
        btninicio.setPreferredSize(new Dimension(150, 50));
        btnAgregar.setPreferredSize(new Dimension(150, 50));
        btnListar.setPreferredSize(new Dimension(150, 50));

        // Agregar botones al panel
        panelBotones.add(btninicio);
        panelBotones.add(btnAgregar);
        panelBotones.add(btnListar);
        add(panelBotones, BorderLayout.SOUTH);

        // Panel central con CardLayout
        cardLayout = new CardLayout();
        panelCentral = new JPanel(cardLayout);
        
        
        JPanel panelTextoImagen = new JPanel();
        panelTextoImagen.setLayout(new BoxLayout(panelTextoImagen, BoxLayout.Y_AXIS));
        panelTextoImagen.setOpaque(false); 

        // Texto arriba de la imagen
        JLabel textoArriba = new JLabel("Bienvenido al sistema de gestión de computadoras", SwingConstants.CENTER);
        textoArriba.setFont(new Font("Arial", Font.BOLD, 28));
        textoArriba.setAlignmentX(Component.CENTER_ALIGNMENT);
        textoArriba.setMaximumSize(new Dimension(Integer.MAX_VALUE, textoArriba.getPreferredSize().height));
        

        JLabel imagenInicio = new JLabel();
        ImageIcon icono = new ImageIcon("data/imagenes/Logoprincipal.png");
        ImageIcon iconoRedimensionado = new ImageIcon(icono.getImage().getScaledInstance(500, 300, Image.SCALE_SMOOTH));
        icono = iconoRedimensionado;
        imagenInicio.setIcon(icono);
        imagenInicio.setHorizontalAlignment(SwingConstants.CENTER);
        imagenInicio.setVerticalAlignment(SwingConstants.CENTER);
        
        panelTextoImagen.add(Box.createVerticalStrut(20)); 
        panelTextoImagen.add(textoArriba);
        panelTextoImagen.add(Box.createVerticalStrut(20)); 
        panelTextoImagen.add(imagenInicio);
        

        // Panel para centrar la imagen
        JPanel panelImagen = new JPanel(new GridBagLayout());
        panelImagen.add(panelTextoImagen);

        panelCentral.add(panelImagen, "Inicio");

        // Paneles del CRUD
        PanelAgregarProducto panelAgregar = new PanelAgregarProducto();
        PanelProductos panelListar = new PanelProductos();

        panelCentral.add(panelAgregar, "Agregar");
        panelCentral.add(panelListar, "Listar");

        add(panelCentral, BorderLayout.CENTER);

        // Acciones de los botones
        btninicio.addActionListener(e -> cardLayout.show(panelCentral, "Inicio"));
        btnAgregar.addActionListener(e -> cardLayout.show(panelCentral, "Agregar"));
        btnListar.addActionListener(e -> cardLayout.show(panelCentral, "Listar"));

        setVisible(true);
    }

    // Método main para lanzar la app directamente
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new VentanaPrincipal());
    }
}