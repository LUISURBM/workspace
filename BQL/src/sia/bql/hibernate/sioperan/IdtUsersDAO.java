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
/*  12:    */ public class IdtUsersDAO
/*  13:    */   extends BaseHibernateDAO
/*  14:    */ {
/*  15: 11 */   private static final Log log = LogFactory.getLog(IdtUsersDAO.class);
/*  16:    */   public static final String USR_NAME = "usrName";
/*  17:    */   public static final String USR_DESCRIPTION = "usrDescription";
/*  18:    */   public static final String USR_PASSWORD = "usrPassword";
/*  19:    */   public static final String USR_STATUS = "usrStatus";
/*  20:    */   public static final String USR_PRF_ID = "usrPrfId";
/*  21:    */   
/*  22:    */   public void attachClean(IdtUsers instance)
/*  23:    */   {
/*  24: 18 */     log.debug("attaching clean IdtUsers instance");
/*  25:    */     try
/*  26:    */     {
/*  27: 20 */       getSession().lock(instance, LockMode.NONE);
/*  28: 21 */       log.debug("attach successful");
/*  29:    */     }
/*  30:    */     catch (RuntimeException re)
/*  31:    */     {
/*  32: 23 */       log.error("attach failed", re);
/*  33: 24 */       throw re;
/*  34:    */     }
/*  35:    */   }
/*  36:    */   
/*  37:    */   public void attachDirty(IdtUsers instance)
/*  38:    */   {
/*  39: 28 */     log.debug("attaching dirty IdtUsers instance");
/*  40:    */     try
/*  41:    */     {
/*  42: 30 */       getSession().saveOrUpdate(instance);
/*  43: 31 */       log.debug("attach successful");
/*  44:    */     }
/*  45:    */     catch (RuntimeException re)
/*  46:    */     {
/*  47: 33 */       log.error("attach failed", re);
/*  48: 34 */       throw re;
/*  49:    */     }
/*  50:    */   }
/*  51:    */   
/*  52:    */   public void delete(IdtUsers persistentInstance)
/*  53:    */   {
/*  54: 38 */     log.debug("deleting IdtUsers instance");
/*  55:    */     try
/*  56:    */     {
/*  57: 40 */       getSession().delete(persistentInstance);
/*  58: 41 */       log.debug("delete successful");
/*  59:    */     }
/*  60:    */     catch (RuntimeException re)
/*  61:    */     {
/*  62: 43 */       log.error("delete failed", re);
/*  63: 44 */       throw re;
/*  64:    */     }
/*  65:    */   }
/*  66:    */   
/*  67:    */   public List findAll()
/*  68:    */   {
/*  69: 49 */     log.debug("finding all IdtUsers instances");
/*  70:    */     try
/*  71:    */     {
/*  72: 51 */       String queryString = "from IdtUsers";
/*  73: 52 */       Query queryObject = getSession().createQuery("from IdtUsers");
/*  74: 53 */       return queryObject.list();
/*  75:    */     }
/*  76:    */     catch (RuntimeException re)
/*  77:    */     {
/*  78: 55 */       log.error("find all failed", re);
/*  79: 56 */       throw re;
/*  80:    */     }
/*  81:    */   }
/*  82:    */   
/*  83:    */   public List findByExample(IdtUsers instance)
/*  84:    */   {
/*  85: 61 */     log.debug("finding IdtUsers instance by example");
/*  86:    */     try
/*  87:    */     {
/*  88: 63 */       List results = getSession().createCriteria("model.IdtUsers").add(Example.create(instance)).list();
/*  89: 64 */       log.debug("find by example successful, result size: " + results.size());
/*  90: 65 */       return results;
/*  91:    */     }
/*  92:    */     catch (RuntimeException re)
/*  93:    */     {
/*  94: 67 */       log.error("find by example failed", re);
/*  95: 68 */       throw re;
/*  96:    */     }
/*  97:    */   }
/*  98:    */   
/*  99:    */   public IdtUsers findById(Long id)
/* 100:    */   {
/* 101: 72 */     log.debug("getting IdtUsers instance with id: " + id);
/* 102:    */     try
/* 103:    */     {
/* 104: 74 */       return (IdtUsers)getSession().get("model.IdtUsers", id);
/* 105:    */     }
/* 106:    */     catch (RuntimeException re)
/* 107:    */     {
/* 108: 77 */       log.error("get failed", re);
/* 109: 78 */       throw re;
/* 110:    */     }
/* 111:    */   }
/* 112:    */   
/* 113:    */   public List findByProperty(String propertyName, Object value)
/* 114:    */   {
/* 115: 83 */     log.debug("finding IdtUsers instance with property: " + propertyName + ", value: " + value);
/* 116:    */     try
/* 117:    */     {
/* 118: 85 */       String queryString = "from IdtUsers as model where model." + propertyName + "= ?";
/* 119: 86 */       Query queryObject = getSession().createQuery(queryString);
/* 120: 87 */       queryObject.setParameter(0, value);
/* 121: 88 */       return queryObject.list();
/* 122:    */     }
/* 123:    */     catch (RuntimeException re)
/* 124:    */     {
/* 125: 90 */       log.error("find by property name failed", re);
/* 126: 91 */       throw re;
/* 127:    */     }
/* 128:    */   }
/* 129:    */   
/* 130:    */   public List findByUsrDescription(Object usrDescription)
/* 131:    */   {
/* 132: 96 */     return findByProperty("usrDescription", usrDescription);
/* 133:    */   }
/* 134:    */   
/* 135:    */   public List findByUsrName(Object usrName)
/* 136:    */   {
/* 137:100 */     return findByProperty("usrName", usrName);
/* 138:    */   }
/* 139:    */   
/* 140:    */   public List findByUsrPassword(Object usrPassword)
/* 141:    */   {
/* 142:104 */     return findByProperty("usrPassword", usrPassword);
/* 143:    */   }
/* 144:    */   
/* 145:    */   public List findByUsrPrfId(Object usrPrfId)
/* 146:    */   {
/* 147:108 */     return findByProperty("usrPrfId", usrPrfId);
/* 148:    */   }
/* 149:    */   
/* 150:    */   public List findByUsrStatus(Object usrStatus)
/* 151:    */   {
/* 152:112 */     return findByProperty("usrStatus", usrStatus);
/* 153:    */   }
/* 154:    */   
/* 155:    */   public IdtUsers merge(IdtUsers detachedInstance)
/* 156:    */   {
/* 157:115 */     log.debug("merging IdtUsers instance");
/* 158:    */     try
/* 159:    */     {
/* 160:117 */       IdtUsers result = (IdtUsers)getSession().merge(detachedInstance);
/* 161:118 */       log.debug("merge successful");
/* 162:119 */       return result;
/* 163:    */     }
/* 164:    */     catch (RuntimeException re)
/* 165:    */     {
/* 166:121 */       log.error("merge failed", re);
/* 167:122 */       throw re;
/* 168:    */     }
/* 169:    */   }
/* 170:    */   
/* 171:    */   public void save(IdtUsers transientInstance)
/* 172:    */   {
/* 173:126 */     log.debug("saving IdtUsers instance");
/* 174:    */     try
/* 175:    */     {
/* 176:128 */       getSession().save(transientInstance);
/* 177:129 */       log.debug("save successful");
/* 178:    */     }
/* 179:    */     catch (RuntimeException re)
/* 180:    */     {
/* 181:131 */       log.error("save failed", re);
/* 182:132 */       throw re;
/* 183:    */     }
/* 184:    */   }
/* 185:    */ }


/* Location:           C:\Users\Luis\Desktop\CLXX\BalanceQL\Fuentes\
 * Qualified Name:     sia.bql.hibernate.sioperan.IdtUsersDAO
 * JD-Core Version:    0.7.0.1
 */