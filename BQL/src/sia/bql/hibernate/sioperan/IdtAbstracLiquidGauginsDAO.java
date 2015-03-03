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
/*  12:    */ public class IdtAbstracLiquidGauginsDAO
/*  13:    */   extends BaseHibernateDAO
/*  14:    */ {
/*  15:    */   public static final String ABLQ_ARA_TTL = "ablqAraTtl";
/*  16:    */   public static final String ABLQ_CDL_TTL = "ablqCdlTtl";
/*  17:    */   public static final String ABLQ_DEP_AVG = "ablqDepAvg";
/*  18:    */   public static final String ABLQ_FCT_GMT = "ablqFctGmt";
/*  19:    */   public static final String ABLQ_FCT_HYD = "ablqFctHyd";
/*  20:    */   public static final String ABLQ_FMTP_CODE_MDT = "ablqFmtpCodeMdt";
/*  21:    */   public static final String ABLQ_FMTP_FML_CODE_MDT = "ablqFmtpFmlCodeMdt";
/*  22:    */   public static final String ABLQ_LVL_AVG = "ablqLvlAvg";
/*  23:    */   public static final String ABLQ_PRM_WET = "ablqPrmWet";
/*  24:    */   public static final String ABLQ_RDO_HYD = "ablqRdoHyd";
/*  25:    */   public static final String ABLQ_SPD_AVG = "ablqSpdAvg";
/*  26:    */   public static final String ABLQ_TTL_WDT = "ablqTtlWdt";
/*  27:    */   public static final String ABLQ_USER_ID = "ablqUserId";
/*  28: 24 */   private static final Log log = LogFactory.getLog(IdtAbstracLiquidGauginsDAO.class);
/*  29:    */   
/*  30:    */   public void attachClean(IdtAbstracLiquidGaugins instance)
/*  31:    */   {
/*  32: 26 */     log.debug("attaching clean IdtAbstracLiquidGaugins instance");
/*  33:    */     try
/*  34:    */     {
/*  35: 28 */       getSession().lock(instance, LockMode.NONE);
/*  36: 29 */       log.debug("attach successful");
/*  37:    */     }
/*  38:    */     catch (RuntimeException re)
/*  39:    */     {
/*  40: 31 */       log.error("attach failed", re);
/*  41: 32 */       throw re;
/*  42:    */     }
/*  43:    */   }
/*  44:    */   
/*  45:    */   public void attachDirty(IdtAbstracLiquidGaugins instance)
/*  46:    */   {
/*  47: 36 */     log.debug("attaching dirty IdtAbstracLiquidGaugins instance");
/*  48:    */     try
/*  49:    */     {
/*  50: 38 */       getSession().saveOrUpdate(instance);
/*  51: 39 */       log.debug("attach successful");
/*  52:    */     }
/*  53:    */     catch (RuntimeException re)
/*  54:    */     {
/*  55: 41 */       log.error("attach failed", re);
/*  56: 42 */       throw re;
/*  57:    */     }
/*  58:    */   }
/*  59:    */   
/*  60:    */   public void delete(IdtAbstracLiquidGaugins persistentInstance)
/*  61:    */   {
/*  62: 46 */     log.debug("deleting IdtAbstracLiquidGaugins instance");
/*  63:    */     try
/*  64:    */     {
/*  65: 48 */       getSession().delete(persistentInstance);
/*  66: 49 */       log.debug("delete successful");
/*  67:    */     }
/*  68:    */     catch (RuntimeException re)
/*  69:    */     {
/*  70: 51 */       log.error("delete failed", re);
/*  71: 52 */       throw re;
/*  72:    */     }
/*  73:    */   }
/*  74:    */   
/*  75:    */   public List findByAblqAraTtl(Object ablqAraTtl)
/*  76:    */   {
/*  77: 56 */     return findByProperty("ablqAraTtl", ablqAraTtl);
/*  78:    */   }
/*  79:    */   
/*  80:    */   public List findByAblqCdlTtl(Object ablqCdlTtl)
/*  81:    */   {
/*  82: 59 */     return findByProperty("ablqCdlTtl", ablqCdlTtl);
/*  83:    */   }
/*  84:    */   
/*  85:    */   public List findByAblqDepAvg(Object ablqDepAvg)
/*  86:    */   {
/*  87: 62 */     return findByProperty("ablqDepAvg", ablqDepAvg);
/*  88:    */   }
/*  89:    */   
/*  90:    */   public List findByAblqFctGmt(Object ablqFctGmt)
/*  91:    */   {
/*  92: 65 */     return findByProperty("ablqFctGmt", ablqFctGmt);
/*  93:    */   }
/*  94:    */   
/*  95:    */   public List findByAblqFctHyd(Object ablqFctHyd)
/*  96:    */   {
/*  97: 68 */     return findByProperty("ablqFctHyd", ablqFctHyd);
/*  98:    */   }
/*  99:    */   
/* 100:    */   public List findByAblqFmtpCodeMdt(Object ablqFmtpCodeMdt)
/* 101:    */   {
/* 102: 71 */     return findByProperty("ablqFmtpCodeMdt", ablqFmtpCodeMdt);
/* 103:    */   }
/* 104:    */   
/* 105:    */   public List findByAblqFmtpFmlCodeMdt(Object ablqFmtpFmlCodeMdt)
/* 106:    */   {
/* 107: 74 */     return findByProperty("ablqFmtpFmlCodeMdt", ablqFmtpFmlCodeMdt);
/* 108:    */   }
/* 109:    */   
/* 110:    */   public List findByAblqLvlAvg(Object ablqLvlAvg)
/* 111:    */   {
/* 112: 77 */     return findByProperty("ablqLvlAvg", ablqLvlAvg);
/* 113:    */   }
/* 114:    */   
/* 115:    */   public List findByAblqPrmWet(Object ablqPrmWet)
/* 116:    */   {
/* 117: 80 */     return findByProperty("ablqPrmWet", ablqPrmWet);
/* 118:    */   }
/* 119:    */   
/* 120:    */   public List findByAblqRdoHyd(Object ablqRdoHyd)
/* 121:    */   {
/* 122: 83 */     return findByProperty("ablqRdoHyd", ablqRdoHyd);
/* 123:    */   }
/* 124:    */   
/* 125:    */   public List findByAblqSpdAvg(Object ablqSpdAvg)
/* 126:    */   {
/* 127: 86 */     return findByProperty("ablqSpdAvg", ablqSpdAvg);
/* 128:    */   }
/* 129:    */   
/* 130:    */   public List findByAblqTtlWdt(Object ablqTtlWdt)
/* 131:    */   {
/* 132: 89 */     return findByProperty("ablqTtlWdt", ablqTtlWdt);
/* 133:    */   }
/* 134:    */   
/* 135:    */   public List findByAblqUserId(Object ablqUserId)
/* 136:    */   {
/* 137: 92 */     return findByProperty("ablqUserId", ablqUserId);
/* 138:    */   }
/* 139:    */   
/* 140:    */   public List findByExample(IdtAbstracLiquidGaugins instance)
/* 141:    */   {
/* 142: 95 */     log.debug("finding IdtAbstracLiquidGaugins instance by example");
/* 143:    */     try
/* 144:    */     {
/* 145: 97 */       List results = getSession().createCriteria("sia.hibernate.IdtAbstracLiquidGaugins").add(Example.create(instance)).list();
/* 146: 98 */       log.debug("find by example successful, result size: " + results.size());
/* 147: 99 */       return results;
/* 148:    */     }
/* 149:    */     catch (RuntimeException re)
/* 150:    */     {
/* 151:101 */       log.error("find by example failed", re);
/* 152:102 */       throw re;
/* 153:    */     }
/* 154:    */   }
/* 155:    */   
/* 156:    */   public IdtAbstracLiquidGaugins findById(Long id)
/* 157:    */   {
/* 158:106 */     log.debug("getting IdtAbstracLiquidGaugins instance with id: " + id);
/* 159:    */     try
/* 160:    */     {
/* 161:108 */       return (IdtAbstracLiquidGaugins)getSession().get("sia.hibernate.IdtAbstracLiquidGaugins", id);
/* 162:    */     }
/* 163:    */     catch (RuntimeException re)
/* 164:    */     {
/* 165:111 */       log.error("get failed", re);
/* 166:112 */       throw re;
/* 167:    */     }
/* 168:    */   }
/* 169:    */   
/* 170:    */   public List findByProperty(String propertyName, Object value)
/* 171:    */   {
/* 172:116 */     log.debug("finding IdtAbstracLiquidGaugins instance with property: " + propertyName + ", value: " + value);
/* 173:    */     try
/* 174:    */     {
/* 175:118 */       String queryString = "from IdtAbstracLiquidGaugins as model where model." + propertyName + "= ?";
/* 176:119 */       Query queryObject = getSession().createQuery(queryString);
/* 177:120 */       queryObject.setParameter(0, value);
/* 178:121 */       return queryObject.list();
/* 179:    */     }
/* 180:    */     catch (RuntimeException re)
/* 181:    */     {
/* 182:123 */       log.error("find by property name failed", re);
/* 183:124 */       throw re;
/* 184:    */     }
/* 185:    */   }
/* 186:    */   
/* 187:    */   public IdtAbstracLiquidGaugins merge(IdtAbstracLiquidGaugins detachedInstance)
/* 188:    */   {
/* 189:128 */     log.debug("merging IdtAbstracLiquidGaugins instance");
/* 190:    */     try
/* 191:    */     {
/* 192:130 */       IdtAbstracLiquidGaugins result = (IdtAbstracLiquidGaugins)getSession().merge(detachedInstance);
/* 193:131 */       log.debug("merge successful");
/* 194:132 */       return result;
/* 195:    */     }
/* 196:    */     catch (RuntimeException re)
/* 197:    */     {
/* 198:134 */       log.error("merge failed", re);
/* 199:135 */       throw re;
/* 200:    */     }
/* 201:    */   }
/* 202:    */   
/* 203:    */   public void save(IdtAbstracLiquidGaugins transientInstance)
/* 204:    */   {
/* 205:139 */     log.debug("saving IdtAbstracLiquidGaugins instance");
/* 206:    */     try
/* 207:    */     {
/* 208:141 */       getSession().save(transientInstance);
/* 209:142 */       log.debug("save successful");
/* 210:    */     }
/* 211:    */     catch (RuntimeException re)
/* 212:    */     {
/* 213:144 */       log.error("save failed", re);
/* 214:145 */       throw re;
/* 215:    */     }
/* 216:    */   }
/* 217:    */ }


/* Location:           C:\Users\Luis\Desktop\CLXX\BalanceQL\Fuentes\
 * Qualified Name:     sia.bql.hibernate.sioperan.IdtAbstracLiquidGauginsDAO
 * JD-Core Version:    0.7.0.1
 */