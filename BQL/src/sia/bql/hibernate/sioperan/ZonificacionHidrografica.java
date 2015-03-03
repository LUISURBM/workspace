/*  1:   */ package sia.bql.hibernate.sioperan;
/*  2:   */ 
/*  3:   */ import com.ada.ideam.siia.comunes.hibernate.ShmtZonificacionHidrografica;
/*  4:   */ import java.util.ArrayList;
/*  5:   */ import java.util.List;
/*  6:   */ import org.apache.commons.logging.Log;
/*  7:   */ import org.apache.commons.logging.LogFactory;
/*  8:   */ import org.hibernate.Query;
/*  9:   */ import org.hibernate.Session;
/* 10:   */ import sia.bql.hibernate.HibernateSessionFactory;
/* 11:   */ 
/* 12:   */ public class ZonificacionHidrografica
/* 13:   */   extends ShmtZonificacionHidrografica
/* 14:   */ {
/* 15:   */   private static final long serialVersionUID = 1L;
/* 16:18 */   protected static final Log log = LogFactory.getLog(ZonificacionHidrografica.class);
/* 17:   */   
/* 18:   */   public static List<Object[]> obtenerAreHidrog()
/* 19:   */   {
/* 20:20 */     String query = "select z.znhdId, z.znhdNombre from   ShmtZonificacionHidrografica  z  where  z.znhdFmlCode =  'AREA_HDG'";
/* 21:21 */     log.debug(query);
/* 22:22 */     Query q = HibernateSessionFactory.currentSession().createSQLQuery(query);
/* 23:23 */     List<Object[]> listObject = q.list();
/* 24:24 */     return listObject;
/* 25:   */   }
/* 26:   */   
/* 27:   */   public static List<Object[]> obtenerZonaXProperty(String tipo, String key)
/* 28:   */   {
/* 29:   */     try
/* 30:   */     {
/* 31:29 */       String queryString = "SELECT nombre, ";
/* 32:30 */       String queryStringEnd = " from SioCuencasHidrograficas where tipo = '";
/* 33:31 */       String clase = " AND CLASE = '";
/* 34:32 */       log.debug("key '" + key + "' tipo " + tipo);
/* 35:33 */       if (key == "---") {
/* 36:34 */         return null;
/* 37:   */       }
/* 38:36 */       if (key == "") {
/* 39:37 */         return null;
/* 40:   */       }
/* 41:39 */       if (tipo.equals("ARE")) {
/* 42:40 */         queryString = queryString + "codigo  from SioCuencasHidrograficas where tipo = '" + tipo + "' " + " AND CLASE = '" + "MAC'";
/* 43:   */       }
/* 44:42 */       if (tipo.equals("ZON")) {
/* 45:43 */         queryString = queryString + "codigo , cuencaHidrograficaId  from SioCuencasHidrograficas where tipo = '" + tipo + "' " + " AND CLASE = '" + "CUE' AND cuencaPadreId = '" + key + "'";
/* 46:   */       }
/* 47:45 */       if (tipo.equals("SBZ")) {
/* 48:46 */         queryString = queryString + "codigo  from SioCuencasHidrograficas where tipo = '" + tipo + "' " + " AND CLASE = '" + "MIC' AND cuencaPadreId = '" + key + "'";
/* 49:   */       }
/* 50:49 */       Session session = HibernateSessionFactory.currentSession();
/* 51:50 */       if (queryString.contains("---")) {
/* 52:51 */         return null;
/* 53:   */       }
/* 54:53 */       log.debug("Key '" + key + "' " + queryString);
/* 55:54 */       List<Object[]> queryObjectUniqueResult = session.createQuery(queryString).list();
/* 56:55 */       if (queryObjectUniqueResult == null) {
/* 57:56 */         return new ArrayList();
/* 58:   */       }
/* 59:57 */       return queryObjectUniqueResult;
/* 60:   */     }
/* 61:   */     catch (RuntimeException re)
/* 62:   */     {
/* 63:59 */       throw re;
/* 64:   */     }
/* 65:   */   }
/* 66:   */   
/* 67:   */   public static List<Object[]> obtenerEstacHidrograf(String nomArea, String nomZona, String nomSubZona)
/* 68:   */   {
/* 69:63 */     if (nomArea == null)
/* 70:   */     {
/* 71:64 */       nomArea = "0";
/* 72:65 */       return null;
/* 73:   */     }
/* 74:67 */     if (nomZona == null)
/* 75:   */     {
/* 76:68 */       nomZona = "0";
/* 77:69 */       return null;
/* 78:   */     }
/* 79:71 */     if (nomSubZona == null)
/* 80:   */     {
/* 81:72 */       nomSubZona = "0";
/* 82:73 */       return null;
/* 83:   */     }
/* 84:75 */     if (nomArea.equals(""))
/* 85:   */     {
/* 86:76 */       nomArea = "0";
/* 87:77 */       return null;
/* 88:   */     }
/* 89:79 */     if (nomZona.equals(""))
/* 90:   */     {
/* 91:80 */       nomZona = "0";
/* 92:81 */       return null;
/* 93:   */     }
/* 94:83 */     if (nomSubZona.equals(""))
/* 95:   */     {
/* 96:84 */       nomSubZona = "0";
/* 97:85 */       return null;
/* 98:   */     }
/* 99:87 */     String query = "SELECT e.cod_catalogo_es ,e.NOMBRE_ES FROM SIOPERAN.SIOV_ESTACIONES e,  SIOPERAN.SIOV_DIVIPOLAS div , SIOPERAN.SIO_ORGANIZACION R WHERE  R.ORGANIZACION_ID = E.ID_ORG AND R.TIPO = 'AOP' AND DIV.CODIGO_DV=E.CODIGO_DIVIPOLA  and E.ID_AREA = '" + nomArea + "' " + " and E.ID_ZONA = '" + nomZona + "' " + " and E.ID_SUBZONA = '" + nomSubZona + "' ";
/* :0:88 */     Query q = HibernateSessionFactory.currentSession().createSQLQuery(query);
/* :1:89 */     List<Object[]> listObject = q.list();
/* :2:90 */     log.debug(query);
/* :3:91 */     return listObject;
/* :4:   */   }
/* :5:   */ }


/* Location:           C:\Users\Luis\Desktop\CLXX\BalanceQL\Fuentes\
 * Qualified Name:     sia.bql.hibernate.sioperan.ZonificacionHidrografica
 * JD-Core Version:    0.7.0.1
 */