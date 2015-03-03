/*  1:   */ package sia.bql.logica;
/*  2:   */ 
/*  3:   */ public class EstadisticoBasico
/*  4:   */ {
/*  5:   */   double max;
/*  6:   */   double min;
/*  7:   */   double promedio;
/*  8:   */   
/*  9:   */   public EstadisticoBasico(double max, double min, double promedio)
/* 10:   */   {
/* 11:13 */     this.max = max;
/* 12:14 */     this.min = min;
/* 13:15 */     this.promedio = promedio;
/* 14:   */   }
/* 15:   */   
/* 16:   */   public double getMax()
/* 17:   */   {
/* 18:18 */     return this.max;
/* 19:   */   }
/* 20:   */   
/* 21:   */   public void setMax(double max)
/* 22:   */   {
/* 23:21 */     this.max = max;
/* 24:   */   }
/* 25:   */   
/* 26:   */   public double getMin()
/* 27:   */   {
/* 28:24 */     return this.min;
/* 29:   */   }
/* 30:   */   
/* 31:   */   public void setMin(double min)
/* 32:   */   {
/* 33:27 */     this.min = min;
/* 34:   */   }
/* 35:   */   
/* 36:   */   public double getPromedio()
/* 37:   */   {
/* 38:30 */     return this.promedio;
/* 39:   */   }
/* 40:   */   
/* 41:   */   public void setPromedio(double promedio)
/* 42:   */   {
/* 43:33 */     this.promedio = promedio;
/* 44:   */   }
/* 45:   */ }


/* Location:           C:\Users\Luis\Desktop\CLXX\BalanceQL\Fuentes\
 * Qualified Name:     sia.bql.logica.EstadisticoBasico
 * JD-Core Version:    0.7.0.1
 */