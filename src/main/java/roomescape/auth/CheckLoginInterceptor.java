package roomescape.auth;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import roomescape.exception.customexception.AuthenticationException;
import roomescape.service.AuthService;
import roomescape.service.dto.request.LoginMember;

import java.io.IOException;

public class CheckLoginInterceptor implements HandlerInterceptor {

    public static final String LOGIN_MEMBER_REQUEST = "loginMember";

    private final Logger logger = LoggerFactory.getLogger(getClass());

    private final AuthService authService;
    private final AuthenticationExtractor authenticationExtractor;

    public CheckLoginInterceptor(AuthService authService, AuthenticationExtractor authenticationExtractor) {
        this.authService = authService;
        this.authenticationExtractor = authenticationExtractor;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws IOException {
        logger.trace("login request = {}", request.getRequestURI());

        try {
            String token = authenticationExtractor.extract(request, authService.getTokenName());
            LoginMember member = authService.findMemberByToken(token);

            request.setAttribute(LOGIN_MEMBER_REQUEST, member);
        } catch (AuthenticationException e) {
            response.sendRedirect("/login");
            return false;
        }
        return true;
    }
}