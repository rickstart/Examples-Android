package com.mobintum.listviewtest;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;


public class MainActivity extends ActionBarActivity {

    ListView listNames;
    ArrayAdapter adapter;
    ArrayList<String> namesArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listNames = (ListView) findViewById(R.id.listNames);

        namesArray = new ArrayList<String>();
        String[] values = new String[] { "Ricardo", "Alejandro", "Genaro",
                "Juan Carlos", "Christian" };

        for (int i = 0; i < values.length; ++i) {
            namesArray.add(values[i]);
        }

        adapter  = new ArrayAdapter(this,
                android.R.layout.simple_list_item_1, namesArray);
        listNames.setAdapter(adapter);

        listNames.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
      

            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                AlertDialog.Builder adb = new AlertDialog.Builder(MainActivity.this);
                adb.setTitle("Delete?");
                adb.setMessage("Are you sure you want to delete " + namesArray.get(position));
                final int positionToRemove = position;
                adb.setNegativeButton("Cancel", null);
                adb.setPositiveButton("Ok", new AlertDialog.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        namesArray.remove(positionToRemove);
                        adapter.notifyDataSetChanged();
                    }
                });
                adb.show();
                return false;
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
        switch (id){
            case R.id.action_add:

                namesArray.add("TEST");
                adapter.notifyDataSetChanged();

                break;
        }



        return super.onOptionsItemSelected(item);
    }
}
