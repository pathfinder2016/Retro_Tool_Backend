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

    public void upsertPublicCards(ArrayList<Card> newCards, String cardType) {
        switch (cardType) {
            case CardType.WELL:
                cardRepository.removeCardsByType(CardType.WELL);
                break;
            case CardType.NOT_WELL:
                cardRepository.removeCardsByType(CardType.NOT_WELL);
                break;
            default:
                cardRepository.removeCardsByType(CardType.SUGGESTION);
                break;
        }
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
