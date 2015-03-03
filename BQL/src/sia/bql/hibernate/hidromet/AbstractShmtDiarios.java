/*    1:     */ package sia.bql.hibernate.hidromet;
/*    2:     */ 
/*    3:     */ import com.ada.ideam.siia.comunes.InfoEstacion;
/*    4:     */ import java.util.Date;
/*    5:     */ import java.util.List;
/*    6:     */ import sia.bql.bean.util.Utiles;
/*    7:     */ 
/*    8:     */ public class AbstractShmtDiarios
/*    9:     */   extends InfoEstacion
/*   10:     */ {
/*   11:     */   private static final long serialVersionUID = 1L;
/*   12:     */   private Date drsFecha;
/*   13:     */   private Long drsId;
/*   14:     */   private Long drsEstacionId;
/*   15:     */   private Long drsAno;
/*   16:     */   private Long drsMes;
/*   17:     */   private Long drsEst;
/*   18:     */   private Double drsValor1;
/*   19:     */   private Double drsValor2;
/*   20:     */   private Double drsValor3;
/*   21:     */   private Double drsValor4;
/*   22:     */   private Double drsValor5;
/*   23:     */   private Double drsValor6;
/*   24:     */   private Double drsValor7;
/*   25:     */   private Double drsValor8;
/*   26:     */   private Double drsValor9;
/*   27:     */   private Double drsValor10;
/*   28:     */   private Double drsValor11;
/*   29:     */   private Double drsValor12;
/*   30:     */   private Double drsValor13;
/*   31:     */   private Double drsValor14;
/*   32:     */   private Double drsValor15;
/*   33:     */   private Double drsValor16;
/*   34:     */   private Double drsValor17;
/*   35:     */   private Double drsValor18;
/*   36:     */   private Double drsValor19;
/*   37:     */   private Double drsValor20;
/*   38:     */   private Double drsValor21;
/*   39:     */   private Double drsValor22;
/*   40:     */   private Double drsValor23;
/*   41:     */   private Double drsValor24;
/*   42:     */   private Double drsValor25;
/*   43:     */   private Double drsValor26;
/*   44:     */   private Double drsValor27;
/*   45:     */   private Double drsValor28;
/*   46:     */   private Double drsValor29;
/*   47:     */   private Double drsValor30;
/*   48:     */   private Double drsValor31;
/*   49:     */   private Long drsValor1Fix;
/*   50:     */   private Long drsValor2Fix;
/*   51:     */   private Long drsValor3Fix;
/*   52:     */   private Long drsValor4Fix;
/*   53:     */   private Long drsValor5Fix;
/*   54:     */   private Long drsValor6Fix;
/*   55:     */   private Long drsValor7Fix;
/*   56:     */   private Long drsValor8Fix;
/*   57:     */   private Long drsValor9Fix;
/*   58:     */   private Long drsValor10Fix;
/*   59:     */   private Long drsValor11Fix;
/*   60:     */   private Long drsValor12Fix;
/*   61:     */   private Long drsValor13Fix;
/*   62:     */   private Long drsValor14Fix;
/*   63:     */   private Long drsValor15Fix;
/*   64:     */   private Long drsValor16Fix;
/*   65:     */   private Long drsValor17Fix;
/*   66:     */   private Long drsValor18Fix;
/*   67:     */   private Long drsValor19Fix;
/*   68:     */   private Long drsValor20Fix;
/*   69:     */   private Long drsValor21Fix;
/*   70:     */   private Long drsValor22Fix;
/*   71:     */   private Long drsValor23Fix;
/*   72:     */   private Long drsValor24Fix;
/*   73:     */   private Long drsValor25Fix;
/*   74:     */   private Long drsValor26Fix;
/*   75:     */   private Long drsValor27Fix;
/*   76:     */   private Long drsValor28Fix;
/*   77:     */   private Long drsValor29Fix;
/*   78:     */   private Long drsValor30Fix;
/*   79:     */   private Long drsValor31Fix;
/*   80:     */   private String drsOd1;
/*   81:     */   private String drsOd2;
/*   82:     */   private String drsOd3;
/*   83:     */   private String drsOd4;
/*   84:     */   private String drsOd5;
/*   85:     */   private String drsOd6;
/*   86:     */   private String drsOd7;
/*   87:     */   private String drsOd8;
/*   88:     */   private String drsOd9;
/*   89:     */   private String drsOd10;
/*   90:     */   private String drsOd11;
/*   91:     */   private String drsOd12;
/*   92:     */   private String drsOd13;
/*   93:     */   private String drsOd14;
/*   94:     */   private String drsOd15;
/*   95:     */   private String drsOd16;
/*   96:     */   private String drsOd17;
/*   97:     */   private String drsOd18;
/*   98:     */   private String drsOd19;
/*   99:     */   private String drsOd20;
/*  100:     */   private String drsOd21;
/*  101:     */   private String drsOd22;
/*  102:     */   private String drsOd23;
/*  103:     */   private String drsOd24;
/*  104:     */   private String drsOd25;
/*  105:     */   private String drsOd26;
/*  106:     */   private String drsOd27;
/*  107:     */   private String drsOd28;
/*  108:     */   private String drsOd29;
/*  109:     */   private String drsOd30;
/*  110:     */   private String drsOd31;
/*  111:     */   private String drsOd1Fix;
/*  112:     */   private String drsOd2Fix;
/*  113:     */   private String drsOd3Fix;
/*  114:     */   private String drsOd4Fix;
/*  115:     */   private String drsOd5Fix;
/*  116:     */   private String drsOd6Fix;
/*  117:     */   private String drsOd7Fix;
/*  118:     */   private String drsOd8Fix;
/*  119:     */   private String drsOd9Fix;
/*  120:     */   private String drsOd10Fix;
/*  121:     */   private String drsOd11Fix;
/*  122:     */   private String drsOd12Fix;
/*  123:     */   private String drsOd13Fix;
/*  124:     */   private String drsOd14Fix;
/*  125:     */   private String drsOd15Fix;
/*  126:     */   private String drsOd16Fix;
/*  127:     */   private String drsOd17Fix;
/*  128:     */   private String drsOd18Fix;
/*  129:     */   private String drsOd19Fix;
/*  130:     */   private String drsOd20Fix;
/*  131:     */   private String drsOd21Fix;
/*  132:     */   private String drsOd22Fix;
/*  133:     */   private String drsOd23Fix;
/*  134:     */   private String drsOd24Fix;
/*  135:     */   private String drsOd25Fix;
/*  136:     */   private String drsOd26Fix;
/*  137:     */   private String drsOd27Fix;
/*  138:     */   private String drsOd28Fix;
/*  139:     */   private String drsOd29Fix;
/*  140:     */   private String drsOd30Fix;
/*  141:     */   private String drsOd31Fix;
/*  142:     */   private String drsVarId;
/*  143:     */   private String drsEnt;
/*  144:     */   private Long idtUsers;
/*  145:     */   
/*  146:     */   public Long getIdtUsers()
/*  147:     */   {
/*  148:  50 */     return this.idtUsers;
/*  149:     */   }
/*  150:     */   
/*  151:     */   public void setIdtUsers(Long idtUsers)
/*  152:     */   {
/*  153:  54 */     this.idtUsers = idtUsers;
/*  154:     */   }
/*  155:     */   
/*  156:     */   public Date getDrsFecha()
/*  157:     */   {
/*  158:  58 */     return this.drsFecha;
/*  159:     */   }
/*  160:     */   
/*  161:     */   public void setDrsFecha(Date drsFecha)
/*  162:     */   {
/*  163:  62 */     this.drsFecha = drsFecha;
/*  164:     */   }
/*  165:     */   
/*  166:     */   public Long getDrsId()
/*  167:     */   {
/*  168:  66 */     return this.drsId;
/*  169:     */   }
/*  170:     */   
/*  171:     */   public void setDrsId(Long drsId)
/*  172:     */   {
/*  173:  70 */     this.drsId = drsId;
/*  174:     */   }
/*  175:     */   
/*  176:     */   public Long getDrsEstacionId()
/*  177:     */   {
/*  178:  74 */     return this.drsEstacionId;
/*  179:     */   }
/*  180:     */   
/*  181:     */   public void setDrsEstacionId(Long drsEstacionId)
/*  182:     */   {
/*  183:  78 */     this.drsEstacionId = drsEstacionId;
/*  184:     */   }
/*  185:     */   
/*  186:     */   public Long getDrsAno()
/*  187:     */   {
/*  188:  82 */     return this.drsAno;
/*  189:     */   }
/*  190:     */   
/*  191:     */   public void setDrsAno(Long drsAno)
/*  192:     */   {
/*  193:  86 */     this.drsAno = drsAno;
/*  194:     */   }
/*  195:     */   
/*  196:     */   public Long getDrsMes()
/*  197:     */   {
/*  198:  90 */     return this.drsMes;
/*  199:     */   }
/*  200:     */   
/*  201:     */   public void setDrsMes(Long drsMes)
/*  202:     */   {
/*  203:  94 */     this.drsMes = drsMes;
/*  204:     */   }
/*  205:     */   
/*  206:     */   public Long getDrsEst()
/*  207:     */   {
/*  208:  98 */     return this.drsEst;
/*  209:     */   }
/*  210:     */   
/*  211:     */   public void setDrsEst(Long drsEst)
/*  212:     */   {
/*  213: 102 */     this.drsEst = drsEst;
/*  214:     */   }
/*  215:     */   
/*  216:     */   public String getDrsEnt()
/*  217:     */   {
/*  218: 106 */     return this.drsEnt;
/*  219:     */   }
/*  220:     */   
/*  221:     */   public void setDrsEnt(String drsEnt)
/*  222:     */   {
/*  223: 110 */     this.drsEnt = drsEnt;
/*  224:     */   }
/*  225:     */   
/*  226:     */   public Double getDrsValor1()
/*  227:     */   {
/*  228: 114 */     return this.drsValor1;
/*  229:     */   }
/*  230:     */   
/*  231:     */   public void setDrsValor1(Double drsValor1)
/*  232:     */   {
/*  233: 118 */     this.drsValor1 = drsValor1;
/*  234:     */   }
/*  235:     */   
/*  236:     */   public Double getDrsValor2()
/*  237:     */   {
/*  238: 122 */     return this.drsValor2;
/*  239:     */   }
/*  240:     */   
/*  241:     */   public void setDrsValor2(Double drsValor2)
/*  242:     */   {
/*  243: 126 */     this.drsValor2 = drsValor2;
/*  244:     */   }
/*  245:     */   
/*  246:     */   public Double getDrsValor3()
/*  247:     */   {
/*  248: 130 */     return this.drsValor3;
/*  249:     */   }
/*  250:     */   
/*  251:     */   public void setDrsValor3(Double drsValor3)
/*  252:     */   {
/*  253: 134 */     this.drsValor3 = drsValor3;
/*  254:     */   }
/*  255:     */   
/*  256:     */   public Double getDrsValor4()
/*  257:     */   {
/*  258: 138 */     return this.drsValor4;
/*  259:     */   }
/*  260:     */   
/*  261:     */   public void setDrsValor4(Double drsValor4)
/*  262:     */   {
/*  263: 142 */     this.drsValor4 = drsValor4;
/*  264:     */   }
/*  265:     */   
/*  266:     */   public Double getDrsValor5()
/*  267:     */   {
/*  268: 146 */     return this.drsValor5;
/*  269:     */   }
/*  270:     */   
/*  271:     */   public void setDrsValor5(Double drsValor5)
/*  272:     */   {
/*  273: 150 */     this.drsValor5 = drsValor5;
/*  274:     */   }
/*  275:     */   
/*  276:     */   public Double getDrsValor6()
/*  277:     */   {
/*  278: 154 */     return this.drsValor6;
/*  279:     */   }
/*  280:     */   
/*  281:     */   public void setDrsValor6(Double drsValor6)
/*  282:     */   {
/*  283: 158 */     this.drsValor6 = drsValor6;
/*  284:     */   }
/*  285:     */   
/*  286:     */   public Double getDrsValor7()
/*  287:     */   {
/*  288: 162 */     return this.drsValor7;
/*  289:     */   }
/*  290:     */   
/*  291:     */   public void setDrsValor7(Double drsValor7)
/*  292:     */   {
/*  293: 166 */     this.drsValor7 = drsValor7;
/*  294:     */   }
/*  295:     */   
/*  296:     */   public Double getDrsValor8()
/*  297:     */   {
/*  298: 170 */     return this.drsValor8;
/*  299:     */   }
/*  300:     */   
/*  301:     */   public void setDrsValor8(Double drsValor8)
/*  302:     */   {
/*  303: 174 */     this.drsValor8 = drsValor8;
/*  304:     */   }
/*  305:     */   
/*  306:     */   public Double getDrsValor9()
/*  307:     */   {
/*  308: 178 */     return this.drsValor9;
/*  309:     */   }
/*  310:     */   
/*  311:     */   public void setDrsValor9(Double drsValor9)
/*  312:     */   {
/*  313: 182 */     this.drsValor9 = drsValor9;
/*  314:     */   }
/*  315:     */   
/*  316:     */   public Double getDrsValor10()
/*  317:     */   {
/*  318: 186 */     return this.drsValor10;
/*  319:     */   }
/*  320:     */   
/*  321:     */   public void setDrsValor10(Double drsValor10)
/*  322:     */   {
/*  323: 190 */     this.drsValor10 = drsValor10;
/*  324:     */   }
/*  325:     */   
/*  326:     */   public Double getDrsValor11()
/*  327:     */   {
/*  328: 194 */     return this.drsValor11;
/*  329:     */   }
/*  330:     */   
/*  331:     */   public void setDrsValor11(Double drsValor11)
/*  332:     */   {
/*  333: 198 */     this.drsValor11 = drsValor11;
/*  334:     */   }
/*  335:     */   
/*  336:     */   public Double getDrsValor12()
/*  337:     */   {
/*  338: 202 */     return this.drsValor12;
/*  339:     */   }
/*  340:     */   
/*  341:     */   public void setDrsValor12(Double drsValor12)
/*  342:     */   {
/*  343: 206 */     this.drsValor12 = drsValor12;
/*  344:     */   }
/*  345:     */   
/*  346:     */   public Double getDrsValor13()
/*  347:     */   {
/*  348: 210 */     return this.drsValor13;
/*  349:     */   }
/*  350:     */   
/*  351:     */   public void setDrsValor13(Double drsValor13)
/*  352:     */   {
/*  353: 214 */     this.drsValor13 = drsValor13;
/*  354:     */   }
/*  355:     */   
/*  356:     */   public Double getDrsValor14()
/*  357:     */   {
/*  358: 218 */     return this.drsValor14;
/*  359:     */   }
/*  360:     */   
/*  361:     */   public void setDrsValor14(Double drsValor14)
/*  362:     */   {
/*  363: 222 */     this.drsValor14 = drsValor14;
/*  364:     */   }
/*  365:     */   
/*  366:     */   public Double getDrsValor15()
/*  367:     */   {
/*  368: 226 */     return this.drsValor15;
/*  369:     */   }
/*  370:     */   
/*  371:     */   public void setDrsValor15(Double drsValor15)
/*  372:     */   {
/*  373: 230 */     this.drsValor15 = drsValor15;
/*  374:     */   }
/*  375:     */   
/*  376:     */   public Double getDrsValor16()
/*  377:     */   {
/*  378: 234 */     return this.drsValor16;
/*  379:     */   }
/*  380:     */   
/*  381:     */   public void setDrsValor16(Double drsValor16)
/*  382:     */   {
/*  383: 238 */     this.drsValor16 = drsValor16;
/*  384:     */   }
/*  385:     */   
/*  386:     */   public Double getDrsValor17()
/*  387:     */   {
/*  388: 242 */     return this.drsValor17;
/*  389:     */   }
/*  390:     */   
/*  391:     */   public void setDrsValor17(Double drsValor17)
/*  392:     */   {
/*  393: 246 */     this.drsValor17 = drsValor17;
/*  394:     */   }
/*  395:     */   
/*  396:     */   public Double getDrsValor18()
/*  397:     */   {
/*  398: 250 */     return this.drsValor18;
/*  399:     */   }
/*  400:     */   
/*  401:     */   public void setDrsValor18(Double drsValor18)
/*  402:     */   {
/*  403: 254 */     this.drsValor18 = drsValor18;
/*  404:     */   }
/*  405:     */   
/*  406:     */   public Double getDrsValor19()
/*  407:     */   {
/*  408: 258 */     return this.drsValor19;
/*  409:     */   }
/*  410:     */   
/*  411:     */   public void setDrsValor19(Double drsValor19)
/*  412:     */   {
/*  413: 262 */     this.drsValor19 = drsValor19;
/*  414:     */   }
/*  415:     */   
/*  416:     */   public Double getDrsValor20()
/*  417:     */   {
/*  418: 266 */     return this.drsValor20;
/*  419:     */   }
/*  420:     */   
/*  421:     */   public void setDrsValor20(Double drsValor20)
/*  422:     */   {
/*  423: 270 */     this.drsValor20 = drsValor20;
/*  424:     */   }
/*  425:     */   
/*  426:     */   public Double getDrsValor21()
/*  427:     */   {
/*  428: 274 */     return this.drsValor21;
/*  429:     */   }
/*  430:     */   
/*  431:     */   public void setDrsValor21(Double drsValor21)
/*  432:     */   {
/*  433: 278 */     this.drsValor21 = drsValor21;
/*  434:     */   }
/*  435:     */   
/*  436:     */   public Double getDrsValor22()
/*  437:     */   {
/*  438: 282 */     return this.drsValor22;
/*  439:     */   }
/*  440:     */   
/*  441:     */   public void setDrsValor22(Double drsValor22)
/*  442:     */   {
/*  443: 286 */     this.drsValor22 = drsValor22;
/*  444:     */   }
/*  445:     */   
/*  446:     */   public Double getDrsValor23()
/*  447:     */   {
/*  448: 290 */     return this.drsValor23;
/*  449:     */   }
/*  450:     */   
/*  451:     */   public void setDrsValor23(Double drsValor23)
/*  452:     */   {
/*  453: 294 */     this.drsValor23 = drsValor23;
/*  454:     */   }
/*  455:     */   
/*  456:     */   public Double getDrsValor24()
/*  457:     */   {
/*  458: 298 */     return this.drsValor24;
/*  459:     */   }
/*  460:     */   
/*  461:     */   public void setDrsValor24(Double drsValor24)
/*  462:     */   {
/*  463: 302 */     this.drsValor24 = drsValor24;
/*  464:     */   }
/*  465:     */   
/*  466:     */   public Double getDrsValor25()
/*  467:     */   {
/*  468: 306 */     return this.drsValor25;
/*  469:     */   }
/*  470:     */   
/*  471:     */   public void setDrsValor25(Double drsValor25)
/*  472:     */   {
/*  473: 310 */     this.drsValor25 = drsValor25;
/*  474:     */   }
/*  475:     */   
/*  476:     */   public Double getDrsValor26()
/*  477:     */   {
/*  478: 314 */     return this.drsValor26;
/*  479:     */   }
/*  480:     */   
/*  481:     */   public void setDrsValor26(Double drsValor26)
/*  482:     */   {
/*  483: 318 */     this.drsValor26 = drsValor26;
/*  484:     */   }
/*  485:     */   
/*  486:     */   public Double getDrsValor27()
/*  487:     */   {
/*  488: 322 */     return this.drsValor27;
/*  489:     */   }
/*  490:     */   
/*  491:     */   public void setDrsValor27(Double drsValor27)
/*  492:     */   {
/*  493: 326 */     this.drsValor27 = drsValor27;
/*  494:     */   }
/*  495:     */   
/*  496:     */   public Double getDrsValor28()
/*  497:     */   {
/*  498: 330 */     return this.drsValor28;
/*  499:     */   }
/*  500:     */   
/*  501:     */   public void setDrsValor28(Double drsValor28)
/*  502:     */   {
/*  503: 334 */     this.drsValor28 = drsValor28;
/*  504:     */   }
/*  505:     */   
/*  506:     */   public Double getDrsValor29()
/*  507:     */   {
/*  508: 338 */     return this.drsValor29;
/*  509:     */   }
/*  510:     */   
/*  511:     */   public void setDrsValor29(Double drsValor29)
/*  512:     */   {
/*  513: 342 */     this.drsValor29 = drsValor29;
/*  514:     */   }
/*  515:     */   
/*  516:     */   public Double getDrsValor30()
/*  517:     */   {
/*  518: 346 */     return this.drsValor30;
/*  519:     */   }
/*  520:     */   
/*  521:     */   public void setDrsValor30(Double drsValor30)
/*  522:     */   {
/*  523: 350 */     this.drsValor30 = drsValor30;
/*  524:     */   }
/*  525:     */   
/*  526:     */   public Double getDrsValor31()
/*  527:     */   {
/*  528: 354 */     return this.drsValor31;
/*  529:     */   }
/*  530:     */   
/*  531:     */   public void setDrsValor31(Double drsValor31)
/*  532:     */   {
/*  533: 358 */     this.drsValor31 = drsValor31;
/*  534:     */   }
/*  535:     */   
/*  536:     */   public Long getDrsValor1Fix()
/*  537:     */   {
/*  538: 362 */     return this.drsValor1Fix;
/*  539:     */   }
/*  540:     */   
/*  541:     */   public void setDrsValor1Fix(Long drsValor1Fix)
/*  542:     */   {
/*  543: 366 */     this.drsValor1Fix = drsValor1Fix;
/*  544:     */   }
/*  545:     */   
/*  546:     */   public Long getDrsValor2Fix()
/*  547:     */   {
/*  548: 370 */     return this.drsValor2Fix;
/*  549:     */   }
/*  550:     */   
/*  551:     */   public void setDrsValor2Fix(Long drsValor2Fix)
/*  552:     */   {
/*  553: 374 */     this.drsValor2Fix = drsValor2Fix;
/*  554:     */   }
/*  555:     */   
/*  556:     */   public Long getDrsValor3Fix()
/*  557:     */   {
/*  558: 378 */     return this.drsValor3Fix;
/*  559:     */   }
/*  560:     */   
/*  561:     */   public void setDrsValor3Fix(Long drsValor3Fix)
/*  562:     */   {
/*  563: 382 */     this.drsValor3Fix = drsValor3Fix;
/*  564:     */   }
/*  565:     */   
/*  566:     */   public Long getDrsValor4Fix()
/*  567:     */   {
/*  568: 386 */     return this.drsValor4Fix;
/*  569:     */   }
/*  570:     */   
/*  571:     */   public void setDrsValor4Fix(Long drsValor4Fix)
/*  572:     */   {
/*  573: 390 */     this.drsValor4Fix = drsValor4Fix;
/*  574:     */   }
/*  575:     */   
/*  576:     */   public Long getDrsValor5Fix()
/*  577:     */   {
/*  578: 394 */     return this.drsValor5Fix;
/*  579:     */   }
/*  580:     */   
/*  581:     */   public void setDrsValor5Fix(Long drsValor5Fix)
/*  582:     */   {
/*  583: 398 */     this.drsValor5Fix = drsValor5Fix;
/*  584:     */   }
/*  585:     */   
/*  586:     */   public Long getDrsValor6Fix()
/*  587:     */   {
/*  588: 402 */     return this.drsValor6Fix;
/*  589:     */   }
/*  590:     */   
/*  591:     */   public void setDrsValor6Fix(Long drsValor6Fix)
/*  592:     */   {
/*  593: 406 */     this.drsValor6Fix = drsValor6Fix;
/*  594:     */   }
/*  595:     */   
/*  596:     */   public Long getDrsValor7Fix()
/*  597:     */   {
/*  598: 410 */     return this.drsValor7Fix;
/*  599:     */   }
/*  600:     */   
/*  601:     */   public void setDrsValor7Fix(Long drsValor7Fix)
/*  602:     */   {
/*  603: 414 */     this.drsValor7Fix = drsValor7Fix;
/*  604:     */   }
/*  605:     */   
/*  606:     */   public Long getDrsValor8Fix()
/*  607:     */   {
/*  608: 418 */     return this.drsValor8Fix;
/*  609:     */   }
/*  610:     */   
/*  611:     */   public void setDrsValor8Fix(Long drsValor8Fix)
/*  612:     */   {
/*  613: 422 */     this.drsValor8Fix = drsValor8Fix;
/*  614:     */   }
/*  615:     */   
/*  616:     */   public Long getDrsValor9Fix()
/*  617:     */   {
/*  618: 426 */     return this.drsValor9Fix;
/*  619:     */   }
/*  620:     */   
/*  621:     */   public void setDrsValor9Fix(Long drsValor9Fix)
/*  622:     */   {
/*  623: 430 */     this.drsValor9Fix = drsValor9Fix;
/*  624:     */   }
/*  625:     */   
/*  626:     */   public Long getDrsValor10Fix()
/*  627:     */   {
/*  628: 434 */     return this.drsValor10Fix;
/*  629:     */   }
/*  630:     */   
/*  631:     */   public void setDrsValor10Fix(Long drsValor10Fix)
/*  632:     */   {
/*  633: 438 */     this.drsValor10Fix = drsValor10Fix;
/*  634:     */   }
/*  635:     */   
/*  636:     */   public Long getDrsValor11Fix()
/*  637:     */   {
/*  638: 442 */     return this.drsValor11Fix;
/*  639:     */   }
/*  640:     */   
/*  641:     */   public void setDrsValor11Fix(Long drsValor11Fix)
/*  642:     */   {
/*  643: 446 */     this.drsValor11Fix = drsValor11Fix;
/*  644:     */   }
/*  645:     */   
/*  646:     */   public Long getDrsValor12Fix()
/*  647:     */   {
/*  648: 450 */     return this.drsValor12Fix;
/*  649:     */   }
/*  650:     */   
/*  651:     */   public void setDrsValor12Fix(Long drsValor12Fix)
/*  652:     */   {
/*  653: 454 */     this.drsValor12Fix = drsValor12Fix;
/*  654:     */   }
/*  655:     */   
/*  656:     */   public Long getDrsValor13Fix()
/*  657:     */   {
/*  658: 458 */     return this.drsValor13Fix;
/*  659:     */   }
/*  660:     */   
/*  661:     */   public void setDrsValor13Fix(Long drsValor13Fix)
/*  662:     */   {
/*  663: 462 */     this.drsValor13Fix = drsValor13Fix;
/*  664:     */   }
/*  665:     */   
/*  666:     */   public Long getDrsValor14Fix()
/*  667:     */   {
/*  668: 466 */     return this.drsValor14Fix;
/*  669:     */   }
/*  670:     */   
/*  671:     */   public void setDrsValor14Fix(Long drsValor14Fix)
/*  672:     */   {
/*  673: 470 */     this.drsValor14Fix = drsValor14Fix;
/*  674:     */   }
/*  675:     */   
/*  676:     */   public Long getDrsValor15Fix()
/*  677:     */   {
/*  678: 474 */     return this.drsValor15Fix;
/*  679:     */   }
/*  680:     */   
/*  681:     */   public void setDrsValor15Fix(Long drsValor15Fix)
/*  682:     */   {
/*  683: 478 */     this.drsValor15Fix = drsValor15Fix;
/*  684:     */   }
/*  685:     */   
/*  686:     */   public Long getDrsValor16Fix()
/*  687:     */   {
/*  688: 482 */     return this.drsValor16Fix;
/*  689:     */   }
/*  690:     */   
/*  691:     */   public void setDrsValor16Fix(Long drsValor16Fix)
/*  692:     */   {
/*  693: 486 */     this.drsValor16Fix = drsValor16Fix;
/*  694:     */   }
/*  695:     */   
/*  696:     */   public Long getDrsValor17Fix()
/*  697:     */   {
/*  698: 490 */     return this.drsValor17Fix;
/*  699:     */   }
/*  700:     */   
/*  701:     */   public void setDrsValor17Fix(Long drsValor17Fix)
/*  702:     */   {
/*  703: 494 */     this.drsValor17Fix = drsValor17Fix;
/*  704:     */   }
/*  705:     */   
/*  706:     */   public Long getDrsValor18Fix()
/*  707:     */   {
/*  708: 498 */     return this.drsValor18Fix;
/*  709:     */   }
/*  710:     */   
/*  711:     */   public void setDrsValor18Fix(Long drsValor18Fix)
/*  712:     */   {
/*  713: 502 */     this.drsValor18Fix = drsValor18Fix;
/*  714:     */   }
/*  715:     */   
/*  716:     */   public Long getDrsValor19Fix()
/*  717:     */   {
/*  718: 506 */     return this.drsValor19Fix;
/*  719:     */   }
/*  720:     */   
/*  721:     */   public void setDrsValor19Fix(Long drsValor19Fix)
/*  722:     */   {
/*  723: 510 */     this.drsValor19Fix = drsValor19Fix;
/*  724:     */   }
/*  725:     */   
/*  726:     */   public Long getDrsValor20Fix()
/*  727:     */   {
/*  728: 514 */     return this.drsValor20Fix;
/*  729:     */   }
/*  730:     */   
/*  731:     */   public void setDrsValor20Fix(Long drsValor20Fix)
/*  732:     */   {
/*  733: 518 */     this.drsValor20Fix = drsValor20Fix;
/*  734:     */   }
/*  735:     */   
/*  736:     */   public Long getDrsValor21Fix()
/*  737:     */   {
/*  738: 522 */     return this.drsValor21Fix;
/*  739:     */   }
/*  740:     */   
/*  741:     */   public void setDrsValor21Fix(Long drsValor21Fix)
/*  742:     */   {
/*  743: 526 */     this.drsValor21Fix = drsValor21Fix;
/*  744:     */   }
/*  745:     */   
/*  746:     */   public Long getDrsValor22Fix()
/*  747:     */   {
/*  748: 530 */     return this.drsValor22Fix;
/*  749:     */   }
/*  750:     */   
/*  751:     */   public void setDrsValor22Fix(Long drsValor22Fix)
/*  752:     */   {
/*  753: 534 */     this.drsValor22Fix = drsValor22Fix;
/*  754:     */   }
/*  755:     */   
/*  756:     */   public Long getDrsValor23Fix()
/*  757:     */   {
/*  758: 538 */     return this.drsValor23Fix;
/*  759:     */   }
/*  760:     */   
/*  761:     */   public void setDrsValor23Fix(Long drsValor23Fix)
/*  762:     */   {
/*  763: 542 */     this.drsValor23Fix = drsValor23Fix;
/*  764:     */   }
/*  765:     */   
/*  766:     */   public Long getDrsValor24Fix()
/*  767:     */   {
/*  768: 546 */     return this.drsValor24Fix;
/*  769:     */   }
/*  770:     */   
/*  771:     */   public void setDrsValor24Fix(Long drsValor24Fix)
/*  772:     */   {
/*  773: 550 */     this.drsValor24Fix = drsValor24Fix;
/*  774:     */   }
/*  775:     */   
/*  776:     */   public Long getDrsValor25Fix()
/*  777:     */   {
/*  778: 554 */     return this.drsValor25Fix;
/*  779:     */   }
/*  780:     */   
/*  781:     */   public void setDrsValor25Fix(Long drsValor25Fix)
/*  782:     */   {
/*  783: 558 */     this.drsValor25Fix = drsValor25Fix;
/*  784:     */   }
/*  785:     */   
/*  786:     */   public Long getDrsValor26Fix()
/*  787:     */   {
/*  788: 562 */     return this.drsValor26Fix;
/*  789:     */   }
/*  790:     */   
/*  791:     */   public void setDrsValor26Fix(Long drsValor26Fix)
/*  792:     */   {
/*  793: 566 */     this.drsValor26Fix = drsValor26Fix;
/*  794:     */   }
/*  795:     */   
/*  796:     */   public Long getDrsValor27Fix()
/*  797:     */   {
/*  798: 570 */     return this.drsValor27Fix;
/*  799:     */   }
/*  800:     */   
/*  801:     */   public void setDrsValor27Fix(Long drsValor27Fix)
/*  802:     */   {
/*  803: 574 */     this.drsValor27Fix = drsValor27Fix;
/*  804:     */   }
/*  805:     */   
/*  806:     */   public Long getDrsValor28Fix()
/*  807:     */   {
/*  808: 578 */     return this.drsValor28Fix;
/*  809:     */   }
/*  810:     */   
/*  811:     */   public void setDrsValor28Fix(Long drsValor28Fix)
/*  812:     */   {
/*  813: 582 */     this.drsValor28Fix = drsValor28Fix;
/*  814:     */   }
/*  815:     */   
/*  816:     */   public Long getDrsValor29Fix()
/*  817:     */   {
/*  818: 586 */     return this.drsValor29Fix;
/*  819:     */   }
/*  820:     */   
/*  821:     */   public void setDrsValor29Fix(Long drsValor29Fix)
/*  822:     */   {
/*  823: 590 */     this.drsValor29Fix = drsValor29Fix;
/*  824:     */   }
/*  825:     */   
/*  826:     */   public Long getDrsValor30Fix()
/*  827:     */   {
/*  828: 594 */     return this.drsValor30Fix;
/*  829:     */   }
/*  830:     */   
/*  831:     */   public void setDrsValor30Fix(Long drsValor30Fix)
/*  832:     */   {
/*  833: 598 */     this.drsValor30Fix = drsValor30Fix;
/*  834:     */   }
/*  835:     */   
/*  836:     */   public Long getDrsValor31Fix()
/*  837:     */   {
/*  838: 602 */     return this.drsValor31Fix;
/*  839:     */   }
/*  840:     */   
/*  841:     */   public void setDrsValor31Fix(Long drsValor31Fix)
/*  842:     */   {
/*  843: 606 */     this.drsValor31Fix = drsValor31Fix;
/*  844:     */   }
/*  845:     */   
/*  846:     */   public String getDrsOd1()
/*  847:     */   {
/*  848: 610 */     return this.drsOd1;
/*  849:     */   }
/*  850:     */   
/*  851:     */   public void setDrsOd1(String drsOd1)
/*  852:     */   {
/*  853: 614 */     this.drsOd1 = drsOd1;
/*  854:     */   }
/*  855:     */   
/*  856:     */   public String getDrsOd2()
/*  857:     */   {
/*  858: 618 */     return this.drsOd2;
/*  859:     */   }
/*  860:     */   
/*  861:     */   public void setDrsOd2(String drsOd2)
/*  862:     */   {
/*  863: 622 */     this.drsOd2 = drsOd2;
/*  864:     */   }
/*  865:     */   
/*  866:     */   public String getDrsOd3()
/*  867:     */   {
/*  868: 626 */     return this.drsOd3;
/*  869:     */   }
/*  870:     */   
/*  871:     */   public void setDrsOd3(String drsOd3)
/*  872:     */   {
/*  873: 630 */     this.drsOd3 = drsOd3;
/*  874:     */   }
/*  875:     */   
/*  876:     */   public String getDrsOd4()
/*  877:     */   {
/*  878: 634 */     return this.drsOd4;
/*  879:     */   }
/*  880:     */   
/*  881:     */   public void setDrsOd4(String drsOd4)
/*  882:     */   {
/*  883: 638 */     this.drsOd4 = drsOd4;
/*  884:     */   }
/*  885:     */   
/*  886:     */   public String getDrsOd5()
/*  887:     */   {
/*  888: 642 */     return this.drsOd5;
/*  889:     */   }
/*  890:     */   
/*  891:     */   public void setDrsOd5(String drsOd5)
/*  892:     */   {
/*  893: 646 */     this.drsOd5 = drsOd5;
/*  894:     */   }
/*  895:     */   
/*  896:     */   public String getDrsOd6()
/*  897:     */   {
/*  898: 650 */     return this.drsOd6;
/*  899:     */   }
/*  900:     */   
/*  901:     */   public void setDrsOd6(String drsOd6)
/*  902:     */   {
/*  903: 654 */     this.drsOd6 = drsOd6;
/*  904:     */   }
/*  905:     */   
/*  906:     */   public String getDrsOd7()
/*  907:     */   {
/*  908: 658 */     return this.drsOd7;
/*  909:     */   }
/*  910:     */   
/*  911:     */   public void setDrsOd7(String drsOd7)
/*  912:     */   {
/*  913: 662 */     this.drsOd7 = drsOd7;
/*  914:     */   }
/*  915:     */   
/*  916:     */   public String getDrsOd8()
/*  917:     */   {
/*  918: 666 */     return this.drsOd8;
/*  919:     */   }
/*  920:     */   
/*  921:     */   public void setDrsOd8(String drsOd8)
/*  922:     */   {
/*  923: 670 */     this.drsOd8 = drsOd8;
/*  924:     */   }
/*  925:     */   
/*  926:     */   public String getDrsOd9()
/*  927:     */   {
/*  928: 674 */     return this.drsOd9;
/*  929:     */   }
/*  930:     */   
/*  931:     */   public void setDrsOd9(String drsOd9)
/*  932:     */   {
/*  933: 678 */     this.drsOd9 = drsOd9;
/*  934:     */   }
/*  935:     */   
/*  936:     */   public String getDrsOd10()
/*  937:     */   {
/*  938: 682 */     return this.drsOd10;
/*  939:     */   }
/*  940:     */   
/*  941:     */   public void setDrsOd10(String drsOd10)
/*  942:     */   {
/*  943: 686 */     this.drsOd10 = drsOd10;
/*  944:     */   }
/*  945:     */   
/*  946:     */   public String getDrsOd11()
/*  947:     */   {
/*  948: 690 */     return this.drsOd11;
/*  949:     */   }
/*  950:     */   
/*  951:     */   public void setDrsOd11(String drsOd11)
/*  952:     */   {
/*  953: 694 */     this.drsOd11 = drsOd11;
/*  954:     */   }
/*  955:     */   
/*  956:     */   public String getDrsOd12()
/*  957:     */   {
/*  958: 698 */     return this.drsOd12;
/*  959:     */   }
/*  960:     */   
/*  961:     */   public void setDrsOd12(String drsOd12)
/*  962:     */   {
/*  963: 702 */     this.drsOd12 = drsOd12;
/*  964:     */   }
/*  965:     */   
/*  966:     */   public String getDrsOd13()
/*  967:     */   {
/*  968: 706 */     return this.drsOd13;
/*  969:     */   }
/*  970:     */   
/*  971:     */   public void setDrsOd13(String drsOd13)
/*  972:     */   {
/*  973: 710 */     this.drsOd13 = drsOd13;
/*  974:     */   }
/*  975:     */   
/*  976:     */   public String getDrsOd14()
/*  977:     */   {
/*  978: 714 */     return this.drsOd14;
/*  979:     */   }
/*  980:     */   
/*  981:     */   public void setDrsOd14(String drsOd14)
/*  982:     */   {
/*  983: 718 */     this.drsOd14 = drsOd14;
/*  984:     */   }
/*  985:     */   
/*  986:     */   public String getDrsOd15()
/*  987:     */   {
/*  988: 722 */     return this.drsOd15;
/*  989:     */   }
/*  990:     */   
/*  991:     */   public void setDrsOd15(String drsOd15)
/*  992:     */   {
/*  993: 726 */     this.drsOd15 = drsOd15;
/*  994:     */   }
/*  995:     */   
/*  996:     */   public String getDrsOd16()
/*  997:     */   {
/*  998: 730 */     return this.drsOd16;
/*  999:     */   }
/* 1000:     */   
/* 1001:     */   public void setDrsOd16(String drsOd16)
/* 1002:     */   {
/* 1003: 734 */     this.drsOd16 = drsOd16;
/* 1004:     */   }
/* 1005:     */   
/* 1006:     */   public String getDrsOd17()
/* 1007:     */   {
/* 1008: 738 */     return this.drsOd17;
/* 1009:     */   }
/* 1010:     */   
/* 1011:     */   public void setDrsOd17(String drsOd17)
/* 1012:     */   {
/* 1013: 742 */     this.drsOd17 = drsOd17;
/* 1014:     */   }
/* 1015:     */   
/* 1016:     */   public String getDrsOd18()
/* 1017:     */   {
/* 1018: 746 */     return this.drsOd18;
/* 1019:     */   }
/* 1020:     */   
/* 1021:     */   public void setDrsOd18(String drsOd18)
/* 1022:     */   {
/* 1023: 750 */     this.drsOd18 = drsOd18;
/* 1024:     */   }
/* 1025:     */   
/* 1026:     */   public String getDrsOd19()
/* 1027:     */   {
/* 1028: 754 */     return this.drsOd19;
/* 1029:     */   }
/* 1030:     */   
/* 1031:     */   public void setDrsOd19(String drsOd19)
/* 1032:     */   {
/* 1033: 758 */     this.drsOd19 = drsOd19;
/* 1034:     */   }
/* 1035:     */   
/* 1036:     */   public String getDrsOd20()
/* 1037:     */   {
/* 1038: 762 */     return this.drsOd20;
/* 1039:     */   }
/* 1040:     */   
/* 1041:     */   public void setDrsOd20(String drsOd20)
/* 1042:     */   {
/* 1043: 766 */     this.drsOd20 = drsOd20;
/* 1044:     */   }
/* 1045:     */   
/* 1046:     */   public String getDrsOd21()
/* 1047:     */   {
/* 1048: 770 */     return this.drsOd21;
/* 1049:     */   }
/* 1050:     */   
/* 1051:     */   public void setDrsOd21(String drsOd21)
/* 1052:     */   {
/* 1053: 774 */     this.drsOd21 = drsOd21;
/* 1054:     */   }
/* 1055:     */   
/* 1056:     */   public String getDrsOd22()
/* 1057:     */   {
/* 1058: 778 */     return this.drsOd22;
/* 1059:     */   }
/* 1060:     */   
/* 1061:     */   public void setDrsOd22(String drsOd22)
/* 1062:     */   {
/* 1063: 782 */     this.drsOd22 = drsOd22;
/* 1064:     */   }
/* 1065:     */   
/* 1066:     */   public String getDrsOd23()
/* 1067:     */   {
/* 1068: 786 */     return this.drsOd23;
/* 1069:     */   }
/* 1070:     */   
/* 1071:     */   public void setDrsOd23(String drsOd23)
/* 1072:     */   {
/* 1073: 790 */     this.drsOd23 = drsOd23;
/* 1074:     */   }
/* 1075:     */   
/* 1076:     */   public String getDrsOd24()
/* 1077:     */   {
/* 1078: 794 */     return this.drsOd24;
/* 1079:     */   }
/* 1080:     */   
/* 1081:     */   public void setDrsOd24(String drsOd24)
/* 1082:     */   {
/* 1083: 798 */     this.drsOd24 = drsOd24;
/* 1084:     */   }
/* 1085:     */   
/* 1086:     */   public String getDrsOd25()
/* 1087:     */   {
/* 1088: 802 */     return this.drsOd25;
/* 1089:     */   }
/* 1090:     */   
/* 1091:     */   public void setDrsOd25(String drsOd25)
/* 1092:     */   {
/* 1093: 806 */     this.drsOd25 = drsOd25;
/* 1094:     */   }
/* 1095:     */   
/* 1096:     */   public String getDrsOd26()
/* 1097:     */   {
/* 1098: 810 */     return this.drsOd26;
/* 1099:     */   }
/* 1100:     */   
/* 1101:     */   public void setDrsOd26(String drsOd26)
/* 1102:     */   {
/* 1103: 814 */     this.drsOd26 = drsOd26;
/* 1104:     */   }
/* 1105:     */   
/* 1106:     */   public String getDrsOd27()
/* 1107:     */   {
/* 1108: 818 */     return this.drsOd27;
/* 1109:     */   }
/* 1110:     */   
/* 1111:     */   public void setDrsOd27(String drsOd27)
/* 1112:     */   {
/* 1113: 822 */     this.drsOd27 = drsOd27;
/* 1114:     */   }
/* 1115:     */   
/* 1116:     */   public String getDrsOd28()
/* 1117:     */   {
/* 1118: 826 */     return this.drsOd28;
/* 1119:     */   }
/* 1120:     */   
/* 1121:     */   public void setDrsOd28(String drsOd28)
/* 1122:     */   {
/* 1123: 830 */     this.drsOd28 = drsOd28;
/* 1124:     */   }
/* 1125:     */   
/* 1126:     */   public String getDrsOd29()
/* 1127:     */   {
/* 1128: 834 */     return this.drsOd29;
/* 1129:     */   }
/* 1130:     */   
/* 1131:     */   public void setDrsOd29(String drsOd29)
/* 1132:     */   {
/* 1133: 838 */     this.drsOd29 = drsOd29;
/* 1134:     */   }
/* 1135:     */   
/* 1136:     */   public String getDrsOd30()
/* 1137:     */   {
/* 1138: 842 */     return this.drsOd30;
/* 1139:     */   }
/* 1140:     */   
/* 1141:     */   public void setDrsOd30(String drsOd30)
/* 1142:     */   {
/* 1143: 846 */     this.drsOd30 = drsOd30;
/* 1144:     */   }
/* 1145:     */   
/* 1146:     */   public String getDrsOd31()
/* 1147:     */   {
/* 1148: 850 */     return this.drsOd31;
/* 1149:     */   }
/* 1150:     */   
/* 1151:     */   public void setDrsOd31(String drsOd31)
/* 1152:     */   {
/* 1153: 854 */     this.drsOd31 = drsOd31;
/* 1154:     */   }
/* 1155:     */   
/* 1156:     */   public String getDrsOd1Fix()
/* 1157:     */   {
/* 1158: 858 */     return this.drsOd1Fix;
/* 1159:     */   }
/* 1160:     */   
/* 1161:     */   public void setDrsOd1Fix(String drsOd1Fix)
/* 1162:     */   {
/* 1163: 862 */     this.drsOd1Fix = drsOd1Fix;
/* 1164:     */   }
/* 1165:     */   
/* 1166:     */   public String getDrsOd2Fix()
/* 1167:     */   {
/* 1168: 866 */     return this.drsOd2Fix;
/* 1169:     */   }
/* 1170:     */   
/* 1171:     */   public void setDrsOd2Fix(String drsOd2Fix)
/* 1172:     */   {
/* 1173: 870 */     this.drsOd2Fix = drsOd2Fix;
/* 1174:     */   }
/* 1175:     */   
/* 1176:     */   public String getDrsOd3Fix()
/* 1177:     */   {
/* 1178: 874 */     return this.drsOd3Fix;
/* 1179:     */   }
/* 1180:     */   
/* 1181:     */   public void setDrsOd3Fix(String drsOd3Fix)
/* 1182:     */   {
/* 1183: 878 */     this.drsOd3Fix = drsOd3Fix;
/* 1184:     */   }
/* 1185:     */   
/* 1186:     */   public String getDrsOd4Fix()
/* 1187:     */   {
/* 1188: 882 */     return this.drsOd4Fix;
/* 1189:     */   }
/* 1190:     */   
/* 1191:     */   public void setDrsOd4Fix(String drsOd4Fix)
/* 1192:     */   {
/* 1193: 886 */     this.drsOd4Fix = drsOd4Fix;
/* 1194:     */   }
/* 1195:     */   
/* 1196:     */   public String getDrsOd5Fix()
/* 1197:     */   {
/* 1198: 890 */     return this.drsOd5Fix;
/* 1199:     */   }
/* 1200:     */   
/* 1201:     */   public void setDrsOd5Fix(String drsOd5Fix)
/* 1202:     */   {
/* 1203: 894 */     this.drsOd5Fix = drsOd5Fix;
/* 1204:     */   }
/* 1205:     */   
/* 1206:     */   public String getDrsOd6Fix()
/* 1207:     */   {
/* 1208: 898 */     return this.drsOd6Fix;
/* 1209:     */   }
/* 1210:     */   
/* 1211:     */   public void setDrsOd6Fix(String drsOd6Fix)
/* 1212:     */   {
/* 1213: 902 */     this.drsOd6Fix = drsOd6Fix;
/* 1214:     */   }
/* 1215:     */   
/* 1216:     */   public String getDrsOd7Fix()
/* 1217:     */   {
/* 1218: 906 */     return this.drsOd7Fix;
/* 1219:     */   }
/* 1220:     */   
/* 1221:     */   public void setDrsOd7Fix(String drsOd7Fix)
/* 1222:     */   {
/* 1223: 910 */     this.drsOd7Fix = drsOd7Fix;
/* 1224:     */   }
/* 1225:     */   
/* 1226:     */   public String getDrsOd8Fix()
/* 1227:     */   {
/* 1228: 914 */     return this.drsOd8Fix;
/* 1229:     */   }
/* 1230:     */   
/* 1231:     */   public void setDrsOd8Fix(String drsOd8Fix)
/* 1232:     */   {
/* 1233: 918 */     this.drsOd8Fix = drsOd8Fix;
/* 1234:     */   }
/* 1235:     */   
/* 1236:     */   public String getDrsOd9Fix()
/* 1237:     */   {
/* 1238: 922 */     return this.drsOd9Fix;
/* 1239:     */   }
/* 1240:     */   
/* 1241:     */   public void setDrsOd9Fix(String drsOd9Fix)
/* 1242:     */   {
/* 1243: 926 */     this.drsOd9Fix = drsOd9Fix;
/* 1244:     */   }
/* 1245:     */   
/* 1246:     */   public String getDrsOd10Fix()
/* 1247:     */   {
/* 1248: 930 */     return this.drsOd10Fix;
/* 1249:     */   }
/* 1250:     */   
/* 1251:     */   public void setDrsOd10Fix(String drsOd10Fix)
/* 1252:     */   {
/* 1253: 934 */     this.drsOd10Fix = drsOd10Fix;
/* 1254:     */   }
/* 1255:     */   
/* 1256:     */   public String getDrsOd11Fix()
/* 1257:     */   {
/* 1258: 938 */     return this.drsOd11Fix;
/* 1259:     */   }
/* 1260:     */   
/* 1261:     */   public void setDrsOd11Fix(String drsOd11Fix)
/* 1262:     */   {
/* 1263: 942 */     this.drsOd11Fix = drsOd11Fix;
/* 1264:     */   }
/* 1265:     */   
/* 1266:     */   public String getDrsOd12Fix()
/* 1267:     */   {
/* 1268: 946 */     return this.drsOd12Fix;
/* 1269:     */   }
/* 1270:     */   
/* 1271:     */   public void setDrsOd12Fix(String drsOd12Fix)
/* 1272:     */   {
/* 1273: 950 */     this.drsOd12Fix = drsOd12Fix;
/* 1274:     */   }
/* 1275:     */   
/* 1276:     */   public String getDrsOd13Fix()
/* 1277:     */   {
/* 1278: 954 */     return this.drsOd13Fix;
/* 1279:     */   }
/* 1280:     */   
/* 1281:     */   public void setDrsOd13Fix(String drsOd13Fix)
/* 1282:     */   {
/* 1283: 958 */     this.drsOd13Fix = drsOd13Fix;
/* 1284:     */   }
/* 1285:     */   
/* 1286:     */   public String getDrsOd14Fix()
/* 1287:     */   {
/* 1288: 962 */     return this.drsOd14Fix;
/* 1289:     */   }
/* 1290:     */   
/* 1291:     */   public void setDrsOd14Fix(String drsOd14Fix)
/* 1292:     */   {
/* 1293: 966 */     this.drsOd14Fix = drsOd14Fix;
/* 1294:     */   }
/* 1295:     */   
/* 1296:     */   public String getDrsOd15Fix()
/* 1297:     */   {
/* 1298: 970 */     return this.drsOd15Fix;
/* 1299:     */   }
/* 1300:     */   
/* 1301:     */   public void setDrsOd15Fix(String drsOd15Fix)
/* 1302:     */   {
/* 1303: 974 */     this.drsOd15Fix = drsOd15Fix;
/* 1304:     */   }
/* 1305:     */   
/* 1306:     */   public String getDrsOd16Fix()
/* 1307:     */   {
/* 1308: 978 */     return this.drsOd16Fix;
/* 1309:     */   }
/* 1310:     */   
/* 1311:     */   public void setDrsOd16Fix(String drsOd16Fix)
/* 1312:     */   {
/* 1313: 982 */     this.drsOd16Fix = drsOd16Fix;
/* 1314:     */   }
/* 1315:     */   
/* 1316:     */   public String getDrsOd17Fix()
/* 1317:     */   {
/* 1318: 986 */     return this.drsOd17Fix;
/* 1319:     */   }
/* 1320:     */   
/* 1321:     */   public void setDrsOd17Fix(String drsOd17Fix)
/* 1322:     */   {
/* 1323: 990 */     this.drsOd17Fix = drsOd17Fix;
/* 1324:     */   }
/* 1325:     */   
/* 1326:     */   public String getDrsOd18Fix()
/* 1327:     */   {
/* 1328: 994 */     return this.drsOd18Fix;
/* 1329:     */   }
/* 1330:     */   
/* 1331:     */   public void setDrsOd18Fix(String drsOd18Fix)
/* 1332:     */   {
/* 1333: 998 */     this.drsOd18Fix = drsOd18Fix;
/* 1334:     */   }
/* 1335:     */   
/* 1336:     */   public String getDrsOd19Fix()
/* 1337:     */   {
/* 1338:1002 */     return this.drsOd19Fix;
/* 1339:     */   }
/* 1340:     */   
/* 1341:     */   public void setDrsOd19Fix(String drsOd19Fix)
/* 1342:     */   {
/* 1343:1006 */     this.drsOd19Fix = drsOd19Fix;
/* 1344:     */   }
/* 1345:     */   
/* 1346:     */   public String getDrsOd20Fix()
/* 1347:     */   {
/* 1348:1010 */     return this.drsOd20Fix;
/* 1349:     */   }
/* 1350:     */   
/* 1351:     */   public void setDrsOd20Fix(String drsOd20Fix)
/* 1352:     */   {
/* 1353:1014 */     this.drsOd20Fix = drsOd20Fix;
/* 1354:     */   }
/* 1355:     */   
/* 1356:     */   public String getDrsOd21Fix()
/* 1357:     */   {
/* 1358:1018 */     return this.drsOd21Fix;
/* 1359:     */   }
/* 1360:     */   
/* 1361:     */   public void setDrsOd21Fix(String drsOd21Fix)
/* 1362:     */   {
/* 1363:1022 */     this.drsOd21Fix = drsOd21Fix;
/* 1364:     */   }
/* 1365:     */   
/* 1366:     */   public String getDrsOd22Fix()
/* 1367:     */   {
/* 1368:1026 */     return this.drsOd22Fix;
/* 1369:     */   }
/* 1370:     */   
/* 1371:     */   public void setDrsOd22Fix(String drsOd22Fix)
/* 1372:     */   {
/* 1373:1030 */     this.drsOd22Fix = drsOd22Fix;
/* 1374:     */   }
/* 1375:     */   
/* 1376:     */   public String getDrsOd23Fix()
/* 1377:     */   {
/* 1378:1034 */     return this.drsOd23Fix;
/* 1379:     */   }
/* 1380:     */   
/* 1381:     */   public void setDrsOd23Fix(String drsOd23Fix)
/* 1382:     */   {
/* 1383:1038 */     this.drsOd23Fix = drsOd23Fix;
/* 1384:     */   }
/* 1385:     */   
/* 1386:     */   public String getDrsOd24Fix()
/* 1387:     */   {
/* 1388:1042 */     return this.drsOd24Fix;
/* 1389:     */   }
/* 1390:     */   
/* 1391:     */   public void setDrsOd24Fix(String drsOd24Fix)
/* 1392:     */   {
/* 1393:1046 */     this.drsOd24Fix = drsOd24Fix;
/* 1394:     */   }
/* 1395:     */   
/* 1396:     */   public String getDrsOd25Fix()
/* 1397:     */   {
/* 1398:1050 */     return this.drsOd25Fix;
/* 1399:     */   }
/* 1400:     */   
/* 1401:     */   public void setDrsOd25Fix(String drsOd25Fix)
/* 1402:     */   {
/* 1403:1054 */     this.drsOd25Fix = drsOd25Fix;
/* 1404:     */   }
/* 1405:     */   
/* 1406:     */   public String getDrsOd26Fix()
/* 1407:     */   {
/* 1408:1058 */     return this.drsOd26Fix;
/* 1409:     */   }
/* 1410:     */   
/* 1411:     */   public void setDrsOd26Fix(String drsOd26Fix)
/* 1412:     */   {
/* 1413:1062 */     this.drsOd26Fix = drsOd26Fix;
/* 1414:     */   }
/* 1415:     */   
/* 1416:     */   public String getDrsOd27Fix()
/* 1417:     */   {
/* 1418:1066 */     return this.drsOd27Fix;
/* 1419:     */   }
/* 1420:     */   
/* 1421:     */   public void setDrsOd27Fix(String drsOd27Fix)
/* 1422:     */   {
/* 1423:1070 */     this.drsOd27Fix = drsOd27Fix;
/* 1424:     */   }
/* 1425:     */   
/* 1426:     */   public String getDrsOd28Fix()
/* 1427:     */   {
/* 1428:1074 */     return this.drsOd28Fix;
/* 1429:     */   }
/* 1430:     */   
/* 1431:     */   public void setDrsOd28Fix(String drsOd28Fix)
/* 1432:     */   {
/* 1433:1078 */     this.drsOd28Fix = drsOd28Fix;
/* 1434:     */   }
/* 1435:     */   
/* 1436:     */   public String getDrsOd29Fix()
/* 1437:     */   {
/* 1438:1082 */     return this.drsOd29Fix;
/* 1439:     */   }
/* 1440:     */   
/* 1441:     */   public void setDrsOd29Fix(String drsOd29Fix)
/* 1442:     */   {
/* 1443:1086 */     this.drsOd29Fix = drsOd29Fix;
/* 1444:     */   }
/* 1445:     */   
/* 1446:     */   public String getDrsOd30Fix()
/* 1447:     */   {
/* 1448:1090 */     return this.drsOd30Fix;
/* 1449:     */   }
/* 1450:     */   
/* 1451:     */   public void setDrsOd30Fix(String drsOd30Fix)
/* 1452:     */   {
/* 1453:1094 */     this.drsOd30Fix = drsOd30Fix;
/* 1454:     */   }
/* 1455:     */   
/* 1456:     */   public String getDrsOd31Fix()
/* 1457:     */   {
/* 1458:1098 */     return this.drsOd31Fix;
/* 1459:     */   }
/* 1460:     */   
/* 1461:     */   public void setDrsOd31Fix(String drsOd31Fix)
/* 1462:     */   {
/* 1463:1102 */     this.drsOd31Fix = drsOd31Fix;
/* 1464:     */   }
/* 1465:     */   
/* 1466:     */   public String getDrsVarId()
/* 1467:     */   {
/* 1468:1106 */     return this.drsVarId;
/* 1469:     */   }
/* 1470:     */   
/* 1471:     */   public void setDrsVarId(String drsVarId)
/* 1472:     */   {
/* 1473:1110 */     this.drsVarId = drsVarId;
/* 1474:     */   }
/* 1475:     */   
/* 1476:     */   public List<Integer> getDiasMes()
/* 1477:     */   {
/* 1478:1114 */     return Utiles.getDiasdelMes(getDrsMes().intValue(), getDrsAno()
/* 1479:1115 */       .intValue());
/* 1480:     */   }
/* 1481:     */ }


/* Location:           C:\Users\Luis\Desktop\CLXX\BalanceQL\Fuentes\
 * Qualified Name:     sia.bql.hibernate.hidromet.AbstractShmtDiarios
 * JD-Core Version:    0.7.0.1
 */