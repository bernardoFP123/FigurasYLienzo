package misiont.mision4.ViewHolders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import misiont.mision4.Adapters.FigureMenuRecyclerViewAdapter;
import misiont.mision4.Models.FigureOptionModel;
import misiont.mision4.R;

/**
 * Created by Bernardo_NoAdmin on 04/02/2018.
 */
public class FigureViewHolder extends RecyclerView.ViewHolder{

    TextView textViewName;
    TextView textViewDescription;
    ImageView imageViewShape;
    FigureOptionModel figureOptionModel;
    FigureMenuRecyclerViewAdapter.OnChildItemSelected onChildItemSelected;

    public FigureViewHolder(View itemView) {
        super(itemView);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onChildItemSelected.onChildItemSelected(figureOptionModel);
            }
        });
        textViewName = itemView.findViewById(R.id.textViewShapeName);
        textViewDescription = itemView.findViewById(R.id.textViewShapeDescription);
        imageViewShape = itemView.findViewById(R.id.imageViewShape);
    }
    public void bind(FigureOptionModel figureOptionModel, FigureMenuRecyclerViewAdapter.OnChildItemSelected onChildItemSelected){
        this.onChildItemSelected = onChildItemSelected;
        this.figureOptionModel = figureOptionModel;
        textViewName.setText(figureOptionModel.getFigureName());
        textViewDescription.setText(figureOptionModel.getFigureDescription());
        imageViewShape.setImageResource(figureOptionModel.getFigureDrawableResource());
    }
}
