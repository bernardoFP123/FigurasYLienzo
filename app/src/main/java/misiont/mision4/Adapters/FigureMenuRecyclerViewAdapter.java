package misiont.mision4.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import misiont.mision4.Models.FigureOptionModel;
import misiont.mision4.R;
import misiont.mision4.ViewHolders.FigureViewHolder;
import misiont.mision4.Views.Lienzo;

/**
 * Created by Bernardo_NoAdmin on 04/02/2018.
 */

public class FigureMenuRecyclerViewAdapter extends RecyclerView.Adapter<FigureViewHolder> {

    List<FigureOptionModel> lista;
    Context context;
    OnChildItemSelected onChildItemSelected;

    public FigureMenuRecyclerViewAdapter(Context context, OnChildItemSelected onChildItemSelected){
        this.context = context;
        this.onChildItemSelected = onChildItemSelected;
        lista = new ArrayList<>();
        lista.add(new FigureOptionModel(R.drawable.circle,context.getString(R.string.circleName),context.getString(R.string.circleDescription), Lienzo.DrawType.circle));
        lista.add(new FigureOptionModel(R.drawable.oval,context.getString(R.string.ovalName),context.getString(R.string.ovalDescription), Lienzo.DrawType.oval));
        lista.add(new FigureOptionModel(R.drawable.square,context.getString(R.string.squareName),context.getString(R.string.squreDescription), Lienzo.DrawType.square));
        lista.add(new FigureOptionModel(R.drawable.rectangle,context.getString(R.string.rectangleName),context.getString(R.string.rectangleDescription), Lienzo.DrawType.rectangle));
        lista.add(new FigureOptionModel(R.mipmap.ic_star,context.getString(R.string.freeFigureName),context.getString(R.string.freeFigureDescription), Lienzo.DrawType.free));

    }

    @Override
    public FigureViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.figure_option_layout,parent,false);
        return new FigureViewHolder(view);
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    @Override
    public void onBindViewHolder(FigureViewHolder holder, int position) {
        holder.bind(lista.get(position),onChildItemSelected);
    }


    public interface OnChildItemSelected
    {
        void onChildItemSelected(FigureOptionModel figureOptionModel);
    }

}

