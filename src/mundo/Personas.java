package mundo;

import java.util.Date;

public class Personas {
	
	private int id;
	private String primerNombre;
	private String segundoNombre;
	private String primerApellido;
	private String segundoApellido;
	private String email;
	private String telefono;
	private String direccion;
	private String ciudad;
	private String codigoPostal;
	private String tipoDocumento;
	private String numeroDocumento;
	private Date fechaNacimiento;
	private String genero;
	private Date fechaRegistro;
	
	public Personas( int id, String primerNombre, String segundoNombre, String primerApellido, String segundoApellido, 
			String email, String telefono, String direccion, String ciudad, String codigoPostal, String tipoDocumento,
			String numeroDocumento, Date fechaNacimiento, String genero, Date fechaRegistro) {
		
		this.id = id;
		this.primerNombre = primerNombre;
		this.segundoNombre = segundoNombre;
		this.primerApellido = primerApellido;
		this.segundoApellido = segundoApellido;
		this.email = email;
		this.telefono = telefono;
		this.direccion = direccion;
		this.ciudad = ciudad;
		this.codigoPostal = codigoPostal;
		this.tipoDocumento = tipoDocumento;
		this.numeroDocumento = numeroDocumento;
		this.fechaNacimiento = fechaNacimiento;
		this.genero = genero;
		this.fechaRegistro = fechaRegistro;
	}
	
	
	public int getId() {
		return id;
	}
	
	public String getPrimerNombre() {
		return primerNombre;
	}
	
	public String getSegundoNombre() {
		return segundoNombre;
	}
	
	public String getPrimerApellido() {
		return primerApellido;
	}
	
	public String getSegundoApellido() {
		return segundoApellido;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getTelefono() {
		return telefono;
	}
	
	public String getDireccion() {
		return direccion;
	}
	
	public String getCiudad() {
		return ciudad;
	}
	
	public String getCodigoPostal() {
		return codigoPostal;
	}
	
	public String getTipoDocumento() {
		return tipoDocumento;
	}
	
	public String getNumeroDocumento() {
		return numeroDocumento;
	}
	
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	
	public String getGenero() {
		return genero;
	}
	
	public Date getFechaRegistro() {
		return fechaRegistro;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
