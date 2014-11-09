package com.cal.codeday;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

/**
 * Created by acohen on 11/9/14.
 */
public class Button {

    public float x, y;

    Texture[] tex = new Texture[3];
    ButtonState state = ButtonState.BUTTON_DEFAULT;
    Rectangle bounds;

    public Button(String texPath, boolean isMultiState, float x, float y, float width, float height){
        if(isMultiState) {
            tex[0] = new Texture(Gdx.files.internal(texPath + "01.png")); //Default texture
            tex[1] = new Texture(Gdx.files.internal(texPath + "02.png")); //Hover texture
            tex[2] = new Texture(Gdx.files.internal(texPath + "03.png")); //Down texture
        }else{
            tex[0] = new Texture(Gdx.files.internal(texPath));
            tex[1] = tex[0];
            tex[2] = tex[0];
        }
        bounds = new Rectangle(x, y, width, height);
    }

    public void move(float x, float y){
        this.x = x;
        this.y = y;
        bounds.setX(x);
        bounds.setY(y);
    }

    public boolean isOver(float x, float y){
        if(bounds.contains(x, y)) {
            state = ButtonState.BUTTON_HOVER;
            return true;
        }else{
            state = ButtonState.BUTTON_DEFAULT;
            return false;
        }
    }

    public boolean click(float x, float y){
        if(isOver(x, y) && Gdx.input.isTouched()){
            state = ButtonState.BUTTON_CLICK;
            return true;
        }else{
            return false;
        }
    }

    public void draw(SpriteBatch batch){
        batch.draw(tex[state.value], bounds.getX(), bounds.getY(), bounds.getWidth(), bounds.getHeight());
    }

    enum ButtonState{
        BUTTON_DEFAULT(0),
        BUTTON_HOVER(1),
        BUTTON_CLICK(2);

        public final int value;

        private ButtonState(int v){
            value = v;
        }
    }

}
