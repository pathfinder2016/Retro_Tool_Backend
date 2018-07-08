package com.retro.core.retro.model;

import com.retro.common.model.User;
import org.springframework.data.jpa.domain.AbstractAuditable;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "RETRO")
public class Retro extends AbstractAuditable<User, Long> {

    @OneToMany(cascade = {CascadeType.ALL})
    @JoinColumn(name = "retro_id")
    private List<Card> cardList;

    public List<Card> getCardList() {
        return cardList;
    }

    public void setCardList(List<Card> cardList) {
        this.cardList = cardList;
    }
}
