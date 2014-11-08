package com.cal.codeday;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.cal.codeday.entity.Entity;

/**
 * Created by acohen on 11/8/14.
 * The sidebar in-game (Purchase towers, etc.) (Could be called player class, idk)
 */
public class GameMenu {

    int cash = 0;
    MenuState state = MenuState.Default;

    public void draw(SpriteBatch batch){

    }

    private enum MenuState{
        Default,
        ViewTower,
        ViewTowerPurchase
    }

}
