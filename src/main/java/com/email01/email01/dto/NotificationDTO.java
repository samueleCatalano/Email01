package com.email01.email01.dto;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class NotificationDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public String contactId;
    public String title;
    public String text;

    public NotificationDTO(String contactId, String title, String text) {
        this.contactId = contactId;
        this.title = title;
        this.text = text;
    }

    public String getContactId() {
        return contactId;
    }

    public void setContactId(String contactId) {
        this.contactId = contactId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
