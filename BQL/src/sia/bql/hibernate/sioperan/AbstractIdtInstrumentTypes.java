/*   1:    */ package sia.bql.hibernate.sioperan;
/*   2:    */ 
/*   3:    */ import java.io.Serializable;
/*   4:    */ import java.util.Date;
/*   5:    */ import java.util.HashSet;
/*   6:    */ import java.util.Set;
/*   7:    */ 
/*   8:    */ public abstract class AbstractIdtInstrumentTypes
/*   9:    */   implements Serializable
/*  10:    */ {
/*  11:    */   private static final long serialVersionUID = 1L;
/*  12:    */   private IdtFamilies idtFamilies;
/*  13: 17 */   private Set<Object> idtInstrumentses = new HashSet(0);
/*  14: 19 */   private Set<Object> idtInsVarses = new HashSet(0);
/*  15:    */   private IdtUsers idtUsers;
/*  16:    */   private String intpDescription;
/*  17:    */   private Long intpId;
/*  18:    */   private String intpName;
/*  19:    */   private Date intpTimestamp;
/*  20:    */   
/*  21:    */   public AbstractIdtInstrumentTypes() {}
/*  22:    */   
/*  23:    */   public AbstractIdtInstrumentTypes(Long intpId, IdtUsers idtUsers, String intpName, Date intpTimestamp)
/*  24:    */   {
/*  25: 69 */     this.intpId = intpId;
/*  26: 70 */     this.idtUsers = idtUsers;
/*  27: 71 */     this.intpName = intpName;
/*  28: 72 */     this.intpTimestamp = intpTimestamp;
/*  29:    */   }
/*  30:    */   
/*  31:    */   public Set<Object> getIdtInstrumentses()
/*  32:    */   {
/*  33: 85 */     return this.idtInstrumentses;
/*  34:    */   }
/*  35:    */   
/*  36:    */   public Set<Object> getIdtInsVarses()
/*  37:    */   {
/*  38: 93 */     return this.idtInsVarses;
/*  39:    */   }
/*  40:    */   
/*  41:    */   public IdtUsers getIdtUsers()
/*  42:    */   {
/*  43:101 */     return this.idtUsers;
/*  44:    */   }
/*  45:    */   
/*  46:    */   public String getIntpDescription()
/*  47:    */   {
/*  48:109 */     return this.intpDescription;
/*  49:    */   }
/*  50:    */   
/*  51:    */   public Long getIntpId()
/*  52:    */   {
/*  53:118 */     return this.intpId;
/*  54:    */   }
/*  55:    */   
/*  56:    */   public String getIntpName()
/*  57:    */   {
/*  58:126 */     return this.intpName;
/*  59:    */   }
/*  60:    */   
/*  61:    */   public Date getIntpTimestamp()
/*  62:    */   {
/*  63:134 */     return this.intpTimestamp;
/*  64:    */   }
/*  65:    */   
/*  66:    */   public void setIdtInstrumentses(Set<Object> idtInstrumentses)
/*  67:    */   {
/*  68:149 */     this.idtInstrumentses = idtInstrumentses;
/*  69:    */   }
/*  70:    */   
/*  71:    */   public void setIdtInsVarses(Set<Object> idtInsVarses)
/*  72:    */   {
/*  73:158 */     this.idtInsVarses = idtInsVarses;
/*  74:    */   }
/*  75:    */   
/*  76:    */   public void setIdtUsers(IdtUsers idtUsers)
/*  77:    */   {
/*  78:167 */     this.idtUsers = idtUsers;
/*  79:    */   }
/*  80:    */   
/*  81:    */   public void setIntpDescription(String intpDescription)
/*  82:    */   {
/*  83:176 */     this.intpDescription = intpDescription;
/*  84:    */   }
/*  85:    */   
/*  86:    */   public void setIntpId(Long intpId)
/*  87:    */   {
/*  88:185 */     this.intpId = intpId;
/*  89:    */   }
/*  90:    */   
/*  91:    */   public void setIntpName(String intpName)
/*  92:    */   {
/*  93:194 */     this.intpName = intpName;
/*  94:    */   }
/*  95:    */   
/*  96:    */   public IdtFamilies getIdtFamilies()
/*  97:    */   {
/*  98:197 */     return this.idtFamilies;
/*  99:    */   }
/* 100:    */   
/* 101:    */   public void setIdtFamilies(IdtFamilies idtFamilies)
/* 102:    */   {
/* 103:200 */     this.idtFamilies = idtFamilies;
/* 104:    */   }
/* 105:    */   
/* 106:    */   public void setIntpTimestamp(Date intpTimestamp)
/* 107:    */   {
/* 108:203 */     this.intpTimestamp = intpTimestamp;
/* 109:    */   }
/* 110:    */ }


/* Location:           C:\Users\Luis\Desktop\CLXX\BalanceQL\Fuentes\
 * Qualified Name:     sia.bql.hibernate.sioperan.AbstractIdtInstrumentTypes
 * JD-Core Version:    0.7.0.1
 */