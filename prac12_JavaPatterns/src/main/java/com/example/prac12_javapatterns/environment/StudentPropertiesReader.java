package com.example.prac12_javapatterns.environment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class StudentPropertiesReader {
    private final Environment environment;

    @Autowired
    public StudentPropertiesReader(Environment environment) {
        this.environment = environment;
    }

    public void printStudentProperties() {
        String name = environment.getProperty("student.name");
        String lastName = environment.getProperty("student.last_name");
        String group = environment.getProperty("student.group");

        System.out.println("Имя студента: " + name);
        System.out.println("Фамилия студента: " + lastName);
        System.out.println("Название группы студента: " + group);
    }
}
