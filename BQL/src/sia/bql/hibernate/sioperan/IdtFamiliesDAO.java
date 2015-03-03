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
/*  12:    */ public class IdtFamiliesDAO
/*  13:    */   extends BaseHibernateDAO
/*  14:    */ {
/*  15:    */   public static final String FML_DATATYPE = "fmlDatatype";
/*  16:    */   public static final String FML_DECIMAL = "fmlDecimal";
/*  17:    */   public static final String FML_DESCRIPTION = "fmlDescription";
/*  18:    */   public static final String FML_LONG = "fmlLong";
/*  19:    */   public static final String FML_NAME = "fmlName";
/*  20: 33 */   private static final Log log = LogFactory.getLog(IdtFamiliesDAO.class);
/*  21:    */   
/*  22:    */   public void attachClean(IdtFamilies instance)
/*  23:    */   {
/*  24: 41 */     log.debug("attaching clean IdtFamilies instance");
/*  25:    */     try
/*  26:    */     {
/*  27: 43 */       getSession().lock(instance, LockMode.NONE);
/*  28: 44 */       log.debug("attach successful");
/*  29:    */     }
/*  30:    */     catch (RuntimeException re)
/*  31:    */     {
/*  32: 46 */       log.error("attach failed", re);
/*  33: 47 */       throw re;
/*  34:    */     }
/*  35:    */   }
/*  36:    */   
/*  37:    */   public void attachDirty(IdtFamilies instance)
/*  38:    */   {
/*  39: 57 */     log.debug("attaching dirty IdtFamilies instance");
/*  40:    */     try
/*  41:    */     {
/*  42: 59 */       getSession().saveOrUpdate(instance);
/*  43: 60 */       log.debug("attach successful");
/*  44:    */     }
/*  45:    */     catch (RuntimeException re)
/*  46:    */     {
/*  47: 62 */       log.error("attach failed", re);
/*  48: 63 */       throw re;
/*  49:    */     }
/*  50:    */   }
/*  51:    */   
/*  52:    */   public void delete(IdtFamilies persistentInstance)
/*  53:    */   {
/*  54: 73 */     log.debug("deleting IdtFamilies instance");
/*  55:    */     try
/*  56:    */     {
/*  57: 75 */       getSession().delete(persistentInstance);
/*  58: 76 */       log.debug("delete successful");
/*  59:    */     }
/*  60:    */     catch (RuntimeException re)
/*  61:    */     {
/*  62: 78 */       log.error("delete failed", re);
/*  63: 79 */       throw re;
/*  64:    */     }
/*  65:    */   }
/*  66:    */   
/*  67:    */   public List findByExample(IdtFamilies instance)
/*  68:    */   {
/*  69: 90 */     log.debug("finding IdtFamilies instance by example");
/*  70:    */     try
/*  71:    */     {
/*  72: 92 */       List results = getSession().createCriteria("sia.hibernate.IdtFamilies").add(Example.create(instance)).list();
/*  73: 93 */       log.debug("find by example successful, result size: " + results.size());
/*  74: 94 */       return results;
/*  75:    */     }
/*  76:    */     catch (RuntimeException re)
/*  77:    */     {
/*  78: 96 */       log.error("find by example failed", re);
/*  79: 97 */       throw re;
/*  80:    */     }
/*  81:    */   }
/*  82:    */   
/*  83:    */   public List findByFmlDatatype(Object fmlDatatype)
/*  84:    */   {
/*  85:108 */     return findByProperty("fmlDatatype", fmlDatatype);
/*  86:    */   }
/*  87:    */   
/*  88:    */   public List findByFmlDecimal(Object fmlDecimal)
/*  89:    */   {
/*  90:118 */     return findByProperty("fmlDecimal", fmlDecimal);
/*  91:    */   }
/*  92:    */   
/*  93:    */   public List findByFmlDescription(Object fmlDescription)
/*  94:    */   {
/*  95:128 */     return findByProperty("fmlDescription", fmlDescription);
/*  96:    */   }
/*  97:    */   
/*  98:    */   public List findByFmlLong(Object fmlLong)
/*  99:    */   {
/* 100:138 */     return findByProperty("fmlLong", fmlLong);
/* 101:    */   }
/* 102:    */   
/* 103:    */   public List findByFmlName(Object fmlName)
/* 104:    */   {
/* 105:148 */     return findByProperty("fmlName", fmlName);
/* 106:    */   }
/* 107:    */   
/* 108:    */   public IdtFamilies findById(IdtFamiliesId id)
/* 109:    */   {
/* 110:158 */     log.debug("getting IdtFamilies instance with id: " + id);
/* 111:    */     try
/* 112:    */     {
/* 113:160 */       return (IdtFamilies)getSession().get("sia.hibernate.IdtFamilies", id);
/* 114:    */     }
/* 115:    */     catch (RuntimeException re)
/* 116:    */     {
/* 117:163 */       log.error("get failed", re);
/* 118:164 */       throw re;
/* 119:    */     }
/* 120:    */   }
/* 121:    */   
/* 122:    */   public List findByProperty(String propertyName, Object value)
/* 123:    */   {
/* 124:177 */     log.debug("finding IdtFamilies instance with property: " + propertyName + ", value: " + value);
/* 125:    */     try
/* 126:    */     {
/* 127:179 */       String queryString = "from IdtFamilies as model where model." + propertyName + "= ?";
/* 128:180 */       Query queryObject = getSession().createQuery(queryString);
/* 129:181 */       queryObject.setParameter(0, value);
/* 130:182 */       return queryObject.list();
/* 131:    */     }
/* 132:    */     catch (RuntimeException re)
/* 133:    */     {
/* 134:184 */       log.error("find by property name failed", re);
/* 135:185 */       throw re;
/* 136:    */     }
/* 137:    */   }
/* 138:    */   
/* 139:    */   public IdtFamilies merge(IdtFamilies detachedInstance)
/* 140:    */   {
/* 141:196 */     log.debug("merging IdtFamilies instance");
/* 142:    */     try
/* 143:    */     {
/* 144:198 */       IdtFamilies result = (IdtFamilies)getSession().merge(detachedInstance);
/* 145:199 */       log.debug("merge successful");
/* 146:200 */       return result;
/* 147:    */     }
/* 148:    */     catch (RuntimeException re)
/* 149:    */     {
/* 150:202 */       log.error("merge failed", re);
/* 151:203 */       throw re;
/* 152:    */     }
/* 153:    */   }
/* 154:    */   
/* 155:    */   public void save(IdtFamilies transientInstance)
/* 156:    */   {
/* 157:213 */     log.debug("saving IdtFamilies instance");
/* 158:    */     try
/* 159:    */     {
/* 160:215 */       getSession().save(transientInstance);
/* 161:216 */       log.debug("save successful");
/* 162:    */     }
/* 163:    */     catch (RuntimeException re)
/* 164:    */     {
/* 165:218 */       log.error("save failed", re);
/* 166:219 */       throw re;
/* 167:    */     }
/* 168:    */   }
/* 169:    */ }


/* Location:           C:\Users\Luis\Desktop\CLXX\BalanceQL\Fuentes\
 * Qualified Name:     sia.bql.hibernate.sioperan.IdtFamiliesDAO
 * JD-Core Version:    0.7.0.1
 */