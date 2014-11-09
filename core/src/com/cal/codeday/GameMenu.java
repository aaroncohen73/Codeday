package com.cal.codeday;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.cal.codeday.entity.Entity;

/**
 * Created by acohen on 11/8/14.
 * The sidebar in-game (Purchase towers, etc.) (Could be called player class, idk)
 */

public class GameMenu {

    int cash = 0;
    Texture menuBackground;
    MenuState state = MenuState.Default;

    public GameMenu(){
        menuBackground = new Texture(Gdx.files.internal("gfx/menu_background.png"));
    }

    public void draw(SpriteBatch batch){
    batch.draw(menuBackground, 800,0);
    }

    private enum MenuState{
        Default,
        ViewTower,
        ViewTowerPurchase
    }

}
