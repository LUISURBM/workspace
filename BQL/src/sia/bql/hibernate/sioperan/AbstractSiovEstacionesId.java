/*   1:    */ package sia.bql.hibernate.sioperan;
/*   2:    */ 
/*   3:    */ import java.io.Serializable;
/*   4:    */ import java.util.Date;
/*   5:    */ 
/*   6:    */ public abstract class AbstractSiovEstacionesId
/*   7:    */   implements Serializable
/*   8:    */ {
/*   9:    */   private static final long serialVersionUID = 1L;
/*  10:    */   private Long altitud;
/*  11:    */   private Double alturaReferenciaEs;
/*  12:    */   private String codigoDivipola;
/*  13:    */   private String descDivipola;
/*  14:    */   private String direccionLatitud;
/*  15:    */   private String direccionLongitud;
/*  16:    */   private Date fechaAplicacionEs;
/*  17:    */   private Date fechaCreacionEs;
/*  18:    */   private Date fechaModificacionEs;
/*  19:    */   private Long gradosLatitud;
/*  20:    */   private Long minutosLatitud;
/*  21:    */   private Long segundosLatitud;
/*  22:    */   private Long gradosLongitud;
/*  23:    */   private Long minutosLongitud;
/*  24:    */   private Long segundosLongitud;
/*  25:    */   private Long idArea;
/*  26:    */   private Long idDv;
/*  27:    */   private Long idFgda;
/*  28:    */   private Long idOrg;
/*  29:    */   private Long idEs;
/*  30:    */   private Long idPma;
/*  31:    */   private Long idZona;
/*  32:    */   private String nomArea;
/*  33:    */   private String nombreEs;
/*  34:    */   private String codCatalogoEs;
/*  35:    */   private String codInternacionalEs;
/*  36:    */   private String codInternoEs;
/*  37:    */   private String codReporteEs;
/*  38:    */   private String codOaciEs;
/*  39:    */   private String codWmoEs;
/*  40:    */   private String categoriaEs;
/*  41:    */   private String descCategoria;
/*  42:    */   private String claseEs;
/*  43:    */   private String descClase;
/*  44:    */   private String tipoEs;
/*  45:    */   private String descTipo;
/*  46:    */   private String escalaEs;
/*  47:    */   private String descEscala;
/*  48:    */   private String estadoEs;
/*  49:    */   private String descEstado;
/*  50:    */   private String nombreFgda;
/*  51:    */   private String nombrePma;
/*  52:    */   private String estadoPma;
/*  53:    */   private String nomZona;
/*  54:    */   private String idSubzona;
/*  55:    */   private String nomSubzona;
/*  56:    */   private String idCorriente;
/*  57:    */   private String objInstalacionEs;
/*  58:    */   private String descObjetivoInst;
/*  59:    */   private String comenInstalacionEs;
/*  60:    */   private String satEnlaceEs;
/*  61:    */   private String satNombreEs;
/*  62:    */   private String satVentanaEs;
/*  63:    */   private String satProtocoloEs;
/*  64:    */   private String descSatProtocolo;
/*  65:    */   private String satTipoEs;
/*  66:    */   private String descSatTipo;
/*  67:    */   
/*  68:    */   public Long getAltitud()
/*  69:    */   {
/*  70: 31 */     return this.altitud;
/*  71:    */   }
/*  72:    */   
/*  73:    */   public Double getAlturaReferenciaEs()
/*  74:    */   {
/*  75: 34 */     return this.alturaReferenciaEs;
/*  76:    */   }
/*  77:    */   
/*  78:    */   public String getCategoriaEs()
/*  79:    */   {
/*  80: 37 */     return this.categoriaEs;
/*  81:    */   }
/*  82:    */   
/*  83:    */   public String getClaseEs()
/*  84:    */   {
/*  85: 40 */     return this.claseEs;
/*  86:    */   }
/*  87:    */   
/*  88:    */   public String getCodCatalogoEs()
/*  89:    */   {
/*  90: 43 */     return this.codCatalogoEs;
/*  91:    */   }
/*  92:    */   
/*  93:    */   public String getCodigoDivipola()
/*  94:    */   {
/*  95: 46 */     return this.codigoDivipola;
/*  96:    */   }
/*  97:    */   
/*  98:    */   public String getCodInternacionalEs()
/*  99:    */   {
/* 100: 49 */     return this.codInternacionalEs;
/* 101:    */   }
/* 102:    */   
/* 103:    */   public String getCodInternoEs()
/* 104:    */   {
/* 105: 52 */     return this.codInternoEs;
/* 106:    */   }
/* 107:    */   
/* 108:    */   public String getCodOaciEs()
/* 109:    */   {
/* 110: 55 */     return this.codOaciEs;
/* 111:    */   }
/* 112:    */   
/* 113:    */   public String getCodReporteEs()
/* 114:    */   {
/* 115: 58 */     return this.codReporteEs;
/* 116:    */   }
/* 117:    */   
/* 118:    */   public String getCodWmoEs()
/* 119:    */   {
/* 120: 61 */     return this.codWmoEs;
/* 121:    */   }
/* 122:    */   
/* 123:    */   public String getComenInstalacionEs()
/* 124:    */   {
/* 125: 64 */     return this.comenInstalacionEs;
/* 126:    */   }
/* 127:    */   
/* 128:    */   public String getDescCategoria()
/* 129:    */   {
/* 130: 67 */     return this.descCategoria;
/* 131:    */   }
/* 132:    */   
/* 133:    */   public String getDescClase()
/* 134:    */   {
/* 135: 70 */     return this.descClase;
/* 136:    */   }
/* 137:    */   
/* 138:    */   public String getDescDivipola()
/* 139:    */   {
/* 140: 73 */     return this.descDivipola;
/* 141:    */   }
/* 142:    */   
/* 143:    */   public String getDescEscala()
/* 144:    */   {
/* 145: 76 */     return this.descEscala;
/* 146:    */   }
/* 147:    */   
/* 148:    */   public String getDescEstado()
/* 149:    */   {
/* 150: 79 */     return this.descEstado;
/* 151:    */   }
/* 152:    */   
/* 153:    */   public String getDescObjetivoInst()
/* 154:    */   {
/* 155: 82 */     return this.descObjetivoInst;
/* 156:    */   }
/* 157:    */   
/* 158:    */   public String getDescSatProtocolo()
/* 159:    */   {
/* 160: 85 */     return this.descSatProtocolo;
/* 161:    */   }
/* 162:    */   
/* 163:    */   public String getDescSatTipo()
/* 164:    */   {
/* 165: 88 */     return this.descSatTipo;
/* 166:    */   }
/* 167:    */   
/* 168:    */   public String getDescTipo()
/* 169:    */   {
/* 170: 91 */     return this.descTipo;
/* 171:    */   }
/* 172:    */   
/* 173:    */   public String getDireccionLatitud()
/* 174:    */   {
/* 175: 94 */     return this.direccionLatitud;
/* 176:    */   }
/* 177:    */   
/* 178:    */   public String getDireccionLongitud()
/* 179:    */   {
/* 180: 97 */     return this.direccionLongitud;
/* 181:    */   }
/* 182:    */   
/* 183:    */   public String getEscalaEs()
/* 184:    */   {
/* 185:100 */     return this.escalaEs;
/* 186:    */   }
/* 187:    */   
/* 188:    */   public String getEstadoEs()
/* 189:    */   {
/* 190:103 */     return this.estadoEs;
/* 191:    */   }
/* 192:    */   
/* 193:    */   public String getEstadoPma()
/* 194:    */   {
/* 195:106 */     return this.estadoPma;
/* 196:    */   }
/* 197:    */   
/* 198:    */   public Date getFechaAplicacionEs()
/* 199:    */   {
/* 200:109 */     return this.fechaAplicacionEs;
/* 201:    */   }
/* 202:    */   
/* 203:    */   public Date getFechaCreacionEs()
/* 204:    */   {
/* 205:112 */     return this.fechaCreacionEs;
/* 206:    */   }
/* 207:    */   
/* 208:    */   public Date getFechaModificacionEs()
/* 209:    */   {
/* 210:115 */     return this.fechaModificacionEs;
/* 211:    */   }
/* 212:    */   
/* 213:    */   public Long getGradosLatitud()
/* 214:    */   {
/* 215:118 */     return this.gradosLatitud;
/* 216:    */   }
/* 217:    */   
/* 218:    */   public Long getGradosLongitud()
/* 219:    */   {
/* 220:121 */     return this.gradosLongitud;
/* 221:    */   }
/* 222:    */   
/* 223:    */   public Long getIdArea()
/* 224:    */   {
/* 225:124 */     return this.idArea;
/* 226:    */   }
/* 227:    */   
/* 228:    */   public String getIdCorriente()
/* 229:    */   {
/* 230:127 */     return this.idCorriente;
/* 231:    */   }
/* 232:    */   
/* 233:    */   public Long getIdDv()
/* 234:    */   {
/* 235:130 */     return this.idDv;
/* 236:    */   }
/* 237:    */   
/* 238:    */   public Long getIdEs()
/* 239:    */   {
/* 240:133 */     return this.idEs;
/* 241:    */   }
/* 242:    */   
/* 243:    */   public Long getIdFgda()
/* 244:    */   {
/* 245:136 */     return this.idFgda;
/* 246:    */   }
/* 247:    */   
/* 248:    */   public Long getIdOrg()
/* 249:    */   {
/* 250:139 */     return this.idOrg;
/* 251:    */   }
/* 252:    */   
/* 253:    */   public Long getIdPma()
/* 254:    */   {
/* 255:142 */     return this.idPma;
/* 256:    */   }
/* 257:    */   
/* 258:    */   public String getIdSubzona()
/* 259:    */   {
/* 260:145 */     return this.idSubzona;
/* 261:    */   }
/* 262:    */   
/* 263:    */   public Long getIdZona()
/* 264:    */   {
/* 265:148 */     return this.idZona;
/* 266:    */   }
/* 267:    */   
/* 268:    */   public Long getMinutosLatitud()
/* 269:    */   {
/* 270:151 */     return this.minutosLatitud;
/* 271:    */   }
/* 272:    */   
/* 273:    */   public Long getMinutosLongitud()
/* 274:    */   {
/* 275:154 */     return this.minutosLongitud;
/* 276:    */   }
/* 277:    */   
/* 278:    */   public String getNomArea()
/* 279:    */   {
/* 280:157 */     return this.nomArea;
/* 281:    */   }
/* 282:    */   
/* 283:    */   public String getNombreEs()
/* 284:    */   {
/* 285:160 */     return this.nombreEs;
/* 286:    */   }
/* 287:    */   
/* 288:    */   public String getNombreFgda()
/* 289:    */   {
/* 290:163 */     return this.nombreFgda;
/* 291:    */   }
/* 292:    */   
/* 293:    */   public String getNombrePma()
/* 294:    */   {
/* 295:166 */     return this.nombrePma;
/* 296:    */   }
/* 297:    */   
/* 298:    */   public String getNomSubzona()
/* 299:    */   {
/* 300:169 */     return this.nomSubzona;
/* 301:    */   }
/* 302:    */   
/* 303:    */   public String getNomZona()
/* 304:    */   {
/* 305:172 */     return this.nomZona;
/* 306:    */   }
/* 307:    */   
/* 308:    */   public String getObjInstalacionEs()
/* 309:    */   {
/* 310:175 */     return this.objInstalacionEs;
/* 311:    */   }
/* 312:    */   
/* 313:    */   public String getSatEnlaceEs()
/* 314:    */   {
/* 315:178 */     return this.satEnlaceEs;
/* 316:    */   }
/* 317:    */   
/* 318:    */   public String getSatNombreEs()
/* 319:    */   {
/* 320:181 */     return this.satNombreEs;
/* 321:    */   }
/* 322:    */   
/* 323:    */   public String getSatProtocoloEs()
/* 324:    */   {
/* 325:184 */     return this.satProtocoloEs;
/* 326:    */   }
/* 327:    */   
/* 328:    */   public String getSatTipoEs()
/* 329:    */   {
/* 330:187 */     return this.satTipoEs;
/* 331:    */   }
/* 332:    */   
/* 333:    */   public String getSatVentanaEs()
/* 334:    */   {
/* 335:190 */     return this.satVentanaEs;
/* 336:    */   }
/* 337:    */   
/* 338:    */   public Long getSegundosLatitud()
/* 339:    */   {
/* 340:193 */     return this.segundosLatitud;
/* 341:    */   }
/* 342:    */   
/* 343:    */   public Long getSegundosLongitud()
/* 344:    */   {
/* 345:196 */     return this.segundosLongitud;
/* 346:    */   }
/* 347:    */   
/* 348:    */   public String getTipoEs()
/* 349:    */   {
/* 350:199 */     return this.tipoEs;
/* 351:    */   }
/* 352:    */   
/* 353:    */   public void setAltitud(Long altitud)
/* 354:    */   {
/* 355:202 */     this.altitud = altitud;
/* 356:    */   }
/* 357:    */   
/* 358:    */   public void setAlturaReferenciaEs(Double alturaReferenciaEs)
/* 359:    */   {
/* 360:205 */     this.alturaReferenciaEs = alturaReferenciaEs;
/* 361:    */   }
/* 362:    */   
/* 363:    */   public void setCategoriaEs(String categoriaEs)
/* 364:    */   {
/* 365:208 */     this.categoriaEs = categoriaEs;
/* 366:    */   }
/* 367:    */   
/* 368:    */   public void setClaseEs(String claseEs)
/* 369:    */   {
/* 370:211 */     this.claseEs = claseEs;
/* 371:    */   }
/* 372:    */   
/* 373:    */   public void setCodCatalogoEs(String codCatalogoEs)
/* 374:    */   {
/* 375:214 */     this.codCatalogoEs = codCatalogoEs;
/* 376:    */   }
/* 377:    */   
/* 378:    */   public void setCodigoDivipola(String codigoDivipola)
/* 379:    */   {
/* 380:217 */     this.codigoDivipola = codigoDivipola;
/* 381:    */   }
/* 382:    */   
/* 383:    */   public void setCodInternacionalEs(String codInternacionalEs)
/* 384:    */   {
/* 385:220 */     this.codInternacionalEs = codInternacionalEs;
/* 386:    */   }
/* 387:    */   
/* 388:    */   public void setCodInternoEs(String codInternoEs)
/* 389:    */   {
/* 390:223 */     this.codInternoEs = codInternoEs;
/* 391:    */   }
/* 392:    */   
/* 393:    */   public void setCodOaciEs(String codOaciEs)
/* 394:    */   {
/* 395:226 */     this.codOaciEs = codOaciEs;
/* 396:    */   }
/* 397:    */   
/* 398:    */   public void setCodReporteEs(String codReporteEs)
/* 399:    */   {
/* 400:229 */     this.codReporteEs = codReporteEs;
/* 401:    */   }
/* 402:    */   
/* 403:    */   public void setCodWmoEs(String codWmoEs)
/* 404:    */   {
/* 405:232 */     this.codWmoEs = codWmoEs;
/* 406:    */   }
/* 407:    */   
/* 408:    */   public void setComenInstalacionEs(String comenInstalacionEs)
/* 409:    */   {
/* 410:235 */     this.comenInstalacionEs = comenInstalacionEs;
/* 411:    */   }
/* 412:    */   
/* 413:    */   public void setDescCategoria(String descCategoria)
/* 414:    */   {
/* 415:238 */     this.descCategoria = descCategoria;
/* 416:    */   }
/* 417:    */   
/* 418:    */   public void setDescClase(String descClase)
/* 419:    */   {
/* 420:241 */     this.descClase = descClase;
/* 421:    */   }
/* 422:    */   
/* 423:    */   public void setDescDivipola(String descDivipola)
/* 424:    */   {
/* 425:244 */     this.descDivipola = descDivipola;
/* 426:    */   }
/* 427:    */   
/* 428:    */   public void setDescEscala(String descEscala)
/* 429:    */   {
/* 430:247 */     this.descEscala = descEscala;
/* 431:    */   }
/* 432:    */   
/* 433:    */   public void setDescEstado(String descEstado)
/* 434:    */   {
/* 435:250 */     this.descEstado = descEstado;
/* 436:    */   }
/* 437:    */   
/* 438:    */   public void setDescObjetivoInst(String descObjetivoInst)
/* 439:    */   {
/* 440:253 */     this.descObjetivoInst = descObjetivoInst;
/* 441:    */   }
/* 442:    */   
/* 443:    */   public void setDescSatProtocolo(String descSatProtocolo)
/* 444:    */   {
/* 445:256 */     this.descSatProtocolo = descSatProtocolo;
/* 446:    */   }
/* 447:    */   
/* 448:    */   public void setDescSatTipo(String descSatTipo)
/* 449:    */   {
/* 450:259 */     this.descSatTipo = descSatTipo;
/* 451:    */   }
/* 452:    */   
/* 453:    */   public void setDescTipo(String descTipo)
/* 454:    */   {
/* 455:262 */     this.descTipo = descTipo;
/* 456:    */   }
/* 457:    */   
/* 458:    */   public void setDireccionLatitud(String direccionLatitud)
/* 459:    */   {
/* 460:265 */     this.direccionLatitud = direccionLatitud;
/* 461:    */   }
/* 462:    */   
/* 463:    */   public void setDireccionLongitud(String direccionLongitud)
/* 464:    */   {
/* 465:268 */     this.direccionLongitud = direccionLongitud;
/* 466:    */   }
/* 467:    */   
/* 468:    */   public void setEscalaEs(String escalaEs)
/* 469:    */   {
/* 470:271 */     this.escalaEs = escalaEs;
/* 471:    */   }
/* 472:    */   
/* 473:    */   public void setEstadoEs(String estadoEs)
/* 474:    */   {
/* 475:274 */     this.estadoEs = estadoEs;
/* 476:    */   }
/* 477:    */   
/* 478:    */   public void setEstadoPma(String estadoPma)
/* 479:    */   {
/* 480:277 */     this.estadoPma = estadoPma;
/* 481:    */   }
/* 482:    */   
/* 483:    */   public void setFechaAplicacionEs(Date fechaAplicacionEs)
/* 484:    */   {
/* 485:280 */     this.fechaAplicacionEs = fechaAplicacionEs;
/* 486:    */   }
/* 487:    */   
/* 488:    */   public void setFechaCreacionEs(Date fechaCreacionEs)
/* 489:    */   {
/* 490:283 */     this.fechaCreacionEs = fechaCreacionEs;
/* 491:    */   }
/* 492:    */   
/* 493:    */   public void setFechaModificacionEs(Date fechaModificacionEs)
/* 494:    */   {
/* 495:286 */     this.fechaModificacionEs = fechaModificacionEs;
/* 496:    */   }
/* 497:    */   
/* 498:    */   public void setGradosLatitud(Long gradosLatitud)
/* 499:    */   {
/* 500:289 */     this.gradosLatitud = gradosLatitud;
/* 501:    */   }
/* 502:    */   
/* 503:    */   public void setGradosLongitud(Long gradosLongitud)
/* 504:    */   {
/* 505:292 */     this.gradosLongitud = gradosLongitud;
/* 506:    */   }
/* 507:    */   
/* 508:    */   public void setIdArea(Long idArea)
/* 509:    */   {
/* 510:295 */     this.idArea = idArea;
/* 511:    */   }
/* 512:    */   
/* 513:    */   public void setIdCorriente(String idCorriente)
/* 514:    */   {
/* 515:298 */     this.idCorriente = idCorriente;
/* 516:    */   }
/* 517:    */   
/* 518:    */   public void setIdDv(Long idDv)
/* 519:    */   {
/* 520:301 */     this.idDv = idDv;
/* 521:    */   }
/* 522:    */   
/* 523:    */   public void setIdEs(Long idEs)
/* 524:    */   {
/* 525:304 */     this.idEs = idEs;
/* 526:    */   }
/* 527:    */   
/* 528:    */   public void setIdFgda(Long idFgda)
/* 529:    */   {
/* 530:307 */     this.idFgda = idFgda;
/* 531:    */   }
/* 532:    */   
/* 533:    */   public void setIdOrg(Long idOrg)
/* 534:    */   {
/* 535:310 */     this.idOrg = idOrg;
/* 536:    */   }
/* 537:    */   
/* 538:    */   public void setIdPma(Long idPma)
/* 539:    */   {
/* 540:313 */     this.idPma = idPma;
/* 541:    */   }
/* 542:    */   
/* 543:    */   public void setIdSubzona(String idSubzona)
/* 544:    */   {
/* 545:316 */     this.idSubzona = idSubzona;
/* 546:    */   }
/* 547:    */   
/* 548:    */   public void setIdZona(Long idZona)
/* 549:    */   {
/* 550:319 */     this.idZona = idZona;
/* 551:    */   }
/* 552:    */   
/* 553:    */   public void setMinutosLatitud(Long minutosLatitud)
/* 554:    */   {
/* 555:322 */     this.minutosLatitud = minutosLatitud;
/* 556:    */   }
/* 557:    */   
/* 558:    */   public void setMinutosLongitud(Long minutosLongitud)
/* 559:    */   {
/* 560:325 */     this.minutosLongitud = minutosLongitud;
/* 561:    */   }
/* 562:    */   
/* 563:    */   public void setNomArea(String nomArea)
/* 564:    */   {
/* 565:328 */     this.nomArea = nomArea;
/* 566:    */   }
/* 567:    */   
/* 568:    */   public void setNombreEs(String nombreEs)
/* 569:    */   {
/* 570:331 */     this.nombreEs = nombreEs;
/* 571:    */   }
/* 572:    */   
/* 573:    */   public void setNombreFgda(String nombreFgda)
/* 574:    */   {
/* 575:334 */     this.nombreFgda = nombreFgda;
/* 576:    */   }
/* 577:    */   
/* 578:    */   public void setNombrePma(String nombrePma)
/* 579:    */   {
/* 580:337 */     this.nombrePma = nombrePma;
/* 581:    */   }
/* 582:    */   
/* 583:    */   public void setNomSubzona(String nomSubzona)
/* 584:    */   {
/* 585:340 */     this.nomSubzona = nomSubzona;
/* 586:    */   }
/* 587:    */   
/* 588:    */   public void setNomZona(String nomZona)
/* 589:    */   {
/* 590:343 */     this.nomZona = nomZona;
/* 591:    */   }
/* 592:    */   
/* 593:    */   public void setObjInstalacionEs(String objInstalacionEs)
/* 594:    */   {
/* 595:346 */     this.objInstalacionEs = objInstalacionEs;
/* 596:    */   }
/* 597:    */   
/* 598:    */   public void setSatEnlaceEs(String satEnlaceEs)
/* 599:    */   {
/* 600:349 */     this.satEnlaceEs = satEnlaceEs;
/* 601:    */   }
/* 602:    */   
/* 603:    */   public void setSatNombreEs(String satNombreEs)
/* 604:    */   {
/* 605:352 */     this.satNombreEs = satNombreEs;
/* 606:    */   }
/* 607:    */   
/* 608:    */   public void setSatProtocoloEs(String satProtocoloEs)
/* 609:    */   {
/* 610:355 */     this.satProtocoloEs = satProtocoloEs;
/* 611:    */   }
/* 612:    */   
/* 613:    */   public void setSatTipoEs(String satTipoEs)
/* 614:    */   {
/* 615:358 */     this.satTipoEs = satTipoEs;
/* 616:    */   }
/* 617:    */   
/* 618:    */   public void setSatVentanaEs(String satVentanaEs)
/* 619:    */   {
/* 620:361 */     this.satVentanaEs = satVentanaEs;
/* 621:    */   }
/* 622:    */   
/* 623:    */   public void setSegundosLatitud(Long segundosLatitud)
/* 624:    */   {
/* 625:364 */     this.segundosLatitud = segundosLatitud;
/* 626:    */   }
/* 627:    */   
/* 628:    */   public void setSegundosLongitud(Long segundosLongitud)
/* 629:    */   {
/* 630:367 */     this.segundosLongitud = segundosLongitud;
/* 631:    */   }
/* 632:    */   
/* 633:    */   public void setTipoEs(String tipoEs)
/* 634:    */   {
/* 635:370 */     this.tipoEs = tipoEs;
/* 636:    */   }
/* 637:    */ }


/* Location:           C:\Users\Luis\Desktop\CLXX\BalanceQL\Fuentes\
 * Qualified Name:     sia.bql.hibernate.sioperan.AbstractSiovEstacionesId
 * JD-Core Version:    0.7.0.1
 */