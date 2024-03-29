package com.example.simpletodo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import static com.example.simpletodo.MainActivity.ITEM_POSITION;
import static com.example.simpletodo.MainActivity.ITEM_TEXT;

public class EditItemActivity extends AppCompatActivity {

    // track edit text
    EditText etItemText;
    // position of edited item in list
    int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_item);

        // resolve edit text from layout
        etItemText = findViewById(R.id.etItemtext);
        // set edit text value from intent extra
        etItemText.setText(getIntent().getStringExtra(ITEM_TEXT));
        // update the position form intent extra
        position = getIntent().getIntExtra(ITEM_POSITION,0);
        // update the title bar of the activity
        getSupportActionBar().setTitle("Edit Item");


    }

    // handler for save button
    public void onSaveItem(View v){

        // new intent to return
        Intent i = new Intent();
        //pass updated item text as extra
        i.putExtra(ITEM_TEXT,etItemText.getText().toString());
        //put original position as extra
        i.putExtra(ITEM_POSITION,position);
        // set the intent as the result of the activity
        setResult(RESULT_OK,i);
        // close the activity and redirect to main
        finish();
    }

    public void setItemUrgent(View v){

        String val = etItemText.getText().toString();

        etItemText.setText(val.toUpperCase());
        onSaveItem(v);


    }
}
