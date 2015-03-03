/*  1:   */ package sia.bql.logica;
/*  2:   */ 
/*  3:   */ import java.math.BigDecimal;
/*  4:   */ import java.util.Date;
/*  5:   */ 
/*  6:   */ public class Pluviometro
/*  7:   */ {
/*  8:   */   private BigDecimal idPluv;
/*  9:   */   private BigDecimal idEstacionPluv;
/* 10:   */   private BigDecimal idSensorPluv;
/* 11:   */   private Date fechaPluv;
/* 12:   */   private String horaPluv;
/* 13:   */   private BigDecimal datoPluv;
/* 14:   */   
/* 15:   */   public Pluviometro(BigDecimal idPluv, BigDecimal idEstacionPluv, BigDecimal idSensorPluv, Date fechaPluv, String horaPluv, BigDecimal datoPluv)
/* 16:   */   {
/* 17:22 */     this.idPluv = idPluv;
/* 18:23 */     this.idEstacionPluv = idEstacionPluv;
/* 19:24 */     this.idSensorPluv = idSensorPluv;
/* 20:25 */     this.fechaPluv = fechaPluv;
/* 21:26 */     this.horaPluv = horaPluv;
/* 22:27 */     this.datoPluv = datoPluv;
/* 23:   */   }
/* 24:   */   
/* 25:   */   public BigDecimal getIdPluv()
/* 26:   */   {
/* 27:31 */     return this.idPluv;
/* 28:   */   }
/* 29:   */   
/* 30:   */   public void setIdPluv(BigDecimal idPluv)
/* 31:   */   {
/* 32:34 */     this.idPluv = idPluv;
/* 33:   */   }
/* 34:   */   
/* 35:   */   public BigDecimal getIdEstacionPluv()
/* 36:   */   {
/* 37:37 */     return this.idEstacionPluv;
/* 38:   */   }
/* 39:   */   
/* 40:   */   public void setIdEstacionPluv(BigDecimal idEstacionPluv)
/* 41:   */   {
/* 42:40 */     this.idEstacionPluv = idEstacionPluv;
/* 43:   */   }
/* 44:   */   
/* 45:   */   public BigDecimal getIdSensorPluv()
/* 46:   */   {
/* 47:43 */     return this.idSensorPluv;
/* 48:   */   }
/* 49:   */   
/* 50:   */   public void setIdSensorPluv(BigDecimal idSensorPluv)
/* 51:   */   {
/* 52:46 */     this.idSensorPluv = idSensorPluv;
/* 53:   */   }
/* 54:   */   
/* 55:   */   public Date getFechaPluv()
/* 56:   */   {
/* 57:49 */     return this.fechaPluv;
/* 58:   */   }
/* 59:   */   
/* 60:   */   public void setFechaPluv(Date fechaPluv)
/* 61:   */   {
/* 62:52 */     this.fechaPluv = fechaPluv;
/* 63:   */   }
/* 64:   */   
/* 65:   */   public String getHoraPluv()
/* 66:   */   {
/* 67:55 */     return this.horaPluv;
/* 68:   */   }
/* 69:   */   
/* 70:   */   public void setHoraPluv(String horaPluv)
/* 71:   */   {
/* 72:58 */     this.horaPluv = horaPluv;
/* 73:   */   }
/* 74:   */   
/* 75:   */   public BigDecimal getDatoPluv()
/* 76:   */   {
/* 77:61 */     return this.datoPluv;
/* 78:   */   }
/* 79:   */   
/* 80:   */   public void setDatoPluv(BigDecimal datoPluv)
/* 81:   */   {
/* 82:64 */     this.datoPluv = datoPluv;
/* 83:   */   }
/* 84:   */ }


/* Location:           C:\Users\Luis\Desktop\CLXX\BalanceQL\Fuentes\
 * Qualified Name:     sia.bql.logica.Pluviometro
 * JD-Core Version:    0.7.0.1
 */