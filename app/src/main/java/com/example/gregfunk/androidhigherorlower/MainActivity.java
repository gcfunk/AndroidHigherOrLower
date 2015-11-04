package com.example.gregfunk.androidhigherorlower;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends ActionBarActivity {

    int randomNumber;
    Random randomGenerator;

    public void checkGuess(View view) {
        EditText guessedNumber = (EditText) findViewById(R.id.guessedNumber);

        int guess = Integer.parseInt(guessedNumber.getText().toString());

        String message = "";
        if (guess < randomNumber) {
            message = "Too Low";
        } else if (guess > randomNumber) {
            message = "Too High";
        } else {
            message = "Right on! Play again?";
            randomNumber = randomGenerator.nextInt(21);
        }
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        randomGenerator = new Random();
        randomNumber = randomGenerator.nextInt(21);
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
