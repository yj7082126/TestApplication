package yongjaekwon.testapplication2;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Kwon on 2017-01-27.
 */
public class BucketItem {
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
        Date date = new Date();
        String dateFormat = "MM/dd/yyyy";
        date = new SimpleDateFormat(dateFormat).parse("01/28/2017");
        for (int i = 0; i< numContacts; i++) {
            bucketItems.add(new BucketItem("Person " + (++lastContactId), date, i <= numContacts/2));
        }
        return bucketItems;
    }
}
