package sia.cmmad.hidromet;

import java.util.Iterator;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.ScrollableResults;

import sia.cmmad.bean.util.Utiles;
import sia.cmmad.hibernate.BDOperacion;
import sia.cmmad.hibernate.HibernateSessionFactory;

public class Hmst_DailyData {

	private static String SUMATORIA_SQL = "select TO_CHAR (dldt_datadate, 'mm'), TO_CHAR (dldt_datadate, 'yyyy'), dldt_idvariable, sum(TO_CHAR(dldt_data,'9999999.99')) from HMST_DAILYDATA where (dldt_idstation = :p_estacion) and (to_char(dldt_datadate,'YYYY-MM-DD')  between :p_fecha_desde and :p_fecha_hasta) and (dldt_idvariable = :p_var) group by to_char(dldt_datadate,'mm'),to_char(dldt_datadate,'yyyy'), dldt_idvariable";

	
	public static List<Object[]> getCubeDecadales(String codigo, int fechaInicio,
			int fechaFin, String frecuenciaDiaria, String grupoMedicion,
			String variable) {

		return BDOperacion.obtenerDecadalesMuliAnual(Utiles.formatoSql(
				SUMATORIA_SQL, codigo, fechaInicio, fechaFin, frecuenciaDiaria,
				grupoMedicion, variable));
	}

}
