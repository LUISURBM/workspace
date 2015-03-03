/*  1:   */ package sia.bql.bean.seguridad;
/*  2:   */ 
/*  3:   */ import java.io.Serializable;
/*  4:   */ 
/*  5:   */ public final class AuthenticationBean
/*  6:   */   implements Serializable
/*  7:   */ {
/*  8:   */   private static final long serialVersionUID = 1L;
/*  9:   */   private Long userId;
/* 10:   */   private String userName;
/* 11:   */   
/* 12:   */   public Long getUserId()
/* 13:   */   {
/* 14:12 */     return this.userId;
/* 15:   */   }
/* 16:   */   
/* 17:   */   public String getUserName()
/* 18:   */   {
/* 19:15 */     return this.userName;
/* 20:   */   }
/* 21:   */   
/* 22:   */   public void setUserId(Long userId)
/* 23:   */   {
/* 24:18 */     this.userId = userId;
/* 25:   */   }
/* 26:   */   
/* 27:   */   public void setUserName(String userName)
/* 28:   */   {
/* 29:21 */     this.userName = userName;
/* 30:   */   }
/* 31:   */ }


/* Location:           C:\Users\Luis\Desktop\CLXX\BalanceQL\Fuentes\
 * Qualified Name:     sia.bql.bean.seguridad.AuthenticationBean
 * JD-Core Version:    0.7.0.1
 */