package com.cursoandroid.ph.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private ListView listLocations;
    private String [] locations = {
            "Porto Seguro", "Domingos Martins", "Salvador",
            "Ilhéus", "Cancún", "Budapeste", "Aruba", "Buenos Aires",
            "Zurique", "Tiradentes"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listLocations = findViewById(R.id.ListViewLocations);

        // Create an adapter for the list
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                getApplicationContext(),
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                locations
        );

        //Add adapter to the list
        listLocations.setAdapter(adapter);

        //Add click to the list
        listLocations.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String clicked = listLocations.getItemAtPosition(position).toString();
                Toast.makeText(getApplicationContext(), clicked, Toast.LENGTH_LONG).show();
            }
        });
    }
}