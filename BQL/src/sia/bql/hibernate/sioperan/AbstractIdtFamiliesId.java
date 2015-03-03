/*  1:   */ package sia.bql.hibernate.sioperan;
/*  2:   */ 
/*  3:   */ import java.io.Serializable;
/*  4:   */ 
/*  5:   */ public abstract class AbstractIdtFamiliesId
/*  6:   */   implements Serializable
/*  7:   */ {
/*  8:   */   private static final long serialVersionUID = 1L;
/*  9:   */   private String fmlCode;
/* 10:   */   private IdtFamilyTypes idtFamilyTypes;
/* 11:   */   
/* 12:   */   public AbstractIdtFamiliesId() {}
/* 13:   */   
/* 14:   */   public AbstractIdtFamiliesId(IdtFamilyTypes idtFamilyTypes, String fmlCode)
/* 15:   */   {
/* 16:31 */     this.idtFamilyTypes = idtFamilyTypes;
/* 17:32 */     this.fmlCode = fmlCode;
/* 18:   */   }
/* 19:   */   
/* 20:   */   public boolean equals(Object other)
/* 21:   */   {
/* 22:41 */     if (this == other) {
/* 23:42 */       return true;
/* 24:   */     }
/* 25:43 */     if (other == null) {
/* 26:44 */       return false;
/* 27:   */     }
/* 28:45 */     if (!(other instanceof AbstractIdtFamiliesId)) {
/* 29:46 */       return false;
/* 30:   */     }
/* 31:47 */     AbstractIdtFamiliesId castOther = (AbstractIdtFamiliesId)other;
/* 32:48 */     return ((getIdtFamilyTypes() == castOther.getIdtFamilyTypes()) || ((getIdtFamilyTypes() != null) && (castOther.getIdtFamilyTypes() != null) && (getIdtFamilyTypes().equals(castOther.getIdtFamilyTypes())))) && ((getFmlCode() == castOther.getFmlCode()) || ((getFmlCode() != null) && (castOther.getFmlCode() != null) && (getFmlCode().equals(castOther.getFmlCode()))));
/* 33:   */   }
/* 34:   */   
/* 35:   */   public String getFmlCode()
/* 36:   */   {
/* 37:56 */     return this.fmlCode;
/* 38:   */   }
/* 39:   */   
/* 40:   */   public IdtFamilyTypes getIdtFamilyTypes()
/* 41:   */   {
/* 42:64 */     return this.idtFamilyTypes;
/* 43:   */   }
/* 44:   */   
/* 45:   */   public int hashCode()
/* 46:   */   {
/* 47:73 */     int result = 17;
/* 48:74 */     result = 37 * result + (getIdtFamilyTypes() == null ? 0 : getIdtFamilyTypes().hashCode());
/* 49:75 */     result = 37 * result + (getFmlCode() == null ? 0 : getFmlCode().hashCode());
/* 50:76 */     return result;
/* 51:   */   }
/* 52:   */   
/* 53:   */   public void setFmlCode(String fmlCode)
/* 54:   */   {
/* 55:85 */     this.fmlCode = fmlCode;
/* 56:   */   }
/* 57:   */   
/* 58:   */   public void setIdtFamilyTypes(IdtFamilyTypes idtFamilyTypes)
/* 59:   */   {
/* 60:94 */     this.idtFamilyTypes = idtFamilyTypes;
/* 61:   */   }
/* 62:   */ }


/* Location:           C:\Users\Luis\Desktop\CLXX\BalanceQL\Fuentes\
 * Qualified Name:     sia.bql.hibernate.sioperan.AbstractIdtFamiliesId
 * JD-Core Version:    0.7.0.1
 */