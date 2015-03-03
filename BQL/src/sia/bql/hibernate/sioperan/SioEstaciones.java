/*   1:    */ package sia.bql.hibernate.sioperan;
/*   2:    */ 
/*   3:    */ import java.io.Serializable;
/*   4:    */ import java.util.Date;
/*   5:    */ import java.util.HashSet;
/*   6:    */ import java.util.Set;
/*   7:    */ 
/*   8:    */ public class SioEstaciones
/*   9:    */   implements Serializable
/*  10:    */ {
/*  11:    */   private static final long serialVersionUID = 1L;
/*  12:    */   private Long estacionId;
/*  13:    */   private String tipo;
/*  14:    */   private String escala;
/*  15:    */   private String codigoInterno;
/*  16:    */   private Date fechaCreacion;
/*  17:    */   private String satEnlace;
/*  18:    */   private String satTipo;
/*  19:    */   private Date fechaModificacion;
/*  20:    */   private Double alturaReferencia;
/*  21:    */   private String satNombre;
/*  22:    */   private String clase;
/*  23:    */   private String categoria;
/*  24:    */   private String satProtocolo;
/*  25:    */   private String comentarioInstalacion;
/*  26:    */   private String satVentana;
/*  27:    */   private String nombre;
/*  28:    */   private String objetivoInstalacion;
/*  29:    */   private String codigoReporte;
/*  30:    */   private String codigoInternacional;
/*  31:    */   private String codigoCatalogo;
/*  32:    */   private String estado;
/*  33:    */   private Date fechaAplicacion;
/*  34:    */   private String codigoOaci;
/*  35:    */   private String codigoWmo;
/*  36: 33 */   private Set sioCostosPlaneadoses = new HashSet(0);
/*  37: 34 */   private Set sioComponenteses = new HashSet(0);
/*  38: 35 */   private Set sioRolesOrganizacionPmas = new HashSet(0);
/*  39: 36 */   private Set sioEstructurases = new HashSet(0);
/*  40: 37 */   private Set sioCarpetases = new HashSet(0);
/*  41: 38 */   private Set sioDocumentoses = new HashSet(0);
/*  42: 39 */   private Set sioRolesEstacionPersonas = new HashSet(0);
/*  43: 40 */   private Set sioProgramacionActividadeses = new HashSet(0);
/*  44: 41 */   private Set sioFallases = new HashSet(0);
/*  45: 42 */   private Set sioObjetivoses = new HashSet(0);
/*  46:    */   
/*  47:    */   public Long getEstacionId()
/*  48:    */   {
/*  49: 49 */     return this.estacionId;
/*  50:    */   }
/*  51:    */   
/*  52:    */   public void setEstacionId(Long estacionId)
/*  53:    */   {
/*  54: 52 */     this.estacionId = estacionId;
/*  55:    */   }
/*  56:    */   
/*  57:    */   public String getTipo()
/*  58:    */   {
/*  59: 55 */     return this.tipo;
/*  60:    */   }
/*  61:    */   
/*  62:    */   public void setTipo(String tipo)
/*  63:    */   {
/*  64: 58 */     this.tipo = tipo;
/*  65:    */   }
/*  66:    */   
/*  67:    */   public String getEscala()
/*  68:    */   {
/*  69: 61 */     return this.escala;
/*  70:    */   }
/*  71:    */   
/*  72:    */   public void setEscala(String escala)
/*  73:    */   {
/*  74: 64 */     this.escala = escala;
/*  75:    */   }
/*  76:    */   
/*  77:    */   public String getCodigoInterno()
/*  78:    */   {
/*  79: 67 */     return this.codigoInterno;
/*  80:    */   }
/*  81:    */   
/*  82:    */   public void setCodigoInterno(String codigoInterno)
/*  83:    */   {
/*  84: 70 */     this.codigoInterno = codigoInterno;
/*  85:    */   }
/*  86:    */   
/*  87:    */   public Date getFechaCreacion()
/*  88:    */   {
/*  89: 73 */     return this.fechaCreacion;
/*  90:    */   }
/*  91:    */   
/*  92:    */   public void setFechaCreacion(Date fechaCreacion)
/*  93:    */   {
/*  94: 76 */     this.fechaCreacion = fechaCreacion;
/*  95:    */   }
/*  96:    */   
/*  97:    */   public String getSatEnlace()
/*  98:    */   {
/*  99: 79 */     return this.satEnlace;
/* 100:    */   }
/* 101:    */   
/* 102:    */   public void setSatEnlace(String satEnlace)
/* 103:    */   {
/* 104: 82 */     this.satEnlace = satEnlace;
/* 105:    */   }
/* 106:    */   
/* 107:    */   public String getSatTipo()
/* 108:    */   {
/* 109: 85 */     return this.satTipo;
/* 110:    */   }
/* 111:    */   
/* 112:    */   public void setSatTipo(String satTipo)
/* 113:    */   {
/* 114: 88 */     this.satTipo = satTipo;
/* 115:    */   }
/* 116:    */   
/* 117:    */   public Date getFechaModificacion()
/* 118:    */   {
/* 119: 91 */     return this.fechaModificacion;
/* 120:    */   }
/* 121:    */   
/* 122:    */   public void setFechaModificacion(Date fechaModificacion)
/* 123:    */   {
/* 124: 94 */     this.fechaModificacion = fechaModificacion;
/* 125:    */   }
/* 126:    */   
/* 127:    */   public Double getAlturaReferencia()
/* 128:    */   {
/* 129: 97 */     return this.alturaReferencia;
/* 130:    */   }
/* 131:    */   
/* 132:    */   public void setAlturaReferencia(Double alturaReferencia)
/* 133:    */   {
/* 134:100 */     this.alturaReferencia = alturaReferencia;
/* 135:    */   }
/* 136:    */   
/* 137:    */   public String getSatNombre()
/* 138:    */   {
/* 139:103 */     return this.satNombre;
/* 140:    */   }
/* 141:    */   
/* 142:    */   public void setSatNombre(String satNombre)
/* 143:    */   {
/* 144:106 */     this.satNombre = satNombre;
/* 145:    */   }
/* 146:    */   
/* 147:    */   public String getClase()
/* 148:    */   {
/* 149:109 */     return this.clase;
/* 150:    */   }
/* 151:    */   
/* 152:    */   public void setClase(String clase)
/* 153:    */   {
/* 154:112 */     this.clase = clase;
/* 155:    */   }
/* 156:    */   
/* 157:    */   public String getCategoria()
/* 158:    */   {
/* 159:115 */     return this.categoria;
/* 160:    */   }
/* 161:    */   
/* 162:    */   public void setCategoria(String categoria)
/* 163:    */   {
/* 164:118 */     this.categoria = categoria;
/* 165:    */   }
/* 166:    */   
/* 167:    */   public String getSatProtocolo()
/* 168:    */   {
/* 169:121 */     return this.satProtocolo;
/* 170:    */   }
/* 171:    */   
/* 172:    */   public void setSatProtocolo(String satProtocolo)
/* 173:    */   {
/* 174:124 */     this.satProtocolo = satProtocolo;
/* 175:    */   }
/* 176:    */   
/* 177:    */   public String getComentarioInstalacion()
/* 178:    */   {
/* 179:127 */     return this.comentarioInstalacion;
/* 180:    */   }
/* 181:    */   
/* 182:    */   public void setComentarioInstalacion(String comentarioInstalacion)
/* 183:    */   {
/* 184:130 */     this.comentarioInstalacion = comentarioInstalacion;
/* 185:    */   }
/* 186:    */   
/* 187:    */   public String getSatVentana()
/* 188:    */   {
/* 189:133 */     return this.satVentana;
/* 190:    */   }
/* 191:    */   
/* 192:    */   public void setSatVentana(String satVentana)
/* 193:    */   {
/* 194:136 */     this.satVentana = satVentana;
/* 195:    */   }
/* 196:    */   
/* 197:    */   public String getNombre()
/* 198:    */   {
/* 199:139 */     return this.nombre;
/* 200:    */   }
/* 201:    */   
/* 202:    */   public void setNombre(String nombre)
/* 203:    */   {
/* 204:142 */     this.nombre = nombre;
/* 205:    */   }
/* 206:    */   
/* 207:    */   public String getObjetivoInstalacion()
/* 208:    */   {
/* 209:145 */     return this.objetivoInstalacion;
/* 210:    */   }
/* 211:    */   
/* 212:    */   public void setObjetivoInstalacion(String objetivoInstalacion)
/* 213:    */   {
/* 214:148 */     this.objetivoInstalacion = objetivoInstalacion;
/* 215:    */   }
/* 216:    */   
/* 217:    */   public String getCodigoReporte()
/* 218:    */   {
/* 219:151 */     return this.codigoReporte;
/* 220:    */   }
/* 221:    */   
/* 222:    */   public void setCodigoReporte(String codigoReporte)
/* 223:    */   {
/* 224:154 */     this.codigoReporte = codigoReporte;
/* 225:    */   }
/* 226:    */   
/* 227:    */   public String getCodigoInternacional()
/* 228:    */   {
/* 229:157 */     return this.codigoInternacional;
/* 230:    */   }
/* 231:    */   
/* 232:    */   public void setCodigoInternacional(String codigoInternacional)
/* 233:    */   {
/* 234:160 */     this.codigoInternacional = codigoInternacional;
/* 235:    */   }
/* 236:    */   
/* 237:    */   public String getCodigoCatalogo()
/* 238:    */   {
/* 239:163 */     return this.codigoCatalogo;
/* 240:    */   }
/* 241:    */   
/* 242:    */   public void setCodigoCatalogo(String codigoCatalogo)
/* 243:    */   {
/* 244:166 */     this.codigoCatalogo = codigoCatalogo;
/* 245:    */   }
/* 246:    */   
/* 247:    */   public String getEstado()
/* 248:    */   {
/* 249:169 */     return this.estado;
/* 250:    */   }
/* 251:    */   
/* 252:    */   public void setEstado(String estado)
/* 253:    */   {
/* 254:172 */     this.estado = estado;
/* 255:    */   }
/* 256:    */   
/* 257:    */   public Date getFechaAplicacion()
/* 258:    */   {
/* 259:175 */     return this.fechaAplicacion;
/* 260:    */   }
/* 261:    */   
/* 262:    */   public void setFechaAplicacion(Date fechaAplicacion)
/* 263:    */   {
/* 264:178 */     this.fechaAplicacion = fechaAplicacion;
/* 265:    */   }
/* 266:    */   
/* 267:    */   public String getCodigoOaci()
/* 268:    */   {
/* 269:181 */     return this.codigoOaci;
/* 270:    */   }
/* 271:    */   
/* 272:    */   public void setCodigoOaci(String codigoOaci)
/* 273:    */   {
/* 274:184 */     this.codigoOaci = codigoOaci;
/* 275:    */   }
/* 276:    */   
/* 277:    */   public String getCodigoWmo()
/* 278:    */   {
/* 279:187 */     return this.codigoWmo;
/* 280:    */   }
/* 281:    */   
/* 282:    */   public void setCodigoWmo(String codigoWmo)
/* 283:    */   {
/* 284:190 */     this.codigoWmo = codigoWmo;
/* 285:    */   }
/* 286:    */   
/* 287:    */   public Set getSioCostosPlaneadoses()
/* 288:    */   {
/* 289:193 */     return this.sioCostosPlaneadoses;
/* 290:    */   }
/* 291:    */   
/* 292:    */   public void setSioCostosPlaneadoses(Set sioCostosPlaneadoses)
/* 293:    */   {
/* 294:196 */     this.sioCostosPlaneadoses = sioCostosPlaneadoses;
/* 295:    */   }
/* 296:    */   
/* 297:    */   public Set getSioComponenteses()
/* 298:    */   {
/* 299:199 */     return this.sioComponenteses;
/* 300:    */   }
/* 301:    */   
/* 302:    */   public void setSioComponenteses(Set sioComponenteses)
/* 303:    */   {
/* 304:202 */     this.sioComponenteses = sioComponenteses;
/* 305:    */   }
/* 306:    */   
/* 307:    */   public Set getSioRolesOrganizacionPmas()
/* 308:    */   {
/* 309:205 */     return this.sioRolesOrganizacionPmas;
/* 310:    */   }
/* 311:    */   
/* 312:    */   public void setSioRolesOrganizacionPmas(Set sioRolesOrganizacionPmas)
/* 313:    */   {
/* 314:208 */     this.sioRolesOrganizacionPmas = sioRolesOrganizacionPmas;
/* 315:    */   }
/* 316:    */   
/* 317:    */   public Set getSioEstructurases()
/* 318:    */   {
/* 319:211 */     return this.sioEstructurases;
/* 320:    */   }
/* 321:    */   
/* 322:    */   public void setSioEstructurases(Set sioEstructurases)
/* 323:    */   {
/* 324:214 */     this.sioEstructurases = sioEstructurases;
/* 325:    */   }
/* 326:    */   
/* 327:    */   public Set getSioCarpetases()
/* 328:    */   {
/* 329:217 */     return this.sioCarpetases;
/* 330:    */   }
/* 331:    */   
/* 332:    */   public void setSioCarpetases(Set sioCarpetases)
/* 333:    */   {
/* 334:220 */     this.sioCarpetases = sioCarpetases;
/* 335:    */   }
/* 336:    */   
/* 337:    */   public Set getSioDocumentoses()
/* 338:    */   {
/* 339:223 */     return this.sioDocumentoses;
/* 340:    */   }
/* 341:    */   
/* 342:    */   public void setSioDocumentoses(Set sioDocumentoses)
/* 343:    */   {
/* 344:226 */     this.sioDocumentoses = sioDocumentoses;
/* 345:    */   }
/* 346:    */   
/* 347:    */   public Set getSioRolesEstacionPersonas()
/* 348:    */   {
/* 349:229 */     return this.sioRolesEstacionPersonas;
/* 350:    */   }
/* 351:    */   
/* 352:    */   public void setSioRolesEstacionPersonas(Set sioRolesEstacionPersonas)
/* 353:    */   {
/* 354:232 */     this.sioRolesEstacionPersonas = sioRolesEstacionPersonas;
/* 355:    */   }
/* 356:    */   
/* 357:    */   public Set getSioProgramacionActividadeses()
/* 358:    */   {
/* 359:235 */     return this.sioProgramacionActividadeses;
/* 360:    */   }
/* 361:    */   
/* 362:    */   public void setSioProgramacionActividadeses(Set sioProgramacionActividadeses)
/* 363:    */   {
/* 364:238 */     this.sioProgramacionActividadeses = sioProgramacionActividadeses;
/* 365:    */   }
/* 366:    */   
/* 367:    */   public Set getSioFallases()
/* 368:    */   {
/* 369:241 */     return this.sioFallases;
/* 370:    */   }
/* 371:    */   
/* 372:    */   public void setSioFallases(Set sioFallases)
/* 373:    */   {
/* 374:244 */     this.sioFallases = sioFallases;
/* 375:    */   }
/* 376:    */   
/* 377:    */   public Set getSioObjetivoses()
/* 378:    */   {
/* 379:247 */     return this.sioObjetivoses;
/* 380:    */   }
/* 381:    */   
/* 382:    */   public void setSioObjetivoses(Set sioObjetivoses)
/* 383:    */   {
/* 384:250 */     this.sioObjetivoses = sioObjetivoses;
/* 385:    */   }
/* 386:    */ }


/* Location:           C:\Users\Luis\Desktop\CLXX\BalanceQL\Fuentes\
 * Qualified Name:     sia.bql.hibernate.sioperan.SioEstaciones
 * JD-Core Version:    0.7.0.1
 */