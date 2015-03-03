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
/*  12:    */ public class ShmtGranulometriaCalculosDAO
/*  13:    */   extends BaseHibernateDAO
/*  14:    */ {
/*  15:    */   public static final String GRCL_D1 = "grclD1";
/*  16:    */   public static final String GRCL_DM = "grclDm";
/*  17:    */   public static final String GRCL_P1 = "grclP1";
/*  18:    */   public static final String GRCL_PESO_RETENIDO = "grclPesoRetenido";
/*  19:    */   public static final String GRCL_PORC_ACUMULADO = "grclPorcAcumulado";
/*  20:    */   public static final String GRCL_PORC_PASA = "grclPorcPasa";
/*  21:    */   public static final String GRCL_USUARIO = "grclUsuario";
/*  22:    */   public static final String GRCL_W1 = "grclW1";
/*  23:    */   public static final String GRCL_WPOND = "grclWpond";
/*  24: 27 */   private static final Log log = LogFactory.getLog(ShmtGranulometriaCalculosDAO.class);
/*  25:    */   
/*  26:    */   public void attachClean(ShmtGranulometriaCalculos instance)
/*  27:    */   {
/*  28: 29 */     log.debug("attaching clean ShmtGranulometriaCalculos instance");
/*  29:    */     try
/*  30:    */     {
/*  31: 31 */       getSession().lock(instance, LockMode.NONE);
/*  32: 32 */       log.debug("attach successful");
/*  33:    */     }
/*  34:    */     catch (RuntimeException re)
/*  35:    */     {
/*  36: 34 */       log.error("attach failed", re);
/*  37: 35 */       throw re;
/*  38:    */     }
/*  39:    */   }
/*  40:    */   
/*  41:    */   public void attachDirty(ShmtGranulometriaCalculos instance)
/*  42:    */   {
/*  43: 39 */     log.debug("attaching dirty ShmtGranulometriaCalculos instance");
/*  44:    */     try
/*  45:    */     {
/*  46: 41 */       getSession().saveOrUpdate(instance);
/*  47: 42 */       log.debug("attach successful");
/*  48:    */     }
/*  49:    */     catch (RuntimeException re)
/*  50:    */     {
/*  51: 44 */       log.error("attach failed", re);
/*  52: 45 */       throw re;
/*  53:    */     }
/*  54:    */   }
/*  55:    */   
/*  56:    */   public void delete(ShmtGranulometriaCalculos persistentInstance)
/*  57:    */   {
/*  58: 49 */     log.debug("deleting ShmtGranulometriaCalculos instance");
/*  59:    */     try
/*  60:    */     {
/*  61: 51 */       getSession().delete(persistentInstance);
/*  62: 52 */       log.debug("delete successful");
/*  63:    */     }
/*  64:    */     catch (RuntimeException re)
/*  65:    */     {
/*  66: 54 */       log.error("delete failed", re);
/*  67: 55 */       throw re;
/*  68:    */     }
/*  69:    */   }
/*  70:    */   
/*  71:    */   public List findByExample(ShmtGranulometriaCalculos instance)
/*  72:    */   {
/*  73: 60 */     log.debug("finding ShmtGranulometriaCalculos instance by example");
/*  74:    */     try
/*  75:    */     {
/*  76: 62 */       List results = getSession().createCriteria("sia.hibernate.ShmtGranulometriaCalculos").add(Example.create(instance)).list();
/*  77: 63 */       log.debug("find by example successful, result size: " + results.size());
/*  78: 64 */       return results;
/*  79:    */     }
/*  80:    */     catch (RuntimeException re)
/*  81:    */     {
/*  82: 66 */       log.error("find by example failed", re);
/*  83: 67 */       throw re;
/*  84:    */     }
/*  85:    */   }
/*  86:    */   
/*  87:    */   public List findByGrclD1(Object grclD1)
/*  88:    */   {
/*  89: 72 */     return findByProperty("grclD1", grclD1);
/*  90:    */   }
/*  91:    */   
/*  92:    */   public List findByGrclDm(Object grclDm)
/*  93:    */   {
/*  94: 76 */     return findByProperty("grclDm", grclDm);
/*  95:    */   }
/*  96:    */   
/*  97:    */   public List findByGrclP1(Object grclP1)
/*  98:    */   {
/*  99: 80 */     return findByProperty("grclP1", grclP1);
/* 100:    */   }
/* 101:    */   
/* 102:    */   public List findByGrclPesoRetenido(Object grclPesoRetenido)
/* 103:    */   {
/* 104: 84 */     return findByProperty("grclPesoRetenido", grclPesoRetenido);
/* 105:    */   }
/* 106:    */   
/* 107:    */   public List findByGrclPorcAcumulado(Object grclPorcAcumulado)
/* 108:    */   {
/* 109: 88 */     return findByProperty("grclPorcAcumulado", grclPorcAcumulado);
/* 110:    */   }
/* 111:    */   
/* 112:    */   public List findByGrclPorcPasa(Object grclPorcPasa)
/* 113:    */   {
/* 114: 92 */     return findByProperty("grclPorcPasa", grclPorcPasa);
/* 115:    */   }
/* 116:    */   
/* 117:    */   public List findByGrclUsuario(Object grclUsuario)
/* 118:    */   {
/* 119: 96 */     return findByProperty("grclUsuario", grclUsuario);
/* 120:    */   }
/* 121:    */   
/* 122:    */   public List findByGrclW1(Object grclW1)
/* 123:    */   {
/* 124:100 */     return findByProperty("grclW1", grclW1);
/* 125:    */   }
/* 126:    */   
/* 127:    */   public List findByGrclWpond(Object grclWpond)
/* 128:    */   {
/* 129:104 */     return findByProperty("grclWpond", grclWpond);
/* 130:    */   }
/* 131:    */   
/* 132:    */   public ShmtGranulometriaCalculos findById(Long id)
/* 133:    */   {
/* 134:107 */     log.debug("getting ShmtGranulometriaCalculos instance with id: " + id);
/* 135:    */     try
/* 136:    */     {
/* 137:109 */       return (ShmtGranulometriaCalculos)getSession().get("sia.hibernate.ShmtGranulometriaCalculos", id);
/* 138:    */     }
/* 139:    */     catch (RuntimeException re)
/* 140:    */     {
/* 141:112 */       log.error("get failed", re);
/* 142:113 */       throw re;
/* 143:    */     }
/* 144:    */   }
/* 145:    */   
/* 146:    */   public List findByProperty(String propertyName, Object value)
/* 147:    */   {
/* 148:118 */     log.debug("finding ShmtGranulometriaCalculos instance with property: " + propertyName + ", value: " + value);
/* 149:    */     try
/* 150:    */     {
/* 151:120 */       String queryString = "from ShmtGranulometriaCalculos as model where model." + propertyName + "= ?";
/* 152:121 */       Query queryObject = getSession().createQuery(queryString);
/* 153:122 */       queryObject.setParameter(0, value);
/* 154:123 */       return queryObject.list();
/* 155:    */     }
/* 156:    */     catch (RuntimeException re)
/* 157:    */     {
/* 158:125 */       log.error("find by property name failed", re);
/* 159:126 */       throw re;
/* 160:    */     }
/* 161:    */   }
/* 162:    */   
/* 163:    */   public ShmtGranulometriaCalculos merge(ShmtGranulometriaCalculos detachedInstance)
/* 164:    */   {
/* 165:130 */     log.debug("merging ShmtGranulometriaCalculos instance");
/* 166:    */     try
/* 167:    */     {
/* 168:132 */       ShmtGranulometriaCalculos result = (ShmtGranulometriaCalculos)getSession().merge(detachedInstance);
/* 169:133 */       log.debug("merge successful");
/* 170:134 */       return result;
/* 171:    */     }
/* 172:    */     catch (RuntimeException re)
/* 173:    */     {
/* 174:136 */       log.error("merge failed", re);
/* 175:137 */       throw re;
/* 176:    */     }
/* 177:    */   }
/* 178:    */   
/* 179:    */   public void save(ShmtGranulometriaCalculos transientInstance)
/* 180:    */   {
/* 181:141 */     log.debug("saving ShmtGranulometriaCalculos instance");
/* 182:    */     try
/* 183:    */     {
/* 184:143 */       getSession().save(transientInstance);
/* 185:144 */       log.debug("save successful");
/* 186:    */     }
/* 187:    */     catch (RuntimeException re)
/* 188:    */     {
/* 189:146 */       log.error("save failed", re);
/* 190:147 */       throw re;
/* 191:    */     }
/* 192:    */   }
/* 193:    */ }


/* Location:           C:\Users\Luis\Desktop\CLXX\BalanceQL\Fuentes\
 * Qualified Name:     sia.bql.hibernate.sioperan.ShmtGranulometriaCalculosDAO
 * JD-Core Version:    0.7.0.1
 */