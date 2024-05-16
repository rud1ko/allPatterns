package com.example.prac12_javapatterns;

import com.example.prac12_javapatterns.environment.StudentPropertiesReader;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Prac12JavaPatternsApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Prac12JavaPatternsApplication.class, args);
        StudentPropertiesReader reader = context.getBean(StudentPropertiesReader.class);
        reader.printStudentProperties();

        context.close();
    }

}
