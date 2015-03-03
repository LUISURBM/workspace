/*   1:    */ package sia.bql.hibernate.hidromet;
/*   2:    */ 
/*   3:    */ import java.io.Serializable;
/*   4:    */ import java.util.ArrayList;
/*   5:    */ import java.util.Date;
/*   6:    */ import java.util.List;
/*   7:    */ import sia.bql.bean.util.Archivo;
/*   8:    */ import sia.bql.ftp.BartTransfer;
/*   9:    */ import sia.bql.hibernate.sioperan.SioCuencasHidrograficas;
/*  10:    */ import sia.bql.i18n.NombresTitulosAplicacion;
/*  11:    */ 
/*  12:    */ public abstract class AbstractShmtGrupoBalanceCaudal
/*  13:    */   implements Serializable
/*  14:    */ {
/*  15:    */   private static final long serialVersionUID = 1L;
/*  16:    */   private Long grbcId;
/*  17:    */   private SioCuencasHidrograficas cuenca;
/*  18:    */   private Date grbcFecha;
/*  19:    */   private Long areaOperativa;
/*  20:    */   private String grbcGrafo;
/*  21:    */   private Long grbcUsuario;
/*  22:    */   private Long grbcNumero;
/*  23:    */   private List<ShmtEstacionBalanceQl> estaciones;
/*  24:    */   
/*  25:    */   public Long getGrbcId()
/*  26:    */   {
/*  27: 46 */     return this.grbcId;
/*  28:    */   }
/*  29:    */   
/*  30:    */   public void setGrbcId(Long grbcId)
/*  31:    */   {
/*  32: 50 */     this.grbcId = grbcId;
/*  33:    */   }
/*  34:    */   
/*  35:    */   public SioCuencasHidrograficas getCuenca()
/*  36:    */   {
/*  37: 54 */     return this.cuenca;
/*  38:    */   }
/*  39:    */   
/*  40:    */   public void setCuenca(String cuenca)
/*  41:    */   {
/*  42: 58 */     this.cuenca = new SioCuencasHidrograficas();
/*  43: 59 */     this.cuenca.setCuencaHidrograficaId(Long.valueOf(cuenca));
/*  44:    */   }
/*  45:    */   
/*  46:    */   public void setCuenca(SioCuencasHidrograficas cuenca)
/*  47:    */   {
/*  48: 63 */     this.cuenca = cuenca;
/*  49:    */   }
/*  50:    */   
/*  51:    */   public Date getGrbcFecha()
/*  52:    */   {
/*  53: 67 */     return this.grbcFecha;
/*  54:    */   }
/*  55:    */   
/*  56:    */   public void setGrbcFecha(Date grbcFecha)
/*  57:    */   {
/*  58: 71 */     this.grbcFecha = grbcFecha;
/*  59:    */   }
/*  60:    */   
/*  61:    */   public Long getAreaOperativa()
/*  62:    */   {
/*  63: 75 */     return this.areaOperativa;
/*  64:    */   }
/*  65:    */   
/*  66:    */   public void setAreaOperativa(Long areaOperativa)
/*  67:    */   {
/*  68: 79 */     this.areaOperativa = areaOperativa;
/*  69:    */   }
/*  70:    */   
/*  71:    */   public String getGrbcGrafo()
/*  72:    */   {
/*  73: 83 */     return this.grbcGrafo;
/*  74:    */   }
/*  75:    */   
/*  76:    */   public Long getGrbcNumero()
/*  77:    */   {
/*  78: 87 */     return this.grbcNumero;
/*  79:    */   }
/*  80:    */   
/*  81:    */   public void setGrbcNumero(Long grbcNumero)
/*  82:    */   {
/*  83: 91 */     this.grbcNumero = grbcNumero;
/*  84:    */   }
/*  85:    */   
/*  86:    */   public void setGrbcGrafo(String grbcGrafo)
/*  87:    */   {
/*  88: 95 */     this.grbcGrafo = grbcGrafo;
/*  89:    */   }
/*  90:    */   
/*  91:    */   public Archivo getGrafo()
/*  92:    */   {
/*  93: 99 */     if (this.grbcGrafo == null)
/*  94:    */     {
/*  95:100 */       this.grbcGrafo = null;
/*  96:101 */       return null;
/*  97:    */     }
/*  98:103 */     if (this.grbcGrafo.equals("---"))
/*  99:    */     {
/* 100:104 */       this.grbcGrafo = null;
/* 101:105 */       return null;
/* 102:    */     }
/* 103:107 */     if (this.grbcGrafo.equals(""))
/* 104:    */     {
/* 105:108 */       this.grbcGrafo = null;
/* 106:109 */       return null;
/* 107:    */     }
/* 108:    */     try
/* 109:    */     {
/* 110:113 */       HmstPath path = 
/* 111:114 */         HmstPath.obtenerDirectoriosFtp(NombresTitulosAplicacion.PATH_COMPONENTE.nombreTitulo);
/* 112:115 */       BartTransfer bt = new BartTransfer(path.getPathServer(), 
/* 113:116 */         path.getPathUserFtp(), path.getPathPassword());
/* 114:117 */       String archivoRemoto = getNombreGrafo();
/* 115:118 */       return bt.bajarImagen(
/* 116:119 */         NombresTitulosAplicacion.DIRECTORIO_CONTEXTO.nombreTitulo, 
/* 117:120 */         archivoRemoto);
/* 118:    */     }
/* 119:    */     catch (Exception e)
/* 120:    */     {
/* 121:122 */       e.printStackTrace();
/* 122:    */     }
/* 123:123 */     return null;
/* 124:    */   }
/* 125:    */   
/* 126:    */   public Long getGrbcUsuario()
/* 127:    */   {
/* 128:128 */     return this.grbcUsuario;
/* 129:    */   }
/* 130:    */   
/* 131:    */   public void setGrbcUsuario(Long grbcUsuario)
/* 132:    */   {
/* 133:132 */     this.grbcUsuario = grbcUsuario;
/* 134:    */   }
/* 135:    */   
/* 136:    */   public List<ShmtEstacionBalanceQl> getEstaciones()
/* 137:    */   {
/* 138:136 */     if (this.grbcId != null)
/* 139:    */     {
/* 140:137 */       if (this.grbcId.equals("---"))
/* 141:    */       {
/* 142:138 */         this.grbcId = null;
/* 143:139 */         return new ArrayList();
/* 144:    */       }
/* 145:141 */       return 
/* 146:142 */         ShmtEstacionBalanceQl.consultaEstacionEnGruposArea(getGrbcId());
/* 147:    */     }
/* 148:146 */     if (this.grbcNumero == null)
/* 149:    */     {
/* 150:147 */       this.grbcNumero = null;
/* 151:148 */       return new ArrayList();
/* 152:    */     }
/* 153:150 */     if (this.areaOperativa == null)
/* 154:    */     {
/* 155:151 */       this.areaOperativa = null;
/* 156:152 */       return new ArrayList();
/* 157:    */     }
/* 158:154 */     if (this.cuenca == null)
/* 159:    */     {
/* 160:155 */       this.cuenca = null;
/* 161:156 */       return new ArrayList();
/* 162:    */     }
/* 163:    */     try
/* 164:    */     {
/* 165:159 */       this.estaciones = 
/* 166:160 */         ShmtEstacionBalanceQl.consultaEstacionEnGruposArea(
/* 167:161 */         ShmtGrupoBalanceCaudal.obtenerGrupo(getAreaOperativa().toString(), 
/* 168:162 */         getCuenca().getCuencaHidrograficaId(), 
/* 169:163 */         getGrbcNumero()).getGrbcId());
/* 170:    */     }
/* 171:    */     catch (Exception e)
/* 172:    */     {
/* 173:165 */       this.estaciones = new ArrayList();
/* 174:    */     }
/* 175:167 */     return this.estaciones;
/* 176:    */   }
/* 177:    */   
/* 178:    */   public void setEstaciones(List<ShmtEstacionBalanceQl> estaciones)
/* 179:    */   {
/* 180:172 */     this.estaciones = estaciones;
/* 181:    */   }
/* 182:    */   
/* 183:    */   public abstract String getNombreGrafo();
/* 184:    */ }


/* Location:           C:\Users\Luis\Desktop\CLXX\BalanceQL\Fuentes\
 * Qualified Name:     sia.bql.hibernate.hidromet.AbstractShmtGrupoBalanceCaudal
 * JD-Core Version:    0.7.0.1
 */