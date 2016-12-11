package unicauca.movil.planetas;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import unicauca.movil.planetas.database.PlanetaDao;
import unicauca.movil.planetas.databinding.ActivityAddBinding;
import unicauca.movil.planetas.models.Planeta;

public class AddActivity extends AppCompatActivity {

    ActivityAddBinding binding;
    Planeta planeta;
    PlanetaDao dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_add);
        binding.setHandler(this);

        planeta = new Planeta();
        dao = new PlanetaDao(this);
    }

    public void save(){
        String nombre = binding.nombre.getText().toString();
        float gravedad = Float.parseFloat(binding.gravedad.getText().toString());

        planeta.setNombre(nombre);
        planeta.setGravedad(gravedad);
        dao.insert(planeta);
        finish();

    }
}
