package com.contact.service.Impl;

import com.contact.entity.Contact;
import com.contact.service.ContactService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ContactServiceImpl implements ContactService {

    List<Contact> list = new ArrayList<>(Arrays.asList(
            new Contact(31L,"kishor@gmail.com","2325525456",12L),
            new Contact(313L,"kishorrtr@gmail.com","892325525",12L),
            new Contact(32L,"shree@gmail.com","6736646560",13L),
            new Contact(33L,"tej@gmail.com","436566656",13L)
    ));

    @Override
    public List<Contact> getContactofUser(Long userId) {
        return list.stream().filter(contact ->contact.getUserId().equals(userId)).collect(Collectors.toList());
    }
}
