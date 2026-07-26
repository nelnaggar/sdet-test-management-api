package pro.netech.testmanagement.controller;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/")
    public Map<String, String> getApplicationStatus() {

        Map<String, String> response = new LinkedHashMap<>();

        response.put("application", "SDET Test Management API");
        response.put("version", "1.0");
        response.put("status", "Running");

        return response;
    }
}