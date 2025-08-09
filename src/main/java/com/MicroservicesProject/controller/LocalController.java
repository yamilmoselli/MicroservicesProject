package com.MicroservicesProject.controller;

import com.MicroservicesProject.domain.Local;
import com.MicroservicesProject.service.LocalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LocalController {

    @Autowired
    LocalService localService;

    @GetMapping("/locals")
    public List<Local> findAllLocals() {
        return localService.findAllLocals();
    }

    @PostMapping("/saveLocal")
    public Local saveLocal(@RequestBody Local local) {
        return localService.saveLocal(local);
    }

    @PutMapping("/updateLocal/{id}")
    public Local updateLocal(@PathVariable Long id, @RequestBody Local local) {
        return localService.updateLocal(id, local);
    }

    @DeleteMapping("/deleteLocal/{id}")
    public String deleteLocal(@PathVariable Long id) {
        localService.deleteLocal(id);
        return "Local deleted successfully";
    }



}
