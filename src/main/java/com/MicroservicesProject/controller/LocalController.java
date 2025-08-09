package com.MicroservicesProject.controller;

import com.MicroservicesProject.domain.Local;
import com.MicroservicesProject.service.LocalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class LocalController {

    @Autowired
    LocalService localService;

    @GetMapping("/locals")
    public List<Local> getAllLocals() {
        return localService.getAllLocals();
    }

}
