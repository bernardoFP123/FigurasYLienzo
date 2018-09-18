package misiont.mision4.Models;

import misiont.mision4.Views.Lienzo;

/**
 * Created by Bernardo_NoAdmin on 04/02/2018.
 */

public class FigureOptionModel {

    int figureDrawableResource;
    String figureName;
    String figureDescription ;
    Lienzo.DrawType drawType;

    public FigureOptionModel(int figureDrawableResource, String figureName, String figureDescription, Lienzo.DrawType drawType) {
        this.figureDrawableResource = figureDrawableResource;
        this.figureName = figureName;
        this.drawType = drawType;
        this.figureDescription = figureDescription;

    }

    public int getFigureDrawableResource() {
        return figureDrawableResource;
    }

    public void setFigureDrawableResource(int figureDrawableResource) {
        this.figureDrawableResource = figureDrawableResource;
    }

    public String getFigureName() {
        return figureName;
    }



    public String getFigureDescription() {
        return figureDescription;
    }


    public Lienzo.DrawType getDrawType() {
        return drawType;
    }

}
