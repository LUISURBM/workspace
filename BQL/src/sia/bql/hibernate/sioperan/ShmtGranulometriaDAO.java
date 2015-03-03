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
/*  12:    */ public class ShmtGranulometriaDAO
/*  13:    */   extends BaseHibernateDAO
/*  14:    */ {
/*  15:    */   public static final String GRN_ABSCISA = "grnAbscisa";
/*  16:    */   public static final String GRN_COORD_PROG = "grnCoordProg";
/*  17:    */   public static final String GRN_EQUIPO_MUESTREADOR = "grnEquipoMuestreador";
/*  18:    */   public static final String GRN_ESTACION_ID = "grnEstacionId";
/*  19:    */   public static final String GRN_FLUVIOMETRO = "grnFluviometro";
/*  20:    */   public static final String GRN_METODO_PROCESO = "grnMetodoProceso";
/*  21:    */   public static final String GRN_NOMBRE_ANALISTA = "grnNombreAnalista";
/*  22:    */   public static final String GRN_OBSERVACIONES = "grnObservaciones";
/*  23:    */   public static final String GRN_PESO_TOT_MUESTRA = "grnPesoTotMuestra";
/*  24:    */   public static final String GRN_PESO_TOT_MUESTRA_TRATADA = "grnPesoTotMuestraTratada";
/*  25:    */   public static final String GRN_TIEMPO_TAMIZADO = "grnTiempoTamizado";
/*  26:    */   public static final String GRN_TIPO_SEDIMENTO = "grnTipoSedimento";
/*  27:    */   public static final String GRN_USUARIO = "grnUsuario";
/*  28: 31 */   private static final Log log = LogFactory.getLog(ShmtGranulometriaDAO.class);
/*  29:    */   
/*  30:    */   public void attachClean(ShmtGranulometria instance)
/*  31:    */   {
/*  32: 33 */     log.debug("attaching clean ShmtGranulometria instance");
/*  33:    */     try
/*  34:    */     {
/*  35: 35 */       getSession().lock(instance, LockMode.NONE);
/*  36: 36 */       log.debug("attach successful");
/*  37:    */     }
/*  38:    */     catch (RuntimeException re)
/*  39:    */     {
/*  40: 38 */       log.error("attach failed", re);
/*  41: 39 */       throw re;
/*  42:    */     }
/*  43:    */   }
/*  44:    */   
/*  45:    */   public void attachDirty(ShmtGranulometria instance)
/*  46:    */   {
/*  47: 43 */     log.debug("attaching dirty ShmtGranulometria instance");
/*  48:    */     try
/*  49:    */     {
/*  50: 45 */       getSession().saveOrUpdate(instance);
/*  51: 46 */       log.debug("attach successful");
/*  52:    */     }
/*  53:    */     catch (RuntimeException re)
/*  54:    */     {
/*  55: 48 */       log.error("attach failed", re);
/*  56: 49 */       throw re;
/*  57:    */     }
/*  58:    */   }
/*  59:    */   
/*  60:    */   public void delete(ShmtGranulometria persistentInstance)
/*  61:    */   {
/*  62: 53 */     log.debug("deleting ShmtGranulometria instance");
/*  63:    */     try
/*  64:    */     {
/*  65: 55 */       getSession().delete(persistentInstance);
/*  66: 56 */       log.debug("delete successful");
/*  67:    */     }
/*  68:    */     catch (RuntimeException re)
/*  69:    */     {
/*  70: 58 */       log.error("delete failed", re);
/*  71: 59 */       throw re;
/*  72:    */     }
/*  73:    */   }
/*  74:    */   
/*  75:    */   public List findByExample(ShmtGranulometria instance)
/*  76:    */   {
/*  77: 64 */     log.debug("finding ShmtGranulometria instance by example");
/*  78:    */     try
/*  79:    */     {
/*  80: 66 */       List results = getSession().createCriteria("sia.hibernate.ShmtGranulometria").add(Example.create(instance)).list();
/*  81: 67 */       log.debug("find by example successful, result size: " + results.size());
/*  82: 68 */       return results;
/*  83:    */     }
/*  84:    */     catch (RuntimeException re)
/*  85:    */     {
/*  86: 70 */       log.error("find by example failed", re);
/*  87: 71 */       throw re;
/*  88:    */     }
/*  89:    */   }
/*  90:    */   
/*  91:    */   public List findByGrnAbscisa(Object grnAbscisa)
/*  92:    */   {
/*  93: 76 */     return findByProperty("grnAbscisa", grnAbscisa);
/*  94:    */   }
/*  95:    */   
/*  96:    */   public List findByGrnCoordProg(Object grnCoordProg)
/*  97:    */   {
/*  98: 80 */     return findByProperty("grnCoordProg", grnCoordProg);
/*  99:    */   }
/* 100:    */   
/* 101:    */   public List findByGrnEquipoMuestreador(Object grnEquipoMuestreador)
/* 102:    */   {
/* 103: 84 */     return findByProperty("grnEquipoMuestreador", grnEquipoMuestreador);
/* 104:    */   }
/* 105:    */   
/* 106:    */   public List findByGrnEstacionId(Object grnEstacionId)
/* 107:    */   {
/* 108: 88 */     return findByProperty("grnEstacionId", grnEstacionId);
/* 109:    */   }
/* 110:    */   
/* 111:    */   public List findByGrnFluviometro(Object grnFluviometro)
/* 112:    */   {
/* 113: 92 */     return findByProperty("grnFluviometro", grnFluviometro);
/* 114:    */   }
/* 115:    */   
/* 116:    */   public List findByGrnMetodoProceso(Object grnMetodoProceso)
/* 117:    */   {
/* 118: 96 */     return findByProperty("grnMetodoProceso", grnMetodoProceso);
/* 119:    */   }
/* 120:    */   
/* 121:    */   public List findByGrnNombreAnalista(Object grnNombreAnalista)
/* 122:    */   {
/* 123:100 */     return findByProperty("grnNombreAnalista", grnNombreAnalista);
/* 124:    */   }
/* 125:    */   
/* 126:    */   public List findByGrnObservaciones(Object grnObservaciones)
/* 127:    */   {
/* 128:104 */     return findByProperty("grnObservaciones", grnObservaciones);
/* 129:    */   }
/* 130:    */   
/* 131:    */   public List findByGrnPesoTotMuestra(Object grnPesoTotMuestra)
/* 132:    */   {
/* 133:108 */     return findByProperty("grnPesoTotMuestra", grnPesoTotMuestra);
/* 134:    */   }
/* 135:    */   
/* 136:    */   public List findByGrnPesoTotMuestraTratada(Object grnPesoTotMuestraTratada)
/* 137:    */   {
/* 138:112 */     return findByProperty("grnPesoTotMuestraTratada", grnPesoTotMuestraTratada);
/* 139:    */   }
/* 140:    */   
/* 141:    */   public List findByGrnTiempoTamizado(Object grnTiempoTamizado)
/* 142:    */   {
/* 143:116 */     return findByProperty("grnTiempoTamizado", grnTiempoTamizado);
/* 144:    */   }
/* 145:    */   
/* 146:    */   public List findByGrnTipoSedimento(Object grnTipoSedimento)
/* 147:    */   {
/* 148:120 */     return findByProperty("grnTipoSedimento", grnTipoSedimento);
/* 149:    */   }
/* 150:    */   
/* 151:    */   public List findByGrnUsuario(Object grnUsuario)
/* 152:    */   {
/* 153:124 */     return findByProperty("grnUsuario", grnUsuario);
/* 154:    */   }
/* 155:    */   
/* 156:    */   public ShmtGranulometria findById(Long id)
/* 157:    */   {
/* 158:127 */     log.debug("getting ShmtGranulometria instance with id: " + id);
/* 159:    */     try
/* 160:    */     {
/* 161:129 */       return (ShmtGranulometria)getSession().get("sia.hibernate.ShmtGranulometria", id);
/* 162:    */     }
/* 163:    */     catch (RuntimeException re)
/* 164:    */     {
/* 165:132 */       log.error("get failed", re);
/* 166:133 */       throw re;
/* 167:    */     }
/* 168:    */   }
/* 169:    */   
/* 170:    */   public List findByProperty(String propertyName, Object value)
/* 171:    */   {
/* 172:138 */     log.debug("finding ShmtGranulometria instance with property: " + propertyName + ", value: " + value);
/* 173:    */     try
/* 174:    */     {
/* 175:140 */       String queryString = "from ShmtGranulometria as model where model." + propertyName + "= ?";
/* 176:141 */       Query queryObject = getSession().createQuery(queryString);
/* 177:142 */       queryObject.setParameter(0, value);
/* 178:143 */       return queryObject.list();
/* 179:    */     }
/* 180:    */     catch (RuntimeException re)
/* 181:    */     {
/* 182:145 */       log.error("find by property name failed", re);
/* 183:146 */       throw re;
/* 184:    */     }
/* 185:    */   }
/* 186:    */   
/* 187:    */   public ShmtGranulometria merge(ShmtGranulometria detachedInstance)
/* 188:    */   {
/* 189:150 */     log.debug("merging ShmtGranulometria instance");
/* 190:    */     try
/* 191:    */     {
/* 192:152 */       ShmtGranulometria result = (ShmtGranulometria)getSession().merge(detachedInstance);
/* 193:153 */       log.debug("merge successful");
/* 194:154 */       return result;
/* 195:    */     }
/* 196:    */     catch (RuntimeException re)
/* 197:    */     {
/* 198:156 */       log.error("merge failed", re);
/* 199:157 */       throw re;
/* 200:    */     }
/* 201:    */   }
/* 202:    */   
/* 203:    */   public void save(ShmtGranulometria transientInstance)
/* 204:    */   {
/* 205:161 */     log.debug("saving ShmtGranulometria instance");
/* 206:    */     try
/* 207:    */     {
/* 208:163 */       getSession().save(transientInstance);
/* 209:164 */       log.debug("save successful");
/* 210:    */     }
/* 211:    */     catch (RuntimeException re)
/* 212:    */     {
/* 213:166 */       log.error("save failed", re);
/* 214:167 */       throw re;
/* 215:    */     }
/* 216:    */   }
/* 217:    */ }


/* Location:           C:\Users\Luis\Desktop\CLXX\BalanceQL\Fuentes\
 * Qualified Name:     sia.bql.hibernate.sioperan.ShmtGranulometriaDAO
 * JD-Core Version:    0.7.0.1
 */