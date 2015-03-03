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
/*  12:    */ public class IdtAbstracSolidGauginsDAO
/*  13:    */   extends BaseHibernateDAO
/*  14:    */ {
/*  15:    */   public static final String ABSL_CDL_LQD = "abslCdlLqd";
/*  16:    */   public static final String ABSL_CNC_SPR = "abslCncSpr";
/*  17:    */   public static final String ABSL_CNT_AVG = "abslCntAvg";
/*  18:    */   public static final String ABSL_LVL_AVG = "abslLvlAvg";
/*  19:    */   public static final String ABSL_SPN_SLD_TTL = "abslSpnSldTtl";
/*  20:    */   public static final String ABSL_USER_ID = "abslUserId";
/*  21: 35 */   private static final Log log = LogFactory.getLog(IdtAbstracSolidGauginsDAO.class);
/*  22:    */   
/*  23:    */   public void attachClean(IdtAbstracSolidGaugins instance)
/*  24:    */   {
/*  25: 43 */     log.debug("attaching clean IdtAbstracSolidGaugins instance");
/*  26:    */     try
/*  27:    */     {
/*  28: 45 */       getSession().lock(instance, LockMode.NONE);
/*  29: 46 */       log.debug("attach successful");
/*  30:    */     }
/*  31:    */     catch (RuntimeException re)
/*  32:    */     {
/*  33: 48 */       log.error("attach failed", re);
/*  34: 49 */       throw re;
/*  35:    */     }
/*  36:    */   }
/*  37:    */   
/*  38:    */   public void attachDirty(IdtAbstracSolidGaugins instance)
/*  39:    */   {
/*  40: 59 */     log.debug("attaching dirty IdtAbstracSolidGaugins instance");
/*  41:    */     try
/*  42:    */     {
/*  43: 61 */       getSession().saveOrUpdate(instance);
/*  44: 62 */       log.debug("attach successful");
/*  45:    */     }
/*  46:    */     catch (RuntimeException re)
/*  47:    */     {
/*  48: 64 */       log.error("attach failed", re);
/*  49: 65 */       throw re;
/*  50:    */     }
/*  51:    */   }
/*  52:    */   
/*  53:    */   public void delete(IdtAbstracSolidGaugins persistentInstance)
/*  54:    */   {
/*  55: 75 */     log.debug("deleting IdtAbstracSolidGaugins instance");
/*  56:    */     try
/*  57:    */     {
/*  58: 77 */       getSession().delete(persistentInstance);
/*  59: 78 */       log.debug("delete successful");
/*  60:    */     }
/*  61:    */     catch (RuntimeException re)
/*  62:    */     {
/*  63: 80 */       log.error("delete failed", re);
/*  64: 81 */       throw re;
/*  65:    */     }
/*  66:    */   }
/*  67:    */   
/*  68:    */   public List findByAbslCdlLqd(Object abslCdlLqd)
/*  69:    */   {
/*  70: 92 */     return findByProperty("abslCdlLqd", abslCdlLqd);
/*  71:    */   }
/*  72:    */   
/*  73:    */   public List findByAbslCncSpr(Object abslCncSpr)
/*  74:    */   {
/*  75:102 */     return findByProperty("abslCncSpr", abslCncSpr);
/*  76:    */   }
/*  77:    */   
/*  78:    */   public List findByAbslCntAvg(Object abslCntAvg)
/*  79:    */   {
/*  80:112 */     return findByProperty("abslCntAvg", abslCntAvg);
/*  81:    */   }
/*  82:    */   
/*  83:    */   public List findByAbslLvlAvg(Object abslLvlAvg)
/*  84:    */   {
/*  85:122 */     return findByProperty("abslLvlAvg", abslLvlAvg);
/*  86:    */   }
/*  87:    */   
/*  88:    */   public List findByAbslSpnSldTtl(Object abslSpnSldTtl)
/*  89:    */   {
/*  90:132 */     return findByProperty("abslSpnSldTtl", abslSpnSldTtl);
/*  91:    */   }
/*  92:    */   
/*  93:    */   public List findByAbslUserId(Object abslUserId)
/*  94:    */   {
/*  95:142 */     return findByProperty("abslUserId", abslUserId);
/*  96:    */   }
/*  97:    */   
/*  98:    */   public List findByExample(IdtAbstracSolidGaugins instance)
/*  99:    */   {
/* 100:152 */     log.debug("finding IdtAbstracSolidGaugins instance by example");
/* 101:    */     try
/* 102:    */     {
/* 103:154 */       List results = getSession().createCriteria("sia.hibernate.IdtAbstracSolidGaugins").add(Example.create(instance)).list();
/* 104:155 */       log.debug("find by example successful, result size: " + results.size());
/* 105:156 */       return results;
/* 106:    */     }
/* 107:    */     catch (RuntimeException re)
/* 108:    */     {
/* 109:158 */       log.error("find by example failed", re);
/* 110:159 */       throw re;
/* 111:    */     }
/* 112:    */   }
/* 113:    */   
/* 114:    */   public IdtAbstracSolidGaugins findById(Long id)
/* 115:    */   {
/* 116:170 */     log.debug("getting IdtAbstracSolidGaugins instance with id: " + id);
/* 117:    */     try
/* 118:    */     {
/* 119:172 */       return (IdtAbstracSolidGaugins)getSession().get("com.sia.aforosolido.hibernate.IdtAbstracSolidGaugins", id);
/* 120:    */     }
/* 121:    */     catch (RuntimeException re)
/* 122:    */     {
/* 123:175 */       log.error("get failed", re);
/* 124:176 */       throw re;
/* 125:    */     }
/* 126:    */   }
/* 127:    */   
/* 128:    */   public List findByProperty(String propertyName, Object value)
/* 129:    */   {
/* 130:189 */     log.debug("finding IdtAbstracSolidGaugins instance with property: " + propertyName + ", value: " + value);
/* 131:    */     try
/* 132:    */     {
/* 133:191 */       String queryString = "from IdtAbstracSolidGaugins as model where model." + propertyName + "= ?";
/* 134:192 */       Query queryObject = getSession().createQuery(queryString);
/* 135:193 */       queryObject.setParameter(0, value);
/* 136:194 */       return queryObject.list();
/* 137:    */     }
/* 138:    */     catch (RuntimeException re)
/* 139:    */     {
/* 140:196 */       log.error("find by property name failed", re);
/* 141:197 */       throw re;
/* 142:    */     }
/* 143:    */   }
/* 144:    */   
/* 145:    */   public IdtAbstracSolidGaugins merge(IdtAbstracSolidGaugins detachedInstance)
/* 146:    */   {
/* 147:208 */     log.debug("merging IdtAbstracSolidGaugins instance");
/* 148:    */     try
/* 149:    */     {
/* 150:210 */       IdtAbstracSolidGaugins result = (IdtAbstracSolidGaugins)getSession().merge(detachedInstance);
/* 151:211 */       log.debug("merge successful");
/* 152:212 */       return result;
/* 153:    */     }
/* 154:    */     catch (RuntimeException re)
/* 155:    */     {
/* 156:214 */       log.error("merge failed", re);
/* 157:215 */       throw re;
/* 158:    */     }
/* 159:    */   }
/* 160:    */   
/* 161:    */   public void save(IdtAbstracSolidGaugins transientInstance)
/* 162:    */   {
/* 163:225 */     log.debug("saving IdtAbstracSolidGaugins instance");
/* 164:    */     try
/* 165:    */     {
/* 166:227 */       getSession().save(transientInstance);
/* 167:228 */       log.debug("save successful");
/* 168:    */     }
/* 169:    */     catch (RuntimeException re)
/* 170:    */     {
/* 171:230 */       log.error("save failed", re);
/* 172:231 */       throw re;
/* 173:    */     }
/* 174:    */   }
/* 175:    */ }


/* Location:           C:\Users\Luis\Desktop\CLXX\BalanceQL\Fuentes\
 * Qualified Name:     sia.bql.hibernate.sioperan.IdtAbstracSolidGauginsDAO
 * JD-Core Version:    0.7.0.1
 */