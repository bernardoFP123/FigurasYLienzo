package misiont.mision4.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import misiont.mision4.Adapters.FigureMenuRecyclerViewAdapter;
import misiont.mision4.Models.FigureOptionModel;
import misiont.mision4.R;
import misiont.mision4.Views.Lienzo;

public class MainActivity extends AppCompatActivity implements FigureMenuRecyclerViewAdapter.OnChildItemSelected {

    RecyclerView recyclerView;
    FigureMenuRecyclerViewAdapter adapter;
    RecyclerView.LayoutManager layoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerViewShapeOptions);
        adapter = new FigureMenuRecyclerViewAdapter(this,this);
        layoutManager = new LinearLayoutManager(this);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);



    }

    @Override
    public void onChildItemSelected(FigureOptionModel figureOptionModel) {
        Intent intent = new Intent(MainActivity.this,CanvaActivity.class);
        intent.putExtra(CanvaActivity.LLAVE_DRAW_TYPE,figureOptionModel.getDrawType().name());
        startActivity(intent);
    }
}
