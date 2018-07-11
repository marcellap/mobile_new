package com.example.svilupposw.camera2.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.svilupposw.camera2.R;

/**
 * Created by svilupposw on 27/03/18.
 */

public class EditActivity extends AppCompatActivity {
    // Creo le EditText
    private EditText nameEdit;
    private EditText bioEdit;
    private EditText telEdit;
    private EditText emailEdit;
    private Button scattaButton;
    private Button btnEditData;

    // Creo le string che mi serviranno per salvare in modo temporaneo
    String name = "";
    String bio = "";
    String tel = "";
    String email = "";

    //Creo una variabile per aprire la videocamera
    static final int REQUEST_IMAGE_CAPTURE =1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_edit);

        // Recupero le info dal Layout, deve essere la prima operazione
        // anche nel caso di modifica
        nameEdit = findViewById(R.id.editName);
        bioEdit = findViewById(R.id.editBio);
        telEdit = findViewById(R.id.editTel);
        emailEdit = findViewById(R.id.editEmail);
        scattaButton = findViewById(R.id.buttonImage);
        btnEditData = findViewById(R.id.btnEditData);

        if (getIntent() != null) {
            nameEdit.setText(getIntent().getExtras().getString("name"));
            bioEdit.setText(getIntent().getExtras().getString("bio"));
            telEdit.setText(getIntent().getExtras().getString("tel"));
            emailEdit.setText(getIntent().getExtras().getString("email"));
        }
        // Viene valorizzato quando ruoto il telefono
        if (savedInstanceState != null) {
            name = savedInstanceState.getString("name");
            bio = savedInstanceState.getString("bio");
            tel = savedInstanceState.getString("tel");
            email = savedInstanceState.getString("email");

            nameEdit.setText(name);
            bioEdit.setText(bio);
            telEdit.setText(tel);
            emailEdit.setText(email);
        }

        setListeners();
    }


    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);

        outState.putString("name", name);
        outState.putString("bio", bio);
        outState.putString("tel", tel);
        outState.putString("email", email);
    }

    private void setListeners() {

        // metodo chiamato ogni volta che il testo in input cambia
        nameEdit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

                // salvo quello che l'utente scrive
                //name = editable.toString();

                // uguale a
                name = nameEdit.getText().toString();
            }
        });


        bioEdit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

                bio = bioEdit.getText().toString();
            }
        });


        telEdit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

                tel = telEdit.getText().toString();
            }
        });


        emailEdit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                email = emailEdit.getText().toString();
            }
        });

        scattaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                snapPhoto();
            }
        });

        btnEditData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent();
                i.putExtra("name", name);
                i.putExtra("bio", bio);
                i.putExtra("tel", tel);
                i.putExtra("email", email);
                //valore 1 immesso solo come controllo quando si passando i dati
                setResult(1,i);

                finish();
            }
        });

    }

    private void snapPhoto() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        //if (takePictureIntent.resolveActivity((getPackegManager())) != null) {
            //startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        //}
    }





}
