package org.example.mobile;

import java.util.ArrayList;
import java.util.List;

public class MobilePhone {
    private String myNumber;

    private List<Contact> myContacts;

    public MobilePhone(String myNumber, List<Contact> myContacts) {
        this.myNumber = myNumber;
        this.myContacts = myContacts;
    }



    public void setMyNumber(String myNumber) {
        this.myNumber = myNumber;
    }

    public String getMyNumber() {
        return myNumber;
    }

    public List<Contact> getMyContacts() {
        return myContacts;
    }

    public int findContact(Contact contact) {
        return this.myContacts.indexOf(contact);
    }
    public int findContact(String contactName) {

        for (int i = 0; i < this.myContacts.size(); i++) {
            Contact contact = this.myContacts.get(i);
            if (contact.getName().equalsIgnoreCase(contactName)) {
                return i;
            }
        }
        return -1;
    }

    public boolean addNewContact(Contact contact) {
        if (contact == null || contact.getName() == null || contact.getPhoneNumber() == null) {
            return false;
        }
        if (findContact(contact.getName()) >= 0) {
            return false;
        }
        return this.myContacts.add(contact);

    }

    public boolean updateContact (Contact oldContact, Contact newContact) {
        int foundPosition = findContact(oldContact);
        if (oldContact == null || newContact == null || foundPosition < 0) {
            return false;
        }

        this.myContacts.set(foundPosition, newContact);
        return true;
    }

    public boolean removeContact(Contact contact) {
        if (contact == null || findContact(contact) < 0) return false;

        return this.myContacts.remove(contact);
    }

    public Contact queryContact(String contactName) {
        int index = findContact(contactName);
        if (index < 0) {
            return null;
        }
        return this.myContacts.get(index);
    }

    public void printContacts() {
        System.out.println("Contacts:");
        for (int i = 0; i < this.myContacts.size(); i++) {
            System.out.println((i + 1) + "." + this.myContacts.get(i).getName() + " -> " + this.myContacts.get(i).getPhoneNumber());
        }
    }
}
