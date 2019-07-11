package com.example.myapplication;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        final EditText txtAmount = (EditText)findViewById(R.id.editText1);
        final EditText txtPeople = (EditText)findViewById(R.id.editText2);
        final EditText txtPercent = (EditText)findViewById(R.id.editText3);

        Button btnGo = (Button)findViewById(R.id.button);
        btnGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                TextView billTotal = (TextView)findViewById(R.id.textView10);
                TextView billPerson = (TextView)findViewById(R.id.textView11);
                TextView tipTotal = (TextView)findViewById(R.id.textView12);
                TextView tipPerson = (TextView)findViewById(R.id.textView13);

                Double amount = Double.parseDouble(txtAmount.getText().toString());
                Double people = Double.parseDouble(txtPeople.getText().toString());
                Double percent = Double.parseDouble(txtPercent.getText().toString());

                billTotal.setText(String.valueOf(amount + people * percent * amount));
                billPerson.setText(String.valueOf((amount + people * percent * amount) / people));
                tipTotal.setText(String.valueOf(people * percent * amount));
                tipPerson.setText(String.valueOf(percent * amount));
            }
        });
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
