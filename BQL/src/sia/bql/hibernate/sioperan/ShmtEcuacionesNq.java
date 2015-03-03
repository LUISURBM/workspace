/*  1:   */ package sia.bql.hibernate.sioperan;
/*  2:   */ 
/*  3:   */ import java.io.Serializable;
/*  4:   */ import java.util.List;
/*  5:   */ import org.apache.commons.lang.math.NumberUtils;
/*  6:   */ import org.hibernate.Query;
/*  7:   */ import org.hibernate.Session;
/*  8:   */ import sia.bql.hibernate.HibernateSessionFactory;
/*  9:   */ 
/* 10:   */ public class ShmtEcuacionesNq
/* 11:   */   extends AbstractShmtEcuacionesNq
/* 12:   */   implements Serializable
/* 13:   */ {
/* 14:   */   private static final long serialVersionUID = 1L;
/* 15:   */   private Long ecnqId;
/* 16:   */   
/* 17:   */   public static double getNumeroEcuacion()
/* 18:   */   {
/* 19:15 */     return NumberUtils.toDouble((String)HibernateSessionFactory.currentSession().getNamedQuery("select max ecnqId from ShmtEcuacionesNq").list().get(0)) + 1.0D;
/* 20:   */   }
/* 21:   */   
/* 22:   */   public ShmtEcuacionesNq() {}
/* 23:   */   
/* 24:   */   public ShmtEcuacionesNq(Long ecnqId)
/* 25:   */   {
/* 26:21 */     this.ecnqId = ecnqId;
/* 27:   */   }
/* 28:   */   
/* 29:   */   public Long getEcnqId()
/* 30:   */   {
/* 31:24 */     return this.ecnqId;
/* 32:   */   }
/* 33:   */   
/* 34:   */   public void setEcnqId(Long ecnqId)
/* 35:   */   {
/* 36:27 */     this.ecnqId = ecnqId;
/* 37:   */   }
/* 38:   */ }


/* Location:           C:\Users\Luis\Desktop\CLXX\BalanceQL\Fuentes\
 * Qualified Name:     sia.bql.hibernate.sioperan.ShmtEcuacionesNq
 * JD-Core Version:    0.7.0.1
 */