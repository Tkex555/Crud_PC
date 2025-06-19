package mundo;

import java.util.Date;

public class Usuario {
	
	private int id;
	private Personas persona;
	private String usuario;
	private String passwordHash;
	private String rol;
	private Date fechaCreacion;
	private Date ultimoAcceso;
	
	public Usuario(int id, Personas persona, String usuario, String passwordHash, String rol, Date fechaCreacion, Date ultimoAcceso) {
		this.id = id;
		this.persona = persona;
		this.usuario = usuario;
		this.passwordHash = passwordHash;
		this.rol = rol;
		this.fechaCreacion = fechaCreacion;
		this.ultimoAcceso = ultimoAcceso;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
