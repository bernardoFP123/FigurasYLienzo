package misiont.mision4.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import misiont.mision4.R;
import misiont.mision4.Views.Lienzo;

public class CanvaActivity extends AppCompatActivity {

    public static final String LLAVE_DRAW_TYPE = "drawtype";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        String stringDrawType = getIntent().getExtras().getString(LLAVE_DRAW_TYPE);

        Lienzo.DrawType drawtype;
        String message;
        //Envía el mensaje adecuado al iniciar la actividad y declara un lienzo que dibuje la figura requerida
        if(Lienzo.DrawType.circle.name().equals(stringDrawType)){
            drawtype = Lienzo.DrawType.circle;
            setTitle(getString(R.string.circleName));
            message = getString(R.string.circleMessage);
        }
        else if(Lienzo.DrawType.square.name().equals(stringDrawType)){
            drawtype = Lienzo.DrawType.square;
            setTitle(getString(R.string.squareName));
            message = getString(R.string.squareMessage);
        }
        else if(Lienzo.DrawType.rectangle.name().equals(stringDrawType)){
            drawtype = Lienzo.DrawType.rectangle;
            setTitle(getString(R.string.rectangleName));
            message = getString(R.string.rectangleMessage);
        }
        else if(Lienzo.DrawType.oval.name().equals(stringDrawType)){
            drawtype = Lienzo.DrawType.oval;
            setTitle(getString(R.string.ovalName));
            message = getString(R.string.ovalMessage);
        }
        else{
            drawtype = Lienzo.DrawType.free;
            setTitle(getString(R.string.freeFigureName));
            message = getString(R.string.freeFigureMessage);
        }
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();



        setContentView(Lienzo.getLienzo(getApplicationContext(),drawtype));
    }
}

