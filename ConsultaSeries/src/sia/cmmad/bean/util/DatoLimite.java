package sia.cmmad.bean.util;

public class DatoLimite {

	private String dato;
	private String fecha;

	public DatoLimite(String dato, String fecha) {
		super();
		this.dato = dato;
		this.fecha = fecha;
	}

	public DatoLimite() {
		super();
		this.dato = "";
		this.fecha = "";
	}

	public String getFechaDato() {
		// TODO Auto-generated method stub
		return this.fecha;
	}

	public String getDato() {
		// TODO Auto-generated method stub
		return this.dato;
	}

	public void setDato(String dato) {
		this.dato = dato;
	}

	public Integer getDatoInt() {
		return Integer.parseInt(dato);
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

}