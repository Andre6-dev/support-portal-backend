package com.devandre.supportportalbackend.filter;

import com.devandre.supportportalbackend.domain.HttpResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.Http403ForbiddenEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;

import static com.devandre.supportportalbackend.constant.SecurityConstant.FORBIDDEN_MESSAGE;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

/**
 * Entry point for authentication
 *
 * @author Andre Gallegos
 * @create 2022-09-28 11:29
 **/
@Component
public class JwtAuthenticationEntryPoint extends Http403ForbiddenEntryPoint {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception)
            throws IOException {

        HttpResponse httpResponse = new HttpResponse(HttpStatus.FORBIDDEN.value(), HttpStatus.FORBIDDEN,
                HttpStatus.FORBIDDEN.getReasonPhrase().toUpperCase(), FORBIDDEN_MESSAGE);

        response.setContentType(APPLICATION_JSON_VALUE);
        response.setStatus(HttpStatus.FORBIDDEN.value());

        // Write the response to the output stream
        OutputStream outputStream = response.getOutputStream();
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(outputStream, httpResponse);
        // Close the output stream
        outputStream.flush();
    }
}

