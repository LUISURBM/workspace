/*   1:    */ package sia.bql.persistencia;
/*   2:    */ 
/*   3:    */ import java.sql.Connection;
/*   4:    */ import java.sql.PreparedStatement;
/*   5:    */ import java.sql.ResultSet;
/*   6:    */ import java.sql.SQLException;
/*   7:    */ import org.hibernate.SQLQuery;
/*   8:    */ import org.hibernate.Session;
/*   9:    */ import org.hibernate.Transaction;
/*  10:    */ import sia.bql.bean.util.Utiles;
/*  11:    */ import sia.bql.hibernate.HibernateSessionFactory;
/*  12:    */ import sia.bql.i18n.NombresTitulosAplicacion;
/*  13:    */ 
/*  14:    */ public class BDOperacion
/*  15:    */ {
/*  16:    */   private static final String SELECT_MSFL_CODE = "SELECT MSFL_CODE FROM IDT_MEASURE_FIELDS WHERE MSFL_MSTP_CODE = 'SRE_HMG' AND MSFL_DESCRIPTION LIKE ";
/*  17:    */   public static final String SQL_ID_SHMTMENSUALES = "SELECT MNS_ID FROM SHMT_MENSUALES WHERE MNS_VAR_ID  LIKE '?0' AND MNS_ANO = '?1' AND MNS_USUARIO = '?2'  AND MNS_ESTACION_ID = '?3'";
/*  18:    */   public static final String SQL_NOMBRE_SIO_ESTACION = "SELECT NOMBRE_ES FROM siov_estaciones where cod_catalogo_es like'%?%'";
/*  19:    */   public static final String SQL_ESTACION_ID_SIO_ESTACION = "SELECT ESTACION_ID FROM sio_estaciones where codIGO_catalogo like'%?%'";
/*  20:    */   public static final String MAX_GRUPO_BALANCE = "SELECT MAX(GRBC_ID) FROM shmt_grupo_balance_caudal  WHERE GRBC_AOP_ID = '?1' AND GRBC_CUENCA_ID = '?2'";
/*  21:    */   
/*  22:    */   public static String getMsflCode(String variable)
/*  23:    */   {
/*  24: 26 */     Connection conn = null;
/*  25:    */     try
/*  26:    */     {
/*  27: 28 */       conn = JDBCConnection.getConnection();
/*  28: 29 */       PreparedStatement st = conn
/*  29: 30 */         .prepareStatement("SELECT MSFL_CODE FROM IDT_MEASURE_FIELDS WHERE MSFL_MSTP_CODE = 'SRE_HMG' AND MSFL_DESCRIPTION LIKE '" + 
/*  30: 31 */         variable + "'");
/*  31: 32 */       ResultSet rs = st.executeQuery();
/*  32: 33 */       rs.next();
/*  33: 34 */       return String.valueOf(rs.getObject(1).toString());
/*  34:    */     }
/*  35:    */     catch (Exception e)
/*  36:    */     {
/*  37: 37 */       e.printStackTrace();
/*  38:    */     }
/*  39:    */     finally
/*  40:    */     {
/*  41: 39 */       if (conn != null) {
/*  42:    */         try
/*  43:    */         {
/*  44: 41 */           conn.close();
/*  45:    */         }
/*  46:    */         catch (SQLException e)
/*  47:    */         {
/*  48: 43 */           e.printStackTrace();
/*  49:    */         }
/*  50:    */       }
/*  51:    */     }
/*  52: 48 */     return "";
/*  53:    */   }
/*  54:    */   
/*  55:    */   public static String nombreEstacion(Long idEstacion)
/*  56:    */   {
/*  57: 52 */     Connection conn = null;
/*  58: 53 */     Session session = HibernateSessionFactory.getSession();
/*  59: 54 */     Transaction tr = null;
/*  60:    */     try
/*  61:    */     {
/*  62: 56 */       tr = session.beginTransaction();
/*  63: 57 */       return String.valueOf(session
/*  64: 58 */         .createSQLQuery(
/*  65: 59 */         Utiles.sqlNombreSiovEstacion(
/*  66: 60 */         String.valueOf(idEstacion))).uniqueResult()
/*  67: 61 */         .toString());
/*  68:    */     }
/*  69:    */     catch (Exception localException) {}finally
/*  70:    */     {
/*  71: 65 */       if (conn != null) {
/*  72:    */         try
/*  73:    */         {
/*  74: 67 */           conn.close();
/*  75:    */         }
/*  76:    */         catch (SQLException e)
/*  77:    */         {
/*  78: 69 */           e.printStackTrace();
/*  79:    */         }
/*  80:    */       }
/*  81:    */     }
/*  82: 74 */     return "Código no válido";
/*  83:    */   }
/*  84:    */   
/*  85:    */   public static String codigoEstacion(String idEstacion)
/*  86:    */   {
/*  87: 78 */     Connection conn = null;
/*  88: 79 */     Session session = HibernateSessionFactory.getSession();
/*  89: 80 */     Transaction tr = null;
/*  90:    */     try
/*  91:    */     {
/*  92: 82 */       tr = session.beginTransaction();
/*  93: 83 */       return String.valueOf(session
/*  94: 84 */         .createSQLQuery(
/*  95: 85 */         Utiles.sqlEstacionIdSiovEstacion(idEstacion))
/*  96: 86 */         .uniqueResult().toString());
/*  97:    */     }
/*  98:    */     catch (Exception localException) {}finally
/*  99:    */     {
/* 100: 90 */       if (conn != null) {
/* 101:    */         try
/* 102:    */         {
/* 103: 92 */           conn.close();
/* 104:    */         }
/* 105:    */         catch (SQLException e)
/* 106:    */         {
/* 107: 94 */           e.printStackTrace();
/* 108:    */         }
/* 109:    */       }
/* 110:    */     }
/* 111: 99 */     return "Código no válido";
/* 112:    */   }
/* 113:    */   
/* 114:    */   public static String siguienteGrupo(String nuevoAreaOperativa, String nuevoCuenca)
/* 115:    */   {
/* 116:104 */     if (nuevoAreaOperativa == null) {
/* 117:105 */       return "---";
/* 118:    */     }
/* 119:107 */     if (nuevoCuenca == null) {
/* 120:108 */       return "---";
/* 121:    */     }
/* 122:110 */     if (nuevoAreaOperativa.equals("---")) {
/* 123:111 */       return "---";
/* 124:    */     }
/* 125:113 */     if (nuevoCuenca.equals("---")) {
/* 126:114 */       return "---";
/* 127:    */     }
/* 128:116 */     if (nuevoAreaOperativa.equals("")) {
/* 129:117 */       return "---";
/* 130:    */     }
/* 131:119 */     if (nuevoCuenca.equals("")) {
/* 132:120 */       return "---";
/* 133:    */     }
/* 134:    */     try
/* 135:    */     {
/* 136:124 */       return 
/* 137:125 */         String.valueOf(HibernateSessionFactory.currentSession()
/* 138:126 */         .createSQLQuery(
/* 139:127 */         Utiles.sqlMaxGrupo(nuevoAreaOperativa, 
/* 140:128 */         nuevoCuenca)).uniqueResult()
/* 141:129 */         .toString());
/* 142:    */     }
/* 143:    */     catch (Exception e)
/* 144:    */     {
/* 145:131 */       e.printStackTrace();
/* 146:    */     }
/* 147:133 */     return "---";
/* 148:    */   }
/* 149:    */   
/* 150:    */   public static String obtenerVariable(String variable)
/* 151:    */   {
/* 152:137 */     if (variable == null) {
/* 153:138 */       return "---";
/* 154:    */     }
/* 155:140 */     if (variable == "") {
/* 156:141 */       return "---";
/* 157:    */     }
/* 158:143 */     if (variable.equals("---")) {
/* 159:144 */       return "---";
/* 160:    */     }
/* 161:147 */     if (variable.equals(NombresTitulosAplicacion.CAUDAL.nombreTitulo)) {
/* 162:148 */       variable = "select MSFL_CODE from idt_MEASURE_FIELDS where LOWER(MSFL_NAME) =  LOWER('CAUDAL MEDIO DIARIO')";
/* 163:    */     }
/* 164:150 */     if (variable.equals(NombresTitulosAplicacion.PRECIPITACION.nombreTitulo)) {
/* 165:151 */       variable = "select MSFL_CODE from idt_MEASURE_FIELDS where LOWER(MSFL_NAME) =  LOWER('PRECIPITACION TOTAL DIARIA') AND MSFL_VRB_CODE = 'PCP_TTL_DRO'";
/* 166:    */     }
/* 167:    */     try
/* 168:    */     {
/* 169:155 */       return String.valueOf(HibernateSessionFactory.currentSession().createSQLQuery(variable)
/* 170:156 */         .uniqueResult().toString());
/* 171:    */     }
/* 172:    */     catch (Exception e)
/* 173:    */     {
/* 174:158 */       e.printStackTrace();
/* 175:    */     }
/* 176:160 */     return "---";
/* 177:    */   }
/* 178:    */ }


/* Location:           C:\Users\Luis\Desktop\CLXX\BalanceQL\Fuentes\
 * Qualified Name:     sia.bql.persistencia.BDOperacion
 * JD-Core Version:    0.7.0.1
 */