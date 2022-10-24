package com.devandre.supportportalbackend.filter;

import com.devandre.supportportalbackend.domain.HttpResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;

import static com.devandre.supportportalbackend.constant.SecurityConstant.ACCESS_DENIED_MESSAGE;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

/**
 * Hanlder to denied requests
 *
 * @author Andre Gallegos
 * @create 2022-09-28 11:57
 **/
@Component
public class JwtAccessDeniedHandler implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException exception)
            throws IOException, ServletException {
        HttpResponse httpResponse = new HttpResponse(HttpStatus.UNAUTHORIZED.value(), HttpStatus.UNAUTHORIZED,
                HttpStatus.UNAUTHORIZED.getReasonPhrase().toUpperCase(), ACCESS_DENIED_MESSAGE);

        response.setContentType(APPLICATION_JSON_VALUE);
        response.setStatus(HttpStatus.UNAUTHORIZED.value());

        // Write the response to the output stream
        OutputStream outputStream = response.getOutputStream();
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(outputStream, httpResponse);
        // Close the output stream
        outputStream.flush();
    }
}
