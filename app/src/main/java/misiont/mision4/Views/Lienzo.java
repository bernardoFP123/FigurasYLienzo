package misiont.mision4.Views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import misiont.mision4.R;

public class Lienzo extends View {

    DrawType drawType;
    Context context;
    List<Point> figureOffsets;
    Point pointForPath = new Point(0,0);
    int id = 0;
    Path path = new Path();

    //Crea un lienzo que dibuja la figura requerida
    public static Lienzo getLienzo(Context context, DrawType drawType){
        return new Lienzo(context,drawType);
    }

    Lienzo(Context context,DrawType drawType) {
        super(context);
        this.context = context;
        this.drawType = drawType;
        figureOffsets = new ArrayList<>();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawColor(Color.WHITE);
        Paint paint = new Paint();
        paint.setColor(getResources().getColor(R.color.shapeColor));

        //Actua diferente dependiendo de si necesita dibujar figuras o si necesita dibujar libremente
        if(drawType == DrawType.free){
            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeWidth(getResources().getDimension(R.dimen.figureStrokeWidth));
            if(id == 1){
                path.moveTo(pointForPath.getX(),pointForPath.getY());
            }
            if(id == 2){
                path.lineTo(pointForPath.getX(),pointForPath.getY());
            }
            canvas.drawPath(path,paint);

        }
        else{
            paint.setStyle(Paint.Style.FILL);
            for(Point point : figureOffsets){
                //Dibuja la figura adecuada dependiendo del modo en el que se encuentra
                switch (drawType){
                    case square:
                        canvas.drawRect(point.getX()-+getResources().getDimension(R.dimen.squareHeight)/2,point.getY() - getResources().getDimension(R.dimen.squareHeight)/2,
                                point.getX()+getResources().getDimension(R.dimen.squareHeight)/2,point.getY()+getResources().getDimension(R.dimen.squareHeight)/2,paint);
                        break;
                    case rectangle:
                        canvas.drawRect(point.getX() - getResources().getDimension(R.dimen.squareHeight)/2,point.getY() - getResources().getDimension(R.dimen.rectangleHeight)/2,
                                point.getX()+getResources().getDimension(R.dimen.squareHeight)/2,point.getY()+getResources().getDimension(R.dimen.rectangleHeight)/2,paint);
                        break;
                    case circle:
                        canvas.drawCircle(point.getX(),point.getY(),getResources().getDimension(R.dimen.circleDiamenter)/2,paint);
                        break;
                    case oval:
                        canvas.drawOval(point.getX() - getResources().getDimension(R.dimen.ovalLongDiameter)/2,point.getY() - getResources().getDimension(R.dimen.ovalShortDiameter)/2,
                                point.getX()+getResources().getDimension(R.dimen.ovalLongDiameter)/2,point.getY()+getResources().getDimension(R.dimen.ovalShortDiameter)/2,paint);
                        break;

                }


            }
        }



    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        pointForPath.setX(event.getX());
        pointForPath.setY(event.getY());
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                if(drawType != DrawType.free){
                    figureOffsets.add(new Point(event.getX(), event.getY()));
                }
                else{
                    id = 1;
                }
                break;
            case MotionEvent.ACTION_MOVE:
                if(drawType == DrawType.free){
                    id = 2;
                }

        }
        invalidate();
        return true;
    }

    public enum DrawType{
        square,
        circle,
        oval,
        rectangle,
        free
    }

    public class Point{
        float x;
        float y;

        public Point(float x, float y) {
            this.x = x;
            this.y = y;
        }


        public float getX() {
            return x;
        }

        public void setX(float x) {
            this.x = x;
        }

        public float getY() {
            return y;
        }

        public void setY(float y) {
            this.y = y;
        }
    }
}
