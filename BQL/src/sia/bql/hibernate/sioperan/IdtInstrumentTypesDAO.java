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
/*  12:    */ public class IdtInstrumentTypesDAO
/*  13:    */   extends BaseHibernateDAO
/*  14:    */ {
/*  15:    */   public static final String INTP_DESCRIPTION = "intpDescription";
/*  16:    */   public static final String INTP_NAME = "intpName";
/*  17: 16 */   private static final Log log = LogFactory.getLog(IdtInstrumentTypesDAO.class);
/*  18:    */   
/*  19:    */   public void attachClean(IdtInstrumentTypes instance)
/*  20:    */   {
/*  21: 18 */     log.debug("attaching clean IdtInstrumentTypes instance");
/*  22:    */     try
/*  23:    */     {
/*  24: 20 */       getSession().lock(instance, LockMode.NONE);
/*  25: 21 */       log.debug("attach successful");
/*  26:    */     }
/*  27:    */     catch (RuntimeException re)
/*  28:    */     {
/*  29: 23 */       log.error("attach failed", re);
/*  30: 24 */       throw re;
/*  31:    */     }
/*  32:    */   }
/*  33:    */   
/*  34:    */   public void attachDirty(IdtInstrumentTypes instance)
/*  35:    */   {
/*  36: 34 */     log.debug("attaching dirty IdtInstrumentTypes instance");
/*  37:    */     try
/*  38:    */     {
/*  39: 36 */       getSession().saveOrUpdate(instance);
/*  40: 37 */       log.debug("attach successful");
/*  41:    */     }
/*  42:    */     catch (RuntimeException re)
/*  43:    */     {
/*  44: 39 */       log.error("attach failed", re);
/*  45: 40 */       throw re;
/*  46:    */     }
/*  47:    */   }
/*  48:    */   
/*  49:    */   public void delete(IdtInstrumentTypes persistentInstance)
/*  50:    */   {
/*  51: 50 */     log.debug("deleting IdtInstrumentTypes instance");
/*  52:    */     try
/*  53:    */     {
/*  54: 52 */       getSession().delete(persistentInstance);
/*  55: 53 */       log.debug("delete successful");
/*  56:    */     }
/*  57:    */     catch (RuntimeException re)
/*  58:    */     {
/*  59: 55 */       log.error("delete failed", re);
/*  60: 56 */       throw re;
/*  61:    */     }
/*  62:    */   }
/*  63:    */   
/*  64:    */   public List findByExample(IdtInstrumentTypes instance)
/*  65:    */   {
/*  66: 67 */     log.debug("finding IdtInstrumentTypes instance by example");
/*  67:    */     try
/*  68:    */     {
/*  69: 69 */       List results = getSession().createCriteria("sia.hibernate.IdtInstrumentTypes").add(Example.create(instance)).list();
/*  70: 70 */       log.debug("find by example successful, result size: " + results.size());
/*  71: 71 */       return results;
/*  72:    */     }
/*  73:    */     catch (RuntimeException re)
/*  74:    */     {
/*  75: 73 */       log.error("find by example failed", re);
/*  76: 74 */       throw re;
/*  77:    */     }
/*  78:    */   }
/*  79:    */   
/*  80:    */   public IdtInstrumentTypes findById(Long id)
/*  81:    */   {
/*  82: 85 */     log.debug("getting IdtInstrumentTypes instance with id: " + id);
/*  83:    */     try
/*  84:    */     {
/*  85: 87 */       return (IdtInstrumentTypes)getSession().get("sia.hibernate.IdtInstrumentTypes", id);
/*  86:    */     }
/*  87:    */     catch (RuntimeException re)
/*  88:    */     {
/*  89: 90 */       log.error("get failed", re);
/*  90: 91 */       throw re;
/*  91:    */     }
/*  92:    */   }
/*  93:    */   
/*  94:    */   public List findByIntpDescription(Object intpDescription)
/*  95:    */   {
/*  96:102 */     return findByProperty("intpDescription", intpDescription);
/*  97:    */   }
/*  98:    */   
/*  99:    */   public List findByIntpName(Object intpName)
/* 100:    */   {
/* 101:112 */     return findByProperty("intpName", intpName);
/* 102:    */   }
/* 103:    */   
/* 104:    */   public List findByProperty(String propertyName, Object value)
/* 105:    */   {
/* 106:124 */     log.debug("finding IdtInstrumentTypes instance with property: " + propertyName + ", value: " + value);
/* 107:    */     try
/* 108:    */     {
/* 109:126 */       String queryString = "from IdtInstrumentTypes as model where model." + propertyName + "= ?";
/* 110:127 */       Query queryObject = getSession().createQuery(queryString);
/* 111:128 */       queryObject.setParameter(0, value);
/* 112:129 */       return queryObject.list();
/* 113:    */     }
/* 114:    */     catch (RuntimeException re)
/* 115:    */     {
/* 116:131 */       log.error("find by property name failed", re);
/* 117:132 */       throw re;
/* 118:    */     }
/* 119:    */   }
/* 120:    */   
/* 121:    */   public IdtInstrumentTypes merge(IdtInstrumentTypes detachedInstance)
/* 122:    */   {
/* 123:143 */     log.debug("merging IdtInstrumentTypes instance");
/* 124:    */     try
/* 125:    */     {
/* 126:145 */       IdtInstrumentTypes result = (IdtInstrumentTypes)getSession().merge(detachedInstance);
/* 127:146 */       log.debug("merge successful");
/* 128:147 */       return result;
/* 129:    */     }
/* 130:    */     catch (RuntimeException re)
/* 131:    */     {
/* 132:149 */       log.error("merge failed", re);
/* 133:150 */       throw re;
/* 134:    */     }
/* 135:    */   }
/* 136:    */   
/* 137:    */   public void save(IdtInstrumentTypes transientInstance)
/* 138:    */   {
/* 139:160 */     log.debug("saving IdtInstrumentTypes instance");
/* 140:    */     try
/* 141:    */     {
/* 142:162 */       getSession().save(transientInstance);
/* 143:163 */       log.debug("save successful");
/* 144:    */     }
/* 145:    */     catch (RuntimeException re)
/* 146:    */     {
/* 147:165 */       log.error("save failed", re);
/* 148:166 */       throw re;
/* 149:    */     }
/* 150:    */   }
/* 151:    */ }


/* Location:           C:\Users\Luis\Desktop\CLXX\BalanceQL\Fuentes\
 * Qualified Name:     sia.bql.hibernate.sioperan.IdtInstrumentTypesDAO
 * JD-Core Version:    0.7.0.1
 */