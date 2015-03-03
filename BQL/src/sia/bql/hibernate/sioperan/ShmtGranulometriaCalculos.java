/*  1:   */ package sia.bql.hibernate.sioperan;
/*  2:   */ 
/*  3:   */ import java.io.Serializable;
/*  4:   */ import java.util.Date;
/*  5:   */ import java.util.List;
/*  6:   */ import org.hibernate.Query;
/*  7:   */ import org.hibernate.Session;
/*  8:   */ 
/*  9:   */ public class ShmtGranulometriaCalculos
/* 10:   */   extends AbstractShmtGranulometria
/* 11:   */   implements Serializable
/* 12:   */ {
/* 13:   */   private static final long serialVersionUID = 1L;
/* 14:   */   private Double grclD1;
/* 15:   */   private Double grclDm;
/* 16:   */   private Double grclP1;
/* 17:   */   private Double grclPesoRetenido;
/* 18:   */   private Double grclPorcAcumulado;
/* 19:   */   private Double grclPorcPasa;
/* 20:   */   private Double grclW1;
/* 21:   */   private Double grclWpond;
/* 22:   */   private Date grclFecha;
/* 23:   */   private Long grclId;
/* 24:   */   private IdtUsers idtUsers;
/* 25:   */   private ShmtGranulometria shmtGranulometria;
/* 26:   */   
/* 27:   */   public static List<ShmtGranulometriaCalculos> obtenerDatosGranulometria(Long grnId)
/* 28:   */   {
/* 29:14 */     return HibernateSessionFactory.currentSession().getNamedQuery("calculosGranulometria").setParameter("grnId", grnId).list();
/* 30:   */   }
/* 31:   */   
/* 32:   */   public IdtUsers getIdtUsers()
/* 33:   */   {
/* 34:21 */     return this.idtUsers;
/* 35:   */   }
/* 36:   */   
/* 37:   */   public void setIdtUsers(IdtUsers idtUsers)
/* 38:   */   {
/* 39:24 */     this.idtUsers = idtUsers;
/* 40:   */   }
/* 41:   */   
/* 42:   */   public Double getGrclD1()
/* 43:   */   {
/* 44:30 */     return this.grclD1;
/* 45:   */   }
/* 46:   */   
/* 47:   */   public Double getGrclDm()
/* 48:   */   {
/* 49:33 */     return this.grclDm;
/* 50:   */   }
/* 51:   */   
/* 52:   */   public Date getGrclFecha()
/* 53:   */   {
/* 54:36 */     return this.grclFecha;
/* 55:   */   }
/* 56:   */   
/* 57:   */   public Long getGrclId()
/* 58:   */   {
/* 59:39 */     return this.grclId;
/* 60:   */   }
/* 61:   */   
/* 62:   */   public Double getGrclP1()
/* 63:   */   {
/* 64:42 */     return this.grclP1;
/* 65:   */   }
/* 66:   */   
/* 67:   */   public Double getGrclPesoRetenido()
/* 68:   */   {
/* 69:45 */     return this.grclPesoRetenido;
/* 70:   */   }
/* 71:   */   
/* 72:   */   public Double getGrclPorcAcumulado()
/* 73:   */   {
/* 74:48 */     return this.grclPorcAcumulado;
/* 75:   */   }
/* 76:   */   
/* 77:   */   public Double getGrclPorcPasa()
/* 78:   */   {
/* 79:51 */     return this.grclPorcPasa;
/* 80:   */   }
/* 81:   */   
/* 82:   */   public Double getGrclW1()
/* 83:   */   {
/* 84:54 */     return this.grclW1;
/* 85:   */   }
/* 86:   */   
/* 87:   */   public Double getGrclWpond()
/* 88:   */   {
/* 89:57 */     return this.grclWpond;
/* 90:   */   }
/* 91:   */   
/* 92:   */   public ShmtGranulometria getShmtGranulometria()
/* 93:   */   {
/* 94:60 */     return this.shmtGranulometria;
/* 95:   */   }
/* 96:   */   
/* 97:   */   public void setGrclD1(Double grclD1)
/* 98:   */   {
/* 99:63 */     this.grclD1 = grclD1;
/* :0:   */   }
/* :1:   */   
/* :2:   */   public void setGrclDm(Double grclDm)
/* :3:   */   {
/* :4:66 */     this.grclDm = grclDm;
/* :5:   */   }
/* :6:   */   
/* :7:   */   public void setGrclFecha(Date grclFecha)
/* :8:   */   {
/* :9:69 */     this.grclFecha = grclFecha;
/* ;0:   */   }
/* ;1:   */   
/* ;2:   */   public void setGrclId(Long grclId)
/* ;3:   */   {
/* ;4:72 */     this.grclId = grclId;
/* ;5:   */   }
/* ;6:   */   
/* ;7:   */   public void setGrclP1(Double grclP1)
/* ;8:   */   {
/* ;9:75 */     this.grclP1 = grclP1;
/* <0:   */   }
/* <1:   */   
/* <2:   */   public void setGrclPesoRetenido(Double grclPesoRetenido)
/* <3:   */   {
/* <4:78 */     this.grclPesoRetenido = grclPesoRetenido;
/* <5:   */   }
/* <6:   */   
/* <7:   */   public void setGrclPorcAcumulado(Double grclPorcAcumulado)
/* <8:   */   {
/* <9:81 */     this.grclPorcAcumulado = grclPorcAcumulado;
/* =0:   */   }
/* =1:   */   
/* =2:   */   public void setGrclPorcPasa(Double grclPorcPasa)
/* =3:   */   {
/* =4:84 */     this.grclPorcPasa = grclPorcPasa;
/* =5:   */   }
/* =6:   */   
/* =7:   */   public void setGrclW1(Double grclW1)
/* =8:   */   {
/* =9:87 */     this.grclW1 = grclW1;
/* >0:   */   }
/* >1:   */   
/* >2:   */   public void setGrclWpond(Double grclWpond)
/* >3:   */   {
/* >4:90 */     this.grclWpond = grclWpond;
/* >5:   */   }
/* >6:   */   
/* >7:   */   public void setShmtGranulometria(ShmtGranulometria shmtGranulometria)
/* >8:   */   {
/* >9:93 */     this.shmtGranulometria = shmtGranulometria;
/* ?0:   */   }
/* ?1:   */ }


/* Location:           C:\Users\Luis\Desktop\CLXX\BalanceQL\Fuentes\
 * Qualified Name:     sia.bql.hibernate.sioperan.ShmtGranulometriaCalculos
 * JD-Core Version:    0.7.0.1
 */