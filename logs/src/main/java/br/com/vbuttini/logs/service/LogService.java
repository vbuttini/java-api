package br.com.vbuttini.logs.service;

import br.com.vbuttini.logs.entity.Log;
import br.com.vbuttini.logs.repository.LogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Vinicius Buttini
 */
@Service
@RequiredArgsConstructor
public class LogService {

    private final LogRepository repository;

    public Log insertLog(Log log){
        return repository.insert(log);
    }

    public List<Log> listLogs(){
        return repository.findAll();
    }

}
