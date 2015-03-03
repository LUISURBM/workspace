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
/*  12:    */ public class ShmtEcuacionesNqDAO
/*  13:    */   extends BaseHibernateDAO
/*  14:    */ {
/*  15:    */   public static final String ECNQ_A = "ecnqA";
/*  16:    */   public static final String ECNQ_B = "ecnqB";
/*  17:    */   public static final String ECNQ_C = "ecnqC";
/*  18:    */   public static final String ECNQ_R = "ecnqR";
/*  19:    */   public static final String ECNQ_TIPO = "ecnqTipo";
/*  20:    */   public static final String ECNQ_USR_ID = "ecnqUsrId";
/*  21: 17 */   private static final Log log = LogFactory.getLog(ShmtEcuacionesNqDAO.class);
/*  22:    */   
/*  23:    */   public void attachClean(ShmtEcuacionesNq instance)
/*  24:    */   {
/*  25: 19 */     log.debug("attaching clean ShmtEcuacionesNq instance");
/*  26:    */     try
/*  27:    */     {
/*  28: 21 */       getSession().lock(instance, LockMode.NONE);
/*  29: 22 */       log.debug("attach successful");
/*  30:    */     }
/*  31:    */     catch (RuntimeException re)
/*  32:    */     {
/*  33: 24 */       log.error("attach failed", re);
/*  34: 25 */       throw re;
/*  35:    */     }
/*  36:    */   }
/*  37:    */   
/*  38:    */   public void attachDirty(ShmtEcuacionesNq instance)
/*  39:    */   {
/*  40: 29 */     log.debug("attaching dirty ShmtEcuacionesNq instance");
/*  41:    */     try
/*  42:    */     {
/*  43: 31 */       getSession().saveOrUpdate(instance);
/*  44: 32 */       log.debug("attach successful");
/*  45:    */     }
/*  46:    */     catch (RuntimeException re)
/*  47:    */     {
/*  48: 34 */       log.error("attach failed", re);
/*  49: 35 */       throw re;
/*  50:    */     }
/*  51:    */   }
/*  52:    */   
/*  53:    */   public void delete(ShmtEcuacionesNq persistentInstance)
/*  54:    */   {
/*  55: 39 */     log.debug("deleting ShmtEcuacionesNq instance");
/*  56:    */     try
/*  57:    */     {
/*  58: 41 */       getSession().delete(persistentInstance);
/*  59: 42 */       log.debug("delete successful");
/*  60:    */     }
/*  61:    */     catch (RuntimeException re)
/*  62:    */     {
/*  63: 44 */       log.error("delete failed", re);
/*  64: 45 */       throw re;
/*  65:    */     }
/*  66:    */   }
/*  67:    */   
/*  68:    */   public List findByEcnqA(Object ecnqA)
/*  69:    */   {
/*  70: 50 */     return findByProperty("ecnqA", ecnqA);
/*  71:    */   }
/*  72:    */   
/*  73:    */   public List findByEcnqB(Object ecnqB)
/*  74:    */   {
/*  75: 54 */     return findByProperty("ecnqB", ecnqB);
/*  76:    */   }
/*  77:    */   
/*  78:    */   public List findByEcnqC(Object ecnqC)
/*  79:    */   {
/*  80: 58 */     return findByProperty("ecnqC", ecnqC);
/*  81:    */   }
/*  82:    */   
/*  83:    */   public List findByEcnqR(Object ecnqR)
/*  84:    */   {
/*  85: 62 */     return findByProperty("ecnqR", ecnqR);
/*  86:    */   }
/*  87:    */   
/*  88:    */   public List findByEcnqTipo(Object ecnqTipo)
/*  89:    */   {
/*  90: 66 */     return findByProperty("ecnqTipo", ecnqTipo);
/*  91:    */   }
/*  92:    */   
/*  93:    */   public List findByEcnqUsrId(Object ecnqUsrId)
/*  94:    */   {
/*  95: 70 */     return findByProperty("ecnqUsrId", ecnqUsrId);
/*  96:    */   }
/*  97:    */   
/*  98:    */   public List findByExample(ShmtEcuacionesNq instance)
/*  99:    */   {
/* 100: 74 */     log.debug("finding ShmtEcuacionesNq instance by example");
/* 101:    */     try
/* 102:    */     {
/* 103: 76 */       List results = getSession().createCriteria("sia.hibernate.ShmtEcuacionesNq").add(Example.create(instance)).list();
/* 104: 77 */       log.debug("find by example successful, result size: " + results.size());
/* 105: 78 */       return results;
/* 106:    */     }
/* 107:    */     catch (RuntimeException re)
/* 108:    */     {
/* 109: 80 */       log.error("find by example failed", re);
/* 110: 81 */       throw re;
/* 111:    */     }
/* 112:    */   }
/* 113:    */   
/* 114:    */   public ShmtEcuacionesNq findById(Long id)
/* 115:    */   {
/* 116: 85 */     log.debug("getting ShmtEcuacionesNq instance with id: " + id);
/* 117:    */     try
/* 118:    */     {
/* 119: 87 */       return (ShmtEcuacionesNq)getSession().get("sia.hibernate.ShmtEcuacionesNq", id);
/* 120:    */     }
/* 121:    */     catch (RuntimeException re)
/* 122:    */     {
/* 123: 90 */       log.error("get failed", re);
/* 124: 91 */       throw re;
/* 125:    */     }
/* 126:    */   }
/* 127:    */   
/* 128:    */   public List findByProperty(String propertyName, Object value)
/* 129:    */   {
/* 130: 96 */     log.debug("finding ShmtEcuacionesNq instance with property: " + propertyName + ", value: " + value);
/* 131:    */     try
/* 132:    */     {
/* 133: 98 */       String queryString = "from ShmtEcuacionesNq as model where model." + propertyName + "= ?";
/* 134: 99 */       Query queryObject = getSession().createQuery(queryString);
/* 135:100 */       queryObject.setParameter(0, value);
/* 136:101 */       return queryObject.list();
/* 137:    */     }
/* 138:    */     catch (RuntimeException re)
/* 139:    */     {
/* 140:103 */       log.error("find by property name failed", re);
/* 141:104 */       throw re;
/* 142:    */     }
/* 143:    */   }
/* 144:    */   
/* 145:    */   public ShmtEcuacionesNq merge(ShmtEcuacionesNq detachedInstance)
/* 146:    */   {
/* 147:108 */     log.debug("merging ShmtEcuacionesNq instance");
/* 148:    */     try
/* 149:    */     {
/* 150:110 */       ShmtEcuacionesNq result = (ShmtEcuacionesNq)getSession().merge(detachedInstance);
/* 151:111 */       log.debug("merge successful");
/* 152:112 */       return result;
/* 153:    */     }
/* 154:    */     catch (RuntimeException re)
/* 155:    */     {
/* 156:114 */       log.error("merge failed", re);
/* 157:115 */       throw re;
/* 158:    */     }
/* 159:    */   }
/* 160:    */   
/* 161:    */   public void save(ShmtEcuacionesNq transientInstance)
/* 162:    */   {
/* 163:119 */     log.debug("saving ShmtEcuacionesNq instance");
/* 164:    */     try
/* 165:    */     {
/* 166:121 */       getSession().save(transientInstance);
/* 167:122 */       log.debug("save successful");
/* 168:    */     }
/* 169:    */     catch (RuntimeException re)
/* 170:    */     {
/* 171:124 */       log.error("save failed", re);
/* 172:125 */       throw re;
/* 173:    */     }
/* 174:    */   }
/* 175:    */ }


/* Location:           C:\Users\Luis\Desktop\CLXX\BalanceQL\Fuentes\
 * Qualified Name:     sia.bql.hibernate.sioperan.ShmtEcuacionesNqDAO
 * JD-Core Version:    0.7.0.1
 */