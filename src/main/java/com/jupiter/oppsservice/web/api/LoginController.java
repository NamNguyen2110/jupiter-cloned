package com.jupiter.oppsservice.web.api;

import com.jupiter.common.base.ApiResponse;
import com.jupiter.common.service.MessageService;
import com.jupiter.common.utils.DataUtils;
import lombok.*;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Arrays;

@RestController
@RequestMapping("/api/opps/authenticate")
@RequiredArgsConstructor
public class LoginController {

    private final RestTemplate restTemplate;
    private final MessageService messageService;

    @PostMapping()
    public ApiResponse<?> login(@RequestBody LoginRequest request) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.add("client_id", request.getClient_id());
        map.add("username", request.getUsername());
        map.add("password", request.getPassword());
        map.add("grant_type", request.getGrant_type());
        HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<>(map, headers);
        try {
            ResponseEntity<LoginResponse> response =
                    restTemplate.exchange("http://keycloak.bdb-jup.com/realms/jupiter/protocol/openid-connect/token",
                            HttpMethod.POST,
                            entity,
                            LoginResponse.class);
            return ApiResponse.builder()
                    .errorCode(DataUtils.safeToString(HttpStatus.OK.value()))
                    .messages(Arrays.asList(messageService.getMessage("error.code.success")))
                    .data(response.getBody())
                    .timestamp(LocalDateTime.now())
                    .build();
        } catch (Exception e) {
            return ApiResponse.builder()
                    .errorCode(DataUtils.safeToString(HttpStatus.OK.value()))
                    .messages(Arrays.asList(messageService.getMessage("error.code.fail")))
                    .data(null)
                    .timestamp(LocalDateTime.now())
                    .build();
        }
    }

    @Getter
    @Setter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class LoginResponse implements Serializable {
        private String access_token;
        private String expires_in;
        private String refresh_expires_in;
        private String refresh_token;
    }

    @Getter
    @Setter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class LoginRequest implements Serializable {
        private String client_id;
        private String username;
        private String password;
        private String grant_type;
    }
}
