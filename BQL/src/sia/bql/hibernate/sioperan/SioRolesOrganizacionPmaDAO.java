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
/*  12:    */ public class SioRolesOrganizacionPmaDAO
/*  13:    */   extends BaseHibernateDAO
/*  14:    */ {
/*  15: 18 */   private static final Log log = LogFactory.getLog(SioRolesOrganizacionPmaDAO.class);
/*  16:    */   public static final String TIPO = "tipo";
/*  17:    */   public static final String ESTADO = "estado";
/*  18:    */   public static final String FUNCION = "funcion";
/*  19:    */   
/*  20:    */   public void save(SioRolesOrganizacionPma transientInstance)
/*  21:    */   {
/*  22: 24 */     log.debug("saving SioRolesOrganizacionPma instance");
/*  23:    */     try
/*  24:    */     {
/*  25: 26 */       getSession().save(transientInstance);
/*  26: 27 */       log.debug("save successful");
/*  27:    */     }
/*  28:    */     catch (RuntimeException re)
/*  29:    */     {
/*  30: 29 */       log.error("save failed", re);
/*  31: 30 */       throw re;
/*  32:    */     }
/*  33:    */   }
/*  34:    */   
/*  35:    */   public void delete(SioRolesOrganizacionPma persistentInstance)
/*  36:    */   {
/*  37: 34 */     log.debug("deleting SioRolesOrganizacionPma instance");
/*  38:    */     try
/*  39:    */     {
/*  40: 36 */       getSession().delete(persistentInstance);
/*  41: 37 */       log.debug("delete successful");
/*  42:    */     }
/*  43:    */     catch (RuntimeException re)
/*  44:    */     {
/*  45: 39 */       log.error("delete failed", re);
/*  46: 40 */       throw re;
/*  47:    */     }
/*  48:    */   }
/*  49:    */   
/*  50:    */   public SioRolesOrganizacionPma findById(Long id)
/*  51:    */   {
/*  52: 44 */     log.debug("getting SioRolesOrganizacionPma instance with id: " + id);
/*  53:    */     try
/*  54:    */     {
/*  55: 46 */       return (SioRolesOrganizacionPma)getSession().get("sia.hibernate.SioRolesOrganizacionPma", id);
/*  56:    */     }
/*  57:    */     catch (RuntimeException re)
/*  58:    */     {
/*  59: 49 */       log.error("get failed", re);
/*  60: 50 */       throw re;
/*  61:    */     }
/*  62:    */   }
/*  63:    */   
/*  64:    */   public List findByExample(SioRolesOrganizacionPma instance)
/*  65:    */   {
/*  66: 54 */     log.debug("finding SioRolesOrganizacionPma instance by example");
/*  67:    */     try
/*  68:    */     {
/*  69: 56 */       List results = getSession().createCriteria("sia.hibernate.SioRolesOrganizacionPma").add(Example.create(instance)).list();
/*  70: 57 */       log.debug("find by example successful, result size: " + results.size());
/*  71: 58 */       return results;
/*  72:    */     }
/*  73:    */     catch (RuntimeException re)
/*  74:    */     {
/*  75: 60 */       log.error("find by example failed", re);
/*  76: 61 */       throw re;
/*  77:    */     }
/*  78:    */   }
/*  79:    */   
/*  80:    */   public List findByProperty(String propertyName, Object value)
/*  81:    */   {
/*  82: 65 */     log.debug("finding SioRolesOrganizacionPma instance with property: " + propertyName + ", value: " + value);
/*  83:    */     try
/*  84:    */     {
/*  85: 67 */       String queryString = "from SioRolesOrganizacionPma as model where model." + propertyName + "= ?";
/*  86: 68 */       Query queryObject = getSession().createQuery(queryString);
/*  87: 69 */       queryObject.setParameter(0, value);
/*  88: 70 */       return queryObject.list();
/*  89:    */     }
/*  90:    */     catch (RuntimeException re)
/*  91:    */     {
/*  92: 72 */       log.error("find by property name failed", re);
/*  93: 73 */       throw re;
/*  94:    */     }
/*  95:    */   }
/*  96:    */   
/*  97:    */   public List findByTipo(Object tipo)
/*  98:    */   {
/*  99: 77 */     return findByProperty("tipo", tipo);
/* 100:    */   }
/* 101:    */   
/* 102:    */   public List findByEstado(Object estado)
/* 103:    */   {
/* 104: 80 */     return findByProperty("estado", estado);
/* 105:    */   }
/* 106:    */   
/* 107:    */   public List findByFuncion(Object funcion)
/* 108:    */   {
/* 109: 83 */     return findByProperty("funcion", funcion);
/* 110:    */   }
/* 111:    */   
/* 112:    */   public SioRolesOrganizacionPma merge(SioRolesOrganizacionPma detachedInstance)
/* 113:    */   {
/* 114: 86 */     log.debug("merging SioRolesOrganizacionPma instance");
/* 115:    */     try
/* 116:    */     {
/* 117: 88 */       SioRolesOrganizacionPma result = (SioRolesOrganizacionPma)getSession().merge(detachedInstance);
/* 118: 89 */       log.debug("merge successful");
/* 119: 90 */       return result;
/* 120:    */     }
/* 121:    */     catch (RuntimeException re)
/* 122:    */     {
/* 123: 92 */       log.error("merge failed", re);
/* 124: 93 */       throw re;
/* 125:    */     }
/* 126:    */   }
/* 127:    */   
/* 128:    */   public void attachDirty(SioRolesOrganizacionPma instance)
/* 129:    */   {
/* 130: 97 */     log.debug("attaching dirty SioRolesOrganizacionPma instance");
/* 131:    */     try
/* 132:    */     {
/* 133: 99 */       getSession().saveOrUpdate(instance);
/* 134:100 */       log.debug("attach successful");
/* 135:    */     }
/* 136:    */     catch (RuntimeException re)
/* 137:    */     {
/* 138:102 */       log.error("attach failed", re);
/* 139:103 */       throw re;
/* 140:    */     }
/* 141:    */   }
/* 142:    */   
/* 143:    */   public void attachClean(SioRolesOrganizacionPma instance)
/* 144:    */   {
/* 145:107 */     log.debug("attaching clean SioRolesOrganizacionPma instance");
/* 146:    */     try
/* 147:    */     {
/* 148:109 */       getSession().lock(instance, LockMode.NONE);
/* 149:110 */       log.debug("attach successful");
/* 150:    */     }
/* 151:    */     catch (RuntimeException re)
/* 152:    */     {
/* 153:112 */       log.error("attach failed", re);
/* 154:113 */       throw re;
/* 155:    */     }
/* 156:    */   }
/* 157:    */ }


/* Location:           C:\Users\Luis\Desktop\CLXX\BalanceQL\Fuentes\
 * Qualified Name:     sia.bql.hibernate.sioperan.SioRolesOrganizacionPmaDAO
 * JD-Core Version:    0.7.0.1
 */