package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conexion {
	
	private static final String URL = "jdbc:mysql://localhost:3306/crud_pc";
	private static final String Username = "root";
	private static final String Password = "";
	private static final String Driver = "com.mysql.cj.jdbc.Driver";
	
	private static Connection connection = null;
	
	private conexion() {}
	
	
	
	
	public static Connection getConnection() {
        try {
            if (connection == null || connection.isClosed()) {
                // Cargar el driver
                Class.forName(Driver);
                
                // Establecer conexión
                connection = DriverManager.getConnection(URL, Username, Password);
                System.out.println("✅ Conexión exitosa a la base de datos Crud_pc");
            }
        } catch (ClassNotFoundException e) {
            System.err.println(" Error: Driver MySQL no encontrado");
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("Error al conectar con la base de datos");
            System.err.println("Verifica que MySQL esté corriendo y los datos sean correctos");
            e.printStackTrace();
        }
        return connection;
    }
	
	private conexion(Connection connection) {
		conexion.connection = connection;
	}
	
	
	public static void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("🔐 Conexión cerrada correctamente");
            }
        } catch (SQLException e) {
            System.err.println("❌ Error al cerrar la conexión");
            e.printStackTrace();
        }
    }
	
}
