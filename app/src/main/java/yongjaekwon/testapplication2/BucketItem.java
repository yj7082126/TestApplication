package yongjaekwon.testapplication2;

import java.sql.Timestamp;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

/**
 * Created by Kwon on 2017-01-27.
 */
public class BucketItem implements Comparable<BucketItem>{
    private String mName;
    private Date mDate;
    private boolean mOnline;

    public BucketItem(String name, Date date, boolean online) {
        mName = name;
        mDate = date;
        mOnline = online;
    }

    public String getName() {
        return mName;
    }

    public Date getDate() { return mDate;}

    public boolean isOnline() {
        return mOnline;
    }

    public static int lastContactId = 0;

    public static ArrayList<BucketItem> createContactsList(int numContacts) throws ParseException {
        ArrayList<BucketItem> bucketItems = new ArrayList<BucketItem>();
        for (int i = 0; i< numContacts; i++) {
            long beginTime = Timestamp.valueOf("2013-01-01 00:00:00").getTime();
            long endTime = Timestamp.valueOf("2013-12-31 00:58:00").getTime();
            long diff = endTime - beginTime + 1;
            Date date = new Date(beginTime + (long)(Math.random() * diff));
            bucketItems.add(new BucketItem("Person " + (++lastContactId), date, i <= numContacts/2));
        }
        Collections.sort(bucketItems);
        return bucketItems;
    }

    @Override
    public int compareTo(BucketItem o) {
        if (mDate.getTime() > o.getDate().getTime()) {
            return 1;
        }
        else if (mDate.getTime() < o.getDate().getTime()) {
            return -1;
        }
        else {
            return 0;
        }
    }
}
