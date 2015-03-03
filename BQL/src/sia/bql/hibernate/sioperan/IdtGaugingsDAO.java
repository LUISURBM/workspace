/*   1:    */ package sia.bql.hibernate.sioperan;
/*   2:    */ 
/*   3:    */ import java.util.List;
/*   4:    */ import org.apache.commons.logging.Log;
/*   5:    */ import org.apache.commons.logging.LogFactory;
/*   6:    */ import org.hibernate.Criteria;
/*   7:    */ import org.hibernate.LockMode;
/*   8:    */ import org.hibernate.Query;
/*   9:    */ import org.hibernate.Session;
/*  10:    */ import org.hibernate.criterion.Example;
/*  11:    */ 
/*  12:    */ public class IdtGaugingsDAO
/*  13:    */   extends BaseHibernateDAO
/*  14:    */ {
/*  15:    */   public static final String GGN_CONVERSION_FACTOR = "ggnConversionFactor";
/*  16:    */   public static final String GGN_DIAMETER_FUZE = "ggnDiameterFuze";
/*  17:    */   public static final String GGN_EQUIPO = "ggnEquipo";
/*  18:    */   public static final String GGN_FINAL_LEVEL = "ggnFinalLevel";
/*  19:    */   public static final String GGN_FML_CODE = "ggnFmlCode";
/*  20:    */   public static final String GGN_FML_CODE_METHOD = "ggnFmlCodeMethod";
/*  21:    */   public static final String GGN_FML_FMTP_CODE = "ggnFmlFmtpCode";
/*  22:    */   public static final String GGN_FML_FMTP_CODE_METHOD = "ggnFmlFmtpCodeMethod";
/*  23:    */   public static final String GGN_FML_TYP_CODE = "ggnFmlTypCode";
/*  24:    */   public static final String GGN_FML_TYP_FMTP_CODE = "ggnFmlTypFmtpCode";
/*  25:    */   public static final String GGN_INITIAL_BORDER = "ggnInitialBorder";
/*  26:    */   public static final String GGN_INITIAL_LEVEL = "ggnInitialLevel";
/*  27:    */   public static final String GGN_INS_ID = "ggnInsId";
/*  28:    */   public static final String GGN_INSPECTOR = "ggnInspector";
/*  29:    */   public static final String GGN_LAG_ANGLE_EXISTS = "ggnLagAngleExists";
/*  30:    */   public static final String GGN_OBSERVATIONS = "ggnObservations";
/*  31:    */   public static final String GGN_PILOT_EXISTS = "ggnPilotExists";
/*  32:    */   public static final String GGN_SECTIONS = "ggnSections";
/*  33:    */   public static final String GGN_STT_CODE = "ggnSttCode";
/*  34:    */   public static final String GGN_SUP_CRC_SAMP12 = "ggnSupCrcSamp12";
/*  35:    */   public static final String GGN_SUP_CRC_SAMP14 = "ggnSupCrcSamp14";
/*  36:    */   public static final String GGN_SUP_CRC_SAMP34 = "ggnSupCrcSamp34";
/*  37:    */   public static final String GGN_SUP_NMR_SAMP12 = "ggnSupNmrSamp12";
/*  38:    */   public static final String GGN_SUP_NMR_SAMP14 = "ggnSupNmrSamp14";
/*  39:    */   public static final String GGN_SUP_NMR_SAMP34 = "ggnSupNmrSamp34";
/*  40:    */   public static final String GGN_SUP_TAR_SAMP12 = "ggnSupTarSamp12";
/*  41:    */   public static final String GGN_SUP_TAR_SAMP14 = "ggnSupTarSamp14";
/*  42:    */   public static final String GGN_SUP_TAR_SAMP34 = "ggnSupTarSamp34";
/*  43:    */   public static final String GGN_SUP_VLM_SAMP12 = "ggnSupVlmSamp12";
/*  44:    */   public static final String GGN_SUP_VLM_SAMP14 = "ggnSupVlmSamp14";
/*  45:    */   public static final String GGN_SUP_VLM_SAMP34 = "ggnSupVlmSamp34";
/*  46:    */   public static final String GGN_SUP_WGH_SAMP12 = "ggnSupWghSamp12";
/*  47:    */   public static final String GGN_SUP_WGH_SAMP14 = "ggnSupWghSamp14";
/*  48:    */   public static final String GGN_SUP_WGH_SAMP34 = "ggnSupWghSamp34";
/*  49:    */   public static final String GGN_TEMP_WATER = "ggnTempWater";
/*  50:    */   public static final String GGN_TTL_VLM = "ggnTtlVlm";
/*  51:    */   public static final String GGN_USR_ID = "ggnUsrId";
/*  52:    */   public static final String GGN_WND_ID = "ggnWndId";
/*  53: 99 */   private static final Log log = LogFactory.getLog(IdtGaugingsDAO.class);
/*  54:    */   
/*  55:    */   public void attachClean(IdtGaugings instance)
/*  56:    */   {
/*  57:107 */     log.debug("attaching clean IdtGaugings instance");
/*  58:    */     try
/*  59:    */     {
/*  60:109 */       getSession().lock(instance, LockMode.NONE);
/*  61:110 */       log.debug("attach successful");
/*  62:    */     }
/*  63:    */     catch (RuntimeException re)
/*  64:    */     {
/*  65:112 */       log.error("attach failed", re);
/*  66:113 */       throw re;
/*  67:    */     }
/*  68:    */   }
/*  69:    */   
/*  70:    */   public void attachDirty(IdtGaugings instance)
/*  71:    */   {
/*  72:123 */     log.debug("attaching dirty IdtGaugings instance");
/*  73:    */     try
/*  74:    */     {
/*  75:125 */       getSession().saveOrUpdate(instance);
/*  76:126 */       log.debug("attach successful");
/*  77:    */     }
/*  78:    */     catch (RuntimeException re)
/*  79:    */     {
/*  80:128 */       log.error("attach failed", re);
/*  81:129 */       throw re;
/*  82:    */     }
/*  83:    */   }
/*  84:    */   
/*  85:    */   public void delete(IdtGaugings persistentInstance)
/*  86:    */   {
/*  87:139 */     log.debug("deleting IdtGaugings instance");
/*  88:    */     try
/*  89:    */     {
/*  90:141 */       getSession().delete(persistentInstance);
/*  91:142 */       log.debug("delete successful");
/*  92:    */     }
/*  93:    */     catch (RuntimeException re)
/*  94:    */     {
/*  95:144 */       log.error("delete failed", re);
/*  96:145 */       throw re;
/*  97:    */     }
/*  98:    */   }
/*  99:    */   
/* 100:    */   public List findByExample(IdtGaugings instance)
/* 101:    */   {
/* 102:156 */     log.debug("finding IdtGaugings instance by example");
/* 103:    */     try
/* 104:    */     {
/* 105:158 */       List results = getSession().createCriteria("sia.hibernate.IdtGaugings").add(Example.create(instance)).list();
/* 106:159 */       log.debug("find by example successful, result size: " + results.size());
/* 107:160 */       return results;
/* 108:    */     }
/* 109:    */     catch (RuntimeException re)
/* 110:    */     {
/* 111:162 */       log.error("find by example failed", re);
/* 112:163 */       throw re;
/* 113:    */     }
/* 114:    */   }
/* 115:    */   
/* 116:    */   public List findByGgnConversionFactor(Object ggnConversionFactor)
/* 117:    */   {
/* 118:174 */     return findByProperty("ggnConversionFactor", ggnConversionFactor);
/* 119:    */   }
/* 120:    */   
/* 121:    */   public List findByGgnDiameterFuze(Object ggnDiameterFuze)
/* 122:    */   {
/* 123:184 */     return findByProperty("ggnDiameterFuze", ggnDiameterFuze);
/* 124:    */   }
/* 125:    */   
/* 126:    */   public List findByGgnEquipo(Object ggnEquipo)
/* 127:    */   {
/* 128:194 */     return findByProperty("ggnEquipo", ggnEquipo);
/* 129:    */   }
/* 130:    */   
/* 131:    */   public List findByGgnFinalLevel(Object ggnFinalLevel)
/* 132:    */   {
/* 133:204 */     return findByProperty("ggnFinalLevel", ggnFinalLevel);
/* 134:    */   }
/* 135:    */   
/* 136:    */   public List findByGgnFmlCode(Object ggnFmlCode)
/* 137:    */   {
/* 138:214 */     return findByProperty("ggnFmlCode", ggnFmlCode);
/* 139:    */   }
/* 140:    */   
/* 141:    */   public List findByGgnFmlCodeMethod(Object ggnFmlCodeMethod)
/* 142:    */   {
/* 143:224 */     return findByProperty("ggnFmlCodeMethod", ggnFmlCodeMethod);
/* 144:    */   }
/* 145:    */   
/* 146:    */   public List findByGgnFmlFmtpCode(Object ggnFmlFmtpCode)
/* 147:    */   {
/* 148:234 */     return findByProperty("ggnFmlFmtpCode", ggnFmlFmtpCode);
/* 149:    */   }
/* 150:    */   
/* 151:    */   public List findByGgnFmlFmtpCodeMethod(Object ggnFmlFmtpCodeMethod)
/* 152:    */   {
/* 153:244 */     return findByProperty("ggnFmlFmtpCodeMethod", ggnFmlFmtpCodeMethod);
/* 154:    */   }
/* 155:    */   
/* 156:    */   public List findByGgnFmlTypCode(Object ggnFmlTypCode)
/* 157:    */   {
/* 158:254 */     return findByProperty("ggnFmlTypCode", ggnFmlTypCode);
/* 159:    */   }
/* 160:    */   
/* 161:    */   public List findByGgnFmlTypFmtpCode(Object ggnFmlTypFmtpCode)
/* 162:    */   {
/* 163:264 */     return findByProperty("ggnFmlTypFmtpCode", ggnFmlTypFmtpCode);
/* 164:    */   }
/* 165:    */   
/* 166:    */   public List findByGgnInitialBorder(Object ggnInitialBorder)
/* 167:    */   {
/* 168:274 */     return findByProperty("ggnInitialBorder", ggnInitialBorder);
/* 169:    */   }
/* 170:    */   
/* 171:    */   public List findByGgnInitialLevel(Object ggnInitialLevel)
/* 172:    */   {
/* 173:284 */     return findByProperty("ggnInitialLevel", ggnInitialLevel);
/* 174:    */   }
/* 175:    */   
/* 176:    */   public List findByGgnInsId(Object ggnInsId)
/* 177:    */   {
/* 178:294 */     return findByProperty("ggnInsId", ggnInsId);
/* 179:    */   }
/* 180:    */   
/* 181:    */   public List findByGgnInspector(Object ggnInspector)
/* 182:    */   {
/* 183:304 */     return findByProperty("ggnInspector", ggnInspector);
/* 184:    */   }
/* 185:    */   
/* 186:    */   public List findByGgnLagAngleExists(Object ggnLagAngleExists)
/* 187:    */   {
/* 188:314 */     return findByProperty("ggnLagAngleExists", ggnLagAngleExists);
/* 189:    */   }
/* 190:    */   
/* 191:    */   public List findByGgnObservations(Object ggnObservations)
/* 192:    */   {
/* 193:324 */     return findByProperty("ggnObservations", ggnObservations);
/* 194:    */   }
/* 195:    */   
/* 196:    */   public List findByGgnPilotExists(Object ggnPilotExists)
/* 197:    */   {
/* 198:334 */     return findByProperty("ggnPilotExists", ggnPilotExists);
/* 199:    */   }
/* 200:    */   
/* 201:    */   public List findByGgnSections(Object ggnSections)
/* 202:    */   {
/* 203:344 */     return findByProperty("ggnSections", ggnSections);
/* 204:    */   }
/* 205:    */   
/* 206:    */   public List findByGgnSttCode(Object ggnSttCode)
/* 207:    */   {
/* 208:354 */     return findByProperty("ggnSttCode", ggnSttCode);
/* 209:    */   }
/* 210:    */   
/* 211:    */   public List findByGgnSupCrcSamp12(Object ggnSupCrcSamp12)
/* 212:    */   {
/* 213:364 */     return findByProperty("ggnSupCrcSamp12", ggnSupCrcSamp12);
/* 214:    */   }
/* 215:    */   
/* 216:    */   public List findByGgnSupCrcSamp14(Object ggnSupCrcSamp14)
/* 217:    */   {
/* 218:374 */     return findByProperty("ggnSupCrcSamp14", ggnSupCrcSamp14);
/* 219:    */   }
/* 220:    */   
/* 221:    */   public List findByGgnSupCrcSamp34(Object ggnSupCrcSamp34)
/* 222:    */   {
/* 223:384 */     return findByProperty("ggnSupCrcSamp34", ggnSupCrcSamp34);
/* 224:    */   }
/* 225:    */   
/* 226:    */   public List findByGgnSupNmrSamp12(Object ggnSupNmrSamp12)
/* 227:    */   {
/* 228:394 */     return findByProperty("ggnSupNmrSamp12", ggnSupNmrSamp12);
/* 229:    */   }
/* 230:    */   
/* 231:    */   public List findByGgnSupNmrSamp14(Object ggnSupNmrSamp14)
/* 232:    */   {
/* 233:404 */     return findByProperty("ggnSupNmrSamp14", ggnSupNmrSamp14);
/* 234:    */   }
/* 235:    */   
/* 236:    */   public List findByGgnSupNmrSamp34(Object ggnSupNmrSamp34)
/* 237:    */   {
/* 238:414 */     return findByProperty("ggnSupNmrSamp34", ggnSupNmrSamp34);
/* 239:    */   }
/* 240:    */   
/* 241:    */   public List findByGgnSupTarSamp12(Object ggnSupTarSamp12)
/* 242:    */   {
/* 243:424 */     return findByProperty("ggnSupTarSamp12", ggnSupTarSamp12);
/* 244:    */   }
/* 245:    */   
/* 246:    */   public List findByGgnSupTarSamp14(Object ggnSupTarSamp14)
/* 247:    */   {
/* 248:434 */     return findByProperty("ggnSupTarSamp14", ggnSupTarSamp14);
/* 249:    */   }
/* 250:    */   
/* 251:    */   public List findByGgnSupTarSamp34(Object ggnSupTarSamp34)
/* 252:    */   {
/* 253:444 */     return findByProperty("ggnSupTarSamp34", ggnSupTarSamp34);
/* 254:    */   }
/* 255:    */   
/* 256:    */   public List findByGgnSupVlmSamp12(Object ggnSupVlmSamp12)
/* 257:    */   {
/* 258:454 */     return findByProperty("ggnSupVlmSamp12", ggnSupVlmSamp12);
/* 259:    */   }
/* 260:    */   
/* 261:    */   public List findByGgnSupVlmSamp14(Object ggnSupVlmSamp14)
/* 262:    */   {
/* 263:464 */     return findByProperty("ggnSupVlmSamp14", ggnSupVlmSamp14);
/* 264:    */   }
/* 265:    */   
/* 266:    */   public List findByGgnSupVlmSamp34(Object ggnSupVlmSamp34)
/* 267:    */   {
/* 268:474 */     return findByProperty("ggnSupVlmSamp34", ggnSupVlmSamp34);
/* 269:    */   }
/* 270:    */   
/* 271:    */   public List findByGgnSupWghSamp12(Object ggnSupWghSamp12)
/* 272:    */   {
/* 273:484 */     return findByProperty("ggnSupWghSamp12", ggnSupWghSamp12);
/* 274:    */   }
/* 275:    */   
/* 276:    */   public List findByGgnSupWghSamp14(Object ggnSupWghSamp14)
/* 277:    */   {
/* 278:494 */     return findByProperty("ggnSupWghSamp14", ggnSupWghSamp14);
/* 279:    */   }
/* 280:    */   
/* 281:    */   public List findByGgnSupWghSamp34(Object ggnSupWghSamp34)
/* 282:    */   {
/* 283:504 */     return findByProperty("ggnSupWghSamp34", ggnSupWghSamp34);
/* 284:    */   }
/* 285:    */   
/* 286:    */   public List findByGgnTempWater(Object ggnTempWater)
/* 287:    */   {
/* 288:514 */     return findByProperty("ggnTempWater", ggnTempWater);
/* 289:    */   }
/* 290:    */   
/* 291:    */   public List findByGgnTtlVlm(Object ggnTtlVlm)
/* 292:    */   {
/* 293:524 */     return findByProperty("ggnTtlVlm", ggnTtlVlm);
/* 294:    */   }
/* 295:    */   
/* 296:    */   public List findByGgnUsrId(Object ggnUsrId)
/* 297:    */   {
/* 298:534 */     return findByProperty("ggnUsrId", ggnUsrId);
/* 299:    */   }
/* 300:    */   
/* 301:    */   public List findByGgnWndId(Object ggnWndId)
/* 302:    */   {
/* 303:544 */     return findByProperty("ggnWndId", ggnWndId);
/* 304:    */   }
/* 305:    */   
/* 306:    */   public IdtGaugings findById(Long id)
/* 307:    */   {
/* 308:554 */     log.debug("getting IdtGaugings instance with id: " + id);
/* 309:    */     try
/* 310:    */     {
/* 311:556 */       return (IdtGaugings)getSession().get("sia.hibernate.IdtGaugings", id);
/* 312:    */     }
/* 313:    */     catch (RuntimeException re)
/* 314:    */     {
/* 315:559 */       log.error("get failed", re);
/* 316:560 */       throw re;
/* 317:    */     }
/* 318:    */   }
/* 319:    */   
/* 320:    */   public List findByProperty(String propertyName, Object value)
/* 321:    */   {
/* 322:573 */     log.debug("finding IdtGaugings instance with property: " + propertyName + ", value: " + value);
/* 323:    */     try
/* 324:    */     {
/* 325:575 */       String queryString = "from IdtGaugings as model where model." + propertyName + "= ?";
/* 326:576 */       Query queryObject = getSession().createQuery(queryString);
/* 327:577 */       queryObject.setParameter(0, value);
/* 328:578 */       return queryObject.list();
/* 329:    */     }
/* 330:    */     catch (RuntimeException re)
/* 331:    */     {
/* 332:580 */       log.error("find by property name failed", re);
/* 333:581 */       throw re;
/* 334:    */     }
/* 335:    */   }
/* 336:    */   
/* 337:    */   public IdtGaugings merge(IdtGaugings detachedInstance)
/* 338:    */   {
/* 339:592 */     log.debug("merging IdtGaugings instance");
/* 340:    */     try
/* 341:    */     {
/* 342:594 */       IdtGaugings result = (IdtGaugings)getSession().merge(detachedInstance);
/* 343:595 */       log.debug("merge successful");
/* 344:596 */       return result;
/* 345:    */     }
/* 346:    */     catch (RuntimeException re)
/* 347:    */     {
/* 348:598 */       log.error("merge failed", re);
/* 349:599 */       throw re;
/* 350:    */     }
/* 351:    */   }
/* 352:    */   
/* 353:    */   public void save(IdtGaugings transientInstance)
/* 354:    */   {
/* 355:609 */     log.debug("saving IdtGaugings instance");
/* 356:    */     try
/* 357:    */     {
/* 358:611 */       getSession().save(transientInstance);
/* 359:612 */       log.debug("save successful");
/* 360:    */     }
/* 361:    */     catch (RuntimeException re)
/* 362:    */     {
/* 363:614 */       log.error("save failed", re);
/* 364:615 */       throw re;
/* 365:    */     }
/* 366:    */   }
/* 367:    */ }


/* Location:           C:\Users\Luis\Desktop\CLXX\BalanceQL\Fuentes\
 * Qualified Name:     sia.bql.hibernate.sioperan.IdtGaugingsDAO
 * JD-Core Version:    0.7.0.1
 */