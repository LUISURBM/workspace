/*   1:    */ package sia.bql.hibernate;
/*   2:    */ 
/*   3:    */ import common.Logger;
/*   4:    */ import java.io.PrintStream;
/*   5:    */ import java.io.Serializable;
/*   6:    */ import org.hibernate.HibernateException;
/*   7:    */ import org.hibernate.Session;
/*   8:    */ import org.hibernate.SessionFactory;
/*   9:    */ import org.hibernate.Transaction;
/*  10:    */ import org.hibernate.cfg.Configuration;
/*  11:    */ 
/*  12:    */ public class HibernateSessionFactory
/*  13:    */ {
/*  14:    */   private static final String CONFIG_FILE_LOCATION = "/hibernate.cfg.xml";
/*  15: 34 */   private static final ThreadLocal<Session> threadLocal = new ThreadLocal();
/*  16:    */   private static volatile SessionFactory sessionFactory;
/*  17: 36 */   private static String configFile = "/hibernate.cfg.xml";
/*  18: 37 */   private static Configuration configuration = new Configuration();
/*  19:    */   
/*  20:    */   public static synchronized Session getSession()
/*  21:    */     throws HibernateException
/*  22:    */   {
/*  23: 51 */     Session session = (Session)threadLocal.get();
/*  24: 53 */     if ((session == null) || (!session.isOpen()))
/*  25:    */     {
/*  26: 54 */       if (sessionFactory == null) {
/*  27: 55 */         rebuildSessionFactory();
/*  28:    */       }
/*  29: 57 */       session = sessionFactory != null ? sessionFactory.openSession() : 
/*  30: 58 */         null;
/*  31: 59 */       threadLocal.set(session);
/*  32:    */     }
/*  33: 62 */     return session;
/*  34:    */   }
/*  35:    */   
/*  36:    */   public static synchronized void rebuildSessionFactory()
/*  37:    */   {
/*  38:    */     try
/*  39:    */     {
/*  40: 71 */       log().info("HibernateSessionFactory :: Iniciando configuración");
/*  41: 72 */       sessionFactory = new Configuration().configure(
/*  42: 73 */         "/hibernate.cfg.xml")
/*  43: 74 */         .buildSessionFactory();
/*  44: 75 */       log().info("HibernateSessionFactory :: Terminada configuración");
/*  45:    */     }
/*  46:    */     catch (Exception e)
/*  47:    */     {
/*  48: 78 */       System.err.println("%%%% Error Creating SessionFactory %%%%");
/*  49: 79 */       e.printStackTrace();
/*  50:    */     }
/*  51:    */   }
/*  52:    */   
/*  53:    */   private static Logger log()
/*  54:    */   {
/*  55: 84 */     return Logger.getLogger(HibernateSessionFactory.class);
/*  56:    */   }
/*  57:    */   
/*  58:    */   public static synchronized void closeSession()
/*  59:    */     throws HibernateException
/*  60:    */   {
/*  61: 93 */     Session session = (Session)threadLocal.get();
/*  62: 94 */     threadLocal.set(null);
/*  63: 96 */     if (session != null) {
/*  64: 97 */       session.close();
/*  65:    */     }
/*  66:    */   }
/*  67:    */   
/*  68:    */   public static synchronized SessionFactory getSessionFactory()
/*  69:    */   {
/*  70:106 */     return sessionFactory;
/*  71:    */   }
/*  72:    */   
/*  73:    */   public static void setConfigFile(String configFile)
/*  74:    */   {
/*  75:115 */     synchronized (sessionFactory)
/*  76:    */     {
/*  77:116 */       configFile = configFile;
/*  78:117 */       sessionFactory = null;
/*  79:    */     }
/*  80:    */   }
/*  81:    */   
/*  82:    */   public static <T> T load(Class<T> c, Serializable id)
/*  83:    */   {
/*  84:123 */     return (T) getSession().load(c, id);
/*  85:    */   }
/*  86:    */   
/*  87:    */   public static <T> T get(Class<T> c, Serializable id)
/*  88:    */   {
/*  89:128 */     return (T) getSession().get(c, id);
/*  90:    */   }
/*  91:    */   
/*  92:    */   public static synchronized Session currentSession()
/*  93:    */     throws HibernateException
/*  94:    */   {
/*  95:133 */     Session session = (Session)threadLocal.get();
/*  96:134 */     if ((session == null) || (!session.isOpen())) {
/*  97:135 */       if (sessionFactory == null) {
/*  98:    */         try
/*  99:    */         {
/* 100:137 */           sessionFactory = new Configuration().configure().buildSessionFactory();
/* 101:138 */           session = sessionFactory.openSession();
/* 102:    */         }
/* 103:    */         catch (Exception e)
/* 104:    */         {
/* 105:140 */           System.err.println("%%%% Error Creating SessionFactory %%%%");
/* 106:141 */           e.printStackTrace();
/* 107:    */         }
/* 108:    */       } else {
/* 109:145 */         session = sessionFactory.openSession();
/* 110:    */       }
/* 111:    */     }
/* 112:154 */     return session;
/* 113:    */   }
/* 114:    */   
/* 115:    */   public static void saveOrUpdate(Object[] o)
/* 116:    */     throws Throwable
/* 117:    */   {
/* 118:157 */     Session session = getSession();
/* 119:158 */     Transaction tx = null;
/* 120:    */     try
/* 121:    */     {
/* 122:160 */       tx = session.beginTransaction();
/* 123:161 */       Object[] arrayOfObject = o;int j = o.length;
/* 124:161 */       for (int i = 0; i < j; i++)
/* 125:    */       {
/* 126:161 */         Object element = arrayOfObject[i];
/* 127:162 */         session.saveOrUpdate(element);
/* 128:    */       }
/* 129:163 */       session.flush();
/* 130:164 */       tx.commit();
/* 131:    */     }
/* 132:    */     catch (Throwable e)
/* 133:    */     {
/* 134:166 */       if (tx != null) {
/* 135:167 */         tx.rollback();
/* 136:    */       }
/* 137:168 */       throw e;
/* 138:    */     }
/* 139:    */     finally
/* 140:    */     {
/* 141:170 */       if (session != null) {
/* 142:171 */         session.close();
/* 143:    */       }
/* 144:    */     }
/* 145:    */   }
/* 146:    */ }


/* Location:           C:\Users\Luis\Desktop\CLXX\BalanceQL\Fuentes\
 * Qualified Name:     sia.bql.hibernate.HibernateSessionFactory
 * JD-Core Version:    0.7.0.1
 */