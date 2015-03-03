/*    1:     */ package sia.bql.hibernate.sioperan;
/*    2:     */ 
/*    3:     */ import java.io.Serializable;
/*    4:     */ import java.util.Date;
/*    5:     */ import java.util.HashSet;
/*    6:     */ import java.util.Set;
/*    7:     */ 
/*    8:     */ public abstract class AbstractIdtFamilies
/*    9:     */   implements Serializable
/*   10:     */ {
/*   11:     */   private static final long serialVersionUID = 1L;
/*   12:     */   private String fmlDatatype;
/*   13:     */   private Long fmlDecimal;
/*   14:     */   private String fmlDescription;
/*   15:     */   private Long fmlLong;
/*   16:     */   private String fmlName;
/*   17:     */   private Date fmlTimestamp;
/*   18:     */   private IdtFamiliesId id;
/*   19:  33 */   private Set idtAggregationsesForAggFmlFk = new HashSet(0);
/*   20:  35 */   private Set idtAggregationsesForAggFmlTypeFk = new HashSet(0);
/*   21:  37 */   private Set idtBoundses = new HashSet(0);
/*   22:  39 */   private Set idtCleanProductionses = new HashSet(0);
/*   23:  41 */   private Set idtClprCrcses = new HashSet(0);
/*   24:  43 */   private Set idtEqpCmbses = new HashSet(0);
/*   25:  45 */   private Set idtEqpCrcses = new HashSet(0);
/*   26:  47 */   private Set idtEquationses = new HashSet(0);
/*   27:  49 */   private Set idtEquationTableses = new HashSet(0);
/*   28:  51 */   private Set idtEquipmentses = new HashSet(0);
/*   29:  53 */   private Set idtFieldses = new HashSet(0);
/*   30:  55 */   private Set idtFmlCrcsesForFmcrFmlFk = new HashSet(0);
/*   31:  57 */   private Set idtFmlCrcsesForFmcrFmlXFk = new HashSet(0);
/*   32:  59 */   private Set idtFmlUbcsesForFmubFmlFk = new HashSet(0);
/*   33:  61 */   private Set idtFmlUbcsesForFmubFmlUbcFk = new HashSet(0);
/*   34:  63 */   private Set idtFurCrcses = new HashSet(0);
/*   35:  65 */   private Set idtFurEqpCrcses = new HashSet(0);
/*   36:  67 */   private Set idtFurPrdCrcses = new HashSet(0);
/*   37:  69 */   private Set idtFurRsdCrcsesForFrrscrFmlFk = new HashSet(0);
/*   38:  71 */   private Set idtFurRsdCrcsesForFrrscrFmlXFk = new HashSet(0);
/*   39:  73 */   private Set idtFurStrCrcses = new HashSet(0);
/*   40:  75 */   private Set idtFurSttCrcses = new HashSet(0);
/*   41:  77 */   private Set idtInsCrcses = new HashSet(0);
/*   42:  79 */   private Set idtInstrumentTypeses = new HashSet(0);
/*   43:  81 */   private Set idtMeasureFieldses = new HashSet(0);
/*   44:  83 */   private Set idtMeasureses = new HashSet(0);
/*   45:  85 */   private Set idtMeasureTypeses = new HashSet(0);
/*   46:  87 */   private Set idtMsrCrcses = new HashSet(0);
/*   47:  89 */   private Set idtMsrPrsses = new HashSet(0);
/*   48:  91 */   private Set idtMultiannualsesForMlanFmlOriginAvFk = new HashSet(0);
/*   49:  93 */   private Set idtMultiannualsesForMlanFmlOriginMnFk = new HashSet(0);
/*   50:  95 */   private Set idtMultiannualsesForMlanFmlOriginMxFk = new HashSet(0);
/*   51:  97 */   private Set idtMultiannualsesForMlanFmlTypeFk = new HashSet(0);
/*   52:  99 */   private Set idtOffCrcses = new HashSet(0);
/*   53: 101 */   private Set idtOffUbcses = new HashSet(0);
/*   54: 103 */   private Set idtOptionses = new HashSet(0);
/*   55: 105 */   private Set idtOrgCrcses = new HashSet(0);
/*   56: 107 */   private Set idtOrgPrsses = new HashSet(0);
/*   57: 109 */   private Set idtOrgUbcses = new HashSet(0);
/*   58: 111 */   private Set idtProductses = new HashSet(0);
/*   59: 113 */   private Set idtPrsCrcses = new HashSet(0);
/*   60: 115 */   private Set idtPrsUbcses = new HashSet(0);
/*   61: 117 */   private Set idtReadingsesForRdnFmlFk = new HashSet(0);
/*   62: 119 */   private Set idtReadingsesForRdnFmlStateFk = new HashSet(0);
/*   63: 121 */   private Set idtStationses = new HashSet(0);
/*   64: 123 */   private Set idtStorageses = new HashSet(0);
/*   65: 125 */   private Set idtSttCrcses = new HashSet(0);
/*   66: 127 */   private Set idtTimePeriodses = new HashSet(0);
/*   67: 129 */   private Set idtTimeScaleses = new HashSet(0);
/*   68: 131 */   private Set idtTmprCrcses = new HashSet(0);
/*   69: 133 */   private Set idtTramitsesForTrmFmlAuthFk = new HashSet(0);
/*   70: 135 */   private Set idtTramitsesForTrmFmlFk = new HashSet(0);
/*   71: 137 */   private Set idtTramitsesForTrmFmlTramitFk = new HashSet(0);
/*   72: 139 */   private Set idtUbcCrcses = new HashSet(0);
/*   73: 141 */   private Set idtUbicationses = new HashSet(0);
/*   74:     */   private IdtUsers idtUsers;
/*   75: 145 */   private Set idtUsrFmlsesForUsfmFmlCategoriaFk = new HashSet(0);
/*   76: 147 */   private Set idtUsrFmlsesForUsfmFmlFk = new HashSet(0);
/*   77: 149 */   private Set idtUsrOffses = new HashSet(0);
/*   78: 151 */   private Set idtValuesesForVleFmlFk = new HashSet(0);
/*   79: 153 */   private Set idtValuesesForVleFmlOriginFk = new HashSet(0);
/*   80: 155 */   private Set idtVariableses = new HashSet(0);
/*   81: 157 */   private Set idtVleCrcses = new HashSet(0);
/*   82: 159 */   private Set idtWaterRelationses = new HashSet(0);
/*   83: 161 */   private Set idtWaterses = new HashSet(0);
/*   84: 163 */   private Set idtWtrCrcses = new HashSet(0);
/*   85:     */   
/*   86:     */   public AbstractIdtFamilies() {}
/*   87:     */   
/*   88:     */   public AbstractIdtFamilies(IdtFamiliesId id, IdtUsers idtUsers, String fmlName, Date fmlTimestamp)
/*   89:     */   {
/*   90: 183 */     this.id = id;
/*   91: 184 */     this.idtUsers = idtUsers;
/*   92: 185 */     this.fmlName = fmlName;
/*   93: 186 */     this.fmlTimestamp = fmlTimestamp;
/*   94:     */   }
/*   95:     */   
/*   96:     */   public AbstractIdtFamilies(IdtFamiliesId id, IdtUsers idtUsers, String fmlName, String fmlDescription, String fmlDatatype, Long fmlLong, Long fmlDecimal, Date fmlTimestamp, Set idtFurCrcses, Set idtEquipmentses, Set idtTramitsesForTrmFmlTramitFk, Set idtInsCrcses, Set idtCleanProductionses, Set idtUsrOffses, Set idtTramitsesForTrmFmlAuthFk, Set idtStorageses, Set idtMultiannualsesForMlanFmlOriginAvFk, Set idtEquationses, Set idtAggregationsesForAggFmlTypeFk, Set idtProductses, Set idtSttCrcses, Set idtUsrFmlsesForUsfmFmlCategoriaFk, Set idtFmlCrcsesForFmcrFmlXFk, Set idtMeasureTypeses, Set idtFurEqpCrcses, Set idtOffUbcses, Set idtValuesesForVleFmlFk, Set idtEqpCrcses, Set idtMsrPrsses, Set idtReadingsesForRdnFmlStateFk, Set idtFurRsdCrcsesForFrrscrFmlFk, Set idtClprCrcses, Set idtUsrFmlsesForUsfmFmlFk, Set idtUbicationses, Set idtFieldses, Set idtOrgPrsses, Set idtFmlUbcsesForFmubFmlUbcFk, Set idtUbcCrcses, Set idtMeasureses, Set idtOrgCrcses, Set idtVleCrcses, Set idtFurSttCrcses, Set idtWaterses, Set idtAggregationsesForAggFmlFk, Set idtMsrCrcses, Set idtFurStrCrcses, Set idtWtrCrcses, Set idtMultiannualsesForMlanFmlTypeFk, Set idtEquationTableses, Set idtReadingsesForRdnFmlFk, Set idtMeasureFieldses, Set idtEqpCmbses, Set idtOrgUbcses, Set idtMultiannualsesForMlanFmlOriginMxFk, Set idtFmlCrcsesForFmcrFmlFk, Set idtTimePeriodses, Set idtPrsUbcses, Set idtStationses, Set idtTmprCrcses, Set idtInstrumentTypeses, Set idtFurRsdCrcsesForFrrscrFmlXFk, Set idtValuesesForVleFmlOriginFk, Set idtOptionses, Set idtTimeScaleses, Set idtPrsCrcses, Set idtMultiannualsesForMlanFmlOriginMnFk, Set idtVariableses, Set idtFurPrdCrcses, Set idtBoundses, Set idtOffCrcses, Set idtFmlUbcsesForFmubFmlFk, Set idtWaterRelationses, Set idtTramitsesForTrmFmlFk)
/*   97:     */   {
/*   98: 340 */     this.id = id;
/*   99: 341 */     this.idtUsers = idtUsers;
/*  100: 342 */     this.fmlName = fmlName;
/*  101: 343 */     this.fmlDescription = fmlDescription;
/*  102: 344 */     this.fmlDatatype = fmlDatatype;
/*  103: 345 */     this.fmlLong = fmlLong;
/*  104: 346 */     this.fmlDecimal = fmlDecimal;
/*  105: 347 */     this.fmlTimestamp = fmlTimestamp;
/*  106: 348 */     this.idtFurCrcses = idtFurCrcses;
/*  107: 349 */     this.idtEquipmentses = idtEquipmentses;
/*  108: 350 */     this.idtTramitsesForTrmFmlTramitFk = idtTramitsesForTrmFmlTramitFk;
/*  109: 351 */     this.idtInsCrcses = idtInsCrcses;
/*  110: 352 */     this.idtCleanProductionses = idtCleanProductionses;
/*  111: 353 */     this.idtUsrOffses = idtUsrOffses;
/*  112: 354 */     this.idtTramitsesForTrmFmlAuthFk = idtTramitsesForTrmFmlAuthFk;
/*  113: 355 */     this.idtStorageses = idtStorageses;
/*  114: 356 */     this.idtMultiannualsesForMlanFmlOriginAvFk = idtMultiannualsesForMlanFmlOriginAvFk;
/*  115: 357 */     this.idtEquationses = idtEquationses;
/*  116: 358 */     this.idtAggregationsesForAggFmlTypeFk = idtAggregationsesForAggFmlTypeFk;
/*  117: 359 */     this.idtProductses = idtProductses;
/*  118: 360 */     this.idtSttCrcses = idtSttCrcses;
/*  119: 361 */     this.idtUsrFmlsesForUsfmFmlCategoriaFk = idtUsrFmlsesForUsfmFmlCategoriaFk;
/*  120: 362 */     this.idtFmlCrcsesForFmcrFmlXFk = idtFmlCrcsesForFmcrFmlXFk;
/*  121: 363 */     this.idtMeasureTypeses = idtMeasureTypeses;
/*  122: 364 */     this.idtFurEqpCrcses = idtFurEqpCrcses;
/*  123: 365 */     this.idtOffUbcses = idtOffUbcses;
/*  124: 366 */     this.idtValuesesForVleFmlFk = idtValuesesForVleFmlFk;
/*  125: 367 */     this.idtEqpCrcses = idtEqpCrcses;
/*  126: 368 */     this.idtMsrPrsses = idtMsrPrsses;
/*  127: 369 */     this.idtReadingsesForRdnFmlStateFk = idtReadingsesForRdnFmlStateFk;
/*  128: 370 */     this.idtFurRsdCrcsesForFrrscrFmlFk = idtFurRsdCrcsesForFrrscrFmlFk;
/*  129: 371 */     this.idtClprCrcses = idtClprCrcses;
/*  130: 372 */     this.idtUsrFmlsesForUsfmFmlFk = idtUsrFmlsesForUsfmFmlFk;
/*  131: 373 */     this.idtUbicationses = idtUbicationses;
/*  132: 374 */     this.idtFieldses = idtFieldses;
/*  133: 375 */     this.idtOrgPrsses = idtOrgPrsses;
/*  134: 376 */     this.idtFmlUbcsesForFmubFmlUbcFk = idtFmlUbcsesForFmubFmlUbcFk;
/*  135: 377 */     this.idtUbcCrcses = idtUbcCrcses;
/*  136: 378 */     this.idtMeasureses = idtMeasureses;
/*  137: 379 */     this.idtOrgCrcses = idtOrgCrcses;
/*  138: 380 */     this.idtVleCrcses = idtVleCrcses;
/*  139: 381 */     this.idtFurSttCrcses = idtFurSttCrcses;
/*  140: 382 */     this.idtWaterses = idtWaterses;
/*  141: 383 */     this.idtAggregationsesForAggFmlFk = idtAggregationsesForAggFmlFk;
/*  142: 384 */     this.idtMsrCrcses = idtMsrCrcses;
/*  143: 385 */     this.idtFurStrCrcses = idtFurStrCrcses;
/*  144: 386 */     this.idtWtrCrcses = idtWtrCrcses;
/*  145: 387 */     this.idtMultiannualsesForMlanFmlTypeFk = idtMultiannualsesForMlanFmlTypeFk;
/*  146: 388 */     this.idtEquationTableses = idtEquationTableses;
/*  147: 389 */     this.idtReadingsesForRdnFmlFk = idtReadingsesForRdnFmlFk;
/*  148: 390 */     this.idtMeasureFieldses = idtMeasureFieldses;
/*  149: 391 */     this.idtEqpCmbses = idtEqpCmbses;
/*  150: 392 */     this.idtOrgUbcses = idtOrgUbcses;
/*  151: 393 */     this.idtMultiannualsesForMlanFmlOriginMxFk = idtMultiannualsesForMlanFmlOriginMxFk;
/*  152: 394 */     this.idtFmlCrcsesForFmcrFmlFk = idtFmlCrcsesForFmcrFmlFk;
/*  153: 395 */     this.idtTimePeriodses = idtTimePeriodses;
/*  154: 396 */     this.idtPrsUbcses = idtPrsUbcses;
/*  155: 397 */     this.idtStationses = idtStationses;
/*  156: 398 */     this.idtTmprCrcses = idtTmprCrcses;
/*  157: 399 */     this.idtInstrumentTypeses = idtInstrumentTypeses;
/*  158: 400 */     this.idtFurRsdCrcsesForFrrscrFmlXFk = idtFurRsdCrcsesForFrrscrFmlXFk;
/*  159: 401 */     this.idtValuesesForVleFmlOriginFk = idtValuesesForVleFmlOriginFk;
/*  160: 402 */     this.idtOptionses = idtOptionses;
/*  161: 403 */     this.idtTimeScaleses = idtTimeScaleses;
/*  162: 404 */     this.idtPrsCrcses = idtPrsCrcses;
/*  163: 405 */     this.idtMultiannualsesForMlanFmlOriginMnFk = idtMultiannualsesForMlanFmlOriginMnFk;
/*  164: 406 */     this.idtVariableses = idtVariableses;
/*  165: 407 */     this.idtFurPrdCrcses = idtFurPrdCrcses;
/*  166: 408 */     this.idtBoundses = idtBoundses;
/*  167: 409 */     this.idtOffCrcses = idtOffCrcses;
/*  168: 410 */     this.idtFmlUbcsesForFmubFmlFk = idtFmlUbcsesForFmubFmlFk;
/*  169: 411 */     this.idtWaterRelationses = idtWaterRelationses;
/*  170: 412 */     this.idtTramitsesForTrmFmlFk = idtTramitsesForTrmFmlFk;
/*  171:     */   }
/*  172:     */   
/*  173:     */   public String getFmlDatatype()
/*  174:     */   {
/*  175: 420 */     return this.fmlDatatype;
/*  176:     */   }
/*  177:     */   
/*  178:     */   public Long getFmlDecimal()
/*  179:     */   {
/*  180: 428 */     return this.fmlDecimal;
/*  181:     */   }
/*  182:     */   
/*  183:     */   public String getFmlDescription()
/*  184:     */   {
/*  185: 436 */     return this.fmlDescription;
/*  186:     */   }
/*  187:     */   
/*  188:     */   public Long getFmlLong()
/*  189:     */   {
/*  190: 444 */     return this.fmlLong;
/*  191:     */   }
/*  192:     */   
/*  193:     */   public String getFmlName()
/*  194:     */   {
/*  195: 452 */     return this.fmlName;
/*  196:     */   }
/*  197:     */   
/*  198:     */   public Date getFmlTimestamp()
/*  199:     */   {
/*  200: 460 */     return this.fmlTimestamp;
/*  201:     */   }
/*  202:     */   
/*  203:     */   public IdtFamiliesId getId()
/*  204:     */   {
/*  205: 469 */     return this.id;
/*  206:     */   }
/*  207:     */   
/*  208:     */   public Set getIdtAggregationsesForAggFmlFk()
/*  209:     */   {
/*  210: 477 */     return this.idtAggregationsesForAggFmlFk;
/*  211:     */   }
/*  212:     */   
/*  213:     */   public Set getIdtAggregationsesForAggFmlTypeFk()
/*  214:     */   {
/*  215: 485 */     return this.idtAggregationsesForAggFmlTypeFk;
/*  216:     */   }
/*  217:     */   
/*  218:     */   public Set getIdtBoundses()
/*  219:     */   {
/*  220: 493 */     return this.idtBoundses;
/*  221:     */   }
/*  222:     */   
/*  223:     */   public Set getIdtCleanProductionses()
/*  224:     */   {
/*  225: 501 */     return this.idtCleanProductionses;
/*  226:     */   }
/*  227:     */   
/*  228:     */   public Set getIdtClprCrcses()
/*  229:     */   {
/*  230: 509 */     return this.idtClprCrcses;
/*  231:     */   }
/*  232:     */   
/*  233:     */   public Set getIdtEqpCmbses()
/*  234:     */   {
/*  235: 517 */     return this.idtEqpCmbses;
/*  236:     */   }
/*  237:     */   
/*  238:     */   public Set getIdtEqpCrcses()
/*  239:     */   {
/*  240: 525 */     return this.idtEqpCrcses;
/*  241:     */   }
/*  242:     */   
/*  243:     */   public Set getIdtEquationses()
/*  244:     */   {
/*  245: 533 */     return this.idtEquationses;
/*  246:     */   }
/*  247:     */   
/*  248:     */   public Set getIdtEquationTableses()
/*  249:     */   {
/*  250: 541 */     return this.idtEquationTableses;
/*  251:     */   }
/*  252:     */   
/*  253:     */   public Set getIdtEquipmentses()
/*  254:     */   {
/*  255: 549 */     return this.idtEquipmentses;
/*  256:     */   }
/*  257:     */   
/*  258:     */   public Set getIdtFieldses()
/*  259:     */   {
/*  260: 557 */     return this.idtFieldses;
/*  261:     */   }
/*  262:     */   
/*  263:     */   public Set getIdtFmlCrcsesForFmcrFmlFk()
/*  264:     */   {
/*  265: 565 */     return this.idtFmlCrcsesForFmcrFmlFk;
/*  266:     */   }
/*  267:     */   
/*  268:     */   public Set getIdtFmlCrcsesForFmcrFmlXFk()
/*  269:     */   {
/*  270: 573 */     return this.idtFmlCrcsesForFmcrFmlXFk;
/*  271:     */   }
/*  272:     */   
/*  273:     */   public Set getIdtFmlUbcsesForFmubFmlFk()
/*  274:     */   {
/*  275: 581 */     return this.idtFmlUbcsesForFmubFmlFk;
/*  276:     */   }
/*  277:     */   
/*  278:     */   public Set getIdtFmlUbcsesForFmubFmlUbcFk()
/*  279:     */   {
/*  280: 589 */     return this.idtFmlUbcsesForFmubFmlUbcFk;
/*  281:     */   }
/*  282:     */   
/*  283:     */   public Set getIdtFurCrcses()
/*  284:     */   {
/*  285: 597 */     return this.idtFurCrcses;
/*  286:     */   }
/*  287:     */   
/*  288:     */   public Set getIdtFurEqpCrcses()
/*  289:     */   {
/*  290: 605 */     return this.idtFurEqpCrcses;
/*  291:     */   }
/*  292:     */   
/*  293:     */   public Set getIdtFurPrdCrcses()
/*  294:     */   {
/*  295: 613 */     return this.idtFurPrdCrcses;
/*  296:     */   }
/*  297:     */   
/*  298:     */   public Set getIdtFurRsdCrcsesForFrrscrFmlFk()
/*  299:     */   {
/*  300: 621 */     return this.idtFurRsdCrcsesForFrrscrFmlFk;
/*  301:     */   }
/*  302:     */   
/*  303:     */   public Set getIdtFurRsdCrcsesForFrrscrFmlXFk()
/*  304:     */   {
/*  305: 629 */     return this.idtFurRsdCrcsesForFrrscrFmlXFk;
/*  306:     */   }
/*  307:     */   
/*  308:     */   public Set getIdtFurStrCrcses()
/*  309:     */   {
/*  310: 637 */     return this.idtFurStrCrcses;
/*  311:     */   }
/*  312:     */   
/*  313:     */   public Set getIdtFurSttCrcses()
/*  314:     */   {
/*  315: 645 */     return this.idtFurSttCrcses;
/*  316:     */   }
/*  317:     */   
/*  318:     */   public Set getIdtInsCrcses()
/*  319:     */   {
/*  320: 653 */     return this.idtInsCrcses;
/*  321:     */   }
/*  322:     */   
/*  323:     */   public Set getIdtInstrumentTypeses()
/*  324:     */   {
/*  325: 661 */     return this.idtInstrumentTypeses;
/*  326:     */   }
/*  327:     */   
/*  328:     */   public Set getIdtMeasureFieldses()
/*  329:     */   {
/*  330: 669 */     return this.idtMeasureFieldses;
/*  331:     */   }
/*  332:     */   
/*  333:     */   public Set getIdtMeasureses()
/*  334:     */   {
/*  335: 677 */     return this.idtMeasureses;
/*  336:     */   }
/*  337:     */   
/*  338:     */   public Set getIdtMeasureTypeses()
/*  339:     */   {
/*  340: 685 */     return this.idtMeasureTypeses;
/*  341:     */   }
/*  342:     */   
/*  343:     */   public Set getIdtMsrCrcses()
/*  344:     */   {
/*  345: 693 */     return this.idtMsrCrcses;
/*  346:     */   }
/*  347:     */   
/*  348:     */   public Set getIdtMsrPrsses()
/*  349:     */   {
/*  350: 701 */     return this.idtMsrPrsses;
/*  351:     */   }
/*  352:     */   
/*  353:     */   public Set getIdtMultiannualsesForMlanFmlOriginAvFk()
/*  354:     */   {
/*  355: 709 */     return this.idtMultiannualsesForMlanFmlOriginAvFk;
/*  356:     */   }
/*  357:     */   
/*  358:     */   public Set getIdtMultiannualsesForMlanFmlOriginMnFk()
/*  359:     */   {
/*  360: 717 */     return this.idtMultiannualsesForMlanFmlOriginMnFk;
/*  361:     */   }
/*  362:     */   
/*  363:     */   public Set getIdtMultiannualsesForMlanFmlOriginMxFk()
/*  364:     */   {
/*  365: 725 */     return this.idtMultiannualsesForMlanFmlOriginMxFk;
/*  366:     */   }
/*  367:     */   
/*  368:     */   public Set getIdtMultiannualsesForMlanFmlTypeFk()
/*  369:     */   {
/*  370: 733 */     return this.idtMultiannualsesForMlanFmlTypeFk;
/*  371:     */   }
/*  372:     */   
/*  373:     */   public Set getIdtOffCrcses()
/*  374:     */   {
/*  375: 741 */     return this.idtOffCrcses;
/*  376:     */   }
/*  377:     */   
/*  378:     */   public Set getIdtOffUbcses()
/*  379:     */   {
/*  380: 749 */     return this.idtOffUbcses;
/*  381:     */   }
/*  382:     */   
/*  383:     */   public Set getIdtOptionses()
/*  384:     */   {
/*  385: 757 */     return this.idtOptionses;
/*  386:     */   }
/*  387:     */   
/*  388:     */   public Set getIdtOrgCrcses()
/*  389:     */   {
/*  390: 765 */     return this.idtOrgCrcses;
/*  391:     */   }
/*  392:     */   
/*  393:     */   public Set getIdtOrgPrsses()
/*  394:     */   {
/*  395: 773 */     return this.idtOrgPrsses;
/*  396:     */   }
/*  397:     */   
/*  398:     */   public Set getIdtOrgUbcses()
/*  399:     */   {
/*  400: 781 */     return this.idtOrgUbcses;
/*  401:     */   }
/*  402:     */   
/*  403:     */   public Set getIdtProductses()
/*  404:     */   {
/*  405: 789 */     return this.idtProductses;
/*  406:     */   }
/*  407:     */   
/*  408:     */   public Set getIdtPrsCrcses()
/*  409:     */   {
/*  410: 797 */     return this.idtPrsCrcses;
/*  411:     */   }
/*  412:     */   
/*  413:     */   public Set getIdtPrsUbcses()
/*  414:     */   {
/*  415: 805 */     return this.idtPrsUbcses;
/*  416:     */   }
/*  417:     */   
/*  418:     */   public Set getIdtReadingsesForRdnFmlFk()
/*  419:     */   {
/*  420: 813 */     return this.idtReadingsesForRdnFmlFk;
/*  421:     */   }
/*  422:     */   
/*  423:     */   public Set getIdtReadingsesForRdnFmlStateFk()
/*  424:     */   {
/*  425: 821 */     return this.idtReadingsesForRdnFmlStateFk;
/*  426:     */   }
/*  427:     */   
/*  428:     */   public Set getIdtStationses()
/*  429:     */   {
/*  430: 829 */     return this.idtStationses;
/*  431:     */   }
/*  432:     */   
/*  433:     */   public Set getIdtStorageses()
/*  434:     */   {
/*  435: 837 */     return this.idtStorageses;
/*  436:     */   }
/*  437:     */   
/*  438:     */   public Set getIdtSttCrcses()
/*  439:     */   {
/*  440: 845 */     return this.idtSttCrcses;
/*  441:     */   }
/*  442:     */   
/*  443:     */   public Set getIdtTimePeriodses()
/*  444:     */   {
/*  445: 853 */     return this.idtTimePeriodses;
/*  446:     */   }
/*  447:     */   
/*  448:     */   public Set getIdtTimeScaleses()
/*  449:     */   {
/*  450: 861 */     return this.idtTimeScaleses;
/*  451:     */   }
/*  452:     */   
/*  453:     */   public Set getIdtTmprCrcses()
/*  454:     */   {
/*  455: 869 */     return this.idtTmprCrcses;
/*  456:     */   }
/*  457:     */   
/*  458:     */   public Set getIdtTramitsesForTrmFmlAuthFk()
/*  459:     */   {
/*  460: 877 */     return this.idtTramitsesForTrmFmlAuthFk;
/*  461:     */   }
/*  462:     */   
/*  463:     */   public Set getIdtTramitsesForTrmFmlFk()
/*  464:     */   {
/*  465: 885 */     return this.idtTramitsesForTrmFmlFk;
/*  466:     */   }
/*  467:     */   
/*  468:     */   public Set getIdtTramitsesForTrmFmlTramitFk()
/*  469:     */   {
/*  470: 893 */     return this.idtTramitsesForTrmFmlTramitFk;
/*  471:     */   }
/*  472:     */   
/*  473:     */   public Set getIdtUbcCrcses()
/*  474:     */   {
/*  475: 901 */     return this.idtUbcCrcses;
/*  476:     */   }
/*  477:     */   
/*  478:     */   public Set getIdtUbicationses()
/*  479:     */   {
/*  480: 909 */     return this.idtUbicationses;
/*  481:     */   }
/*  482:     */   
/*  483:     */   public IdtUsers getIdtUsers()
/*  484:     */   {
/*  485: 917 */     return this.idtUsers;
/*  486:     */   }
/*  487:     */   
/*  488:     */   public Set getIdtUsrFmlsesForUsfmFmlCategoriaFk()
/*  489:     */   {
/*  490: 925 */     return this.idtUsrFmlsesForUsfmFmlCategoriaFk;
/*  491:     */   }
/*  492:     */   
/*  493:     */   public Set getIdtUsrFmlsesForUsfmFmlFk()
/*  494:     */   {
/*  495: 933 */     return this.idtUsrFmlsesForUsfmFmlFk;
/*  496:     */   }
/*  497:     */   
/*  498:     */   public Set getIdtUsrOffses()
/*  499:     */   {
/*  500: 941 */     return this.idtUsrOffses;
/*  501:     */   }
/*  502:     */   
/*  503:     */   public Set getIdtValuesesForVleFmlFk()
/*  504:     */   {
/*  505: 949 */     return this.idtValuesesForVleFmlFk;
/*  506:     */   }
/*  507:     */   
/*  508:     */   public Set getIdtValuesesForVleFmlOriginFk()
/*  509:     */   {
/*  510: 957 */     return this.idtValuesesForVleFmlOriginFk;
/*  511:     */   }
/*  512:     */   
/*  513:     */   public Set getIdtVariableses()
/*  514:     */   {
/*  515: 965 */     return this.idtVariableses;
/*  516:     */   }
/*  517:     */   
/*  518:     */   public Set getIdtVleCrcses()
/*  519:     */   {
/*  520: 973 */     return this.idtVleCrcses;
/*  521:     */   }
/*  522:     */   
/*  523:     */   public Set getIdtWaterRelationses()
/*  524:     */   {
/*  525: 981 */     return this.idtWaterRelationses;
/*  526:     */   }
/*  527:     */   
/*  528:     */   public Set getIdtWaterses()
/*  529:     */   {
/*  530: 989 */     return this.idtWaterses;
/*  531:     */   }
/*  532:     */   
/*  533:     */   public Set getIdtWtrCrcses()
/*  534:     */   {
/*  535: 997 */     return this.idtWtrCrcses;
/*  536:     */   }
/*  537:     */   
/*  538:     */   public void setFmlDatatype(String fmlDatatype)
/*  539:     */   {
/*  540:1006 */     this.fmlDatatype = fmlDatatype;
/*  541:     */   }
/*  542:     */   
/*  543:     */   public void setFmlDecimal(Long fmlDecimal)
/*  544:     */   {
/*  545:1015 */     this.fmlDecimal = fmlDecimal;
/*  546:     */   }
/*  547:     */   
/*  548:     */   public void setFmlDescription(String fmlDescription)
/*  549:     */   {
/*  550:1024 */     this.fmlDescription = fmlDescription;
/*  551:     */   }
/*  552:     */   
/*  553:     */   public void setFmlLong(Long fmlLong)
/*  554:     */   {
/*  555:1033 */     this.fmlLong = fmlLong;
/*  556:     */   }
/*  557:     */   
/*  558:     */   public void setFmlName(String fmlName)
/*  559:     */   {
/*  560:1042 */     this.fmlName = fmlName;
/*  561:     */   }
/*  562:     */   
/*  563:     */   public void setFmlTimestamp(Date fmlTimestamp)
/*  564:     */   {
/*  565:1051 */     this.fmlTimestamp = fmlTimestamp;
/*  566:     */   }
/*  567:     */   
/*  568:     */   public void setId(IdtFamiliesId id)
/*  569:     */   {
/*  570:1060 */     this.id = id;
/*  571:     */   }
/*  572:     */   
/*  573:     */   public void setIdtAggregationsesForAggFmlFk(Set idtAggregationsesForAggFmlFk)
/*  574:     */   {
/*  575:1069 */     this.idtAggregationsesForAggFmlFk = idtAggregationsesForAggFmlFk;
/*  576:     */   }
/*  577:     */   
/*  578:     */   public void setIdtAggregationsesForAggFmlTypeFk(Set idtAggregationsesForAggFmlTypeFk)
/*  579:     */   {
/*  580:1078 */     this.idtAggregationsesForAggFmlTypeFk = idtAggregationsesForAggFmlTypeFk;
/*  581:     */   }
/*  582:     */   
/*  583:     */   public void setIdtBoundses(Set idtBoundses)
/*  584:     */   {
/*  585:1087 */     this.idtBoundses = idtBoundses;
/*  586:     */   }
/*  587:     */   
/*  588:     */   public void setIdtCleanProductionses(Set idtCleanProductionses)
/*  589:     */   {
/*  590:1096 */     this.idtCleanProductionses = idtCleanProductionses;
/*  591:     */   }
/*  592:     */   
/*  593:     */   public void setIdtClprCrcses(Set idtClprCrcses)
/*  594:     */   {
/*  595:1105 */     this.idtClprCrcses = idtClprCrcses;
/*  596:     */   }
/*  597:     */   
/*  598:     */   public void setIdtEqpCmbses(Set idtEqpCmbses)
/*  599:     */   {
/*  600:1114 */     this.idtEqpCmbses = idtEqpCmbses;
/*  601:     */   }
/*  602:     */   
/*  603:     */   public void setIdtEqpCrcses(Set idtEqpCrcses)
/*  604:     */   {
/*  605:1123 */     this.idtEqpCrcses = idtEqpCrcses;
/*  606:     */   }
/*  607:     */   
/*  608:     */   public void setIdtEquationses(Set idtEquationses)
/*  609:     */   {
/*  610:1132 */     this.idtEquationses = idtEquationses;
/*  611:     */   }
/*  612:     */   
/*  613:     */   public void setIdtEquationTableses(Set idtEquationTableses)
/*  614:     */   {
/*  615:1141 */     this.idtEquationTableses = idtEquationTableses;
/*  616:     */   }
/*  617:     */   
/*  618:     */   public void setIdtEquipmentses(Set idtEquipmentses)
/*  619:     */   {
/*  620:1150 */     this.idtEquipmentses = idtEquipmentses;
/*  621:     */   }
/*  622:     */   
/*  623:     */   public void setIdtFieldses(Set idtFieldses)
/*  624:     */   {
/*  625:1159 */     this.idtFieldses = idtFieldses;
/*  626:     */   }
/*  627:     */   
/*  628:     */   public void setIdtFmlCrcsesForFmcrFmlFk(Set idtFmlCrcsesForFmcrFmlFk)
/*  629:     */   {
/*  630:1168 */     this.idtFmlCrcsesForFmcrFmlFk = idtFmlCrcsesForFmcrFmlFk;
/*  631:     */   }
/*  632:     */   
/*  633:     */   public void setIdtFmlCrcsesForFmcrFmlXFk(Set idtFmlCrcsesForFmcrFmlXFk)
/*  634:     */   {
/*  635:1177 */     this.idtFmlCrcsesForFmcrFmlXFk = idtFmlCrcsesForFmcrFmlXFk;
/*  636:     */   }
/*  637:     */   
/*  638:     */   public void setIdtFmlUbcsesForFmubFmlFk(Set idtFmlUbcsesForFmubFmlFk)
/*  639:     */   {
/*  640:1186 */     this.idtFmlUbcsesForFmubFmlFk = idtFmlUbcsesForFmubFmlFk;
/*  641:     */   }
/*  642:     */   
/*  643:     */   public void setIdtFmlUbcsesForFmubFmlUbcFk(Set idtFmlUbcsesForFmubFmlUbcFk)
/*  644:     */   {
/*  645:1195 */     this.idtFmlUbcsesForFmubFmlUbcFk = idtFmlUbcsesForFmubFmlUbcFk;
/*  646:     */   }
/*  647:     */   
/*  648:     */   public void setIdtFurCrcses(Set idtFurCrcses)
/*  649:     */   {
/*  650:1204 */     this.idtFurCrcses = idtFurCrcses;
/*  651:     */   }
/*  652:     */   
/*  653:     */   public void setIdtFurEqpCrcses(Set idtFurEqpCrcses)
/*  654:     */   {
/*  655:1213 */     this.idtFurEqpCrcses = idtFurEqpCrcses;
/*  656:     */   }
/*  657:     */   
/*  658:     */   public void setIdtFurPrdCrcses(Set idtFurPrdCrcses)
/*  659:     */   {
/*  660:1222 */     this.idtFurPrdCrcses = idtFurPrdCrcses;
/*  661:     */   }
/*  662:     */   
/*  663:     */   public void setIdtFurRsdCrcsesForFrrscrFmlFk(Set idtFurRsdCrcsesForFrrscrFmlFk)
/*  664:     */   {
/*  665:1231 */     this.idtFurRsdCrcsesForFrrscrFmlFk = idtFurRsdCrcsesForFrrscrFmlFk;
/*  666:     */   }
/*  667:     */   
/*  668:     */   public void setIdtFurRsdCrcsesForFrrscrFmlXFk(Set idtFurRsdCrcsesForFrrscrFmlXFk)
/*  669:     */   {
/*  670:1240 */     this.idtFurRsdCrcsesForFrrscrFmlXFk = idtFurRsdCrcsesForFrrscrFmlXFk;
/*  671:     */   }
/*  672:     */   
/*  673:     */   public void setIdtFurStrCrcses(Set idtFurStrCrcses)
/*  674:     */   {
/*  675:1249 */     this.idtFurStrCrcses = idtFurStrCrcses;
/*  676:     */   }
/*  677:     */   
/*  678:     */   public void setIdtFurSttCrcses(Set idtFurSttCrcses)
/*  679:     */   {
/*  680:1258 */     this.idtFurSttCrcses = idtFurSttCrcses;
/*  681:     */   }
/*  682:     */   
/*  683:     */   public void setIdtInsCrcses(Set idtInsCrcses)
/*  684:     */   {
/*  685:1267 */     this.idtInsCrcses = idtInsCrcses;
/*  686:     */   }
/*  687:     */   
/*  688:     */   public void setIdtInstrumentTypeses(Set idtInstrumentTypeses)
/*  689:     */   {
/*  690:1276 */     this.idtInstrumentTypeses = idtInstrumentTypeses;
/*  691:     */   }
/*  692:     */   
/*  693:     */   public void setIdtMeasureFieldses(Set idtMeasureFieldses)
/*  694:     */   {
/*  695:1285 */     this.idtMeasureFieldses = idtMeasureFieldses;
/*  696:     */   }
/*  697:     */   
/*  698:     */   public void setIdtMeasureses(Set idtMeasureses)
/*  699:     */   {
/*  700:1294 */     this.idtMeasureses = idtMeasureses;
/*  701:     */   }
/*  702:     */   
/*  703:     */   public void setIdtMeasureTypeses(Set idtMeasureTypeses)
/*  704:     */   {
/*  705:1303 */     this.idtMeasureTypeses = idtMeasureTypeses;
/*  706:     */   }
/*  707:     */   
/*  708:     */   public void setIdtMsrCrcses(Set idtMsrCrcses)
/*  709:     */   {
/*  710:1312 */     this.idtMsrCrcses = idtMsrCrcses;
/*  711:     */   }
/*  712:     */   
/*  713:     */   public void setIdtMsrPrsses(Set idtMsrPrsses)
/*  714:     */   {
/*  715:1321 */     this.idtMsrPrsses = idtMsrPrsses;
/*  716:     */   }
/*  717:     */   
/*  718:     */   public void setIdtMultiannualsesForMlanFmlOriginAvFk(Set idtMultiannualsesForMlanFmlOriginAvFk)
/*  719:     */   {
/*  720:1330 */     this.idtMultiannualsesForMlanFmlOriginAvFk = idtMultiannualsesForMlanFmlOriginAvFk;
/*  721:     */   }
/*  722:     */   
/*  723:     */   public void setIdtMultiannualsesForMlanFmlOriginMnFk(Set idtMultiannualsesForMlanFmlOriginMnFk)
/*  724:     */   {
/*  725:1339 */     this.idtMultiannualsesForMlanFmlOriginMnFk = idtMultiannualsesForMlanFmlOriginMnFk;
/*  726:     */   }
/*  727:     */   
/*  728:     */   public void setIdtMultiannualsesForMlanFmlOriginMxFk(Set idtMultiannualsesForMlanFmlOriginMxFk)
/*  729:     */   {
/*  730:1348 */     this.idtMultiannualsesForMlanFmlOriginMxFk = idtMultiannualsesForMlanFmlOriginMxFk;
/*  731:     */   }
/*  732:     */   
/*  733:     */   public void setIdtMultiannualsesForMlanFmlTypeFk(Set idtMultiannualsesForMlanFmlTypeFk)
/*  734:     */   {
/*  735:1357 */     this.idtMultiannualsesForMlanFmlTypeFk = idtMultiannualsesForMlanFmlTypeFk;
/*  736:     */   }
/*  737:     */   
/*  738:     */   public void setIdtOffCrcses(Set idtOffCrcses)
/*  739:     */   {
/*  740:1366 */     this.idtOffCrcses = idtOffCrcses;
/*  741:     */   }
/*  742:     */   
/*  743:     */   public void setIdtOffUbcses(Set idtOffUbcses)
/*  744:     */   {
/*  745:1375 */     this.idtOffUbcses = idtOffUbcses;
/*  746:     */   }
/*  747:     */   
/*  748:     */   public void setIdtOptionses(Set idtOptionses)
/*  749:     */   {
/*  750:1384 */     this.idtOptionses = idtOptionses;
/*  751:     */   }
/*  752:     */   
/*  753:     */   public void setIdtOrgCrcses(Set idtOrgCrcses)
/*  754:     */   {
/*  755:1393 */     this.idtOrgCrcses = idtOrgCrcses;
/*  756:     */   }
/*  757:     */   
/*  758:     */   public void setIdtOrgPrsses(Set idtOrgPrsses)
/*  759:     */   {
/*  760:1402 */     this.idtOrgPrsses = idtOrgPrsses;
/*  761:     */   }
/*  762:     */   
/*  763:     */   public void setIdtOrgUbcses(Set idtOrgUbcses)
/*  764:     */   {
/*  765:1411 */     this.idtOrgUbcses = idtOrgUbcses;
/*  766:     */   }
/*  767:     */   
/*  768:     */   public void setIdtProductses(Set idtProductses)
/*  769:     */   {
/*  770:1420 */     this.idtProductses = idtProductses;
/*  771:     */   }
/*  772:     */   
/*  773:     */   public void setIdtPrsCrcses(Set idtPrsCrcses)
/*  774:     */   {
/*  775:1429 */     this.idtPrsCrcses = idtPrsCrcses;
/*  776:     */   }
/*  777:     */   
/*  778:     */   public void setIdtPrsUbcses(Set idtPrsUbcses)
/*  779:     */   {
/*  780:1438 */     this.idtPrsUbcses = idtPrsUbcses;
/*  781:     */   }
/*  782:     */   
/*  783:     */   public void setIdtReadingsesForRdnFmlFk(Set idtReadingsesForRdnFmlFk)
/*  784:     */   {
/*  785:1447 */     this.idtReadingsesForRdnFmlFk = idtReadingsesForRdnFmlFk;
/*  786:     */   }
/*  787:     */   
/*  788:     */   public void setIdtReadingsesForRdnFmlStateFk(Set idtReadingsesForRdnFmlStateFk)
/*  789:     */   {
/*  790:1456 */     this.idtReadingsesForRdnFmlStateFk = idtReadingsesForRdnFmlStateFk;
/*  791:     */   }
/*  792:     */   
/*  793:     */   public void setIdtStationses(Set idtStationses)
/*  794:     */   {
/*  795:1465 */     this.idtStationses = idtStationses;
/*  796:     */   }
/*  797:     */   
/*  798:     */   public void setIdtStorageses(Set idtStorageses)
/*  799:     */   {
/*  800:1474 */     this.idtStorageses = idtStorageses;
/*  801:     */   }
/*  802:     */   
/*  803:     */   public void setIdtSttCrcses(Set idtSttCrcses)
/*  804:     */   {
/*  805:1483 */     this.idtSttCrcses = idtSttCrcses;
/*  806:     */   }
/*  807:     */   
/*  808:     */   public void setIdtTimePeriodses(Set idtTimePeriodses)
/*  809:     */   {
/*  810:1492 */     this.idtTimePeriodses = idtTimePeriodses;
/*  811:     */   }
/*  812:     */   
/*  813:     */   public void setIdtTimeScaleses(Set idtTimeScaleses)
/*  814:     */   {
/*  815:1501 */     this.idtTimeScaleses = idtTimeScaleses;
/*  816:     */   }
/*  817:     */   
/*  818:     */   public void setIdtTmprCrcses(Set idtTmprCrcses)
/*  819:     */   {
/*  820:1510 */     this.idtTmprCrcses = idtTmprCrcses;
/*  821:     */   }
/*  822:     */   
/*  823:     */   public void setIdtTramitsesForTrmFmlAuthFk(Set idtTramitsesForTrmFmlAuthFk)
/*  824:     */   {
/*  825:1519 */     this.idtTramitsesForTrmFmlAuthFk = idtTramitsesForTrmFmlAuthFk;
/*  826:     */   }
/*  827:     */   
/*  828:     */   public void setIdtTramitsesForTrmFmlFk(Set idtTramitsesForTrmFmlFk)
/*  829:     */   {
/*  830:1528 */     this.idtTramitsesForTrmFmlFk = idtTramitsesForTrmFmlFk;
/*  831:     */   }
/*  832:     */   
/*  833:     */   public void setIdtTramitsesForTrmFmlTramitFk(Set idtTramitsesForTrmFmlTramitFk)
/*  834:     */   {
/*  835:1537 */     this.idtTramitsesForTrmFmlTramitFk = idtTramitsesForTrmFmlTramitFk;
/*  836:     */   }
/*  837:     */   
/*  838:     */   public void setIdtUbcCrcses(Set idtUbcCrcses)
/*  839:     */   {
/*  840:1546 */     this.idtUbcCrcses = idtUbcCrcses;
/*  841:     */   }
/*  842:     */   
/*  843:     */   public void setIdtUbicationses(Set idtUbicationses)
/*  844:     */   {
/*  845:1555 */     this.idtUbicationses = idtUbicationses;
/*  846:     */   }
/*  847:     */   
/*  848:     */   public void setIdtUsers(IdtUsers idtUsers)
/*  849:     */   {
/*  850:1564 */     this.idtUsers = idtUsers;
/*  851:     */   }
/*  852:     */   
/*  853:     */   public void setIdtUsrFmlsesForUsfmFmlCategoriaFk(Set idtUsrFmlsesForUsfmFmlCategoriaFk)
/*  854:     */   {
/*  855:1573 */     this.idtUsrFmlsesForUsfmFmlCategoriaFk = idtUsrFmlsesForUsfmFmlCategoriaFk;
/*  856:     */   }
/*  857:     */   
/*  858:     */   public void setIdtUsrFmlsesForUsfmFmlFk(Set idtUsrFmlsesForUsfmFmlFk)
/*  859:     */   {
/*  860:1582 */     this.idtUsrFmlsesForUsfmFmlFk = idtUsrFmlsesForUsfmFmlFk;
/*  861:     */   }
/*  862:     */   
/*  863:     */   public void setIdtUsrOffses(Set idtUsrOffses)
/*  864:     */   {
/*  865:1591 */     this.idtUsrOffses = idtUsrOffses;
/*  866:     */   }
/*  867:     */   
/*  868:     */   public void setIdtValuesesForVleFmlFk(Set idtValuesesForVleFmlFk)
/*  869:     */   {
/*  870:1600 */     this.idtValuesesForVleFmlFk = idtValuesesForVleFmlFk;
/*  871:     */   }
/*  872:     */   
/*  873:     */   public void setIdtValuesesForVleFmlOriginFk(Set idtValuesesForVleFmlOriginFk)
/*  874:     */   {
/*  875:1609 */     this.idtValuesesForVleFmlOriginFk = idtValuesesForVleFmlOriginFk;
/*  876:     */   }
/*  877:     */   
/*  878:     */   public void setIdtVariableses(Set idtVariableses)
/*  879:     */   {
/*  880:1618 */     this.idtVariableses = idtVariableses;
/*  881:     */   }
/*  882:     */   
/*  883:     */   public void setIdtVleCrcses(Set idtVleCrcses)
/*  884:     */   {
/*  885:1627 */     this.idtVleCrcses = idtVleCrcses;
/*  886:     */   }
/*  887:     */   
/*  888:     */   public void setIdtWaterRelationses(Set idtWaterRelationses)
/*  889:     */   {
/*  890:1636 */     this.idtWaterRelationses = idtWaterRelationses;
/*  891:     */   }
/*  892:     */   
/*  893:     */   public void setIdtWaterses(Set idtWaterses)
/*  894:     */   {
/*  895:1645 */     this.idtWaterses = idtWaterses;
/*  896:     */   }
/*  897:     */   
/*  898:     */   public void setIdtWtrCrcses(Set idtWtrCrcses)
/*  899:     */   {
/*  900:1654 */     this.idtWtrCrcses = idtWtrCrcses;
/*  901:     */   }
/*  902:     */ }


/* Location:           C:\Users\Luis\Desktop\CLXX\BalanceQL\Fuentes\
 * Qualified Name:     sia.bql.hibernate.sioperan.AbstractIdtFamilies
 * JD-Core Version:    0.7.0.1
 */