/*  1:   */ package sia.bql.hibernate.sioperan;
/*  2:   */ 
/*  3:   */ import java.io.Serializable;
/*  4:   */ import java.util.Date;
/*  5:   */ 
/*  6:   */ public abstract class AbstractIdtUsers
/*  7:   */   implements Serializable
/*  8:   */ {
/*  9:   */   private static final long serialVersionUID = 1L;
/* 10:   */   private Long usrId;
/* 11:   */   private String usrName;
/* 12:   */   private String usrDescription;
/* 13:   */   private String usrPassword;
/* 14:   */   private String usrStatus;
/* 15:   */   private Date usrTimestamp;
/* 16:   */   private Long usrPrfId;
/* 17:   */   
/* 18:   */   public String getUsrDescription()
/* 19:   */   {
/* 20:18 */     return this.usrDescription;
/* 21:   */   }
/* 22:   */   
/* 23:   */   public Long getUsrId()
/* 24:   */   {
/* 25:21 */     return this.usrId;
/* 26:   */   }
/* 27:   */   
/* 28:   */   public String getUsrName()
/* 29:   */   {
/* 30:24 */     return this.usrName;
/* 31:   */   }
/* 32:   */   
/* 33:   */   public String getUsrPassword()
/* 34:   */   {
/* 35:27 */     return this.usrPassword;
/* 36:   */   }
/* 37:   */   
/* 38:   */   public Long getUsrPrfId()
/* 39:   */   {
/* 40:30 */     return this.usrPrfId;
/* 41:   */   }
/* 42:   */   
/* 43:   */   public String getUsrStatus()
/* 44:   */   {
/* 45:33 */     return this.usrStatus;
/* 46:   */   }
/* 47:   */   
/* 48:   */   public Date getUsrTimestamp()
/* 49:   */   {
/* 50:36 */     return this.usrTimestamp;
/* 51:   */   }
/* 52:   */   
/* 53:   */   public void setUsrDescription(String usrDescription)
/* 54:   */   {
/* 55:39 */     this.usrDescription = usrDescription;
/* 56:   */   }
/* 57:   */   
/* 58:   */   public void setUsrId(Long usrId)
/* 59:   */   {
/* 60:42 */     this.usrId = usrId;
/* 61:   */   }
/* 62:   */   
/* 63:   */   public void setUsrName(String usrName)
/* 64:   */   {
/* 65:45 */     this.usrName = usrName;
/* 66:   */   }
/* 67:   */   
/* 68:   */   public void setUsrPassword(String usrPassword)
/* 69:   */   {
/* 70:48 */     this.usrPassword = usrPassword;
/* 71:   */   }
/* 72:   */   
/* 73:   */   public void setUsrPrfId(Long usrPrfId)
/* 74:   */   {
/* 75:51 */     this.usrPrfId = usrPrfId;
/* 76:   */   }
/* 77:   */   
/* 78:   */   public void setUsrStatus(String usrStatus)
/* 79:   */   {
/* 80:54 */     this.usrStatus = usrStatus;
/* 81:   */   }
/* 82:   */   
/* 83:   */   public void setUsrTimestamp(Date usrTimestamp)
/* 84:   */   {
/* 85:57 */     this.usrTimestamp = usrTimestamp;
/* 86:   */   }
/* 87:   */ }


/* Location:           C:\Users\Luis\Desktop\CLXX\BalanceQL\Fuentes\
 * Qualified Name:     sia.bql.hibernate.sioperan.AbstractIdtUsers
 * JD-Core Version:    0.7.0.1
 */