package com.devsimple.hrwork.config;

import com.devsimple.hrwork.WorkerRepository;
import com.devsimple.hrwork.model.Worker;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
@AllArgsConstructor
public class Instantiation implements CommandLineRunner {

    private WorkerRepository workerRepository;

    @Override
    public void run(String... args) throws Exception {
        Worker dean = new Worker(null, "Dean", 200.0);
        Worker bob = new Worker(null, "Bob", 300.2);
        Worker sam = new Worker(null, "Sam", 350.0);

        workerRepository.saveAll(Arrays.asList(dean, bob, sam));

    }
}
