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
/*  12:    */ public class SioEstacionesDAO
/*  13:    */   extends BaseHibernateDAO
/*  14:    */ {
/*  15: 12 */   private static final Log log = LogFactory.getLog(SioEstacionesDAO.class);
/*  16:    */   public static final String TIPO = "tipo";
/*  17:    */   public static final String ESCALA = "escala";
/*  18:    */   public static final String CODIGO_INTERNO = "codigoInterno";
/*  19:    */   public static final String SAT_ENLACE = "satEnlace";
/*  20:    */   public static final String SAT_TIPO = "satTipo";
/*  21:    */   public static final String ALTURA_REFERENCIA = "alturaReferencia";
/*  22:    */   public static final String SAT_NOMBRE = "satNombre";
/*  23:    */   public static final String CLASE = "clase";
/*  24:    */   public static final String CATEGORIA = "categoria";
/*  25:    */   public static final String SAT_PROTOCOLO = "satProtocolo";
/*  26:    */   public static final String COMENTARIO_INSTALACION = "comentarioInstalacion";
/*  27:    */   public static final String SAT_VENTANA = "satVentana";
/*  28:    */   public static final String NOMBRE = "nombre";
/*  29:    */   public static final String OBJETIVO_INSTALACION = "objetivoInstalacion";
/*  30:    */   public static final String CODIGO_REPORTE = "codigoReporte";
/*  31:    */   public static final String CODIGO_INTERNACIONAL = "codigoInternacional";
/*  32:    */   public static final String CODIGO_CATALOGO = "codigoCatalogo";
/*  33:    */   public static final String ESTADO = "estado";
/*  34:    */   public static final String CODIGO_OACI = "codigoOaci";
/*  35:    */   public static final String CODIGO_WMO = "codigoWmo";
/*  36:    */   
/*  37:    */   public void save(SioEstaciones transientInstance)
/*  38:    */   {
/*  39: 35 */     log.debug("saving SioEstaciones instance");
/*  40:    */     try
/*  41:    */     {
/*  42: 37 */       getSession().save(transientInstance);
/*  43: 38 */       log.debug("save successful");
/*  44:    */     }
/*  45:    */     catch (RuntimeException re)
/*  46:    */     {
/*  47: 40 */       log.error("save failed", re);
/*  48: 41 */       throw re;
/*  49:    */     }
/*  50:    */   }
/*  51:    */   
/*  52:    */   public void delete(SioEstaciones persistentInstance)
/*  53:    */   {
/*  54: 45 */     log.debug("deleting SioEstaciones instance");
/*  55:    */     try
/*  56:    */     {
/*  57: 47 */       getSession().delete(persistentInstance);
/*  58: 48 */       log.debug("delete successful");
/*  59:    */     }
/*  60:    */     catch (RuntimeException re)
/*  61:    */     {
/*  62: 50 */       log.error("delete failed", re);
/*  63: 51 */       throw re;
/*  64:    */     }
/*  65:    */   }
/*  66:    */   
/*  67:    */   public SioEstaciones findById(Long id)
/*  68:    */   {
/*  69: 55 */     log.debug("getting SioEstaciones instance with id: " + id);
/*  70:    */     try
/*  71:    */     {
/*  72: 57 */       return (SioEstaciones)getSession().get("sia.hibernate.SioEstaciones", id);
/*  73:    */     }
/*  74:    */     catch (RuntimeException re)
/*  75:    */     {
/*  76: 60 */       log.error("get failed", re);
/*  77: 61 */       throw re;
/*  78:    */     }
/*  79:    */   }
/*  80:    */   
/*  81:    */   public List findByExample(SioEstaciones instance)
/*  82:    */   {
/*  83: 65 */     log.debug("finding SioEstaciones instance by example");
/*  84:    */     try
/*  85:    */     {
/*  86: 67 */       List results = getSession().createCriteria("sia.hibernate.SioEstaciones").add(Example.create(instance)).list();
/*  87: 68 */       log.debug("find by example successful, result size: " + results.size());
/*  88: 69 */       return results;
/*  89:    */     }
/*  90:    */     catch (RuntimeException re)
/*  91:    */     {
/*  92: 71 */       log.error("find by example failed", re);
/*  93: 72 */       throw re;
/*  94:    */     }
/*  95:    */   }
/*  96:    */   
/*  97:    */   public List findByProperty(String propertyName, Object value)
/*  98:    */   {
/*  99: 76 */     log.debug("finding SioEstaciones instance with property: " + propertyName + ", value: " + value);
/* 100:    */     try
/* 101:    */     {
/* 102: 78 */       String queryString = "from SioEstaciones as model where model." + propertyName + "= ?";
/* 103: 79 */       Query queryObject = getSession().createQuery(queryString);
/* 104: 80 */       queryObject.setParameter(0, value);
/* 105: 81 */       return queryObject.list();
/* 106:    */     }
/* 107:    */     catch (RuntimeException re)
/* 108:    */     {
/* 109: 83 */       log.error("find by property name failed", re);
/* 110: 84 */       throw re;
/* 111:    */     }
/* 112:    */   }
/* 113:    */   
/* 114:    */   public List findByTipo(Object tipo)
/* 115:    */   {
/* 116: 88 */     return findByProperty("tipo", tipo);
/* 117:    */   }
/* 118:    */   
/* 119:    */   public List findByEscala(Object escala)
/* 120:    */   {
/* 121: 91 */     return findByProperty("escala", escala);
/* 122:    */   }
/* 123:    */   
/* 124:    */   public List findByCodigoInterno(Object codigoInterno)
/* 125:    */   {
/* 126: 94 */     return findByProperty("codigoInterno", codigoInterno);
/* 127:    */   }
/* 128:    */   
/* 129:    */   public List findBySatEnlace(Object satEnlace)
/* 130:    */   {
/* 131: 97 */     return findByProperty("satEnlace", satEnlace);
/* 132:    */   }
/* 133:    */   
/* 134:    */   public List findBySatTipo(Object satTipo)
/* 135:    */   {
/* 136:100 */     return findByProperty("satTipo", satTipo);
/* 137:    */   }
/* 138:    */   
/* 139:    */   public List findByAlturaReferencia(Object alturaReferencia)
/* 140:    */   {
/* 141:103 */     return findByProperty("alturaReferencia", alturaReferencia);
/* 142:    */   }
/* 143:    */   
/* 144:    */   public List findBySatNombre(Object satNombre)
/* 145:    */   {
/* 146:106 */     return findByProperty("satNombre", satNombre);
/* 147:    */   }
/* 148:    */   
/* 149:    */   public List findByClase(Object clase)
/* 150:    */   {
/* 151:109 */     return findByProperty("clase", clase);
/* 152:    */   }
/* 153:    */   
/* 154:    */   public List findByCategoria(Object categoria)
/* 155:    */   {
/* 156:112 */     return findByProperty("categoria", categoria);
/* 157:    */   }
/* 158:    */   
/* 159:    */   public List findBySatProtocolo(Object satProtocolo)
/* 160:    */   {
/* 161:115 */     return findByProperty("satProtocolo", satProtocolo);
/* 162:    */   }
/* 163:    */   
/* 164:    */   public List findByComentarioInstalacion(Object comentarioInstalacion)
/* 165:    */   {
/* 166:118 */     return findByProperty("comentarioInstalacion", comentarioInstalacion);
/* 167:    */   }
/* 168:    */   
/* 169:    */   public List findBySatVentana(Object satVentana)
/* 170:    */   {
/* 171:121 */     return findByProperty("satVentana", satVentana);
/* 172:    */   }
/* 173:    */   
/* 174:    */   public List findByNombre(Object nombre)
/* 175:    */   {
/* 176:124 */     return findByProperty("nombre", nombre);
/* 177:    */   }
/* 178:    */   
/* 179:    */   public List findByObjetivoInstalacion(Object objetivoInstalacion)
/* 180:    */   {
/* 181:127 */     return findByProperty("objetivoInstalacion", objetivoInstalacion);
/* 182:    */   }
/* 183:    */   
/* 184:    */   public List findByCodigoReporte(Object codigoReporte)
/* 185:    */   {
/* 186:130 */     return findByProperty("codigoReporte", codigoReporte);
/* 187:    */   }
/* 188:    */   
/* 189:    */   public List findByCodigoInternacional(Object codigoInternacional)
/* 190:    */   {
/* 191:133 */     return findByProperty("codigoInternacional", codigoInternacional);
/* 192:    */   }
/* 193:    */   
/* 194:    */   public List findByCodigoCatalogo(Object codigoCatalogo)
/* 195:    */   {
/* 196:136 */     return findByProperty("codigoCatalogo", codigoCatalogo);
/* 197:    */   }
/* 198:    */   
/* 199:    */   public List findByEstado(Object estado)
/* 200:    */   {
/* 201:139 */     return findByProperty("estado", estado);
/* 202:    */   }
/* 203:    */   
/* 204:    */   public List findByCodigoOaci(Object codigoOaci)
/* 205:    */   {
/* 206:142 */     return findByProperty("codigoOaci", codigoOaci);
/* 207:    */   }
/* 208:    */   
/* 209:    */   public List findByCodigoWmo(Object codigoWmo)
/* 210:    */   {
/* 211:145 */     return findByProperty("codigoWmo", codigoWmo);
/* 212:    */   }
/* 213:    */   
/* 214:    */   public SioEstaciones merge(SioEstaciones detachedInstance)
/* 215:    */   {
/* 216:148 */     log.debug("merging SioEstaciones instance");
/* 217:    */     try
/* 218:    */     {
/* 219:150 */       SioEstaciones result = (SioEstaciones)getSession().merge(detachedInstance);
/* 220:151 */       log.debug("merge successful");
/* 221:152 */       return result;
/* 222:    */     }
/* 223:    */     catch (RuntimeException re)
/* 224:    */     {
/* 225:154 */       log.error("merge failed", re);
/* 226:155 */       throw re;
/* 227:    */     }
/* 228:    */   }
/* 229:    */   
/* 230:    */   public void attachDirty(SioEstaciones instance)
/* 231:    */   {
/* 232:159 */     log.debug("attaching dirty SioEstaciones instance");
/* 233:    */     try
/* 234:    */     {
/* 235:161 */       getSession().saveOrUpdate(instance);
/* 236:162 */       log.debug("attach successful");
/* 237:    */     }
/* 238:    */     catch (RuntimeException re)
/* 239:    */     {
/* 240:164 */       log.error("attach failed", re);
/* 241:165 */       throw re;
/* 242:    */     }
/* 243:    */   }
/* 244:    */   
/* 245:    */   public void attachClean(SioEstaciones instance)
/* 246:    */   {
/* 247:169 */     log.debug("attaching clean SioEstaciones instance");
/* 248:    */     try
/* 249:    */     {
/* 250:171 */       getSession().lock(instance, LockMode.NONE);
/* 251:172 */       log.debug("attach successful");
/* 252:    */     }
/* 253:    */     catch (RuntimeException re)
/* 254:    */     {
/* 255:174 */       log.error("attach failed", re);
/* 256:175 */       throw re;
/* 257:    */     }
/* 258:    */   }
/* 259:    */ }


/* Location:           C:\Users\Luis\Desktop\CLXX\BalanceQL\Fuentes\
 * Qualified Name:     sia.bql.hibernate.sioperan.SioEstacionesDAO
 * JD-Core Version:    0.7.0.1
 */