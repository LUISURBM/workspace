/*   1:    */package sia.cmmad.bean.util;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.poi.openxml4j.opc.Package;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.jboss.logging.Logger;

import sia.cmmad.bean.InformacionEstacion;

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

	/*     */public static void setDataXLSX(List<Object[]> data, int fechaInicio,
			int fechaFin, String frecuencia, String grupoMedicion,
			String variable) {
		String[][] matriz = new String[14][fechaFin - fechaInicio + 1];

		/*     */try {

			FileUtils.copyFile(new File(Utiles.getArchivoReporte()), new File(
					Utiles.getArchivoReporteDCD()));
			log.debug(Utiles.getArchivoReporteDCD());

			// FileInputStream fis = new FileInputStream(new File(Utiles
			// .getArchivoReporteDCD()));
			Workbook wb = WorkbookFactory.create(new FileInputStream(Utiles
					.getArchivoReporteDCD()));
			// /* 145 */XSSFWorkbook wb = new XSSFWorkbook(
			// Utiles.getArchivoReporteDCD());

			/* 149 */Sheet sheet = wb.getSheetAt(0);

			/*     */
			/* 151 */final Row cab = sheet.getRow(10);

			Cell reporte = cab.getCell(2);
			String titulo = reporte.getStringCellValue() + " " + frecuencia
					+ ": " + grupoMedicion + " - " + variable;
			reporte.setCellValue(titulo);

			/* 164 */int años = fechaFin - fechaInicio;
			/*     */
			/* 166 */int i = 0;
			/*     */
			InformacionEstacion estacion = Utiles.evaluar("#{Estacion}");
			cargarEncabezadoArchivo(sheet, estacion);

			String año = "";
			String decada = "1";

			while (años - i > 0) {
				int decadas = 0;
				i++;// Bucle filas
				while (decadas <= 3) {
					Row fila = sheet.createRow(14 + i + decadas);
					int celdas = 1;
					fila.createCell(0).setCellValue(fechaInicio + i - 1);
					decadas++;
					fila.createCell(1).setCellValue(decadas);
					while (celdas <= 14) {
						celdas++;// Bucle columnas
						Cell itC = fila.createCell(celdas);
						int d = 0;
						int m = 1;
						// while (m <= 14) {
						// m++;
						d = 0;
						while (d < data.size()) {
							d++;// Bucle data
							año = data.get(d - 1)[1].toString();
							if (((Integer.parseInt(año))) == (años - i - 1)) {
								decada = data.get(d - 1)[4].toString();
								if (decada.equals(decadas)) {
									String mes = data.get(i - 1)[0].toString();
									if (mes.equals(celdas + 2)) {
										fila.createCell(celdas + 2)
												.setCellValue(
														data.get(i - 1)[3]
																.toString());
										data.remove(i - 1);
									}
								}

							} else {

							}
						}
						// }
					}
				}
			}

			FileOutputStream fileOut = new FileOutputStream(new File(
					Utiles.getArchivoReporteDCD()));

			wb.write(fileOut);
			fileOut.flush();
			fileOut.close();
			log.debug(Utiles.getArchivoReporteDCD());
		} catch (Exception e) {
			/* 281 */e.printStackTrace();

			/*     */}

		/*     */}

	private static void cargarEncabezadoArchivo(Sheet sheet,
			InformacionEstacion estacion) {
		Cell reporte = sheet.getRow(11).getCell(2);
		reporte.setCellValue(Utiles.asNumeric(estacion.getCodigoEstacion()
				.getValue().toString()));
		reporte = sheet.getRow(11).getCell(5);
		reporte.setCellValue(estacion.getInputelevacion().getValue().toString());
		reporte = sheet.getRow(11).getCell(7);
		reporte.setCellValue(estacion.getInputnombreEstacion().getValue()
				.toString());
		reporte = sheet.getRow(11).getCell(12);
		reporte.setCellValue(estacion.getInputsubzonaHidrografica().getValue()
				.toString());
		reporte = sheet.getRow(12).getCell(2);
		reporte.setCellValue(estacion.getInputlatitud().getValue().toString());
		reporte = sheet.getRow(12).getCell(5);
		reporte.setCellValue(estacion.getInputareaHidrografica().getValue()
				.toString());
		reporte = sheet.getRow(12).getCell(7);
		reporte.setCellValue(estacion.getInputcategoria().getValue().toString());
		reporte = sheet.getRow(12).getCell(10);
		reporte.setCellValue(estacion.getInputdepartamento().getValue()
				.toString());
		reporte = sheet.getRow(12).getCell(13);
		reporte.setCellValue(estacion.getInputareaOperativa().getValue()
				.toString());
		reporte = sheet.getRow(13).getCell(2);
		reporte.setCellValue(estacion.getInputlongitud().getValue().toString());
		reporte = sheet.getRow(13).getCell(5);
		reporte.setCellValue(estacion.getInputzonaHidrografica().getValue()
				.toString());
		reporte = sheet.getRow(13).getCell(7);
		reporte.setCellValue(estacion.getInputentidad().getValue().toString());
		reporte = sheet.getRow(13).getCell(10);
		reporte.setCellValue(estacion.getInputmunicipio().getValue().toString());
		reporte = sheet.getRow(13).getCell(13);
		reporte.setCellValue(estacion.getInputcorriente().getValue().toString());
	}

	private static String getArchivoReporte() {
		return FacesContext.getCurrentInstance().getExternalContext()
				.getRealPath("/ReporteRQ866.xls");
	}

	public static String getArchivoReporteDCD() {
		return FacesContext.getCurrentInstance().getExternalContext()
				.getRealPath("/")
				+ "ReporteRQ866DCD.xls";
	}

	public static String formatoSql(String sUMATORIA_SQL, String codigo,
			int fechaInicio, int fechaFin, String frecuenciaDiaria,
			String grupoMedicion, String variable) {

		sUMATORIA_SQL = sUMATORIA_SQL.replace(":p_fecha_desde", "'"
				+ fechaInicio + "01-01'");
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

	public static byte[] readIntoByteArray(InputStream in) throws IOException {
		byte[] buffer = new byte[4096];
		int bytesRead;
		ByteArrayOutputStream out = new ByteArrayOutputStream();

		while ((bytesRead = in.read(buffer)) != -1) {
			out.write(buffer, 0, bytesRead);
		}
		out.flush();

		return out.toByteArray();
	}

}