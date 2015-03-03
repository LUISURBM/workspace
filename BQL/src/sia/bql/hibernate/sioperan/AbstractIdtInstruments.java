/*   1:    */ package sia.bql.hibernate.sioperan;
/*   2:    */ 
/*   3:    */ import java.io.Serializable;
/*   4:    */ import java.util.Date;
/*   5:    */ import java.util.HashSet;
/*   6:    */ import java.util.Set;
/*   7:    */ 
/*   8:    */ public abstract class AbstractIdtInstruments
/*   9:    */   implements Serializable
/*  10:    */ {
/*  11:    */   private static final long serialVersionUID = 1L;
/*  12:  9 */   private Set idtInsCrcses = new HashSet(0);
/*  13:    */   private IdtInstrumentTypes idtInstrumentTypes;
/*  14:    */   private IdtUsers idtUsers;
/*  15: 12 */   private Set idtValueses = new HashSet(0);
/*  16: 13 */   private Set idtWindlassesDesiadesOlds = new HashSet(0);
/*  17:    */   private String insArop;
/*  18:    */   private String insCode;
/*  19:    */   private String insDescription;
/*  20:    */   private Long insEstacionId;
/*  21:    */   private Long insId;
/*  22:    */   private Date insTimestamp;
/*  23:    */   
/*  24:    */   public AbstractIdtInstruments() {}
/*  25:    */   
/*  26:    */   public AbstractIdtInstruments(Long insId, IdtUsers idtUsers, IdtInstrumentTypes idtInstrumentTypes, Date insTimestamp)
/*  27:    */   {
/*  28: 23 */     this.insId = insId;
/*  29: 24 */     this.idtUsers = idtUsers;
/*  30: 25 */     this.idtInstrumentTypes = idtInstrumentTypes;
/*  31: 26 */     this.insTimestamp = insTimestamp;
/*  32:    */   }
/*  33:    */   
/*  34:    */   public AbstractIdtInstruments(Long insId, IdtUsers idtUsers, IdtInstrumentTypes idtInstrumentTypes, String insCode, String insDescription, Date insTimestamp, Long insEstacionId, String insArop, Set idtInsCrcses, Set idtWindlassesDesiadesOlds, Set idtValueses)
/*  35:    */   {
/*  36: 29 */     this.insId = insId;
/*  37: 30 */     this.idtUsers = idtUsers;
/*  38: 31 */     this.idtInstrumentTypes = idtInstrumentTypes;
/*  39: 32 */     this.insCode = insCode;
/*  40: 33 */     this.insDescription = insDescription;
/*  41: 34 */     this.insTimestamp = insTimestamp;
/*  42: 35 */     this.insEstacionId = insEstacionId;
/*  43: 36 */     this.insArop = insArop;
/*  44: 37 */     this.idtInsCrcses = idtInsCrcses;
/*  45: 38 */     this.idtWindlassesDesiadesOlds = idtWindlassesDesiadesOlds;
/*  46: 39 */     this.idtValueses = idtValueses;
/*  47:    */   }
/*  48:    */   
/*  49:    */   public Set getIdtInsCrcses()
/*  50:    */   {
/*  51: 42 */     return this.idtInsCrcses;
/*  52:    */   }
/*  53:    */   
/*  54:    */   public IdtInstrumentTypes getIdtInstrumentTypes()
/*  55:    */   {
/*  56: 45 */     return this.idtInstrumentTypes;
/*  57:    */   }
/*  58:    */   
/*  59:    */   public IdtUsers getIdtUsers()
/*  60:    */   {
/*  61: 48 */     return this.idtUsers;
/*  62:    */   }
/*  63:    */   
/*  64:    */   public Set getIdtValueses()
/*  65:    */   {
/*  66: 51 */     return this.idtValueses;
/*  67:    */   }
/*  68:    */   
/*  69:    */   public Set getIdtWindlassesDesiadesOlds()
/*  70:    */   {
/*  71: 54 */     return this.idtWindlassesDesiadesOlds;
/*  72:    */   }
/*  73:    */   
/*  74:    */   public String getInsArop()
/*  75:    */   {
/*  76: 57 */     return this.insArop;
/*  77:    */   }
/*  78:    */   
/*  79:    */   public String getInsCode()
/*  80:    */   {
/*  81: 60 */     return this.insCode;
/*  82:    */   }
/*  83:    */   
/*  84:    */   public String getInsDescription()
/*  85:    */   {
/*  86: 63 */     return this.insDescription;
/*  87:    */   }
/*  88:    */   
/*  89:    */   public Long getInsEstacionId()
/*  90:    */   {
/*  91: 66 */     return this.insEstacionId;
/*  92:    */   }
/*  93:    */   
/*  94:    */   public Long getInsId()
/*  95:    */   {
/*  96: 69 */     return this.insId;
/*  97:    */   }
/*  98:    */   
/*  99:    */   public Date getInsTimestamp()
/* 100:    */   {
/* 101: 72 */     return this.insTimestamp;
/* 102:    */   }
/* 103:    */   
/* 104:    */   public void setIdtInsCrcses(Set idtInsCrcses)
/* 105:    */   {
/* 106: 75 */     this.idtInsCrcses = idtInsCrcses;
/* 107:    */   }
/* 108:    */   
/* 109:    */   public void setIdtInstrumentTypes(IdtInstrumentTypes idtInstrumentTypes)
/* 110:    */   {
/* 111: 78 */     this.idtInstrumentTypes = idtInstrumentTypes;
/* 112:    */   }
/* 113:    */   
/* 114:    */   public void setIdtUsers(IdtUsers idtUsers)
/* 115:    */   {
/* 116: 81 */     this.idtUsers = idtUsers;
/* 117:    */   }
/* 118:    */   
/* 119:    */   public void setIdtValueses(Set idtValueses)
/* 120:    */   {
/* 121: 84 */     this.idtValueses = idtValueses;
/* 122:    */   }
/* 123:    */   
/* 124:    */   public void setIdtWindlassesDesiadesOlds(Set idtWindlassesDesiadesOlds)
/* 125:    */   {
/* 126: 87 */     this.idtWindlassesDesiadesOlds = idtWindlassesDesiadesOlds;
/* 127:    */   }
/* 128:    */   
/* 129:    */   public void setInsArop(String insArop)
/* 130:    */   {
/* 131: 90 */     this.insArop = insArop;
/* 132:    */   }
/* 133:    */   
/* 134:    */   public void setInsCode(String insCode)
/* 135:    */   {
/* 136: 93 */     this.insCode = insCode;
/* 137:    */   }
/* 138:    */   
/* 139:    */   public void setInsDescription(String insDescription)
/* 140:    */   {
/* 141: 96 */     this.insDescription = insDescription;
/* 142:    */   }
/* 143:    */   
/* 144:    */   public void setInsEstacionId(Long insEstacionId)
/* 145:    */   {
/* 146: 99 */     this.insEstacionId = insEstacionId;
/* 147:    */   }
/* 148:    */   
/* 149:    */   public void setInsId(Long insId)
/* 150:    */   {
/* 151:102 */     this.insId = insId;
/* 152:    */   }
/* 153:    */   
/* 154:    */   public void setInsTimestamp(Date insTimestamp)
/* 155:    */   {
/* 156:105 */     this.insTimestamp = insTimestamp;
/* 157:    */   }
/* 158:    */ }


/* Location:           C:\Users\Luis\Desktop\CLXX\BalanceQL\Fuentes\
 * Qualified Name:     sia.bql.hibernate.sioperan.AbstractIdtInstruments
 * JD-Core Version:    0.7.0.1
 */