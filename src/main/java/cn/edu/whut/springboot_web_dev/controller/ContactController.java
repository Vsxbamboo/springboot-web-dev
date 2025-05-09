package cn.edu.whut.springboot_web_dev.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.edu.whut.springboot_web_dev.dto.ContactForm;
import cn.edu.whut.springboot_web_dev.dto.ContactId;
import cn.edu.whut.springboot_web_dev.model.Contact;
import cn.edu.whut.springboot_web_dev.service.ContactService;
import cn.edu.whut.springboot_web_dev.util.JwtUtil;

@RestController
@RequestMapping("/contacts")
public class ContactController {
    @Autowired
    private ContactService contactService;

    @GetMapping
    public ResponseEntity<List<Contact>> getContacts() {
        String username = JwtUtil.getCurrentUsername();
        List<Contact> contacts = contactService.findByUsername(username);
        return ResponseEntity.ok(contacts);
    }

    @PostMapping
    public ResponseEntity<Void> addContact(@RequestBody ContactForm form) {
        String username = JwtUtil.getCurrentUsername();
        Contact contact = new Contact();
        contact.setUsername(username);
        contact.setName(form.getName());
        contact.setProvince(form.getProvince());
        contact.setCity(form.getCity());
        contact.setAddress(form.getAddress());
        contact.setPostalCode(form.getPostalCode());
        contact.setDate(form.getDate());
        try {
            contactService.addContact(contact);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/{name}")
    public ResponseEntity<Void> deleteContact(@PathVariable String name) {
        String username = JwtUtil.getCurrentUsername();
        ContactId contactId = new ContactId();
        contactId.setUsername(username);
        contactId.setName(name);
        contactService.deleteContact(contactId);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{name}")
    public ResponseEntity<Void> updateContact(@PathVariable String name, @RequestBody ContactForm form) {
        // System.out.println(name);
        // System.out.println(form);
        String username = JwtUtil.getCurrentUsername();
        Contact contact = new Contact();
        contact.setUsername(username);
        contact.setName(form.getName());
        contact.setProvince(form.getProvince());
        contact.setCity(form.getCity());
        contact.setAddress(form.getAddress());
        contact.setPostalCode(form.getPostalCode());
        contact.setDate(form.getDate());
        contactService.updateContact(name, contact);
        return ResponseEntity.ok().build();
    }
}
