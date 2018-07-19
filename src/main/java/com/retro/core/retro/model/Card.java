package com.retro.core.retro.model;

import com.retro.common.model.User;
import org.springframework.data.jpa.domain.AbstractAuditable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Objects;

@Entity @Table(name = "CARD")
public class Card extends AbstractAuditable<User, Long> {

    @Column(name = "CONTENT")
    private String content;

    @Column(name = "TYPE")
    private String type;

    @Column(name = "IS_PRIVATE")
    private int asPrivate;

    @Column(name = "ORDER_INDEX")
    private int order;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getAsPrivate() {
        return asPrivate;
    }

    public void setAsPrivate(int asPrivate) {
        this.asPrivate = asPrivate;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Card)) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        Card card = (Card)o;
        return Objects.equals(getContent(), card.getContent()) && Objects.equals(getType(), card.getType()) && Objects.equals(asPrivate, card.asPrivate) && Objects.equals(getOrder(), card.getOrder());
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), getContent(), getType(), asPrivate, getOrder());
    }
}
