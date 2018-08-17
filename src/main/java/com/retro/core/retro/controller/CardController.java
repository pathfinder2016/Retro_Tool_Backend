package com.retro.core.retro.controller;

import com.retro.core.retro.model.Card;
import com.retro.core.retro.service.CardService;
import com.retro.core.websocket.WebSocketServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.EncodeException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@CrossOrigin
@RestController
@RequestMapping("/card")
public class CardController {

    @Autowired CardService cardService;

    @RequestMapping(value = "/public", method = POST, consumes = "application/json")
    public void upsertPublicWellCards(@RequestBody ArrayList<Card> cards) throws IOException, EncodeException {
        cardService.upsertPublicCards(cards);
        WebSocketServer.sendInfo(cardService.findAll());
    }

    @RequestMapping(value = "/all", method = GET, consumes = "application/json")
    public ResponseEntity findAll(){
        List<Card> cards = cardService.findAll();
        return new ResponseEntity(cards, HttpStatus.OK);
    }

    @RequestMapping(value = "/del", method = POST, consumes = "application/json")
    public void del(@RequestBody Card card) throws IOException, EncodeException {
        cardService.del(card);
        WebSocketServer.sendInfo(cardService.findAll());
    }
}
