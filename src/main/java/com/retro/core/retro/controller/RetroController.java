package com.retro.core.retro.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping(value="/retro")
public class RetroController {

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public ResponseEntity testGet(){
        return new ResponseEntity("Mike", HttpStatus.OK);
    }
}
