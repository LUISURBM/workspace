/*   1:    */package sia.cmmad.bean.util;

import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.jboss.logging.Logger;

/*  29:    */
/*  30:    */public final class Utiles
/* 31: */{
	private static Logger log = Logger.getLogger(Utiles.class);

	/* 135: */
	/* 136: */@Deprecated
	/* 137: */static HttpSession httpSession()
	/* 138: */{
		/* 139:152 */return (HttpSession) context().getExternalContext()
				.getSession(true);
		/* 140: */}

	/* 141: */
	/* 142: */public static void mostrarMensaje(FacesMessage facesMessage,
			String clientId)
	/* 143: */{
		/* 146:158 */context().addMessage(clientId, facesMessage);
		/* 147: */}

	/* 148: */
	/* 149: */public static FacesContext context()
	/* 150: */{
		/* 151:162 */return FacesContext.getCurrentInstance();
		/* 152: */}

	/* 153: */
	/* 154: */public static Map<String, String> sessionMap()
	/* 155: */{
		/* 156:167 */Map<String, String> map = context().getExternalContext()
		/* 157:168 */.getRequestParameterMap();
		/* 158:169 */return map;
		/* 159: */}

	/* 160: */
	/* 161: */public static String getTipoReporte()
	/* 162: */{
		/* 163:173 */return (String) sessionMap().get("tipoReporte");
		/* 164: */}

	/* 165: */
	/* 166: */static void mostrarMensaje(FacesMessage facesMessage)
	/* 167: */{
		/* 168:177 */mostrarMensaje(facesMessage, null);
		/* 169: */}

	/* 170: */
	/* 171: */public static void mostrarMensaje(String s)
	/* 172: */{
		/* 173:181 */mostrarMensaje(new FacesMessage(s));
		/* 174: */}

	/* 175: */
	/* 176: */public static void mostrarMensajeError(String s)
	/* 177: */{
		/* 179:186 */mostrarMensajeError(new FacesMessage(
				FacesMessage.SEVERITY_ERROR, s,
				/* 180:187 */null));
		/* 181: */}

	/* 182: */
	/* 183: */public static void mostrarMensajeError(FacesMessage m)
	/* 184: */{
		/* 185:191 */mostrarMensaje(m);
		/* 186: */}

	/*     */public static void setDataXLSX(List data, List data2, int fechaInicio,
			int fechaFin, String frecuencia, String grupoMedicion,
			String variable) {
		String[][] matriz = new String[14][fechaFin - fechaInicio + 1];
		/*     */try {

			FileUtils.copyFile(new File(Utiles.getArchivoReporte()), new File(
					Utiles.getArchivoReporteDCD()));
			/* 145 */XSSFWorkbook wb = new XSSFWorkbook(
					Utiles.getArchivoReporteDCD());
			/* 149 */XSSFSheet sheet = wb.getSheetAt(0);
			/*     */
			/* 151 */final XSSFRow cab = sheet.getRow(10);

			XSSFCell reporte = cab.getCell(2);
			String titulo = reporte.getStringCellValue() + " " + frecuencia
					+ ": " + grupoMedicion + " - " + variable;
			reporte.setCellValue(titulo);

			/* 164 */int a�os = fechaFin - fechaInicio;
			/*     */
			/* 166 */int i = 0;
			/*     */

			String a�o = "";
			String decada = "1";
			while (a�os - i > 0) {
				i++;// Bucle filas
				XSSFRow fila = sheet.createRow(12 + i);
				int celdas = 1;
				fila.createCell(0).setCellValue(fechaInicio);
				fila.createCell(1).setCellValue(decada);
				while (celdas <= 14) {
					celdas++;// Bucle columnas
					Cell itC = fila.createCell(celdas);
					int d = 0;
					int m = 1;
					// while (m <= 14) {
					// m++;
					// d = 0;
					// while (d < data.size()) {
					// d++;// Bucle data
					// a�o = data.get(d - 1)[1].toString();//
					// if (((Integer.parseInt(a�o))) == (a�os - i - 1)) {//
					// decada = data.get(d - 1)[4].toString();
					// int decadaIt = 0;
					// while (decadaIt <= 3) {
					// decadaIt++;
					// decada = (decadaIt + 1) + "";
					// if (decada.equals(decadaIt)) {
					// String mes = data.get(i - 1)[0]
					// .toString();
					// if (mes.equals(m)) {
					// fila.createCell(m + 1)
					// .setCellValue(
					// data.get(i - 1)[3]
					// .toString());
					// data.remove(i - 1);
					// }
					// }
					// }
					//
					// } else {
					//
					// }
					// }
					// }
				}
			}
			log.debug(Utiles.getArchivoReporteDCD());
		} catch (Exception e) {
			/* 281 */e.printStackTrace();

			/*     */}

		/*     */}

	private static String getArchivoReporte() {
		return FacesContext.getCurrentInstance().getExternalContext()
				.getRealPath("/ReporteRQ866.xlsx");
	}

	private static String getArchivoReporteDCD() {
		return FacesContext.getCurrentInstance().getExternalContext()
				.getRealPath("/")
				+ "ReporteRQ866DCD.xlsx";
	}

	public static String formatoSql(String sUMATORIA_SQL, String codigo,
			int fechaInicio, int fechaFin, String frecuenciaDiaria,
			String grupoMedicion, String variable) {

		sUMATORIA_SQL = sUMATORIA_SQL.replace(":p_fecha_desde", "'"
				+ fechaInicio + "-01-01'");
		sUMATORIA_SQL = sUMATORIA_SQL.replace(":p_fecha_hasta", "'" + fechaFin
				+ "-12-31'");
		sUMATORIA_SQL = sUMATORIA_SQL.replace(":p_fml_code_frecuencia", "'"
				+ frecuenciaDiaria + "'");
		sUMATORIA_SQL = sUMATORIA_SQL.replace(":p_fml_code_grupo", "'"
				+ grupoMedicion + "'");
		sUMATORIA_SQL = sUMATORIA_SQL.replace(":p_var", "'" + variable + "'");
		sUMATORIA_SQL = sUMATORIA_SQL.replace(":p_estacion", ""
				+ asNumeric(codigo) + "");

		return sUMATORIA_SQL;
	}

	private static String asNumeric(String codigo) {
		// TODO Auto-generated method stub
		return codigo.substring(0, codigo.indexOf("_"));
	}

	public static String httpMethod() {
		return ((HttpServletRequest) context().getExternalContext()
				.getRequest()).getMethod();

	}

	public static boolean httpMethodGet() {
		return httpMethod().equals("GET");
	}

	/* 219: */
	/* 220: */public static <T> T evaluar(String expression)
	/* 221: */{
		/* 222:225 */return (T) context().getApplication()
				.createValueBinding(expression).getValue(context());
		/* 224: */}

	public static String getDS() {
		return (String) sessionMap().get("HIMEDESADEV");
	}

}