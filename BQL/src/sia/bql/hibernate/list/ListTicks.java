/*  1:   */ package sia.bql.hibernate.list;
/*  2:   */ 
/*  3:   */ import java.util.ArrayList;
/*  4:   */ import java.util.ListIterator;
/*  5:   */ 
/*  6:   */ public class ListTicks
/*  7:   */   extends ArrayList<String>
/*  8:   */ {
/*  9:   */   public String[] toArray()
/* 10:   */   {
/* 11:11 */     String[] ticks = new String[size()];
/* 12:12 */     ListIterator<String> it = super.listIterator();
/* 13:13 */     for (int i = 0; i < size(); i++) {
/* 14:14 */       ticks[i] = ((String)get(i)).toString();
/* 15:   */     }
/* 16:16 */     return ticks;
/* 17:   */   }
/* 18:   */ }


/* Location:           C:\Users\Luis\Desktop\CLXX\BalanceQL\Fuentes\
 * Qualified Name:     sia.bql.hibernate.list.ListTicks
 * JD-Core Version:    0.7.0.1
 */