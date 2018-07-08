package com.retro.common.model;

import org.springframework.data.jpa.domain.AbstractAuditable;
import javax.persistence.*;

@Entity
public class User extends AbstractAuditable<User, Long> {

    @Column(name = "DOMAIN_ID")
    private String domainId;
    @Column(name = "DISPLAY_NAME")
    private String displayName;

    public String getDomainId() {
        return domainId;
    }

    public void setDomainId(String domainId) {
        this.domainId = domainId;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }
}
