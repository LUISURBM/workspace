/*   1:    */ package sia.bql.hibernate.hidromet;
/*   2:    */ 
/*   3:    */ import java.io.Serializable;
/*   4:    */ import java.util.Date;
/*   5:    */ 
/*   6:    */ public abstract class AbstractHmstPath
/*   7:    */   implements Serializable
/*   8:    */ {
/*   9:    */   private static final long serialVersionUID = 1L;
/*  10:    */   private Long pathId;
/*  11:    */   private String pathComponent;
/*  12:    */   private String pathDescription;
/*  13:    */   private String pathServer;
/*  14:    */   private String pathPath;
/*  15:    */   private String pathUserFtp;
/*  16:    */   private String pathPassword;
/*  17:    */   private Long pathUser;
/*  18:    */   private Date pathFecha;
/*  19:    */   
/*  20:    */   public Long getPathId()
/*  21:    */   {
/*  22: 37 */     return this.pathId;
/*  23:    */   }
/*  24:    */   
/*  25:    */   public void setPathId(Long pathId)
/*  26:    */   {
/*  27: 42 */     this.pathId = pathId;
/*  28:    */   }
/*  29:    */   
/*  30:    */   public String getPathComponent()
/*  31:    */   {
/*  32: 47 */     return this.pathComponent;
/*  33:    */   }
/*  34:    */   
/*  35:    */   public void setPathComponent(String pathComponent)
/*  36:    */   {
/*  37: 52 */     this.pathComponent = pathComponent;
/*  38:    */   }
/*  39:    */   
/*  40:    */   public String getPathDescription()
/*  41:    */   {
/*  42: 57 */     return this.pathDescription;
/*  43:    */   }
/*  44:    */   
/*  45:    */   public void setPathDescription(String pathDescription)
/*  46:    */   {
/*  47: 62 */     this.pathDescription = pathDescription;
/*  48:    */   }
/*  49:    */   
/*  50:    */   public String getPathServer()
/*  51:    */   {
/*  52: 67 */     return this.pathServer;
/*  53:    */   }
/*  54:    */   
/*  55:    */   public void setPathServer(String pathServer)
/*  56:    */   {
/*  57: 72 */     this.pathServer = pathServer;
/*  58:    */   }
/*  59:    */   
/*  60:    */   public String getPathPath()
/*  61:    */   {
/*  62: 77 */     return this.pathPath;
/*  63:    */   }
/*  64:    */   
/*  65:    */   public void setPathPath(String pathPath)
/*  66:    */   {
/*  67: 82 */     this.pathPath = pathPath;
/*  68:    */   }
/*  69:    */   
/*  70:    */   public String getPathUserFtp()
/*  71:    */   {
/*  72: 87 */     return this.pathUserFtp;
/*  73:    */   }
/*  74:    */   
/*  75:    */   public void setPathUserFtp(String pathUserFtp)
/*  76:    */   {
/*  77: 92 */     this.pathUserFtp = pathUserFtp;
/*  78:    */   }
/*  79:    */   
/*  80:    */   public String getPathPassword()
/*  81:    */   {
/*  82: 97 */     return this.pathPassword;
/*  83:    */   }
/*  84:    */   
/*  85:    */   public void setPathPassword(String pathPassword)
/*  86:    */   {
/*  87:102 */     this.pathPassword = pathPassword;
/*  88:    */   }
/*  89:    */   
/*  90:    */   public Long getPathUser()
/*  91:    */   {
/*  92:107 */     return this.pathUser;
/*  93:    */   }
/*  94:    */   
/*  95:    */   public void setPathUser(Long pathUser)
/*  96:    */   {
/*  97:112 */     this.pathUser = pathUser;
/*  98:    */   }
/*  99:    */   
/* 100:    */   public Date getPathFecha()
/* 101:    */   {
/* 102:117 */     return this.pathFecha;
/* 103:    */   }
/* 104:    */   
/* 105:    */   public void setPathFecha(Date pathFecha)
/* 106:    */   {
/* 107:122 */     this.pathFecha = pathFecha;
/* 108:    */   }
/* 109:    */ }


/* Location:           C:\Users\Luis\Desktop\CLXX\BalanceQL\Fuentes\
 * Qualified Name:     sia.bql.hibernate.hidromet.AbstractHmstPath
 * JD-Core Version:    0.7.0.1
 */