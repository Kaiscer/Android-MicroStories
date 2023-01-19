package com.example.microcuento.utilrv;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.microcuento.R;
import com.example.microcuento.model.Story;

import java.util.ArrayList;

/**
 * Esta clase es el adaptador de la lista de historias.
 * 1- Debemos crear el ViewHolder
 * 2- Indicamos que vamos a usar el ViewHolder creado en el paso 1
 * 3- Implementamos los métodos de la clase RecyclerView.Adapter
 */
public class StoryAdapter extends RecyclerView.Adapter<StoryAdapter.StoryVH>
        implements View.OnClickListener {

    private ArrayList<Story> data;

    private View.OnClickListener listener;

    public StoryAdapter(ArrayList<Story> data, View.OnClickListener listener) {
        this.data = data;
        this.listener = listener;
    }



    /**
     * Este método crea una vista con el layoutInflater y la devuelve
     * @param parent
     * @param viewType
     * @return StoryVH
     */
    @NonNull
    @Override
    public StoryVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cuento_item, parent, false);
        v.setOnClickListener(this);
        StoryVH vh = new StoryVH(v);

        return vh;

    }

    /**
     * Este método su función es volcar los datos de la lista en el ViewHolder con la posición que
     * se le pasa como parámetro
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(@NonNull StoryVH holder, int position) {
            holder.bindStory(data.get(position));
    }

    /**
     * Este método es el que nos indica cuántos elementos tiene la lista
     * @return
     */
    @Override
    public int getItemCount() {
        return data.size();
    }

    @Override
    public void onClick(View v) {
        if(listener != null){
            listener.onClick(v);
        }
    }

    /**
     * 1- Creamos el ViewHolder que extiende de RecyclerView.ViewHolder
     * En esta clase debemos crear dos métodos:
     * 1- Un constructor que reciba un View
     * 2- Un método que reciba un objeto de tipo Story y que asigne los valores a los elementos del layout
     */
    public static class StoryVH extends RecyclerView.ViewHolder {
        private TextView tvTitle;
        private TextView tvAdvance;

        public StoryVH(@NonNull View itemView){
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tv_TitleS);
            tvAdvance = itemView.findViewById(R.id.tv_Advance);
        }

        public void bindStory(Story story){
            tvTitle.setText(story.getTitle());
            tvAdvance.setText(story.getAdvance());
        }

    }

}
