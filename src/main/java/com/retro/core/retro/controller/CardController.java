package com.retro.core.retro.controller;

import com.retro.core.retro.model.Card;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@CrossOrigin
@RestController
@RequestMapping("/card")
public class CardController {

    @RequestMapping(value = "/public/well", method = POST)
    public ResponseEntity upsertPublicWellCards(@RequestBody ArrayList<Card> cards){
        return new ResponseEntity("Test", HttpStatus.OK);
    }
}
