/*  1:   */ package sia.bql.persistencia;
/*  2:   */ 
/*  3:   */ import java.util.logging.FileHandler;
/*  4:   */ import java.util.logging.Level;
/*  5:   */ import java.util.logging.Logger;
/*  6:   */ import java.util.logging.SimpleFormatter;
/*  7:   */ 
/*  8:   */ public class LogUtil
/*  9:   */ {
/* 10:17 */   private static final Logger logger = Logger.getLogger("BQL");
/* 11:   */   private static FileHandler fileTxt;
/* 12:   */   private static SimpleFormatter formatterTxt;
/* 13:   */   
/* 14:   */   static
/* 15:   */   {
/* 16:18 */     logger.setLevel(Level.ALL);
/* 17:   */     try
/* 18:   */     {
/* 19:21 */       fileTxt = new FileHandler("BQL.txt", true);
/* 20:   */     }
/* 21:   */     catch (Exception ex)
/* 22:   */     {
/* 23:23 */       throw new RuntimeException("Error al inicializar el logger. " + ex.getLocalizedMessage());
/* 24:   */     }
/* 25:27 */     formatterTxt = new SimpleFormatter();
/* 26:28 */     fileTxt.setFormatter(formatterTxt);
/* 27:29 */     logger.addHandler(fileTxt);
/* 28:   */   }
/* 29:   */   
/* 30:   */   public static void log(String info, Level level, Throwable ex)
/* 31:   */   {
/* 32:33 */     logger.log(level, info, ex);
/* 33:   */   }
/* 34:   */   
/* 35:   */   public static Logger getLogger()
/* 36:   */   {
/* 37:37 */     return logger;
/* 38:   */   }
/* 39:   */ }


/* Location:           C:\Users\Luis\Desktop\CLXX\BalanceQL\Fuentes\
 * Qualified Name:     sia.bql.persistencia.LogUtil
 * JD-Core Version:    0.7.0.1
 */