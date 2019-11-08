package com.example.Deintpruebarecycler.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.Deintpruebarecycler.R;
import com.example.Deintpruebarecycler.model.Contacto;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>{
    private LayoutInflater inflater;
    // Constructor con cosas
    private Contacto misContactos[];

    private int[] imagenes;

    private OnItemClickListener listener;
    public interface OnItemClickListener{
        public void OnItemClick(Contacto contacto);
        }

    public MyAdapter(Contacto[] misContactos, int[] imagenes, OnItemClickListener listener) {
        this.misContactos = misContactos;
        this.imagenes = imagenes;
        this.listener = listener;


    }

    // Metodos del RecyclerView
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.my_recycler_view, parent, false); // Si se pone true, se engancha a la vista. Si se pone false se engancha a la vista cuando el adapter quiera.
        MyViewHolder vh = new MyViewHolder(itemView);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        // Vamos a asignar a cada holder su posicion
        final Contacto contacto = misContactos[position];
        final int imagenId = imagenes[position];
        holder.tvUno.setText(misContactos[position].getNombre());
        holder.tvDos.setText(String.valueOf((misContactos[position].getSueldo())));
        holder.ivImagen.setImageResource(imagenId);
        holder.cl.setOnClickListener(new View.OnClickListener(){
            // Le clicamos a cada recycler y dice su posicion
            @Override
            public void onClick(View view){
                Toast.makeText(view.getContext(), "has pulsado" + position, Toast.LENGTH_SHORT).show();
                listener.OnItemClick(contacto);
            }
        });
    }

    @Override
    public int getItemCount() {
        return misContactos.length;
    }


    // La clase tendra los textview que hemos creado
    public class MyViewHolder extends RecyclerView.ViewHolder { // ViewHolder para vistas individuales.
        TextView tvUno, tvDos;
        ImageView ivImagen;
        //
        ConstraintLayout cl;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            // Hasta no crear el onCreateViewHolder no va a encontrar los id
            tvUno = itemView.findViewById(R.id.tvUno);
            tvDos = itemView.findViewById(R.id.tvDos);
            ivImagen = itemView.findViewById(R.id.ivImagen);
            cl = itemView.findViewById(R.id.cl);
        }
    }

}
