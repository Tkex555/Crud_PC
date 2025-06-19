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
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public Personas getPersona() {
		return persona;
	}
	
	public void setPersona(Personas persona) {
		this.persona = persona;
	}
	
	public String getUsuario() {
		return usuario;
	}
	
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	
	public String getPasswordHash() {
		return passwordHash;
	}
	
	public void setPasswordHash(String passwordHash) {
		this.passwordHash = passwordHash;
	}
	
	public String getRol() {
		return rol;
	}
	
	public void setRol(String rol) {
		this.rol = rol;
	}
	
	public Date getFechaCreacion() {
		return fechaCreacion;
	}
	
	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	
	public Date getUltimoAcceso() {
		return ultimoAcceso;
	}
	
	public void setUltimoAcceso(Date ultimoAcceso) {
		this.ultimoAcceso = ultimoAcceso;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
