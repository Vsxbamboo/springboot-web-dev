package cn.edu.whut.springboot_web_dev.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.whut.springboot_web_dev.dto.ContactId;
import cn.edu.whut.springboot_web_dev.mapper.ContactMapper;
import cn.edu.whut.springboot_web_dev.model.Contact;
import cn.edu.whut.springboot_web_dev.service.ContactService;

@Service
public class ContactServiceImpl implements ContactService {
    @Autowired
    private ContactMapper contactMapper;
    public List<Contact> findByUsername(String username) {
        return contactMapper.findByUsername(username);
    }
    @Override
    public void addContact(Contact contact) {
        contactMapper.insert(contact);
    }
    @Override
    public void deleteContact(ContactId contactId) {
        contactMapper.delete(contactId);
    }
    @Override
    public void updateContact(String name, Contact contact) {
        contactMapper.update(name, contact);
    }
}
