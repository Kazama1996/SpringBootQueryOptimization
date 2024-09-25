package com.kazama.spring_jpa_base.common;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

@Component
public class JsonFileReader {
    
    private final ObjectMapper objectMapper = new ObjectMapper();

    public Map<String,Object> readJsonFile(String fileName) throws IOException{
        Resource resource = new ClassPathResource(fileName);

        try(InputStream inputStream = resource.getInputStream()){
            return objectMapper.readValue(inputStream, Map.class);
        }
    }
}
