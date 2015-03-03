/*  1:   */ package sia.bql.hibernate.sioperan;
/*  2:   */ 
/*  3:   */ import java.io.Serializable;
/*  4:   */ import java.util.List;
/*  5:   */ import org.hibernate.Query;
/*  6:   */ import org.hibernate.SQLQuery;
/*  7:   */ import org.hibernate.Session;
/*  8:   */ import sia.bql.hibernate.HibernateSessionFactory;
/*  9:   */ 
/* 10:   */ public class SiovEstacionesId
/* 11:   */   extends AbstractSiovEstacionesId
/* 12:   */   implements Serializable
/* 13:   */ {
/* 14:   */   private static final long serialVersionUID = 1L;
/* 15:   */   
/* 16:   */   public SiovEstacionesId() {}
/* 17:   */   
/* 18:   */   public SiovEstacionesId(String nombre, String id, String idCatalogo, String categoria)
/* 19:   */   {
/* 20:17 */     setNombreEs(nombre);
/* 21:18 */     setIdEs(Long.valueOf(id));
/* 22:19 */     setCodCatalogoEs(idCatalogo);
/* 23:20 */     setCategoriaEs(categoria);
/* 24:   */   }
/* 25:   */   
/* 26:   */   public static Long obtenerCodigoCatalogoEstacion(Long codigoEstacion)
/* 27:   */   {
/* 28:23 */     return (Long)HibernateSessionFactory.getSession()
/* 29:24 */       .getNamedQuery("obtenerCodigoCatalogoEstacion")
/* 30:25 */       .setParameter("codigoEstacion", codigoEstacion).uniqueResult();
/* 31:   */   }
/* 32:   */   
/* 33:   */   public static List<Object[]> obtenerEstaciones(Long areaH, Long zonaH, Long cuencaH, String variable, String egbqGrbcId)
/* 34:   */   {
/* 35:30 */     String vista = "SELECT distinct(e.NOMBRE_ES), e.CATEGORIA_ES, e.ID_ES,e.COD_CATALOGO_ES FROM SIOPERAN.SIOV_ESTACIONES e,  SIOPERAN.SIOV_DIVIPOLAS div , SIOPERAN.SIO_ORGANIZACION R, IDT_FAMILIES fam WHERE  R.ORGANIZACION_ID = E.ID_ORG AND R.TIPO = 'AOP' AND DIV.CODIGO_DV=E.CODIGO_DIVIPOLA and E.id_AREA = '" + 
/* 36:   */     
/* 37:32 */       areaH + 
/* 38:33 */       "'  and E.id_ZONA = '" + 
/* 39:34 */       zonaH + 
/* 40:35 */       "'  and E.id_SUBZONA = '" + 
/* 41:36 */       cuencaH + 
/* 42:37 */       "' and FML_FMTP_CODE = 'CTG_EST' ";
/* 43:38 */     String variables = " AND( ";
/* 44:40 */     if (variable.equals("nvl")) {
/* 45:41 */       variables = variables + "lower(FML_DESCRIPTION) LIKE lower('%Limni%') OR FML_DESCRIPTION LIKE ('%Hidrologica%'))";
/* 46:43 */     } else if (variable.equals("pm")) {
/* 47:44 */       variables = variables + "FML_DESCRIPTION LIKE '%Agrometeorologica%' OR FML_DESCRIPTION LIKE '%Climatologica%' OR FML_DESCRIPTION LIKE '%Meteorologica Especial%' OR FML_DESCRIPTION LIKE '%Pluvio%' OR FML_DESCRIPTION LIKE '%Sinoptica%')";
/* 48:   */     }
/* 49:51 */     vista = vista + variables;
/* 50:52 */     vista = vista + "and e.CATEGORIA_ES = fml_code and NOT exists (select egbq.egbq_estacion_id from Shmt_Estacion_balance_Ql egbq where egbq.egbq_estacion_id = e.ID_ES and egbq_grbc_id = " + egbqGrbcId + ") order by e.COD_CATALOGO_ES asc ";
/* 51:53 */     List<Object[]> estaciones = HibernateSessionFactory.currentSession().createSQLQuery(vista)
/* 52:54 */       .list();
/* 53:55 */     return estaciones;
/* 54:   */   }
/* 55:   */ }


/* Location:           C:\Users\Luis\Desktop\CLXX\BalanceQL\Fuentes\
 * Qualified Name:     sia.bql.hibernate.sioperan.SiovEstacionesId
 * JD-Core Version:    0.7.0.1
 */