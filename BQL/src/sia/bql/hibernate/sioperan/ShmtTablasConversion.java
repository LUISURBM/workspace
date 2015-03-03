/*   1:    */ package sia.bql.hibernate.sioperan;
/*   2:    */ 
/*   3:    */ import java.io.Serializable;
/*   4:    */ import java.util.Date;
/*   5:    */ import java.util.HashSet;
/*   6:    */ import java.util.List;
/*   7:    */ import java.util.Set;
/*   8:    */ import org.apache.commons.lang.ObjectUtils;
/*   9:    */ import org.hibernate.Query;
/*  10:    */ import org.hibernate.Session;
/*  11:    */ 
/*  12:    */ public class ShmtTablasConversion
/*  13:    */   extends AbstractShmtTablasConversion
/*  14:    */   implements Serializable
/*  15:    */ {
/*  16:    */   static final String ECUACION_ACTIVA = "A";
/*  17:    */   private static final long serialVersionUID = 1L;
/*  18:    */   
/*  19:    */   public static List<ShmtTablasConversion> obtenerEcuacionesPorEstacionYTipo(Long estacion, Long tipo)
/*  20:    */   {
/*  21: 28 */     return sia.bql.hibernate.HibernateSessionFactory.currentSession().getNamedQuery("obtenerEcuacionesPorEstacionYTipo").setParameter("estacion", estacion).setParameter("tipo", tipo).list();
/*  22:    */   }
/*  23:    */   
/*  24:    */   public static List<ShmtTablasConversion> obtenerEcuacionesPorAreaOperativa(String arreaOperativa, Long tipo)
/*  25:    */   {
/*  26: 32 */     return sia.bql.hibernate.HibernateSessionFactory.currentSession().getNamedQuery("obtenerEcuacionesPorAreaOperativa").setParameter("areaOperativa", arreaOperativa).setParameter("tipo", tipo).list();
/*  27:    */   }
/*  28:    */   
/*  29:    */   public static List<ShmtTablasConversion> obtenerEstadoEcuacion(Long estId)
/*  30:    */   {
/*  31: 42 */     return sia.bql.hibernate.HibernateSessionFactory.currentSession().getNamedQuery("codigoEstacion").setParameter("estacion", estId).list();
/*  32:    */   }
/*  33:    */   
/*  34:    */   public static Long siguienteCodigoSisdhim(Long codigoEstacion, Long tipoEcuacionAsLong)
/*  35:    */   {
/*  36: 52 */     return Long.valueOf(((Long)ObjectUtils.defaultIfNull((Long)sia.bql.hibernate.HibernateSessionFactory.getSession().getNamedQuery("codigoSisdhim").setParameter("codEstacion", codigoEstacion).setParameter("tipo", tipoEcuacionAsLong).uniqueResult(), Long.valueOf(0L))).longValue() + 1L);
/*  37:    */   }
/*  38:    */   
/*  39:    */   public static Long codigoSisdhimActual(Long codigoEstacion, Long tipoEcuacionAsLong, Date fechaInicio, Date fechaFin)
/*  40:    */   {
/*  41: 55 */     return (Long)sia.bql.hibernate.HibernateSessionFactory.getSession().getNamedQuery("codigoSisdhimActual").setParameter("codEstacion", codigoEstacion).setParameter("tipo", tipoEcuacionAsLong).setParameter("fechaInicio", fechaInicio).setParameter("fechaFin", fechaFin).uniqueResult();
/*  42:    */   }
/*  43:    */   
/*  44:    */   public static Long primerCodigoSisdhim(Long codigoEstacion, Long tipoEcuacionAsLong)
/*  45:    */   {
/*  46: 58 */     return (Long)sia.bql.hibernate.HibernateSessionFactory.getSession().getNamedQuery("primerCodigoSisdhim").setParameter("codEstacion", codigoEstacion).setParameter("tipo", tipoEcuacionAsLong).uniqueResult();
/*  47:    */   }
/*  48:    */   
/*  49:    */   public static Long ultimoCodigoSisdhim(Long codigoEstacion, Long tipoEcuacionAsLong)
/*  50:    */   {
/*  51: 61 */     return (Long)sia.bql.hibernate.HibernateSessionFactory.getSession().getNamedQuery("codigoSisdhim").setParameter("codEstacion", codigoEstacion).setParameter("tipo", tipoEcuacionAsLong).uniqueResult();
/*  52:    */   }
/*  53:    */   
/*  54: 63 */   private Set<ShmtEcuacionesNq> shmtEcuacionesNqs = new HashSet(1);
/*  55:    */   private Long tbcnId;
/*  56:    */   
/*  57:    */   public ShmtTablasConversion() {}
/*  58:    */   
/*  59:    */   public ShmtTablasConversion(Long tbcnId)
/*  60:    */   {
/*  61: 76 */     this.tbcnId = tbcnId;
/*  62:    */   }
/*  63:    */   
/*  64:    */   public void addShmtEcuacionesNqs(ShmtEcuacionesNq ecuacion)
/*  65:    */   {
/*  66: 84 */     this.shmtEcuacionesNqs.add(ecuacion);
/*  67:    */   }
/*  68:    */   
/*  69:    */   public Set<ShmtEcuacionesNq> getShmtEcuacionesNqs()
/*  70:    */   {
/*  71: 92 */     return this.shmtEcuacionesNqs;
/*  72:    */   }
/*  73:    */   
/*  74:    */   public Long getTbcnId()
/*  75:    */   {
/*  76: 98 */     return this.tbcnId;
/*  77:    */   }
/*  78:    */   
/*  79:    */   public void setShmtEcuacionesNqs(Set<ShmtEcuacionesNq> shmtEcuacionesNqs)
/*  80:    */   {
/*  81:106 */     this.shmtEcuacionesNqs = shmtEcuacionesNqs;
/*  82:    */   }
/*  83:    */   
/*  84:    */   public void setTbcnId(Long tbcnId)
/*  85:    */   {
/*  86:112 */     this.tbcnId = tbcnId;
/*  87:    */   }
/*  88:    */   
/*  89:    */   public static List<ShmtTablasConversion> obtenerTablasYEcuacionesPorEstacionYTipo(Long estacion, Long tipo)
/*  90:    */   {
/*  91:123 */     return sia.bql.hibernate.HibernateSessionFactory.currentSession().getNamedQuery("obtenerTablasYEcuacionesPorEstacionYTipo").setParameter("estacion", estacion).setParameter("tipo", tipo).list();
/*  92:    */   }
/*  93:    */   
/*  94:    */   public static List<ShmtTablasConversion> obtenerTablasYEcuacionesPorAreaOperativa(String areaOperativa)
/*  95:    */   {
/*  96:133 */     return HibernateSessionFactory.getSession().getNamedQuery("obtenerTablasYEcuacionesPorAreaOperativa").setParameter("areaOperativa", areaOperativa).list();
/*  97:    */   }
/*  98:    */   
/*  99:    */   public static Date fechaInicioVigenciaEcuacionReciente(Long codigoEstacion, Long tipoEcuacionAsLong)
/* 100:    */   {
/* 101:143 */     return (Date)sia.bql.hibernate.HibernateSessionFactory.getSession().getNamedQuery("fechaInicioEcuacionReciente").setParameter("estacion", codigoEstacion).setParameter("tipo", tipoEcuacionAsLong).uniqueResult();
/* 102:    */   }
/* 103:    */   
/* 104:    */   public static Date siguienteEcuacion(Long codigoEstacion, Long tipoEcuacionAsLong)
/* 105:    */   {
/* 106:147 */     Date fechaEcuacion = (Date)HibernateSessionFactory.getSession().getNamedQuery("fechaInicioEcuacionReciente").setParameter("estacion", codigoEstacion).setParameter("tipo", tipoEcuacionAsLong).uniqueResult();
/* 107:148 */     Date fechaSigiente = (Date)fechaEcuacion.clone();
/* 108:149 */     fechaSigiente.setDate(fechaSigiente.getDate() + 1);
/* 109:150 */     return fechaSigiente;
/* 110:    */   }
/* 111:    */   
/* 112:    */   public static ShmtTablasConversion obtenerTablaYEcuacionActiva(Long estacionId, Long tipoEcuacionAsLong)
/* 113:    */   {
/* 114:153 */     return (ShmtTablasConversion)HibernateSessionFactory.getSession().getNamedQuery("obtenerTablaYEcuacionActiva").setParameter("estacion", estacionId).setParameter("tipo", tipoEcuacionAsLong).uniqueResult();
/* 115:    */   }
/* 116:    */   
/* 117:    */   public static List<ShmtTablasConversion> obtenerCorrespondenciaEntreFechas(Long estacionId, Long tipoEcuacionAsLong, Date fechaInicio, Date fechaCierre)
/* 118:    */   {
/* 119:166 */     return HibernateSessionFactory.getSession().getNamedQuery("obtenerCorrespondenciaEntreFechas").setParameter("estacion", estacionId).setParameter("tipo", tipoEcuacionAsLong).setParameter("fechaInicio", fechaInicio).setParameter("fechaCierre", fechaCierre).list();
/* 120:    */   }
/* 121:    */ }


/* Location:           C:\Users\Luis\Desktop\CLXX\BalanceQL\Fuentes\
 * Qualified Name:     sia.bql.hibernate.sioperan.ShmtTablasConversion
 * JD-Core Version:    0.7.0.1
 */