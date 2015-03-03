/*  1:   */ package sia.bql.hibernate.hidromet;
/*  2:   */ 
/*  3:   */ import java.io.Serializable;
/*  4:   */ import java.util.List;
/*  5:   */ import org.hibernate.Query;
/*  6:   */ import org.hibernate.Session;
/*  7:   */ import sia.bql.hibernate.HibernateSessionFactory;
/*  8:   */ 
/*  9:   */ public class HmstPath
/* 10:   */   extends AbstractHmstPath
/* 11:   */   implements Serializable
/* 12:   */ {
/* 13:   */   private static final long serialVersionUID = 1L;
/* 14:   */   
/* 15:   */   public static HmstPath obtenerDirectoriosFtp(String componente)
/* 16:   */   {
/* 17:14 */     if (componente == null)
/* 18:   */     {
/* 19:15 */       componente = "0";
/* 20:16 */       return null;
/* 21:   */     }
/* 22:18 */     if (componente.equals("---"))
/* 23:   */     {
/* 24:19 */       componente = "0";
/* 25:20 */       return null;
/* 26:   */     }
/* 27:22 */     return 
/* 28:   */     
/* 29:24 */       (HmstPath)HibernateSessionFactory.currentSession().getNamedQuery("consultaDirectorioFtp").setParameter("comp", componente).list().get(0);
/* 30:   */   }
/* 31:   */ }


/* Location:           C:\Users\Luis\Desktop\CLXX\BalanceQL\Fuentes\
 * Qualified Name:     sia.bql.hibernate.hidromet.HmstPath
 * JD-Core Version:    0.7.0.1
 */