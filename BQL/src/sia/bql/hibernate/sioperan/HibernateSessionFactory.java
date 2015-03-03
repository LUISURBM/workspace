/*   1:    */ package sia.bql.hibernate.sioperan;
/*   2:    */ 
/*   3:    */ import java.io.PrintStream;
/*   4:    */ import java.util.List;
/*   5:    */ import org.hibernate.HibernateException;
/*   6:    */ import org.hibernate.Query;
/*   7:    */ import org.hibernate.Session;
/*   8:    */ import org.hibernate.SessionFactory;
/*   9:    */ import org.hibernate.Transaction;
/*  10:    */ import org.hibernate.cfg.Configuration;
/*  11:    */ import sia.bql.bean.seguridad.InterceptorAuditoria;
/*  12:    */ 
/*  13:    */ public class HibernateSessionFactory
/*  14:    */ {
/*  15: 13 */   private static String CONFIG_FILE_LOCATION = "/hibernate.cfg.xml";
/*  16: 14 */   private static String configFile = CONFIG_FILE_LOCATION;
/*  17: 15 */   private static Configuration configuration = new Configuration();
/*  18:    */   private static SessionFactory sessionFactory;
/*  19: 17 */   private static final ThreadLocal<Session> threadLocal = new ThreadLocal();
/*  20:    */   
/*  21:    */   public static void closeSession()
/*  22:    */     throws HibernateException
/*  23:    */   {
/*  24: 19 */     Session session = (Session)threadLocal.get();
/*  25: 20 */     threadLocal.set(null);
/*  26: 21 */     if (session != null) {
/*  27: 22 */       session.close();
/*  28:    */     }
/*  29:    */   }
/*  30:    */   
/*  31:    */   public static synchronized Session currentSession()
/*  32:    */     throws HibernateException
/*  33:    */   {
/*  34: 25 */     Session session = (Session)threadLocal.get();
/*  35: 26 */     if ((session == null) || (!session.isOpen()))
/*  36:    */     {
/*  37: 27 */       if (sessionFactory == null) {
/*  38:    */         try
/*  39:    */         {
/*  40: 29 */           configuration.configure(CONFIG_FILE_LOCATION);
/*  41: 30 */           sessionFactory = configuration.buildSessionFactory();
/*  42:    */         }
/*  43:    */         catch (Exception e)
/*  44:    */         {
/*  45: 32 */           System.err.println("%%%% Error Creating SessionFactory %%%%");
/*  46: 33 */           e.printStackTrace();
/*  47:    */         }
/*  48:    */       }
/*  49: 35 */       session = sessionFactory != null ? sessionFactory.openSession() : null;
/*  50: 36 */       threadLocal.set(session);
/*  51:    */     }
/*  52: 38 */     return session;
/*  53:    */   }
/*  54:    */   
/*  55:    */   public static void delete(Object[] o)
/*  56:    */     throws Throwable
/*  57:    */   {
/*  58: 41 */     Session session = getSession();
/*  59: 42 */     Transaction tx = null;
/*  60:    */     try
/*  61:    */     {
/*  62: 44 */       tx = session.beginTransaction();
/*  63: 45 */       Object[] arrayOfObject = o;int j = o.length;
/*  64: 45 */       for (int i = 0; i < j; i++)
/*  65:    */       {
/*  66: 45 */         Object element = arrayOfObject[i];
/*  67: 46 */         session.delete(element);
/*  68:    */       }
/*  69: 47 */       session.flush();
/*  70: 48 */       tx.commit();
/*  71:    */     }
/*  72:    */     catch (Throwable e)
/*  73:    */     {
/*  74: 50 */       if (tx != null) {
/*  75: 51 */         tx.rollback();
/*  76:    */       }
/*  77: 52 */       throw e;
/*  78:    */     }
/*  79:    */     finally
/*  80:    */     {
/*  81: 54 */       if (session != null) {
/*  82: 55 */         session.close();
/*  83:    */       }
/*  84:    */     }
/*  85:    */   }
/*  86:    */   
/*  87:    */   public static Configuration getConfiguration()
/*  88:    */   {
/*  89: 60 */     return configuration;
/*  90:    */   }
/*  91:    */   
/*  92:    */   public static Session getSession()
/*  93:    */     throws HibernateException
/*  94:    */   {
/*  95: 63 */     Session session = (Session)threadLocal.get();
/*  96: 64 */     if ((session == null) || (!session.isOpen()))
/*  97:    */     {
/*  98: 65 */       if (sessionFactory == null) {
/*  99: 66 */         rebuildSessionFactory();
/* 100:    */       }
/* 101: 67 */       session = sessionFactory != null ? sessionFactory.openSession(new InterceptorAuditoria()) : null;
/* 102: 68 */       threadLocal.set(session);
/* 103:    */     }
/* 104: 70 */     return session;
/* 105:    */   }
/* 106:    */   
/* 107:    */   public static SessionFactory getSessionFactory()
/* 108:    */   {
/* 109: 76 */     return sessionFactory;
/* 110:    */   }
/* 111:    */   
/* 112:    */   public static List readAll(String clase)
/* 113:    */   {
/* 114: 80 */     Session session = getSession();
/* 115: 81 */     List all = null;
/* 116:    */     try
/* 117:    */     {
/* 118: 83 */       Query q = session.createQuery("from " + clase);
/* 119: 84 */       all = q.list();
/* 120: 85 */       session.flush();
/* 121: 86 */       return all;
/* 122:    */     }
/* 123:    */     catch (Throwable e)
/* 124:    */     {
/* 125: 88 */       e.printStackTrace();
/* 126:    */     }
/* 127:    */     finally
/* 128:    */     {
/* 129: 90 */       closeSession();
/* 130:    */     }
/* 131: 92 */     return all;
/* 132:    */   }
/* 133:    */   
/* 134:    */   public static void rebuildSessionFactory()
/* 135:    */   {
/* 136:    */     try
/* 137:    */     {
/* 138: 99 */       configuration.configure(configFile);
/* 139:100 */       sessionFactory = configuration.buildSessionFactory();
/* 140:    */     }
/* 141:    */     catch (Exception e)
/* 142:    */     {
/* 143:102 */       System.err.println("%%%% Error Creating SessionFactory %%%%");
/* 144:103 */       e.printStackTrace();
/* 145:    */     }
/* 146:    */   }
/* 147:    */   
/* 148:    */   public static void saveOrUpdate(Object[] o)
/* 149:    */     throws Throwable
/* 150:    */   {
/* 151:107 */     Session session = getSession();
/* 152:108 */     Transaction tx = null;
/* 153:    */     try
/* 154:    */     {
/* 155:110 */       tx = session.beginTransaction();
/* 156:111 */       Object[] arrayOfObject = o;int j = o.length;
/* 157:111 */       for (int i = 0; i < j; i++)
/* 158:    */       {
/* 159:111 */         Object element = arrayOfObject[i];
/* 160:112 */         session.saveOrUpdate(element);
/* 161:    */       }
/* 162:113 */       session.flush();
/* 163:114 */       tx.commit();
/* 164:    */     }
/* 165:    */     catch (Throwable e)
/* 166:    */     {
/* 167:116 */       if (tx != null) {
/* 168:117 */         tx.rollback();
/* 169:    */       }
/* 170:118 */       throw e;
/* 171:    */     }
/* 172:    */     finally
/* 173:    */     {
/* 174:120 */       if (session != null) {
/* 175:121 */         session.close();
/* 176:    */       }
/* 177:    */     }
/* 178:    */   }
/* 179:    */   
/* 180:    */   public static void setConfigFile(String configFile)
/* 181:    */   {
/* 182:125 */     configFile = configFile;
/* 183:126 */     sessionFactory = null;
/* 184:    */   }
/* 185:    */ }


/* Location:           C:\Users\Luis\Desktop\CLXX\BalanceQL\Fuentes\
 * Qualified Name:     sia.bql.hibernate.sioperan.HibernateSessionFactory
 * JD-Core Version:    0.7.0.1
 */