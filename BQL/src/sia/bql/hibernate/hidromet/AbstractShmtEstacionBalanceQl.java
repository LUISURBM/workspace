/*   1:    */ package sia.bql.hibernate.hidromet;
/*   2:    */ 
/*   3:    */ import java.io.Serializable;
/*   4:    */ import java.util.ArrayList;
/*   5:    */ import java.util.Calendar;
/*   6:    */ import java.util.Date;
/*   7:    */ import java.util.GregorianCalendar;
/*   8:    */ import java.util.List;
/*   9:    */ import sia.bql.hibernate.sioperan.SiovEstacionesId;
/*  10:    */ 
/*  11:    */ public abstract class AbstractShmtEstacionBalanceQl
/*  12:    */   implements Serializable
/*  13:    */ {
/*  14:    */   private static final long serialVersionUID = 1L;
/*  15:    */   private Long egbqId;
/*  16:    */   private Long grbcId;
/*  17:    */   private Long grupo;
/*  18:    */   private SiovEstacionesId estacion;
/*  19:    */   private String egbqObservacion;
/*  20:    */   private Double egbqPeso;
/*  21:    */   private int nuevoPeso;
/*  22:    */   private Long egbqTipo;
/*  23:    */   private Date egbqFecha;
/*  24:    */   private Long egbqUsuario;
/*  25:    */   private Long seqNum;
/*  26:    */   
/*  27:    */   public AbstractShmtEstacionBalanceQl() {}
/*  28:    */   
/*  29:    */   public AbstractShmtEstacionBalanceQl(String nombre, String id, String idCatalogo, String categoria, Long idGrupo, String usuario, Long tipoEstacion)
/*  30:    */   {
/*  31: 46 */     this.estacion = new SiovEstacionesId(nombre, id, idCatalogo, categoria);
/*  32: 47 */     this.grupo = idGrupo;
/*  33: 48 */     this.egbqUsuario = Long.valueOf(usuario);
/*  34: 49 */     this.egbqFecha = GregorianCalendar.getInstance().getTime();
/*  35: 50 */     this.egbqTipo = tipoEstacion;
/*  36:    */   }
/*  37:    */   
/*  38:    */   public Long getEgbqId()
/*  39:    */   {
/*  40: 54 */     return this.egbqId;
/*  41:    */   }
/*  42:    */   
/*  43:    */   public void setEgbqId(Long egbqId)
/*  44:    */   {
/*  45: 58 */     this.egbqId = egbqId;
/*  46:    */   }
/*  47:    */   
/*  48:    */   public Long getGrupo()
/*  49:    */   {
/*  50: 62 */     return this.grupo;
/*  51:    */   }
/*  52:    */   
/*  53:    */   public void setGrupo(Long grupo)
/*  54:    */   {
/*  55: 66 */     this.grupo = grupo;
/*  56:    */   }
/*  57:    */   
/*  58:    */   public SiovEstacionesId getEstacion()
/*  59:    */   {
/*  60: 70 */     return this.estacion;
/*  61:    */   }
/*  62:    */   
/*  63:    */   public void setEstacion(SiovEstacionesId estacion)
/*  64:    */   {
/*  65: 74 */     this.estacion = estacion;
/*  66:    */   }
/*  67:    */   
/*  68:    */   public String getEgbqObservacion()
/*  69:    */   {
/*  70: 78 */     return this.egbqObservacion;
/*  71:    */   }
/*  72:    */   
/*  73:    */   public void setEgbqObservacion(String egbqObservacion)
/*  74:    */   {
/*  75: 82 */     this.egbqObservacion = egbqObservacion;
/*  76:    */   }
/*  77:    */   
/*  78:    */   public Double getEgbqPeso()
/*  79:    */   {
/*  80: 86 */     return this.egbqPeso;
/*  81:    */   }
/*  82:    */   
/*  83:    */   public void setEgbqPeso(Double egbqPeso)
/*  84:    */   {
/*  85: 90 */     this.egbqPeso = egbqPeso;
/*  86:    */   }
/*  87:    */   
/*  88:    */   public Long getEgbqTipo()
/*  89:    */   {
/*  90: 94 */     return this.egbqTipo;
/*  91:    */   }
/*  92:    */   
/*  93:    */   public void setEgbqTipo(Long egbqTipo)
/*  94:    */   {
/*  95: 98 */     this.egbqTipo = egbqTipo;
/*  96:    */   }
/*  97:    */   
/*  98:    */   public Date getEgbqFecha()
/*  99:    */   {
/* 100:102 */     return this.egbqFecha;
/* 101:    */   }
/* 102:    */   
/* 103:    */   public void setEgbqFecha(Date egbqFecha)
/* 104:    */   {
/* 105:106 */     this.egbqFecha = egbqFecha;
/* 106:    */   }
/* 107:    */   
/* 108:    */   public Long getEgbqUsuario()
/* 109:    */   {
/* 110:110 */     return this.egbqUsuario;
/* 111:    */   }
/* 112:    */   
/* 113:    */   public void setEgbqUsuario(Long egbqUsuario)
/* 114:    */   {
/* 115:114 */     this.egbqUsuario = egbqUsuario;
/* 116:    */   }
/* 117:    */   
/* 118:    */   public int getNuevoPeso()
/* 119:    */   {
/* 120:118 */     return this.nuevoPeso;
/* 121:    */   }
/* 122:    */   
/* 123:    */   public void setNuevoPeso(int nuevoPeso)
/* 124:    */   {
/* 125:122 */     this.egbqPeso = Double.valueOf(Double.valueOf(nuevoPeso).doubleValue() / 100.0D);
/* 126:123 */     this.nuevoPeso = nuevoPeso;
/* 127:    */   }
/* 128:    */   
/* 129:    */   public Long getSeqNum()
/* 130:    */   {
/* 131:127 */     return this.seqNum;
/* 132:    */   }
/* 133:    */   
/* 134:    */   public void setSeqNum(Long seqNum)
/* 135:    */   {
/* 136:131 */     this.seqNum = seqNum;
/* 137:    */   }
/* 138:    */   
/* 139:    */   public final List<ShmtDiarios> getSecuenciaDiario(Date fInicio, Date fFin, String variable)
/* 140:    */   {
/* 141:136 */     return ShmtDiarios.consultarCaudalesEnEstacionYAno(
/* 142:137 */       this.estacion.getIdEs(), Long.valueOf(fInicio.getYear() + 1900L), variable);
/* 143:    */   }
/* 144:    */   
/* 145:    */   public List<ShmtEstacionBalanceQl> getEstaciones()
/* 146:    */   {
/* 147:141 */     if (this.grbcId != null) {
/* 148:142 */       if (this.grbcId.equals("---")) {
/* 149:143 */         this.grbcId = null;
/* 150:    */       } else {
/* 151:145 */         return 
/* 152:146 */           ShmtEstacionBalanceQl.consultaEstacionEnGruposArea(this.grbcId);
/* 153:    */       }
/* 154:    */     }
/* 155:149 */     return new ArrayList();
/* 156:    */   }
/* 157:    */ }


/* Location:           C:\Users\Luis\Desktop\CLXX\BalanceQL\Fuentes\
 * Qualified Name:     sia.bql.hibernate.hidromet.AbstractShmtEstacionBalanceQl
 * JD-Core Version:    0.7.0.1
 */