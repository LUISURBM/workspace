/*   1:    */ package sia.bql.hibernate.sioperan;
/*   2:    */ 
/*   3:    */ import java.io.Serializable;
/*   4:    */ import java.util.Date;
/*   5:    */ 
/*   6:    */ public class SiovDivipolas
/*   7:    */   implements Serializable
/*   8:    */ {
/*   9:    */   private static final long serialVersionUID = 1L;
/*  10:    */   public static final String TABLA = "SiovDivipolas";
/*  11:    */   public static final String CODIGO_DV = "codigoDv";
/*  12:    */   private String codigoDv;
/*  13:    */   private String nombreDv;
/*  14:    */   private String estadoDv;
/*  15:    */   private String descEstado;
/*  16:    */   private Date fechaAplicacionDv;
/*  17:    */   private Long idDv;
/*  18:    */   private Long idPadreDv;
/*  19:    */   private String nombrePadreDv;
/*  20:    */   private Date fechaCreacionDv;
/*  21:    */   private Date fechaModificacionDv;
/*  22:    */   
/*  23:    */   public SiovDivipolas() {}
/*  24:    */   
/*  25:    */   public SiovDivipolas(String codigoDv, String nombreDv, String estadoDv, Long idDv, Date fechaCreacionDv, Date fechaModificacionDv)
/*  26:    */   {
/*  27: 38 */     this.codigoDv = codigoDv;
/*  28: 39 */     this.nombreDv = nombreDv;
/*  29: 40 */     this.estadoDv = estadoDv;
/*  30: 41 */     this.idDv = idDv;
/*  31: 42 */     this.fechaCreacionDv = fechaCreacionDv;
/*  32: 43 */     this.fechaModificacionDv = fechaModificacionDv;
/*  33:    */   }
/*  34:    */   
/*  35:    */   public SiovDivipolas(String codigoDv, String nombreDv, String estadoDv, String descEstado, Date fechaAplicacionDv, Long idDv, Long idPadreDv, String nombrePadreDv, Date fechaCreacionDv, Date fechaModificacionDv)
/*  36:    */   {
/*  37: 51 */     this.codigoDv = codigoDv;
/*  38: 52 */     this.nombreDv = nombreDv;
/*  39: 53 */     this.estadoDv = estadoDv;
/*  40: 54 */     this.descEstado = descEstado;
/*  41: 55 */     this.fechaAplicacionDv = fechaAplicacionDv;
/*  42: 56 */     this.idDv = idDv;
/*  43: 57 */     this.idPadreDv = idPadreDv;
/*  44: 58 */     this.nombrePadreDv = nombrePadreDv;
/*  45: 59 */     this.fechaCreacionDv = fechaCreacionDv;
/*  46: 60 */     this.fechaModificacionDv = fechaModificacionDv;
/*  47:    */   }
/*  48:    */   
/*  49:    */   public String getCodigoDv()
/*  50:    */   {
/*  51: 66 */     return this.codigoDv;
/*  52:    */   }
/*  53:    */   
/*  54:    */   public void setCodigoDv(String codigoDv)
/*  55:    */   {
/*  56: 70 */     this.codigoDv = codigoDv;
/*  57:    */   }
/*  58:    */   
/*  59:    */   public String getNombreDv()
/*  60:    */   {
/*  61: 74 */     return this.nombreDv;
/*  62:    */   }
/*  63:    */   
/*  64:    */   public void setNombreDv(String nombreDv)
/*  65:    */   {
/*  66: 78 */     this.nombreDv = nombreDv;
/*  67:    */   }
/*  68:    */   
/*  69:    */   public String getEstadoDv()
/*  70:    */   {
/*  71: 82 */     return this.estadoDv;
/*  72:    */   }
/*  73:    */   
/*  74:    */   public void setEstadoDv(String estadoDv)
/*  75:    */   {
/*  76: 86 */     this.estadoDv = estadoDv;
/*  77:    */   }
/*  78:    */   
/*  79:    */   public String getDescEstado()
/*  80:    */   {
/*  81: 90 */     return this.descEstado;
/*  82:    */   }
/*  83:    */   
/*  84:    */   public void setDescEstado(String descEstado)
/*  85:    */   {
/*  86: 94 */     this.descEstado = descEstado;
/*  87:    */   }
/*  88:    */   
/*  89:    */   public Date getFechaAplicacionDv()
/*  90:    */   {
/*  91: 98 */     return this.fechaAplicacionDv;
/*  92:    */   }
/*  93:    */   
/*  94:    */   public void setFechaAplicacionDv(Date fechaAplicacionDv)
/*  95:    */   {
/*  96:102 */     this.fechaAplicacionDv = fechaAplicacionDv;
/*  97:    */   }
/*  98:    */   
/*  99:    */   public Long getIdDv()
/* 100:    */   {
/* 101:106 */     return this.idDv;
/* 102:    */   }
/* 103:    */   
/* 104:    */   public void setIdDv(Long idDv)
/* 105:    */   {
/* 106:110 */     this.idDv = idDv;
/* 107:    */   }
/* 108:    */   
/* 109:    */   public Long getIdPadreDv()
/* 110:    */   {
/* 111:114 */     return this.idPadreDv;
/* 112:    */   }
/* 113:    */   
/* 114:    */   public void setIdPadreDv(Long idPadreDv)
/* 115:    */   {
/* 116:118 */     this.idPadreDv = idPadreDv;
/* 117:    */   }
/* 118:    */   
/* 119:    */   public String getNombrePadreDv()
/* 120:    */   {
/* 121:122 */     return this.nombrePadreDv;
/* 122:    */   }
/* 123:    */   
/* 124:    */   public void setNombrePadreDv(String nombrePadreDv)
/* 125:    */   {
/* 126:126 */     this.nombrePadreDv = nombrePadreDv;
/* 127:    */   }
/* 128:    */   
/* 129:    */   public Date getFechaCreacionDv()
/* 130:    */   {
/* 131:130 */     return this.fechaCreacionDv;
/* 132:    */   }
/* 133:    */   
/* 134:    */   public void setFechaCreacionDv(Date fechaCreacionDv)
/* 135:    */   {
/* 136:134 */     this.fechaCreacionDv = fechaCreacionDv;
/* 137:    */   }
/* 138:    */   
/* 139:    */   public Date getFechaModificacionDv()
/* 140:    */   {
/* 141:138 */     return this.fechaModificacionDv;
/* 142:    */   }
/* 143:    */   
/* 144:    */   public void setFechaModificacionDv(Date fechaModificacionDv)
/* 145:    */   {
/* 146:142 */     this.fechaModificacionDv = fechaModificacionDv;
/* 147:    */   }
/* 148:    */ }


/* Location:           C:\Users\Luis\Desktop\CLXX\BalanceQL\Fuentes\
 * Qualified Name:     sia.bql.hibernate.sioperan.SiovDivipolas
 * JD-Core Version:    0.7.0.1
 */