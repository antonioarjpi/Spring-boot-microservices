package com.devsimple.hrwork.controller;

import com.devsimple.hrwork.model.Worker;
import com.devsimple.hrwork.services.WorkerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RefreshScope
@RestController
@RequestMapping("/workers")
public class WorkerController {

    private static Logger logger = LoggerFactory.getLogger(WorkerController.class);

    @Autowired
    private WorkerService workerService;

    @GetMapping
    public ResponseEntity<List<Worker>> findAll(){
        List<Worker> list = workerService.findAll();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Worker> findById(@PathVariable Long id){
        Worker worker = workerService.findById(id);
        return ResponseEntity.ok(worker);
    }

    @GetMapping("/configs")
    public ResponseEntity<Void> getConfigs() {
        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public Worker save(@RequestBody Worker worker){
        return workerService.save(worker);
    }
}
