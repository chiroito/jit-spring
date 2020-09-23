package chiroito.sample.jitspring.event;

import javax.servlet.*;
import java.io.IOException;

public class HelloEventFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpEvent event = new HttpEvent();
        event.begin();

        filterChain.doFilter(servletRequest,servletResponse);

        event.end();
        event.commit();
    }

    @Override
    public void destroy() {
    }
}
