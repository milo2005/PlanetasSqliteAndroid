package unicauca.movil.planetas;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

import unicauca.movil.planetas.adapters.PlanetaAdapter;
import unicauca.movil.planetas.databinding.ActivityMainBinding;
import unicauca.movil.planetas.models.Planeta;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    PlanetaAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setHandler(this);

        adapter = new PlanetaAdapter(this, new ArrayList<Planeta>());
        binding.list.setAdapter(adapter);

    }

    public void goToAdd(){
        Intent intent = new Intent(this, AddActivity.class);
        startActivity(intent);
    }
}
