package sia.cmmad.bean;


import java.util.List;

import org.apache.commons.lang.ObjectUtils;
import org.hibernate.Query;

import sia.cmmad.hibernate.HibernateSessionFactory;


public class Broker {

	// Unica instancia de la fachada
	private static Broker instance;

	private Broker() {
	}

	/**
	 * Retorna la �nica instancia de la fachada
	 * 
	 * @return
	 */
	public static Broker getInstance() {
		if (instance == null)
			instance = new Broker();
		return instance;
	}

	@SuppressWarnings("unchecked")
	public InformacionEstacion buscarEstacion(String estacion) {
		InformacionEstacion infoEstacion = new InformacionEstacion();
		String sql = "SELECT  e.ID_ES, "
				+ "e.NOMBRE_ES, "
				+ "e.CATEGORIA_ES , "
				+ "e.ESTADO_ES ,"
				+ "e.DESC_CATEGORIA, "
				+ "e.ALTURA_REFERENCIA_ES, "
				+ "e.ALTITUD,"
				+ "e.NOMBRE_FGDA, "
				+ "e.GRADOS_LATITUD, "
				+ "e.MINUTOS_LATITUD, "
				+ "e.SEGUNDOS_LATITUD, "
				+ "e.DIRECCION_LATITUD ,e.NOM_AREA ,e.NOM_ZONA ,e.NOM_SUBZONA ,"
				+ "e.GRADOS_LONGITUD , e.MINUTOS_LONGITUD, e.SEGUNDOS_LONGITUD ,e.DIRECCION_LONGITUD, ALTITUD,"
				+ "e.CODIGO_DIVIPOLA, e. ID_AREA, e.ID_ZONA, e.ID_SUBZONA, e.ID_CORRIENTE ,e.SIGLA_FGDA,"
				+ "div.NOMBRE_DV as municipio, div.NOMBRE_PADRE_DV as departamento , r.RAZON_SOCIAL as AREAOPERATIVA, "
				+ "e.cod_interno_es "
				+ "FROM SIOPERAN.SIOV_ESTACIONES e, SIOPERAN.SIOV_DIVIPOLAS div,  "
				+ "SIOPERAN.SIO_ORGANIZACION  r  "
				+ "WHERE div.CODIGO_DV=e.CODIGO_DIVIPOLA " + "AND (e.ID_ES="
				+ estacion + " OR e.cod_interno_es=" + estacion + ")"
				+ "AND r.TIPO = 'AOP' " + "AND r.ORGANIZACION_ID = e.ID_ORG";
		Query q = HibernateSessionFactory.currentSession().createSQLQuery(sql);
		List<Object[]> listObject = q.list();

		if (listObject.size() >= 1) {
			for (Object[] objects : listObject) {
				infoEstacion.setId_Es(ObjectUtils.toString(objects[0]));
				infoEstacion.setCod_interno_es(ObjectUtils
						.toString(objects[29]));
				infoEstacion
						.setNombreEstacion(ObjectUtils.toString(objects[1]));
				String categoria = ObjectUtils.toString(objects[2]) + " "
						+ ObjectUtils.toString(objects[4]);
				infoEstacion.setCategoria(categoria);
				String latitud = ObjectUtils.toString(objects[8])
						+ "�"
						+ ObjectUtils.toString(objects[9] + "'"
								+ ObjectUtils.toString(objects[10]) + "''"
								+ ObjectUtils.toString(objects[11]));
				infoEstacion.setLatitud(latitud);
				String longitud = ObjectUtils.toString(objects[15])
						+ "�"
						+ ObjectUtils.toString(objects[16] + "'"
								+ ObjectUtils.toString(objects[17]) + "''"
								+ ObjectUtils.toString(objects[18]));
				infoEstacion.setLongitud(longitud);
				infoEstacion.setCorriente(ObjectUtils.toString(objects[24]));
				infoEstacion.setMunicipio(ObjectUtils.toString(objects[26]));
				infoEstacion.setDepartamento(ObjectUtils.toString(objects[27]));
				infoEstacion.setAreaHidrografica(ObjectUtils
						.toString(objects[12]));
				infoEstacion.setZonaHidrografica(ObjectUtils
						.toString(objects[13]));
				infoEstacion.setSubzonaHidrografica(ObjectUtils
						.toString(objects[14]));
				infoEstacion.setElevacion(ObjectUtils.toString(objects[19])
						+ " msnm ");
				infoEstacion.setEntidad(ObjectUtils.toString(objects[25]));
				String areaOperativa = ObjectUtils.toString(objects[28]);
				infoEstacion.setAreaOperativa(areaOperativa);
			}
			return infoEstacion;
		} else
			return null;
	}

}