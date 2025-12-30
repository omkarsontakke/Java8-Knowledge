package org.example.JavaTheoryAndImpl;

import java.util.List;

public class Users {
    String name;
    long phoneNumber;
    List<String> emails;

    public Users(String name, long phoneNumber, List<String> emails) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.emails = emails;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<String> getEmails() {
        return emails;
    }

    public void setEmails(List<String> emails) {
        this.emails = emails;
    }
}
