package ru.ruiners.cards.security.interceptor;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import ru.ruiners.cards.controller.dto.AuthenticateDto;
import ru.ruiners.cards.security.AuthorizationService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@Component
@RequiredArgsConstructor
public class AuthorizationInterceptor implements HandlerInterceptor {

    private final AuthorizationService authorizationService;
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws JsonProcessingException {
        String authorizationString = request.getHeader("Authorization");
        AuthenticateDto authorization = objectMapper.readValue(authorizationString, AuthenticateDto.class);
        return authorizationService.authenticate(authorization);
    }

}