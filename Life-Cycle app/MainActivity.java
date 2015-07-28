package cz.davidkocnar.life_cycleapp;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toast to = Toast.makeText(getApplicationContext(), "onCreate!", Toast.LENGTH_LONG);
        to.show();
    }

    @Override
    protected void onResume() {
        //super.onCreate(savedInstanceState);
        super.onResume();
        Toast to = Toast.makeText(getApplicationContext(), "onResume!", Toast.LENGTH_LONG);
        to.show();
        //Log.i("MainActivity", "onResume!");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast to = Toast.makeText(getApplicationContext(), "onResume!", Toast.LENGTH_LONG);
        to.show();
        //Log.i("MainActivity","onPause!");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast to = Toast.makeText(getApplicationContext(), "onStop!", Toast.LENGTH_LONG);
        to.show();
        //Log.i("MainActivity","onPause!");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast to = Toast.makeText(getApplicationContext(), "onDestroy!", Toast.LENGTH_LONG);
        to.show();
        //Log.i("MainActivity","onPause!");
    }

}
