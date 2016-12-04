package unicauca.movil.planetas.adapters;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.media.Image;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

import unicauca.movil.planetas.R;
import unicauca.movil.planetas.databinding.TemplatePlanetaBinding;
import unicauca.movil.planetas.models.Planeta;

/**
 * Created by Dario Chamorro on 4/12/2016.
 */

public class PlanetaAdapter extends BaseAdapter {

    Context context;
    List<Planeta> data;

    public PlanetaAdapter(Context context, List<Planeta> data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int i) {
        return data.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View v =  view;

        if(v == null)
            v = View.inflate(context, R.layout.template_planeta, null);

        TemplatePlanetaBinding binding = DataBindingUtil.bind(v);
        binding.setPlaneta(data.get(i));

        return binding.getRoot();
    }

    public void setData(List<Planeta> data) {
        this.data = data;
    }
}
