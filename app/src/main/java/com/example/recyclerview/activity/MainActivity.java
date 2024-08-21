package com.example.recyclerview.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.recyclerview.R;
import com.example.recyclerview.adapter.Adapter;
import com.example.recyclerview.model.Compromisso;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<Compromisso> listaCompromissos = new ArrayList<>();
    private Adapter adapter;

    private EditText editTitulo, editData, editLocal, editHorario;
    private Button btnAdicionar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inicializar componentes
        recyclerView = findViewById(R.id.recyclerView);
        editTitulo = findViewById(R.id.editTitulo);
        editData = findViewById(R.id.editData);
        editLocal = findViewById(R.id.editLocal);
        editHorario = findViewById(R.id.editHorario);
        btnAdicionar = findViewById(R.id.btnAdicionar);

        // Configurar RecyclerView
        adapter = new Adapter(listaCompromissos);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayout.VERTICAL));
        recyclerView.setAdapter(adapter);

        // Evento de clique para adicionar compromisso
        btnAdicionar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adicionarCompromisso();
            }
        });

        // Evento de clique na listagem
        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(
                getApplicationContext(),
                recyclerView,
                new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        Compromisso compromisso = listaCompromissos.get(position);
                        Toast.makeText(getApplicationContext(), "Local: " + compromisso.getLocal(), Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onLongItemClick(View view, int position) {
                        // Ação para clique longo (opcional)
                    }
                }
        ));
    }

    private void adicionarCompromisso() {
        String titulo = editTitulo.getText().toString();
        String data = editData.getText().toString();
        String local = editLocal.getText().toString();
        String horario = editHorario.getText().toString();

        if (!titulo.isEmpty() && !data.isEmpty() && !local.isEmpty() && !horario.isEmpty()) {
            Compromisso compromisso = new Compromisso(titulo, data, local, horario);
            listaCompromissos.add(compromisso);
            adapter.notifyDataSetChanged(); // Atualizar lista
            limparCampos(); // Limpar campos após adicionar
        } else {
            Toast.makeText(this, "Preencha todos os campos!", Toast.LENGTH_SHORT).show();
        }
    }

    private void limparCampos() {
        editTitulo.setText("");
        editData.setText("");
        editLocal.setText("");
        editHorario.setText("");
    }
}
