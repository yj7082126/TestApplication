package yongjaekwon.testapplication2;

import java.util.ArrayList;

/**
 * Created by Kwon on 2017-01-27.
 */
public class BucketItem {
    private String mName;
    private boolean mOnline;

    public BucketItem(String name, boolean online) {
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

    public static ArrayList<BucketItem> createContactsList(int numContacts) {
       ArrayList<BucketItem> bucketItems = new ArrayList<BucketItem>();
        for (int i = 0; i< numContacts; i++) {
            bucketItems.add(new BucketItem("Person " + (++lastContactId), i <= numContacts/2));
        }
        return bucketItems;
    }
}
