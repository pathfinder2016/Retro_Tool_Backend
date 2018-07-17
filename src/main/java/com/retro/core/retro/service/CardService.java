package com.retro.core.retro.service;

import com.retro.common.constant.CardType;
import com.retro.core.retro.model.Card;
import com.retro.core.retro.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CardService {
    @Autowired
    private CardRepository cardRepository;

    public void upsertPublicWellCards(ArrayList<Card> newCards) {
        List<Card> oldCards = cardRepository.findAllByType(CardType.WELL);
        compareCards(oldCards, newCards);
    }

    private void compareCards(List<Card> oldCards, ArrayList<Card> newCards) {

    }

    public List<Card> findCards() {
        return null;
    }
}
