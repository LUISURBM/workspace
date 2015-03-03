/*   1:    */ package sia.bql.hibernate.hidromet;
/*   2:    */ 
/*   3:    */ import java.io.Serializable;
/*   4:    */ import java.util.ArrayList;
/*   5:    */ import java.util.Calendar;
/*   6:    */ import java.util.GregorianCalendar;
/*   7:    */ import java.util.List;
/*   8:    */ import java.util.Set;
/*   9:    */ import javax.faces.model.SelectItem;
/*  10:    */ import org.apache.commons.logging.Log;
/*  11:    */ import org.apache.commons.logging.LogFactory;
/*  12:    */ import org.hibernate.Query;
/*  13:    */ import org.hibernate.SQLQuery;
/*  14:    */ import org.hibernate.Session;
/*  15:    */ import sia.bql.bean.util.Utiles;
/*  16:    */ import sia.bql.hibernate.HibernateSessionFactory;
/*  17:    */ import sia.bql.hibernate.sioperan.SioCuencasHidrograficas;
/*  18:    */ 
/*  19:    */ public class ShmtGrupoBalanceCaudal
/*  20:    */   extends AbstractShmtGrupoBalanceCaudal
/*  21:    */   implements Serializable
/*  22:    */ {
/*  23:    */   private static final long serialVersionUID = 1L;
/*  24: 27 */   private static final Log log = LogFactory.getLog(ShmtGrupoBalanceCaudal.class);
/*  25:    */   
/*  26:    */   public ShmtGrupoBalanceCaudal(String nuevoAreaOperativa, SioCuencasHidrograficas cuenca, Long numero, String extension, String usuario)
/*  27:    */   {
/*  28: 31 */     setAreaOperativa(Long.valueOf(nuevoAreaOperativa));
/*  29: 32 */     setGrbcNumero(numero);
/*  30: 33 */     setCuenca(cuenca);
/*  31: 34 */     setGrbcGrafo(extension);
/*  32: 35 */     setGrbcUsuario(Long.valueOf(usuario));
/*  33: 36 */     setGrbcFecha(GregorianCalendar.getInstance().getTime());
/*  34:    */   }
/*  35:    */   
/*  36:    */   public ShmtGrupoBalanceCaudal() {}
/*  37:    */   
/*  38:    */   public static ArrayList<ShmtGrupoBalanceCaudal> obtenerGruposAreasOperativas(String areaOperativa)
/*  39:    */   {
/*  40: 47 */     if (areaOperativa == null)
/*  41:    */     {
/*  42: 48 */       areaOperativa = "0";
/*  43: 49 */       return null;
/*  44:    */     }
/*  45: 51 */     if (areaOperativa.equals("---"))
/*  46:    */     {
/*  47: 52 */       areaOperativa = "0";
/*  48: 53 */       return null;
/*  49:    */     }
/*  50: 56 */     return (ArrayList)HibernateSessionFactory.currentSession()
/*  51: 57 */       .getNamedQuery("consultaGruposEnArea")
/*  52: 58 */       .setParameter("area", Long.valueOf(Long.parseLong(areaOperativa))).list();
/*  53:    */   }
/*  54:    */   
/*  55:    */   public static ArrayList<ShmtGrupoBalanceCaudal> obtenerGruposAreasOperativas(String areaOperativa, String cuenca, String grupo, String año)
/*  56:    */   {
/*  57: 66 */     if (!Utiles.validarParametro(areaOperativa)) {
/*  58: 67 */       return null;
/*  59:    */     }
/*  60: 68 */     if (!Utiles.validarParametro(cuenca)) {
/*  61: 69 */       return null;
/*  62:    */     }
/*  63: 70 */     if (!Utiles.validarParametro(grupo)) {
/*  64: 71 */       return null;
/*  65:    */     }
/*  66: 72 */     if (!Utiles.validarParametro(año)) {
/*  67: 73 */       return null;
/*  68:    */     }
/*  69: 76 */     return (ArrayList)HibernateSessionFactory.currentSession()
/*  70: 77 */       .getNamedQuery("consultaGruposEnAreaAño")
/*  71: 78 */       .setParameter("area", Long.valueOf(Long.parseLong(areaOperativa)))
/*  72: 79 */       .setParameter("cuenca", Long.valueOf(Long.parseLong(cuenca)))
/*  73: 80 */       .setParameter("grupo", Long.valueOf(Long.parseLong(grupo))).uniqueResult();
/*  74:    */   }
/*  75:    */   
/*  76:    */   public static List<ShmtGrupoBalanceCaudal> obtenerGruposAreasCuenca(String nuevoAreaOperativa, String nuevoCuenca)
/*  77:    */   {
/*  78: 86 */     if (nuevoAreaOperativa == null)
/*  79:    */     {
/*  80: 87 */       nuevoAreaOperativa = "0";
/*  81: 88 */       return null;
/*  82:    */     }
/*  83: 90 */     if (nuevoAreaOperativa.equals("---"))
/*  84:    */     {
/*  85: 91 */       nuevoAreaOperativa = "0";
/*  86: 92 */       return null;
/*  87:    */     }
/*  88: 94 */     if (nuevoAreaOperativa.equals(""))
/*  89:    */     {
/*  90: 95 */       nuevoAreaOperativa = "0";
/*  91: 96 */       return null;
/*  92:    */     }
/*  93: 98 */     if (nuevoCuenca == null)
/*  94:    */     {
/*  95: 99 */       nuevoCuenca = "0";
/*  96:100 */       return null;
/*  97:    */     }
/*  98:102 */     if (nuevoCuenca.equals("---"))
/*  99:    */     {
/* 100:103 */       nuevoCuenca = "0";
/* 101:104 */       return null;
/* 102:    */     }
/* 103:106 */     if (nuevoCuenca.equals(""))
/* 104:    */     {
/* 105:107 */       nuevoAreaOperativa = "0";
/* 106:108 */       return null;
/* 107:    */     }
/* 108:110 */     return (ArrayList)HibernateSessionFactory.currentSession()
/* 109:111 */       .getNamedQuery("consultaGruposEnAreaCuenca")
/* 110:112 */       .setParameter("area", Long.valueOf(Long.parseLong(nuevoAreaOperativa)))
/* 111:113 */       .setParameter("cuenca", Long.valueOf(Long.parseLong(nuevoCuenca))).list();
/* 112:    */   }
/* 113:    */   
/* 114:    */   public static void delete(ShmtGrupoBalanceCaudal persistentInstance)
/* 115:    */   {
/* 116:117 */     log.debug("deleting ShmtGrupoBalanceCaudal instance");
/* 117:    */     try
/* 118:    */     {
/* 119:119 */       HibernateSessionFactory.currentSession().delete(persistentInstance);
/* 120:120 */       log.debug("delete successful");
/* 121:    */     }
/* 122:    */     catch (RuntimeException re)
/* 123:    */     {
/* 124:122 */       log.error("delete failed", re);
/* 125:123 */       throw re;
/* 126:    */     }
/* 127:    */   }
/* 128:    */   
/* 129:    */   public static ShmtGrupoBalanceCaudal merge(ShmtGrupoBalanceCaudal detachedInstance)
/* 130:    */   {
/* 131:129 */     log.debug("merging ShmtGrupoBalanceCaudal instance");
/* 132:    */     try
/* 133:    */     {
/* 134:131 */       ShmtGrupoBalanceCaudal result = (ShmtGrupoBalanceCaudal)HibernateSessionFactory.currentSession()
/* 135:132 */         .merge(detachedInstance);
/* 136:133 */       log.debug("merge successful");
/* 137:134 */       return result;
/* 138:    */     }
/* 139:    */     catch (RuntimeException re)
/* 140:    */     {
/* 141:136 */       log.error("merge failed", re);
/* 142:137 */       throw re;
/* 143:    */     }
/* 144:    */   }
/* 145:    */   
/* 146:    */   public static void save(ShmtGrupoBalanceCaudal transientInstance)
/* 147:    */   {
/* 148:142 */     log.debug("saving ShmtGrupoBalanceCaudal instance");
/* 149:    */     try
/* 150:    */     {
/* 151:144 */       HibernateSessionFactory.currentSession().save(transientInstance);
/* 152:145 */       log.debug("save successful");
/* 153:    */     }
/* 154:    */     catch (RuntimeException re)
/* 155:    */     {
/* 156:147 */       log.error("save failed", re);
/* 157:148 */       throw re;
/* 158:    */     }
/* 159:    */   }
/* 160:    */   
/* 161:    */   public String getNombreGrafo()
/* 162:    */   {
/* 163:154 */     return 
/* 164:    */     
/* 165:156 */       getGrbcUsuario().toString() + getAreaOperativa().toString() + getCuenca().getCuencaHidrograficaId().toString() + getGrbcId() + "." + getGrbcGrafo();
/* 166:    */   }
/* 167:    */   
/* 168:    */   public String getNameDisplay()
/* 169:    */   {
/* 170:160 */     return 
/* 171:161 */       getCuenca().getNombre() + " (GRUPO " + getGrbcNumero() + ")";
/* 172:    */   }
/* 173:    */   
/* 174:    */   public static void retirarEstaciones(Set<Object> itemsEstacionesEnGruposBalanceAreaBorrado, Long selectedGrupo, String selectedAreaOperativa)
/* 175:    */     throws Exception
/* 176:    */   {
/* 177:168 */     for (Object objects : itemsEstacionesEnGruposBalanceAreaBorrado) {
/* 178:173 */       HibernateSessionFactory.currentSession().createSQLQuery("DELETE FROM SHMT_ESTACION_BALANCE_QL WHERE  EGBQ_ID = " + ((SelectItem)objects).getValue() + " AND EGBQ_GRBC_ID = " + selectedGrupo).executeUpdate();
/* 179:    */     }
/* 180:    */   }
/* 181:    */   
/* 182:    */   public static void retirarGrupos(Set<Object> itemsGruposBalanceAreaBorrado)
/* 183:    */     throws Exception
/* 184:    */   {
/* 185:179 */     for (Object objects : itemsGruposBalanceAreaBorrado) {
/* 186:183 */       HibernateSessionFactory.currentSession().createSQLQuery("DELETE FROM SHMT_GRUPO_BALANCE_CAUDAL WHERE  GRBC_ID = " + ((SelectItem)objects).getValue()).executeUpdate();
/* 187:    */     }
/* 188:    */   }
/* 189:    */   
/* 190:    */   public static ShmtGrupoBalanceCaudal obtenerGrupo(String selectedAreaOperativa, Long nuevaCuenca, Long numero)
/* 191:    */     throws Exception
/* 192:    */   {
/* 193:191 */     return (ShmtGrupoBalanceCaudal)HibernateSessionFactory.currentSession().createQuery("SELECT G FROM ShmtGrupoBalanceCaudal as G WHERE G.areaOperativa = '" + selectedAreaOperativa + "' " + 
/* 194:192 */       "AND G.cuenca.cuencaHidrograficaId = " + nuevaCuenca + " AND G.grbcNumero = '" + numero + "'").uniqueResult();
/* 195:    */   }
/* 196:    */ }


/* Location:           C:\Users\Luis\Desktop\CLXX\BalanceQL\Fuentes\
 * Qualified Name:     sia.bql.hibernate.hidromet.ShmtGrupoBalanceCaudal
 * JD-Core Version:    0.7.0.1
 */