package com.example.aula2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    Spinner spinner;
    List<User> listaDeUsers;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner = findViewById(R.id.spinnerDeUsuarios);
        buscaDados();
    }

    private void buscaDados(){
        RetrofitService.getServico().getUsers().enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                List<User> listaDeUsers = response.body();
                List<String> nomesDeUsers = new ArrayList<String>();
                for (User user: listaDeUsers){
                    nomesDeUsers.add(user.getName());
                }
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this,
                        android.R.layout.simple_spinner_item,nomesDeUsers);
                spinner.setAdapter(adapter);
                spinner.setOnItemSelectedListener(MainActivity.this);
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                Log.e("aula",t.getMessage());
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        TextView saida = findViewById(R.id.viewUsuario);
        User user = listaDeUsers.get(position);
        saida.setText("Nome: "+user.getName()+" \nEmail: "+user.getEmail());
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
