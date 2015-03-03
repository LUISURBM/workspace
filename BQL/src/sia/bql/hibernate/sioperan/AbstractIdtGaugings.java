/*   1:    */ package sia.bql.hibernate.sioperan;
/*   2:    */ 
/*   3:    */ import java.io.Serializable;
/*   4:    */ import java.util.Date;
/*   5:    */ import java.util.HashSet;
/*   6:    */ import java.util.Set;
/*   7:    */ 
/*   8:    */ public abstract class AbstractIdtGaugings
/*   9:    */   implements Serializable
/*  10:    */ {
/*  11:    */   private static final long serialVersionUID = 1L;
/*  12:    */   private Double ggnConversionFactor;
/*  13:    */   private Date ggnDate;
/*  14:    */   private Double ggnDiameterFuze;
/*  15:    */   private String ggnEquipo;
/*  16:    */   private Date ggnFinalHour;
/*  17:    */   private Long ggnFinalLevel;
/*  18:    */   private String ggnFmlCode;
/*  19:    */   private String ggnFmlCodeMethod;
/*  20:    */   private String ggnFmlFmtpCode;
/*  21:    */   private String ggnFmlFmtpCodeMethod;
/*  22:    */   private String ggnFmlTypCode;
/*  23:    */   private String ggnFmlTypFmtpCode;
/*  24:    */   private Long ggnId;
/*  25:    */   private String ggnInitialBorder;
/*  26:    */   private Date ggnInitialHour;
/*  27:    */   private Long ggnInitialLevel;
/*  28:    */   private Long ggnInsId;
/*  29:    */   private String ggnInspector;
/*  30:    */   private String ggnLagAngleExists;
/*  31:    */   private String ggnObservations;
/*  32:    */   private String ggnPilotExists;
/*  33:    */   private Long ggnSections;
/*  34:    */   private String ggnSttCode;
/*  35:    */   private Double ggnSupCrcSamp12;
/*  36:    */   private Double ggnSupCrcSamp14;
/*  37:    */   private Double ggnSupCrcSamp34;
/*  38:    */   private Double ggnSupNmrSamp12;
/*  39:    */   private Double ggnSupNmrSamp14;
/*  40:    */   private Double ggnSupNmrSamp34;
/*  41:    */   private Double ggnSupTarSamp12;
/*  42:    */   private Double ggnSupTarSamp14;
/*  43:    */   private Double ggnSupTarSamp34;
/*  44:    */   private Double ggnSupVlmSamp12;
/*  45:    */   private Double ggnSupVlmSamp14;
/*  46:    */   private Double ggnSupVlmSamp34;
/*  47:    */   private Double ggnSupWghSamp12;
/*  48:    */   private Double ggnSupWghSamp14;
/*  49:    */   private Double ggnSupWghSamp34;
/*  50:    */   private Long ggnTempWater;
/*  51:    */   private Date ggnTimestamp;
/*  52:    */   private Long ggnTtlVlm;
/*  53:    */   private Long ggnWndId;
/*  54: 86 */   private Set idtAbstracLiquidGauginses = new HashSet(0);
/*  55:    */   private IdtUsers idtUsers;
/*  56:    */   
/*  57:    */   public Double getGgnConversionFactor()
/*  58:    */   {
/*  59:103 */     return this.ggnConversionFactor;
/*  60:    */   }
/*  61:    */   
/*  62:    */   public Date getGgnDate()
/*  63:    */   {
/*  64:111 */     return this.ggnDate;
/*  65:    */   }
/*  66:    */   
/*  67:    */   public Double getGgnDiameterFuze()
/*  68:    */   {
/*  69:119 */     return this.ggnDiameterFuze;
/*  70:    */   }
/*  71:    */   
/*  72:    */   public String getGgnEquipo()
/*  73:    */   {
/*  74:127 */     return this.ggnEquipo;
/*  75:    */   }
/*  76:    */   
/*  77:    */   public Date getGgnFinalHour()
/*  78:    */   {
/*  79:135 */     return this.ggnFinalHour;
/*  80:    */   }
/*  81:    */   
/*  82:    */   public Long getGgnFinalLevel()
/*  83:    */   {
/*  84:143 */     return this.ggnFinalLevel;
/*  85:    */   }
/*  86:    */   
/*  87:    */   public String getGgnFmlCode()
/*  88:    */   {
/*  89:151 */     return this.ggnFmlCode;
/*  90:    */   }
/*  91:    */   
/*  92:    */   public String getGgnFmlCodeMethod()
/*  93:    */   {
/*  94:159 */     return this.ggnFmlCodeMethod;
/*  95:    */   }
/*  96:    */   
/*  97:    */   public String getGgnFmlFmtpCode()
/*  98:    */   {
/*  99:167 */     return this.ggnFmlFmtpCode;
/* 100:    */   }
/* 101:    */   
/* 102:    */   public String getGgnFmlFmtpCodeMethod()
/* 103:    */   {
/* 104:175 */     return this.ggnFmlFmtpCodeMethod;
/* 105:    */   }
/* 106:    */   
/* 107:    */   public String getGgnFmlTypCode()
/* 108:    */   {
/* 109:183 */     return this.ggnFmlTypCode;
/* 110:    */   }
/* 111:    */   
/* 112:    */   public String getGgnFmlTypFmtpCode()
/* 113:    */   {
/* 114:191 */     return this.ggnFmlTypFmtpCode;
/* 115:    */   }
/* 116:    */   
/* 117:    */   public Long getGgnId()
/* 118:    */   {
/* 119:200 */     return this.ggnId;
/* 120:    */   }
/* 121:    */   
/* 122:    */   public String getGgnInitialBorder()
/* 123:    */   {
/* 124:208 */     return this.ggnInitialBorder;
/* 125:    */   }
/* 126:    */   
/* 127:    */   public Date getGgnInitialHour()
/* 128:    */   {
/* 129:216 */     return this.ggnInitialHour;
/* 130:    */   }
/* 131:    */   
/* 132:    */   public Long getGgnInitialLevel()
/* 133:    */   {
/* 134:224 */     return this.ggnInitialLevel;
/* 135:    */   }
/* 136:    */   
/* 137:    */   public Long getGgnInsId()
/* 138:    */   {
/* 139:232 */     return this.ggnInsId;
/* 140:    */   }
/* 141:    */   
/* 142:    */   public String getGgnInspector()
/* 143:    */   {
/* 144:240 */     return this.ggnInspector;
/* 145:    */   }
/* 146:    */   
/* 147:    */   public String getGgnLagAngleExists()
/* 148:    */   {
/* 149:248 */     return this.ggnLagAngleExists;
/* 150:    */   }
/* 151:    */   
/* 152:    */   public String getGgnObservations()
/* 153:    */   {
/* 154:256 */     return this.ggnObservations;
/* 155:    */   }
/* 156:    */   
/* 157:    */   public String getGgnPilotExists()
/* 158:    */   {
/* 159:264 */     return this.ggnPilotExists;
/* 160:    */   }
/* 161:    */   
/* 162:    */   public Long getGgnSections()
/* 163:    */   {
/* 164:272 */     return this.ggnSections;
/* 165:    */   }
/* 166:    */   
/* 167:    */   public String getGgnSttCode()
/* 168:    */   {
/* 169:280 */     return this.ggnSttCode;
/* 170:    */   }
/* 171:    */   
/* 172:    */   public Double getGgnSupCrcSamp12()
/* 173:    */   {
/* 174:288 */     return this.ggnSupCrcSamp12;
/* 175:    */   }
/* 176:    */   
/* 177:    */   public Double getGgnSupCrcSamp14()
/* 178:    */   {
/* 179:296 */     return this.ggnSupCrcSamp14;
/* 180:    */   }
/* 181:    */   
/* 182:    */   public Double getGgnSupCrcSamp34()
/* 183:    */   {
/* 184:304 */     return this.ggnSupCrcSamp34;
/* 185:    */   }
/* 186:    */   
/* 187:    */   public Double getGgnSupNmrSamp12()
/* 188:    */   {
/* 189:312 */     return this.ggnSupNmrSamp12;
/* 190:    */   }
/* 191:    */   
/* 192:    */   public Double getGgnSupNmrSamp14()
/* 193:    */   {
/* 194:320 */     return this.ggnSupNmrSamp14;
/* 195:    */   }
/* 196:    */   
/* 197:    */   public Double getGgnSupNmrSamp34()
/* 198:    */   {
/* 199:328 */     return this.ggnSupNmrSamp34;
/* 200:    */   }
/* 201:    */   
/* 202:    */   public Double getGgnSupTarSamp12()
/* 203:    */   {
/* 204:336 */     return this.ggnSupTarSamp12;
/* 205:    */   }
/* 206:    */   
/* 207:    */   public Double getGgnSupTarSamp14()
/* 208:    */   {
/* 209:344 */     return this.ggnSupTarSamp14;
/* 210:    */   }
/* 211:    */   
/* 212:    */   public Double getGgnSupTarSamp34()
/* 213:    */   {
/* 214:352 */     return this.ggnSupTarSamp34;
/* 215:    */   }
/* 216:    */   
/* 217:    */   public Double getGgnSupVlmSamp12()
/* 218:    */   {
/* 219:360 */     return this.ggnSupVlmSamp12;
/* 220:    */   }
/* 221:    */   
/* 222:    */   public Double getGgnSupVlmSamp14()
/* 223:    */   {
/* 224:368 */     return this.ggnSupVlmSamp14;
/* 225:    */   }
/* 226:    */   
/* 227:    */   public Double getGgnSupVlmSamp34()
/* 228:    */   {
/* 229:376 */     return this.ggnSupVlmSamp34;
/* 230:    */   }
/* 231:    */   
/* 232:    */   public Double getGgnSupWghSamp12()
/* 233:    */   {
/* 234:384 */     return this.ggnSupWghSamp12;
/* 235:    */   }
/* 236:    */   
/* 237:    */   public Double getGgnSupWghSamp14()
/* 238:    */   {
/* 239:392 */     return this.ggnSupWghSamp14;
/* 240:    */   }
/* 241:    */   
/* 242:    */   public Double getGgnSupWghSamp34()
/* 243:    */   {
/* 244:400 */     return this.ggnSupWghSamp34;
/* 245:    */   }
/* 246:    */   
/* 247:    */   public Long getGgnTempWater()
/* 248:    */   {
/* 249:408 */     return this.ggnTempWater;
/* 250:    */   }
/* 251:    */   
/* 252:    */   public Date getGgnTimestamp()
/* 253:    */   {
/* 254:416 */     return this.ggnTimestamp;
/* 255:    */   }
/* 256:    */   
/* 257:    */   public Long getGgnTtlVlm()
/* 258:    */   {
/* 259:424 */     return this.ggnTtlVlm;
/* 260:    */   }
/* 261:    */   
/* 262:    */   public Long getGgnWndId()
/* 263:    */   {
/* 264:432 */     return this.ggnWndId;
/* 265:    */   }
/* 266:    */   
/* 267:    */   public Set getIdtAbstracLiquidGauginses()
/* 268:    */   {
/* 269:440 */     return this.idtAbstracLiquidGauginses;
/* 270:    */   }
/* 271:    */   
/* 272:    */   public IdtUsers getIdtUsers()
/* 273:    */   {
/* 274:456 */     return this.idtUsers;
/* 275:    */   }
/* 276:    */   
/* 277:    */   public void setGgnConversionFactor(Double ggnConversionFactor)
/* 278:    */   {
/* 279:465 */     this.ggnConversionFactor = ggnConversionFactor;
/* 280:    */   }
/* 281:    */   
/* 282:    */   public void setGgnDate(Date ggnDate)
/* 283:    */   {
/* 284:474 */     this.ggnDate = ggnDate;
/* 285:    */   }
/* 286:    */   
/* 287:    */   public void setGgnDiameterFuze(Double ggnDiameterFuze)
/* 288:    */   {
/* 289:483 */     this.ggnDiameterFuze = ggnDiameterFuze;
/* 290:    */   }
/* 291:    */   
/* 292:    */   public void setGgnEquipo(String ggnEquipo)
/* 293:    */   {
/* 294:492 */     this.ggnEquipo = ggnEquipo;
/* 295:    */   }
/* 296:    */   
/* 297:    */   public void setGgnFinalHour(Date ggnFinalHour)
/* 298:    */   {
/* 299:501 */     this.ggnFinalHour = ggnFinalHour;
/* 300:    */   }
/* 301:    */   
/* 302:    */   public void setGgnFinalLevel(Long ggnFinalLevel)
/* 303:    */   {
/* 304:510 */     this.ggnFinalLevel = ggnFinalLevel;
/* 305:    */   }
/* 306:    */   
/* 307:    */   public void setGgnFmlCode(String ggnFmlCode)
/* 308:    */   {
/* 309:519 */     this.ggnFmlCode = ggnFmlCode;
/* 310:    */   }
/* 311:    */   
/* 312:    */   public void setGgnFmlCodeMethod(String ggnFmlCodeMethod)
/* 313:    */   {
/* 314:528 */     this.ggnFmlCodeMethod = ggnFmlCodeMethod;
/* 315:    */   }
/* 316:    */   
/* 317:    */   public void setGgnFmlFmtpCode(String ggnFmlFmtpCode)
/* 318:    */   {
/* 319:537 */     this.ggnFmlFmtpCode = ggnFmlFmtpCode;
/* 320:    */   }
/* 321:    */   
/* 322:    */   public void setGgnFmlFmtpCodeMethod(String ggnFmlFmtpCodeMethod)
/* 323:    */   {
/* 324:546 */     this.ggnFmlFmtpCodeMethod = ggnFmlFmtpCodeMethod;
/* 325:    */   }
/* 326:    */   
/* 327:    */   public void setGgnFmlTypCode(String ggnFmlTypCode)
/* 328:    */   {
/* 329:555 */     this.ggnFmlTypCode = ggnFmlTypCode;
/* 330:    */   }
/* 331:    */   
/* 332:    */   public void setGgnFmlTypFmtpCode(String ggnFmlTypFmtpCode)
/* 333:    */   {
/* 334:564 */     this.ggnFmlTypFmtpCode = ggnFmlTypFmtpCode;
/* 335:    */   }
/* 336:    */   
/* 337:    */   public void setGgnId(Long ggnId)
/* 338:    */   {
/* 339:573 */     this.ggnId = ggnId;
/* 340:    */   }
/* 341:    */   
/* 342:    */   public void setGgnInitialBorder(String ggnInitialBorder)
/* 343:    */   {
/* 344:582 */     this.ggnInitialBorder = ggnInitialBorder;
/* 345:    */   }
/* 346:    */   
/* 347:    */   public void setGgnInitialHour(Date ggnInitialHour)
/* 348:    */   {
/* 349:591 */     this.ggnInitialHour = ggnInitialHour;
/* 350:    */   }
/* 351:    */   
/* 352:    */   public void setGgnInitialLevel(Long ggnInitialLevel)
/* 353:    */   {
/* 354:600 */     this.ggnInitialLevel = ggnInitialLevel;
/* 355:    */   }
/* 356:    */   
/* 357:    */   public void setGgnInsId(Long ggnInsId)
/* 358:    */   {
/* 359:609 */     this.ggnInsId = ggnInsId;
/* 360:    */   }
/* 361:    */   
/* 362:    */   public void setGgnInspector(String ggnInspector)
/* 363:    */   {
/* 364:618 */     this.ggnInspector = ggnInspector;
/* 365:    */   }
/* 366:    */   
/* 367:    */   public void setGgnLagAngleExists(String ggnLagAngleExists)
/* 368:    */   {
/* 369:627 */     this.ggnLagAngleExists = ggnLagAngleExists;
/* 370:    */   }
/* 371:    */   
/* 372:    */   public void setGgnObservations(String ggnObservations)
/* 373:    */   {
/* 374:636 */     this.ggnObservations = ggnObservations;
/* 375:    */   }
/* 376:    */   
/* 377:    */   public void setGgnPilotExists(String ggnPilotExists)
/* 378:    */   {
/* 379:645 */     this.ggnPilotExists = ggnPilotExists;
/* 380:    */   }
/* 381:    */   
/* 382:    */   public void setGgnSections(Long ggnSections)
/* 383:    */   {
/* 384:654 */     this.ggnSections = ggnSections;
/* 385:    */   }
/* 386:    */   
/* 387:    */   public void setGgnSttCode(String ggnSttCode)
/* 388:    */   {
/* 389:663 */     this.ggnSttCode = ggnSttCode;
/* 390:    */   }
/* 391:    */   
/* 392:    */   public void setGgnSupCrcSamp12(Double ggnSupCrcSamp12)
/* 393:    */   {
/* 394:672 */     this.ggnSupCrcSamp12 = ggnSupCrcSamp12;
/* 395:    */   }
/* 396:    */   
/* 397:    */   public void setGgnSupCrcSamp14(Double ggnSupCrcSamp14)
/* 398:    */   {
/* 399:681 */     this.ggnSupCrcSamp14 = ggnSupCrcSamp14;
/* 400:    */   }
/* 401:    */   
/* 402:    */   public void setGgnSupCrcSamp34(Double ggnSupCrcSamp34)
/* 403:    */   {
/* 404:690 */     this.ggnSupCrcSamp34 = ggnSupCrcSamp34;
/* 405:    */   }
/* 406:    */   
/* 407:    */   public void setGgnSupNmrSamp12(Double ggnSupNmrSamp12)
/* 408:    */   {
/* 409:699 */     this.ggnSupNmrSamp12 = ggnSupNmrSamp12;
/* 410:    */   }
/* 411:    */   
/* 412:    */   public void setGgnSupNmrSamp14(Double ggnSupNmrSamp14)
/* 413:    */   {
/* 414:708 */     this.ggnSupNmrSamp14 = ggnSupNmrSamp14;
/* 415:    */   }
/* 416:    */   
/* 417:    */   public void setGgnSupNmrSamp34(Double ggnSupNmrSamp34)
/* 418:    */   {
/* 419:717 */     this.ggnSupNmrSamp34 = ggnSupNmrSamp34;
/* 420:    */   }
/* 421:    */   
/* 422:    */   public void setGgnSupTarSamp12(Double ggnSupTarSamp12)
/* 423:    */   {
/* 424:726 */     this.ggnSupTarSamp12 = ggnSupTarSamp12;
/* 425:    */   }
/* 426:    */   
/* 427:    */   public void setGgnSupTarSamp14(Double ggnSupTarSamp14)
/* 428:    */   {
/* 429:735 */     this.ggnSupTarSamp14 = ggnSupTarSamp14;
/* 430:    */   }
/* 431:    */   
/* 432:    */   public void setGgnSupTarSamp34(Double ggnSupTarSamp34)
/* 433:    */   {
/* 434:744 */     this.ggnSupTarSamp34 = ggnSupTarSamp34;
/* 435:    */   }
/* 436:    */   
/* 437:    */   public void setGgnSupVlmSamp12(Double ggnSupVlmSamp12)
/* 438:    */   {
/* 439:753 */     this.ggnSupVlmSamp12 = ggnSupVlmSamp12;
/* 440:    */   }
/* 441:    */   
/* 442:    */   public void setGgnSupVlmSamp14(Double ggnSupVlmSamp14)
/* 443:    */   {
/* 444:762 */     this.ggnSupVlmSamp14 = ggnSupVlmSamp14;
/* 445:    */   }
/* 446:    */   
/* 447:    */   public void setGgnSupVlmSamp34(Double ggnSupVlmSamp34)
/* 448:    */   {
/* 449:771 */     this.ggnSupVlmSamp34 = ggnSupVlmSamp34;
/* 450:    */   }
/* 451:    */   
/* 452:    */   public void setGgnSupWghSamp12(Double ggnSupWghSamp12)
/* 453:    */   {
/* 454:780 */     this.ggnSupWghSamp12 = ggnSupWghSamp12;
/* 455:    */   }
/* 456:    */   
/* 457:    */   public void setGgnSupWghSamp14(Double ggnSupWghSamp14)
/* 458:    */   {
/* 459:789 */     this.ggnSupWghSamp14 = ggnSupWghSamp14;
/* 460:    */   }
/* 461:    */   
/* 462:    */   public void setGgnSupWghSamp34(Double ggnSupWghSamp34)
/* 463:    */   {
/* 464:798 */     this.ggnSupWghSamp34 = ggnSupWghSamp34;
/* 465:    */   }
/* 466:    */   
/* 467:    */   public void setGgnTempWater(Long ggnTempWater)
/* 468:    */   {
/* 469:807 */     this.ggnTempWater = ggnTempWater;
/* 470:    */   }
/* 471:    */   
/* 472:    */   public void setGgnTimestamp(Date ggnTimestamp)
/* 473:    */   {
/* 474:816 */     this.ggnTimestamp = ggnTimestamp;
/* 475:    */   }
/* 476:    */   
/* 477:    */   public void setGgnTtlVlm(Long ggnTtlVlm)
/* 478:    */   {
/* 479:825 */     this.ggnTtlVlm = ggnTtlVlm;
/* 480:    */   }
/* 481:    */   
/* 482:    */   public void setGgnWndId(Long ggnWndId)
/* 483:    */   {
/* 484:834 */     this.ggnWndId = ggnWndId;
/* 485:    */   }
/* 486:    */   
/* 487:    */   public void setIdtAbstracLiquidGauginses(Set idtAbstracLiquidGauginses)
/* 488:    */   {
/* 489:843 */     this.idtAbstracLiquidGauginses = idtAbstracLiquidGauginses;
/* 490:    */   }
/* 491:    */   
/* 492:    */   public void setIdtUsers(IdtUsers idtUsers)
/* 493:    */   {
/* 494:861 */     this.idtUsers = idtUsers;
/* 495:    */   }
/* 496:    */ }


/* Location:           C:\Users\Luis\Desktop\CLXX\BalanceQL\Fuentes\
 * Qualified Name:     sia.bql.hibernate.sioperan.AbstractIdtGaugings
 * JD-Core Version:    0.7.0.1
 */