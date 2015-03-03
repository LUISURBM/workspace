/*  1:   */ package sia.bql.hibernate.sioperan;
/*  2:   */ 
/*  3:   */ import java.util.Date;
/*  4:   */ 
/*  5:   */ public class AbstractShmtEcuacionesNq
/*  6:   */ {
/*  7:   */   private static final long serialVersionUID = 1L;
/*  8:   */   private String ecnqA;
/*  9:   */   private String ecnqB;
/* 10:   */   private String ecnqC;
/* 11:   */   private String ecnqR;
/* 12:   */   private Date ecnqTimestamp;
/* 13:   */   private String ecnqTipo;
/* 14:   */   private IdtUsers idtUsers;
/* 15:   */   private ShmtTablasConversion shmtTablasConversion;
/* 16:   */   
/* 17:   */   public String getEcnqA()
/* 18:   */   {
/* 19:13 */     return this.ecnqA;
/* 20:   */   }
/* 21:   */   
/* 22:   */   public String getEcnqB()
/* 23:   */   {
/* 24:16 */     return this.ecnqB;
/* 25:   */   }
/* 26:   */   
/* 27:   */   public String getEcnqC()
/* 28:   */   {
/* 29:19 */     return this.ecnqC;
/* 30:   */   }
/* 31:   */   
/* 32:   */   public String getEcnqR()
/* 33:   */   {
/* 34:22 */     return this.ecnqR;
/* 35:   */   }
/* 36:   */   
/* 37:   */   public Date getEcnqTimestamp()
/* 38:   */   {
/* 39:25 */     return this.ecnqTimestamp;
/* 40:   */   }
/* 41:   */   
/* 42:   */   public String getEcnqTipo()
/* 43:   */   {
/* 44:28 */     return this.ecnqTipo;
/* 45:   */   }
/* 46:   */   
/* 47:   */   public IdtUsers getIdtUsers()
/* 48:   */   {
/* 49:31 */     return this.idtUsers;
/* 50:   */   }
/* 51:   */   
/* 52:   */   public void setIdtUsers(IdtUsers idtUsers)
/* 53:   */   {
/* 54:34 */     this.idtUsers = idtUsers;
/* 55:   */   }
/* 56:   */   
/* 57:   */   public ShmtTablasConversion getShmtTablasConversion()
/* 58:   */   {
/* 59:37 */     return this.shmtTablasConversion;
/* 60:   */   }
/* 61:   */   
/* 62:   */   public void setEcnqA(String ecnqA)
/* 63:   */   {
/* 64:40 */     this.ecnqA = ecnqA;
/* 65:   */   }
/* 66:   */   
/* 67:   */   public void setEcnqB(String ecnqB)
/* 68:   */   {
/* 69:43 */     this.ecnqB = ecnqB;
/* 70:   */   }
/* 71:   */   
/* 72:   */   public void setEcnqC(String ecnqC)
/* 73:   */   {
/* 74:46 */     this.ecnqC = ecnqC;
/* 75:   */   }
/* 76:   */   
/* 77:   */   public void setEcnqR(String ecnqR)
/* 78:   */   {
/* 79:49 */     this.ecnqR = ecnqR;
/* 80:   */   }
/* 81:   */   
/* 82:   */   public void setEcnqTimestamp(Date ecnqTimestamp)
/* 83:   */   {
/* 84:52 */     this.ecnqTimestamp = ecnqTimestamp;
/* 85:   */   }
/* 86:   */   
/* 87:   */   public void setEcnqTipo(String ecnqTipo)
/* 88:   */   {
/* 89:55 */     this.ecnqTipo = ecnqTipo;
/* 90:   */   }
/* 91:   */   
/* 92:   */   public void setShmtTablasConversion(ShmtTablasConversion shmtTablasConversion)
/* 93:   */   {
/* 94:58 */     this.shmtTablasConversion = shmtTablasConversion;
/* 95:   */   }
/* 96:   */ }


/* Location:           C:\Users\Luis\Desktop\CLXX\BalanceQL\Fuentes\
 * Qualified Name:     sia.bql.hibernate.sioperan.AbstractShmtEcuacionesNq
 * JD-Core Version:    0.7.0.1
 */