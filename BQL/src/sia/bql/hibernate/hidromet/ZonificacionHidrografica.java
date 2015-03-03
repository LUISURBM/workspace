/*   1:    */ package sia.bql.hibernate.hidromet;
/*   2:    */ 
/*   3:    */ import com.ada.ideam.siia.comunes.hibernate.ShmtZonificacionHidrografica;
/*   4:    */ import java.util.ArrayList;
/*   5:    */ import java.util.List;
/*   6:    */ import org.apache.commons.logging.Log;
/*   7:    */ import org.apache.commons.logging.LogFactory;
/*   8:    */ import org.hibernate.Query;
/*   9:    */ import org.hibernate.Session;
/*  10:    */ import sia.bql.hibernate.HibernateSessionFactory;
/*  11:    */ 
/*  12:    */ public class ZonificacionHidrografica
/*  13:    */   extends ShmtZonificacionHidrografica
/*  14:    */ {
/*  15:    */   private static final long serialVersionUID = 1L;
/*  16: 20 */   protected static final Log log = LogFactory.getLog(ZonificacionHidrografica.class);
/*  17:    */   
/*  18:    */   public static List<Object[]> obtenerAreHidrog()
/*  19:    */   {
/*  20: 23 */     String query = "select z.znhdId, z.znhdNombre from   ShmtZonificacionHidrografica  z  where  z.znhdFmlCode =  'AREA_HDG'";
/*  21:    */     
/*  22:    */ 
/*  23: 26 */     log.debug(query);
/*  24: 27 */     Query q = HibernateSessionFactory.currentSession()
/*  25: 28 */       .createSQLQuery(query);
/*  26: 29 */     List<Object[]> listObject = q.list();
/*  27: 30 */     return listObject;
/*  28:    */   }
/*  29:    */   
/*  30:    */   public static List<Object[]> obtenerZonaXProperty(String tipo, String key)
/*  31:    */   {
/*  32:    */     try
/*  33:    */     {
/*  34: 37 */       String queryString = "SELECT nombre, ";
/*  35: 38 */       String queryStringEnd = " from SioCuencasHidrograficas where tipo = '";
/*  36: 39 */       String clase = " AND CLASE = '";
/*  37: 40 */       log.debug("key '" + key + "' tipo " + tipo);
/*  38: 41 */       if (key == "---") {
/*  39: 42 */         return null;
/*  40:    */       }
/*  41: 43 */       if (key == "") {
/*  42: 44 */         return null;
/*  43:    */       }
/*  44: 45 */       if (key == null) {
/*  45: 46 */         return null;
/*  46:    */       }
/*  47: 48 */       if (tipo.equals("ARE")) {
/*  48: 49 */         queryString = 
/*  49: 50 */           queryString + "codigo  from SioCuencasHidrograficas where tipo = '" + tipo + "' " + " AND CLASE = '" + "MAC'";
/*  50:    */       }
/*  51: 52 */       if (tipo.equals("ZON")) {
/*  52: 53 */         queryString = 
/*  53:    */         
/*  54: 55 */           queryString + "codigo , cuencaHidrograficaId  from SioCuencasHidrograficas where tipo = '" + tipo + "' " + " AND CLASE = '" + "CUE' AND cuencaPadreId = '" + key + "'";
/*  55:    */       }
/*  56: 57 */       if (tipo.equals("SBZ")) {
/*  57: 58 */         queryString = 
/*  58:    */         
/*  59: 60 */           queryString + "cuencaHidrograficaId, codigo  from SioCuencasHidrograficas where tipo = '" + tipo + "' " + " AND CLASE = '" + "MIC' AND cuencaPadreId = '" + key + "'";
/*  60:    */       }
/*  61: 63 */       Session session = HibernateSessionFactory.currentSession();
/*  62: 64 */       if (queryString.contains("---")) {
/*  63: 65 */         return null;
/*  64:    */       }
/*  65: 67 */       log.debug("Key '" + key + "' " + queryString);
/*  66: 68 */       List<Object[]> queryObjectUniqueResult = session.createQuery(
/*  67: 69 */         queryString).list();
/*  68: 70 */       if (queryObjectUniqueResult == null) {
/*  69: 71 */         return new ArrayList();
/*  70:    */       }
/*  71: 72 */       return queryObjectUniqueResult;
/*  72:    */     }
/*  73:    */     catch (RuntimeException re)
/*  74:    */     {
/*  75: 74 */       throw re;
/*  76:    */     }
/*  77:    */   }
/*  78:    */   
/*  79:    */   public static List<Object[]> obtenerEstacHidrograf(String nomArea, String nomZona, String nomSubZona)
/*  80:    */   {
/*  81: 80 */     if (nomArea == null)
/*  82:    */     {
/*  83: 81 */       nomArea = "0";
/*  84: 82 */       return null;
/*  85:    */     }
/*  86: 84 */     if (nomZona == null)
/*  87:    */     {
/*  88: 85 */       nomZona = "0";
/*  89: 86 */       return null;
/*  90:    */     }
/*  91: 88 */     if (nomSubZona == null)
/*  92:    */     {
/*  93: 89 */       nomSubZona = "0";
/*  94: 90 */       return null;
/*  95:    */     }
/*  96: 92 */     if (nomArea.equals(""))
/*  97:    */     {
/*  98: 93 */       nomArea = "0";
/*  99: 94 */       return null;
/* 100:    */     }
/* 101: 96 */     if (nomZona.equals(""))
/* 102:    */     {
/* 103: 97 */       nomZona = "0";
/* 104: 98 */       return null;
/* 105:    */     }
/* 106:100 */     if (nomSubZona.equals(""))
/* 107:    */     {
/* 108:101 */       nomSubZona = "0";
/* 109:102 */       return null;
/* 110:    */     }
/* 111:104 */     String query = "SELECT e.cod_catalogo_es ,e.NOMBRE_ES FROM SIOPERAN.SIOV_ESTACIONES e,  SIOPERAN.SIOV_DIVIPOLAS div , SIOPERAN.SIO_ORGANIZACION R WHERE  R.ORGANIZACION_ID = E.ID_ORG AND R.TIPO = 'AOP' AND DIV.CODIGO_DV=E.CODIGO_DIVIPOLA  and E.ID_AREA = '" + 
/* 112:    */     
/* 113:    */ 
/* 114:    */ 
/* 115:108 */       nomArea + "' " + " and E.ID_ZONA = '" + 
/* 116:109 */       nomZona + "' " + " and E.ID_SUBZONA = '" + nomSubZona + "' ";
/* 117:110 */     Query q = HibernateSessionFactory.currentSession().createSQLQuery(query);
/* 118:111 */     List<Object[]> listObject = q.list();
/* 119:112 */     log.debug(query);
/* 120:113 */     return listObject;
/* 121:    */   }
/* 122:    */   
/* 123:    */   public static Object[] obtenerZona(Long zonaH)
/* 124:    */   {
/* 125:117 */     if (zonaH == null) {
/* 126:118 */       return null;
/* 127:    */     }
/* 128:119 */     String queryString = "SELECT nombre,cuenca_hidrografica_id,cuenca_padre_id,codigo from Sio_Cuencas_Hidrograficas where cuenca_hidrografica_id = '" + 
/* 129:120 */       zonaH + "'";
/* 130:121 */     Query q = HibernateSessionFactory.currentSession().createSQLQuery(queryString);
/* 131:122 */     Object[] object = (Object[])q.uniqueResult();
/* 132:123 */     return object;
/* 133:    */   }
/* 134:    */ }


/* Location:           C:\Users\Luis\Desktop\CLXX\BalanceQL\Fuentes\
 * Qualified Name:     sia.bql.hibernate.hidromet.ZonificacionHidrografica
 * JD-Core Version:    0.7.0.1
 */