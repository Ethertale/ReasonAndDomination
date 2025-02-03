package io.ethertale.reasonanddominationspringdefenseproject.security;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.HashSet;
import java.util.Set;

@Component
public class SessionCheckInterceptor implements HandlerInterceptor {

    private final Set<String> UNAUTHENTICATED_ENDPOINTS = Set.of("/", "/login", "/register");

    // Ще се изпълни преди всяка заявка
    // Request - заявката, която се праща към приложението
    // Response - отговор, който връщаме
    // Handler
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        // End Point (ex. /home)
        String endPoint = request.getServletPath();

        if (UNAUTHENTICATED_ENDPOINTS.contains(endPoint)) {
            //Ако иска да достъпи endpoint, който няма нужда от сесия, пуска заявката напред
            return true;
        }

        // request.getSession() - Вземам сесията, ако няма се създава нова!!!
        // request.getSession(false) - взема сесията, ако има, ако няма връща NULL!!!
        HttpSession currentUserSession = request.getSession(false);

        if (currentUserSession == null) {
            response.sendRedirect("/login");
            return false;
        }

        return HandlerInterceptor.super.preHandle(request, response, handler);
    }
}
