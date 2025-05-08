package cn.edu.whut.springboot_web_dev.service;

import java.util.List;

import cn.edu.whut.springboot_web_dev.dto.ContactId;
import cn.edu.whut.springboot_web_dev.model.Contact;

public interface ContactService {
    public List<Contact> findByUsername(String username);
    public void addContact(Contact contact);
    public void deleteContact(ContactId contactId);
    public void updateContact(String name, Contact contact);
}
