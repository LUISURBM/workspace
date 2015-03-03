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
/*  12:    */ public class SioOrganizacionDAO
/*  13:    */   extends BaseHibernateDAO
/*  14:    */ {
/*  15: 18 */   private static final Log log = LogFactory.getLog(SioOrganizacionDAO.class);
/*  16:    */   public static final String TIPO = "tipo";
/*  17:    */   public static final String ESTADO = "estado";
/*  18:    */   public static final String EMAIL = "email";
/*  19:    */   public static final String CLASE = "clase";
/*  20:    */   public static final String RAZON_SOCIAL = "razonSocial";
/*  21:    */   public static final String DIRECCION = "direccion";
/*  22:    */   public static final String FAX = "fax";
/*  23:    */   public static final String WEB = "web";
/*  24:    */   public static final String TELEFONO = "telefono";
/*  25:    */   public static final String SECTOR = "sector";
/*  26:    */   public static final String NIT = "nit";
/*  27:    */   public static final String SIGLA = "sigla";
/*  28:    */   
/*  29:    */   public void save(SioOrganizacion transientInstance)
/*  30:    */   {
/*  31: 33 */     log.debug("saving SioOrganizacion instance");
/*  32:    */     try
/*  33:    */     {
/*  34: 35 */       getSession().save(transientInstance);
/*  35: 36 */       log.debug("save successful");
/*  36:    */     }
/*  37:    */     catch (RuntimeException re)
/*  38:    */     {
/*  39: 38 */       log.error("save failed", re);
/*  40: 39 */       throw re;
/*  41:    */     }
/*  42:    */   }
/*  43:    */   
/*  44:    */   public void delete(SioOrganizacion persistentInstance)
/*  45:    */   {
/*  46: 43 */     log.debug("deleting SioOrganizacion instance");
/*  47:    */     try
/*  48:    */     {
/*  49: 45 */       getSession().delete(persistentInstance);
/*  50: 46 */       log.debug("delete successful");
/*  51:    */     }
/*  52:    */     catch (RuntimeException re)
/*  53:    */     {
/*  54: 48 */       log.error("delete failed", re);
/*  55: 49 */       throw re;
/*  56:    */     }
/*  57:    */   }
/*  58:    */   
/*  59:    */   public SioOrganizacion findById(Long id)
/*  60:    */   {
/*  61: 53 */     log.debug("getting SioOrganizacion instance with id: " + id);
/*  62:    */     try
/*  63:    */     {
/*  64: 55 */       return (SioOrganizacion)getSession().get("sia.hibernate.SioOrganizacion", id);
/*  65:    */     }
/*  66:    */     catch (RuntimeException re)
/*  67:    */     {
/*  68: 58 */       log.error("get failed", re);
/*  69: 59 */       throw re;
/*  70:    */     }
/*  71:    */   }
/*  72:    */   
/*  73:    */   public List findByExample(SioOrganizacion instance)
/*  74:    */   {
/*  75: 63 */     log.debug("finding SioOrganizacion instance by example");
/*  76:    */     try
/*  77:    */     {
/*  78: 65 */       List results = getSession().createCriteria("sia.hibernate.SioOrganizacion").add(Example.create(instance)).list();
/*  79: 66 */       log.debug("find by example successful, result size: " + results.size());
/*  80: 67 */       return results;
/*  81:    */     }
/*  82:    */     catch (RuntimeException re)
/*  83:    */     {
/*  84: 69 */       log.error("find by example failed", re);
/*  85: 70 */       throw re;
/*  86:    */     }
/*  87:    */   }
/*  88:    */   
/*  89:    */   public List findByProperty(String propertyName, Object value)
/*  90:    */   {
/*  91: 74 */     log.debug("finding SioOrganizacion instance with property: " + propertyName + ", value: " + value);
/*  92:    */     try
/*  93:    */     {
/*  94: 76 */       String queryString = "from SioOrganizacion as model where model." + propertyName + "= ?";
/*  95: 77 */       Query queryObject = getSession().createQuery(queryString);
/*  96: 78 */       queryObject.setParameter(0, value);
/*  97: 79 */       return queryObject.list();
/*  98:    */     }
/*  99:    */     catch (RuntimeException re)
/* 100:    */     {
/* 101: 81 */       log.error("find by property name failed", re);
/* 102: 82 */       throw re;
/* 103:    */     }
/* 104:    */   }
/* 105:    */   
/* 106:    */   public List findByTipo(Object tipo)
/* 107:    */   {
/* 108: 86 */     return findByProperty("tipo", tipo);
/* 109:    */   }
/* 110:    */   
/* 111:    */   public List findByEstado(Object estado)
/* 112:    */   {
/* 113: 89 */     return findByProperty("estado", estado);
/* 114:    */   }
/* 115:    */   
/* 116:    */   public List findByEmail(Object email)
/* 117:    */   {
/* 118: 92 */     return findByProperty("email", email);
/* 119:    */   }
/* 120:    */   
/* 121:    */   public List findByClase(Object clase)
/* 122:    */   {
/* 123: 95 */     return findByProperty("clase", clase);
/* 124:    */   }
/* 125:    */   
/* 126:    */   public List findByRazonSocial(Object razonSocial)
/* 127:    */   {
/* 128: 98 */     return findByProperty("razonSocial", razonSocial);
/* 129:    */   }
/* 130:    */   
/* 131:    */   public List findByDireccion(Object direccion)
/* 132:    */   {
/* 133:101 */     return findByProperty("direccion", direccion);
/* 134:    */   }
/* 135:    */   
/* 136:    */   public List findByFax(Object fax)
/* 137:    */   {
/* 138:104 */     return findByProperty("fax", fax);
/* 139:    */   }
/* 140:    */   
/* 141:    */   public List findByWeb(Object web)
/* 142:    */   {
/* 143:107 */     return findByProperty("web", web);
/* 144:    */   }
/* 145:    */   
/* 146:    */   public List findByTelefono(Object telefono)
/* 147:    */   {
/* 148:110 */     return findByProperty("telefono", telefono);
/* 149:    */   }
/* 150:    */   
/* 151:    */   public List findBySector(Object sector)
/* 152:    */   {
/* 153:113 */     return findByProperty("sector", sector);
/* 154:    */   }
/* 155:    */   
/* 156:    */   public List findByNit(Object nit)
/* 157:    */   {
/* 158:116 */     return findByProperty("nit", nit);
/* 159:    */   }
/* 160:    */   
/* 161:    */   public List findBySigla(Object sigla)
/* 162:    */   {
/* 163:119 */     return findByProperty("sigla", sigla);
/* 164:    */   }
/* 165:    */   
/* 166:    */   public SioOrganizacion merge(SioOrganizacion detachedInstance)
/* 167:    */   {
/* 168:122 */     log.debug("merging SioOrganizacion instance");
/* 169:    */     try
/* 170:    */     {
/* 171:124 */       SioOrganizacion result = (SioOrganizacion)getSession().merge(detachedInstance);
/* 172:125 */       log.debug("merge successful");
/* 173:126 */       return result;
/* 174:    */     }
/* 175:    */     catch (RuntimeException re)
/* 176:    */     {
/* 177:128 */       log.error("merge failed", re);
/* 178:129 */       throw re;
/* 179:    */     }
/* 180:    */   }
/* 181:    */   
/* 182:    */   public void attachDirty(SioOrganizacion instance)
/* 183:    */   {
/* 184:133 */     log.debug("attaching dirty SioOrganizacion instance");
/* 185:    */     try
/* 186:    */     {
/* 187:135 */       getSession().saveOrUpdate(instance);
/* 188:136 */       log.debug("attach successful");
/* 189:    */     }
/* 190:    */     catch (RuntimeException re)
/* 191:    */     {
/* 192:138 */       log.error("attach failed", re);
/* 193:139 */       throw re;
/* 194:    */     }
/* 195:    */   }
/* 196:    */   
/* 197:    */   public void attachClean(SioOrganizacion instance)
/* 198:    */   {
/* 199:143 */     log.debug("attaching clean SioOrganizacion instance");
/* 200:    */     try
/* 201:    */     {
/* 202:145 */       getSession().lock(instance, LockMode.NONE);
/* 203:146 */       log.debug("attach successful");
/* 204:    */     }
/* 205:    */     catch (RuntimeException re)
/* 206:    */     {
/* 207:148 */       log.error("attach failed", re);
/* 208:149 */       throw re;
/* 209:    */     }
/* 210:    */   }
/* 211:    */ }


/* Location:           C:\Users\Luis\Desktop\CLXX\BalanceQL\Fuentes\
 * Qualified Name:     sia.bql.hibernate.sioperan.SioOrganizacionDAO
 * JD-Core Version:    0.7.0.1
 */