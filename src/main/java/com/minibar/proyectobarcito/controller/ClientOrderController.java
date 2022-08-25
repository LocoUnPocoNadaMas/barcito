package com.minibar.proyectobarcito.controller;

import com.minibar.proyectobarcito.dto.ClientDTO;
import com.minibar.proyectobarcito.dto.ClientOrderDTO;
import com.minibar.proyectobarcito.service.IClientOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class ClientOrderController {

    @Autowired
    public IClientOrderService clientOrderService;

    @PostMapping("/agregar")
    public ResponseEntity<Void> addItem(@RequestBody @Validated ClientDTO clientDTO) {
        if(clientOrderService.addNewItem(clientDTO)) return new ResponseEntity<>(HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/miorden/{id}")
    public ResponseEntity<ClientOrderDTO> showOrder(@PathVariable Long id) {
        //return new ResponseEntity<>(clientOrderService.getOrderItems(id), HttpStatus.OK);
        return null;
    }



}
