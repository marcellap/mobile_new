package com.example.svilupposw.camera2.activity;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.svilupposw.camera2.R;
import com.example.svilupposw.camera2.activity.EditActivity;
import com.example.svilupposw.camera2.models.Rifornimento;

public class ShowActivity extends AppCompatActivity {

    // creiamo gli oggetti view creati nell'xml (e istanziati nell'xml)
    private ImageView profilePhoto;
    private TextView nameText;
    private TextView bioText;
    private TextView telText;
    private TextView emailText;

    private ImageView Photo;
    private String name;
    private String bio;
    private String tel;
    private String email;

    private Toolbar toolbar;
    static final int ASK_QUESTION_REQUEST = 1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_show);

        toolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);

        profilePhoto = findViewById(R.id.profileImage);
        nameText = findViewById(R.id.nameText);
        bioText = findViewById(R.id.bioText);
        telText = findViewById(R.id.telText);
        emailText = findViewById(R.id.emailText);

        //nameText.setText("Nome");
        //bioText.setText("Sono nato a ...");
        //telText.setText("3296476");
        //emailText.setText("mail@mail.com");

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.toolbar_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.edit_profile) {
            Intent i = new Intent(getApplicationContext(), EditActivity.class);
            //startActivity(i);

            //Passo i dati dall'activity dello show all'edit
            i.putExtra("name", nameText.getText());
            i.putExtra("bio", bioText.getText());
            i.putExtra("tel", telText.getText());
            i.putExtra("email", emailText.getText());
            //i.putExtra("photo", profilePhoto.);

            startActivityForResult(i,1);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == ASK_QUESTION_REQUEST) {
            if (resultCode == 1) {
                nameText.setText(data.getStringExtra("name"));
                bioText.setText(data.getStringExtra("bio"));
                telText.setText(data.getStringExtra("tel"));
                emailText.setText(data.getStringExtra("email"));

            }
        }
    }


}
