/*  1:   */ package sia.bql.hibernate.sioperan;
/*  2:   */ 
/*  3:   */ import java.io.Serializable;
/*  4:   */ import java.util.List;
/*  5:   */ import org.hibernate.Query;
/*  6:   */ import org.hibernate.Session;
/*  7:   */ import sia.bql.hibernate.HibernateSessionFactory;
/*  8:   */ 
/*  9:   */ public class ShmtGranulometria
/* 10:   */   extends AbstractShmtGranulometria
/* 11:   */   implements Serializable
/* 12:   */ {
/* 13:   */   private static final long serialVersionUID = 1L;
/* 14:   */   
/* 15:   */   public static List<ShmtGranulometria> obtenerMuestraGranulometriaXEstacion(Long estId)
/* 16:   */   {
/* 17:14 */     return HibernateSessionFactory.getSession().getNamedQuery("muestraGranulometriaPorEstacion").setParameter("estacion", estId).list();
/* 18:   */   }
/* 19:   */ }


/* Location:           C:\Users\Luis\Desktop\CLXX\BalanceQL\Fuentes\
 * Qualified Name:     sia.bql.hibernate.sioperan.ShmtGranulometria
 * JD-Core Version:    0.7.0.1
 */