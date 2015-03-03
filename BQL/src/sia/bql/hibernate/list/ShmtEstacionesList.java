/*   1:    */ package sia.bql.hibernate.list;
/*   2:    */ 
/*   3:    */ import java.math.BigDecimal;
/*   4:    */ import java.util.ArrayList;
/*   5:    */ import java.util.Date;
/*   6:    */ import java.util.List;
/*   7:    */ import org.hibernate.SQLQuery;
/*   8:    */ import org.hibernate.Session;
/*   9:    */ import sia.bql.hibernate.HibernateSessionFactory;
/*  10:    */ import sia.bql.hibernate.hidromet.ShmtEstacionBalanceQl;
/*  11:    */ import sia.bql.hibernate.sioperan.SioCuencasHidrograficas;
/*  12:    */ import sia.bql.i18n.NombresTitulosAplicacion;
/*  13:    */ 
/*  14:    */ public class ShmtEstacionesList
/*  15:    */   extends ShmtEstacionBalanceQl
/*  16:    */ {
/*  17:    */   private static final long serialVersionUID = 1L;
/*  18:    */   private Date fechaInicio;
/*  19:    */   private Date fechaFin;
/*  20:    */   private String variable;
/*  21:    */   private Long grbcId;
/*  22:    */   private SioCuencasHidrograficas cuenca;
/*  23:    */   private Long areaOperativa;
/*  24:    */   private int tamaño;
/*  25:    */   
/*  26:    */   public Long getGrbcId()
/*  27:    */   {
/*  28: 30 */     return this.grbcId;
/*  29:    */   }
/*  30:    */   
/*  31:    */   public void setGrbcId(Long grbcId)
/*  32:    */   {
/*  33: 34 */     this.grbcId = grbcId;
/*  34:    */   }
/*  35:    */   
/*  36:    */   public SioCuencasHidrograficas getCuenca()
/*  37:    */   {
/*  38: 38 */     return this.cuenca;
/*  39:    */   }
/*  40:    */   
/*  41:    */   public void setCuenca(SioCuencasHidrograficas cuenca)
/*  42:    */   {
/*  43: 42 */     this.cuenca = cuenca;
/*  44:    */   }
/*  45:    */   
/*  46:    */   public Long getAreaOperativa()
/*  47:    */   {
/*  48: 46 */     return this.areaOperativa;
/*  49:    */   }
/*  50:    */   
/*  51:    */   public void setAreaOperativa(Long areaOperativa)
/*  52:    */   {
/*  53: 50 */     this.areaOperativa = areaOperativa;
/*  54:    */   }
/*  55:    */   
/*  56:    */   public Date getFechaInicio()
/*  57:    */   {
/*  58: 54 */     return this.fechaInicio;
/*  59:    */   }
/*  60:    */   
/*  61:    */   public void setFechaInicio(Date fechaInicio)
/*  62:    */   {
/*  63: 58 */     this.fechaInicio = fechaInicio;
/*  64:    */   }
/*  65:    */   
/*  66:    */   public Date getFechaFin()
/*  67:    */   {
/*  68: 62 */     return this.fechaFin;
/*  69:    */   }
/*  70:    */   
/*  71:    */   public void setFechaFin(Date fechaFin)
/*  72:    */   {
/*  73: 66 */     this.fechaFin = fechaFin;
/*  74:    */   }
/*  75:    */   
/*  76:    */   public String getVariable()
/*  77:    */   {
/*  78: 70 */     return this.variable;
/*  79:    */   }
/*  80:    */   
/*  81:    */   public void setVariable(String variable)
/*  82:    */   {
/*  83: 74 */     this.variable = variable;
/*  84:    */   }
/*  85:    */   
/*  86:    */   public int getTamaño()
/*  87:    */   {
/*  88: 78 */     this.tamaño = 
/*  89:    */     
/*  90: 80 */       ((BigDecimal)HibernateSessionFactory.currentSession().createSQLQuery("SELECT COUNT(1) FROM SHMT_ESTACION_BALANCE_QL WHERE EGBQ_GRBC_ID = " + this.grbcId).uniqueResult()).intValue();
/*  91: 81 */     return this.tamaño;
/*  92:    */   }
/*  93:    */   
/*  94:    */   public void setTamaño(int tamaño)
/*  95:    */   {
/*  96: 85 */     this.tamaño = tamaño;
/*  97:    */   }
/*  98:    */   
/*  99:    */   public List<ShmtEstacionBalanceQl> getEstaciones()
/* 100:    */   {
/* 101: 89 */     if (this.grbcId != null) {
/* 102: 90 */       if (this.grbcId.equals("---")) {
/* 103: 91 */         this.grbcId = null;
/* 104:    */       } else {
/* 105: 93 */         return 
/* 106: 94 */           ShmtEstacionBalanceQl.consultaEstacionEnGruposArea(getGrbcId());
/* 107:    */       }
/* 108:    */     }
/* 109: 97 */     return new ArrayList();
/* 110:    */   }
/* 111:    */   
/* 112:    */   public List<ShmtEstacionBalanceQl> getEstaciones(String var)
/* 113:    */   {
/* 114:101 */     if (this.grbcId != null) {
/* 115:102 */       if (this.grbcId.equals("---")) {
/* 116:103 */         this.grbcId = null;
/* 117:    */       } else {
/* 118:105 */         return 
/* 119:106 */           ShmtEstacionBalanceQl.consultaEstacionEnGruposArea(getGrbcId(), var);
/* 120:    */       }
/* 121:    */     }
/* 122:109 */     return new ArrayList();
/* 123:    */   }
/* 124:    */   
/* 125:    */   public List<ShmtEstacionBalanceQl> getEstacionesNvl()
/* 126:    */   {
/* 127:113 */     if (this.grbcId != null) {
/* 128:114 */       if (this.grbcId.equals("---")) {
/* 129:115 */         this.grbcId = null;
/* 130:    */       } else {
/* 131:117 */         return 
/* 132:118 */           ShmtEstacionBalanceQl.consultaEstacionEnGruposArea(getGrbcId(), 
/* 133:119 */           NombresTitulosAplicacion.NIVEL.nombreTitulo);
/* 134:    */       }
/* 135:    */     }
/* 136:122 */     return new ArrayList();
/* 137:    */   }
/* 138:    */   
/* 139:    */   public List<ShmtEstacionBalanceQl> getEstacionesPm()
/* 140:    */   {
/* 141:126 */     if (this.grbcId != null) {
/* 142:127 */       if (this.grbcId.equals("---")) {
/* 143:128 */         this.grbcId = null;
/* 144:    */       } else {
/* 145:130 */         return 
/* 146:131 */           ShmtEstacionBalanceQl.consultaEstacionEnGruposArea(
/* 147:132 */           getGrbcId(), 
/* 148:133 */           NombresTitulosAplicacion.PRECIPITACION.nombreTitulo);
/* 149:    */       }
/* 150:    */     }
/* 151:136 */     return new ArrayList();
/* 152:    */   }
/* 153:    */ }


/* Location:           C:\Users\Luis\Desktop\CLXX\BalanceQL\Fuentes\
 * Qualified Name:     sia.bql.hibernate.list.ShmtEstacionesList
 * JD-Core Version:    0.7.0.1
 */