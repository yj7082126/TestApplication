package yongjaekwon.testapplication2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;

public class AddItemActivty extends AppCompatActivity {

    EditText name;
    EditText description;
    EditText latitude;
    EditText longitude;
    DatePicker date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item_activty);
        name = (EditText) findViewById(R.id.itemName);
        description = (EditText) findViewById(R.id.itemDescription);
        latitude = (EditText) findViewById(R.id.itemLatitude);
        longitude = (EditText) findViewById(R.id.itemLongitude);
        date = (DatePicker) findViewById(R.id.itemDate);
       // Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

    }

    public void saveItem(View view){
        int day = date.getDayOfMonth();
        int month = date.getMonth();
        int year = date.getYear();
        int lat = Integer.parseInt(latitude.getText().toString());
        int lon = Integer.parseInt(longitude.getText().toString());

        Intent backToMain = new Intent();
        backToMain.putExtra("name", name.getText().toString());
        backToMain.putExtra("description", description.getText().toString());
        backToMain.putExtra("latitude", lat);
        backToMain.putExtra("longitude", lon);
        backToMain.putExtra("day", day);
        backToMain.putExtra("month", month);
        backToMain.putExtra("year", year);

        setResult(Activity.RESULT_OK, backToMain);
        finish();
    }

}
