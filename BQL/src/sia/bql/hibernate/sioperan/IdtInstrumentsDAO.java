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
/*  12:    */ public class IdtInstrumentsDAO
/*  13:    */   extends BaseHibernateDAO
/*  14:    */ {
/*  15:    */   public static final String INS_AROP = "insArop";
/*  16:    */   public static final String INS_CODE = "insCode";
/*  17:    */   public static final String INS_DESCRIPTION = "insDescription";
/*  18:    */   public static final String INS_ESTACION_ID = "insEstacionId";
/*  19: 31 */   private static final Log log = LogFactory.getLog(IdtInstrumentsDAO.class);
/*  20:    */   
/*  21:    */   public void attachClean(IdtInstruments instance)
/*  22:    */   {
/*  23: 39 */     log.debug("attaching clean IdtInstruments instance");
/*  24:    */     try
/*  25:    */     {
/*  26: 41 */       getSession().lock(instance, LockMode.NONE);
/*  27: 42 */       log.debug("attach successful");
/*  28:    */     }
/*  29:    */     catch (RuntimeException re)
/*  30:    */     {
/*  31: 44 */       log.error("attach failed", re);
/*  32: 45 */       throw re;
/*  33:    */     }
/*  34:    */   }
/*  35:    */   
/*  36:    */   public void attachDirty(IdtInstruments instance)
/*  37:    */   {
/*  38: 55 */     log.debug("attaching dirty IdtInstruments instance");
/*  39:    */     try
/*  40:    */     {
/*  41: 57 */       getSession().saveOrUpdate(instance);
/*  42: 58 */       log.debug("attach successful");
/*  43:    */     }
/*  44:    */     catch (RuntimeException re)
/*  45:    */     {
/*  46: 60 */       log.error("attach failed", re);
/*  47: 61 */       throw re;
/*  48:    */     }
/*  49:    */   }
/*  50:    */   
/*  51:    */   public void delete(IdtInstruments persistentInstance)
/*  52:    */   {
/*  53: 71 */     log.debug("deleting IdtInstruments instance");
/*  54:    */     try
/*  55:    */     {
/*  56: 73 */       getSession().delete(persistentInstance);
/*  57: 74 */       log.debug("delete successful");
/*  58:    */     }
/*  59:    */     catch (RuntimeException re)
/*  60:    */     {
/*  61: 76 */       log.error("delete failed", re);
/*  62: 77 */       throw re;
/*  63:    */     }
/*  64:    */   }
/*  65:    */   
/*  66:    */   public List findByExample(IdtInstruments instance)
/*  67:    */   {
/*  68: 88 */     log.debug("finding IdtInstruments instance by example");
/*  69:    */     try
/*  70:    */     {
/*  71: 90 */       List results = getSession().createCriteria("sia.hibernate.IdtInstruments").add(Example.create(instance)).list();
/*  72: 91 */       log.debug("find by example successful, result size: " + results.size());
/*  73: 92 */       return results;
/*  74:    */     }
/*  75:    */     catch (RuntimeException re)
/*  76:    */     {
/*  77: 94 */       log.error("find by example failed", re);
/*  78: 95 */       throw re;
/*  79:    */     }
/*  80:    */   }
/*  81:    */   
/*  82:    */   public IdtInstruments findById(Long id)
/*  83:    */   {
/*  84:106 */     log.debug("getting IdtInstruments instance with id: " + id);
/*  85:    */     try
/*  86:    */     {
/*  87:108 */       return (IdtInstruments)getSession().get("sia.hibernate.IdtInstruments", id);
/*  88:    */     }
/*  89:    */     catch (RuntimeException re)
/*  90:    */     {
/*  91:111 */       log.error("get failed", re);
/*  92:112 */       throw re;
/*  93:    */     }
/*  94:    */   }
/*  95:    */   
/*  96:    */   public List findByInsArop(Object insArop)
/*  97:    */   {
/*  98:123 */     return findByProperty("insArop", insArop);
/*  99:    */   }
/* 100:    */   
/* 101:    */   public List findByInsCode(Object insCode)
/* 102:    */   {
/* 103:133 */     return findByProperty("insCode", insCode);
/* 104:    */   }
/* 105:    */   
/* 106:    */   public List findByInsDescription(Object insDescription)
/* 107:    */   {
/* 108:143 */     return findByProperty("insDescription", insDescription);
/* 109:    */   }
/* 110:    */   
/* 111:    */   public List findByInsEstacionId(Object insEstacionId)
/* 112:    */   {
/* 113:153 */     return findByProperty("insEstacionId", insEstacionId);
/* 114:    */   }
/* 115:    */   
/* 116:    */   public List findByProperty(String propertyName, Object value)
/* 117:    */   {
/* 118:165 */     log.debug("finding IdtInstruments instance with property: " + propertyName + ", value: " + value);
/* 119:    */     try
/* 120:    */     {
/* 121:167 */       String queryString = "from IdtInstruments as model where model." + propertyName + "= ?";
/* 122:168 */       Query queryObject = getSession().createQuery(queryString);
/* 123:169 */       queryObject.setParameter(0, value);
/* 124:170 */       return queryObject.list();
/* 125:    */     }
/* 126:    */     catch (RuntimeException re)
/* 127:    */     {
/* 128:172 */       log.error("find by property name failed", re);
/* 129:173 */       throw re;
/* 130:    */     }
/* 131:    */   }
/* 132:    */   
/* 133:    */   public IdtInstruments merge(IdtInstruments detachedInstance)
/* 134:    */   {
/* 135:184 */     log.debug("merging IdtInstruments instance");
/* 136:    */     try
/* 137:    */     {
/* 138:186 */       IdtInstruments result = (IdtInstruments)getSession().merge(detachedInstance);
/* 139:187 */       log.debug("merge successful");
/* 140:188 */       return result;
/* 141:    */     }
/* 142:    */     catch (RuntimeException re)
/* 143:    */     {
/* 144:190 */       log.error("merge failed", re);
/* 145:191 */       throw re;
/* 146:    */     }
/* 147:    */   }
/* 148:    */   
/* 149:    */   public void save(IdtInstruments transientInstance)
/* 150:    */   {
/* 151:201 */     log.debug("saving IdtInstruments instance");
/* 152:    */     try
/* 153:    */     {
/* 154:203 */       getSession().save(transientInstance);
/* 155:204 */       log.debug("save successful");
/* 156:    */     }
/* 157:    */     catch (RuntimeException re)
/* 158:    */     {
/* 159:206 */       log.error("save failed", re);
/* 160:207 */       throw re;
/* 161:    */     }
/* 162:    */   }
/* 163:    */ }


/* Location:           C:\Users\Luis\Desktop\CLXX\BalanceQL\Fuentes\
 * Qualified Name:     sia.bql.hibernate.sioperan.IdtInstrumentsDAO
 * JD-Core Version:    0.7.0.1
 */