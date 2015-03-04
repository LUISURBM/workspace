/*  1:   */package sia.cmmad.i18n;

/*  2:   */
/*  3:   */public enum NombresTitulosAplicacion
/* 4: */{
	/* 5:11 */TITULO_REPORTE_DECADAL("DCD"), TITULO_REPORTE_MULTIANUAL("MAM"), FRECUENCIA_DIARIA(
			"MTR_DRO"), FRECUENCIA_MULTIANUAL("MTR_MNS"), DECADAL("DECADAL"), MULTIANUAL_MENSUAL(
			"MULTIANUAL");
	/* 6: */
	/* 7: */public final String nombreTitulo;

	/* 8: */
	/* 9: */private NombresTitulosAplicacion(String nombreTitulo)
	/* 10: */{
		/* 11:14 */this.nombreTitulo = nombreTitulo;
		/* 12: */}
	/* 13: */
}
