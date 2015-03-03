/*  1:   */ package sia.bql.hibernate.sioperan;
/*  2:   */ 
/*  3:   */ import java.io.Serializable;
/*  4:   */ import java.util.Date;
/*  5:   */ 
/*  6:   */ public class SioRolesOrganizacionPma
/*  7:   */   implements Serializable
/*  8:   */ {
/*  9:   */   private static final long serialVersionUID = 1L;
/* 10:   */   private Long rolOrgPmaId;
/* 11:   */   private SioOrganizacion sioOrganizacion;
/* 12:   */   private SioEstaciones sioEstaciones;
/* 13:   */   private String tipo;
/* 14:   */   private String estado;
/* 15:   */   private String funcion;
/* 16:   */   private Date fechaCreacion;
/* 17:   */   private Date fechaModificacion;
/* 18:   */   private Date fechaTerminacion;
/* 19:   */   private Date fechaAsignacion;
/* 20:   */   
/* 21:   */   public Long getRolOrgPmaId()
/* 22:   */   {
/* 23:20 */     return this.rolOrgPmaId;
/* 24:   */   }
/* 25:   */   
/* 26:   */   public void setRolOrgPmaId(Long rolOrgPmaId)
/* 27:   */   {
/* 28:23 */     this.rolOrgPmaId = rolOrgPmaId;
/* 29:   */   }
/* 30:   */   
/* 31:   */   public SioOrganizacion getSioOrganizacion()
/* 32:   */   {
/* 33:26 */     return this.sioOrganizacion;
/* 34:   */   }
/* 35:   */   
/* 36:   */   public void setSioOrganizacion(SioOrganizacion sioOrganizacion)
/* 37:   */   {
/* 38:29 */     this.sioOrganizacion = sioOrganizacion;
/* 39:   */   }
/* 40:   */   
/* 41:   */   public SioEstaciones getSioEstaciones()
/* 42:   */   {
/* 43:32 */     return this.sioEstaciones;
/* 44:   */   }
/* 45:   */   
/* 46:   */   public void setSioEstaciones(SioEstaciones sioEstaciones)
/* 47:   */   {
/* 48:35 */     this.sioEstaciones = sioEstaciones;
/* 49:   */   }
/* 50:   */   
/* 51:   */   public String getTipo()
/* 52:   */   {
/* 53:38 */     return this.tipo;
/* 54:   */   }
/* 55:   */   
/* 56:   */   public void setTipo(String tipo)
/* 57:   */   {
/* 58:41 */     this.tipo = tipo;
/* 59:   */   }
/* 60:   */   
/* 61:   */   public String getEstado()
/* 62:   */   {
/* 63:44 */     return this.estado;
/* 64:   */   }
/* 65:   */   
/* 66:   */   public void setEstado(String estado)
/* 67:   */   {
/* 68:47 */     this.estado = estado;
/* 69:   */   }
/* 70:   */   
/* 71:   */   public String getFuncion()
/* 72:   */   {
/* 73:50 */     return this.funcion;
/* 74:   */   }
/* 75:   */   
/* 76:   */   public void setFuncion(String funcion)
/* 77:   */   {
/* 78:53 */     this.funcion = funcion;
/* 79:   */   }
/* 80:   */   
/* 81:   */   public Date getFechaCreacion()
/* 82:   */   {
/* 83:56 */     return this.fechaCreacion;
/* 84:   */   }
/* 85:   */   
/* 86:   */   public void setFechaCreacion(Date fechaCreacion)
/* 87:   */   {
/* 88:59 */     this.fechaCreacion = fechaCreacion;
/* 89:   */   }
/* 90:   */   
/* 91:   */   public Date getFechaModificacion()
/* 92:   */   {
/* 93:62 */     return this.fechaModificacion;
/* 94:   */   }
/* 95:   */   
/* 96:   */   public void setFechaModificacion(Date fechaModificacion)
/* 97:   */   {
/* 98:65 */     this.fechaModificacion = fechaModificacion;
/* 99:   */   }
/* :0:   */   
/* :1:   */   public Date getFechaTerminacion()
/* :2:   */   {
/* :3:68 */     return this.fechaTerminacion;
/* :4:   */   }
/* :5:   */   
/* :6:   */   public void setFechaTerminacion(Date fechaTerminacion)
/* :7:   */   {
/* :8:71 */     this.fechaTerminacion = fechaTerminacion;
/* :9:   */   }
/* ;0:   */   
/* ;1:   */   public Date getFechaAsignacion()
/* ;2:   */   {
/* ;3:74 */     return this.fechaAsignacion;
/* ;4:   */   }
/* ;5:   */   
/* ;6:   */   public void setFechaAsignacion(Date fechaAsignacion)
/* ;7:   */   {
/* ;8:77 */     this.fechaAsignacion = fechaAsignacion;
/* ;9:   */   }
/* <0:   */ }


/* Location:           C:\Users\Luis\Desktop\CLXX\BalanceQL\Fuentes\
 * Qualified Name:     sia.bql.hibernate.sioperan.SioRolesOrganizacionPma
 * JD-Core Version:    0.7.0.1
 */