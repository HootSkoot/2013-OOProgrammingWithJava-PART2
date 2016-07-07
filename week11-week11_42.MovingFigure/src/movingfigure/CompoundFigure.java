/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movingfigure;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Michael
 */
public class CompoundFigure extends Figure{
    private List<Figure> figureList;

    public CompoundFigure() {
        super(0, 0);
        figureList = new ArrayList<Figure>();
    }
    
    public void add(Figure f){
        figureList.add(f);
    }

    @Override
    public void move(int dx, int dy) {
        for (Figure figure : figureList) {
            figure.move(dx, dy);
        }
    }
    
    @Override
    public void draw(Graphics graphics) {
        for (Figure figure : figureList) {
            figure.draw(graphics);
        }
    }
    
}
