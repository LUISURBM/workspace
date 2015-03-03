/*   1:    */ package sia.bql.hibernate.sioperan;
/*   2:    */ 
/*   3:    */ import java.io.Serializable;
/*   4:    */ import java.util.Date;
/*   5:    */ import java.util.List;
/*   6:    */ import org.hibernate.Query;
/*   7:    */ import org.hibernate.Session;
/*   8:    */ import sia.bql.hibernate.HibernateSessionFactory;
/*   9:    */ 
/*  10:    */ public class SioCuencasHidrograficas
/*  11:    */   implements Serializable
/*  12:    */ {
/*  13:    */   private static final long serialVersionUID = 1L;
/*  14:    */   private Long cuencaHidrograficaId;
/*  15:    */   private String codigo;
/*  16:    */   private String nombre;
/*  17:    */   private String tipo;
/*  18:    */   private Date fechaCreacion;
/*  19:    */   private Date fechaModificacion;
/*  20:    */   private String clase;
/*  21:    */   private Long cuencaPadreId;
/*  22:    */   private String codigoPath;
/*  23:    */   
/*  24:    */   public Long getCuencaHidrograficaId()
/*  25:    */   {
/*  26: 30 */     return this.cuencaHidrograficaId;
/*  27:    */   }
/*  28:    */   
/*  29:    */   public void setCuencaHidrograficaId(Long cuencaHidrograficaId)
/*  30:    */   {
/*  31: 34 */     this.cuencaHidrograficaId = cuencaHidrograficaId;
/*  32:    */   }
/*  33:    */   
/*  34:    */   public String getCodigo()
/*  35:    */   {
/*  36: 38 */     return this.codigo;
/*  37:    */   }
/*  38:    */   
/*  39:    */   public void setCodigo(String codigo)
/*  40:    */   {
/*  41: 42 */     this.codigo = codigo;
/*  42:    */   }
/*  43:    */   
/*  44:    */   public String getNombre()
/*  45:    */   {
/*  46: 46 */     return this.nombre;
/*  47:    */   }
/*  48:    */   
/*  49:    */   public void setNombre(String nombre)
/*  50:    */   {
/*  51: 50 */     this.nombre = nombre;
/*  52:    */   }
/*  53:    */   
/*  54:    */   public String getTipo()
/*  55:    */   {
/*  56: 54 */     return this.tipo;
/*  57:    */   }
/*  58:    */   
/*  59:    */   public void setTipo(String tipo)
/*  60:    */   {
/*  61: 58 */     this.tipo = tipo;
/*  62:    */   }
/*  63:    */   
/*  64:    */   public Date getFechaCreacion()
/*  65:    */   {
/*  66: 62 */     return this.fechaCreacion;
/*  67:    */   }
/*  68:    */   
/*  69:    */   public void setFechaCreacion(Date fechaCreacion)
/*  70:    */   {
/*  71: 66 */     this.fechaCreacion = fechaCreacion;
/*  72:    */   }
/*  73:    */   
/*  74:    */   public Date getFechaModificacion()
/*  75:    */   {
/*  76: 70 */     return this.fechaModificacion;
/*  77:    */   }
/*  78:    */   
/*  79:    */   public void setFechaModificacion(Date fechaModificacion)
/*  80:    */   {
/*  81: 74 */     this.fechaModificacion = fechaModificacion;
/*  82:    */   }
/*  83:    */   
/*  84:    */   public String getClase()
/*  85:    */   {
/*  86: 78 */     return this.clase;
/*  87:    */   }
/*  88:    */   
/*  89:    */   public void setClase(String clase)
/*  90:    */   {
/*  91: 82 */     this.clase = clase;
/*  92:    */   }
/*  93:    */   
/*  94:    */   public Long getCuencaPadreId()
/*  95:    */   {
/*  96: 86 */     return this.cuencaPadreId;
/*  97:    */   }
/*  98:    */   
/*  99:    */   public void setCuencaPadreId(Long cuencaPadreId)
/* 100:    */   {
/* 101: 90 */     this.cuencaPadreId = cuencaPadreId;
/* 102:    */   }
/* 103:    */   
/* 104:    */   public String getCodigoPath()
/* 105:    */   {
/* 106: 94 */     return this.codigoPath;
/* 107:    */   }
/* 108:    */   
/* 109:    */   public void setCodigoPath(String codigoPath)
/* 110:    */   {
/* 111: 98 */     this.codigoPath = codigoPath;
/* 112:    */   }
/* 113:    */   
/* 114:    */   public static List<Object[]> obtenerCuencaHidrograf()
/* 115:    */   {
/* 116:103 */     String query = "select cuenca_hidrografica_id,nombre from sio_cuencas_hidrograficas ";
/* 117:104 */     Query q = HibernateSessionFactory.currentSession().createSQLQuery(query);
/* 118:105 */     List<Object[]> listObject = q.list();
/* 119:106 */     return listObject;
/* 120:    */   }
/* 121:    */   
/* 122:    */   public static List<Object[]> obtenerSbZCuencaHidrograf()
/* 123:    */   {
/* 124:112 */     String query = "select cuenca_hidrografica_id,nombre,clase from sio_cuencas_hidrograficas where clase = 'MIC'";
/* 125:113 */     Query q = HibernateSessionFactory.currentSession().createSQLQuery(query);
/* 126:114 */     List<Object[]> listObject = q.list();
/* 127:115 */     return listObject;
/* 128:    */   }
/* 129:    */   
/* 130:    */   public static List<Object[]> obtenerSbZCuencaHidrografAop(String aop)
/* 131:    */   {
/* 132:120 */     String query = "select distinct(cuenca_hidrografica_id),nombre,clase from sio_cuencas_hidrograficas,Shmt_Grupo_balance_caudal g where clase = 'MIC' and g.GRBC_CUENCA_ID =cuenca_hidrografica_id and g.GRBC_AOP_ID = " + 
/* 133:121 */       aop + " order by nombre";
/* 134:122 */     Query q = HibernateSessionFactory.currentSession().createSQLQuery(query);
/* 135:123 */     List<Object[]> listObject = q.list();
/* 136:124 */     return listObject;
/* 137:    */   }
/* 138:    */   
/* 139:    */   public static SioCuencasHidrograficas cuencaPorId(String nuevoCuenca)
/* 140:    */   {
/* 141:130 */     String query = "select c from SioCuencasHidrograficas as c where c.cuencaHidrograficaId = '" + 
/* 142:131 */       nuevoCuenca + "'";
/* 143:132 */     Query q = HibernateSessionFactory.currentSession().createQuery(query);
/* 144:133 */     return (SioCuencasHidrograficas)q.uniqueResult();
/* 145:    */   }
/* 146:    */   
/* 147:    */   public static SioCuencasHidrograficas cuencaPorNombre(String nuevoCuenca)
/* 148:    */   {
/* 149:137 */     String query = "select c from SioCuencasHidrograficas as c where c.nombre = '" + 
/* 150:138 */       nuevoCuenca + "'";
/* 151:139 */     Query q = HibernateSessionFactory.currentSession().createQuery(query);
/* 152:140 */     return (SioCuencasHidrograficas)q.uniqueResult();
/* 153:    */   }
/* 154:    */ }


/* Location:           C:\Users\Luis\Desktop\CLXX\BalanceQL\Fuentes\
 * Qualified Name:     sia.bql.hibernate.sioperan.SioCuencasHidrograficas
 * JD-Core Version:    0.7.0.1
 */