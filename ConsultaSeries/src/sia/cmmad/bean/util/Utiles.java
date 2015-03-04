/*   1:    */package sia.cmmad.bean.util;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.ObjectUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.jboss.logging.Logger;

import sia.cmmad.bean.FacadeBean;
import sia.cmmad.bean.InformacionEstacion;

/*  29:    */
/*  30:    */public final class Utiles
/* 31: */{
	private static final String[] encabezadoMAM = { "MES", "MEDIOS", "MAXIMOS",
			"FECHA MAX", "MINIMOS", "FECHA MIN", "Nro. AÑOS" };
	private static final String[] meses = { "ENERO", "FEBRERO", "MARZO",
			"ABRIL", "MAYO", "JUNIO", "JULIO", "AGOSTO", "SEPTIEM", "OCTUBRE",
			"NOVIEM", "DICIEM" };
	private static final long[] diasMes = { 31, 28, 31, 30, 31, 30, 31, 31, 30,
			31, 30, 31 };
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

	/*     */public static void setDataMAM(List<Object[]> data, int fechaInicio,
			int fechaFin, String frecuencia, String grupoMedicion,
			String variable) {
		Workbook wb = Utiles.inicializaArchivo();
		// /* 145 */XSSFWorkbook wb = new XSSFWorkbook(
		// Utiles.getArchivoReporteDCD());

		/* 149 */Sheet sheet = wb.getSheetAt(0);

		/*     */
		/* 151 */Row cab = sheet.getRow(10);

		Cell reporte = cab.getCell(0);
		String titulo = reporte.getStringCellValue() + " " + frecuencia + ": "
				+ grupoMedicion + " - " + nombreVariablesMedicion(variable);
		reporte.setCellValue(titulo);
		cab = sheet.getRow(11);
		reporte = cab.getCell(0);
		titulo = " Fecha proceso: "
				+ GregorianCalendar.getInstance().getTime().toString()
				+ " Periodo: " + fechaInicio + " " + fechaFin;
		reporte.setCellValue(titulo);

		/* 164 */int años = fechaFin - fechaInicio;
		/*     */
		/* 166 */int i = 0;
		/*     */
		InformacionEstacion estacion = Utiles.evaluar("#{Estacion}");
		cargarEncabezadoArchivo(sheet, estacion);
		sheet.removeRow(sheet.getRow(15));
		Row encab = sheet.createRow(15);
		while (i < 7) {
			encab.createCell(i + 4).setCellValue(encabezadoMAM[i]);
			i++;
		}

		i = 0;
		Row fila = null;
		int d = 0;

		DatoLimite dMax = new DatoLimite();
		dMax.setDato(ObjectUtils.toString(0));
		DatoLimite dMin = new DatoLimite();
		dMin.setDato(ObjectUtils.toString(0));
		Long nvalor = 0l;
		String nfecha = "";
		while (i < 12) {
			nvalor = 0l;
			fila = sheet.createRow(16 + i);
			fila.createCell(4).setCellValue(meses[i]);
			int c = 0;
			i++;// Bucle filas
			long medios = 0l;
			// while (c < encabezadoMAM.length) {
			// c++;
			while (d < data.size()) {
				d++;
				String mes = data.get(d - 1)[0].toString();
				if (Integer.parseInt(mes) > i) {
					d = 0;
					break;
				}
				if (Integer.parseInt(mes) == i) {
					nvalor = Long.parseLong(data.get(d - 1)[4].toString());
					nfecha = Long.parseLong(data.get(d - 1)[2].toString())
							+ "-"
							+ Long.parseLong(data.get(d - 1)[0].toString())
							+ "-"
							+ Long.parseLong(data.get(d - 1)[1].toString());
					medios += nvalor;
					fila.createCell(5).setCellValue(medios / diasMes[i - 1]);
					if (nvalor >= dMax.getDatoInt()) {
						dMax.setDato(nvalor.toString());
						dMax.setFecha(nfecha);
						fila.createCell(6).setCellValue(nvalor.toString());
						fila.createCell(7).setCellValue(nfecha);
					}
					if (nvalor <= dMin.getDatoInt()) {
						dMin.setDato(nvalor.toString());
						dMin.setFecha(nfecha);
						fila.createCell(8).setCellValue(nvalor.toString());
						fila.createCell(9).setCellValue(nfecha);
					}
					fila.createCell(10).setCellValue(años);
					data.get(d - 1)[4].toString();
					data.remove(d - 1);
					d = 0;
				}

			}

			// }
		}

		FileOutputStream fileOut = null;
		try {
			fileOut = new FileOutputStream(new File(
					Utiles.getArchivoReporteDCD()));
			wb.write(fileOut);
			fileOut.flush();
			fileOut.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

		}

	}

	/*     */public static void setDataDCD(List<Object[]> data, int fechaInicio,
			int fechaFin, String frecuencia, String grupoMedicion,
			String variable) {
		// String[][] matriz = new String[14][fechaFin - fechaInicio + 1];

		/*     */try {

			// FileInputStream fis = new FileInputStream(new File(Utiles
			// .getArchivoReporteDCD()));
			Workbook wb = Utiles.inicializaArchivo();
			// /* 145 */XSSFWorkbook wb = new XSSFWorkbook(
			// Utiles.getArchivoReporteDCD());

			/* 149 */Sheet sheet = wb.getSheetAt(0);

			/*     */
			/* 151 */Row cab = sheet.getRow(10);

			Cell reporte = cab.getCell(0);
			String titulo = reporte.getStringCellValue() + " " + frecuencia
					+ ": " + grupoMedicion + " - " + variable;
			reporte.setCellValue(titulo);
			cab = sheet.getRow(11);
			reporte = cab.getCell(0);
			titulo = " Fecha proceso: "
					+ GregorianCalendar.getInstance().getTime().toString()
					+ " Periodo: " + fechaInicio + " " + fechaFin;
			reporte.setCellValue(titulo);

			/* 164 */int años = fechaFin - fechaInicio;
			/*     */
			/* 166 */int i = 0;
			/*     */
			InformacionEstacion estacion = Utiles.evaluar("#{Estacion}");
			cargarEncabezadoArchivo(sheet, estacion);

			String año = "";
			String decada = "1";

			while (años - i >= 0) {
				int decadas = 0;
				i++;// Bucle filas
				while (decadas < 3) {
					Row fila = sheet.createRow(16 + ((i - 1) * 3) + decadas);

					if (decadas == 0) {
						fila.createCell(0).setCellValue(fechaInicio + i - 1);
					}
					decadas++;
					fila.createCell(1).setCellValue(decadas);

					int d = 0;
					int m = 1;
					// while (m <= 14) {
					// m++;
					d = 0;
					int celdas = 1;
					long vlAnual = 0l;
					while (d < data.size()) {
						d++;// Bucle data
						año = data.get(d - 1)[1].toString();
						if ((Integer.parseInt(año) > fechaInicio + (i - 1))) {
							break;
						} else if (((Integer.parseInt(año))) == (fechaInicio + (i - 1))) {
							decada = data.get(d - 1)[4].toString();
							if (Integer.parseInt(decada) == (decadas)) {
								String mes = data.get(d - 1)[0].toString();
								while (celdas <= 13) {
									celdas++;// Bucle columnas
									if (Integer.parseInt(mes) == (celdas - 1)) {
										fila.createCell(celdas).setCellValue(
												data.get(d - 1)[3].toString());
										vlAnual += Long.parseLong(data
												.get(d - 1)[3].toString());
										int dividendo = 1;
										if (!Utiles.totales(variable)) {
											dividendo = 12;
										}
										fila.createCell(14).setCellValue(
												vlAnual / dividendo);
										data.remove(d - 1);
										d = 0;
										break;
									} else {
										continue;
									}
								}
							} else {
								break;
							}
						}
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

	private static Workbook inicializaArchivo() {
		Workbook wb = null;
		try {
			FileUtils.copyFile(new File(Utiles.getArchivoReporte()), new File(
					Utiles.getArchivoReporteDCD()));

			wb = WorkbookFactory.create(new FileInputStream(Utiles
					.getArchivoReporteDCD()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return wb;
	}

	private static void cargarEncabezadoArchivo(Sheet sheet,
			InformacionEstacion estacion) {
		Cell reporte = sheet.getRow(12).getCell(2);
		reporte.setCellValue((estacion.getInputcodInternoEstacion().getValue()
				.toString()));
		reporte = sheet.getRow(12).getCell(5);
		reporte.setCellValue(estacion.getInputelevacion().getValue().toString());
		reporte = sheet.getRow(12).getCell(7);
		reporte.setCellValue(estacion.getInputnombreEstacion().getValue()
				.toString());
		reporte = sheet.getRow(12).getCell(12);
		reporte.setCellValue(estacion.getInputsubzonaHidrografica().getValue()
				.toString());
		reporte = sheet.getRow(13).getCell(2);
		reporte.setCellValue(estacion.getInputlatitud().getValue().toString());
		reporte = sheet.getRow(13).getCell(5);
		reporte.setCellValue(estacion.getInputareaHidrografica().getValue()
				.toString());
		reporte = sheet.getRow(13).getCell(7);
		reporte.setCellValue(estacion.getInputcategoria().getValue().toString());
		reporte = sheet.getRow(13).getCell(10);
		reporte.setCellValue(estacion.getInputdepartamento().getValue()
				.toString());
		reporte = sheet.getRow(13).getCell(13);
		reporte.setCellValue(estacion.getInputareaOperativa().getValue()
				.toString());
		reporte = sheet.getRow(14).getCell(2);
		reporte.setCellValue(estacion.getInputlongitud().getValue().toString());
		reporte = sheet.getRow(14).getCell(5);
		reporte.setCellValue(estacion.getInputzonaHidrografica().getValue()
				.toString());
		reporte = sheet.getRow(14).getCell(7);
		reporte.setCellValue(estacion.getInputentidad().getValue().toString());
		reporte = sheet.getRow(14).getCell(10);
		reporte.setCellValue(estacion.getInputmunicipio().getValue().toString());
		reporte = sheet.getRow(14).getCell(13);
		reporte.setCellValue(estacion.getInputcorriente().getValue().toString());
	}

	private static String getArchivoReporte() {
		return FacesContext.getCurrentInstance().getExternalContext()
				.getRealPath("/ReporteRQ866.xls");
	}

	public static String getArchivoReporteDCD() {
		return FacesContext.getCurrentInstance().getExternalContext()
				.getRealPath("/")
				+ "ReporteRQ866.new.xls";
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

		if (Utiles.totales(variable)) {

		} else {
			sUMATORIA_SQL = sUMATORIA_SQL.replace("sum(", "avg(");
		}

		return sUMATORIA_SQL;
	}

	private static boolean totales(String variable) {
		variable = nombreVariablesMedicion(variable);
		if (variable.toLowerCase().contains("precipita")
				|| variable.toLowerCase().contains("evaporaci")
				|| (variable.toLowerCase().contains("brillo") && variable
						.toLowerCase().contains("solar"))) {
			return true;
		}
		return false;
	}

	private static String nombreVariablesMedicion(String varMedicion) {
		FacadeBean beanFachada = evaluar("#{BeanFachada}");
		for (SelectItem item : beanFachada.getVariables()) {
			if (item.getValue().equals(varMedicion)) {
				return item.getLabel();
			}
		}
		return "";
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