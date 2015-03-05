/*  1:   */ package sia.bql.persistencia;
/*  2:   */ 
/*  3:   */ import java.sql.Connection;
/*  4:   */ import javax.naming.InitialContext;
/*  5:   */ import javax.sql.DataSource;
/*  6:   */ 
/*  7:   */ public final class JDBCConnection
/*  8:   */ {
/*  9:   */   public static Connection getConnection()
/* 10:   */     throws Exception
/* 11:   */   {
/* 12:15 */     InitialContext c = new InitialContext();
/* 13:16 */     DataSource o = (DataSource)c.lookup("java:jboss/datasources/dsHIDROMET");
/* 14:17 */     return o.getConnection();
/* 15:   */   }
/* 16:   */   
/* 17:   */   public static DataSource getDataSource()
/* 18:   */     throws Exception
/* 19:   */   {
/* 20:20 */     InitialContext c = new InitialContext();
/* 21:21 */     return (DataSource)c.lookup("java:jboss/datasources/dsHIDROMET");
/* 22:   */   }
/* 23:   */ }


/* Location:           C:\Users\Luis\Desktop\CLXX\BalanceQL\Fuentes\
 * Qualified Name:     sia.bql.persistencia.JDBCConnection
 * JD-Core Version:    0.7.0.1
 */