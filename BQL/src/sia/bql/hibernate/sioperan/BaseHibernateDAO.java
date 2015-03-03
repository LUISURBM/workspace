/*   1:    */ package sia.bql.hibernate.sioperan;
/*   2:    */ 
/*   3:    */ import java.io.PrintStream;
/*   4:    */ import java.math.BigDecimal;
/*   5:    */ import java.util.List;
/*   6:    */ import org.apache.commons.lang.math.NumberUtils;
/*   7:    */ import org.hibernate.Query;
/*   8:    */ import org.hibernate.Session;
/*   9:    */ import sia.bql.logica.InfoEstacion;
/*  10:    */ 
/*  11:    */ public class BaseHibernateDAO
/*  12:    */   implements IBaseHibernateDAO
/*  13:    */ {
/*  14:    */   public static Long autoIncrement(String primaryKey, String tabla)
/*  15:    */   {
/*  16: 14 */     String queryString = "select max(" + primaryKey + ") from " + 
/*  17: 15 */       tabla;
/*  18: 16 */     Query queryObject = HibernateSessionFactory.getSession()
/*  19: 17 */       .createQuery(queryString);
/*  20: 18 */     Object queryObjectUniqueResult = queryObject.uniqueResult();
/*  21: 19 */     if (queryObjectUniqueResult == null) {
/*  22: 20 */       return NumberUtils.LONG_ONE;
/*  23:    */     }
/*  24: 21 */     String stringResults = String.valueOf(queryObjectUniqueResult);
/*  25: 22 */     return Long.valueOf(NumberUtils.toLong(stringResults) + 1L);
/*  26:    */   }
/*  27:    */   
/*  28:    */   public Long autoIncrementRestriction(String primaryKey, String tabla, String restriction)
/*  29:    */   {
/*  30: 27 */     String queryString = "select max(tbcnCodigoSisdhim) from " + 
/*  31: 28 */       tabla + " where " + restriction;
/*  32: 29 */     Query queryObject = getSession().createQuery(queryString);
/*  33: 30 */     Object queryObjectUniqueResult = queryObject.uniqueResult();
/*  34: 31 */     if (queryObjectUniqueResult == null)
/*  35:    */     {
/*  36: 32 */       Long longResults = new Long(1L);
/*  37: 33 */       return longResults;
/*  38:    */     }
/*  39: 35 */     String stringResults = String.valueOf(queryObjectUniqueResult);
/*  40: 36 */     Long longResults = new Long(Long.parseLong(stringResults) + 1L);
/*  41: 37 */     return longResults;
/*  42:    */   }
/*  43:    */   
/*  44:    */   public Session getSession()
/*  45:    */   {
/*  46: 41 */     return HibernateSessionFactory.getSession();
/*  47:    */   }
/*  48:    */   
/*  49:    */   public InfoEstacion buscarEstacion(String estacion)
/*  50:    */   {
/*  51: 46 */     InfoEstacion infoEstacion = new InfoEstacion();
/*  52:    */     
/*  53: 48 */     String sql = "SELECT  e.ID_ES, e.NOMBRE_ES, e.CATEGORIA_ES , e.ESTADO_ES ,e.DESC_CATEGORIA, e.ALTURA_REFERENCIA_ES, e.ALTITUD,e.NOMBRE_FGDA, e.GRADOS_LATITUD, e.MINUTOS_LATITUD, e.SEGUNDOS_LATITUD, e.DIRECCION_LATITUD ,e.NOM_AREA ,e.NOM_ZONA ,e.NOM_SUBZONA ,e.GRADOS_LONGITUD , e.MINUTOS_LONGITUD, e.SEGUNDOS_LONGITUD ,e.DIRECCION_LONGITUD, ALTITUD,e.CODIGO_DIVIPOLA, e. ID_AREA, e.ID_ZONA, e.ID_SUBZONA, e.ID_CORRIENTE ,e.SIGLA_FGDA,div.NOMBRE_DV as municipio, div.NOMBRE_PADRE_DV as departamento , r.RAZON_SOCIAL as AREAOPERATIVA FROM SIOPERAN.SIOV_ESTACIONES e, SIOPERAN.SIOV_DIVIPOLAS div,  SIOPERAN.SIO_ORGANIZACION  r  WHERE div.CODIGO_DV=e.CODIGO_DIVIPOLA AND(e.COD_CATALOGO_ES='" + 
/*  54:    */     
/*  55:    */ 
/*  56:    */ 
/*  57:    */ 
/*  58:    */ 
/*  59:    */ 
/*  60:    */ 
/*  61:    */ 
/*  62:    */ 
/*  63:    */ 
/*  64:    */ 
/*  65:    */ 
/*  66:    */ 
/*  67:    */ 
/*  68:    */ 
/*  69:    */ 
/*  70:    */ 
/*  71: 66 */       estacion + "' or e.ID_ES =" + 
/*  72: 67 */       estacion + " ) " + "AND r.TIPO = 'AOP' " + 
/*  73: 68 */       "AND r.ORGANIZACION_ID = e.ID_ORG";
/*  74:    */     
/*  75: 70 */     Query queryObject = getSession().createSQLQuery(sql);
/*  76: 71 */     Object[] queryObjectUniqueResult = (Object[])queryObject
/*  77: 72 */       .uniqueResult();
/*  78: 73 */     if (queryObjectUniqueResult.length >= 8)
/*  79:    */     {
/*  80: 75 */       System.out.println("Dato 8" + queryObjectUniqueResult[8]);
/*  81: 76 */       infoEstacion.setNombreEstacion((String)queryObjectUniqueResult[2]);
/*  82: 77 */       String categoria = (String)queryObjectUniqueResult[3] + " " + 
/*  83: 78 */         (String)queryObjectUniqueResult[5];
/*  84: 79 */       infoEstacion.setCategoria(categoria);
/*  85: 80 */       String latitud = (BigDecimal)queryObjectUniqueResult[9] + "º" + 
/*  86: 81 */         (BigDecimal)queryObjectUniqueResult[10] + "'" + 
/*  87: 82 */         (BigDecimal)queryObjectUniqueResult[11] + "''" + 
/*  88: 83 */         (String)queryObjectUniqueResult[12];
/*  89: 84 */       infoEstacion.setLatitud(latitud);
/*  90: 85 */       String longitud = (BigDecimal)queryObjectUniqueResult[16] + "º" + 
/*  91: 86 */         (BigDecimal)queryObjectUniqueResult[17] + "'" + 
/*  92: 87 */         (BigDecimal)queryObjectUniqueResult[18] + "''" + 
/*  93: 88 */         (String)queryObjectUniqueResult[19];
/*  94: 89 */       infoEstacion.setLongitud(longitud);
/*  95: 90 */       infoEstacion.setCorriente((String)queryObjectUniqueResult[25]);
/*  96: 91 */       infoEstacion.setMunicipio((String)queryObjectUniqueResult[27]);
/*  97: 92 */       infoEstacion.setDepartamento((String)queryObjectUniqueResult[28]);
/*  98: 93 */       infoEstacion
/*  99: 94 */         .setAreaHidrografica((String)queryObjectUniqueResult[13]);
/* 100: 95 */       infoEstacion
/* 101: 96 */         .setZonaHidrografica((String)queryObjectUniqueResult[14]);
/* 102: 97 */       infoEstacion
/* 103: 98 */         .setSubzonaHidrografica((String)queryObjectUniqueResult[15]);
/* 104: 99 */       infoEstacion.setElevacion((BigDecimal)queryObjectUniqueResult[20] + 
/* 105:100 */         " msnm ");
/* 106:101 */       infoEstacion.setEntidad((String)queryObjectUniqueResult[26]);
/* 107:102 */       String areaOperativa = (String)queryObjectUniqueResult[29];
/* 108:103 */       infoEstacion.setAreaOperativa(areaOperativa);
/* 109:104 */       return infoEstacion;
/* 110:    */     }
/* 111:107 */     return null;
/* 112:    */   }
/* 113:    */   
/* 114:    */   public static List<Object[]> listarVariables(String categoria)
/* 115:    */   {
/* 116:113 */     String queryString = "select FML_CODE, FML_NAME FROM IDT_FAMILIES WHERE FML_FMTP_CODE = 'CTG_EST' AND lower(FML_DESCRIPTION) LIKE lower('%" + 
/* 117:114 */       categoria + "%')";
/* 118:115 */     Query queryObject = HibernateSessionFactory.getSession()
/* 119:116 */       .createSQLQuery(queryString);
/* 120:117 */     List<Object[]> queryObjectListResult = queryObject.list();
/* 121:118 */     if (queryObjectListResult == null) {
/* 122:119 */       return null;
/* 123:    */     }
/* 124:121 */     return queryObjectListResult;
/* 125:    */   }
/* 126:    */   
/* 127:    */   public static List<Object[]> listarVariablesPrecipitacion()
/* 128:    */   {
/* 129:125 */     String queryString = "SELECT fml_code FROM IDT_FAMILIES WHERE FML_FMTP_CODE = 'CTG_EST' AND (lower(FML_DESCRIPTION) LIKE lower(%Agrometeorologica%) OR lower(FML_DESCRIPTION) LIKE lower(%Climatologica%) OR lower(FML_DESCRIPTION) LIKE lower(%Meteorologica Especial%) OR lower(FML_DESCRIPTION) LIKE lower(%Pluvio%) OR lower(FML_DESCRIPTION) LIKE lower(%Sinoptica%))";
/* 130:    */     
/* 131:    */ 
/* 132:    */ 
/* 133:    */ 
/* 134:130 */     Query queryObject = HibernateSessionFactory.getSession()
/* 135:131 */       .createSQLQuery("SELECT fml_code FROM IDT_FAMILIES WHERE FML_FMTP_CODE = 'CTG_EST' AND (lower(FML_DESCRIPTION) LIKE lower(%Agrometeorologica%) OR lower(FML_DESCRIPTION) LIKE lower(%Climatologica%) OR lower(FML_DESCRIPTION) LIKE lower(%Meteorologica Especial%) OR lower(FML_DESCRIPTION) LIKE lower(%Pluvio%) OR lower(FML_DESCRIPTION) LIKE lower(%Sinoptica%))");
/* 136:132 */     List<Object[]> queryObjectListResult = queryObject.list();
/* 137:133 */     if (queryObjectListResult == null) {
/* 138:134 */       return null;
/* 139:    */     }
/* 140:136 */     return queryObjectListResult;
/* 141:    */   }
/* 142:    */   
/* 143:    */   public static List<Object[]> listarVariablesNivel()
/* 144:    */   {
/* 145:140 */     String queryString = "SELECT fml_code FROM IDT_FAMILIES WHERE FML_FMTP_CODE = 'CTG_EST' AND ( lower(FML_DESCRIPTION) LIKE lower(%Limni%) OR (FML_DESCRIPTION) LIKE (%Hidrologica%))";
/* 146:    */     
/* 147:    */ 
/* 148:143 */     Query queryObject = HibernateSessionFactory.getSession()
/* 149:144 */       .createSQLQuery("SELECT fml_code FROM IDT_FAMILIES WHERE FML_FMTP_CODE = 'CTG_EST' AND ( lower(FML_DESCRIPTION) LIKE lower(%Limni%) OR (FML_DESCRIPTION) LIKE (%Hidrologica%))");
/* 150:145 */     List<Object[]> queryObjectListResult = queryObject.list();
/* 151:146 */     if (queryObjectListResult == null) {
/* 152:147 */       return null;
/* 153:    */     }
/* 154:149 */     return queryObjectListResult;
/* 155:    */   }
/* 156:    */ }


/* Location:           C:\Users\Luis\Desktop\CLXX\BalanceQL\Fuentes\
 * Qualified Name:     sia.bql.hibernate.sioperan.BaseHibernateDAO
 * JD-Core Version:    0.7.0.1
 */