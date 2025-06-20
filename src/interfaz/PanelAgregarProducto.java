package interfaz;

import javax.swing.*;

public class PanelAgregarProducto extends JPanel {

    public PanelAgregarProducto() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(new JLabel("Aquí va el formulario para agregar producto"));
        // Aquí irán los campos JTextField, JComboBox, etc.
    }
}
