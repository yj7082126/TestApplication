package yongjaekwon.testapplication2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Contact> contacts;
    EditText nameField;
    RecyclerView rvContacts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvContacts = (RecyclerView) findViewById(R.id.rvContacts);
        nameField = (EditText) findViewById(R.id.personName);

        // Initialize contacts
        contacts = Contact.createContactsList(1);
        // Create adapter passing in the sample user data
        ContactAdapter adapter = new ContactAdapter(this, contacts);
        // Attach the adapter to the recyclerview to populate items
        rvContacts.setAdapter(adapter);
        // Set layout manager to position the items
        rvContacts.setLayoutManager(new LinearLayoutManager(this));
        // That's all!
    }

    public void addContact(View view) {
        //Make sure it is a name
        String name = nameField.getText().toString();
        if (!name.equals("")) {
            Log.d("ListExample", "addContact " + nameField.getText().toString());
            contacts.add(new Contact(name, true));
            rvContacts.getAdapter().notifyDataSetChanged();
            nameField.setText("");
        }
    }

    public void sendMessage(View view) {
        TextView currentItem = (TextView)view;
        String text = currentItem.getText().toString();
        Log.d("ListExample", "sendMessage to " + text);
        Toast.makeText(this, "Sending message to " + text, Toast.LENGTH_LONG).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
