/*   1:    */ package sia.bql.hibernate.sioperan;
/*   2:    */ 
/*   3:    */ import java.io.Serializable;
/*   4:    */ import java.util.Date;
/*   5:    */ import java.util.HashSet;
/*   6:    */ import java.util.List;
/*   7:    */ import java.util.Set;
/*   8:    */ import org.hibernate.Query;
/*   9:    */ import org.hibernate.Session;
/*  10:    */ import sia.bql.hibernate.HibernateSessionFactory;
/*  11:    */ 
/*  12:    */ public class SioOrganizacion
/*  13:    */   implements Serializable
/*  14:    */ {
/*  15:    */   private static final long serialVersionUID = 1L;
/*  16:    */   private Long organizacionId;
/*  17:    */   private SioOrganizacion sioOrganizacion;
/*  18:    */   private Date fechaModificacion;
/*  19:    */   private String tipo;
/*  20:    */   private String estado;
/*  21:    */   private String email;
/*  22:    */   private String clase;
/*  23:    */   private Date fechaRegistro;
/*  24:    */   private String razonSocial;
/*  25:    */   private Date fechaRetiro;
/*  26:    */   private String direccion;
/*  27:    */   private String fax;
/*  28:    */   private String web;
/*  29:    */   private String telefono;
/*  30:    */   private String sector;
/*  31:    */   private String nit;
/*  32:    */   private Date fechaCreacion;
/*  33:    */   private Date fechaAplicacion;
/*  34:    */   private String sigla;
/*  35: 35 */   private Set sioRolesOrganizacionPmas = new HashSet(0);
/*  36: 36 */   private Set sioPlanVisitases = new HashSet(0);
/*  37: 37 */   private Set sioRolesOrganizacionPersonas = new HashSet(0);
/*  38: 38 */   private Set sioOrganizacions = new HashSet(0);
/*  39: 39 */   private Set sioRegistroProveedoreses = new HashSet(0);
/*  40: 40 */   private Set sioRolesOrganizacionFgdas = new HashSet(0);
/*  41: 41 */   private Set sioCostosPlaneadoses = new HashSet(0);
/*  42: 42 */   private Set sioActividadCiiueses = new HashSet(0);
/*  43:    */   
/*  44:    */   public Long getOrganizacionId()
/*  45:    */   {
/*  46: 50 */     return this.organizacionId;
/*  47:    */   }
/*  48:    */   
/*  49:    */   public void setOrganizacionId(Long organizacionId)
/*  50:    */   {
/*  51: 54 */     this.organizacionId = organizacionId;
/*  52:    */   }
/*  53:    */   
/*  54:    */   public SioOrganizacion getSioOrganizacion()
/*  55:    */   {
/*  56: 58 */     return this.sioOrganizacion;
/*  57:    */   }
/*  58:    */   
/*  59:    */   public void setSioOrganizacion(SioOrganizacion sioOrganizacion)
/*  60:    */   {
/*  61: 62 */     this.sioOrganizacion = sioOrganizacion;
/*  62:    */   }
/*  63:    */   
/*  64:    */   public Date getFechaModificacion()
/*  65:    */   {
/*  66: 66 */     return this.fechaModificacion;
/*  67:    */   }
/*  68:    */   
/*  69:    */   public void setFechaModificacion(Date fechaModificacion)
/*  70:    */   {
/*  71: 70 */     this.fechaModificacion = fechaModificacion;
/*  72:    */   }
/*  73:    */   
/*  74:    */   public String getTipo()
/*  75:    */   {
/*  76: 74 */     return this.tipo;
/*  77:    */   }
/*  78:    */   
/*  79:    */   public void setTipo(String tipo)
/*  80:    */   {
/*  81: 78 */     this.tipo = tipo;
/*  82:    */   }
/*  83:    */   
/*  84:    */   public String getEstado()
/*  85:    */   {
/*  86: 82 */     return this.estado;
/*  87:    */   }
/*  88:    */   
/*  89:    */   public void setEstado(String estado)
/*  90:    */   {
/*  91: 86 */     this.estado = estado;
/*  92:    */   }
/*  93:    */   
/*  94:    */   public String getEmail()
/*  95:    */   {
/*  96: 90 */     return this.email;
/*  97:    */   }
/*  98:    */   
/*  99:    */   public void setEmail(String email)
/* 100:    */   {
/* 101: 94 */     this.email = email;
/* 102:    */   }
/* 103:    */   
/* 104:    */   public String getClase()
/* 105:    */   {
/* 106: 98 */     return this.clase;
/* 107:    */   }
/* 108:    */   
/* 109:    */   public void setClase(String clase)
/* 110:    */   {
/* 111:102 */     this.clase = clase;
/* 112:    */   }
/* 113:    */   
/* 114:    */   public Date getFechaRegistro()
/* 115:    */   {
/* 116:106 */     return this.fechaRegistro;
/* 117:    */   }
/* 118:    */   
/* 119:    */   public void setFechaRegistro(Date fechaRegistro)
/* 120:    */   {
/* 121:110 */     this.fechaRegistro = fechaRegistro;
/* 122:    */   }
/* 123:    */   
/* 124:    */   public String getRazonSocial()
/* 125:    */   {
/* 126:114 */     return this.razonSocial;
/* 127:    */   }
/* 128:    */   
/* 129:    */   public void setRazonSocial(String razonSocial)
/* 130:    */   {
/* 131:118 */     this.razonSocial = razonSocial;
/* 132:    */   }
/* 133:    */   
/* 134:    */   public Date getFechaRetiro()
/* 135:    */   {
/* 136:122 */     return this.fechaRetiro;
/* 137:    */   }
/* 138:    */   
/* 139:    */   public void setFechaRetiro(Date fechaRetiro)
/* 140:    */   {
/* 141:126 */     this.fechaRetiro = fechaRetiro;
/* 142:    */   }
/* 143:    */   
/* 144:    */   public String getDireccion()
/* 145:    */   {
/* 146:130 */     return this.direccion;
/* 147:    */   }
/* 148:    */   
/* 149:    */   public void setDireccion(String direccion)
/* 150:    */   {
/* 151:134 */     this.direccion = direccion;
/* 152:    */   }
/* 153:    */   
/* 154:    */   public String getFax()
/* 155:    */   {
/* 156:138 */     return this.fax;
/* 157:    */   }
/* 158:    */   
/* 159:    */   public void setFax(String fax)
/* 160:    */   {
/* 161:142 */     this.fax = fax;
/* 162:    */   }
/* 163:    */   
/* 164:    */   public String getWeb()
/* 165:    */   {
/* 166:146 */     return this.web;
/* 167:    */   }
/* 168:    */   
/* 169:    */   public void setWeb(String web)
/* 170:    */   {
/* 171:150 */     this.web = web;
/* 172:    */   }
/* 173:    */   
/* 174:    */   public String getTelefono()
/* 175:    */   {
/* 176:154 */     return this.telefono;
/* 177:    */   }
/* 178:    */   
/* 179:    */   public void setTelefono(String telefono)
/* 180:    */   {
/* 181:158 */     this.telefono = telefono;
/* 182:    */   }
/* 183:    */   
/* 184:    */   public String getSector()
/* 185:    */   {
/* 186:162 */     return this.sector;
/* 187:    */   }
/* 188:    */   
/* 189:    */   public void setSector(String sector)
/* 190:    */   {
/* 191:166 */     this.sector = sector;
/* 192:    */   }
/* 193:    */   
/* 194:    */   public String getNit()
/* 195:    */   {
/* 196:170 */     return this.nit;
/* 197:    */   }
/* 198:    */   
/* 199:    */   public void setNit(String nit)
/* 200:    */   {
/* 201:174 */     this.nit = nit;
/* 202:    */   }
/* 203:    */   
/* 204:    */   public Date getFechaCreacion()
/* 205:    */   {
/* 206:178 */     return this.fechaCreacion;
/* 207:    */   }
/* 208:    */   
/* 209:    */   public void setFechaCreacion(Date fechaCreacion)
/* 210:    */   {
/* 211:182 */     this.fechaCreacion = fechaCreacion;
/* 212:    */   }
/* 213:    */   
/* 214:    */   public Date getFechaAplicacion()
/* 215:    */   {
/* 216:186 */     return this.fechaAplicacion;
/* 217:    */   }
/* 218:    */   
/* 219:    */   public void setFechaAplicacion(Date fechaAplicacion)
/* 220:    */   {
/* 221:190 */     this.fechaAplicacion = fechaAplicacion;
/* 222:    */   }
/* 223:    */   
/* 224:    */   public String getSigla()
/* 225:    */   {
/* 226:194 */     return this.sigla;
/* 227:    */   }
/* 228:    */   
/* 229:    */   public void setSigla(String sigla)
/* 230:    */   {
/* 231:198 */     this.sigla = sigla;
/* 232:    */   }
/* 233:    */   
/* 234:    */   public Set getSioRolesOrganizacionPmas()
/* 235:    */   {
/* 236:202 */     return this.sioRolesOrganizacionPmas;
/* 237:    */   }
/* 238:    */   
/* 239:    */   public void setSioRolesOrganizacionPmas(Set sioRolesOrganizacionPmas)
/* 240:    */   {
/* 241:206 */     this.sioRolesOrganizacionPmas = sioRolesOrganizacionPmas;
/* 242:    */   }
/* 243:    */   
/* 244:    */   public Set getSioPlanVisitases()
/* 245:    */   {
/* 246:210 */     return this.sioPlanVisitases;
/* 247:    */   }
/* 248:    */   
/* 249:    */   public void setSioPlanVisitases(Set sioPlanVisitases)
/* 250:    */   {
/* 251:214 */     this.sioPlanVisitases = sioPlanVisitases;
/* 252:    */   }
/* 253:    */   
/* 254:    */   public Set getSioRolesOrganizacionPersonas()
/* 255:    */   {
/* 256:218 */     return this.sioRolesOrganizacionPersonas;
/* 257:    */   }
/* 258:    */   
/* 259:    */   public void setSioRolesOrganizacionPersonas(Set sioRolesOrganizacionPersonas)
/* 260:    */   {
/* 261:222 */     this.sioRolesOrganizacionPersonas = sioRolesOrganizacionPersonas;
/* 262:    */   }
/* 263:    */   
/* 264:    */   public Set getSioOrganizacions()
/* 265:    */   {
/* 266:226 */     return this.sioOrganizacions;
/* 267:    */   }
/* 268:    */   
/* 269:    */   public void setSioOrganizacions(Set sioOrganizacions)
/* 270:    */   {
/* 271:230 */     this.sioOrganizacions = sioOrganizacions;
/* 272:    */   }
/* 273:    */   
/* 274:    */   public Set getSioRegistroProveedoreses()
/* 275:    */   {
/* 276:234 */     return this.sioRegistroProveedoreses;
/* 277:    */   }
/* 278:    */   
/* 279:    */   public void setSioRegistroProveedoreses(Set sioRegistroProveedoreses)
/* 280:    */   {
/* 281:238 */     this.sioRegistroProveedoreses = sioRegistroProveedoreses;
/* 282:    */   }
/* 283:    */   
/* 284:    */   public Set getSioRolesOrganizacionFgdas()
/* 285:    */   {
/* 286:242 */     return this.sioRolesOrganizacionFgdas;
/* 287:    */   }
/* 288:    */   
/* 289:    */   public void setSioRolesOrganizacionFgdas(Set sioRolesOrganizacionFgdas)
/* 290:    */   {
/* 291:246 */     this.sioRolesOrganizacionFgdas = sioRolesOrganizacionFgdas;
/* 292:    */   }
/* 293:    */   
/* 294:    */   public Set getSioCostosPlaneadoses()
/* 295:    */   {
/* 296:250 */     return this.sioCostosPlaneadoses;
/* 297:    */   }
/* 298:    */   
/* 299:    */   public void setSioCostosPlaneadoses(Set sioCostosPlaneadoses)
/* 300:    */   {
/* 301:254 */     this.sioCostosPlaneadoses = sioCostosPlaneadoses;
/* 302:    */   }
/* 303:    */   
/* 304:    */   public Set getSioActividadCiiueses()
/* 305:    */   {
/* 306:258 */     return this.sioActividadCiiueses;
/* 307:    */   }
/* 308:    */   
/* 309:    */   public void setSioActividadCiiueses(Set sioActividadCiiueses)
/* 310:    */   {
/* 311:262 */     this.sioActividadCiiueses = sioActividadCiiueses;
/* 312:    */   }
/* 313:    */   
/* 314:    */   public static List<String> obtenerAreasOperativas()
/* 315:    */   {
/* 316:267 */     return 
/* 317:268 */       HibernateSessionFactory.currentSession().getNamedQuery("estacionesPorAreaOperativa").list();
/* 318:    */   }
/* 319:    */   
/* 320:    */   public static String obtenerAreasOperativas(String aop)
/* 321:    */   {
/* 322:272 */     String query = "select r.ORGANIZACION_ID, R.RAZON_SOCIAL from   SIOPERAN.SIO_ORGANIZACION  r  where  r.TIPO = 'AOP' and and r.ORGANIZACION_ID = " + 
/* 323:    */     
/* 324:274 */       aop + 
/* 325:275 */       " order by r.ORGANIZACION_ID ";
/* 326:276 */     Query q = HibernateSessionFactory.currentSession().createSQLQuery(query);
/* 327:277 */     Object[] object = (Object[])q.uniqueResult();
/* 328:278 */     return object[1].toString();
/* 329:    */   }
/* 330:    */   
/* 331:    */   public static List<Object[]> obtenerAreOperat()
/* 332:    */   {
/* 333:282 */     String query = "select r.ORGANIZACION_ID, R.RAZON_SOCIAL from   SIOPERAN.SIO_ORGANIZACION  r  where  r.TIPO = 'AOP' order by r.ORGANIZACION_ID ";
/* 334:    */     
/* 335:    */ 
/* 336:285 */     Query q = HibernateSessionFactory.currentSession().createSQLQuery(query);
/* 337:286 */     List<Object[]> listObject = q.list();
/* 338:287 */     return listObject;
/* 339:    */   }
/* 340:    */   
/* 341:    */   public static List<Object[]> obtenerDeptosAreasOperativas(String areaOperativa)
/* 342:    */   {
/* 343:295 */     if (areaOperativa == null)
/* 344:    */     {
/* 345:296 */       areaOperativa = "0";
/* 346:297 */       return null;
/* 347:    */     }
/* 348:299 */     if (areaOperativa.equals("---"))
/* 349:    */     {
/* 350:300 */       areaOperativa = "0";
/* 351:301 */       return null;
/* 352:    */     }
/* 353:303 */     String query = "select   distinct div.departamento ,  div.NOMBRE_PADRE_DV ,  R.RAZON_SOCIAL  from   SIOPERAN.SIO_ORGANIZACION  r,   SIOPERAN.SIOV_ESTACIONES e,   SIOPERAN.SIOV_DIVIPOLAS div  where  r.TIPO = 'AOP'  AND r.ORGANIZACION_ID = e.ID_ORG  and div.CODIGO_DV=e.CODIGO_DIVIPOLA  and R.ORGANIZACION_ID= " + 
/* 354:    */     
/* 355:    */ 
/* 356:    */ 
/* 357:    */ 
/* 358:    */ 
/* 359:    */ 
/* 360:310 */       areaOperativa;
/* 361:    */     
/* 362:312 */     Query q = HibernateSessionFactory.currentSession().createSQLQuery(query);
/* 363:313 */     List<Object[]> listObject = q.list();
/* 364:314 */     return listObject;
/* 365:    */   }
/* 366:    */   
/* 367:    */   public static List<Object[]> obtenerMunicipiOperativas(String areaOperativa, String idDepto)
/* 368:    */   {
/* 369:320 */     if (areaOperativa == null)
/* 370:    */     {
/* 371:321 */       areaOperativa = "0";
/* 372:322 */       return null;
/* 373:    */     }
/* 374:324 */     if (idDepto == null)
/* 375:    */     {
/* 376:325 */       idDepto = "0";
/* 377:326 */       return null;
/* 378:    */     }
/* 379:328 */     if (areaOperativa.equals("---"))
/* 380:    */     {
/* 381:329 */       areaOperativa = "0";
/* 382:330 */       return null;
/* 383:    */     }
/* 384:332 */     if (idDepto.equals("---"))
/* 385:    */     {
/* 386:333 */       idDepto = "0";
/* 387:334 */       return null;
/* 388:    */     }
/* 389:336 */     String query = "select  distinct div.id_dv, div.NOMBRE_DV  from  SIOPERAN.SIO_ORGANIZACION  r,  SIOPERAN.SIOV_ESTACIONES e,  SIOPERAN.SIOV_DIVIPOLAS div  where  r.TIPO = 'AOP'  AND r.ORGANIZACION_ID = e.ID_ORG  and div.CODIGO_DV=e.CODIGO_DIVIPOLA  and organizacion_id= " + 
/* 390:    */     
/* 391:    */ 
/* 392:    */ 
/* 393:    */ 
/* 394:    */ 
/* 395:342 */       areaOperativa + 
/* 396:343 */       " and div.departamento = " + idDepto;
/* 397:344 */     Query q = HibernateSessionFactory.currentSession().createSQLQuery(query);
/* 398:345 */     List<Object[]> listObject = q.list();
/* 399:346 */     return listObject;
/* 400:    */   }
/* 401:    */   
/* 402:    */   public static List<Object[]> obtenerEstacOperativas(String areaOperativa, String idDepto, String idMunici)
/* 403:    */   {
/* 404:352 */     if (areaOperativa == null)
/* 405:    */     {
/* 406:353 */       areaOperativa = "0";
/* 407:354 */       return null;
/* 408:    */     }
/* 409:356 */     if (idDepto == null)
/* 410:    */     {
/* 411:357 */       idDepto = "0";
/* 412:358 */       return null;
/* 413:    */     }
/* 414:360 */     if (idMunici == null)
/* 415:    */     {
/* 416:361 */       idMunici = "0";
/* 417:362 */       return null;
/* 418:    */     }
/* 419:364 */     if (areaOperativa.equals("---"))
/* 420:    */     {
/* 421:365 */       areaOperativa = "0";
/* 422:366 */       return null;
/* 423:    */     }
/* 424:368 */     if (idDepto.equals("---"))
/* 425:    */     {
/* 426:369 */       idDepto = "0";
/* 427:370 */       return null;
/* 428:    */     }
/* 429:372 */     if (idMunici.equals("---"))
/* 430:    */     {
/* 431:373 */       idMunici = "0";
/* 432:374 */       return null;
/* 433:    */     }
/* 434:377 */     String query = "SELECT  e.cod_catalogo_es ,e.NOMBRE_ES  from  SIOPERAN.SIO_ORGANIZACION  r,  SIOPERAN.SIOV_ESTACIONES e,  SIOPERAN.SIOV_DIVIPOLAS div  where  r.TIPO = 'AOP'  AND r.ORGANIZACION_ID = e.ID_ORG  and div.CODIGO_DV=e.CODIGO_DIVIPOLA  and organizacion_id= " + 
/* 435:    */     
/* 436:    */ 
/* 437:    */ 
/* 438:    */ 
/* 439:    */ 
/* 440:    */ 
/* 441:    */ 
/* 442:385 */       areaOperativa + 
/* 443:386 */       " and div.departamento =  " + idDepto + " and div.id_dv =  " + 
/* 444:387 */       idMunici;
/* 445:388 */     Query q = HibernateSessionFactory.currentSession().createSQLQuery(query);
/* 446:389 */     List<Object[]> listObject = q.list();
/* 447:390 */     return listObject;
/* 448:    */   }
/* 449:    */   
/* 450:    */   public static List<Object[]> obtenerEstacOperativas(String areaOperativa)
/* 451:    */   {
/* 452:395 */     if (areaOperativa == null)
/* 453:    */     {
/* 454:396 */       areaOperativa = "0";
/* 455:397 */       return null;
/* 456:    */     }
/* 457:399 */     if (areaOperativa.equals("---"))
/* 458:    */     {
/* 459:400 */       areaOperativa = "0";
/* 460:401 */       return null;
/* 461:    */     }
/* 462:403 */     if (areaOperativa.equals(""))
/* 463:    */     {
/* 464:404 */       areaOperativa = "0";
/* 465:405 */       return null;
/* 466:    */     }
/* 467:408 */     String query = "SELECT  e.cod_catalogo_es ,e.NOMBRE_ES  from  SIOPERAN.SIO_ORGANIZACION  r,  SIOPERAN.SIOV_ESTACIONES e,  SIOPERAN.SIOV_DIVIPOLAS div  where  r.TIPO = 'AOP'  AND r.ORGANIZACION_ID = e.ID_ORG  and div.CODIGO_DV=e.CODIGO_DIVIPOLA  and organizacion_id= " + 
/* 468:    */     
/* 469:    */ 
/* 470:    */ 
/* 471:    */ 
/* 472:    */ 
/* 473:    */ 
/* 474:    */ 
/* 475:416 */       areaOperativa;
/* 476:417 */     Query q = HibernateSessionFactory.currentSession().createSQLQuery(query);
/* 477:418 */     List<Object[]> listObject = q.list();
/* 478:419 */     return listObject;
/* 479:    */   }
/* 480:    */   
/* 481:    */   public static String obtenerCodigoAreaOpe(String selectedAreaOperativa)
/* 482:    */   {
/* 483:423 */     if (selectedAreaOperativa == null) {
/* 484:424 */       return null;
/* 485:    */     }
/* 486:425 */     if (selectedAreaOperativa == "") {
/* 487:426 */       return null;
/* 488:    */     }
/* 489:427 */     Object result = HibernateSessionFactory.currentSession().getNamedQuery("codigoOrganizacion")
/* 490:428 */       .setParameter("razon", selectedAreaOperativa).uniqueResult();
/* 491:429 */     if (result != null) {
/* 492:430 */       return result.toString();
/* 493:    */     }
/* 494:432 */     return "";
/* 495:    */   }
/* 496:    */ }


/* Location:           C:\Users\Luis\Desktop\CLXX\BalanceQL\Fuentes\
 * Qualified Name:     sia.bql.hibernate.sioperan.SioOrganizacion
 * JD-Core Version:    0.7.0.1
 */