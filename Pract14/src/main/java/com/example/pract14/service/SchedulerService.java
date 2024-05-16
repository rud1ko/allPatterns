package com.example.pract14.service;

import com.example.pract14.entity.MarketDB;
import com.example.pract14.repository.MarketRepository;
import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Service
@AllArgsConstructor
public class SchedulerService{

    private MarketRepository marketRepository;

    @Scheduled(cron = "*/30 * * * * *")
    public void doScheduledTask() {
        String directoryPath = "D:\\idea_Projects\\PracticJava_2_next\\User";

        File directory = new File(directoryPath);
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                System.out.println(file);
                file.delete();
            }
        }

        Path path = Paths.get(directoryPath, "users.txt");
        try {
            Files.createFile(path);
            try (FileWriter writer = new FileWriter(String.valueOf(path))) {
                List<MarketDB> markets = marketRepository.findAll();
                for (MarketDB user : markets) {
                    writer.write("Id: " + user.getId()
                            + "\nName: " + user.getName()
                            + "\nAddress: " + user.getAddress() + "\n\n");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            System.err.println("Не удалось создать файл: " + path);
        }
    }
}
