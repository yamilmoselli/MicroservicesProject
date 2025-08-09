package com.MicroservicesProject.service;

import com.MicroservicesProject.domain.Local;
import org.springframework.stereotype.Service;

import java.util.List;

public interface LocalService {

    List<Local> getAllLocals();
    Local saveLocal(Local local);
    Local updateLocal(Long id, Local local);
    void deleteLocal(Long id);
}
