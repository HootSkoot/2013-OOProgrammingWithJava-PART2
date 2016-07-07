/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boxes;

import java.util.List;

/**
 *
 * @author Michael
 */
public class OneThingBox extends Box{
    private Thing things;

    public OneThingBox() {
        things = null;
    }

    @Override
    public void add(Thing thing) {
        if ( things == null) {
            things = thing;
        }
    }

    @Override
    public boolean isInTheBox(Thing thing) {
        if ( things == null) {
            return false;
        }
        return things.equals(thing);
    }
    
    
}
