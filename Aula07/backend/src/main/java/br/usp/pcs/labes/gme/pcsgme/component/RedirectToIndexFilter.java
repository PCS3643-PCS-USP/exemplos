package br.usp.pcs.labes.gme.pcsgme.component;

import java.io.IOException;
import org.springframework.stereotype.Component;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;

// https://stackoverflow.com/questions/47689971/how-to-work-with-react-routers-and-spring-boot-controller

@Component
public class RedirectToIndexFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request,
                         ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        String requestURI = req.getRequestURI();

        if (requestURI.startsWith("/pcs-gme/api")) {
            chain.doFilter(request, response);
            return;
        }
        
        // Para o Swagger
        if (requestURI.startsWith("/pcs-gme/v3/api-docs")) {
            chain.doFilter(request, response);
            return;
        }

        // all requests not api or static will be forwarded to index page. 
        request.getRequestDispatcher("/").forward(request, response);
    }

}
