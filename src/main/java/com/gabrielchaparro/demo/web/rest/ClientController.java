package com.gabrielchaparro.demo.web.rest;

import com.gabrielchaparro.demo.model.Client;
import com.gabrielchaparro.demo.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ClientController {

    @Autowired
    private final ClientService service;

    @GetMapping("/clients")
    public List<Client> index(){
        return service.findAll();
    }
}
