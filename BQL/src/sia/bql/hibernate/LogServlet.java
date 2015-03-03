/*  1:   */ package sia.bql.hibernate;
/*  2:   */ 
/*  3:   */ import java.io.IOException;
/*  4:   */ import java.util.Properties;
/*  5:   */ import javax.servlet.ServletConfig;
/*  6:   */ import javax.servlet.ServletException;
/*  7:   */ import javax.servlet.http.HttpServlet;
/*  8:   */ import org.apache.commons.logging.Log;
/*  9:   */ import org.apache.commons.logging.LogFactory;
/* 10:   */ import org.apache.log4j.PropertyConfigurator;
/* 11:   */ 
/* 12:   */ public final class LogServlet
/* 13:   */   extends HttpServlet
/* 14:   */ {
/* 15:   */   private static final long serialVersionUID = 1L;
/* 16:   */   private Log log;
/* 17:   */   
/* 18:   */   public void destroy() {}
/* 19:   */   
/* 20:   */   public void init(ServletConfig config)
/* 21:   */     throws ServletException
/* 22:   */   {
/* 23:   */     try
/* 24:   */     {
/* 25:26 */       Properties p = new Properties();
/* 26:27 */       p.load(getClass().getResourceAsStream("log4j.properties"));
/* 27:28 */       PropertyConfigurator.configure(p);
/* 28:29 */       this.log = LogFactory.getLog(getClass());
/* 29:30 */       this.log.info("LogServlet inicializado");
/* 30:   */     }
/* 31:   */     catch (IOException e)
/* 32:   */     {
/* 33:32 */       e.printStackTrace();
/* 34:33 */       throw new ServletException("Inicialización de Servlet de log fallida", e);
/* 35:   */     }
/* 36:   */   }
/* 37:   */ }


/* Location:           C:\Users\Luis\Desktop\CLXX\BalanceQL\Fuentes\
 * Qualified Name:     sia.bql.hibernate.LogServlet
 * JD-Core Version:    0.7.0.1
 */