package com.example.bottom_nav;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.bottom_nav.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    // Declaração da variável de binding
    ActivityMainBinding binding;

    // Método chamado quando a atividade é criada
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Infla o layout da atividade usando View Binding
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        // Define o layout inflado como o conteúdo da atividade
        setContentView(binding.getRoot());

        // Substitui o conteúdo inicial pelo fragmento HomeFragment
        replaceFragment(new HomeFragment());

        // Configura a navegação inferior
        binding.bottomNavigationView.setOnItemSelectedListener(item -> {
            // Obtém o ID do item selecionado
            int itemId = item.getItemId();

            // Verifica qual item foi selecionado e substitui o fragmento correspondente
            if (itemId == R.id.home) {
                replaceFragment(new HomeFragment());
            } else if (itemId == R.id.profile) {
                replaceFragment(new ProfileFragment());
            } else if (itemId == R.id.settings) {
                replaceFragment(new SettingsFragment());
            }

            // Indica que o item foi selecionado com sucesso
            return true;
        });
    }

    // Método para substituir fragmentos na atividade
    private void replaceFragment(Fragment fragment) {
        // Obtém o gerenciador de fragmentos
        FragmentManager fragmentManager = getSupportFragmentManager();
        // Inicia uma transação de fragmento
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        // Substitui o conteúdo do frameLayout pelo fragmento passado como parâmetro
        fragmentTransaction.replace(R.id.frameLayout, fragment);
        // Confirma a transação
        fragmentTransaction.commit();
    }
}


