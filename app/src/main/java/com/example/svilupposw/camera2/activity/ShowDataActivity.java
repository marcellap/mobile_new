package com.example.svilupposw.camera2.activity;

import android.app.ActionBar;
import android.content.ClipData;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.view.menu.MenuView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

import com.example.svilupposw.camera2.R;
import com.example.svilupposw.camera2.adapters.showDataAdapter;
import com.example.svilupposw.camera2.models.Rifornimento;

import java.util.ArrayList;

/**
 * Created by svilupposw on 27/03/18.
 */


    public class ShowDataActivity extends AppCompatActivity {

        String txtrifornimento;
        String txtimporto;
        ArrayList<Rifornimento> dataR;
        showDataAdapter adapter;
        static final int ASK_QUESTION_REQUEST = 1;

        private ListView myShowDataList;
        private FloatingActionButton btn;
        private Toolbar toolbar;


        @Override
        protected void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

            setContentView(R.layout.show_data);
            myShowDataList = findViewById(R.id.list);

            dataR = new ArrayList<>();

            Rifornimento r = new Rifornimento("eni", 30.0);
            dataR.add(r);
            dataR.add(r);
            dataR.add(r);
            dataR.add(r);
            dataR.add(r);

            adapter = new showDataAdapter(getApplicationContext(), dataR);
            myShowDataList.setAdapter(adapter);
            btn = findViewById(R.id.button);
            toolbar = findViewById(R.id.my_toolbar);

            setSupportActionBar(toolbar);

            startEdit();

        }

        private void startEdit(){
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent myIntent = new Intent(ShowDataActivity.this,
                            EditDataActivity.class);
                    startActivityForResult(myIntent, ASK_QUESTION_REQUEST);
                }
            });
        }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
       getMenuInflater().inflate(R.menu.toolbar_menu, menu);
       //Nascondo la prima icona del menu
        menu.getItem(0).setVisible(false);
        return true;
    }

    @Override
    //click sull'item della toolbar
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.edit_profile) {
            Intent i = new Intent(ShowDataActivity.this, EditActivity.class);
            startActivity(i);
            return true;
        }
        if (id == R.id.show_profile) {
            Intent i = new Intent(ShowDataActivity.this, ShowActivity.class);
            startActivity(i);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == ASK_QUESTION_REQUEST) {
            if (resultCode == 2) {
                txtrifornimento = data.getStringExtra("rifornimento");
                txtimporto = data.getStringExtra("importo");

                // this line adds the data of your EditText and puts in your array
                // data.add(editTxt.getText().toString());
                // next thing you have to do is check if your adapter has changed
                // adapter.notifyDataSetChanged();

                Rifornimento r = new Rifornimento(txtrifornimento, Double.parseDouble(txtimporto));
                dataR.add(r);
                adapter.notifyDataSetChanged();
            }
        }
    }



}






