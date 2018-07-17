package com.retro.core.retro.model;

import com.retro.common.model.User;
import org.springframework.data.jpa.domain.AbstractAuditable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity @Table(name = "CARD")
public class Card extends AbstractAuditable<User, Long> {

    @Column(name = "CONTENT")
    private String content;

    @Column(name = "TYPE")
    private String type;

    @Column(name = "IS_PRIVATE")
    private Boolean isPrivate;

    @Column(name = "ORDER_INDEX")
    private Integer order;

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

    public Boolean getPrivate() {
        return isPrivate;
    }

    public void setPrivate(Boolean aPrivate) {
        isPrivate = aPrivate;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }
}
