package com.minibar.proyectobarcito.controller;

import com.minibar.proyectobarcito.dto.ClientDTO;
import com.minibar.proyectobarcito.service.IClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@RestController
public class ItemController {

    @Autowired
    public IClientService clientService;

    @PostMapping("/agregar")
    public ResponseEntity<Void> addItem(@RequestBody @Validated ClientDTO clientDTO) {
        if(clientService.addNewItem(clientDTO)) return new ResponseEntity<>(HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/orden")
    public ResponseEntity<Void> showOrder(@PathVariable Long id) {
        //if(clientService.addNewItem(clientDTO)) return new ResponseEntity<>(HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }



}
