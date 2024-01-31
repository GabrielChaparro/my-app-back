package com.gabrielchaparro.demo.service.impl;

import com.gabrielchaparro.demo.model.Client;
import com.gabrielchaparro.demo.repository.ClientRepository;
import com.gabrielchaparro.demo.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {
    @Autowired
    private final ClientRepository repository;

    @Override
    public List<Client> findAll() {
        return repository.findAll();
    }
}
