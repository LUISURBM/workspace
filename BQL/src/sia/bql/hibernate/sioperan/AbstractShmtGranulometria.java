/*   1:    */ package sia.bql.hibernate.sioperan;
/*   2:    */ 
/*   3:    */ import java.util.Date;
/*   4:    */ import java.util.HashSet;
/*   5:    */ import java.util.Set;
/*   6:    */ 
/*   7:    */ public class AbstractShmtGranulometria
/*   8:    */ {
/*   9:    */   private Long grnEstacionId;
/*  10:    */   private Long grnId;
/*  11:    */   private Long grnEquipoMuestreador;
/*  12:    */   private Long grnTiempoTamizado;
/*  13:    */   private Long grnFluviometro;
/*  14:    */   private Double grnAbscisa;
/*  15:    */   private Double grnPesoTotMuestra;
/*  16:    */   private Double grnPesoTotMuestraTratada;
/*  17:    */   private Date grnFecha;
/*  18:    */   private Date grnFechaAnalisis;
/*  19:    */   private Date grnFechaMuestreo;
/*  20:    */   private String grnMetodoProceso;
/*  21:    */   private String grnNombreAnalista;
/*  22:    */   private String grnObservaciones;
/*  23:    */   private String grnCoordProg;
/*  24:    */   private String grnTipoSedimento;
/*  25:    */   private IdtUsers idtUsers;
/*  26: 13 */   private Set<ShmtGranulometriaCalculos> shmtGranulometriaCalculoses = new HashSet(0);
/*  27:    */   
/*  28:    */   public Double getGrnAbscisa()
/*  29:    */   {
/*  30: 15 */     return this.grnAbscisa;
/*  31:    */   }
/*  32:    */   
/*  33:    */   public String getGrnCoordProg()
/*  34:    */   {
/*  35: 18 */     return this.grnCoordProg;
/*  36:    */   }
/*  37:    */   
/*  38:    */   public Long getGrnEquipoMuestreador()
/*  39:    */   {
/*  40: 21 */     return this.grnEquipoMuestreador;
/*  41:    */   }
/*  42:    */   
/*  43:    */   public Date getGrnFecha()
/*  44:    */   {
/*  45: 24 */     return this.grnFecha;
/*  46:    */   }
/*  47:    */   
/*  48:    */   public Date getGrnFechaAnalisis()
/*  49:    */   {
/*  50: 27 */     return this.grnFechaAnalisis;
/*  51:    */   }
/*  52:    */   
/*  53:    */   public Date getGrnFechaMuestreo()
/*  54:    */   {
/*  55: 30 */     return this.grnFechaMuestreo;
/*  56:    */   }
/*  57:    */   
/*  58:    */   public Long getGrnFluviometro()
/*  59:    */   {
/*  60: 33 */     return this.grnFluviometro;
/*  61:    */   }
/*  62:    */   
/*  63:    */   public String getGrnMetodoProceso()
/*  64:    */   {
/*  65: 36 */     return this.grnMetodoProceso;
/*  66:    */   }
/*  67:    */   
/*  68:    */   public String getGrnNombreAnalista()
/*  69:    */   {
/*  70: 39 */     return this.grnNombreAnalista;
/*  71:    */   }
/*  72:    */   
/*  73:    */   public String getGrnObservaciones()
/*  74:    */   {
/*  75: 42 */     return this.grnObservaciones;
/*  76:    */   }
/*  77:    */   
/*  78:    */   public Double getGrnPesoTotMuestra()
/*  79:    */   {
/*  80: 45 */     return this.grnPesoTotMuestra;
/*  81:    */   }
/*  82:    */   
/*  83:    */   public Double getGrnPesoTotMuestraTratada()
/*  84:    */   {
/*  85: 48 */     return this.grnPesoTotMuestraTratada;
/*  86:    */   }
/*  87:    */   
/*  88:    */   public Long getGrnTiempoTamizado()
/*  89:    */   {
/*  90: 51 */     return this.grnTiempoTamizado;
/*  91:    */   }
/*  92:    */   
/*  93:    */   public String getGrnTipoSedimento()
/*  94:    */   {
/*  95: 54 */     return this.grnTipoSedimento;
/*  96:    */   }
/*  97:    */   
/*  98:    */   public IdtUsers getIdtUsers()
/*  99:    */   {
/* 100: 57 */     return this.idtUsers;
/* 101:    */   }
/* 102:    */   
/* 103:    */   public void setIdtUsers(IdtUsers idtUsers)
/* 104:    */   {
/* 105: 60 */     this.idtUsers = idtUsers;
/* 106:    */   }
/* 107:    */   
/* 108:    */   public Set<ShmtGranulometriaCalculos> getShmtGranulometriaCalculoses()
/* 109:    */   {
/* 110: 63 */     return this.shmtGranulometriaCalculoses;
/* 111:    */   }
/* 112:    */   
/* 113:    */   public void setGrnAbscisa(Double grnAbscisa)
/* 114:    */   {
/* 115: 66 */     this.grnAbscisa = grnAbscisa;
/* 116:    */   }
/* 117:    */   
/* 118:    */   public void setGrnCoordProg(String grnCoordProg)
/* 119:    */   {
/* 120: 69 */     this.grnCoordProg = grnCoordProg;
/* 121:    */   }
/* 122:    */   
/* 123:    */   public void setGrnEquipoMuestreador(Long grnEquipoMuestreador)
/* 124:    */   {
/* 125: 72 */     this.grnEquipoMuestreador = grnEquipoMuestreador;
/* 126:    */   }
/* 127:    */   
/* 128:    */   public void setGrnFecha(Date grnFecha)
/* 129:    */   {
/* 130: 75 */     this.grnFecha = grnFecha;
/* 131:    */   }
/* 132:    */   
/* 133:    */   public void setGrnFechaAnalisis(Date grnFechaAnalisis)
/* 134:    */   {
/* 135: 78 */     this.grnFechaAnalisis = grnFechaAnalisis;
/* 136:    */   }
/* 137:    */   
/* 138:    */   public void setGrnFechaMuestreo(Date grnFechaMuestreo)
/* 139:    */   {
/* 140: 81 */     this.grnFechaMuestreo = grnFechaMuestreo;
/* 141:    */   }
/* 142:    */   
/* 143:    */   public void setGrnFluviometro(Long grnFluviometro)
/* 144:    */   {
/* 145: 84 */     this.grnFluviometro = grnFluviometro;
/* 146:    */   }
/* 147:    */   
/* 148:    */   public void setGrnMetodoProceso(String grnMetodoProceso)
/* 149:    */   {
/* 150: 87 */     this.grnMetodoProceso = grnMetodoProceso;
/* 151:    */   }
/* 152:    */   
/* 153:    */   public void setGrnNombreAnalista(String grnNombreAnalista)
/* 154:    */   {
/* 155: 90 */     this.grnNombreAnalista = grnNombreAnalista;
/* 156:    */   }
/* 157:    */   
/* 158:    */   public void setGrnObservaciones(String grnObservaciones)
/* 159:    */   {
/* 160: 93 */     this.grnObservaciones = grnObservaciones;
/* 161:    */   }
/* 162:    */   
/* 163:    */   public void setGrnPesoTotMuestra(Double grnPesoTotMuestra)
/* 164:    */   {
/* 165: 96 */     this.grnPesoTotMuestra = grnPesoTotMuestra;
/* 166:    */   }
/* 167:    */   
/* 168:    */   public void setGrnPesoTotMuestraTratada(Double grnPesoTotMuestraTratada)
/* 169:    */   {
/* 170: 99 */     this.grnPesoTotMuestraTratada = grnPesoTotMuestraTratada;
/* 171:    */   }
/* 172:    */   
/* 173:    */   public void setGrnTiempoTamizado(Long grnTiempoTamizado)
/* 174:    */   {
/* 175:102 */     this.grnTiempoTamizado = grnTiempoTamizado;
/* 176:    */   }
/* 177:    */   
/* 178:    */   public void setGrnTipoSedimento(String grnTipoSedimento)
/* 179:    */   {
/* 180:105 */     this.grnTipoSedimento = grnTipoSedimento;
/* 181:    */   }
/* 182:    */   
/* 183:    */   public void setShmtGranulometriaCalculoses(Set<ShmtGranulometriaCalculos> shmtGranulometriaCalculoses)
/* 184:    */   {
/* 185:108 */     this.shmtGranulometriaCalculoses = shmtGranulometriaCalculoses;
/* 186:    */   }
/* 187:    */   
/* 188:    */   public Long getGrnEstacionId()
/* 189:    */   {
/* 190:111 */     return this.grnEstacionId;
/* 191:    */   }
/* 192:    */   
/* 193:    */   public Long getGrnId()
/* 194:    */   {
/* 195:114 */     return this.grnId;
/* 196:    */   }
/* 197:    */   
/* 198:    */   public void setGrnEstacionId(Long grnEstacionId)
/* 199:    */   {
/* 200:117 */     this.grnEstacionId = grnEstacionId;
/* 201:    */   }
/* 202:    */   
/* 203:    */   public void setGrnId(Long grnId)
/* 204:    */   {
/* 205:120 */     this.grnId = grnId;
/* 206:    */   }
/* 207:    */ }


/* Location:           C:\Users\Luis\Desktop\CLXX\BalanceQL\Fuentes\
 * Qualified Name:     sia.bql.hibernate.sioperan.AbstractShmtGranulometria
 * JD-Core Version:    0.7.0.1
 */