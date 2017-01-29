package yongjaekwon.testapplication2;

import java.util.ArrayList;

/**
 * Created by Kwon on 2017-01-27.
 */
public class Contact {
    private String mName;
    private boolean mOnline;

    public Contact(String name, boolean online) {
        mName = name;
        mOnline = online;
    }

    public String getName() {
        return mName;
    }

    public boolean isOnline() {
        return mOnline;
    }

    public static int lastContactId = 0;

    public static ArrayList<Contact> createContactsList(int numContacts) {
       ArrayList<Contact> contacts = new ArrayList<Contact>();
        for (int i = 0; i< numContacts; i++) {
            contacts.add(new Contact("Person " + (++lastContactId), i <= numContacts/2));
        }
        return contacts;
    }
}
