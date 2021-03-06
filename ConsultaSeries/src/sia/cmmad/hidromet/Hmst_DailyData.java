package sia.cmmad.hidromet;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.ScrollableResults;

import sia.cmmad.bean.util.Utiles;
import sia.cmmad.hibernate.BDOperacion;
import sia.cmmad.hibernate.HibernateSessionFactory;

public class Hmst_DailyData {

	private static String SUMATORIA_SQL = "select to_char(dldt_datadate,'mm'),to_char(dldt_datadate,'yyyy'), dldt_idvariable, sum(dlDT_DATA), decada from (select dldt_idstation,dldt_datadate, dldt_idvariable, to_number(replace(dlDT_DATA,'.',',')) dlDT_DATA, 1 decada from HMST_DAILYDATA,      idt_measure_fields mf where dldt_idstation = :p_estacion and TO_CHAR(dldt_datadate,'YYYY-MM-DD') between :p_fecha_desde and :p_fecha_hasta and to_char(dldt_datadate,'dd') between 1 and 10 and mf.msfl_code = dldt_idvariable AND mf.MSFL_FRC_CODE = :p_fml_code_frecuencia and mf.MSFL_MSTP_CODE = :p_fml_code_grupo and mf.msfl_code = :p_var union select dldt_idstation,dldt_datadate, dldt_idvariable, to_number(replace(dlDT_DATA,'.',',')) dlDT_DATA, 2   from HMST_DAILYDATA,         idt_measure_fields mf where dldt_idstation = :p_estacion AND mf.MSFL_FRC_CODE = :p_fml_code_frecuencia and mf.MSFL_MSTP_CODE = :p_fml_code_grupo and mf.msfl_code = :p_var and TO_CHAR(dldt_datadate,'YYYY-MM-DD') between :p_fecha_desde and :p_fecha_hasta and to_char(dldt_datadate,'dd') between 11 and 20 and mf.msfl_code = dldt_idvariable union select dldt_idstation,dldt_datadate, dldt_idvariable, to_number(replace(dlDT_DATA,'.',',')) dlDT_DATA, 3  from HMST_DAILYDATA,         idt_measure_fields mf where dldt_idstation = :p_estacion and TO_CHAR(dldt_datadate,'YYYY-MM-DD') between :p_fecha_desde and :p_fecha_hasta and to_char(dldt_datadate,'dd') between 21 and 31 and mf.msfl_code = dldt_idvariable AND mf.MSFL_FRC_CODE = :p_fml_code_frecuencia and mf.MSFL_MSTP_CODE = :p_fml_code_grupo and mf.msfl_code = :p_var ) group by dldt_idstation,to_char(dldt_datadate,'mm'),to_char(dldt_datadate,'yyyy'), dldt_idvariable, decada ORDER BY TO_CHAR (dldt_datadate, 'yyyy'), TO_CHAR (dldt_datadate, 'mm')";
	private static String SUMATORIA_SQL_MAM = "select to_char(mndt_datadate,'mm'),to_char(mndt_datadate,'dd'),to_char(mndt_datadate,'yyyy'), mndt_idvariable, sum(mndt_DATA), decada from (select mndt_idstation,mndt_datadate, mndt_idvariable, to_number(replace(mndt_DATA,'.',',')) mndt_DATA, 1 decada,to_char(mndt_datadate,'dd') from hmst_monthlydata,      idt_measure_fields mf where mndt_idstation = :p_estacion and TO_CHAR(mndt_datadate,'YYYY-MM-DD') between :p_fecha_desde and :p_fecha_hasta and to_char(mndt_datadate,'dd') between 1 and 10 and mf.msfl_code = mndt_idvariable AND mf.MSFL_FRC_CODE = :p_fml_code_frecuencia and mf.MSFL_MSTP_CODE = :p_fml_code_grupo and mf.msfl_code = :p_var union select mndt_idstation,mndt_datadate, mndt_idvariable, to_number(replace(mndt_DATA,'.',',')) mndt_DATA, 2 DECADA,to_char(mndt_datadate,'dd')  from hmst_monthlydata,         idt_measure_fields mf where mndt_idstation = :p_estacion AND mf.MSFL_FRC_CODE = :p_fml_code_frecuencia and mf.MSFL_MSTP_CODE = :p_fml_code_grupo and mf.msfl_code = :p_var and TO_CHAR(mndt_datadate,'YYYY-MM-DD') between :p_fecha_desde and :p_fecha_hasta and to_char(mndt_datadate,'dd') between 11 and 20 and mf.msfl_code = mndt_idvariable union select mndt_idstation,mndt_datadate, mndt_idvariable, to_number(replace(mndt_DATA,'.',',')) mndt_DATA, 3 DECADA,to_char(mndt_datadate,'dd')  from hmst_monthlydata,         idt_measure_fields mf where mndt_idstation = :p_estacion and TO_CHAR(mndt_datadate,'YYYY-MM-DD') between :p_fecha_desde and :p_fecha_hasta and to_char(mndt_datadate,'dd') between 21 and 31 and mf.msfl_code = mndt_idvariable AND mf.MSFL_FRC_CODE = :p_fml_code_frecuencia and mf.MSFL_MSTP_CODE = :p_fml_code_grupo and mf.msfl_code = :p_var ) group by mndt_idstation,to_char(mndt_datadate,'dd'),to_char(mndt_datadate,'mm'),to_char(mndt_datadate,'yyyy'), mndt_idvariable, decada ORDER BY TO_CHAR (mndt_datadate, 'yyyy'), TO_CHAR (mndt_datadate, 'mm'), to_char(mndt_datadate,'dd')";

	public static List<Object[]> getCubeDecadales(String codigo,
			int fechaInicio, int fechaFin, String frecuenciaDiaria,
			String grupoMedicion, String variable) {

		return HibernateSessionFactory
				.currentSession()
				.createSQLQuery(
						Utiles.formatoSql(SUMATORIA_SQL, codigo, fechaInicio,
								fechaFin, frecuenciaDiaria, grupoMedicion,
								variable)).list();
	}

	public static List<Object[]> getCubeMultianual(String codigo,
			int fechaInicio, int fechaFin, String frecuenciaDiaria,
			String grupoMedicion, String variable) {
		return HibernateSessionFactory
				.currentSession()
				.createSQLQuery(
						Utiles.formatoSql(SUMATORIA_SQL_MAM, codigo,
								fechaInicio, fechaFin, frecuenciaDiaria,
								grupoMedicion, variable)).list();
	}


}
