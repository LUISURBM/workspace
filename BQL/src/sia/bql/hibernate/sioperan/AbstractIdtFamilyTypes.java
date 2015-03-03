/*   1:    */ package sia.bql.hibernate.sioperan;
/*   2:    */ 
/*   3:    */ import java.io.Serializable;
/*   4:    */ import java.util.Date;
/*   5:    */ import java.util.HashSet;
/*   6:    */ import java.util.Set;
/*   7:    */ 
/*   8:    */ public abstract class AbstractIdtFamilyTypes
/*   9:    */   implements Serializable
/*  10:    */ {
/*  11:    */   private static final long serialVersionUID = 1L;
/*  12:    */   private String fmtpCode;
/*  13:    */   private String fmtpDescription;
/*  14:    */   private String fmtpName;
/*  15:    */   private Date fmtpTimestamp;
/*  16: 27 */   private Set idtFamilieses = new HashSet(0);
/*  17:    */   private IdtUsers idtUsers;
/*  18:    */   
/*  19:    */   public AbstractIdtFamilyTypes() {}
/*  20:    */   
/*  21:    */   public AbstractIdtFamilyTypes(String fmtpCode, IdtUsers idtUsers, String fmtpName, Date fmtpTimestamp)
/*  22:    */   {
/*  23: 48 */     this.fmtpCode = fmtpCode;
/*  24: 49 */     this.idtUsers = idtUsers;
/*  25: 50 */     this.fmtpName = fmtpName;
/*  26: 51 */     this.fmtpTimestamp = fmtpTimestamp;
/*  27:    */   }
/*  28:    */   
/*  29:    */   public AbstractIdtFamilyTypes(String fmtpCode, IdtUsers idtUsers, String fmtpName, String fmtpDescription, Date fmtpTimestamp, Set idtFamilieses)
/*  30:    */   {
/*  31: 70 */     this.fmtpCode = fmtpCode;
/*  32: 71 */     this.idtUsers = idtUsers;
/*  33: 72 */     this.fmtpName = fmtpName;
/*  34: 73 */     this.fmtpDescription = fmtpDescription;
/*  35: 74 */     this.fmtpTimestamp = fmtpTimestamp;
/*  36: 75 */     this.idtFamilieses = idtFamilieses;
/*  37:    */   }
/*  38:    */   
/*  39:    */   public String getFmtpCode()
/*  40:    */   {
/*  41: 84 */     return this.fmtpCode;
/*  42:    */   }
/*  43:    */   
/*  44:    */   public String getFmtpDescription()
/*  45:    */   {
/*  46: 92 */     return this.fmtpDescription;
/*  47:    */   }
/*  48:    */   
/*  49:    */   public String getFmtpName()
/*  50:    */   {
/*  51:100 */     return this.fmtpName;
/*  52:    */   }
/*  53:    */   
/*  54:    */   public Date getFmtpTimestamp()
/*  55:    */   {
/*  56:108 */     return this.fmtpTimestamp;
/*  57:    */   }
/*  58:    */   
/*  59:    */   public Set getIdtFamilieses()
/*  60:    */   {
/*  61:116 */     return this.idtFamilieses;
/*  62:    */   }
/*  63:    */   
/*  64:    */   public IdtUsers getIdtUsers()
/*  65:    */   {
/*  66:124 */     return this.idtUsers;
/*  67:    */   }
/*  68:    */   
/*  69:    */   public void setFmtpCode(String fmtpCode)
/*  70:    */   {
/*  71:133 */     this.fmtpCode = fmtpCode;
/*  72:    */   }
/*  73:    */   
/*  74:    */   public void setFmtpDescription(String fmtpDescription)
/*  75:    */   {
/*  76:142 */     this.fmtpDescription = fmtpDescription;
/*  77:    */   }
/*  78:    */   
/*  79:    */   public void setFmtpName(String fmtpName)
/*  80:    */   {
/*  81:151 */     this.fmtpName = fmtpName;
/*  82:    */   }
/*  83:    */   
/*  84:    */   public void setFmtpTimestamp(Date fmtpTimestamp)
/*  85:    */   {
/*  86:160 */     this.fmtpTimestamp = fmtpTimestamp;
/*  87:    */   }
/*  88:    */   
/*  89:    */   public void setIdtFamilieses(Set idtFamilieses)
/*  90:    */   {
/*  91:169 */     this.idtFamilieses = idtFamilieses;
/*  92:    */   }
/*  93:    */   
/*  94:    */   public void setIdtUsers(IdtUsers idtUsers)
/*  95:    */   {
/*  96:178 */     this.idtUsers = idtUsers;
/*  97:    */   }
/*  98:    */ }


/* Location:           C:\Users\Luis\Desktop\CLXX\BalanceQL\Fuentes\
 * Qualified Name:     sia.bql.hibernate.sioperan.AbstractIdtFamilyTypes
 * JD-Core Version:    0.7.0.1
 */