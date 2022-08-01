package br.com.vbuttini.logs.controller;

import br.com.vbuttini.logs.entity.Log;
import br.com.vbuttini.logs.service.LogService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Vinícius Buttini
 */
@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/logs")
public class LogController {

    private final LogService service;

    @GetMapping
    public ResponseEntity<List<Log>> listLogs(){
        return ResponseEntity.ok(service.listLogs());
    }

}
