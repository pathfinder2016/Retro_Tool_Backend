package com.retro.common.model;

import org.springframework.data.jpa.domain.AbstractAuditable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "USER")
public class User extends AbstractAuditable<User, Long> {

    @Column(name = "DOMAIN_ID")
    private String domainId;
    @Column(name = "DISPLAY_NAME")
    private String displayName;
    @Column(name = "CATEGORY")
    private String category;
    @Column(name = "SUB_CATEGORY")
    private String subCategory;

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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSubCategory() {
        return subCategory;
    }

    public void setSubCategory(String subCategory) {
        this.subCategory = subCategory;
    }
}
