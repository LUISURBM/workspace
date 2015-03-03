/*   1:    */ package sia.bql.hibernate.hidromet;
/*   2:    */ 
import static java.text.NumberFormat.getIntegerInstance;
/*   3:    */ import java.io.Serializable;
/*   4:    */ import java.text.NumberFormat;
/*   5:    */ import java.util.AbstractList;
/*   6:    */ import java.util.Date;
/*   7:    */ import java.util.List;
/*   8:    */ import org.apache.commons.beanutils.PropertyUtils;
/*   9:    */ import org.hibernate.Query;
/*  10:    */ import org.hibernate.Session;
/*  11:    */ import sia.bql.bean.util.Utiles;
/*  12:    */ import sia.bql.hibernate.HibernateSessionFactory;
/*  13:    */ 
/*  14:    */ public class ShmtDiarios
/*  15:    */   extends AbstractShmtDiarios
/*  16:    */   implements Serializable
/*  17:    */ {
/*  18:    */   private static final long serialVersionUID = -5610865750592773279L;
/*  19:    */   
/*  20:    */   public static List<ShmtDiarios> consultarCaudalesEnEstacionYAno(Long estacionId, Long año, String variable)
/*  21:    */   {
/*  22: 32 */     return 
/*  23:    */     
/*  24:    */ 
/*  25: 35 */       HibernateSessionFactory.currentSession().getNamedQuery("consultaCaudalesEnEstacionYAno").setParameter("estacionId", new Long(estacionId.longValue())).setParameter("año", new Long(año.longValue())).setParameter("variable", variable).list();
/*  26:    */   }
/*  27:    */   
/*  28:    */   private final class ListaDiarios
/*  29:    */     extends AbstractList<ShmtDiarios.ValorUnitario>
/*  30:    */   {
/*  31:    */     private ListaDiarios() {}
/*  32:    */     
/*  33:    */     public ShmtDiarios.ValorUnitario get(int index)
/*  34:    */     {
/*  35: 41 */       return new ShmtDiarios.ValorUnitario(index + 1);
/*  36:    */     }
/*  37:    */     
/*  38:    */     public int size()
/*  39:    */     {
/*  40: 46 */       return 31;
/*  41:    */     }
/*  42:    */   }
/*  43:    */   
/*  44:    */   public final class ValorUnitario
/*  45:    */   {
/*  46:    */     private final int i;
/*  47:    */     
/*  48:    */     ValorUnitario(int i)
/*  49:    */     {
/*  50: 54 */       this.i = i;
/*  51:    */     }
/*  52:    */     
/*  53:    */     public int getI()
/*  54:    */     {
/*  55: 58 */       return this.i;
/*  56:    */     }
/*  57:    */     
/*  58:    */     public Double getValor()
/*  59:    */     {
/*  60:    */       try
/*  61:    */       {
/*  62: 63 */         return (Double)PropertyUtils.getProperty(ShmtDiarios.this.echo(), "drsValor" + 
/*  63: 64 */           ShmtDiarios.formatoUnEnteros.format(this.i));
/*  64:    */       }
/*  65:    */       catch (Exception e) {}
/*  66: 67 */       return Double.valueOf(-1.0D);
/*  67:    */     }
/*  68:    */     
/*  69:    */     public Date getFecha()
/*  70:    */     {
/*  71:    */       try
/*  72:    */       {
/*  73: 73 */         return new Date(Integer.parseInt(PropertyUtils.getProperty(ShmtDiarios.this.echo(), "drsAno")
/*  74: 74 */           .toString()), Integer.parseInt(PropertyUtils.getProperty(ShmtDiarios.this.echo(), 
/*  75: 75 */           "drsMes").toString()), 
/*  76: 76 */           Integer.parseInt(ShmtDiarios.formatoDosEnteros.format(this.i)
/*  77: 77 */           .toString()));
/*  78:    */       }
/*  79:    */       catch (Exception e)
/*  80:    */       {
/*  81: 79 */         throw new RuntimeException(e);
/*  82:    */       }
/*  83:    */     }
/*  84:    */     
/*  85:    */     public String getDate()
/*  86:    */     {
/*  87:    */       try
/*  88:    */       {
/*  89: 85 */         return 
/*  90:    */         
/*  91: 87 */           (Long)PropertyUtils.getProperty(ShmtDiarios.this.echo(), "drsAno") + " / " + (Long)PropertyUtils.getProperty(ShmtDiarios.this.echo(), "drsMes") + " / " + ShmtDiarios.formatoDosEnteros.format(this.i).toString();
/*  92:    */       }
/*  93:    */       catch (Exception e)
/*  94:    */       {
/*  95: 89 */         throw new RuntimeException(e);
/*  96:    */       }
/*  97:    */     }
/*  98:    */     
/*  99:    */     public String getDiaMes()
/* 100:    */     {
/* 101:    */       try
/* 102:    */       {
/* 103: 95 */         return 
/* 104:    */         
/* 105:    */ 
/* 106: 98 */           Utiles.nombMes(((Long)PropertyUtils.getProperty(ShmtDiarios.this.echo(), "drsMes")).intValue() - 1) + " / " + ShmtDiarios.formatoDosEnteros.format(this.i).toString();
/* 107:    */       }
/* 108:    */       catch (Exception e)
/* 109:    */       {
/* 110:100 */         throw new RuntimeException(e);
/* 111:    */       }
/* 112:    */     }
/* 113:    */     
/* 114:    */     public int getDia()
/* 115:    */     {
/* 116:    */       try
/* 117:    */       {
/* 118:106 */         return Utiles.isPeriocidadAnual() ? Utiles.getDiasHastaFecha(
/* 119:107 */           ((Long)PropertyUtils.getProperty(ShmtDiarios.this.echo(), "drsAno")).intValue(), 
/* 120:108 */           ((Long)PropertyUtils.getProperty(ShmtDiarios.this.echo(), "drsMes")).intValue() - 1, 
/* 121:109 */           this.i - 1) : this.i;
/* 122:    */       }
/* 123:    */       catch (Exception e)
/* 124:    */       {
/* 125:111 */         throw new RuntimeException(e);
/* 126:    */       }
/* 127:    */     }
/* 128:    */   }
/* 129:    */   
/* 130:116 */   private final ListaDiarios listaDiarios = new ListaDiarios();
/* 131:    */   public static final NumberFormat formatoDosEnteros;
/* 132:    */   
/* 133:    */   public ValorUnitario[] arregloHorarios()
/* 134:    */   {
/* 135:119 */     return (ValorUnitario[])this.listaDiarios.toArray(new ValorUnitario[this.listaDiarios.size()]);
/* 136:    */   }
/* 137:    */   
/* 138:    */   private ShmtDiarios echo()
/* 139:    */   {
/* 140:123 */     return this;
/* 141:    */   }
/* 142:    */   
	/* 143:129 */public static final NumberFormat formatoUnEnteros = getIntegerInstance();
/* 144:    */   
/* 145:    */   static
/* 146:    */   {
/* 147:130 */     formatoUnEnteros.setMinimumIntegerDigits(1);
/* 148:131 */     formatoDosEnteros = NumberFormat.getIntegerInstance();
/* 149:132 */     formatoDosEnteros.setMinimumIntegerDigits(2);
/* 150:    */   }
/* 151:    */   
/* 152:    */   public List<ValorUnitario> getListaHorarios()
/* 153:    */   {
/* 154:136 */     return this.listaDiarios;
/* 155:    */   }
/* 156:    */ }


/* Location:           C:\Users\Luis\Desktop\CLXX\BalanceQL\Fuentes\
 * Qualified Name:     sia.bql.hibernate.hidromet.ShmtDiarios
 * JD-Core Version:    0.7.0.1
 */