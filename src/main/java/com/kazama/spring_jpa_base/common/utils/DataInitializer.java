package com.kazama.spring_jpa_base.common.utils;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.kazama.spring_jpa_base.common.JsonFileReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;
import lombok.Data;

@Service
@Data
public class DataInitializer {

    @Autowired
    private JsonFileReader jsonFileReader;

    private List<String> firstNames;
    private List<String> lastNames;
    private List<String> cities;
    private List<String> districts;
    private List<String> streets;




    @PostConstruct
    public void init(){
        Map<String, Object> data;
        try {
            data = jsonFileReader.readJsonFile("dataset.json");
            this.firstNames = (List<String>) data.get("firstNames");
            this.lastNames = (List<String>) data.get("lastNames");
            this.cities = (List<String>) data.get("cities");
            this.districts = (List<String>) data.get("districts");
            this.streets = (List<String>) data.get("streets");

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    
}
