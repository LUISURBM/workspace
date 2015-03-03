/*   1:    */package sia.bql.hibernate.sioperan;

/*   2:    */
/*   3:    */import java.util.List;
/*   4:    */
import org.apache.commons.logging.Log;
/*   5:    */
import org.apache.commons.logging.LogFactory;
/*   6:    */
import org.hibernate.Criteria;
/*   7:    */
import org.hibernate.LockMode;
/*   8:    */
import org.hibernate.Query;
/*   9:    */
import org.hibernate.Session;
/*  10:    */
import org.hibernate.criterion.Example;

/*  11:    */
/*  12:    */public class ShmtTablasConversionDAO
/* 13: */extends BaseHibernateDAO
/* 14: */{
	/* 15: 17 */private static final Log log = LogFactory
			.getLog(ShmtTablasConversionDAO.class);
	/* 16: */public static final String TBCN_CODIGO_SISDHIM = "tbcnCodigoSisdhim";
	/* 17: */public static final String TBCN_ESTACION_ID = "tbcnEstacionId";
	/* 18: */public static final String TBCN_ESTADO = "tbcnEstado";
	/* 19: */public static final String TBCN_FIN_VIG = "tbcnFinVig";
	/* 20: */public static final String TBCN_INICIO_VIG = "tbcnInicioVig";
	/* 21: */public static final String TBCN_TIPO = "tbcnTipo";
	/* 22: */public static final String TBCN_USR_ID = "tbcnUsrId";

	/* 23: */
	/* 24: */public void attachClean(ShmtTablasConversion instance)
	/* 25: */{
		/* 26: 27 */log.debug("attaching clean ShmtTablasConversion instance");
		/* 27: */try
		/* 28: */{
			/* 29: 29 */getSession().lock(instance, LockMode.NONE);
			/* 30: 30 */log.debug("attach successful");
			/* 31: */}
		/* 32: */catch (RuntimeException re)
		/* 33: */{
			/* 34: 32 */log.error("attach failed", re);
			/* 35: 33 */throw re;
			/* 36: */}
		/* 37: */}

	/* 38: */
	/* 39: */public void attachDirty(ShmtTablasConversion instance)
	/* 40: */{
		/* 41: 37 */log.debug("attaching dirty ShmtTablasConversion instance");
		/* 42: */try
		/* 43: */{
			/* 44: 39 */getSession().saveOrUpdate(instance);
			/* 45: 40 */log.debug("attach successful");
			/* 46: */}
		/* 47: */catch (RuntimeException re)
		/* 48: */{
			/* 49: 42 */log.error("attach failed", re);
			/* 50: 43 */throw re;
			/* 51: */}
		/* 52: */}

	/* 53: */
	/* 54: */public void delete(ShmtTablasConversion persistentInstance)
	/* 55: */{
		/* 56: 47 */log.debug("deleting ShmtTablasConversion instance");
		/* 57: */try
		/* 58: */{
			/* 59: 49 */getSession().delete(persistentInstance);
			/* 60: 50 */log.debug("delete successful");
			/* 61: */}
		/* 62: */catch (RuntimeException re)
		/* 63: */{
			/* 64: 52 */log.error("delete failed", re);
			/* 65: 53 */throw re;
			/* 66: */}
		/* 67: */}

	/* 68: */
	/* 69: */public List findByExample(ShmtTablasConversion instance)
	/* 70: */{
		/* 71: 58 */log
				.debug("finding ShmtTablasConversion instance by example");
		/* 72: */try
		/* 73: */{
			/* 74: 60 */List results = getSession()
					.createCriteria("sia.hibernate.ShmtTablasConversion")
					.add(Example.create(instance)).list();
			/* 75: 61 */log.debug("find by example successful, result size: "
					+ results.size());
			/* 76: 62 */return results;
			/* 77: */}
		/* 78: */catch (RuntimeException re)
		/* 79: */{
			/* 80: 64 */log.error("find by example failed", re);
			/* 81: 65 */throw re;
			/* 82: */}
		/* 83: */}

	/* 84: */
	/* 85: */public ShmtTablasConversion findById(Long id)
	/* 86: */{
		/* 87: 69 */log.debug("getting ShmtTablasConversion instance with id: "
				+ id);
		/* 88: */try
		/* 89: */{
			/* 90: 71 */return (ShmtTablasConversion) getSession().get(
					"sia.hibernate.ShmtTablasConversion", id);
			/* 91: */}
		/* 92: */catch (RuntimeException re)
		/* 93: */{
			/* 94: 74 */log.error("get failed", re);
			/* 95: 75 */throw re;
			/* 96: */}
		/* 97: */}

	/* 98: */
	/* 99: */public List findByProperty(String propertyName, Object value)
	/* 100: */{
		/* 101: 80 */log
				.debug("finding ShmtTablasConversion instance with property: "
						+ propertyName + ", value: " + value);
		/* 102: */try
		/* 103: */{
			/* 104: 82 */String queryString = "from ShmtTablasConversion as model where model."
					+ propertyName + "= ?";
			/* 105: 83 */Query queryObject = getSession().createQuery(
					queryString);
			/* 106: 84 */queryObject.setParameter(0, value);
			/* 107: 85 */return queryObject.list();
			/* 108: */}
		/* 109: */catch (RuntimeException re)
		/* 110: */{
			/* 111: 87 */log.error("find by property name failed", re);
			/* 112: 88 */throw re;
			/* 113: */}
		/* 114: */}

	/* 115: */
	/* 116: */public List findByRestriction(String tabla, String restriction)
	/* 117: */{
		/* 126: */List result;
		/* 118: */try
		/* 119: */{
			/* 120: 95 */String queryString = "from " + tabla + " where "
					+ restriction;
			/* 121: 96 */Query queryObject = getSession().createQuery(
					queryString);
			/* 122: 97 */result = queryObject.list();
			/* 123: */}
		/* 124: */catch (RuntimeException re)
		/* 125: */{

			/* 127: 99 */throw re;
			/* 128: */}
		/* 130:101 */return result;
		/* 131: */}

	/* 132: */
	/* 133: */public List findByTbcnCodigoSisdhim(Object tbcnCodigoSisdhim)
	/* 134: */{
		/* 135:105 */return findByProperty("tbcnCodigoSisdhim",
				tbcnCodigoSisdhim);
		/* 136: */}

	/* 137: */
	/* 138: */public List findByTbcnEstacionId(Object tbcnEstacionId)
	/* 139: */{
		/* 140:109 */return findByProperty("tbcnEstacionId", tbcnEstacionId);
		/* 141: */}

	/* 142: */
	/* 143: */public List findByTbcnEstado(Object tbcnEstado)
	/* 144: */{
		/* 145:113 */return findByProperty("tbcnEstado", tbcnEstado);
		/* 146: */}

	/* 147: */
	/* 148: */public List findByTbcnFinVig(Object tbcnFinVig)
	/* 149: */{
		/* 150:117 */return findByProperty("tbcnFinVig", tbcnFinVig);
		/* 151: */}

	/* 152: */
	/* 153: */public List findByTbcnInicioVig(Object tbcnInicioVig)
	/* 154: */{
		/* 155:121 */return findByProperty("tbcnInicioVig", tbcnInicioVig);
		/* 156: */}

	/* 157: */
	/* 158: */public List findByTbcnTipo(Object tbcnTipo)
	/* 159: */{
		/* 160:125 */return findByProperty("tbcnTipo", tbcnTipo);
		/* 161: */}

	/* 162: */
	/* 163: */public List findByTbcnUsrId(Object tbcnUsrId)
	/* 164: */{
		/* 165:129 */return findByProperty("tbcnUsrId", tbcnUsrId);
		/* 166: */}

	/* 167: */
	/* 168: */public ShmtTablasConversion merge(
			ShmtTablasConversion detachedInstance)
	/* 169: */{
		/* 170:132 */log.debug("merging ShmtTablasConversion instance");
		/* 171: */try
		/* 172: */{
			/* 173:134 */ShmtTablasConversion result = (ShmtTablasConversion) getSession()
					.merge(detachedInstance);
			/* 174:135 */log.debug("merge successful");
			/* 175:136 */return result;
			/* 176: */}
		/* 177: */catch (RuntimeException re)
		/* 178: */{
			/* 179:138 */log.error("merge failed", re);
			/* 180:139 */throw re;
			/* 181: */}
		/* 182: */}

	/* 183: */
	/* 184: */public void save(ShmtTablasConversion transientInstance)
	/* 185: */{
		/* 186:143 */log.debug("saving ShmtTablasConversion instance");
		/* 187: */try
		/* 188: */{
			/* 189:145 */getSession().save(transientInstance);
			/* 190:146 */log.debug("save successful");
			/* 191: */}
		/* 192: */catch (RuntimeException re)
		/* 193: */{
			/* 194:148 */log.error("save failed", re);
			/* 195:149 */throw re;
			/* 196: */}
		/* 197: */}
	/* 198: */
}

/*
 * Location: C:\Users\Luis\Desktop\CLXX\BalanceQL\Fuentes\
 * 
 * Qualified Name: sia.bql.hibernate.sioperan.ShmtTablasConversionDAO
 * 
 * JD-Core Version: 0.7.0.1
 */