package com.example.svilupposw.camera2.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
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

public class EditDataActivity extends AppCompatActivity {
    private EditText txtRifornimento;
    private EditText txtImporto;
    private Button btnEdit;

    // Creo le string che mi serviranno per salvare in modo temporaneo
    String rifornimento = "";
    String importo = "";



    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_data);

        txtRifornimento = findViewById(R.id.editRifornimento);
        txtImporto = findViewById(R.id.editImporto);
        btnEdit = findViewById(R.id.btnEditData);

        setListeners();
    }

    // Bundle per far tornare i dati
    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);

        outState.putString("rifornimento", rifornimento);
        outState.putString("importo", importo);
    }

    private void setListeners() {

        // metodo chiamato ogni volta che il testo in input cambia
        txtRifornimento.addTextChangedListener(new TextWatcher() {
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
                rifornimento = txtRifornimento.getText().toString();
            }
        });

        txtImporto.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

                importo = txtImporto.getText().toString();
            }
        });

        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent();
                i.putExtra("rifornimento", rifornimento);
                i.putExtra("importo", importo);

                //valore 2 immesso solo come controllo quando si passando i dati
                setResult(2,i);

                finish();
            }
        });

    }

}
