/*  1:   */ package sia.bql.hibernate.list;
/*  2:   */ 
/*  3:   */ import java.util.ArrayList;
/*  4:   */ import java.util.Date;
/*  5:   */ import java.util.ListIterator;
/*  6:   */ import sia.bql.hibernate.hidromet.ShmtEstacionBalanceQl;
/*  7:   */ 
/*  8:   */ public class ListShmtEstacion
/*  9:   */   extends ArrayList<ShmtEstacionBalanceQl>
/* 10:   */ {
/* 11:   */   private static final long serialVersionUID = 1L;
/* 12:   */   private Date fechaInicio;
/* 13:   */   private Date fechaFin;
/* 14:   */   private String variable;
/* 15:   */   
/* 16:   */   public Double pesoConjunto()
/* 17:   */   {
/* 18:28 */     ListIterator<ShmtEstacionBalanceQl> itEstaciones = listIterator();
/* 19:29 */     double total = 0.0D;
/* 20:30 */     while (itEstaciones.hasNext())
/* 21:   */     {
/* 22:31 */       ShmtEstacionBalanceQl temp = (ShmtEstacionBalanceQl)itEstaciones.next();
/* 23:32 */       total += (temp.isEstacionNivel() ? temp.getEgbqPeso().doubleValue() : 0.0D);
/* 24:   */     }
/* 25:34 */     return Double.valueOf(total);
/* 26:   */   }
/* 27:   */   
/* 28:   */   public Date getFechaInicio()
/* 29:   */   {
/* 30:38 */     return this.fechaInicio;
/* 31:   */   }
/* 32:   */   
/* 33:   */   public void setFechaInicio(Date fechaInicio)
/* 34:   */   {
/* 35:42 */     this.fechaInicio = fechaInicio;
/* 36:   */   }
/* 37:   */   
/* 38:   */   public Date getFechaFin()
/* 39:   */   {
/* 40:46 */     return this.fechaFin;
/* 41:   */   }
/* 42:   */   
/* 43:   */   public void setFechaFin(Date fechaFin)
/* 44:   */   {
/* 45:50 */     this.fechaFin = fechaFin;
/* 46:   */   }
/* 47:   */   
/* 48:   */   public String getVariable()
/* 49:   */   {
/* 50:54 */     return this.variable;
/* 51:   */   }
/* 52:   */   
/* 53:   */   public void setVariable(String variable)
/* 54:   */   {
/* 55:58 */     this.variable = variable;
/* 56:   */   }
/* 57:   */ }


/* Location:           C:\Users\Luis\Desktop\CLXX\BalanceQL\Fuentes\
 * Qualified Name:     sia.bql.hibernate.list.ListShmtEstacion
 * JD-Core Version:    0.7.0.1
 */