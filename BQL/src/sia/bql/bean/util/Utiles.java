/*   1:    */package sia.bql.bean.util;

/*   2:    */
/*   3:    */import common.Logger;
/*   4:    */
import java.text.DateFormat;
import java.text.DecimalFormat;
/*   5:    */
import java.text.SimpleDateFormat;
/*   6:    */
import java.util.ArrayList;
/*   7:    */
import java.util.Calendar;
/*   8:    */
import java.util.Date;
/*   9:    */
import java.util.GregorianCalendar;
/*  10:    */
import java.util.List;
/*  11:    */
import java.util.Locale;
/*  12:    */
import java.util.Map;
/*  13:    */
import java.util.TimeZone;
/*  14:    */
import javax.faces.application.Application;
/*  15:    */
import javax.faces.application.FacesMessage;
/*  16:    */
import javax.faces.application.FacesMessage.Severity;
/*  17:    */
import javax.faces.component.UIInput;
/*  18:    */
import javax.faces.context.ExternalContext;
/*  19:    */
import javax.faces.context.FacesContext;
/*  20:    */
import javax.faces.el.ValueBinding;
/*  21:    */
import javax.faces.model.SelectItem;
/*  22:    */
import javax.faces.validator.ValidatorException;
/*  23:    */
import javax.servlet.http.HttpSession;
/*  24:    */
import org.apache.commons.lang.math.NumberUtils;
/*  25:    */
import sia.bql.bean.FacadeBean;
/*  26:    */
import sia.bql.hibernate.list.Fecha;
/*  27:    */
import sia.bql.i18n.NombresTitulosAplicacion;
/*  28:    */
import sia.bql.persistencia.BDOperacion;

/*  29:    */
/*  30:    */public final class Utiles
/* 31: */{
	/* 32: 47 */private static final Logger log = Logger
			.getLogger(Utiles.class);
	private static final DecimalFormat df = new DecimalFormat("#.###");
	/* 33: 48 */private static SimpleDateFormat formatoAño = new SimpleDateFormat(
			"yyyy");
	/* 34: 49 */public static final transient String[] HORAS_DEL_DIA = {
	/* 35: 50 */String.valueOf("00 ~ 05"), String.valueOf("01 ~ 06"),
	/* 36: 51 */String.valueOf("02 ~ 07"), String.valueOf("03 ~ 08"),
	/* 37: 52 */String.valueOf("04 ~ 09"), String.valueOf("05 ~ 10"),
	/* 38: 53 */String.valueOf("06 ~ 11"), String.valueOf("07 ~ 12"),
	/* 39: 54 */String.valueOf("08 ~ 13"), String.valueOf("09 ~ 14"),
	/* 40: 55 */String.valueOf("10 ~ 15"), String.valueOf("11 ~ 16"),
	/* 41: 56 */String.valueOf("12 ~ 17"), String.valueOf("13 ~ 18"),
	/* 42: 57 */String.valueOf("14 ~ 19"), String.valueOf("15 ~ 20"),
	/* 43: 58 */String.valueOf("16 ~ 21"), String.valueOf("17 ~ 22"),
	/* 44: 59 */String.valueOf("18 ~ 23"), String.valueOf("19 ~ 00"),
	/* 45: 60 */String.valueOf("20 ~ 01"), String.valueOf("21 ~ 02"),
	/* 46: 61 */String.valueOf("22 ~ 03"), String.valueOf("23 ~ 04") };

	/* 47: */
	/* 48: */public static final Object[] getAños()
	/* 49: */{
		/* 50: 64 */Calendar calenda = GregorianCalendar.getInstance();
		/* 51: 65 */ArrayList<String> años = new ArrayList();
		/* 52: 66 */for (int i = 0; i < 100; i++) {
			/* 53: 67 */años.add(String.valueOf(calenda.get(1) - i));
			/* 54: */}
		/* 55: 69 */return años.toArray();
		/* 56: */}

	/* 57: */
	/* 58: */public static int getNumDiasdelMes(int mes, int ano)
	/* 59: */{
		/* 60: 73 */int[] diasMes = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31,
				30, 31 };
		/* 61: 75 */if (((ano % 4 == 0) && (ano % 100 != 0))
				|| (ano % 400 == 0)) {
			/* 62: 76 */diasMes[1] = 29;
			/* 63: */}
		/* 64: 77 */return diasMes[mes];
		/* 65: */}

	/* 66: */
	/* 67: */public static List<Integer> getDiasdelMes(int mes, int ano)
	/* 68: */{
		/* 69: 81 */List<Integer> dias = new ArrayList();
		/* 70: 82 */for (int d = 1; d <= getNumDiasdelMes(mes - 1, ano); d++) {
			/* 71: 83 */dias.add(Integer.valueOf(d));
			/* 72: */}
		/* 73: 85 */return dias;
		/* 74: */}

	/* 75: */
	/* 76: */public List<SelectItem> getMeses()
	/* 77: */throws Throwable
	/* 78: */{
		/* 79: 89 */List<SelectItem> lista = new ArrayList();
		/* 80: */
		/* 81: */
		/* 82: 92 */lista.add(new SelectItem(NumberUtils.LONG_ZERO, "Enero"));
		/* 83: 93 */lista.add(new SelectItem(NumberUtils.LONG_ONE, "Febrero"));
		/* 84: 94 */lista.add(new SelectItem(new Long(2L), "Marzo"));
		/* 85: 95 */lista.add(new SelectItem(new Long(3L), "Abril"));
		/* 86: 96 */lista.add(new SelectItem(new Long(4L), "Mayo"));
		/* 87: 97 */lista.add(new SelectItem(new Long(5L), "Junio"));
		/* 88: 98 */lista.add(new SelectItem(new Long(6L), "Julio"));
		/* 89: 99 */lista.add(new SelectItem(new Long(7L), "Agosto"));
		/* 90:100 */lista.add(new SelectItem(new Long(8L), "Septiembre"));
		/* 91:101 */lista.add(new SelectItem(new Long(9L), "Octubre"));
		/* 92:102 */lista.add(new SelectItem(new Long(10L), "Noviembre"));
		/* 93:103 */lista.add(new SelectItem(new Long(11L), "Diciembre"));
		/* 94:104 */return lista;
		/* 95: */}

	/* 96: */
	/* 97: */public static String nombMes(int numMes)
	/* 98: */{
		/* 99:114 */return
		/* 100: */
		/* 101: */
		/* 102: */
		/* 103: */
		/* 104: */
		/* 105: */
		/* 106: */
		/* 107: */
		/* 108: */
		/* 109: */
		/* 110:125 */numMes == 11 ? "Diciembre"
				: numMes == 10 ? "Noviembre"
						: numMes == 9 ? "Octubre"
								: numMes == 8 ? "Septiembre"
										: numMes == 7 ? "Agosto"
												: numMes == 6 ? "Julio"
														: numMes == 5 ? "Junio"
																: numMes == 4 ? "Mayo"
																		: numMes == 3 ? "Abril"
																				: numMes == 2 ? "Marzo"
																						: numMes == 1 ? "Febrero"
																								: numMes == 0 ? "Enero"
																										:
																										/*
																										 * 111
																										 * :
																										 * 126
																										 */"";
		/* 112: */}

	/* 113: */
	/* 114:129 */private static final Double CERO = Double.valueOf(0.0D);

	/* 115: */
	/* 116: */public static Double asDouble(Number n)
	/* 117: */{
		/* 118:135 */return n == null ? null : Double.valueOf(n.doubleValue());
		/* 119: */}

	/* 120: */
	/* 121: */public static Long asLong(String valor)
	/* 122: */{
		/* 123: */try
		/* 124: */{
			/* 125:140 */return Long.valueOf(valor);
			/* 126: */}
		/* 127: */catch (Exception localException) {
		}
		/* 128:143 */return Long.valueOf(0L);
		/* 129: */}

	/* 130: */
	/* 131: */public static Integer asInteger(Number n)
	/* 132: */{
		/* 133:147 */return n == null ? null : Integer.valueOf(n.intValue());
		/* 134: */}

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
		/* 144:156 */log.debug("clientId: " + clientId + " mensaje: " + (
		/* 145:157 */facesMessage != null ? facesMessage.getSummary() : ""));
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
	/* 161: */public static String getUsuario()
	/* 162: */{
		/* 163:173 */return (String) sessionMap().get("usuario");
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
		/* 178:185 */log.error("Mensaje de error: " + s);
		/* 179:186 */mostrarMensajeError(new FacesMessage(
				FacesMessage.SEVERITY_ERROR, s,
				/* 180:187 */null));
		/* 181: */}

	/* 182: */
	/* 183: */public static void mostrarMensajeError(FacesMessage m)
	/* 184: */{
		/* 185:191 */mostrarMensaje(m);
		/* 186: */}

	/* 187: */
	/* 188: */public static ValidatorException nuevaExcepcion(String mensaje,
			FacesMessage.Severity severidad)
	/* 189: */{
		/* 190:197 */return new ValidatorException(
		/* 191:198 */new FacesMessage(severidad, mensaje, null));
		/* 192: */}

	/* 193: */
	/* 194: */public static ValidatorException nuevaExcepcionValidacion(
			String mensaje)
	/* 195: */{
		/* 196:203 */return nuevaExcepcion(mensaje, FacesMessage.SEVERITY_ERROR);
		/* 197: */}

	/* 198: */
	/* 199: */public static void limpiarEstadoCamposEntrada(UIInput... inputs)
	/* 200: */{
		/* 201:207 */UIInput[] arrayOfUIInput = inputs;
		int j = inputs.length;
		/* 202:207 */for (int i = 0; i < j; i++)
		/* 203: */{
			/* 204:207 */UIInput in = arrayOfUIInput[i];
			/* 205:208 */if (in != null)
			/* 206: */{
				/* 207:210 */in.setSubmittedValue(null);
				/* 208:211 */in.getChildren().clear();
				/* 209:212 */in.setValue(null);
				/* 210:213 */in.setLocalValueSet(false);
				/* 211: */}
			/* 212: */}
		/* 213: */}

	/* 214: */
	/* 215: */public static Locale getLocaleContexto()
	/* 216: */{
		/* 217:220 */return context().getApplication().getDefaultLocale();
		/* 218: */}

	/* 219: */
	/* 220: */public static <T> T evaluar(String expression)
	/* 221: */{
		/* 222:225 */return (T) context().getApplication()
				.createValueBinding(expression).getValue(context());
		/* 224: */}

	/* 225: */
	/* 226: */public static String UTC(Date hlc)
	/* 227: */{
		/* 228:230 */return
		/* 229: */
		/* 230: */
		/* 231:233 */(hlc.getHours() < 10 ? "0" + hlc.getHours() : Integer
				.valueOf(hlc.getHours()))
				+ ":"
				+ (hlc.getMinutes() < 10 ? "0" + hlc.getMinutes() :
				/* 232:234 */Integer.valueOf(hlc.getMinutes()));
		/* 233: */}

	/* 234: */
	/* 235: */public static String formatoFecha(Date date)
	/* 236: */{
		/* 237:238 */return DateFormat.getDateInstance(3).format(date);
		/* 238: */}

	/* 239: */
	/* 240: */public static String getHoraPredeterminada()
	/* 241: */{
		/* 242:242 */int h = Calendar.getInstance(TimeZone.getDefault()).get(
		/* 243:243 */11);
		/* 244:244 */String hora = dosDigitos(h) + "~";
		/* 245:245 */h = h < 19 ? h + 5 : h - 19;
		/* 246:246 */hora = hora + dosDigitos(h);
		/* 247:247 */return hora;
		/* 248: */}

	/* 249: */
	/* 250: */public static Long dosDigitos(String valor)
	/* 251: */{
		/* 252:251 */return Long.valueOf(valor.substring(0, 2));
		/* 253: */}

	public static String dosDigitos(Double valor)
	/* 251: */{
		/* 252:251 */return valor.intValue()+""
//				toString().substring(0,
//				valor.toString().charAt('.') + 4)
				;

		/* 253: */}

	/* 254: */
	/* 255: */public static String dosDigitos(int valor)
	/* 256: */{
		/* 257:255 */return valor < 10 ? "0" + valor : String.valueOf(valor);
		/* 258: */}

	/* 259: */
	/* 260: */public static Date getFechaPredeterminada()
	/* 261: */{
		/* 262:259 */return Calendar.getInstance(TimeZone.getDefault())
				.getTime();
		/* 263: */}

	/* 264: */
	/* 265: */public static Boolean equals(Object n, Object o)
	/* 266: */{
		/* 267:263 */return Boolean.valueOf(n.equals(o));
		/* 268: */}

	/* 269: */
	/* 270: */public static Long code(String selected)
	/* 271: */{
		/* 272: */try
		/* 273: */{
			/* 274:268 */return
			/* 275:269 */Long.valueOf(selected.substring(0,
					selected.indexOf("~") - 1));
			/* 276: */}
		/* 277: */catch (Exception e) {
		}
		/* 278:271 */return null;
		/* 279: */}

	/* 280: */
	/* 281: */public static Date formatoFechaSnp(Date fecha)
	/* 282: */{
		/* 283:277 */return new Date(fecha.getYear(), fecha.getMonth(),
				fecha.getDate());
		/* 284: */}

	/* 285: */
	/* 286: */private static String MSLF_CODE_ECHAM(String echam)
	/* 287: */{
		/* 288:281 */return echam.substring(0, echam.length() - 1) + "%";
		/* 289: */}

	/* 290: */
	/* 291: */public static String sqlNombreSiovEstacion(String idEstacion)
	/* 292: */{
		/* 293:285 */return "SELECT NOMBRE_ES FROM siov_estaciones where cod_catalogo_es like'%?%'"
				.replace("?", idEstacion);
		/* 294: */}

	/* 295: */
	/* 296: */public static String sqlEstacionIdSiovEstacion(String idEstacion)
	/* 297: */{
		/* 298:289 */return
		/* 299:290 */"SELECT ESTACION_ID FROM sio_estaciones where codIGO_catalogo like'%?%'"
				.replace("?", idEstacion);
		/* 300: */}

	/* 301: */
	/* 302: */public static Long asLongAño(Date dateCellValue)
	/* 303: */{
		/* 304:294 */return Long.valueOf(formatoAño.format(dateCellValue));
		/* 305: */}

	/* 306: */
	/* 307: */public static Long asLong(double numericCellValue)
	/* 308: */{
		/* 309:298 */return Long.valueOf(Long.parseLong(String
				.valueOf(numericCellValue)));
		/* 310: */}

	/* 311: */
	/* 312: */public static String sqlMaxGrupo(String nuevoAreaOperativa,
			String nuevoCuenca)
	/* 313: */{
		/* 314:303 */return
		/* 315:304 */"SELECT MAX(GRBC_ID) FROM shmt_grupo_balance_caudal  WHERE GRBC_AOP_ID = '?1' AND GRBC_CUENCA_ID = '?2'"
				.replace("?1", nuevoAreaOperativa).replace("?2", nuevoCuenca);
		/* 316: */}

	/* 317: */
	/* 318: */public static boolean validarParametro(String areaOperativa)
	/* 319: */{
		/* 320:308 */if (areaOperativa == null) {
			/* 321:309 */return false;
			/* 322: */}
		/* 323:311 */if (areaOperativa.equals("0")) {
			/* 324:312 */return false;
			/* 325: */}
		/* 326:314 */if (areaOperativa.equals("---")) {
			/* 327:315 */return false;
			/* 328: */}
		/* 329:318 */if (areaOperativa.equals("")) {
			/* 330:319 */return false;
			/* 331: */}
		/* 332:322 */return true;
		/* 333: */}

	/* 334: */
	/* 335: */public static Date añoAnterior()
	/* 336: */{
		/* 337:326 */Date time = GregorianCalendar.getInstance().getTime();
		/* 338:327 */time.setYear(time.getYear() - 1);
		/* 339:328 */return time;
		/* 340: */}

	/* 341: */
	/* 342: */public static String obtenerVariableCaudal()
	/* 343: */{
		/* 344:332 */return
		/* 345:333 */BDOperacion
				.obtenerVariable(NombresTitulosAplicacion.CAUDAL.nombreTitulo);
		/* 346: */}

	/* 347: */
	/* 348: */public static String obtenerVariablePrecipitacion()
	/* 349: */{
		/* 350:337 */return
		/* 351:338 */BDOperacion
				.obtenerVariable(NombresTitulosAplicacion.PRECIPITACION.nombreTitulo);
		/* 352: */}

	/* 353: */
	/* 354: */public static Date getFechaInicio()
	/* 355: */{
		/* 356:342 */FacadeBean bf = (FacadeBean) evaluar("#{BeanFachada}");
		/* 357:343 */Date fIni = bf.getSelectedDate1();
		/* 358:344 */fIni.setDate(1);
		/* 359:345 */return fIni;
		/* 360: */}

	/* 361: */
	/* 362: */public static Date getFechaFin()
	/* 363: */{
		/* 364:349 */FacadeBean bf = (FacadeBean) evaluar("#{BeanFachada}");
		/* 365:350 */Date fFin = bf.getSelectedDate2();
		/* 366:351 */Date fIni = bf.getSelectedDate1();
		/* 367:352 */fIni.setDate(1);
		/* 368:353 */fFin.setYear(fIni.getYear());
		/* 369:355 */if (bf.getPeriocidad().equals(
				NombresTitulosAplicacion.MENSUAL.nombreTitulo))
		/* 370: */{
			/* 371:356 */fFin.setMonth(fIni.getMonth());
			/* 372:357 */fFin.setDate(getNumDiasdelMes(fIni.getMonth(),
					fIni.getYear()));
			/* 373: */}
		/* 374: */else
		/* 375: */{
			/* 376:359 */fFin.setMonth(11);
			/* 377:360 */fFin.setDate(31);
			/* 378: */}
		/* 379:362 */return fFin;
		/* 380: */}

	/* 381: */
	/* 382: */public static int getMesesBalance()
	/* 383: */{
		/* 384:366 */FacadeBean bf = (FacadeBean) evaluar("#{BeanFachada}");
		/* 385:368 */if (bf.getPeriocidad().equals(
				NombresTitulosAplicacion.MENSUAL.nombreTitulo)) {
			/* 386:369 */return 1;
			/* 387: */}
		/* 388:371 */return 12;
		/* 389: */}

	/* 390: */
	/* 391: */public static int getMesBalance()
	/* 392: */{
		/* 393:376 */Date dI = getFechaInicio();
		/* 394:377 */return dI.getMonth();
		/* 395: */}

	/* 396: */
	/* 397: */public static int getAñoBalance()
	/* 398: */{
		/* 399:381 */Date dI = getFechaInicio();
		/* 400:382 */return dI.getYear() + 1900;
		/* 401: */}

	/* 402: */
	/* 403: */public static List<Fecha> getDiasBalance()
	/* 404: */{
		/* 405:386 */List<Fecha> dias = new ArrayList();
		/* 406:387 */int p = 0;
		/* 407:388 */int m = getMesesBalance() > 1 ? 0 : getMesBalance();
		/* 408: */do
		/* 409: */{
			/* 410:390 */for (int d = 1; d <= getNumDiasdelMes(m,
					getAñoBalance()); d++)
			/* 411: */{
				/* 412:391 */dias.add(new Fecha(d + " / " + nombMes(m), p));
				/* 413:392 */p++;
				/* 414: */}
			/* 415:394 */m++;
			/* 416:389 */} while (
		/* 417: */
		/* 418: */
		/* 419: */
		/* 420: */
		/* 421: */
		/* 422:395 */m < getMesesBalance());
		/* 423:396 */return dias;
		/* 424: */}

	/* 425: */
	/* 426: */public static int getDiasHastaFecha(int year, int mes, int dia)
	/* 427: */{
		/* 428:400 */int toReturn = 1;
		/* 429:401 */for (int m = 0; m < 12; m++) {
			/* 430:402 */for (int d = 0; d < getNumDiasdelMes(m, year); d++)
			/* 431: */{
				/* 432:403 */if ((m == mes) && (dia == d)) {
					/* 433:404 */return toReturn;
					/* 434: */}
				/* 435:406 */toReturn++;
				/* 436: */}
			/* 437: */}
		/* 438:409 */return 0;
		/* 439: */}

	/* 440: */
	/* 441: */public static boolean isPeriocidadAnual()
	/* 442: */{
		/* 443:413 */return getMesesBalance() != 1;
		/* 444: */}
	/* 445: */
}

/*
 * Location: C:\Users\Luis\Desktop\CLXX\BalanceQL\Fuentes\
 * 
 * Qualified Name: sia.bql.bean.util.Utiles
 * 
 * JD-Core Version: 0.7.0.1
 */