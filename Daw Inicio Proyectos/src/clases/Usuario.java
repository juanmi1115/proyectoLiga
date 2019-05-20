package clases;

import java.time.LocalDate;

import excepciones.Contrase�aCortaExcaption;

public class Usuario {
	private String nombre;
	private String contrasenia;
	private LocalDate fechaNacimiento;
	private String email;
	
	/**
	 * 
	 * @param nombre
	 * @param contrasenia
	 * @param fechaNacimiento
	 * @param email
	 * @throws Contrase�aCortaExcaption 
	 */
	public Usuario(String nombre, String contrasenia, LocalDate fechaNacimiento, String email) throws Contrase�aCortaExcaption {
		super();
		this.nombre = nombre;
		this.setContrasenia(contrasenia);
		this.fechaNacimiento = fechaNacimiento;
		this.email = email;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the contrasenia
	 */
	public String getContrasenia() {
		return contrasenia;
	}

	/**
	 * @param contrasenia the contrasenia to set
	 * @throws Contrase�aCortaExcaption 
	 */
	public void setContrasenia(String contrasenia) throws Contrase�aCortaExcaption {
		if(contrasenia.length() <8 ) {
			throw new Contrase�aCortaExcaption();
			
		}
		this.contrasenia = contrasenia;
	}

	/**
	 * @return the fechaNacimiento
	 */
	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	/**
	 * @param fechaNacimiento the fechaNacimiento to set
	 */
	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
