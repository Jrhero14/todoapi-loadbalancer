package org.todo.todoapi.helpers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

public class ResponseHandler {
    public static ResponseEntity<Object> JSONResponse(HttpStatus status, String message, Object data) {
        Map<String, Object> response = new HashMap<String, Object>();

        response.put("status", status.value());
        response.put("message", message);
        response.put("data", data);

        return new ResponseEntity<>(response, status);
    }
}
