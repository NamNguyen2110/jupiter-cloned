package com.jupiter.oppsservice.aop;

import com.jupiter.common.annotation.AuthorizedFor;
import com.jupiter.common.constants.Message;
import com.jupiter.common.constants.Role;
import com.jupiter.common.constants.StringConstants;
import com.jupiter.common.exception.AccessDeniedException;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Objects;

@Aspect
@Component
public class AuthorizationAop {
    @Before("@annotation(authorizedFor)")
    private void authorizationCheck(AuthorizedFor authorizedFor) {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String permissionHeader = request.getHeader(StringConstants.X_ROLE_HEADER);
        if (permissionHeader == null) {
            throw new AccessDeniedException(Message.permission);
        }

        Role role = Role.of(permissionHeader);
        if (!List.of(authorizedFor.roles()).contains(Objects.requireNonNull(role))) {
            throw new AccessDeniedException(Message.access_denied);
        }
    }
}
