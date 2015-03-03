/*   1:    */ package sia.bql.hibernate.sioperan;
/*   2:    */ 
/*   3:    */ import java.io.Serializable;
/*   4:    */ import java.util.Date;
/*   5:    */ 
/*   6:    */ public abstract class AbstractIdtAbstracLiquidGaugins
/*   7:    */   implements Serializable
/*   8:    */ {
/*   9:    */   private static final long serialVersionUID = 1L;
/*  10:    */   private Double ablqAraTtl;
/*  11:    */   private Double ablqCdlTtl;
/*  12:    */   private Double ablqDepAvg;
/*  13:    */   private Double ablqFctGmt;
/*  14:    */   private Double ablqFctHyd;
/*  15:    */   private String ablqFmtpCodeMdt;
/*  16:    */   private String ablqFmtpFmlCodeMdt;
/*  17:    */   private Long ablqId;
/*  18:    */   private Double ablqLvlAvg;
/*  19:    */   private Double ablqPrmWet;
/*  20:    */   private Double ablqRdoHyd;
/*  21:    */   private Double ablqSpdAvg;
/*  22:    */   private Date ablqTimestamp;
/*  23:    */   private Double ablqTtlWdt;
/*  24:    */   private Long ablqUserId;
/*  25:    */   private IdtGaugings idtGaugings;
/*  26:    */   
/*  27:    */   public Double getAblqAraTtl()
/*  28:    */   {
/*  29: 19 */     return this.ablqAraTtl;
/*  30:    */   }
/*  31:    */   
/*  32:    */   public Double getAblqCdlTtl()
/*  33:    */   {
/*  34: 22 */     return this.ablqCdlTtl;
/*  35:    */   }
/*  36:    */   
/*  37:    */   public Double getAblqDepAvg()
/*  38:    */   {
/*  39: 25 */     return this.ablqDepAvg;
/*  40:    */   }
/*  41:    */   
/*  42:    */   public Double getAblqFctGmt()
/*  43:    */   {
/*  44: 28 */     return this.ablqFctGmt;
/*  45:    */   }
/*  46:    */   
/*  47:    */   public Double getAblqFctHyd()
/*  48:    */   {
/*  49: 31 */     return this.ablqFctHyd;
/*  50:    */   }
/*  51:    */   
/*  52:    */   public String getAblqFmtpCodeMdt()
/*  53:    */   {
/*  54: 34 */     return this.ablqFmtpCodeMdt;
/*  55:    */   }
/*  56:    */   
/*  57:    */   public String getAblqFmtpFmlCodeMdt()
/*  58:    */   {
/*  59: 37 */     return this.ablqFmtpFmlCodeMdt;
/*  60:    */   }
/*  61:    */   
/*  62:    */   public Long getAblqId()
/*  63:    */   {
/*  64: 40 */     return this.ablqId;
/*  65:    */   }
/*  66:    */   
/*  67:    */   public Double getAblqLvlAvg()
/*  68:    */   {
/*  69: 43 */     return this.ablqLvlAvg;
/*  70:    */   }
/*  71:    */   
/*  72:    */   public Double getAblqPrmWet()
/*  73:    */   {
/*  74: 46 */     return this.ablqPrmWet;
/*  75:    */   }
/*  76:    */   
/*  77:    */   public Double getAblqRdoHyd()
/*  78:    */   {
/*  79: 49 */     return this.ablqRdoHyd;
/*  80:    */   }
/*  81:    */   
/*  82:    */   public Double getAblqSpdAvg()
/*  83:    */   {
/*  84: 52 */     return this.ablqSpdAvg;
/*  85:    */   }
/*  86:    */   
/*  87:    */   public Date getAblqTimestamp()
/*  88:    */   {
/*  89: 55 */     return this.ablqTimestamp;
/*  90:    */   }
/*  91:    */   
/*  92:    */   public Double getAblqTtlWdt()
/*  93:    */   {
/*  94: 58 */     return this.ablqTtlWdt;
/*  95:    */   }
/*  96:    */   
/*  97:    */   public Long getAblqUserId()
/*  98:    */   {
/*  99: 61 */     return this.ablqUserId;
/* 100:    */   }
/* 101:    */   
/* 102:    */   public IdtGaugings getIdtGaugings()
/* 103:    */   {
/* 104: 64 */     return this.idtGaugings;
/* 105:    */   }
/* 106:    */   
/* 107:    */   public void setAblqAraTtl(Double ablqAraTtl)
/* 108:    */   {
/* 109: 67 */     this.ablqAraTtl = ablqAraTtl;
/* 110:    */   }
/* 111:    */   
/* 112:    */   public void setAblqCdlTtl(Double ablqCdlTtl)
/* 113:    */   {
/* 114: 70 */     this.ablqCdlTtl = ablqCdlTtl;
/* 115:    */   }
/* 116:    */   
/* 117:    */   public void setAblqDepAvg(Double ablqDepAvg)
/* 118:    */   {
/* 119: 73 */     this.ablqDepAvg = ablqDepAvg;
/* 120:    */   }
/* 121:    */   
/* 122:    */   public void setAblqFctGmt(Double ablqFctGmt)
/* 123:    */   {
/* 124: 76 */     this.ablqFctGmt = ablqFctGmt;
/* 125:    */   }
/* 126:    */   
/* 127:    */   public void setAblqFctHyd(Double ablqFctHyd)
/* 128:    */   {
/* 129: 79 */     this.ablqFctHyd = ablqFctHyd;
/* 130:    */   }
/* 131:    */   
/* 132:    */   public void setAblqFmtpCodeMdt(String ablqFmtpCodeMdt)
/* 133:    */   {
/* 134: 82 */     this.ablqFmtpCodeMdt = ablqFmtpCodeMdt;
/* 135:    */   }
/* 136:    */   
/* 137:    */   public void setAblqFmtpFmlCodeMdt(String ablqFmtpFmlCodeMdt)
/* 138:    */   {
/* 139: 85 */     this.ablqFmtpFmlCodeMdt = ablqFmtpFmlCodeMdt;
/* 140:    */   }
/* 141:    */   
/* 142:    */   public void setAblqId(Long ablqId)
/* 143:    */   {
/* 144: 88 */     this.ablqId = ablqId;
/* 145:    */   }
/* 146:    */   
/* 147:    */   public void setAblqLvlAvg(Double ablqLvlAvg)
/* 148:    */   {
/* 149: 91 */     this.ablqLvlAvg = ablqLvlAvg;
/* 150:    */   }
/* 151:    */   
/* 152:    */   public void setAblqPrmWet(Double ablqPrmWet)
/* 153:    */   {
/* 154: 94 */     this.ablqPrmWet = ablqPrmWet;
/* 155:    */   }
/* 156:    */   
/* 157:    */   public void setAblqRdoHyd(Double ablqRdoHyd)
/* 158:    */   {
/* 159: 97 */     this.ablqRdoHyd = ablqRdoHyd;
/* 160:    */   }
/* 161:    */   
/* 162:    */   public void setAblqSpdAvg(Double ablqSpdAvg)
/* 163:    */   {
/* 164:100 */     this.ablqSpdAvg = ablqSpdAvg;
/* 165:    */   }
/* 166:    */   
/* 167:    */   public void setAblqTimestamp(Date ablqTimestamp)
/* 168:    */   {
/* 169:103 */     this.ablqTimestamp = ablqTimestamp;
/* 170:    */   }
/* 171:    */   
/* 172:    */   public void setAblqTtlWdt(Double ablqTtlWdt)
/* 173:    */   {
/* 174:106 */     this.ablqTtlWdt = ablqTtlWdt;
/* 175:    */   }
/* 176:    */   
/* 177:    */   public void setAblqUserId(Long ablqUserId)
/* 178:    */   {
/* 179:109 */     this.ablqUserId = ablqUserId;
/* 180:    */   }
/* 181:    */   
/* 182:    */   public void setIdtGaugings(IdtGaugings idtGaugings)
/* 183:    */   {
/* 184:112 */     this.idtGaugings = idtGaugings;
/* 185:    */   }
/* 186:    */ }


/* Location:           C:\Users\Luis\Desktop\CLXX\BalanceQL\Fuentes\
 * Qualified Name:     sia.bql.hibernate.sioperan.AbstractIdtAbstracLiquidGaugins
 * JD-Core Version:    0.7.0.1
 */