package com.example.mct.searchbar;

import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    ListView listViev;
    ArrayList<String > items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );

        listViev = findViewById( R.id.listView );
        items = new ArrayList <>();
        items.add( "one" );
        items.add( "two" );
        items.add( "three" );
        items.add( "four" );
        items.add( "five" );
        items.add( "six" );
        items.add( "seven" );
        items.add( "eigth" );
        items.add( "nine" );
        items.add( "ten" );

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter <String>(this,android.R.layout.simple_list_item_1,items );
        listViev.setAdapter( arrayAdapter );

        listViev.setOnItemClickListener( new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView <?> adapterView, View view, int i, long l) {
                String text = listViev.getItemAtPosition( i ).toString();
                Toast.makeText( MainActivity.this,"" + text,Toast.LENGTH_LONG).show();

            }
        } );

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu,menu);

        MenuItem searchItem = menu.findItem( R.id.item_search);
        SearchView searchView = (SearchView) searchItem.getActionView();
        searchView.setOnQueryTextListener( new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {

                ArrayList<String> tempList = new ArrayList <>(  );

                for(String temp : items){
                    if(temp.toLowerCase().contains(s.toLowerCase())){
                        tempList.add( temp );
                    }
                }
                ArrayAdapter<String> arrayAdapter = new ArrayAdapter <String>(MainActivity.this,android.R.layout.simple_list_item_1,tempList );
                listViev.setAdapter( arrayAdapter );
                return true;

            }
        } );
        return super.onCreateOptionsMenu( menu );


    }
}
