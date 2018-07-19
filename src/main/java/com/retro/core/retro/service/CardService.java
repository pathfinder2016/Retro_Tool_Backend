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
        cardRepository.removeCardsByType(CardType.WELL);
        cardRepository.saveAll(newCards);
    }

    public List<Card> findAll() {
        Iterable<Card> all = cardRepository.findAll();
        List<Card> cards = new ArrayList<>();
        for (Card card: all){
            cards.add(card);
        }
        return cards;
    }

    public void del(Card card) {
        cardRepository.deleteById(card.getId());
    }
}
