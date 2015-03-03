/*  1:   */ package sia.bql.hibernate.hidromet;
/*  2:   */ 
/*  3:   */ import common.Logger;
/*  4:   */ import java.io.Serializable;
/*  5:   */ import java.util.ArrayList;
/*  6:   */ import java.util.List;
/*  7:   */ import org.hibernate.Query;
/*  8:   */ import org.hibernate.Session;
/*  9:   */ import sia.bql.bean.util.Utiles;
/* 10:   */ import sia.bql.hibernate.HibernateSessionFactory;
/* 11:   */ import sia.bql.hibernate.sioperan.SiovEstacionesId;
/* 12:   */ import sia.bql.i18n.NombresTitulosAplicacion;
/* 13:   */ 
/* 14:   */ public class ShmtEstacionBalanceQl
/* 15:   */   extends AbstractShmtEstacionBalanceQl
/* 16:   */   implements Serializable
/* 17:   */ {
/* 18:23 */   private static Logger log = Logger.getLogger(ShmtEstacionBalanceQl.class);
/* 19:   */   private static final long serialVersionUID = 1L;
/* 20:   */   
/* 21:   */   public boolean isEstacionNivel()
/* 22:   */   {
/* 23:27 */     if (getEgbqPeso() != null) {
/* 24:28 */       return true;
/* 25:   */     }
/* 26:30 */     return false;
/* 27:   */   }
/* 28:   */   
/* 29:   */   public static ArrayList<ShmtEstacionBalanceQl> consultaEstacionEnGruposArea(Long grbcId)
/* 30:   */   {
/* 31:35 */     return (ArrayList)HibernateSessionFactory.currentSession()
/* 32:36 */       .getNamedQuery("consultaEstacionEnGruposArea")
/* 33:37 */       .setParameter("grupo", grbcId).list();
/* 34:   */   }
/* 35:   */   
/* 36:   */   public static ArrayList<ShmtEstacionBalanceQl> consultaEstacionEnGruposArea(Long grbcId, String var)
/* 37:   */   {
/* 38:43 */     if (var.equals(NombresTitulosAplicacion.NIVEL.nombreTitulo)) {
/* 39:44 */       var = "consultaEstacionEnGruposAreaNvl";
/* 40:46 */     } else if (var.equals(NombresTitulosAplicacion.PRECIPITACION.nombreTitulo)) {
/* 41:47 */       var = "consultaEstacionEnGruposAreaPm";
/* 42:   */     }
/* 43:49 */     return (ArrayList)HibernateSessionFactory.currentSession()
/* 44:50 */       .getNamedQuery(var).setParameter("grupo", grbcId).list();
/* 45:   */   }
/* 46:   */   
/* 47:   */   public ShmtEstacionBalanceQl(String nombre, String id, String idCatalogo, String categoria, Long idGrupo, String usuario, Long tipoEstacion)
/* 48:   */   {
/* 49:55 */     super(nombre, id, idCatalogo, categoria, idGrupo, usuario, tipoEstacion);
/* 50:   */   }
/* 51:   */   
/* 52:   */   public ShmtEstacionBalanceQl() {}
/* 53:   */   
/* 54:   */   public String getDisplayName()
/* 55:   */   {
/* 56:63 */     return 
/* 57:64 */       getEstacion().getCodCatalogoEs() + " " + getEstacion().getNombreEs();
/* 58:   */   }
/* 59:   */   
/* 60:   */   public List<ShmtDiarios> getSecuenciaDiarioCaudal()
/* 61:   */   {
/* 62:68 */     return getSecuenciaDiario(Utiles.getFechaInicio(), 
/* 63:69 */       Utiles.getFechaFin(), Utiles.obtenerVariableCaudal());
/* 64:   */   }
/* 65:   */   
/* 66:   */   public List<ShmtDiarios> getSecuenciaDiarioPrecipitacion()
/* 67:   */   {
/* 68:73 */     return getSecuenciaDiario(Utiles.getFechaInicio(), 
/* 69:74 */       Utiles.getFechaFin(), Utiles.obtenerVariablePrecipitacion());
/* 70:   */   }
/* 71:   */ }


/* Location:           C:\Users\Luis\Desktop\CLXX\BalanceQL\Fuentes\
 * Qualified Name:     sia.bql.hibernate.hidromet.ShmtEstacionBalanceQl
 * JD-Core Version:    0.7.0.1
 */