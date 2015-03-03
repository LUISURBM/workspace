/*  1:   */ package sia.bql.hibernate.sioperan;
/*  2:   */ 
/*  3:   */ import java.io.Serializable;
/*  4:   */ import java.util.List;
/*  5:   */ import org.hibernate.Query;
/*  6:   */ import org.hibernate.Session;
/*  7:   */ import sia.bql.hibernate.HibernateSessionFactory;
/*  8:   */ 
/*  9:   */ public class IdtInstruments
/* 10:   */   extends AbstractIdtInstruments
/* 11:   */   implements Serializable
/* 12:   */ {
/* 13:   */   private static final long serialVersionUID = 1L;
/* 14:   */   
/* 15:   */   public static List<IdtInstruments> obtenerTipoEquipo()
/* 16:   */   {
/* 17:11 */     return HibernateSessionFactory.getSession().getNamedQuery("tipoEquipo").list();
/* 18:   */   }
/* 19:   */ }


/* Location:           C:\Users\Luis\Desktop\CLXX\BalanceQL\Fuentes\
 * Qualified Name:     sia.bql.hibernate.sioperan.IdtInstruments
 * JD-Core Version:    0.7.0.1
 */