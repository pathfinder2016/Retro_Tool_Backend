package com.retro.core.retro.controller;

import com.retro.core.retro.model.Card;
import com.retro.core.retro.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@CrossOrigin
@RestController
@RequestMapping("/card")
public class CardController {

    @Autowired CardService cardService;

    @RequestMapping(value = "/public/well", method = POST)
    public ResponseEntity upsertPublicWellCards(@RequestBody ArrayList<Card> cards){
        cardService.upsertPublicWellCards(cards);
        return new ResponseEntity(cards, HttpStatus.OK);
    }

    @RequestMapping(value = "/all", method = GET)
    public ResponseEntity findAll(){
        List<Card> cards = cardService.findAll();
        return new ResponseEntity(cards, HttpStatus.OK);
    }
}
