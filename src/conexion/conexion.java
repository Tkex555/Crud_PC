package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Clase que maneja la conexión a la base de datos MySQL.
 * Contiene métodos para obtener una conexión y cerrar la conexión. 
 */
public class conexion {
	
	private static final String URL = "jdbc:mysql://localhost:3306/crud_pc";
	private static final String Username = "root";
	private static final String Password = "";
	private static final String Driver = "com.mysql.cj.jdbc.Driver";
	
	private static Connection connection = null;
	
	private conexion() {}
	
	/**
	 * Método para obtener una conexión a la base de datos.
	 * Si la conexión ya existe y está abierta, la devuelve; de lo contrario, crea una nueva conexión.
	 * @return Connection - Objeto de conexión a la base de datos.
	 */
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
	
	/**
	 * Método privado para establecer la conexión a la base de datos.
	 * @param connection
	 */
	private conexion(Connection connection) {
		conexion.connection = connection;
	}
	
	/**
	 * Método para cerrar la conexión a la base de datos.
	 * Si la conexión está abierta, la cierra y libera los recursos.
	 */
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
