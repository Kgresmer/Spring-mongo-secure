package config;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CustomizeAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest,
                                        HttpServletResponse httpServletResponse,
                                        Authentication authentication) throws IOException, ServletException {
        // set response to OK status
        httpServletResponse.setStatus(HttpServletResponse.SC_OK);

        for (GrantedAuthority auth : authentication.getAuthorities()) {
            if ("ADMIN".equals(auth.getAuthority())) {
                httpServletResponse.sendRedirect("/dashboard");
            }
        }
    }
}
