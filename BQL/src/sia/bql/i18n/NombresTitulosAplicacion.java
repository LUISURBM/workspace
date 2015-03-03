/*  1:   */ package sia.bql.i18n;
/*  2:   */ 
/*  3:   */ public enum NombresTitulosAplicacion
/*  4:   */ {
/*  5:11 */   TITULO_GRUPO("GRUPO"),  TITULO_ESTACION("ESTACIÓN"),  REFERENCIA_GRUPO("GR"),  REFERENCIA_ESTACION("ES"),  IMAGEN_NUEVA_ESTACION("./resources/css/images/estacion.png"),  IMAGEN_NUEVO_GRUPO("./resources/css/images/group.png"),  PATH_COMPONENTE("Balance Caudales"),  DIRECTORIO_CONTEXTO("./upload/"),  ESTADO_BALANCE("balance"),  ESTADO_GRUPOS("grupos"),  NIVEL("nvl"),  PRECIPITACION("pm"),  MENSAJE_ELIMINAR("ELIMINAR"),  MENSAJE_NUEVO("INCLUIR"),  RQ_544("RQ544"),  CAUDAL("CDL"),  MENSUAL("MNS"),  ANUAL("ANL");
/*  6:   */   
/*  7:   */   public final String nombreTitulo;
/*  8:   */   
/*  9:   */   private NombresTitulosAplicacion(String nombreTitulo)
/* 10:   */   {
/* 11:14 */     this.nombreTitulo = nombreTitulo;
/* 12:   */   }
/* 13:   */ }


/* Location:           C:\Users\Luis\Desktop\CLXX\BalanceQL\Fuentes\
 * Qualified Name:     sia.bql.i18n.NombresTitulosAplicacion
 * JD-Core Version:    0.7.0.1
 */