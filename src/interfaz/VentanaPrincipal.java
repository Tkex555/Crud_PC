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
        JPanel panelBotones = new JPanel(new GringLayout(3, 1, 10, 10));

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
