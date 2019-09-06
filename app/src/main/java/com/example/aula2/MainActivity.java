package com.example.aula2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    TextView textView1;
    TextView textView2;
    TextView textView3;
    TextView textView4;
    TextView textView5;
    TextView textView6;
    ImageView imageView1;
    List<Notas> listaDeAlunos;
    List<Notas> listaDeNotas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView1 = findViewById(R.id.aluno1);
        textView2 = findViewById(R.id.aluno2);
        textView3 = findViewById(R.id.aluno3);
        textView4 = findViewById(R.id.nota1);
        textView5 = findViewById(R.id.nota2);
        textView6 = findViewById(R.id.nota3);
        imageView1 = findViewById(R.id.imageView);
        buscaDados();
    }

    private void buscaDados(){
        RetrofitService.getServico().getName().enqueue(new Callback<List<Notas>>() {
            @Override
            public void onResponse(Call<List<Notas>> call, Response<List<Notas>> response) {
                listaDeAlunos = response.body();
                List<String> nomesDeAlunos = new ArrayList<String>();
                for (Notas Notas: listaDeAlunos){
                    nomesDeAlunos.add(Notas.getName());

                }
                listaDeNotas = response.body();
                List<String> notasDeAlunos = new ArrayList<String>();
                for (Notas Notas: listaDeNotas){
                    notasDeAlunos.add(Notas.getNota());

                }

                textView1.setText(nomesDeAlunos.get(0));
                textView2.setText(nomesDeAlunos.get(1));
                textView3.setText(nomesDeAlunos.get(2));

                textView4.setText(notasDeAlunos.get(0));
                textView5.setText(notasDeAlunos.get(1));
                textView6.setText(notasDeAlunos.get(2));

                String nota1 = notasDeAlunos.get(0);
                int nota1_int = Integer.parseInt(nota1);
                if(nota1_int < 6){
                    imageView1.setImageResource(R.drawable.vermelho);
                } else {
                    imageView1.setImageResource(R.drawable.azul);
                }


                ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this,
                        android.R.layout.simple_list_item_1,nomesDeAlunos);




            }

            @Override
            public void onFailure(Call<List<Notas>> call, Throwable t) {
                Log.e("aula",t.getMessage());
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        TextView saida = findViewById(R.id.aluno2);
        Notas Notas = listaDeAlunos.get(position);
        saida.setText("Nome: "+Notas.getName()+" \nNota: "+Notas.getNota());
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
