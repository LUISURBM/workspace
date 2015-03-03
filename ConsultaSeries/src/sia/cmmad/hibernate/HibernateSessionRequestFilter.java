/*  1:   */package sia.cmmad.hibernate;

/*  2:   */
/*  4:   */import java.io.IOException;
/*  5:   */
import javax.servlet.Filter;
/*  6:   */
import javax.servlet.FilterChain;
/*  7:   */
import javax.servlet.FilterConfig;
/*  8:   */
import javax.servlet.ServletException;
/*  9:   */
import javax.servlet.ServletRequest;
/* 10:   */
import javax.servlet.ServletResponse;
/* 11:   */
import org.hibernate.Session;
/* 12:   */
import org.hibernate.StaleObjectStateException;
import org.jboss.logging.Logger;

/* 13:   */
/* 14:   */public final class HibernateSessionRequestFilter
/* 15: */implements Filter
/* 16: */{
	/* 17:21 */private static Logger log = Logger
			.getLogger(HibernateSessionRequestFilter.class);

	/* 18: */
	/* 19: */public void doFilter(ServletRequest request,
			ServletResponse response, FilterChain chain)
	/* 20: */throws IOException, ServletException
	/* 21: */{
		/* 22: */Session session;
		/* 23: */try
		/* 24: */{
			/* 25:29 */log.info("HibernateSessionRequestFilter :: do ");
			/* 26:30 */chain.doFilter(request, response);
			/* 27:31 */log.info("HibernateSessionRequestFilter :: Filter.");
			/* 28: */}
		/* 29: */catch (StaleObjectStateException staleEx)
		/* 30: */{
			/* 31:33 */log
					.info("This interceptor does not implement optimistic concurrency control!");
			/* 32:34 */log
					.info("Your application will not work until you add compensation actions!",
							staleEx);
			/* 33: */try
			/* 34: */{
				/* 35:38 */session = HibernateSessionFactory.getSession();
				/* 36:39 */if ((session != null) && (session.isOpen())) {
					/* 37:40 */session.close();
					/* 38: */}
				/* 39: */}
			/* 40: */catch (Throwable localThrowable) {
			}
			/* 41: */}
		/* 42: */finally
		/* 43: */{
			/* 44: */try
			/* 45: */{
				/* 46:38 */session = HibernateSessionFactory.getSession();
				/* 47:39 */if ((session != null) && (session.isOpen())) {
					/* 48:40 */session.close();
					/* 49: */}
				/* 50: */}
			/* 51: */catch (Throwable localThrowable1) {
			}
			/* 52: */}
		/* 53: */}

	/* 54: */
	/* 55: */public void init(FilterConfig filterConfig)
	/* 56: */throws ServletException
	/* 57: */{
		/* 58:47 */log
				.debug("HibernateSessionRequestFilter :: Initializing filter...");
		/* 59:48 */log
				.debug("HibernateSessionRequestFilter :: Obtaining SessionFactory from static HibernateUtil singleton");
		/* 60: */}

	/* 61: */
	/* 62: */public void destroy() {
	}
	/* 63: */
}