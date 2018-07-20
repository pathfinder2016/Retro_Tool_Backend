package com.retro.core.retro.model;

import com.retro.common.model.User;
import org.springframework.data.jpa.domain.AbstractAuditable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "ACTION")
public class Action implements Serializable {
    @Column(name = "retro_key")
    private @Id String retroKey;

    @Column(name = "action_content")
    private String actionContent;

    public String getRetroKey() {
        return retroKey;
    }

    public void setRetroKey(String retroKey) {
        this.retroKey = retroKey;
    }

    public String getActionContent() {
        return actionContent;
    }

    public void setActionContent(String actionContent) {
        this.actionContent = actionContent;
    }
}
