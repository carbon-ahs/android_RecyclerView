package com.axiagroups.recyclerview.util;

import android.content.Context;
import android.widget.Toast;

import com.axiagroups.recyclerview.adapter.ContactAdapter;
import com.axiagroups.recyclerview.model.Contact;
import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.List;

public class Util {
    public static List<Contact> getNameList(){
        List<Contact> conactList = new ArrayList<>();

        for (int i = 0; i < 50; i++) {
            Faker faker = new Faker();

            String name = faker.name().fullName();
            String streetAddress = faker.address().streetAddress();

            conactList.add(new Contact(name, streetAddress));

        }

        return conactList;
    }
    public static void filteredList(Context context, String text, List<Contact> contactList, ContactAdapter contactAdapter) {
        List<Contact> filteredList = new ArrayList<>();
        for(Contact contact : contactList){
            if(contact.getName().toLowerCase().contains(text.toLowerCase())){
                filteredList.add(contact);
            }
        }
        if (filteredList.isEmpty()) {
            Toast.makeText(context, "No data found", Toast.LENGTH_SHORT).show();
        }
        else {
            contactAdapter.setContactList(filteredList);
        }
    }
}
