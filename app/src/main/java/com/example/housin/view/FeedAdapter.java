package com.example.housin.view;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.housin.R;
import com.example.housin.model.Casa;

import java.util.List;

public class FeedAdapter extends RecyclerView.Adapter<FeedAdapter.MyViewHolder> {

    private List<Casa> casas;
    private Casa casaAtual;
    private Context context;

    public FeedAdapter(List<Casa> casas, Context context) {
        Log.i("adapter", "construtor");
        this.casas = casas;
        this.context = context;

    }

    public List<Casa> getCasas() {
        return casas;
    }


    @NonNull
    @Override
    //chamado quando é criado
    public FeedAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        //Inflando o xml do adapter e criando a view;
        Log.i("adapter", "on create");
        View feedView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.adapter_feed, viewGroup,false);
        return new MyViewHolder(feedView);
    }

    @Override
    //chamada em cada elemento
    public void onBindViewHolder(@NonNull FeedAdapter.MyViewHolder myViewHolder, int i) {
        casaAtual = this.casas.get(i);
    }

    @Override
    //quantidade de elementos
    public int getItemCount() {
        return this.casas.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        private ImageView imageCasa;
        private TextView textoDesc;


        public MyViewHolder(@NonNull final View itemView) {
            super(itemView);
            this.imageCasa = itemView.findViewById(R.id.imageCasa);
            this.textoDesc = itemView.findViewById(R.id.textoDesc);


        }
    }
}
