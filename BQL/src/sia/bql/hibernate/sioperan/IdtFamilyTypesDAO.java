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
/*  12:    */ public class IdtFamilyTypesDAO
/*  13:    */   extends BaseHibernateDAO
/*  14:    */ {
/*  15:    */   public static final String FMTP_DESCRIPTION = "fmtpDescription";
/*  16:    */   public static final String FMTP_NAME = "fmtpName";
/*  17: 16 */   private static final Log log = LogFactory.getLog(IdtFamilyTypesDAO.class);
/*  18:    */   
/*  19:    */   public void attachClean(IdtFamilyTypes instance)
/*  20:    */   {
/*  21: 18 */     log.debug("attaching clean IdtFamilyTypes instance");
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
/*  34:    */   public void attachDirty(IdtFamilyTypes instance)
/*  35:    */   {
/*  36: 34 */     log.debug("attaching dirty IdtFamilyTypes instance");
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
/*  49:    */   public void delete(IdtFamilyTypes persistentInstance)
/*  50:    */   {
/*  51: 50 */     log.debug("deleting IdtFamilyTypes instance");
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
/*  64:    */   public List findByExample(IdtFamilyTypes instance)
/*  65:    */   {
/*  66: 67 */     log.debug("finding IdtFamilyTypes instance by example");
/*  67:    */     try
/*  68:    */     {
/*  69: 69 */       List results = getSession().createCriteria("sia.hibernate.IdtFamilyTypes").add(Example.create(instance)).list();
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
/*  80:    */   public List findByFmtpDescription(Object fmtpDescription)
/*  81:    */   {
/*  82: 85 */     return findByProperty("fmtpDescription", fmtpDescription);
/*  83:    */   }
/*  84:    */   
/*  85:    */   public List findByFmtpName(Object fmtpName)
/*  86:    */   {
/*  87: 95 */     return findByProperty("fmtpName", fmtpName);
/*  88:    */   }
/*  89:    */   
/*  90:    */   public IdtFamilyTypes findById(String id)
/*  91:    */   {
/*  92:105 */     log.debug("getting IdtFamilyTypes instance with id: " + id);
/*  93:    */     try
/*  94:    */     {
/*  95:107 */       return (IdtFamilyTypes)getSession().get("sia.hibernate.IdtFamilyTypes", id);
/*  96:    */     }
/*  97:    */     catch (RuntimeException re)
/*  98:    */     {
/*  99:110 */       log.error("get failed", re);
/* 100:111 */       throw re;
/* 101:    */     }
/* 102:    */   }
/* 103:    */   
/* 104:    */   public List findByProperty(String propertyName, Object value)
/* 105:    */   {
/* 106:124 */     log.debug("finding IdtFamilyTypes instance with property: " + propertyName + ", value: " + value);
/* 107:    */     try
/* 108:    */     {
/* 109:126 */       String queryString = "from IdtFamilyTypes as model where model." + propertyName + "= ?";
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
/* 121:    */   public IdtFamilyTypes merge(IdtFamilyTypes detachedInstance)
/* 122:    */   {
/* 123:143 */     log.debug("merging IdtFamilyTypes instance");
/* 124:    */     try
/* 125:    */     {
/* 126:145 */       IdtFamilyTypes result = (IdtFamilyTypes)getSession().merge(detachedInstance);
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
/* 137:    */   public void save(IdtFamilyTypes transientInstance)
/* 138:    */   {
/* 139:160 */     log.debug("saving IdtFamilyTypes instance");
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
 * Qualified Name:     sia.bql.hibernate.sioperan.IdtFamilyTypesDAO
 * JD-Core Version:    0.7.0.1
 */