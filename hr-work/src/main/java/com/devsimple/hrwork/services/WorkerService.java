package com.devsimple.hrwork.services;

import com.devsimple.hrwork.repository.WorkerRepository;
import com.devsimple.hrwork.model.Worker;
import com.devsimple.hrwork.services.exception.ObjectNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class WorkerService {

    private WorkerRepository workerRepository;

    @Transactional
    public List<Worker> findAll(){
        return workerRepository.findAll();
    }

    @Transactional
    public Worker findById(Long id){
        return workerRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Worker not found"));
    }

//    @Transactional
//    public Worker save(Worker worker){
//        try {
//            return workerRepository.save(worker);
//        }catch (DataIntegrityViolationException e){
//            throw new IllegalArgumentException("Formato inválido");
//        }
//    }

}
