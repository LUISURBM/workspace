/*  1:   */ package sia.bql.hibernate.sioperan;
/*  2:   */ 
/*  3:   */ import java.io.IOException;
/*  4:   */ import javax.servlet.Filter;
/*  5:   */ import javax.servlet.FilterChain;
/*  6:   */ import javax.servlet.FilterConfig;
/*  7:   */ import javax.servlet.ServletException;
/*  8:   */ import javax.servlet.ServletRequest;
/*  9:   */ import javax.servlet.ServletResponse;
/* 10:   */ import org.apache.commons.logging.Log;
/* 11:   */ import org.apache.commons.logging.LogFactory;
/* 12:   */ import org.hibernate.Session;
/* 13:   */ import org.hibernate.StaleObjectStateException;
/* 14:   */ 
/* 15:   */ public final class HibernateSessionRequestFilter
/* 16:   */   implements Filter
/* 17:   */ {
/* 18:21 */   private static Log log = LogFactory.getLog(HibernateSessionRequestFilter.class);
/* 19:   */   
/* 20:   */   public void destroy() {}
/* 21:   */   
/* 22:   */   public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
/* 23:   */     throws IOException, ServletException
/* 24:   */   {
/* 25:   */     Session sessionF;
/* 26:   */     try
/* 27:   */     {
/* 28:28 */       chain.doFilter(request, response);
/* 29:   */     }
/* 30:   */     catch (StaleObjectStateException staleEx)
/* 31:   */     {
/* 32:30 */       log.error("This interceptor does not implement optimistic concurrency control!");
/* 33:31 */       log.error("Your application will not work until you add compensation actions!");
/* 34:32 */       staleEx.printStackTrace();
/* 35:33 */       throw staleEx;
/* 36:   */     }
/* 37:   */     finally
/* 38:   */     {
/* 39:   */       try
/* 40:   */       {
/* 41:36 */         HibernateSessionFactory.currentSession().close();
/* 42:   */       }
/* 43:   */       catch (Throwable t)
/* 44:   */       {
/* 45:38 */         t.printStackTrace();
/* 46:   */       }
/* 47:   */       try
/* 48:   */       {
/* 49:42 */         sessionF = HibernateSessionFactory.getSession();
/* 50:43 */         if ((sessionF != null) && (sessionF.isOpen())) {
/* 51:44 */           sessionF.close();
/* 52:   */         }
/* 53:   */       }
/* 54:   */       catch (Throwable localThrowable1) {}
/* 55:   */     }
/* 56:   */   }
/* 57:   */   
/* 58:   */   public void init(FilterConfig filterConfig)
/* 59:   */     throws ServletException
/* 60:   */   {
/* 61:51 */     log.debug("Initializing filter...");
/* 62:52 */     log.debug("Obtaining SessionFactory from static HibernateUtil singleton");
/* 63:   */   }
/* 64:   */ }


/* Location:           C:\Users\Luis\Desktop\CLXX\BalanceQL\Fuentes\
 * Qualified Name:     sia.bql.hibernate.sioperan.HibernateSessionRequestFilter
 * JD-Core Version:    0.7.0.1
 */