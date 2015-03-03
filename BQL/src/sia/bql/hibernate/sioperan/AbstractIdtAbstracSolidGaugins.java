/*   1:    */ package sia.bql.hibernate.sioperan;
/*   2:    */ 
/*   3:    */ import java.io.Serializable;
/*   4:    */ import java.util.Date;
/*   5:    */ 
/*   6:    */ public abstract class AbstractIdtAbstracSolidGaugins
/*   7:    */   implements Serializable
/*   8:    */ {
/*   9:    */   private static final long serialVersionUID = 1L;
/*  10:    */   private Double abslCdlLqd;
/*  11:    */   private Double abslCncSpr;
/*  12:    */   private Double abslCntAvg;
/*  13:    */   private Long abslId;
/*  14:    */   private Double abslLvlAvg;
/*  15:    */   private Double abslSpnSldTtl;
/*  16:    */   private Date abslTimestamp;
/*  17:    */   private IdtUsers idtUsers;
/*  18:    */   private IdtGaugings aforoSolido;
/*  19:    */   private IdtGaugings aforoLiquido;
/*  20:    */   
/*  21:    */   public Double getAbslCdlLqd()
/*  22:    */   {
/*  23: 45 */     return this.abslCdlLqd;
/*  24:    */   }
/*  25:    */   
/*  26:    */   public Double getAbslCncSpr()
/*  27:    */   {
/*  28: 53 */     return this.abslCncSpr;
/*  29:    */   }
/*  30:    */   
/*  31:    */   public Double getAbslCntAvg()
/*  32:    */   {
/*  33: 61 */     return this.abslCntAvg;
/*  34:    */   }
/*  35:    */   
/*  36:    */   public Long getAbslId()
/*  37:    */   {
/*  38: 70 */     return this.abslId;
/*  39:    */   }
/*  40:    */   
/*  41:    */   public Double getAbslLvlAvg()
/*  42:    */   {
/*  43: 78 */     return this.abslLvlAvg;
/*  44:    */   }
/*  45:    */   
/*  46:    */   public Double getAbslSpnSldTtl()
/*  47:    */   {
/*  48: 86 */     return this.abslSpnSldTtl;
/*  49:    */   }
/*  50:    */   
/*  51:    */   public Date getAbslTimestamp()
/*  52:    */   {
/*  53: 94 */     return this.abslTimestamp;
/*  54:    */   }
/*  55:    */   
/*  56:    */   public IdtGaugings getAforoSolido()
/*  57:    */   {
/*  58:102 */     return this.aforoSolido;
/*  59:    */   }
/*  60:    */   
/*  61:    */   public void setAbslCdlLqd(Double abslCdlLqd)
/*  62:    */   {
/*  63:111 */     this.abslCdlLqd = abslCdlLqd;
/*  64:    */   }
/*  65:    */   
/*  66:    */   public void setAbslCncSpr(Double abslCncSpr)
/*  67:    */   {
/*  68:120 */     this.abslCncSpr = abslCncSpr;
/*  69:    */   }
/*  70:    */   
/*  71:    */   public void setAbslCntAvg(Double abslCntAvg)
/*  72:    */   {
/*  73:129 */     this.abslCntAvg = abslCntAvg;
/*  74:    */   }
/*  75:    */   
/*  76:    */   public void setAbslId(Long abslId)
/*  77:    */   {
/*  78:138 */     this.abslId = abslId;
/*  79:    */   }
/*  80:    */   
/*  81:    */   public void setAbslLvlAvg(Double abslLvlAvg)
/*  82:    */   {
/*  83:147 */     this.abslLvlAvg = abslLvlAvg;
/*  84:    */   }
/*  85:    */   
/*  86:    */   public void setAbslSpnSldTtl(Double abslSpnSldTtl)
/*  87:    */   {
/*  88:156 */     this.abslSpnSldTtl = abslSpnSldTtl;
/*  89:    */   }
/*  90:    */   
/*  91:    */   public void setAbslTimestamp(Date abslTimestamp)
/*  92:    */   {
/*  93:165 */     this.abslTimestamp = abslTimestamp;
/*  94:    */   }
/*  95:    */   
/*  96:    */   public void setAforoSolido(IdtGaugings idtGaugings)
/*  97:    */   {
/*  98:174 */     this.aforoSolido = idtGaugings;
/*  99:    */   }
/* 100:    */   
/* 101:    */   public IdtGaugings getAforoLiquido()
/* 102:    */   {
/* 103:182 */     return this.aforoLiquido;
/* 104:    */   }
/* 105:    */   
/* 106:    */   public void setAforoLiquido(IdtGaugings aforoLiquido)
/* 107:    */   {
/* 108:188 */     this.aforoLiquido = aforoLiquido;
/* 109:    */   }
/* 110:    */   
/* 111:    */   public IdtUsers getIdtUsers()
/* 112:    */   {
/* 113:196 */     return this.idtUsers;
/* 114:    */   }
/* 115:    */   
/* 116:    */   public void setIdtUsers(IdtUsers idtUsers)
/* 117:    */   {
/* 118:202 */     this.idtUsers = idtUsers;
/* 119:    */   }
/* 120:    */ }


/* Location:           C:\Users\Luis\Desktop\CLXX\BalanceQL\Fuentes\
 * Qualified Name:     sia.bql.hibernate.sioperan.AbstractIdtAbstracSolidGaugins
 * JD-Core Version:    0.7.0.1
 */