package by.zyablov.bank.filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * {@code AutorizeSecurityFilter} intercepts user's http requests to check
 * user's authority type.
 */
public class AutorizeSecurityFilter implements Filter {

	/**
	 * Checks the user's authority type.
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		checkAuthorization(request, response);

		chain.doFilter(request, response);

	}

	private void checkAuthorization(ServletRequest request, ServletResponse response) {
		//
		// HttpServletRequest req = (HttpServletRequest) request;
		// HttpServletResponse resp = (HttpServletResponse) response;
		// TODO Realize filter

	}

	/**
	 * Initializes {@code AutorizeSecurityFilter} object.
	 */
	public void init(FilterConfig fConfig) throws ServletException {
	}

	/**
	 * Destroys {@code AutorizeSecurityFilter} object.
	 */
	public void destroy() {
	}

}
