/*    1:     */package sia.bql.bean;

/*    2:     */
/*    3:     */import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.component.html.HtmlPanelGrid;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.ObjectUtils;
import org.icefaces.ace.component.autocompleteentry.AutoCompleteEntry;
import org.icefaces.ace.component.chart.Axis;
import org.icefaces.ace.component.chart.AxisType;
import org.icefaces.ace.component.dialog.Dialog;
import org.icefaces.ace.component.fileentry.FileEntry;
import org.icefaces.ace.component.fileentry.FileEntryEvent;
import org.icefaces.ace.component.fileentry.FileEntryResults;
import org.icefaces.ace.event.TextChangeEvent;
import org.icefaces.ace.model.chart.CartesianSeries;
import org.icefaces.ace.model.chart.DragConstraintAxis;
import org.icefaces.ace.model.chart.LineCap;
import org.icefaces.ace.model.chart.LineJoin;
import org.icefaces.ace.model.chart.LinePattern;

import sia.bql.bean.util.Archivo;
import sia.bql.bean.util.Utiles;
import sia.bql.ftp.BartTransfer;
import sia.bql.hibernate.HibernateSessionFactory;
import sia.bql.hibernate.hidromet.HmstPath;
import sia.bql.hibernate.hidromet.ShmtDiarios;
import sia.bql.hibernate.hidromet.ShmtEstacionBalanceQl;
import sia.bql.hibernate.hidromet.ShmtGrupoBalanceCaudal;
import sia.bql.hibernate.hidromet.ZonificacionHidrografica;
import sia.bql.hibernate.list.Fecha;
import sia.bql.hibernate.list.ListShmtEstacion;
import sia.bql.hibernate.list.ListTicks;
import sia.bql.hibernate.list.ShmtEstacionesList;
import sia.bql.hibernate.sioperan.SioCuencasHidrograficas;
import sia.bql.hibernate.sioperan.SioOrganizacion;
import sia.bql.hibernate.sioperan.SiovEstacionesId;
import sia.bql.i18n.NombresMensajesAplicacion;
import sia.bql.i18n.NombresTitulosAplicacion;

import common.Logger;

/*    4:     */
/*    5:     */
/*    6:     */
/*    7:     */
/*    8:     */
/*    9:     */
/*   10:     */
/*   11:     */
/*   12:     */
/*   13:     */
/*   14:     */
/*   15:     */
/*   16:     */
/*   17:     */
/*   18:     */
/*   19:     */
/*   20:     */
/*   21:     */
/*   22:     */
/*   23:     */
/*   24:     */
/*   25:     */
/*   26:     */
/*   27:     */
/*   28:     */
/*   29:     */
/*   30:     */
/*   31:     */
/*   32:     */
/*   33:     */
/*   34:     */
/*   35:     */
/*   36:     */
/*   37:     */
/*   38:     */
/*   39:     */
/*   40:     */
/*   41:     */
/*   42:     */
/*   43:     */
/*   44:     */
/*   45:     */
/*   46:     */
/*   47:     */
/*   48:     */
/*   49:     */
/*   50:     */
/*   51:     */
/*   52:     */
/*   53:     */
/*   54:     */
/*   55:     */
/*   56:     */
/*   57:     */
/*   58:     */
/*   59:     */
/*   60:     */
/*   61:     */

/*   62:     */
/*   63:     */@ManagedBean
/* 64: */@SessionScoped
/* 65: */public class FacadeBean
/* 66: */implements Serializable
/* 67: */{
	/* 68: */private static final long serialVersionUID = 1L;
	/* 69: 81 */private static Logger log = Logger.getLogger(FacadeBean.class);
	/* 70: 82 */private static String[] severityNames = { "Info", "Warn",
			"Error", "Fatal" };
	/* 71: 83 */private static String[] extensionsNames = { "JPEG", "JPG",
			"PNG", "BMP" };
	/* 72: 84 */private boolean visibleNuevo = false;
	/* 73: 85 */private boolean visibleEliminar = false;
	/* 74: */private String usuario;
	/* 75: */private String estado;
	/* 76: */private boolean balance;
	/* 77: */private boolean grupos;
	/* 78: 91 */private ListShmtEstacion estacionesBalanceCaudal = null;
	/* 79: 92 */private ShmtEstacionesList estacionesBalanceCaudalList = null;
	/* 80: */private List<ShmtGrupoBalanceCaudal> itemsGruposBalanceCaudal;
	/* 81: */private List<SelectItem> itemsEstaciones;
	/* 82: */private List<ShmtEstacionBalanceQl> itemsEstacionesVariable;
	/* 83: */private List<SelectItem> itemsEstacionesEnGrupo;
	/* 84: */private ListShmtEstacion itemsEstacionesEnGrupoVariable;
	/* 85: */private List<SelectItem> itemsEstacionesGruposBalanceNuevo;
	/* 86: */private List<SelectItem> itemsGruposBalanceAreaCuenca;
	/* 87: */private List<SelectItem> itemsAreaHidrografica;
	/* 88: */private List<SelectItem> itemsZonaHidrografica;
	/* 89: */private List<SelectItem> itemsSbZonaHidrografica;
	/* 90: 103 */private String cuenca = "";
	/* 91: 104 */private String grupo = "";
	/* 92: 105 */private String año = "";
	private Axis axisCdl = null;
	private Axis axisPpp = null;
	/* 93: */private transient AutoCompleteEntry areaOperativa;
	/* 94: */private HtmlPanelGrid datosEstacion;
	/* 95: */private AutoCompleteEntry entryCuenca;
	/* 96: */private AutoCompleteEntry entryGrupo;
	/* 97: */private Dialog chartDialog;
	/* 98: */private String selectedAreaOperativa;
	/* 99: */private String selectedGrupo;
	/* 98: */private String numberModify;
	/* 100: */private String selectedGrupoBorrado;
	/* 101: */private String selectedGrupoNuevaEstacion;
	/* 102: */private transient String selectedAreaHidrografica;
	/* 103: */private String selectedZonaHidrografica;
	/* 104: */private String selectedSbZonaHidrografica;
	/* 105: */private String selectedEstacion;
	/* 106: */private String mensajePupop;
	/* 107: */private Set<Object> itemsEstacionesEnGruposBalanceAreaBorrado;
	/* 108: */private Set<Object> itemsGruposBalanceAreaBorrado;
	/* 109: */private Set<Object> itemsEstacionesGruposBalanceAreaNuevo;
	/* 110: */private Set<Object> itemsEstacionesGrupoNuevo;
	/* 111: 125 */private String nuevoFormulario = "";
	/* 112: 126 */private String nuevoAreaOperativa = "";
	/* 113: 127 */private String nuevoCuenca = "";
	/* 114: 128 */private String nuevoGrupo = "";
	/* 115: 129 */private String nuevoEstacion = "";
	/* 116: 130 */private Archivo nuevoGrafo = null;
	/* 117: 131 */private String nuevoObs = "";
	/* 118: 132 */private String nuevoPesoConjunto = "";
	/* 119: 133 */private String nuevoPesoIndividual = "";
	/* 120: 134 */private int nuevoPeso = 50;
	/* 121: 135 */private String nuevoDistancia = "";
	/* 122: 136 */private String nuevoVariable = NombresTitulosAplicacion.NIVEL.nombreTitulo;
	/* 123: 137 */private String periocidad = NombresTitulosAplicacion.ANUAL.nombreTitulo;
	/* 124: 138 */private boolean grupoNuevo = true;
	/* 125: 139 */private String nuevo = NombresTitulosAplicacion.IMAGEN_NUEVA_ESTACION.nombreTitulo;
	/* 126: 140 */private boolean visibleTabla = false;
	/* 127: 141 */private boolean visibleTablaBalance = false;
	/* 128: 142 */private boolean visiblePupOpEstacion = false;
	/* 129: 143 */private boolean validaAreaHidrografica = false;
	/* 130: 144 */private boolean validaZonaHidrografica = false;
	/* 131: 145 */private boolean validaSbZonaHidrografica = false;
	/* 132: 146 */private boolean validaGrupoNuevo = false;
	/* 133: */private Date selectedDate1;
	/* 134: */private Date selectedDate2;
	/* 135: 149 */private final String[] colorSet = { "#FAEBD7",
	/* 136: 150 */"#00FFFF", "#7FFFD4", "#F0FFFF", "#F5F5DC", "#FFE4C4",
	/* 137: 151 */"#FFEBCD", "#0000FF", "#8A2BE2", "#A52A2A", "#DEB887",
			"#5F9EA0",
			/* 138: 152 */"#7FFF00", "#D2691E", "#FF7F50", "#6495ED",
			"#FFF8DC", "#DC143C",
			/* 139: 153 */"#00FFFF", "#00008B", "#008B8B", "#B8860B",
			"#A9A9A9", "#006400",
			/* 140: 154 */"#BDB76B", "#8B008B", "#556B2F", "#FF8C00",
			"#9932CC", "#8B0000",
			/* 141: 155 */"#E9967A", "#8FBC8F", "#483D8B", "#2F4F4F",
			"#00CED1", "#9400D3",
			/* 142: 156 */"#FF1493", "#00BFFF", "#696969", "#1E90FF",
			"#B22222", "#FFFAF0",
			/* 143: 157 */"#228B22", "#FF00FF", "#DCDCDC", "#F8F8FF",
			"#FFD700", "#DAA520",
			/* 144: 158 */"#808080", "#008000", "#ADFF2F", "#F0FFF0",
			"#FF69B4", "#CD5C5C",
			/* 145: 159 */"#4B0082", "#FFFFF0", "#F0E68C", "#E6E6FA",
			"#FFF0F5", "#7CFC00",
			/* 146: 160 */"#FFFACD", "#ADD8E6", "#F08080", "#E0FFFF",
			"#FAFAD2", "#90EE90",
			/* 147: 161 */"#D3D3D3", "#FFB6C1", "#FFA07A", "#20B2AA",
			"#87CEFA", "#778899",
			/* 148: 162 */"#B0C4DE", "#FFFFE0", "#00FF00", "#32CD32",
			"#FAF0E6", "#FF00FF",
			/* 149: 163 */"#800000", "#66CDAA", "#0000CD", "#BA55D3",
			"#9370DB", "#3CB371",
			/* 150: 164 */"#7B68EE", "#00FA9A", "#48D1CC", "#C71585",
			"#191970", "#F5FFFA",
			/* 151: 165 */"#FFE4E1", "#FFE4B5", "#FFDEAD", "#000080",
			"#FDF5E6", "#808000",
			/* 152: 166 */"#6B8E23", "#FFA500", "#FF4500", "#DA70D6",
			"#EEE8AA", "#98FB98",
			/* 153: 167 */"#AFEEEE", "#DB7093", "#FFEFD5", "#FFDAB9",
			"#CD853F", "#FFC0CB",
			/* 154: 168 */"#DDA0DD", "#B0E0E6", "#800080", "#FF0000",
			"#BC8F8F", "#4169E1",
			/* 155: 169 */"#8B4513", "#FA8072", "#FAA460", "#2E8B57",
			"#FFF5EE", "#A0522D",
			/* 156: 170 */"#C0C0C0", "#87CEEB", "#6A5ACD", "#708090",
			"#FFFAFA", "#00FF7F",
			/* 157: 171 */"#4682B4", "#D2B48C", "#008080", "#D8BFD8",
			"#FF6347", "#40E0D0",
			/* 158: 172 */"#EE82EE", "#F5DEB3", "#FFFFFF", "#F5F5F5",
			"#FFFF00", "#9ACD32" };
	/* 159: 174 */private List<CartesianSeries> barData = null;
	/* 160: 176 */private Axis barDemoDefaultAxis = null;
	/* 161: 183 */private Axis barDemoXOneAxis = null;
	/* 162: 190 */private Axis[] barDemoYAxes = null;
	/* 163: 192 */private Axis barDemoXTwoAxis = null;
	/* 164: */private transient Dialog clientDialog;
	/* 165: 194 */private List<Fecha> dias = null;
	/* 166: */protected Double[][] mapaValoresDiariosEnEstacionDiaCaudal;
	/* 167: */protected Double[][] mapaValoresDiariosEnEstacionDiaPrecipitacion;
	/* 168: */private List<ShmtEstacionBalanceQl> estacionesNvl;
	/* 169: */private List<ShmtEstacionBalanceQl> estacionesPm;
	/* 170: 199 */private static double MAX_PM = 0.0D;
	/* 171: 200 */private static double MAX_CDL = 0.0D;
	private static String BACK = "http://OASDESA.IDEAM.GOV.CO:7780/MenuSia";
	/* 172: 201 */private boolean zoom = false;
	/* 173: */private List<SelectItem> itemsAreaOpera;

	/* 174: */
	/* 175: */public FacadeBean()
	/* 176: */{
		/* 177: 205 */this.cuenca = "";
		/* 178: 206 */this.estacionesBalanceCaudal = new ListShmtEstacion();
		/* 179: 207 */this.estacionesBalanceCaudalList = new ShmtEstacionesList();
		/* 180: 208 */this.itemsAreaHidrografica = new ArrayList();
		/* 181: 209 */this.itemsEstaciones = new ArrayList();
		/* 182: 210 */this.itemsEstacionesEnGruposBalanceAreaBorrado = null;
		/* 183: 211 */this.itemsEstacionesGrupoNuevo = null;
		this.itemsGruposBalanceCaudal = new ArrayList<ShmtGrupoBalanceCaudal>();
		/* 184: 212 */this.itemsEstacionesGruposBalanceNuevo = new ArrayList();
		/* 185: 213 */this.itemsEstacionesGruposBalanceAreaNuevo = null;
		/* 186: 214 */this.itemsEstacionesVariable = new ArrayList();
		/* 187: 215 */this.itemsEstacionesEnGrupoVariable = new ListShmtEstacion();
		/* 188: 216 */this.itemsGruposBalanceAreaBorrado = null;
		/* 189: 217 */this.itemsGruposBalanceAreaCuenca = new ArrayList();
		/* 190: 218 */this.itemsZonaHidrografica = new ArrayList();
		/* 191: 219 */this.nuevoPeso = 50;
		/* 192: 220 */this.nuevoAreaOperativa = "";
		/* 193: 221 */this.nuevoCuenca = "";
		/* 194: 222 */this.nuevoDistancia = "";
		/* 195: 223 */this.nuevoEstacion = "";
		/* 196: 224 */this.nuevoFormulario = NombresTitulosAplicacion.REFERENCIA_ESTACION.nombreTitulo;
		/* 197: 225 */this.nuevoGrafo = null;
		/* 198: 226 */this.nuevoGrupo = "";
		/* 199: 227 */this.nuevoObs = "";
		/* 200: 228 */this.nuevoPesoConjunto = "";
		/* 201: 229 */this.nuevoPesoIndividual = "";
		/* 202: 230 */this.nuevoVariable = NombresTitulosAplicacion.NIVEL.nombreTitulo;
		/* 203: 231 */this.mensajePupop = "";
		/* 204: 232 */this.grupoNuevo = false;
		/* 205: 233 */this.periocidad = NombresTitulosAplicacion.ANUAL.nombreTitulo;
		/* 206: 234 */this.selectedAreaOperativa = "";
		/* 207: 235 */this.selectedDate1 = Calendar.getInstance().getTime();
		/* 208: 236 */this.selectedDate2 = Calendar.getInstance().getTime();
		/* 209: 237 */this.selectedGrupo = "";
		this.numberModify = "";
		/* 210: 238 */this.selectedGrupoBorrado = "";
		/* 211: 239 */this.selectedGrupoNuevaEstacion = "";
		/* 212: 240 */this.selectedAreaHidrografica = "";
		/* 213: 241 */this.selectedZonaHidrografica = "";
		/* 214: 242 */this.selectedSbZonaHidrografica = "";
		/* 215: 243 */this.validaAreaHidrografica = false;
		/* 216: 244 */this.validaZonaHidrografica = false;
		/* 217: 245 */this.validaSbZonaHidrografica = false;
		/* 218: 246 */this.validaGrupoNuevo = false;
		/* 219: 247 */this.visibleNuevo = false;
		/* 220: 248 */this.visibleEliminar = false;
		/* 221: 249 */this.visibleTabla = false;
		/* 222: 250 */this.visibleTablaBalance = false;
		/* 223: 251 */this.zoom = false;
		/* 224: */}

	/* 225: */
	/* 226: */public void pupOpEvent(ActionEvent e)
	/* 227: */{
		/* 228: 255 */this.visibleNuevo = (!this.visibleNuevo);
		/* 229: 256 */nuevoEvent(e);
		/* 230: */}

	/* 231: */
	/* 232: */public void pupOpEventEliminar(ActionEvent e)
	/* 233: */{
		/* 234: 260 */this.visibleEliminar = (!this.visibleEliminar);
		/* 235: 261 */nuevoEvent(e);
		/* 236: 262 */limpiarEstaciones();
					listaGruposPorAreaOperativa(e);
		/* 237: */}

	/* 238: */
	/* 239: */public String eventRedirect()
	/* 240: */{
		/* 241: */try
		/* 242: */{
			/* 243: 267 */String estado = isBalance() ? "grupos" : "balance";
			/* 244: 268 */limpiarEstaciones();
			/* 245: */
			/* 246: 270 */FacesContext.getCurrentInstance()
			/* 247: 271 */.getExternalContext()
			/* 248: 272 */.redirect(
			/* 249: 273 */"index.jsp?&usuario=" + getUsuario() + "&estado=" +
			/* 250: 274 */estado);
			/* 251: */}
		/* 252: */catch (Exception ex)
		/* 253: */{
			/* 254: 277 */log.debug(ex.getMessage());
			/* 255: */}
		/* 256: 279 */return "";
		/* 257: */}

	/* 258: */
	/* 259: */public void eventEliminar(ActionEvent e)
	/* 260: */{
		/* 261: 284 */UIComponent boton = e.getComponent();
		/* 262: 285 */actualizaGuardado(e);
		/* 263: 286 */if (isVisiblePupOpEstacion())
		/* 264: */{
			/* 265: */try
			/* 266: */{
				/* 267: 289 */ShmtGrupoBalanceCaudal.retirarEstaciones(
				/* 268: 290 */this.itemsEstacionesEnGruposBalanceAreaBorrado,
				/* 269: 291 */getIdSelectedGrupoBorrado(),
				/* 270: 292 */getSelectedAreaOperativa());
				/* 271: 293 */context()
				/* 272: 294 */.addMessage(
				/* 273: 295 */boton.getClientId(),
				/* 274: 296 */new FacesMessage(
				/* 275: 297 */"Se ha(n) retirado la(s) estación(es)"));
				/* 276: */}
			/* 277: */catch (Exception ex)
			/* 278: */{
				/* 279: 299 */context().addMessage(
						boton.getClientId(),
						/* 280: 300 */new FacesMessage(
								"No se logró retirar estación(es)"));
				/* 281: */}
			/* 282: */}
		/* 283: 302 */else if (!isVisiblePupOpEstacion())
		/* 284: */{
			/* 285: */try
			/* 286: */{
				/* 287: 304 */String file = "";
				/* 288: */
				/* 289: */
				/* 290: 307 */BartTransfer bt = new BartTransfer();
				/* 291: 309 */for (Object object : this.itemsGruposBalanceAreaBorrado)
				/* 292: */{
					/* 293: 310 */file = ((ShmtGrupoBalanceCaudal) object)
							.getGrbcGrafo();
					/* 294: 311 */bt.eliminarImagen(file);
					/* 295: */}
				/* 296: */}
			/* 297: */catch (Exception ex)
			/* 298: */{
				/* 299: 314 */context().addMessage(
				/* 300: 315 */boton.getClientId(),
				/* 301: 316 */new FacesMessage(
				/* 302: 317 */"No se logra(ron) eliminar la(s) imagen(es)!"));
				/* 303: */}
			/* 304: */try
			/* 305: */{
				/* 306: 322 */ShmtGrupoBalanceCaudal
						.retirarGrupos(this.itemsGruposBalanceAreaBorrado);
				/* 307: */
				/* 308: 324 */context().addMessage(
						boton.getClientId(),
						/* 309: 325 */new FacesMessage(
								"Se ha(n) retirado el/los grupo(s)"));
				/* 310: */
				/* 311: 327 */getItemsGruposBalanceArea();
				/* 312: */
				/* 313: 329 */this.itemsGruposBalanceAreaBorrado = null;
				/* 314: */
				/* 315: 331 */getGruposBalanceCaudal();
				/* 316: */}
			/* 317: */catch (Exception ex)
			/* 318: */{
				/* 319: 333 */context()
						.addMessage(
								boton.getClientId(),
								/* 320: 334 */new FacesMessage(
										"No se logró retirar grupo(s)!"));
				/* 321: */}
			/* 322: */}
		/* 323: */}

	/* 324: */
	/* 325: */public void nuevoEvent(ActionEvent e)
	/* 326: */{
		/* 327: 342 */this.grupoNuevo = (!this.grupoNuevo);
		/* 328: 343 */this.itemsEstacionesGruposBalanceAreaNuevo = null;
		/* 329: 344 */this.itemsEstacionesEnGruposBalanceAreaBorrado = null;
		/* 330: 345 */this.itemsGruposBalanceAreaBorrado = null;
		/* 331: */
		/* 332: 347 */this.nuevoGrafo = null;
		/* 333: 349 */if (this.visibleEliminar)
		/* 334: */{
			/* 335: 350 */this.mensajePupop = NombresTitulosAplicacion.MENSAJE_ELIMINAR.nombreTitulo;
			/* 336: 351 */this.selectedGrupoBorrado = "";
			/* 337: */}
		/* 338: 354 */if (this.visibleNuevo)
		/* 339: */{
			/* 340: 355 */this.mensajePupop = NombresTitulosAplicacion.MENSAJE_NUEVO.nombreTitulo;
			/* 341: 356 */actualizaAreasNuevoGrupo();
			/* 342: 357 */this.selectedAreaHidrografica = "";
			/* 343: 358 */this.selectedZonaHidrografica = "";
			/* 344: 359 */this.selectedSbZonaHidrografica = "";
			/* 345: 360 */this.selectedGrupo = "";
			/* 346: */}
		/* 347: 362 */this.nuevo =
		/* 348: 363 */(this.nuevo
				.equals(NombresTitulosAplicacion.IMAGEN_NUEVO_GRUPO.nombreTitulo) ? NombresTitulosAplicacion.IMAGEN_NUEVA_ESTACION.nombreTitulo
				:
				/* 349: 364 */NombresTitulosAplicacion.IMAGEN_NUEVO_GRUPO.nombreTitulo);
		/* 350: 365 */this.mensajePupop =
		/* 351: 366 */(this.mensajePupop + " " + (isVisiblePupOpEstacion() ? NombresTitulosAplicacion.TITULO_ESTACION.nombreTitulo
				:
				/* 352: 367 */NombresTitulosAplicacion.TITULO_GRUPO.nombreTitulo));
		/* 353: */}

	/* 354: */
	/* 355: */public boolean isVisiblePupOpEstacion()
	/* 356: */{
		/* 357: 372 */return
		/* 358: 373 */this.nuevo
				.equals(NombresTitulosAplicacion.IMAGEN_NUEVA_ESTACION.nombreTitulo);
		/* 359: */}

	/* 360: */
	/* 361: */public boolean isValidaAreaHidrografica()
	/* 362: */{
		/* 363: 377 */return this.validaAreaHidrografica;
		/* 364: */}

	/* 365: */
	/* 366: */public void setValidaAreaHidrografica(
			boolean validaAreaHidrografica)
	/* 367: */{
		/* 368: 381 */this.validaAreaHidrografica = validaAreaHidrografica;
		/* 369: */}

	/* 370: */
	/* 371: */public boolean isValidaZonaHidrografica()
	/* 372: */{
		/* 373: 385 */return this.validaZonaHidrografica;
		/* 374: */}

	/* 375: */
	/* 376: */public void setValidaZonaHidrografica(
			boolean validaZonaHidrografica)
	/* 377: */{
		/* 378: 389 */this.validaZonaHidrografica = validaZonaHidrografica;
		/* 379: */}

	/* 380: */
	/* 381: */public boolean isValidaSbZonaHidrografica()
	/* 382: */{
		/* 383: 393 */return this.validaSbZonaHidrografica;
		/* 384: */}

	/* 385: */
	/* 386: */public void setValidaSbZonaHidrografica(
			boolean validaSbZonaHidrografica)
	/* 387: */{
		/* 388: 397 */this.validaSbZonaHidrografica = validaSbZonaHidrografica;
		/* 389: */}

	/* 390: */
	/* 391: */public boolean isValidaGrupoNuevo()
	/* 392: */{
		/* 393: 401 */return this.validaGrupoNuevo;
		/* 394: */}

	/* 395: */
	/* 396: */public void setValidaGrupoNuevo(boolean validaGrupoNuevo)
	/* 397: */{
		/* 398: 405 */this.validaGrupoNuevo = validaGrupoNuevo;
		/* 399: */}

	/* 400: */
	/* 401: */public Boolean getVisibleNuevo()
	/* 402: */{
		/* 403: 409 */return Boolean.valueOf(this.visibleNuevo);
		/* 404: */}

	/* 405: */
	/* 406: */public Boolean isVisibleNuevo()
	/* 407: */{
		/* 408: 413 */return Boolean.valueOf(this.visibleNuevo);
		/* 409: */}

	/* 410: */
	/* 411: */public void setVisibleNuevo(Boolean visibleNuevo)
	/* 412: */{
		/* 413: 417 */this.visibleNuevo = visibleNuevo.booleanValue();
		/* 414: */}

	/* 415: */
	/* 416: */public boolean isVisibleEliminar()
	/* 417: */{
		/* 418: 421 */return this.visibleEliminar;
		/* 419: */}

	/* 420: */
	/* 421: */public void setVisibleEliminar(boolean visibleEliminar)
	/* 422: */{
		/* 423: 425 */this.visibleEliminar = visibleEliminar;
		/* 424: */}

	/* 425: */
	/* 426: */public boolean isZoom()
	/* 427: */{
		/* 428: 429 */return this.zoom;
		/* 429: */}

	/* 430: */
	/* 431: */public void setZoom(boolean zoom)
	/* 432: */{
		/* 433: 433 */this.zoom = zoom;
		/* 434: */}

	/* 435: */
	/* 436: */public AutoCompleteEntry getAreaOperativa()
	/* 437: */{
		/* 438: 437 */if (this.areaOperativa == null)
		/* 439: */{
			/* 440: 438 */this.areaOperativa = new AutoCompleteEntry();
			/* 441: 439 */this.areaOperativa.setListValue(getItemsAreaOpera());
			/* 442: 440 */this.areaOperativa.setItemList(getItemsAreaOpera());
			/* 443: 441 */this.areaOperativa.setTransient(true);
			/* 444: */}
		/* 445: 443 */return this.areaOperativa;
		/* 446: */}

	/* 447: */
	/* 448: */public void setAreaOperativa(AutoCompleteEntry areaOperativa)
	/* 449: */{
		/* 450: 447 */this.areaOperativa = areaOperativa;
		/* 451: */}

	/* 452: */
	/* 453: */public HtmlPanelGrid getDatosEstacion()
	/* 454: */{
		/* 455: 451 */if (this.datosEstacion == null) {
			/* 456: 452 */this.datosEstacion = new HtmlPanelGrid();
			/* 457: */}
		/* 458: 454 */return this.datosEstacion;
		/* 459: */}

	/* 460: */
	/* 461: */public void setDatosEstacion(HtmlPanelGrid datosEstacion)
	/* 462: */{
		/* 463: 458 */this.datosEstacion = datosEstacion;
		/* 464: */}

	/* 465: */
	/* 466: */public AutoCompleteEntry getEntryCuenca()
	/* 467: */{
		/* 468: 462 */if (this.entryCuenca == null) {
			/* 469: 463 */this.entryCuenca = new AutoCompleteEntry();
			/* 470: */}
		/* 471: 465 */return this.entryCuenca;
		/* 472: */}

	/* 473: */
	/* 474: */public void setEntryCuenca(AutoCompleteEntry entryCuenca)
	/* 475: */{
		/* 476: 469 */this.entryCuenca = entryCuenca;
		/* 477: */}

	/* 478: */
	/* 479: */public AutoCompleteEntry getEntryGrupo()
	/* 480: */{
		/* 481: 473 */if (this.entryGrupo == null) {
			/* 482: 474 */this.entryGrupo = new AutoCompleteEntry();
			/* 483: */}
		/* 484: 476 */return this.entryGrupo;
		/* 485: */}

	/* 486: */
	/* 487: */public void setEntryGrupo(AutoCompleteEntry entryGrupo)
	/* 488: */{
		/* 489: 480 */this.entryGrupo = entryGrupo;
		/* 490: */}

	/* 491: */
	/* 492: */public Dialog getChartDialog()
	/* 493: */{
		/* 494: 484 */return this.chartDialog;
		/* 495: */}

	/* 496: */
	/* 497: */public void setChartDialog(Dialog chartDialog)
	/* 498: */{
		/* 499: 488 */this.chartDialog = chartDialog;
		/* 500: */}

	/* 501: */
	/* 502: */public ListShmtEstacion getEstacionesBalanceCaudal()
	/* 503: */{
		/* 504: 492 */return this.estacionesBalanceCaudal;
		/* 505: */}

	/* 506: */
	/* 507: */public void setEstacionesBalanceCaudal(
			ListShmtEstacion estacionesBalanceCaudal)
	/* 508: */{
		/* 509: 497 */this.estacionesBalanceCaudal = estacionesBalanceCaudal;
		/* 510: */}

	/* 511: */
	/* 512: */public void setEstacionesBalanceCaudalList(
			ShmtEstacionesList estacionesBalanceCaudalList)
	/* 513: */{
		/* 514: 502 */this.estacionesBalanceCaudalList = estacionesBalanceCaudalList;
		/* 515: */}

	/* 516: */
	/* 517: */public String getNuevoFormulario()
	/* 518: */{
		/* 519: 506 */return this.nuevoFormulario;
		/* 520: */}

	/* 521: */
	/* 522: */public void setNuevoFormulario(String nuevoFormulario)
	/* 523: */{
		/* 524: 510 */this.nuevoFormulario = nuevoFormulario;
		/* 525: */}

	/* 526: */
	/* 527: */public String getNuevoAreaOperativa()
	/* 528: */{
		/* 529: 514 */if (!isValidaAop())
		/* 530: */{
			/* 531: 515 */this.visibleNuevo = false;
			/* 532: 516 */return "";
			/* 533: */}
		/* 534: 518 */this.nuevoAreaOperativa = this.areaOperativa.getLabel();
		/* 535: 519 */return this.nuevoAreaOperativa;
		/* 536: */}

	/* 537: */
	/* 538: */public void setNuevoAreaOperativa(String nuevoAreaOperativa)
	/* 539: */{
		/* 540: 523 */this.nuevoAreaOperativa = nuevoAreaOperativa;
		/* 541: */}

	/* 542: */
	/* 543: */public String getNuevoCuenca()
	/* 544: */{
		/* 545: 527 */return this.nuevoCuenca;
		/* 546: */}

	/* 547: */
	/* 548: */public void setNuevoCuenca(String nuevoCuenca)
	/* 549: */{
		/* 550: 531 */this.nuevoCuenca = nuevoCuenca;
		/* 551: */}

	/* 552: */
	/* 553: */public String getNuevoGrupo()
	/* 554: */{
		/* 555: 535 */return this.nuevoGrupo;
		/* 556: */}

	/* 557: */
	/* 558: */public void setNuevoGrupo(String nuevoGrupo)
	/* 559: */{
		/* 560: 539 */this.nuevoGrupo = nuevoGrupo;
		/* 561: */}

	/* 562: */
	/* 563: */public String getNuevoEstacion()
	/* 564: */{
		/* 565: 543 */return this.nuevoEstacion;
		/* 566: */}

	/* 567: */
	/* 568: */public void setNuevoEstacion(String nuevoEstacion)
	/* 569: */{
		/* 570: 547 */this.nuevoEstacion = nuevoEstacion;
		/* 571: */}

	/* 572: */
	/* 573: */public Archivo getNuevoGrafo()
	/* 574: */{
		/* 575: 551 */return this.nuevoGrafo;
		/* 576: */}

	/* 577: */
	/* 578: */public void setNuevoGrafo(Archivo nuevoGrafo)
	/* 579: */{
		/* 580: 555 */this.nuevoGrafo = nuevoGrafo;
		/* 581: */}

	/* 582: */
	/* 583: */public String getNuevoObs()
	/* 584: */{
		/* 585: 559 */return this.nuevoObs;
		/* 586: */}

	/* 587: */
	/* 588: */public void setNuevoObs(String nuevoObs)
	/* 589: */{
		/* 590: 563 */this.nuevoObs = nuevoObs;
		/* 591: */}

	/* 592: */
	/* 593: */public String getNuevoPesoConjunto()
	/* 594: */{
		/* 595: 567 */return this.nuevoPesoConjunto;
		/* 596: */}

	/* 597: */
	/* 598: */public void setNuevoPesoConjunto(String nuevoPesoConjunto)
	/* 599: */{
		/* 600: 571 */this.nuevoPesoConjunto = nuevoPesoConjunto;
		/* 601: */}

	/* 602: */
	/* 603: */public String getNuevoPesoIndividual()
	/* 604: */{
		/* 605: 575 */return this.nuevoPesoIndividual;
		/* 606: */}

	/* 607: */
	/* 608: */public void setNuevoPesoIndividual(String nuevoPesoIndividual)
	/* 609: */{
		/* 610: 579 */this.nuevoPesoIndividual = nuevoPesoIndividual;
		/* 611: */}

	/* 612: */
	/* 613: */public int getNuevoPeso()
	/* 614: */{
		/* 615: 583 */return this.nuevoPeso;
		/* 616: */}

	/* 617: */
	/* 618: */public void setNuevoPeso(int nuevoPeso)
	/* 619: */{
		/* 620: 587 */this.nuevoPeso = nuevoPeso;
		/* 621: */}

	/* 622: */
	/* 623: */public String getNuevoDistancia()
	/* 624: */{
		/* 625: 591 */return this.nuevoDistancia;
		/* 626: */}

	/* 627: */
	/* 628: */public void setNuevoDistancia(String nuevoDistancia)
	/* 629: */{
		/* 630: 595 */this.nuevoDistancia = nuevoDistancia;
		/* 631: */}

	/* 632: */
	/* 633: */public void setVisibleNuevo(boolean visibleNuevo)
	/* 634: */{
		/* 635: 599 */this.visibleNuevo = visibleNuevo;
		/* 636: */}

	/* 637: */
	/* 638: */public void setBalance(boolean balance)
	/* 639: */{
		/* 640: 603 */this.balance = balance;
		/* 641: */}

	/* 642: */
	/* 643: */public void setGrupos(boolean grupos)
	/* 644: */{
		/* 645: 607 */this.grupos = grupos;
		/* 646: */}

	/* 647: */
	/* 648: */public String getCuenca()
	/* 649: */{
		/* 650: 611 */return this.cuenca;
		/* 651: */}

	/* 652: */
	/* 653: */public void setCuenca(String cuenca)
	/* 654: */{
		/* 655: 615 */this.cuenca = cuenca;
		/* 656: */}

	/* 657: */
	/* 658: */public String getGrupo()
	/* 659: */{
		/* 660: 619 */return this.grupo;
		/* 661: */}

	/* 662: */
	/* 663: */public void setGrupo(String grupo)
	/* 664: */{
		/* 665: 623 */this.grupo = grupo;
		/* 666: */}

	/* 667: */
	/* 668: */public String getAño()
	/* 669: */{
		/* 670: 627 */return this.año;
		/* 671: */}

	/* 672: */
	/* 673: */public void setAño(String año)
	/* 674: */{
		/* 675: 631 */this.año = año;
		/* 676: */}

	/* 677: */
	/* 678: */public boolean isGrupoNuevo()
	/* 679: */{
		/* 680: 635 */return this.grupoNuevo;
		/* 681: */}

	/* 682: */
	/* 683: */public void setGrupoNuevo(boolean grupoNuevo)
	/* 684: */{
		/* 685: 639 */this.grupoNuevo = grupoNuevo;
		/* 686: */}

	/* 687: */
	/* 688: */public String getNuevo()
	/* 689: */{
		/* 690: 643 */return this.nuevo;
		/* 691: */}

	/* 692: */
	/* 693: */public void setNuevo(String nuevo)
	/* 694: */{
		/* 695: 647 */this.nuevo = nuevo;
		/* 696: */}

	/* 697: */
	/* 698: */public boolean isVisibleTabla()
	/* 699: */{
		/* 700: 651 */return this.visibleTabla;
		/* 701: */}

	/* 702: */
	/* 703: */public void setVisibleTabla(boolean visibleTabla)
	/* 704: */{
		/* 705: 655 */this.visibleTabla = visibleTabla;
		/* 706: */}

	/* 707: */
	/* 708: */public boolean isVisibleTablaBalance()
	/* 709: */{
		/* 710: 659 */return this.visibleTablaBalance;
		/* 711: */}

	/* 712: */
	/* 713: */public void setVisibleTablaBalance(boolean visibleTablaBalance)
	/* 714: */{
		/* 715: 663 */this.visibleTablaBalance = visibleTablaBalance;
		/* 716: */}

	/* 717: */
	/* 718: */private String getSelectedAreaOperativa()
	/* 719: */{
		/* 720: 667 */return SioOrganizacion
				.obtenerCodigoAreaOpe(this.areaOperativa
				/* 721: 668 */.getValue().toString());
		/* 722: */}

	/* 723: */
	/* 724: */public String getSelectedAreaOperativaInput()
	/* 725: */{
		/* 726: 672 */return SioOrganizacion
				.obtenerCodigoAreaOpe(this.areaOperativa
				/* 727: 673 */.getText());
		/* 728: */}

	/* 729: */
	/* 730: */public void setSelectedAreaOperativa(String selectedAreaOperativa)
	/* 731: */{
		/* 732: 677 */this.selectedAreaOperativa = selectedAreaOperativa;
		/* 733: */}

	/* 734: */
	/* 735: */public String getSelectedGrupo()
	/* 736: */{
		/* 737: 681 */for (SelectItem grupo : getItemsGruposBalanceAreaCuenca()) {
			/* 738: 682 */if (grupo.getLabel().equals(this.selectedGrupo)) {
				/* 739: 683 */return grupo.getLabel();
				/* 740: */}
			/* 741: */}
		/* 742: 686 */return this.selectedGrupo;
		/* 743: */}

	/* 744: */
	/* 745: */public String getSelectedGrupoBorrado()
	/* 746: */{
		/* 747: 690 */for (SelectItem grupo : getItemsGruposBalanceArea()) {
			/* 748: 691 */if (grupo.getLabel()
					.equals(this.selectedGrupoBorrado)) {
				/* 749: 692 */return grupo.getLabel();
				/* 750: */}
			/* 751: */}
		/* 752: 695 */return this.selectedGrupoBorrado;
		/* 753: */}

	/* 754: */
	/* 755: */public Long getIdSelectedGrupo()
	/* 756: */{
		/* 757: 699 */for (SelectItem grupo : getItemsGruposBalanceAreaCuenca()) {
			/* 758: 701 */if (((ShmtGrupoBalanceCaudal) grupo.getValue())
					.getNameDisplay().equals(this.selectedGrupo)) {
				/* 759: 702 */return ((ShmtGrupoBalanceCaudal) grupo.getValue())
						.getGrbcId();
				/* 760: */}
			/* 761: */}
		/* 762: 705 */return Long.valueOf(-1L);
		/* 763: */}

	/* 764: */
	/* 765: */public Long getNumberSelectedGrupo()
	/* 766: */{
		/* 767: 709 */for (SelectItem grupo : getItemsGruposBalanceAreaCuenca()) {
			/* 768: 711 */if (((ShmtGrupoBalanceCaudal) grupo.getValue())
					.getNameDisplay().equals(this.selectedGrupo)) {
				/* 769: 712 */return
				/* 770: 713 */((ShmtGrupoBalanceCaudal) grupo.getValue())
						.getGrbcNumero();
				/* 771: */}
			/* 772: */}
		/* 773: 716 */return Long.valueOf(-1L);
		/* 774: */}

	/* 775: */
	/* 776: */public Long getIdSelectedGrupoBalance()
	/* 777: */{
		/* 778: 720 */for (SelectItem grupo : getItemsGruposBalanceCaudal()) {
			/* 779: 721 */if (grupo.getLabel().equals(
					this.entryGrupo.getValue().toString())) {
				/* 780: 722 */return Long.valueOf(grupo.getValue().toString());
				/* 781: */}
			/* 782: */}
		/* 783: 725 */return Long.valueOf(-1L);
		/* 784: */}

	/* 785: */
	/* 786: */public Long getIdSelectedGrupoBorrado()
	/* 787: */{
		/* 788: 729 */for (ShmtGrupoBalanceCaudal grupo : getGruposBalanceCaudal()) {
			/* 789: 730 */if (grupo.getNameDisplay().equals(
					this.selectedGrupoBorrado)) {
				/* 790: 731 */return grupo.getGrbcId();
				/* 791: */}
			/* 792: */}
		/* 793: 734 */return Long.valueOf(-1L);
		/* 794: */}

	/* 795: */
	/* 796: */public String getSelectedGrupoNuevaEstacion()
	/* 797: */{
		/* 798: 738 */for (ShmtGrupoBalanceCaudal grupo : getGruposBalanceCaudal()) {
			/* 799: 739 */if (grupo.getNameDisplay().equals(
					this.selectedGrupoNuevaEstacion)) {
				/* 800: 740 */return grupo.getGrbcId().toString();
				/* 801: */}
			/* 802: */}
		/* 803: 743 */return null;
		/* 804: */}

	/* 805: */
	/* 806: */public ShmtGrupoBalanceCaudal getSelectedGrupoBalance()
	/* 807: */{
		/* 808: 747 */for (ShmtGrupoBalanceCaudal grupo : getGruposBalanceCaudal()) {
			/* 809: 748 */if (grupo.getNameDisplay().equals(
					this.selectedGrupoNuevaEstacion)) {
				/* 810: 749 */return grupo;
				/* 811: */}
			/* 812: */}
		/* 813: 752 */return null;
		/* 814: */}

	/* 815: */
	/* 816: */public void setSelectedGrupoNuevaEstacion(
			String selectedGrupoNuevaEstacion)
	/* 817: */{
		/* 818: 756 */if (!this.selectedGrupoNuevaEstacion
				.equals(selectedGrupoNuevaEstacion))
		/* 819: */{
			/* 820: 757 */this.selectedGrupoNuevaEstacion = selectedGrupoNuevaEstacion;
			/* 821: 758 */actualizaEstacionesIncluir();
			/* 822: 759 */actualizaEstacionesExcluir();
			/* 823: */}
		/* 824: */}

	/* 825: */
	/* 826: */public void setSelectedGrupo(String selectedGrupo)
	/* 827: */{
		/* 828: 764 */if (!this.selectedGrupo.equals(selectedGrupo))
		/* 829: */{
			/* 830: 765 */this.selectedGrupo = selectedGrupo;
			/* 831: 766 */actualizaGruposIncluir();
			/* 832: */}
		/* 833: */}

	/* 834: */
	/* 835: */public void setSelectedGrupoBorrado(String selectedGrupoBorrado)
	/* 836: */{
		/* 837: 771 */if (!this.selectedGrupoBorrado
				.equals(selectedGrupoBorrado))
		/* 838: */{
			/* 839: 772 */this.selectedGrupoBorrado = selectedGrupoBorrado;
			/* 840: 773 */actualizaEstacionesExcluir();
			/* 841: */}
		/* 842: */}

	/* 843: */
	/* 844: */public String getSelectedAreaHidrografica()
	/* 845: */{
		/* 846: 778 */for (SelectItem area : getItemsAreaHidrografica()) {
			/* 847: 779 */if (area.getLabel().equals(
					this.selectedAreaHidrografica)) {
				/* 848: 780 */return area.getValue().toString();
				/* 849: */}
			/* 850: */}
		/* 851: 783 */return "";
		/* 852: */}

	/* 853: */
	/* 854: */public void setSelectedAreaHidrografica(
			String selectedAreaHidrografica)
	/* 855: */{
		/* 856: 787 */if (!this.selectedAreaHidrografica
				.equals(selectedAreaHidrografica))
		/* 857: */{
			/* 858: 788 */this.selectedAreaHidrografica = selectedAreaHidrografica;
			/* 859: 789 */actualizaZonasNuevoGrupo();
			/* 860: */}
		/* 861: */}

	/* 862: */
	/* 863: */public String getSelectedZonaHidrografica()
	/* 864: */{
		/* 865: 794 */for (SelectItem zn : getItemsZonasPorAreaHidrografica()) {
			/* 866: 795 */if (zn.getLabel().equals(
					this.selectedZonaHidrografica)) {
				/* 867: 796 */return zn.getValue().toString().split("---")[0]
						.toString();
				/* 868: */}
			/* 869: */}
		/* 870: 799 */return null;
		/* 871: */}

	/* 872: */
	/* 873: */public void setSelectedZonaHidrografica(
			String selectedZonaHidrografica)
	/* 874: */{
		/* 875: 803 */if (!this.selectedZonaHidrografica
				.equals(selectedZonaHidrografica))
		/* 876: */{
			/* 877: 804 */this.selectedZonaHidrografica = selectedZonaHidrografica;
			/* 878: 805 */actualizaSbZonasNuevoGrupo();
			/* 879: */}
		/* 880: */}

	/* 881: */
	/* 882: */public String getSelectedSbZonaHidrografica()
	/* 883: */{
		/* 884: 810 */for (SelectItem zb : getItemsSubZonasHidrografica()) {
			/* 885: 811 */if (zb.getLabel().equals(
					this.selectedSbZonaHidrografica)) {
				/* 886: 812 */return zb.getValue().toString().split("---")[1]
						.toString();
				/* 887: */}
			/* 888: */}
		/* 889: 815 */return "";
		/* 890: */}

	/* 891: */
	/* 892: */public String getSelectedSbZonaHidrograficaId()
	/* 893: */{
		/* 894: 819 */for (SelectItem zb : getItemsSubZonasHidrografica()) {
			/* 895: 820 */if (zb.getLabel().equals(
					this.selectedSbZonaHidrografica)) {
				/* 896: 821 */return zb.getValue().toString().split("---")[1]
						.toString();
				/* 897: */}
			/* 898: */}
		/* 899: 824 */return "";
		/* 900: */}

	/* 901: */
	/* 902: */public SioCuencasHidrograficas getIdSelectedCuenca()
	/* 903: */{
		/* 904: 828 */return SioCuencasHidrograficas
				.cuencaPorNombre(this.entryCuenca.getValue()
				/* 905: 829 */.toString());
		/* 906: */}

	/* 907: */
	/* 908: */public void setSelectedSbZonaHidrografica(
			String selectedSbZonaHidrografica)
	/* 909: */{
		/* 910: 834 */if (!this.selectedSbZonaHidrografica
				.equals(selectedSbZonaHidrografica))
		/* 911: */{
			/* 912: 835 */this.selectedSbZonaHidrografica = selectedSbZonaHidrografica;
			/* 913: 836 */actualizaGruposIncluir();
			/* 914: */}
		/* 915: */}

	/* 916: */
	/* 917: */public String getSelectedEstacion()
	/* 918: */{
		/* 919: 841 */if (this.selectedGrupoNuevaEstacion == "") {
			/* 920: 842 */return "";
			/* 921: */}
		/* 922: 844 */for (SelectItem ie : getItemsEstaciones()) {
			/* 923: 845 */if (ie.getLabel().equals(this.selectedEstacion)) {
				/* 924: 846 */return ie.getValue().toString().split("---")[0]
						.toString();
				/* 925: */}
			/* 926: */}
		/* 927: 849 */return null;
		/* 928: */}

	/* 929: */
	/* 930: */public void setSelectedEstacion(String selectedEstacion)
	/* 931: */{
		/* 932: 853 */this.selectedEstacion = selectedEstacion;
		/* 933: */}

	/* 934: */
	/* 935: */public Date getSelectedDate1()
	/* 936: */{
		/* 937: 857 */return this.selectedDate1;
		/* 938: */}

	/* 939: */
	/* 940: */public void setSelectedDate1(Date selectedDate1)
	/* 941: */{
		/* 942: 861 */this.selectedDate1 = selectedDate1;
		/* 943: */}

	/* 944: */
	/* 945: */public Date getSelectedDate2()
	/* 946: */{
		/* 947: 865 */return this.selectedDate2;
		/* 948: */}

	/* 949: */
	/* 950: */public void setSelectedDate2(Date selectedDate2)
	/* 951: */{
		/* 952: 869 */this.selectedDate2 = selectedDate2;
		/* 953: */}

	/* 954: */
	/* 955: */public String getMensajePupop()
	/* 956: */{
		/* 957: 873 */return this.mensajePupop;
		/* 958: */}

	/* 959: */
	/* 960: */public void setMensajePupop(String mensajePupop)
	/* 961: */{
		/* 962: 877 */this.mensajePupop = mensajePupop;
		/* 963: */}

	/* 964: */
	/* 965: */public Set<Object> getItemsEstacionesEnGruposBalanceAreaBorrado()
	/* 966: */{
		/* 967: 881 */return this.itemsEstacionesEnGruposBalanceAreaBorrado;
		/* 968: */}

	/* 969: */
	/* 970: */public void setItemsEstacionesEnGruposBalanceAreaBorrado(
			Set<Object> itemsEstacionesEnGruposBalanceAreaBorrado)
	/* 971: */{
		/* 972: 886 */this.itemsEstacionesEnGruposBalanceAreaBorrado = itemsEstacionesEnGruposBalanceAreaBorrado;
		/* 973: */}

	/* 974: */
	/* 975: */public Set<Object> getItemsGruposBalanceAreaBorrado()
	/* 976: */{
		/* 977: 890 */return this.itemsGruposBalanceAreaBorrado;
		/* 978: */}

	/* 979: */
	/* 980: */public void setItemsGruposBalanceAreaBorrado(
			Set<Object> itemsGruposBalanceAreaBorrado)
	/* 981: */{
		/* 982: 895 */this.itemsGruposBalanceAreaBorrado = itemsGruposBalanceAreaBorrado;
		/* 983: */}

	/* 984: */
	/* 985: */public Set<Object> getItemsEstacionesGruposBalanceAreaNuevo()
	/* 986: */{
		/* 987: 899 */return this.itemsEstacionesGruposBalanceAreaNuevo;
		/* 988: */}

	/* 989: */
	/* 990: */public void setItemsEstacionesGruposBalanceAreaNuevo(
			Set<Object> itemsEstacionesGruposBalanceAreaNuevo)
	/* 991: */{
		/* 992: 904 */this.itemsEstacionesGruposBalanceAreaNuevo = itemsEstacionesGruposBalanceAreaNuevo;
		/* 993: */}

	/* 994: */
	/* 995: */public List<SelectItem> getItemsEstacionesGruposBalanceNuevo()
	/* 996: */{
		/* 997: 908 */this.itemsEstacionesGruposBalanceNuevo = new ArrayList();
		/* 998: 909 */if (getSelectedGrupoBalance() == null) {
			/* 999: 910 */return this.itemsEstacionesGruposBalanceNuevo;
			/* 1000: */}
		/* 1001: 911 */Long selectedGrupoId = getSelectedGrupoBalance()
				.getGrbcId();
		/* 1002: 912 */List<ShmtEstacionBalanceQl> itemsGrupos = getGruposBalanceCaudal(selectedGrupoId
		/* 1003: 913 */.toString());
		/* 1004: 915 */if ((itemsGrupos != null) &&
		/* 1005: 916 */(itemsGrupos.size() >= 1)) {
			/* 1006: 917 */for (ShmtEstacionBalanceQl estacion : itemsGrupos)
			/* 1007: */{
				/* 1008: 918 */String a1 = ObjectUtils.toString(estacion
						.getEgbqId());
				/* 1009: 919 */String a2 = ObjectUtils.toString(estacion
						.getEstacion()
						/* 1010: 920 */.getCodCatalogoEs() +
				/* 1011: 921 */" " +
				/* 1012: 922 */estacion.getEstacion().getNombrePma());
				/* 1013: 923 */this.itemsEstacionesGruposBalanceNuevo
				/* 1014: 924 */.add(new SelectItem(a1, a2));
				/* 1015: */}
			/* 1016: */}
		/* 1017: 928 */return this.itemsEstacionesGruposBalanceNuevo;
		/* 1018: */}

	/* 1019: */
	/* 1020: */public void setItemsEstacionesGruposBalanceNuevo(
			List<SelectItem> itemsEstacionesGruposBalanceNuevo)
	/* 1021: */{
		/* 1022: 933 */this.itemsEstacionesGruposBalanceNuevo = itemsEstacionesGruposBalanceNuevo;
		/* 1023: */}

	/* 1024: */
	/* 1025: */public Set<Object> getItemsEstacionesGrupoNuevo()
	/* 1026: */{
		/* 1027: 937 */return this.itemsEstacionesGrupoNuevo;
		/* 1028: */}

	/* 1029: */
	/* 1030: */public void setItemsEstacionesGrupoNuevo(
			Set<Object> itemsEstacionesGrupoNuevo)
	/* 1031: */{
		/* 1032: 942 */this.itemsEstacionesGrupoNuevo = itemsEstacionesGrupoNuevo;
		/* 1033: */}

	/* 1034: */
	/* 1035: */public boolean isBalance()
	/* 1036: */{
		/* 1037: */try
		/* 1038: */{
			/* 1039: 947 */this.balance = this.estado
					/* 1040: 948 */.equals(NombresTitulosAplicacion.ESTADO_BALANCE.nombreTitulo);
			/* 1041: */}
		/* 1042: */catch (Exception e)
		/* 1043: */{
			/* 1044: 951 */log.debug("isBalance() " + this.balance);
			/* 1045: */}
		/* 1046: 953 */return this.balance;
		/* 1047: */}

	/* 1048: */
	/* 1049: */public boolean isGrupos()
	/* 1050: */{
		/* 1051: */try
		/* 1052: */{
			/* 1053: 958 */this.grupos = this.estado
					/* 1054: 959 */.equals(NombresTitulosAplicacion.ESTADO_GRUPOS.nombreTitulo);
			/* 1055: */}
		/* 1056: */catch (Exception e)
		/* 1057: */{
			/* 1058: 961 */log.debug("isGrupos() " + this.grupos);
			/* 1059: */}
		/* 1060: 963 */return this.grupos;
		/* 1061: */}

	/* 1062: */
	/* 1063: */public void setItemsEstaciones(List<SelectItem> itemsEstaciones)
	/* 1064: */{
		/* 1065: 967 */this.itemsEstaciones = itemsEstaciones;
		/* 1066: */}

	/* 1067: */
	/* 1068: */public void setItemsEstacionesVariable(
			List<ShmtEstacionBalanceQl> itemsEstacionesVariable)
	/* 1069: */{
		/* 1070: 972 */this.itemsEstacionesVariable = itemsEstacionesVariable;
		/* 1071: */}

	/* 1072: */
	/* 1073: */public void setItemsEstacionesEnGrupo(
			List<SelectItem> itemsEstacionesEnGrupo)
	/* 1074: */{
		/* 1075: 977 */this.itemsEstacionesEnGrupo = itemsEstacionesEnGrupo;
		/* 1076: */}

	/* 1077: */
	/* 1078: */public void setItemsEstacionesEnGrupoVariable(
			ListShmtEstacion itemsEstacionesEnGrupoVariable)
	/* 1079: */{
		/* 1080: 982 */this.itemsEstacionesEnGrupoVariable = itemsEstacionesEnGrupoVariable;
		/* 1081: */}

	/* 1082: */
	/* 1083: */public void setItemsGruposBalanceCaudal(
			List<ShmtGrupoBalanceCaudal> itemsGruposBalanceCaudal)
	/* 1084: */{
		/* 1085: 987 */this.itemsGruposBalanceCaudal = itemsGruposBalanceCaudal;
		/* 1086: */}

	/* 1087: */
	/* 1088: */public void setItemsAreaHidrografica(
			List<SelectItem> itemsAreaHidrografica)
	/* 1089: */{
		/* 1090: 991 */this.itemsAreaHidrografica = itemsAreaHidrografica;
		/* 1091: */}

	/* 1092: */
	/* 1093: */public void setItemsZonaHidrografica(
			List<SelectItem> itemsZonaHidrografica)
	/* 1094: */{
		/* 1095: 995 */this.itemsZonaHidrografica = itemsZonaHidrografica;
		/* 1096: */}

	/* 1097: */
	/* 1098: */public void setItemsSbZonaHidrografica(
			List<SelectItem> itemsSbZonaHidrografica)
	/* 1099: */{
		/* 1100:1000 */this.itemsSbZonaHidrografica = itemsSbZonaHidrografica;
		/* 1101: */}

	/* 1102: */
	/* 1103: */public void setItemsGruposBalanceAreaCuenca(
			List<SelectItem> itemsGruposBalanceAreaCuenca)
	/* 1104: */{
		/* 1105:1005 */this.itemsGruposBalanceAreaCuenca = itemsGruposBalanceAreaCuenca;
		/* 1106: */}

	/* 1107: */
	/* 1108: */public void listaGruposPorAreaOperativaListener(ActionEvent e)
	/* 1109: */{
		/* 1110: */try
		/* 1111: */{
			/* 1112:1010 */getItemsGruposBalanceCaudal();
			/* 1113: */}
		/* 1114: */catch (Throwable localThrowable) {
		}
		/* 1115: */}

	public String getNumberModify() {
		return numberModify;
	}

	public void setNumberModify(String numberModify) {
		this.numberModify = numberModify;
	}

	/* 1116: */
	/* 1117: */public void nuevoVariable(ValueChangeEvent e)
	/* 1118: */{
		/* 1119:1016 */this.itemsEstacionesGrupoNuevo = null;
		/* 1120:1017 */this.itemsEstacionesGruposBalanceAreaNuevo = null;
		/* 1121: */}

	/* 1122: */
	/* 1123: */public void listaGruposPorAreaOperativaEvent(ValueChangeEvent e)
	/* 1124: */{
		/* 1125: */try
		/* 1126: */{
			/* 1127:1022 */getItemsGruposBalanceCaudal();
			/* 1128: */}
		/* 1129: */catch (Throwable localThrowable) {
		}
		/* 1130: */}

	/* 1131: */
	/* 1132: */public void listaGruposPorAreaOperativa(ActionEvent e)
	/* 1133: */{
		/* 1134: */try
		/* 1135: */{
			/* 1136:1029 */getItemsGruposBalanceCaudal();
			/* 1137: */}
		/* 1138: */catch (Throwable e1)
		/* 1139: */{
			/* 1140:1031 */UIComponent boton = e.getComponent();
			/* 1141:1032 */log.debug("listaGruposPorAreaOperativa "
					+ boton.getClientId());
			/* 1142:1033 */context().addMessage(
			/* 1143:1034 */boton.getClientId(),
			/* 1144:1035 */new FacesMessage(severityNames[1],
			/* 1145:1036 */"Error al cargar Grupos Balance Caudal : " +
			/* 1146:1037 */e1.getMessage()));
			/* 1147: */}
		/* 1148: */}

	/* 1149: */
	/* 1150: */public void listaEstacionesBalance(ActionEvent e)
	/* 1151: */{
		/* 1152: */try
		/* 1153: */{
			/* 1154:1043 */setVisibleTablaBalance(true);
			/* 1155:1044 */getItemsEstacionesBalanceCaudalList();
			/* 1156: */}
		/* 1157: */catch (Throwable e1)
		/* 1158: */{
			/* 1159:1046 */e1.printStackTrace();
			/* 1160:1047 */UIComponent boton = e.getComponent();
			/* 1161:1048 */log.debug("listaEstacionesBalance "
					+ boton.getClientId());
			/* 1162:1049 */context().addMessage(
			/* 1163:1050 */boton.getClientId(),
			/* 1164:1051 */new FacesMessage(severityNames[1],
			/* 1165:1052 */"Error al cargar estaciones de balance: " +
			/* 1166:1053 */e1.getMessage()));
			/* 1167: */}
		/* 1168: */}

	/* 1169: */
	/* 1170: */public void listaGruposPorAreaOperativa(TextChangeEvent e)
	/* 1171: */{
		/* 1172: */try
		/* 1173: */{
			/* 1174:1059 */limpiar();
			/* 1175: */}
		/* 1176: */catch (Throwable localThrowable) {
		}
		/* 1177: */}

	/* 1178: */
	/* 1179: */public void listaEstacionesSelectedGrupo(TextChangeEvent e)
	/* 1180: */{
		/* 1181: */try
		/* 1182: */{
			/* 1183:1066 */limpiarEstaciones();
			/* 1184: */}
		/* 1185: */catch (Throwable localThrowable) {
		}
		/* 1186: */}

	/* 1187: */
	/* 1188: */public void listaFiltroIncluirGrupo(TextChangeEvent e)
	/* 1189: */{
		/* 1190: */try
		/* 1191: */{
			/* 1192:1073 */limpiarFiltroAreaH();
			/* 1193: */}
		/* 1194: */catch (Throwable localThrowable) {
		}
		/* 1195: */}

	/* 1196: */
	/* 1197: */public void listaFiltroZonaIncluirGrupo(TextChangeEvent e)
	/* 1198: */{
		/* 1199: */try
		/* 1200: */{
			/* 1201:1080 */limpiarFiltroZonaH();
			/* 1202: */}
		/* 1203: */catch (Throwable localThrowable) {
		}
		/* 1204: */}

	/* 1205: */
	/* 1206: */public void listaFiltroSbZonaIncluirGrupo(TextChangeEvent e)
	/* 1207: */{
		/* 1208: */try
		/* 1209: */{
			/* 1210:1087 */limpiarFiltroSbZonaH();
			/* 1211: */}
		/* 1212: */catch (Throwable localThrowable) {
		}
		/* 1213: */}

	/* 1214: */
	/* 1215: */private void limpiar()
	/* 1216: */{
		/* 1217:1093 */setVisibleTabla(false);
		/* 1218:1094 */limpiarEstaciones();
		/* 1219: */}

	/* 1220: */
	/* 1221: */private void limpiarEstaciones()
	/* 1222: */{
		/* 1223:1098 */this.itemsEstaciones = new ArrayList();
		/* 1224:1099 */this.itemsEstacionesEnGrupo = new ArrayList();
		/* 1225:1100 */this.itemsEstacionesVariable = new ArrayList();
		/* 1226:1101 */this.itemsEstacionesEnGrupoVariable = new ListShmtEstacion();
		/* 1227:1102 */this.selectedGrupoNuevaEstacion = "";
		/* 1228:1103 */this.itemsEstacionesEnGruposBalanceAreaBorrado = null;
		/* 1229:1104 */this.itemsEstacionesGruposBalanceAreaNuevo = null;
		/* 1230:1105 */this.itemsEstacionesGruposBalanceNuevo = new ArrayList();
		/* 1231:1106 */this.itemsGruposBalanceAreaBorrado = null;
		/* 1232:1107 */this.nuevoVariable = NombresTitulosAplicacion.NIVEL.nombreTitulo;
		/* 1233:1108 */this.visibleTabla = false;
		/* 1234:1109 */this.visibleTablaBalance = false;
		/* 1235:1110 */this.nuevoObs = "";
		/* 1236:1111 */this.periocidad = NombresTitulosAplicacion.MENSUAL.nombreTitulo;
		/* 1237: */}

	/* 1238: */
	/* 1239: */private void limpiarFiltroAreaH()
	/* 1240: */{
		/* 1241:1115 */this.selectedAreaHidrografica = "";
		/* 1242:1116 */this.selectedZonaHidrografica = "";
		/* 1243:1117 */this.itemsZonaHidrografica = new ArrayList();
		/* 1244:1118 */this.selectedSbZonaHidrografica = "";
		/* 1245:1119 */this.itemsSbZonaHidrografica = new ArrayList();
		/* 1246:1120 */this.validaAreaHidrografica = false;
		/* 1247:1121 */this.validaZonaHidrografica = false;
		/* 1248:1122 */this.validaSbZonaHidrografica = false;
		/* 1249:1123 */this.validaGrupoNuevo = false;
		/* 1250: */}

	/* 1251: */
	/* 1252: */private void limpiarFiltroZonaH()
	/* 1253: */{
		/* 1254:1127 */this.selectedZonaHidrografica = "";
		/* 1255:1128 */this.selectedSbZonaHidrografica = "";
		/* 1256:1129 */this.itemsSbZonaHidrografica = new ArrayList();
		/* 1257:1130 */this.validaZonaHidrografica = false;
		/* 1258:1131 */this.validaSbZonaHidrografica = false;
		/* 1259:1132 */this.validaGrupoNuevo = false;
		/* 1260: */}

	/* 1261: */
	/* 1262: */private void limpiarFiltroSbZonaH()
	/* 1263: */{
		/* 1264:1136 */this.selectedSbZonaHidrografica = "";
		/* 1265:1137 */this.validaSbZonaHidrografica = false;
		/* 1266:1138 */this.validaGrupoNuevo = false;
		/* 1267: */}

	/* 1268: */
	/* 1269: */private void actualizaGuardado(ActionEvent e)
	/* 1270: */{
		/* 1271:1142 */limpiarFiltroAreaH();
		/* 1272:1143 */setVisibleNuevo(false);
		/* 1273:1144 */setVisibleEliminar(false);
		/* 1274:1145 */listaGruposPorAreaOperativa(e);
		/* 1275: */}

	/* 1276: */
	/* 1277: */public List<SelectItem> getItemsEstaciones()
	/* 1278: */{
		/* 1279:1149 */return this.itemsEstaciones;
		/* 1280: */}

	/* 1281: */
	/* 1282: */public List<ShmtEstacionBalanceQl> getItemsEstacionesVariable()
	/* 1283: */{
		/* 1284:1153 */return this.itemsEstacionesVariable;
		/* 1285: */}

	/* 1286: */
	/* 1287: */public List<SelectItem> getItemsEstacionesEnGrupo()
	/* 1288: */{
		/* 1289:1157 */return this.itemsEstacionesEnGrupo;
		/* 1290: */}

	/* 1291: */
	/* 1292: */public ListShmtEstacion getItemsEstacionesEnGrupoVariable()
	/* 1293: */{
		/* 1294:1161 */return this.itemsEstacionesEnGrupoVariable;
		/* 1295: */}

	/* 1296: */
	/* 1297: */public ShmtEstacionesList getItemsEstacionesBalanceCaudalList()
	/* 1298: */{
		/* 1299:1165 */if ((isValidaAop()) && (isBalance())
				&& (isValidaSbZonaBalance()) &&
				/* 1300:1166 */(isValidaSelectedGrupoBalance()))
		/* 1301: */{
			/* 1302:1167 */this.estacionesBalanceCaudalList = new ShmtEstacionesList();
			/* 1303:1168 */this.selectedDate2 = Utiles.getFechaFin();
			/* 1304:1169 */this.selectedDate1 = Utiles.getFechaInicio();
			/* 1305:1170 */this.estacionesBalanceCaudalList
					.setFechaInicio(this.selectedDate1);
			/* 1306:1171 */this.estacionesBalanceCaudalList
					.setFechaFin(this.selectedDate2);
			/* 1307:1172 */this.estacionesBalanceCaudalList
					.setCuenca(getIdSelectedCuenca());
			/* 1308:1173 */this.estacionesBalanceCaudalList.setAreaOperativa(
			/* 1309:1174 */Long.valueOf(getSelectedAreaOperativa()));
			/* 1310:1175 */this.estacionesBalanceCaudalList
					.setGrbcId(getIdSelectedGrupoBalance());
			/* 1311:1176 */setEstacionesBalanceCaudalList(this.estacionesBalanceCaudalList);
			/* 1312: */
			/* 1313:1178 */cargaSerie();
			/* 1314: */}
		/* 1315:1180 */return this.estacionesBalanceCaudalList;
		/* 1316: */}

	/* 1317: */
	/* 1318: */private static String[] getTicksPm()
	/* 1319: */{
		/* 1320:1184 */String[] toReturn = new String[11];
		/* 1321:1185 */for (int i = 10; i > 0; i--) {
			/* 1322:1186 */toReturn[(10 - i)] = Utiles.dosDigitos(MAX_PM
					/ 10.0D * (i + 1));
			/* 1323: */}
		/* 1324:1188 */toReturn[10] = 0.0 + "";
		/* 1325:1189 */return toReturn;
		/* 1326: */}

	/* 1327: */
	/* 1328: */private static String[] getTicksCdl()
	/* 1329: */{
		/* 1330:1193 */String[] toReturn = new String[11];
		/* 1331:1194 */toReturn[0] = "0,0";
		/* 1332:1195 */for (int i = 1; i <= 10; i++) {
			/* 1333:1196 */toReturn[i] = Utiles.dosDigitos(MAX_CDL / 10.0D * i);
			/* 1334: */}
		/* 1335:1199 */return toReturn;
		/* 1336: */}

	/* 1337: */
	/* 1338: */
	private List<CartesianSeries> cargaSerie()
	/* 1339: */{
		this.barData = new ArrayList();
		CartesianSeries serie = null;
		MAX_CDL = 0.0D;
		MAX_PM = 0.0D;
		List<ShmtDiarios> secuencia = null;
		this.estacionesNvl = this.estacionesBalanceCaudalList
				.getEstacionesNvl();

		ListTicks ticks = new ListTicks();

		ShmtDiarios.ValorUnitario[] arregloUnitario = null;
		int meses = Utiles.getMesesBalance();
		this.dias = Utiles.getDiasBalance();
		Long p = Long.valueOf(0L);
		int d = 0;
		int año = Utiles.getFechaFin().getYear() + 1900;
		int diasMes = 0;

		int it = Utiles.isPeriocidadAnual() ? 0 : Utiles.getMesBalance();
		meses = meses == 1 ? Utiles.getMesBalance() + 1 : meses;
		this.estacionesPm = this.estacionesBalanceCaudalList.getEstacionesPm();

		serie = new CartesianSeries();
		serie.setType(CartesianSeries.CartesianType.BAR);

		serie.setLabel("PRECIPITACI“N MEDIA CALCULADA (mm)");

		serie.setColor("black");

		serie.setYAxis(Integer.valueOf(2));
		serie.setXAxis(Integer.valueOf(2));
		serie.setPointLabels(Boolean.valueOf(true));
		serie.setShadow(Boolean.valueOf(true));
		serie.setLinePattern(LinePattern.DASHED);
		serie.setLineCap(LineCap.BUTT);
		serie.setPointLabels(Boolean.valueOf(true));
		serie.setPointLabelStacked(Boolean.valueOf(false));

		serie.setFillToZero(Boolean.valueOf(true));
		serie.setUseNegativeColors(Boolean.valueOf(true));
		serie.setDragConstraintAxis(DragConstraintAxis.X);
		serie.setHorizontalBar(Boolean.valueOf(false));

		Double totalPm = Double.valueOf(0.0D);
		int cestaciones = this.estacionesPm.size();
		this.mapaValoresDiariosEnEstacionDiaPrecipitacion = new Double[this.dias
				.size()][cestaciones + 1];
		p = Long.valueOf(0L);
		d = 0;
		ShmtEstacionBalanceQl estacion;
		Double v;
		for (int m = it; m < meses; m++) {
			diasMes = Utiles.getNumDiasdelMes(m, año);
			int dia = 0;
			while (dia < diasMes) {
				totalPm = Double.valueOf(0.0D);
				p = Long.valueOf(0L);
				for (Iterator localIterator = this.estacionesPm.iterator(); localIterator
						.hasNext();) {
					estacion = (ShmtEstacionBalanceQl) localIterator.next();
					secuencia = estacion.getSecuenciaDiarioPrecipitacion();
					estacion.setSeqNum(p);
					p = Long.valueOf(p.longValue() + 1L);
					if (secuencia.size() >= 12) {
						ShmtDiarios diario = (ShmtDiarios) secuencia.get(m);
						arregloUnitario = diario.arregloHorarios();
						ShmtDiarios.ValorUnitario valor = arregloUnitario[dia];
						v = valor.getValor();
						if (v == null) {
							v = Double.valueOf(0.0D);
						}
						if ((v != null) && (v.doubleValue() >= 0.0D)) {
							totalPm = Double.valueOf(totalPm.doubleValue()
									+ v.doubleValue()
									* estacion.getEgbqPeso().doubleValue());
							this.mapaValoresDiariosEnEstacionDiaPrecipitacion[d][(p
									.intValue() - 1)] = v;
						}
					}
				}
				if (totalPm.doubleValue() > MAX_PM) {
					MAX_PM = totalPm.doubleValue();
				}
				this.mapaValoresDiariosEnEstacionDiaPrecipitacion[d][cestaciones] = totalPm;
				dia++;
				d++;

				serie.add(Utiles.nombMes(m) + " / " + Utiles.dosDigitos(dia),
						totalPm);
			}
		}
		ShmtEstacionBalanceQl vmp = new ShmtEstacionBalanceQl("PRECIPITACI“N",
				"0", "MEDIA CALCULADA ", "", null, "19", null);
		vmp.setSeqNum(Long.valueOf(cestaciones));
		this.estacionesPm.add(vmp);

		this.barData.add(serie);

		secuencia = null;
		this.estacionesNvl = this.estacionesBalanceCaudalList
				.getEstacionesNvl();

		ticks = new ListTicks();

		arregloUnitario = null;
		meses = Utiles.getMesesBalance();
		this.dias = Utiles.getDiasBalance();

		meses = meses == 1 ? Utiles.getMesBalance() + 1 : meses;
		p = Long.valueOf(0L);
		this.mapaValoresDiariosEnEstacionDiaCaudal = new Double[this.dias
				.size()][this.estacionesNvl.size()];
		d = 0;
		año = Utiles.getFechaFin().getYear() + 1900;
		diasMes = 0;
		for (ShmtEstacionBalanceQl e : this.estacionesNvl) {
			e.setSeqNum(p);

			serie = new CartesianSeries();
			serie.setType(CartesianSeries.CartesianType.LINE);
			serie.setLabel(e.getEstacion().getCodCatalogoEs() + " "
					+ e.getEstacion().getNombrePma());

			serie.setLineCap(LineCap.BUTT);
			serie.setLineJoin(LineJoin.ROUND);
			serie.setLinePattern(LinePattern.SOLID);
			serie.setFillToZero(Boolean.valueOf(true));
			serie.setColor(this.colorSet[p.intValue()]);
			p = Long.valueOf(p.longValue() + 1L);
			secuencia = e.getSecuenciaDiarioCaudal();
			if (secuencia.size() > 0) {
				for (int m = it; m < meses; m++) {
					diasMes = Utiles.getNumDiasdelMes(m, año);
					ShmtDiarios diario = (ShmtDiarios) secuencia.get(m);
					ShmtDiarios.ValorUnitario[] arrayOfValorUnitario1;
					Double localDouble1 = (double) (arrayOfValorUnitario1 = diario
							.arregloHorarios()).length;
					for (v = 0.0; v < localDouble1; v++) {
						ShmtDiarios.ValorUnitario nu = arrayOfValorUnitario1[v
								.intValue()];
						ticks.add(nu.getDiaMes());
						int dia = nu.getDia();
						Double valor = nu.getValor();
						boolean dValido = nu.getI() <= diasMes;
						if ((dia > 0) && (dValido)) {
							if (valor != null) {
								MAX_CDL = Math.max(nu.getValor().doubleValue(),
										MAX_CDL);
							} else {
								valor = Double.valueOf(0.0D);
							}
							this.mapaValoresDiariosEnEstacionDiaCaudal[(dia - 1)][(p
									.intValue() - 1)] = valor;
							serie.add(nu.getDiaMes(), valor);
						}
					}
				}
				this.barData.add(serie);
			}
		}
		return this.barData;

		/* 1503: */}

	/* 1504: */
	/* 1505: */public List<SelectItem> getItemsGruposBalanceCaudal()
	/* 1506: */{
		/* 1507:1364 */List<SelectItem> s = new ArrayList<SelectItem>();
		/* 1508:1365 */String codigo = getSelectedAreaOperativa();
		/* 1509:1366 */if (isValidaAop()) {
			/* 1510:1367 */if (isGrupos())
			/* 1511: */{
				/* 1512:1368 */setItemsGruposBalanceCaudal(
				/* 1513:1369 */ShmtGrupoBalanceCaudal
						.obtenerGruposAreasOperativas(codigo));
				/* 1514:1370 */if ((this.itemsGruposBalanceCaudal != null) &&
				/* 1515:1371 */(this.itemsGruposBalanceCaudal.size() >= 1))
				/* 1516: */{
					String grafoEx = "";
					/* 1517:1372 */String grafo = ((ShmtGrupoBalanceCaudal) this.itemsGruposBalanceCaudal
							.get(0))
					/* 1518:1373 */.getGrbcGrafo();
					for (String ex : extensionsNames) {
						if (grafo.contains(ex)) {
							grafoEx = ex;
							break;
						}
					}
					/* 1519:1374 */if (grafo != null) {
						/* 1520:1375 */extraerArchivo(grafo, grafoEx);
						/* 1521: */}
					/* 1522: */}
				/* 1523: */}
			/* 1524:1380 */else if (isBalance())
			/* 1525: */{
				/* 1526:1381 */setItemsGruposBalanceCaudal(
				/* 1527:1382 */ShmtGrupoBalanceCaudal.obtenerGruposAreasCuenca(
						codigo, getIdSelectedCuenca()
						/* 1528:1383 */.getCuencaHidrograficaId().toString()));
				/* 1529: */}
			/* 1530: */}
		/* 1531:1386 */if ((this.itemsGruposBalanceCaudal != null) &&
		/* 1532:1387 */(this.itemsGruposBalanceCaudal.size() >= 1))
		/* 1533: */{
			/* 1534:1388 */if (isGrupos()) {
				/* 1535:1389 */setVisibleTabla(true);
				/* 1536: */}
			/* 1537:1391 */for (ShmtGrupoBalanceCaudal gbc : this.itemsGruposBalanceCaudal)
			/* 1538: */{
				/* 1539:1392 */String a1 = ObjectUtils
						.toString(gbc.getGrbcId());
				/* 1540:1393 */String a2 = ObjectUtils.toString(gbc
						.getNameDisplay());
				/* 1541:1394 */s.add(new SelectItem(a1, a2));
				/* 1542: */}
			/* 1543: */}
		/* 1544:1398 */return s;
		/* 1545: */}

	/* 1546: */
	/* 1547: */public List<ShmtGrupoBalanceCaudal> getGruposBalanceCaudal()
	/* 1548: */{
		/* 1549:1402 */return this.itemsGruposBalanceCaudal;
		/* 1550: */}

	/* 1551: */
	/* 1552: */private boolean isValidaAop()
	/* 1553: */{
		/* 1554:1406 */if (getAreaOperativa().getValue().equals("")) {
			/* 1555:1407 */return false;
			/* 1556: */}
		/* 1557:1409 */if (getAreaOperativa().getValue().equals("------")) {
			/* 1558:1410 */return false;
			/* 1559: */}
		/* 1560:1412 */return true;
		/* 1561: */}

	/* 1562: */
	/* 1563: */private boolean isValidaSbZonaBalance()
	/* 1564: */{
		/* 1565:1416 */if (getIdSelectedCuenca() == null) {
			/* 1566:1417 */return false;
			/* 1567: */}
		/* 1568:1419 */return true;
		/* 1569: */}

	/* 1570: */
	/* 1571: */private boolean isValidaSelectedGrupoBalance()
	/* 1572: */{
		/* 1573:1423 */if (0L > getIdSelectedGrupoBalance().longValue()) {
			/* 1574:1424 */return false;
			/* 1575: */}
		/* 1576:1426 */return true;
		/* 1577: */}

	/* 1578: */
	/* 1579: */public List<SelectItem> getItemsAreaOpera()
	/* 1580: */{
		/* 1581:1430 */if (this.itemsAreaOpera == null) {
			/* 1582:1431 */cargaItemsAreaOpera();
			/* 1583: */}
		/* 1584:1433 */return this.itemsAreaOpera;
		/* 1585: */}

	/* 1586: */
	/* 1587: */void cargaItemsAreaOpera()
	/* 1588: */{
		/* 1589:1437 */setItemsAreaOpera(new ArrayList());
		/* 1590:1438 */List<Object[]> areasOperativas = SioOrganizacion
				.obtenerAreOperat();
		/* 1591:1439 */if (areasOperativas.size() >= 1) {
			/* 1592:1440 */for (Object[] objects : areasOperativas)
			/* 1593: */{
				/* 1594:1441 */String a1 = ObjectUtils.toString(objects[0]);
				/* 1595:1442 */String a2 = ObjectUtils.toString(objects[1]);
				/* 1596:1443 */this.itemsAreaOpera.add(new SelectItem(a1, a2));
				/* 1597: */}
			/* 1598: */}
		/* 1599: */}

	/* 1600: */
	/* 1601: */public void setItemsAreaOpera(List<SelectItem> itemsAreaOpera)
	/* 1602: */{
		/* 1603:1449 */this.itemsAreaOpera = itemsAreaOpera;
		/* 1604: */}

	/* 1605: */
	/* 1606: */public List<SelectItem> getItemsVariables()
	/* 1607: */{
		/* 1608:1453 */List<SelectItem> s = new ArrayList();
		/* 1609:1454 */s.add(new SelectItem(
				NombresTitulosAplicacion.NIVEL.nombreTitulo,
				/* 1610:1455 */"NIVEL"));
		/* 1611:1456 */s.add(new SelectItem(
		/* 1612:1457 */NombresTitulosAplicacion.PRECIPITACION.nombreTitulo,
		/* 1613:1458 */"PRECIPITACI“N"));
		/* 1614:1459 */return s;
		/* 1615: */}

	/* 1616: */
	/* 1617: */public List<SelectItem> getItemsPeriocidad()
	/* 1618: */{
		/* 1619:1463 */List<SelectItem> s = new ArrayList();
		/* 1620:1464 */s.add(new SelectItem(
				NombresTitulosAplicacion.ANUAL.nombreTitulo,
				/* 1621:1465 */"ANUAL"));
		/* 1622:1466 */s.add(new SelectItem(
				NombresTitulosAplicacion.MENSUAL.nombreTitulo,
				/* 1623:1467 */"MENSUAL"));
		/* 1624:1468 */return s;
		/* 1625: */}

	/* 1626: */
	/* 1627: */public List<SelectItem> getItemsCuencasHidrograficas()
	/* 1628: */{
		/* 1629:1472 */List<SelectItem> s = new ArrayList();
		/* 1630:1473 */List<Object[]> areasOperativas =
		/* 1631:1474 */SioCuencasHidrograficas.obtenerCuencaHidrograf();
		/* 1632:1475 */if (areasOperativas.size() >= 1) {
			/* 1633:1476 */for (Object[] objects : areasOperativas)
			/* 1634: */{
				/* 1635:1477 */String a1 = ObjectUtils.toString(objects[0]);
				/* 1636:1478 */String a2 = ObjectUtils.toString(objects[1]);
				/* 1637:1479 */s.add(new SelectItem(a1, a2));
				/* 1638: */}
			/* 1639: */}
		/* 1640:1482 */return s;
		/* 1641: */}

	/* 1642: */
	/* 1643: */public List<SelectItem> getItemsSbZCuencasHidrograficas()
	/* 1644: */{
		/* 1645:1486 */List<SelectItem> s = new ArrayList();
		/* 1646:1487 */List<Object[]> areasOperativas =
		/* 1647:1488 */SioCuencasHidrograficas.obtenerSbZCuencaHidrograf();
		/* 1648:1489 */if (areasOperativas.size() >= 1) {
			/* 1649:1490 */for (Object[] objects : areasOperativas)
			/* 1650: */{
				/* 1651:1491 */String a1 = ObjectUtils.toString(objects[0]);
				/* 1652:1492 */String a2 = ObjectUtils.toString(objects[1]);
				/* 1653:1493 */s.add(new SelectItem(a1, a2));
				/* 1654: */}
			/* 1655: */}
		/* 1656:1496 */return s;
		/* 1657: */}

	/* 1658: */
	/* 1659: */public List<SelectItem> getItemsSbZCuencasHidrograficasAop()
	/* 1660: */{
		/* 1661:1500 */List<SelectItem> s = new ArrayList();
		/* 1662:1501 */List<Object[]> areasOperativas =
		/* 1663:1502 */SioCuencasHidrograficas
				.obtenerSbZCuencaHidrografAop(getSelectedAreaOperativaInput());
		/* 1664:1503 */if (areasOperativas.size() >= 1) {
			/* 1665:1504 */for (Object[] objects : areasOperativas)
			/* 1666: */{
				/* 1667:1505 */String a1 = ObjectUtils.toString(objects[0]);
				/* 1668:1506 */String a2 = ObjectUtils.toString(objects[1]);
				/* 1669:1507 */s.add(new SelectItem(a1, a2));
				/* 1670: */}
			/* 1671: */}
		/* 1672:1510 */return s;
		/* 1673: */}

	/* 1674: */
	/* 1675: */public List<SelectItem> getItemsAreaHidrografica()
	/* 1676: */{
		/* 1677:1514 */return this.itemsAreaHidrografica;
		/* 1678: */}

	/* 1679: */
	/* 1680: */public List<SelectItem> getItemsZonasPorAreaHidrografica()
	/* 1681: */{
		/* 1682:1518 */return this.itemsZonaHidrografica;
		/* 1683: */}

	/* 1684: */
	/* 1685: */public List<SelectItem> getItemsSubZonasHidrografica()
	/* 1686: */{
		/* 1687:1522 */return this.itemsSbZonaHidrografica;
		/* 1688: */}

	/* 1689: */
	/* 1690: */public List<SelectItem> getItemsGruposBalanceAreaCuenca()
	/* 1691: */{
		/* 1692:1526 */return this.itemsGruposBalanceAreaCuenca;
		/* 1693: */}

	/* 1694: */
	/* 1695: */public List<Fecha> getDias()
	/* 1696: */{
		/* 1697:1530 */return this.dias;
		/* 1698: */}

	/* 1699: */
	/* 1700: */public void setDias(List<Fecha> dias)
	/* 1701: */{
		/* 1702:1534 */this.dias = dias;
		/* 1703: */}

	/* 1704: */
	/* 1705: */public List<SelectItem> getItemsAños()
	/* 1706: */{
		/* 1707:1538 */List<SelectItem> s = new ArrayList();
		/* 1708:1539 */Object[] años = Utiles.getAños();
		/* 1709:1540 */if (años.length >= 1) {
			/* 1710:1541 */for (Object strings : años)
			/* 1711: */{
				/* 1712:1542 */String a1 = ObjectUtils.toString(strings
						.toString());
				/* 1713:1543 */s.add(new SelectItem(a1, a1));
				/* 1714: */}
			/* 1715: */}
		/* 1716:1546 */return s;
		/* 1717: */}

	/* 1718: */
	/* 1719: */public List<SelectItem> getItemsMeses()
	/* 1720: */{
		/* 1721:1550 */List<SelectItem> s = new ArrayList();
		/* 1722:1551 */Object[] años = Utiles.getAños();
		/* 1723:1552 */if (años.length >= 1) {
			/* 1724:1553 */for (Object strings : años)
			/* 1725: */{
				/* 1726:1554 */String a1 = ObjectUtils.toString(strings
						.toString());
				/* 1727:1555 */s.add(new SelectItem(a1, a1));
				/* 1728: */}
			/* 1729: */}
		/* 1730:1558 */return s;
		/* 1731: */}

	/* 1732: */
	/* 1733: */public List<SelectItem> getItemsGruposBalanceArea()
	/* 1734: */{
		/* 1735:1562 */List<ShmtGrupoBalanceCaudal> itemsGrupos = getGruposBalanceCaudal();
		/* 1736:1563 */List<SelectItem> s = new ArrayList();
		/* 1737:1564 */if ((itemsGrupos != null) &&
		/* 1738:1565 */(itemsGrupos.size() >= 1)) {
			/* 1739:1566 */for (ShmtGrupoBalanceCaudal objects : itemsGrupos)
			/* 1740: */{
				/* 1741:1567 */String a1 = ObjectUtils.toString(objects
						.getGrbcId());
				/* 1742:1568 */String a2 = ObjectUtils.toString(objects
						.getNameDisplay());
				/* 1743:1569 */s.add(new SelectItem(a1, a2));
				/* 1744: */}
			/* 1745: */}
		/* 1746:1574 */return s;
		/* 1747: */}

	/* 1748: */
	/* 1749: */public List<SelectItem> getItemsEstacionesEnGruposBalanceArea()
	/* 1750: */{
		/* 1751:1578 */List<ShmtEstacionBalanceQl> itemsGrupos = getGruposBalanceCaudal(getIdSelectedGrupoBorrado()
		/* 1752:1579 */.toString());
		/* 1753:1580 */List<SelectItem> s = new ArrayList();
		/* 1754:1581 */if ((itemsGrupos != null) &&
		/* 1755:1582 */(itemsGrupos.size() >= 1)) {
			/* 1756:1583 */for (ShmtEstacionBalanceQl objects : itemsGrupos)
			/* 1757: */{
				/* 1758:1584 */String a1 = ObjectUtils.toString(objects
						.getEgbqId());
				/* 1759:1585 */String a2 = ObjectUtils.toString(objects
						.getEstacion()
						/* 1760:1586 */.getCodCatalogoEs() +
				/* 1761:1587 */" " +
				/* 1762:1588 */objects.getEstacion().getNombrePma());
				/* 1763:1589 */s.add(new SelectItem(a1, a2));
				/* 1764: */}
			/* 1765: */}
		/* 1766:1594 */return s;
		/* 1767: */}

	/* 1768: */
	/* 1769: */private List<ShmtEstacionBalanceQl> getGruposBalanceCaudal(
			String selectedGrupo)
	/* 1770: */{
		/* 1771:1599 */List<ShmtEstacionBalanceQl> estaciones = null;
		/* 1772:1600 */for (ShmtGrupoBalanceCaudal grupo : getGruposBalanceCaudal()) {
			/* 1773:1601 */if (grupo.getGrbcId().toString()
					.equals(selectedGrupo)) {
				/* 1774:1602 */estaciones = grupo.getEstaciones();
				/* 1775: */}
			/* 1776: */}
		/* 1777:1605 */return estaciones;
		/* 1778: */}

	/* 1779: */
	/* 1780: */public String getUsuario()
	/* 1781: */{
		/* 1782:1609 */return this.usuario;
		/* 1783: */}

	/* 1784: */
	/* 1785: */public void setUsuario(String usuario)
	/* 1786: */{
		/* 1787:1613 */this.usuario = usuario;
		/* 1788: */}

	/* 1789: */
	/* 1790: */public String getEstado()
	/* 1791: */{
		/* 1792:1617 */return this.estado;
		/* 1793: */}

	/* 1794: */
	/* 1795: */public void setEstado(String estado)
	/* 1796: */{
		/* 1797:1621 */this.estado = estado;
		/* 1798: */}

	/* 1799: */
	/* 1800: */public String getNuevoVariable()
	/* 1801: */{
		/* 1802:1625 */return this.nuevoVariable;
		/* 1803: */}

	/* 1804: */
	/* 1805: */public void setNuevoVariable(String nuevoVariable)
	/* 1806: */{
		/* 1807:1629 */if (!this.nuevoVariable.equals(nuevoVariable))
		/* 1808: */{
			/* 1809:1630 */this.nuevoVariable = nuevoVariable;
			/* 1810:1631 */actualizaEstacionesIncluir();
			/* 1811: */}
		/* 1812: */}

	/* 1813: */
	/* 1814: */public String getPeriocidad()
	/* 1815: */{
		/* 1816:1636 */return this.periocidad;
		/* 1817: */}

	/* 1818: */
	/* 1819: */public void setPeriocidad(String periocidad)
	/* 1820: */{
		/* 1821:1640 */this.periocidad = periocidad;
		/* 1822: */}

	/* 1823: */
	/* 1824: */public Dialog getClientDialog()
	/* 1825: */{
		/* 1826:1644 */return this.clientDialog;
		/* 1827: */}

	/* 1828: */
	/* 1829: */public void setClientDialog(Dialog clientDialog)
	/* 1830: */{
		/* 1831:1648 */this.clientDialog = clientDialog;
		/* 1832: */}

	/* 1833: */
	/* 1834: */public void limparImagen(ActionEvent e)
	/* 1835: */{
		/* 1836:1652 */this.nuevoGrafo.getFile().delete();
		/* 1837: */}

	/* 1838: */
	/* 1839: */public void guardarEvent(ActionEvent e)
	/* 1840: */{
		/* 1841:1656 */UIComponent boton = e.getComponent();
		/* 1842:1658 */if (isVisibleNuevo().booleanValue()) {
			/* 1843:1659 */if (!isGrupoNuevo())
			/* 1844: */{
				/* 1845:1660 */log.debug(Integer
						.valueOf(this.itemsEstacionesEnGrupoVariable.size()));
				/* 1846: */try
				/* 1847: */{
					/* 1848:1663 */if (this.itemsEstacionesEnGrupoVariable
							.pesoConjunto().doubleValue() > 1.0D)
					/* 1849: */{
						/* 1850:1665 */context()
								.addMessage(
										/* 1851:1666 */boton.getClientId(),
										/* 1852:1667 */new FacesMessage(
												severityNames[0],
												/* 1853:1668 */"Peso conjunto de las estaciones asociadas no debe superar el valor 1"));
						/* 1854:1669 */return;
						/* 1855: */}
					/* 1856:1671 */HibernateSessionFactory
							.saveOrUpdate(this.itemsEstacionesEnGrupoVariable
									.toArray());
					/* 1857: */
					/* 1858:1673 */context().addMessage(
					/* 1859:1674 */boton.getClientId(),
					/* 1860:1675 */new FacesMessage(severityNames[0],
					/* 1861:1676 */"Datos salvados con ©xito"));
					/* 1862: */}
				/* 1863: */catch (Throwable ex)
				/* 1864: */{
					/* 1865:1678 */ex.printStackTrace();
					/* 1866:1679 */context().addMessage(
					/* 1867:1680 */boton.getClientId(),
					/* 1868:1681 */new FacesMessage(severityNames[2],
					/* 1869:1682 */"Error al salvar los datos!"));
					/* 1870: */}
				/* 1871:1684 */actualizaEstacionesExcluir();
				/* 1872:1685 */actualizaEstacionesIncluir();
				/* 1873: */}
			/* 1874:1686 */else if (isGrupoNuevo())
			/* 1875: */{
				/* 1876:1687 */Object[] cuenca = null;
				/* 1877: */try
				/* 1878: */{
					/* 1879:1689 */cuenca = ZonificacionHidrografica
							.obtenerZona(
							/* 1880:1690 */Long
									.valueOf(getSelectedSbZonaHidrografica()));
					/* 1881: */}
				/* 1882: */catch (Exception ex)
				/* 1883: */{
					/* 1884:1693 */context()
							.addMessage(
									/* 1885:1694 */boton.getClientId(),
									/* 1886:1695 */new FacesMessage(
											severityNames[2],
											/* 1887:1696 */"Error: Debe seleccionar una SubZona v¡lida!"));
					/* 1888:1697 */return;
					/* 1889: */}
				/* 1890:1699 */SioCuencasHidrograficas nuevaCuenca = new SioCuencasHidrograficas();
				/* 1891:1700 */Long numero = null;
				/* 1892: */try
				/* 1893: */{
					/* 1894:1702 */numero = getNumeroSelectedGrupo();
					/* 1895: */}
				/* 1896: */catch (Exception ex)
				/* 1897: */{
					/* 1898:1704 */context().addMessage(
					/* 1899:1705 */boton.getClientId(),
					/* 1900:1706 */new FacesMessage(severityNames[2],
					/* 1901:1707 */"Error: Debe ser un nºmero!"));
					/* 1902:1708 */return;
					/* 1903: */}
				/* 1904:1710 */String fileName = " ";
				/* 1905: */try
				/* 1906: */{
					String ex = this.nuevoGrafo.getFileExtension();
					/* 1907:1712 */fileName =
					/* 1908: */
					/* 1909:1714 */getSelectedAreaOperativa() + "_"
							+ getSelectedSbZonaHidrograficaId() + "_" + numero
							+ ex;
					/* 1910:1715 */File parent = this.nuevoGrafo.getFile()
							.getParentFile();
					String parentSep = String.valueOf(File.separatorChar);
					String parentPath = parent.getPath().contains(
							"JBOSS-INSTANCES") ? (parentSep + "tmp" + parentSep)
							: parent.getPath();
					/* 1911:1716 */File nFile = new File(parentPath, fileName);
					// /* 1912:1717 */boolean delete = nFile.delete();
					/* 1913:1718 */boolean rename = this.nuevoGrafo.getFile()
							.renameTo(nFile);
					/* 1914: */
					/* 1915:1720 */log.debug("RENAME : " + rename + " ");
					log.debug("RENAME : " + rename + " ");
					/* 1916:1721 */this.nuevoGrafo.setFile(nFile);
					this.nuevoGrafo.setFileExtension(ex);
					/* 1917:1722 */this.nuevoGrafo.setFileName(fileName);
					/* 1918: */}
				/* 1919: */catch (Exception ex)
				/* 1920: */{
					/* 1921:1724 */context().addMessage(
					/* 1922:1725 */boton.getClientId(),
					/* 1923:1726 */new FacesMessage(severityNames[1],
					/* 1924:1727 */"No ha cargado la imagen!"));
					/* 1925: */}
				/* 1926:1730 */nuevaCuenca.setCuencaHidrograficaId(Long
						.valueOf(cuenca[1]
						/* 1927:1731 */.toString()));
				/* 1928:1732 */ShmtGrupoBalanceCaudal nvBalance = null;
				/* 1929: */try
				/* 1930: */{
					/* 1931:1734 */nvBalance = ShmtGrupoBalanceCaudal
							.obtenerGrupo(
							/* 1932:1735 */getSelectedAreaOperativa(),
							/* 1933:1736 */nuevaCuenca
									.getCuencaHidrograficaId(), numero);
					/* 1934: */}
				/* 1935: */catch (Exception e1)
				/* 1936: */{
					/* 1937:1738 */e1.printStackTrace();
					/* 1938: */}
				/* 1939:1740 */nvBalance = nvBalance == null ? new ShmtGrupoBalanceCaudal(
				/* 1940:1741 */getSelectedAreaOperativa(), nuevaCuenca, numero,
				/* 1941:1742 */fileName, this.usuario)
						: nvBalance;
				/* 1942:1743 */nvBalance.setGrbcGrafo(fileName);
				/* 1943:1744 */List<ShmtGrupoBalanceCaudal> grupos = new ArrayList();
				/* 1944:1745 */ShmtEstacionBalanceQl esta = new ShmtEstacionBalanceQl();
				/* 1945:1746 */List<ShmtEstacionBalanceQl> estaciones = new ArrayList();
				/* 1946:1747 */estaciones.add(esta);
				/* 1947:1748 */nvBalance.setEstaciones(estaciones);
				/* 1948:1749 */grupos.add(nvBalance);
				/* 1949: */try
				/* 1950: */{
					/* 1951:1751 */HibernateSessionFactory.saveOrUpdate(grupos
							.toArray());
					/* 1952:1752 */context().addMessage(
					/* 1953:1753 */boton.getClientId(),
					/* 1954:1754 */new FacesMessage(severityNames[0],
					/* 1955:1755 */"Datos salvados con ©xito!"));
					/* 1956: */}
				/* 1957: */catch (Throwable ex)
				/* 1958: */{
					/* 1959:1757 */ex.printStackTrace();
					/* 1960:1758 */context().addMessage(
					/* 1961:1759 */boton.getClientId(),
					/* 1962:1760 */new FacesMessage(severityNames[2],
					/* 1963:1761 */"Error al salvar los datos!"));
					/* 1964:1762 */return;
					/* 1965: */}
				/* 1966: */try
				/* 1967: */{
					/* 1968:1765 */if (this.nuevoGrafo != null)
					/* 1969: */{
						/* 1970:1766 */HmstPath p =
						/* 1971:1767 */HmstPath
								.obtenerDirectoriosFtp(NombresTitulosAplicacion.PATH_COMPONENTE.nombreTitulo);
						/* 1972: */
						/* 1973:1769 */BartTransfer bt = new BartTransfer(
								p.getPathServer(),
								/* 1974:1770 */p.getPathUserFtp(),
								p.getPathPassword());
						/* 1975:1771 */log.debug(this.nuevoGrafo
								.getFileExtension()
								+
								/* 1976:1772 */" name: "
								+ this.nuevoGrafo.getFileName()
								+
								/* 1977:1773 */" path: "
								+
								/* 1978:1774 */this.nuevoGrafo.getFile()
										.getCanonicalPath());
						/* 1979:1775 */boolean edit = bt
								.eliminarImagen(fileName);
						/* 1980:1776 */log.debug("edit image : " + edit);
						/* 1981:1777 */bt.enviarImagen(this.nuevoGrafo);
						/* 1982:1778 */this.nuevoGrafo.getFile().delete();
						/* 1983:1779 */this.nuevoGrafo = new Archivo();
						/* 1984: */}
					/* 1985: */}
				/* 1986: */catch (Exception e1)
				/* 1987: */{
					/* 1988:1782 */e1.printStackTrace();
					/* 1989:1783 */context().addMessage(
					/* 1990:1784 */boton.getClientId(),
					/* 1991:1785 */new FacesMessage(severityNames[2],
					/* 1992:1786 */"Error al salvar la imagen!"));
					/* 1993: */}
				/* 1994: */}
			/* 1995: */}
		/* 1996:1792 */actualizaGuardado(e);
		/* 1997: */}

	/* 1998: */
	/* 1999: */private Long getNumeroSelectedGrupo()
	/* 2000: */throws Exception
	/* 2001: */{
		/* 2002:1796 */Long number = getNumberSelectedGrupo();
		/* 2003:1797 */return Long.valueOf(number.longValue() < 0L ? Long
				.parseLong(this.selectedGrupo) : number.longValue());
		/* 2004: */}

	/* 2005: */
	/* 2006: */public void action_carga(ActionEvent e)
	/* 2007: */{
		/* 2008:1801 */FileEntry inputFile = (FileEntry) e.getSource();
		/* 2009:1802 */FileEntryResults.FileInfo fileInfo =
		/* 2010:1803 */(FileEntryResults.FileInfo) inputFile.getResults()
				.getFiles().get(0);
		/* 2011:1804 */this.nuevoGrafo = new Archivo(fileInfo);
		/* 2012: */}

	/* 2013: */
	/* 2014: */public void loadListener(FileEntryEvent e)
	/* 2015: */{
		/* 2016:1808 */FileEntry fe = (FileEntry) e.getComponent();
		/* 2017:1809 */FileEntryResults results = fe.getResults();
		/* 2018:1810 */File parent = null;
		/* 2019:1811 */this.nuevoGrafo = new Archivo();
		String ex = "";
		/* 2020:1812 */UIComponent boton = e.getComponent();
		/* 2021:1813 */for (FileEntryResults.FileInfo i : results.getFiles()) {
			/* 2022:1814 */if (i.isSaved())
			/* 2023: */{
				/* 2024:1815 */File file = i.getFile();
				/* 2025:1816 */if (file != null)
				/* 2026: */{
					/* 2027:1817 */parent = file.getParentFile();
					ex = /* 2028:1818 */cargaExtension(file);
					/* 2029: */}
				/* 2030: */}
			/* 2031: */}
		/* 2032:1823 */if (parent != null)
		/* 2033: */{
			/* 2034:1824 */long dirSize = 0L;
			/* 2035:1825 */int fileCount = 0;
			/* 2036:1826 */for (File file : parent.listFiles())
			/* 2037: */{
				/* 2038:1827 */fileCount++;
				/* 2039:1828 */dirSize += file.length();
				/* 2040:1829 */this.nuevoGrafo.setFile(file);
				this.nuevoGrafo.setFileExtension(ex);
				/* 2041: */}
			/* 2042:1831 */context().addMessage(
			/* 2043:1832 */boton.getClientId(),
			/* 2044:1833 */new FacesMessage(severityNames[0],
			/* 2045:1834 */"Archivo cargado exitosamente."));
			/* 2046:1835 */log.debug(" " + dirSize + " " + fileCount);
			/* 2047: */}
		/* 2048: */else
		/* 2049: */{
			/* 2050:1837 */context().addMessage(
					boton.getClientId(),
					/* 2051:1838 */new FacesMessage(severityNames[2],
							"Extension no v¡lida."));
			/* 2052: */}
		/* 2053: */}

	/* 2054: */
	/* 2055: */private final void cargaExtension(String file)
	/* 2056: */{
		/* 2057:1844 */for (String ex : extensionsNames) {
			/* 2058:1845 */if (file.toUpperCase().contains(ex))
			/* 2059: */{
				/* 2060:1846 */this.nuevoGrafo.setFileExtension(ex);
				/* 2061:1847 */this.nuevoGrafo.setFileName(file);
				/* 2062: */}
			/* 2063: */}
		/* 2064: */}

	/* 2065: */
	/* 2066: */private String cargaExtension(File file)
	/* 2067: */{
		/* 2068:1854 */for (String ex : extensionsNames) {
			/* 2069:1855 */if (file.getName().toUpperCase().contains(ex))
			/* 2070: */{
				/* 2071:1856 */this.nuevoGrafo.setFileExtension(ex);
				/* 2072:1857 */this.nuevoGrafo.setFileName(file.getName());
				return ex;
				/* 2073: */}
			/* 2074: */}
		return ".null";
		/* 2075: */}

	/* 2076: */
	/* 2077: */public static FacesContext context()
	/* 2078: */{
		/* 2079:1864 */return FacesContext.getCurrentInstance();
		/* 2080: */}

	/* 2081: */
	/* 2082: */public boolean isInicializar()
	/* 2083: */{
		/* 2084:1868 */return HibernateSessionFactory.currentSession()
		/* 2085:1869 */.createSQLQuery("SELECT 1 FROM DUAL").uniqueResult() != null;
		/* 2086: */}

	/* 2087: */
	/* 2088: */@PostConstruct
	/* 2089: */public void init()
	/* 2090: */{
		/* 2091:1875 */String method = ((HttpServletRequest) context()
				.getExternalContext()
				/* 2092:1876 */.getRequest()).getMethod();

		/* 2098:1884 */if (method.equals("GET")) {
			cargarBACK();
			/* 2099:1885 */limpiar();
			/* 2100: */}
		/* 2101:1888 */log.debug("init() : " + method);
		/* 2102: */}

	private static void cargarBACK() {
		HttpServletRequest origRequest = (HttpServletRequest) FacesContext
				.getCurrentInstance().getExternalContext().getRequest();
		String referrer = origRequest.getHeader("referer");
		log.debug(referrer);
		// log.debug(origRequest.getRequestURL());
		// log.debug(origRequest.getScheme());
		// log.debug(origRequest.getServerName());
		// log.debug(origRequest.getServerPort());
		// log.debug(origRequest.getContextPath());
		// log.debug(origRequest.getServletPath());
		// log.debug(origRequest.getPathInfo());
		// log.debug(origRequest.getQueryString());
		if (referrer != null) {
			FacadeBean.BACK = referrer;
		}
	}

	/* 2103: */
	/* 2104: */public void actualizaEstacionesExcluir()
	/* 2105: */{
		/* 2106:1893 */this.itemsEstacionesEnGrupo = new ArrayList();
		/* 2107:1894 */this.itemsEstacionesEnGrupoVariable = new ListShmtEstacion();
		/* 2108:1895 */if ((getNuevoVariable() == null)
				|| (getNuevoVariable() == "")) {
			/* 2109:1896 */return;
			/* 2110: */}
		/* 2111:1897 */if (getSelectedGrupoBalance() == null) {
			/* 2112:1898 */return;
			/* 2113: */}
		/* 2114:1899 */Long cuencaH = getSelectedGrupoBalance().getCuenca()
		/* 2115:1900 */.getCuencaHidrograficaId();
		/* 2116:1901 */cuencaH =
		/* 2117:1902 */Long.valueOf(Long.parseLong(ZonificacionHidrografica
				.obtenerZona(cuencaH)[3]
		/* 2118:1903 */.toString()));
		/* 2119:1904 */Long zonaH = getSelectedGrupoBalance().getCuenca()
				.getCuencaPadreId();
		/* 2120:1905 */zonaH = Long.valueOf(Long
				.parseLong(ZonificacionHidrografica.obtenerZona(zonaH)[3]
				/* 2121:1906 */.toString()));
		/* 2122:1907 */Object[] zona = ZonificacionHidrografica
				.obtenerZona(zonaH);
		/* 2123:1908 */Long areaH = Long.valueOf(zona[1].toString());
		/* 2124:1909 */String variable = getNuevoVariable();
		/* 2125: */
		/* 2126:1911 */Long selectedGrupoId = getSelectedGrupoBalance()
				.getGrbcId();
		/* 2127:1912 */List<ShmtEstacionBalanceQl> itemsGrupos = getGruposBalanceCaudal(selectedGrupoId
		/* 2128:1913 */.toString());
		/* 2129:1915 */if ((itemsGrupos != null) &&
		/* 2130:1916 */(itemsGrupos.size() >= 1)) {
			/* 2131:1917 */for (ShmtEstacionBalanceQl estacion : itemsGrupos)
			/* 2132: */{
				/* 2133:1918 */String a1 = ObjectUtils.toString(estacion
						.getEgbqId());
				/* 2134:1919 */String a2 = ObjectUtils.toString(estacion
						.getEstacion()
						/* 2135:1920 */.getCodCatalogoEs() +
				/* 2136:1921 */" " +
				/* 2137:1922 */estacion.getEstacion().getNombrePma());
				/* 2138:1923 */this.itemsEstacionesEnGrupo.add(new SelectItem(
						a1, a2));
				/* 2139:1924 */this.itemsEstacionesEnGrupoVariable
						.add(estacion);
				/* 2140: */}
			/* 2141: */}
		/* 2142: */}

	/* 2143: */
	/* 2144: */public void actualizaEstacionesIncluir()
	/* 2145: */{
		/* 2146:1932 */this.itemsEstaciones = new ArrayList();
		/* 2147:1933 */this.itemsEstacionesVariable = new ArrayList();
		/* 2148:1935 */if ((getNuevoVariable() == null)
				|| (getNuevoVariable() == "")) {
			/* 2149:1936 */return;
			/* 2150: */}
		/* 2151:1937 */if (getSelectedGrupoBalance() == null) {
			/* 2152:1938 */return;
			/* 2153: */}
		/* 2154:1939 */Long cuencaH = getSelectedGrupoBalance().getCuenca()
		/* 2155:1940 */.getCuencaHidrograficaId();
		/* 2156:1941 */cuencaH =
		/* 2157:1942 */Long.valueOf(Long.parseLong(ZonificacionHidrografica
				.obtenerZona(cuencaH)[3]
		/* 2158:1943 */.toString()));
		/* 2159:1944 */Long zonaH = getSelectedGrupoBalance().getCuenca()
				.getCuencaPadreId();
		/* 2160:1945 */Object[] cuencaZH = ZonificacionHidrografica
				.obtenerZona(zonaH);
		/* 2161:1946 */zonaH = Long.valueOf(cuencaZH[3].toString());
		/* 2162: */
		/* 2163:1948 */Long areaH = Long.valueOf(cuencaZH[2].toString());
		/* 2164:1949 */String variable = getNuevoVariable();
		/* 2165: */
		/* 2166:1951 */List<Object[]> items = SiovEstacionesId
				.obtenerEstaciones(areaH,
				/* 2167:1952 */zonaH, cuencaH, variable,
						getSelectedGrupoBalance().getGrbcId()
						/* 2168:1953 */.toString());
		/* 2169:1954 */Long grupo = getSelectedGrupoBalance().getGrbcId();
		/* 2170: */
		/* 2171:1956 */Long tipoEstacion = getTipoVariable();
		/* 2172:1958 */if ((items != null) &&
		/* 2173:1959 */(items.size() >= 1)) {
			/* 2174:1960 */for (Object[] estacion : items)
			/* 2175: */{
				/* 2176:1961 */String a1 = ObjectUtils.toString(estacion[2]);
				/* 2177:1962 */String a2 = ObjectUtils.toString(estacion[3]
						+ " " +
						/* 2178:1963 */estacion[0]);
				/* 2179: */
				/* 2180:1965 */this.itemsEstaciones.add(new SelectItem(a1, a2));
				/* 2181:1966 */this.itemsEstacionesVariable
						.add(new ShmtEstacionBalanceQl(
						/* 2182:1967 */estacion[0].toString(), estacion[2]
								.toString(),
						/* 2183:1968 */estacion[3].toString(), estacion[1]
								.toString(),
						/* 2184:1969 */grupo, this.usuario, tipoEstacion));
				/* 2185: */}
			/* 2186: */}
		/* 2187: */}

	/* 2188: */
	/* 2189: */private void actualizaGruposIncluir()
	/* 2190: */{
		/* 2191:1977 */this.itemsGruposBalanceAreaCuenca = new ArrayList();
		/* 2192:1978 */List<ShmtGrupoBalanceCaudal> grupos =
		/* 2193:1979 */ShmtGrupoBalanceCaudal.obtenerGruposAreasCuenca(
				getSelectedAreaOperativa(),
				/* 2194:1980 */getSelectedSbZonaHidrograficaId());
		/* 2195:1981 */if ((grupos != null) &&
		/* 2196:1982 */(grupos.size() >= 1)) {
			/* 2197:1983 */for (ShmtGrupoBalanceCaudal g : grupos) {
				/* 2198:1984 */this.itemsGruposBalanceAreaCuenca
						.add(new SelectItem(g, g
						/* 2199:1985 */.getNameDisplay()));
				/* 2200: */}
			/* 2201: */}
		/* 2202:1989 */this.validaGrupoNuevo = true;
		/* 2203:1990 */this.validaSbZonaHidrografica = true;
		/* 2204: */}

	/* 2205: */
	/* 2206: */private void actualizaAreasNuevoGrupo()
	/* 2207: */{
		/* 2208:1994 */this.itemsAreaHidrografica = new ArrayList();
		/* 2209:1995 */List<Object[]> areasOperativas =
		/* 2210:1996 */ZonificacionHidrografica
				.obtenerZonaXProperty("ARE", ".");
		/* 2211:1998 */if ((areasOperativas != null) &&
		/* 2212:1999 */(areasOperativas.size() >= 1)) {
			/* 2213:2000 */for (Object[] objects : areasOperativas)
			/* 2214: */{
				/* 2215:2001 */String a1 = ObjectUtils.toString(objects[1]);
				/* 2216:2002 */String a2 = ObjectUtils.toString(objects[0]);
				/* 2217:2003 */this.itemsAreaHidrografica.add(new SelectItem(
						a1, a2));
				/* 2218: */}
			/* 2219: */}
		/* 2220: */}

	/* 2221: */
	/* 2222: */private void actualizaZonasNuevoGrupo()
	/* 2223: */{
		/* 2224:2010 */this.itemsZonaHidrografica = new ArrayList();
		/* 2225:2011 */List<Object[]> zonaHidrog =
		/* 2226:2012 */ZonificacionHidrografica.obtenerZonaXProperty("ZON",
				getSelectedAreaHidrografica());
		/* 2227:2013 */if (zonaHidrog != null)
		/* 2228: */{
			/* 2229:2014 */if (zonaHidrog.size() >= 1) {
				/* 2230:2015 */for (Object[] objects : zonaHidrog)
				/* 2231: */{
					/* 2232:2016 */String a1 = ObjectUtils.toString(objects[2])
							+ "---" +
							/* 2233:2017 */ObjectUtils.toString(objects[1]);
					/* 2234:2018 */String a2 = ObjectUtils.toString(objects[0]);
					/* 2235:2019 */this.itemsZonaHidrografica
							.add(new SelectItem(a1, a2));
					/* 2236: */}
				/* 2237: */}
			/* 2238:2022 */this.validaAreaHidrografica = true;
			/* 2239: */}
		/* 2240: */else
		/* 2241: */{
			/* 2242:2024 */this.validaAreaHidrografica = false;
			/* 2243: */}
		/* 2244: */}

	/* 2245: */
	/* 2246: */private void actualizaSbZonasNuevoGrupo()
	/* 2247: */{
		/* 2248:2029 */this.itemsSbZonaHidrografica = new ArrayList();
		/* 2249:2030 */List<Object[]> zonaHidrog =
		/* 2250:2031 */ZonificacionHidrografica.obtenerZonaXProperty("SBZ",
				getSelectedZonaHidrografica());
		/* 2251:2033 */if (zonaHidrog != null)
		/* 2252: */{
			/* 2253:2034 */if (zonaHidrog.size() >= 1) {
				/* 2254:2035 */for (Object[] objects : zonaHidrog)
				/* 2255: */{
					/* 2256:2036 */String a1 = ObjectUtils.toString(objects[2]
							+ "---" +
							/* 2257:2037 */objects[1]);
					/* 2258:2038 */String a2 = ObjectUtils.toString(objects[0]);
					/* 2259:2039 */this.itemsSbZonaHidrografica
							.add(new SelectItem(a1, a2));
					/* 2260: */}
				/* 2261: */}
			/* 2262:2042 */this.validaZonaHidrografica = true;
			/* 2263: */}
		/* 2264: */else
		/* 2265: */{
			/* 2266:2044 */this.validaZonaHidrografica = false;
			/* 2267: */}
		/* 2268: */}

	/* 2269: */
	/* 2270: */private Long getTipoVariable()
	/* 2271: */{
		/* 2272:2049 */return Long.valueOf(getNuevoVariable().equals(
		/* 2273:2050 */NombresTitulosAplicacion.NIVEL.nombreTitulo) ? 1L : 2L);
		/* 2274: */}

	/* 2275: */
	/* 2276: */private void extraerArchivo(String fileName, String grafoEx)
	/* 2277: */{
		/* 2278: */try
		/* 2279: */{
			/* 2280:2056 */HmstPath p =
			/* 2281:2057 */HmstPath
					.obtenerDirectoriosFtp(NombresTitulosAplicacion.PATH_COMPONENTE.nombreTitulo);
			/* 2282: */
			/* 2283:2059 */BartTransfer bt = new BartTransfer(
					p.getPathServer(), p.getPathUserFtp(),
					/* 2284:2060 */p.getPathPassword());
			/* 2285:2061 */String r = obtenerRutaFisica();
			/* 2286:2062 */String serverConfUrl = System
					.getProperty("jboss.server.temp.dir");
			/* 2287:2063 */String fSeparator = System
					.getProperty("file.separator");
			String ex = ".none";
			/* 2288:2064 */serverConfUrl = serverConfUrl + fSeparator;
			/* 2289:2065 */log.debug("Dw: \n" + r + "\n " + serverConfUrl);
			/* 2290:2066 */this.nuevoGrafo = bt.bajarImagen(serverConfUrl,
					fileName);
			this.nuevoGrafo.setFileExtension(grafoEx);
			/* 2291:2067 */File name = this.nuevoGrafo.getFile();
			/* 2292:2068 */if (this.nuevoGrafo != null)
			/* 2293: */{
				ex = this.nuevoGrafo.getFileExtension();
				/* 2294:2069 */if (name == null)
				/* 2295: */{
					/* 2296:2070 */fileName =
					/* 2297:2071 */NombresTitulosAplicacion.RQ_544.nombreTitulo
							+ ex;
					/* 2298:2072 */name = new File(r, r + fileName);
					/* 2299:2073 */this.nuevoGrafo.setFile(name);
					this.nuevoGrafo.setFileExtension(ex);
					/* 2300:2074 */cargaExtension(this.nuevoGrafo.getFile());
					/* 2301: */}
				/* 2302: */else
				/* 2303: */{
					/* 2304:2076 */cargaExtension(fileName);
					/* 2305: */}
				/* 2306: */}
			/* 2307: */else {
				/* 2308:2079 */cargaExtension(fileName);
				/* 2309: */}
			/* 2310:2081 */File file = new File(r +
			/* 2311:2082 */NombresTitulosAplicacion.RQ_544.nombreTitulo +
			/* 2312:2083 */this.nuevoGrafo.getFileExtension());
			/* 2313:2084 */boolean delete = file.delete();
			/* 2314:2085 */boolean rename = name.renameTo(file);
			/* 2315:2086 */this.nuevoGrafo.setFile(name);
			this.nuevoGrafo.setFileExtension(ex);
			/* 2316:2087 */this.nuevoGrafo.setFileName(name.getAbsolutePath());
			/* 2317: */
			/* 2318:2089 */log.debug("delete : " + delete + " rename : "
					+ rename + " " + r +
					/* 2319:2090 */fileName);
			/* 2320:2091 */log.debug(this.nuevoGrafo.getFileExtension()
					+ " name: " +
					/* 2321:2092 */this.nuevoGrafo.getFileName() + " dir: " +
					/* 2322:2093 */this.nuevoGrafo.getFile().getAbsolutePath());
			/* 2323: */}
		/* 2324: */catch (Exception e)
		/* 2325: */{
			/* 2326:2095 */e.printStackTrace();
			/* 2327:2096 */context()
					.addMessage(
							/* 2328:2097 */NombresMensajesAplicacion.SUBMIT_MONITOR.nombreTitulo,
							/* 2329:2098 */new FacesMessage(severityNames[2],
							/* 2330:2099 */"Error al cargar imagen: "
									+ e.getMessage()));
			/* 2331: */}
		/* 2332: */}

	/* 2333: */
	/* 2334: */private static String obtenerRutaFisica()
	/* 2335: */{
		/* 2336:2104 */return
		/* 2337:2105 */((ServletContext) context().getExternalContext()
				.getContext()).getRealPath("/");
		/* 2338: */}

	/* 2339: */
	/* 2340: */public List<Integer> getDiasDelMes(int mes, int año)
	/* 2341: */{
		/* 2342:2109 */return Utiles.getDiasdelMes(mes, año);
		/* 2343: */}

	/* 2344: */
	/* 2345: */public List<CartesianSeries> getBarData()
	/* 2346: */{
		/* 2347:2113 */return this.barData;
		/* 2348: */}

	/* 2349: */
	/* 2350: */public void setBarData(List<CartesianSeries> barData)
	/* 2351: */{
		/* 2352:2117 */this.barData = barData;
		/* 2353: */}

	/* 2354: */
	/* 2355: */public Axis getBarDemoDefaultAxis()
	/* 2356: */{
		this.barDemoDefaultAxis = new Axis();
		barDemoDefaultAxis.setTickAngle(-30);
		/* 2357:2121 */return this.barDemoDefaultAxis;
		/* 2358: */}

	/* 2359: */
	/* 2360: */public void setBarDemoDefaultAxis(Axis barDemoDefaultAxis)
	/* 2361: */{
		/* 2362:2125 */this.barDemoDefaultAxis = barDemoDefaultAxis;
		/* 2363: */}

	/* 2364: */
	/* 2365: */public Axis getBarDemoXOneAxis()
	/* 2366: */{
		if (barDemoXOneAxis == null) {
			this.barDemoXOneAxis = new Axis();
			this.barDemoXOneAxis.setLabel("Fecha (Mes / Dia)");
			this.barDemoXOneAxis.setType(AxisType.CATEGORY);
			// this.barDemoXOneAxis.setDrawMajorGridlines(true);
			// this.barDemoXOneAxis.setSortMergedLabels(true);
			this.barDemoXOneAxis.setTickAngle(90);
		}
		/* 2367:2129 */return this.barDemoXOneAxis;
		/* 2368: */}

	/* 2369: */
	/* 2370: */public void setBarDemoXOneAxis(Axis barDemoXOneAxis)
	/* 2371: */{
		/* 2372:2133 */this.barDemoXOneAxis = barDemoXOneAxis;
		/* 2373: */}

	/* 2374: */
	/* 2375: */public Axis[] getBarDemoYAxes() {
		/* 2377:2137 */if (this.barDemoYAxes == null) {
			this.barDemoYAxes = new Axis[2];
			axisCdl = new Axis();
			axisPpp = new Axis();

			axisCdl.setAutoscale(true);
			axisCdl.setTickInterval("50");
			axisCdl.setLabel("Caudal (m2/seg)");
			axisCdl.setSortMergedLabels(true);
			axisCdl.setDrawMajorGridlines(true);

			axisPpp.setAutoscale(true);
			axisPpp.setTickInterval("50");
			axisPpp.setLabel("Precipitación media calculada (mm)");
			axisPpp.setSortMergedLabels(true);
			axisPpp.setDrawMajorGridlines(true);

		}
		// axisCdl.setTicks(getTicksCdl());
		axisPpp.setTicks(getTicksPm());
		this.barDemoYAxes[0] = axisCdl;
		this.barDemoYAxes[1] = axisPpp;

		return this.barDemoYAxes;
		/* 2388: */}

	/* 2389: */
	/* 2390: */public void setBarDemoYAxes(Axis[] barDemoYAxes)
	/* 2391: */{
		/* 2392:2164 */this.barDemoYAxes = barDemoYAxes;
		/* 2393: */}

	/* 2394: */
	/* 2395: */public Axis getBarDemoXTwoAxis()
	/* 2396: */{
		if (this.barDemoXTwoAxis == null) {
			this.barDemoXTwoAxis = new Axis();
			this.barDemoXTwoAxis.setLabel("Fecha (Mes / Dia)");
			this.barDemoXTwoAxis.setType(AxisType.CATEGORY);
			this.barDemoXTwoAxis.setDrawMajorGridlines(Boolean.valueOf(true));
			this.barDemoXTwoAxis.setSortMergedLabels(Boolean.valueOf(true));
			this.barDemoXTwoAxis.setTickAngle(90);
		}
		// this.barDemoXTwoAxis.setTicks(getTicksPm());
		return this.barDemoXTwoAxis;
		/* 2406: */}

	/* 2407: */
	/* 2408: */public void setBarDemoXTwoAxis(Axis barDemoXTwoAxis)
	/* 2409: */{
		/* 2410:2179 */this.barDemoXTwoAxis = barDemoXTwoAxis;
		/* 2411: */}

	/* 2412: */
	/* 2413: */public String[] getColorSet()
	/* 2414: */{
		/* 2415:2183 */return this.colorSet;
		/* 2416: */}

	/* 2417: */
	/* 2418: */public List<ShmtEstacionBalanceQl> getEstacionesNvl()
	/* 2419: */{
		/* 2420:2187 */return this.estacionesNvl;
		/* 2421: */}

	/* 2422: */
	/* 2423: */public void setEstacionesNvl(
			List<ShmtEstacionBalanceQl> estacionesNvl)
	/* 2424: */{
		/* 2425:2191 */this.estacionesNvl = estacionesNvl;
		/* 2426: */}

	/* 2427: */
	/* 2428: */public List<ShmtEstacionBalanceQl> getEstacionesPm()
	/* 2429: */{
		/* 2430:2195 */return this.estacionesPm;
		/* 2431: */}

	/* 2432: */
	/* 2433: */public void setEstacionesPm(
			List<ShmtEstacionBalanceQl> estacionesPm)
	/* 2434: */{
		/* 2435:2199 */this.estacionesPm = estacionesPm;
		/* 2436: */}

	/* 2437: */
	/* 2438: */public Double[][] getMapaValoresDiariosEnEstacionDiaCaudal()
	/* 2439: */{
		/* 2440:2203 */return this.mapaValoresDiariosEnEstacionDiaCaudal;
		/* 2441: */}

	/* 2442: */
	/* 2443: */public void setMapaValoresDiariosEnEstacionDiaCaudal(
			Double[][] mapaValoresDiariosEnEstacionDiaCaudal)
	/* 2444: */{
		/* 2445:2208 */this.mapaValoresDiariosEnEstacionDiaCaudal = mapaValoresDiariosEnEstacionDiaCaudal;
		/* 2446: */}

	/* 2447: */
	/* 2448: */public Double[][] getMapaValoresDiariosEnEstacionDiaPrecipitacion()
	/* 2449: */{
		/* 2450:2212 */return this.mapaValoresDiariosEnEstacionDiaPrecipitacion;
		/* 2451: */}

	/* 2452: */
	/* 2453: */public void setMapaValoresDiariosEnEstacionDiaPrecipitacion(
			Double[][] mapaValoresDiariosEnEstacionDiaPrecipitacion)
	/* 2454: */{
		/* 2455:2217 */this.mapaValoresDiariosEnEstacionDiaPrecipitacion = mapaValoresDiariosEnEstacionDiaPrecipitacion;
		/* 2456: */}

	/* 2457: */
	/* 2458: */public boolean isPeriocidadAnual()
	/* 2459: */{
		/* 2460:2221 */return Utiles.isPeriocidadAnual();
		/* 2461: */}

	public String actionModify(ActionEvent e) {

		/* 261: 284 */UIComponent boton = e.getComponent();

		String value = (String) boton.getAttributes().get("valor");

		return "start";
	}

	/* 2462: */
	private List<CartesianSeries> dataForChart = new ArrayList<CartesianSeries>() {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		{
			add(new CartesianSeries() {
				{
					setType(CartesianType.BAR);
					add("Enero 01", 90);
					add("Enero 02", 120);
					setLabel("First Value");
				}
			});
			add(new CartesianSeries() {
				{
					setType(CartesianType.LINE);
					add("Enero 01", 120);
					add("Enero 02", 200);
					setLabel("Second Value");
					setYAxis(2);
					setXAxis(2);
				}
			});
		}
	};

	private Axis xAxis = new Axis() {
		{
			setType(AxisType.CATEGORY);
		}
	};

	private Axis x2Axis = new Axis() {
		{
			setType(AxisType.CATEGORY);
		}
	};

	private Axis[] YAxes = new Axis[] { new Axis() {
		{
			setAutoscale(true);
			setLabel("Y1");
		}
	}, new Axis() {
		{
			setAutoscale(true);
			setLabel("Y2");
		}
	} };

	public List<CartesianSeries> getDataForChart() {
		return dataForChart;
	}

	public void setDataForChart(List<CartesianSeries> dataForChart) {
		this.dataForChart = dataForChart;
	}

	public Axis getxAxis() {
		return xAxis;
	}

	public void setxAxis(Axis xAxis) {
		this.xAxis = xAxis;
	}

	public Axis getX2Axis() {
		return x2Axis;
	}

	public void setX2Axis(Axis x2Axis) {
		this.x2Axis = x2Axis;
	}

	public Axis[] getYAxes() {
		return YAxes;
	}

	public void setYAxes(Axis[] yAxes) {
		YAxes = yAxes;
	}

	public String getBACK() {
		if (BACK.equals(null)) {
			BACK = ((HttpServletRequest) context().getExternalContext()
					.getRequest()).getServletContext().getInitParameter("name");
		}
		return BACK;
	}

	public void setBACK(String bACK) {
		BACK = bACK;
	}

}

/*
 * Location: C:\Users\Luis\Desktop\CLXX\BalanceQL\Fuentes\
 * 
 * Qualified Name: sia.bql.bean.FacadeBean
 * 
 * JD-Core Version: 0.7.0.1
 */