package com.example.Deintpruebarecycler;

import android.os.Bundle;

import com.example.Deintpruebarecycler.adapter.MyAdapter;
import com.example.Deintpruebarecycler.model.Contacto;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    // Objetos
    private RecyclerView myRecyler;
    private RecyclerView.LayoutManager layoutManager;
    private Contacto misContactos[] = new Contacto[3];

    //
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

        init();
    }

    //-----------------------
    public void init(){
        myRecyler = findViewById(R.id.myRecycler);
        // Asignarle un layout manager
        // layoutManager = new LinearLayoutManager(this); Por defecto vertical
        layoutManager = new GridLayoutManager(this,3);
        myRecyler.setLayoutManager(layoutManager);
        // Asignarle un adaptador
        crearArray();
        MyAdapter myAdapter = new MyAdapter(misContactos, new MyAdapter.OnItemClickListener() {
            @Override
            public void OnItemClick(Contacto contacto) {
                Toast.makeText(MainActivity.this, "Nombre " + contacto.getNombre(), Toast.LENGTH_SHORT).show();
            }
        });
        myRecyler.setAdapter(myAdapter);

    }

    private void crearArray() {
        misContactos[0] = new Contacto("Juan", "juan@as.net");
        misContactos[1] = new Contacto("Maria", "mariflow@as.net");
        misContactos[2] = new Contacto("Antonia", "antonia@as.net");
    }


    //-----------------------

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