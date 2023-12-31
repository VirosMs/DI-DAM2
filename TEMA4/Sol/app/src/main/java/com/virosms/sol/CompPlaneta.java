package com.virosms.sol;

import android.os.Bundle;
import android.widget.ArrayAdapter;

import androidx.appcompat.app.AppCompatActivity;

import com.virosms.sol.databinding.ActivityCompPlanetaBinding;
import com.virosms.sol.entities.Planeta;

import java.util.ArrayList;
import java.util.List;

public class CompPlaneta extends AppCompatActivity {

    private ActivityCompPlanetaBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comp_planeta);

        binding = ActivityCompPlanetaBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        List<Planeta> planetas = new ArrayList<Planeta>() {{
            add(new Planeta("Mercurio", "4879", "57.9", "5.43"));
            add(new Planeta("Venus", "12104", "108.2", "5.24"));
            add(new Planeta("Tierra", "12756", "149.6", "5.52"));
            add(new Planeta("Marte", "6792", "227.9", "3.94"));
            add(new Planeta("Jupiter", "142984", "778.6", "1.33"));
            add(new Planeta("Saturno", "120536", "1433.5", "0.69"));
            add(new Planeta("Urano", "51118", "2872.5", "1.27"));
            add(new Planeta("Neptuno", "49528", "4495.1", "1.64"));
            add(new Planeta("Pluton", "???", "39,44", "5?"));
        }};

        ArrayAdapter<CharSequence> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                planetas.stream().map(Planeta::getNombre).toArray(String[]::new)
        );

        binding.planeta1.setAdapter(adapter);
        binding.planeta2.setAdapter(adapter);

        binding.planeta1.setOnItemClickListener((parent, view, position, id) -> {
            binding.diametro1.setText(planetas.stream().filter(p -> p.getNombre()
                    .equals(binding.planeta1.getText().toString())).findFirst()
                    .map(Planeta::getDiametro).orElse(""));

            binding.distancia1.setText(planetas.stream().filter(p -> p.getNombre()
                    .equals(binding.planeta1.getText().toString())).findFirst()
                    .map(Planeta::getDistanciaSol).orElse(""));

            binding.densidad1.setText(planetas.stream().filter(p -> p.getNombre()
                    .equals(binding.planeta1.getText().toString())).findFirst()
                    .map(Planeta::getDensidad).orElse(""));
        });

        binding.planeta2.setOnItemClickListener((parent, view, position, id) -> {
            binding.diametro2.setText(planetas.stream().filter(p -> p.getNombre()
                    .equals(binding.planeta2.getText().toString())).findFirst()
                    .map(Planeta::getDiametro).orElse(""));
            binding.distancia2.setText(planetas.stream().filter(p -> p.getNombre()
                    .equals(binding.planeta2.getText().toString())).findFirst()
                    .map(Planeta::getDistanciaSol).orElse(""));
            binding.densidad2.setText(planetas.stream().filter(p -> p.getNombre()
                    .equals(binding.planeta2.getText().toString())).findFirst()
                    .map(Planeta::getDensidad).orElse(""));
        });
    }
}