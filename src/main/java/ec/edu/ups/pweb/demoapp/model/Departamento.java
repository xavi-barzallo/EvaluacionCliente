package ec.edu.ups.pweb.demoapp.model;
import java.io.Serializable;





public class Departamento implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	private int codigo;
	private int numeroPiso;

	private String direccion;
	
	private int numeroCuartos;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public int getNumeroPiso() {
		return numeroPiso;
	}

	public void setNumeroPiso(int numeroPiso) {
		this.numeroPiso = numeroPiso;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public int getNumeroCuartos() {
		return numeroCuartos;
	}

	public void setNumeroCuartos(int numeroCuartos) {
		this.numeroCuartos = numeroCuartos;
	}

	
	
}




