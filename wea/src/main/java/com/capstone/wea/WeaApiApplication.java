package com.capstone.wea;

import com.capstone.wea.model.WEAMessageModel;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import java.io.File;

@SpringBootApplication
public class WeaApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(WeaApiApplication.class, args);
	}
}
