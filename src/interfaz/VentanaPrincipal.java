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
        
        
        //botones
        JPanel panelBotones = new JPanel(new GridLayout(3, 1, 10, 10));
        panelBotones.setBackground(new Color(230, 230, 250));
        panelBotones.setBorder(BorderFactory.createEmptyBorder(20, 10, 20, 10));
        
        JButton btninicio = new JButton("Inicio");
        JButton btnAgregar = new JButton("Agregar");
        JButton btnListar = new JButton("Listar");
        
        // Agregar botones al panel
        panelBotones.add(btninicio);
        panelBotones.add(btnAgregar);
        panelBotones.add(btnListar);
        add(panelBotones, BorderLayout.WEST);
        
        // Panel central con CardLayout
        cardLayout = new CardLayout();
        panelCentral = new JPanel(cardLayout);
        
        //imagen 
        
        JLabel imagenInicio = new JLabel();
        imagenInicio.setIcon(new ImageIcon("data/imagenes/Logoprincipal.png")); 
        imagenInicio.setIcon(icono);
        imagenInicio.setHorizontalAlignment(SwingConstants.CENTER);
        panelCentral.add(imagenInicio, "Inicio");
        
        //panales del Crud
        
        PanelAgregarProducto panelAgregar = new PanelAgregarProducto();

        // Panel principal de productos
        PanelProductos panelProductos = new PanelProductos();
        add(panelProductos, BorderLayout.CENTER);

        setVisible(true);
    }

    // Método main para lanzar la app directamente
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new VentanaPrincipal());
    }
}
