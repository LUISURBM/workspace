package sia.cmmad.bean;

import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

import org.icefaces.ace.component.maskedentry.MaskedEntry;

import com.icesoft.faces.component.InputTextareaTag;
import com.icesoft.faces.component.ext.HtmlInputText;
import com.icesoft.faces.component.ext.HtmlInputTextarea;

import static org.apache.commons.lang.StringUtils.isNumeric;

public class InformacionEstacion {

	private transient MaskedEntry codigoEstacion;
	private transient HtmlInputText inputnombreEstacion,
			inputcodInternoEstacion, inputlongitud, inputlatitud,
			inputelevacion, inputareaOperativa, inputentidad, inputcategoria,
			inputdepartamento, inputmunicipio, inputcorriente,
			inputareaHidrografica, inputzonaHidrografica;
	private transient HtmlInputTextarea inputsubzonaHidrografica;
	private transient String nombreEstacion, longitud, latitud, elevacion,
			areaOperativa, entidad, categoria, departamento, municipio,
			corriente, areaHidrografica, zonaHidrografica, subzonaHidrografica;
	private transient String id_Es, cod_interno_es;
	protected boolean estacionVisible, mensajeVisible = false;
	private String mensaje = "";

	public boolean isMensajeVisible() {
		return mensajeVisible;
	}

	public boolean isEstacionVisible() {
		return estacionVisible;
	}

	public void setEstacionVisible(boolean estacionVisible) {
		this.estacionVisible = estacionVisible;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public void setMensajeVisible(boolean mensajeVisible) {
		this.mensajeVisible = mensajeVisible;
	}

	public org.icefaces.ace.component.maskedentry.MaskedEntry getCodigoEstacion() {
		return codigoEstacion;
	}

	public HtmlInputText getInputnombreEstacion() {
		return inputnombreEstacion;
	}

	public void setInputnombreEstacion(HtmlInputText inputnombreEstacion) {
		this.inputnombreEstacion = inputnombreEstacion;
	}

	public HtmlInputText getInputcodInternoEstacion() {
		return inputcodInternoEstacion;
	}

	public void setInputcodInternoEstacion(HtmlInputText inputcodInternoEstacion) {
		this.inputcodInternoEstacion = inputcodInternoEstacion;
	}

	public HtmlInputText getInputlongitud() {
		return inputlongitud;
	}

	public void setInputlongitud(HtmlInputText inputlongitud) {
		this.inputlongitud = inputlongitud;
	}

	public HtmlInputText getInputlatitud() {
		return inputlatitud;
	}

	public void setInputlatitud(HtmlInputText inputlatitud) {
		this.inputlatitud = inputlatitud;
	}

	public HtmlInputText getInputelevacion() {
		return inputelevacion;
	}

	public void setInputelevacion(HtmlInputText inputelevacion) {
		this.inputelevacion = inputelevacion;
	}

	public HtmlInputText getInputareaOperativa() {
		return inputareaOperativa;
	}

	public void setInputareaOperativa(HtmlInputText inputareaOperativa) {
		this.inputareaOperativa = inputareaOperativa;
	}

	public HtmlInputText getInputentidad() {
		return inputentidad;
	}

	public void setInputentidad(HtmlInputText inputentidad) {
		this.inputentidad = inputentidad;
	}

	public HtmlInputText getInputcategoria() {
		return inputcategoria;
	}

	public void setInputcategoria(HtmlInputText inputcategoria) {
		this.inputcategoria = inputcategoria;
	}

	public HtmlInputText getInputdepartamento() {
		return inputdepartamento;
	}

	public void setInputdepartamento(HtmlInputText inputdepartamento) {
		this.inputdepartamento = inputdepartamento;
	}

	public HtmlInputText getInputmunicipio() {
		return inputmunicipio;
	}

	public void setInputmunicipio(HtmlInputText inputmunicipio) {
		this.inputmunicipio = inputmunicipio;
	}

	public HtmlInputText getInputcorriente() {
		return inputcorriente;
	}

	public void setInputcorriente(HtmlInputText inputcorriente) {
		this.inputcorriente = inputcorriente;
	}

	public HtmlInputText getInputareaHidrografica() {
		return inputareaHidrografica;
	}

	public void setInputareaHidrografica(HtmlInputText inputareaHidrografica) {
		this.inputareaHidrografica = inputareaHidrografica;
	}

	public HtmlInputText getInputzonaHidrografica() {
		return inputzonaHidrografica;
	}

	public void setInputzonaHidrografica(HtmlInputText inputzonaHidrografica) {
		this.inputzonaHidrografica = inputzonaHidrografica;
	}

	public HtmlInputTextarea getInputsubzonaHidrografica() {
		return inputsubzonaHidrografica;
	}

	public void setInputsubzonaHidrografica(
			HtmlInputTextarea inputsubzonaHidrografica) {
		this.inputsubzonaHidrografica = inputsubzonaHidrografica;
	}

	public void setCodigoEstacion(
			org.icefaces.ace.component.maskedentry.MaskedEntry codigoEstacion) {
		this.codigoEstacion = codigoEstacion;
	}

	public String getId_Es() {
		return id_Es;
	}

	public void setId_Es(String id_Es) {
		this.id_Es = id_Es;
	}

	public String getCod_interno_es() {
		return cod_interno_es;
	}

	public void setCod_interno_es(String codInternoEs) {
		cod_interno_es = codInternoEs;
	}

	public String getNombreEstacion() {
		return nombreEstacion;
	}

	public void setNombreEstacion(String nombreEstacion) {
		this.nombreEstacion = nombreEstacion;
	}

	public String getLongitud() {
		return longitud;
	}

	public void setLongitud(String longitud) {
		this.longitud = longitud;
	}

	public String getLatitud() {
		return latitud;
	}

	public void setLatitud(String latitud) {
		this.latitud = latitud;
	}

	public String getElevacion() {
		return elevacion;
	}

	public void setElevacion(String elevacion) {
		this.elevacion = elevacion;
	}

	public String getAreaOperativa() {
		return areaOperativa;
	}

	public void setAreaOperativa(String areaOperativa) {
		this.areaOperativa = areaOperativa;
	}

	public String getEntidad() {
		return entidad;
	}

	public void setEntidad(String entidad) {
		this.entidad = entidad;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	public String getMunicipio() {
		return municipio;
	}

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

	public String getCorriente() {
		return corriente;
	}

	public void setCorriente(String corriente) {
		this.corriente = corriente;
	}

	public String getAreaHidrografica() {
		return areaHidrografica;
	}

	public void setAreaHidrografica(String areaHidrografica) {
		this.areaHidrografica = areaHidrografica;
	}

	public String getZonaHidrografica() {
		return zonaHidrografica;
	}

	public void setZonaHidrografica(String zonaHidrografica) {
		this.zonaHidrografica = zonaHidrografica;
	}

	public String getSubzonaHidrografica() {
		return subzonaHidrografica;
	}

	public void setSubzonaHidrografica(String subzonaHidrografica) {
		this.subzonaHidrografica = subzonaHidrografica;
	}

	protected static FacesContext context() {
		return FacesContext.getCurrentInstance();
	}

	private static Broker broker() {
		return Broker.getInstance();
	}

	public void buscarEstacion(ValueChangeEvent e) throws Exception {
		FacesContext context = FacesContext.getCurrentInstance();
		FacadeBean fbean = (FacadeBean) context.getApplication()
				.createValueBinding("#{BeanFachada}").getValue(context);
		fbean.setCambiosCombos(false);
		fbean.setFechaBusqueda(null);
		String estacion = (String) e.getNewValue();
		estacion = estacion.replace("_", " ");
		if (estacion.equals(null)) {
			if (estacion.equals("")) {
				if (isNumeric(estacion)) {
					estacionVisible = false;
					mensajeVisible = true;
					setMensaje("Código de estación invalido");
				}
			}
		} else {
			buscarEstacion(estacion);
		}
	}

	private void buscarEstacion(String estacion) {
		InformacionEstacion informacion = broker().buscarEstacion(estacion);
		if (informacion == null) {
			estacionVisible = false;
			mensajeVisible = true;
			setMensaje("El código no corresponde a ninguna estación registrada");
		} else {
			estacionVisible = true;
			mensajeVisible = false;
			inputnombreEstacion.setValue(informacion.getNombreEstacion());
			inputcategoria.setValue(informacion.getCategoria());
			inputlatitud.setValue(informacion.getLatitud());
			inputlongitud.setValue(informacion.getLongitud());
			inputcorriente.setValue(informacion.getCorriente());
			inputmunicipio.setValue(informacion.getMunicipio());
			inputdepartamento.setValue(informacion.getDepartamento());
			inputareaHidrografica.setValue(informacion.getAreaHidrografica());
			inputzonaHidrografica.setValue(informacion.getZonaHidrografica());
			inputsubzonaHidrografica.setValue(informacion
					.getSubzonaHidrografica());
			inputelevacion.setValue(informacion.getElevacion());
			inputareaOperativa.setValue(informacion.getAreaOperativa());
			inputentidad.setValue(informacion.getEntidad());

			setId_Es(informacion.getId_Es());
			setCod_interno_es(informacion.getCod_interno_es());
			inputcodInternoEstacion.setValue(informacion.getCod_interno_es());
		}
	}
}
