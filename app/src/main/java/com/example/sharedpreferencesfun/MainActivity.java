package com.example.sharedpreferencesfun;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    static final String SHARED_PREFERENCES_FNAME = "sharedpreferences";
    static final String NAME_KEY = "name"; // for key value pair

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // task: fetch the name and set it as the EditText text
        EditText editText = (EditText) findViewById(R.id.nameEditText);
        String name;
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFERENCES_FNAME, 0);
        name = sharedPreferences.getString(NAME_KEY, "");
        editText.setText(name);
    }

    @Override
    protected void onStop() {
        super.onStop();

        // persistent data storage: save data between sessions/runs of the app
        // options for persistent data storage
        // 1. SharedPreferences: save preferences ("Settings") AND/OR
        // simple values
        // 2. read/write to a file
        // 3. SQLite database
        // 4. Room persistence library: abstraction layer on top of SQLite

        // let's do (1.)
        // in onStop() we are going to "put" the name from the EditText
        EditText nameEditText = (EditText) findViewById(R.id.nameEditText);
        String name = nameEditText.getText().toString();
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFERENCES_FNAME, 0);
        // 0 Context.MODE_PRIVATE
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(NAME_KEY, name);
        editor.apply(); // or commit(), writes to disk

    }
}
