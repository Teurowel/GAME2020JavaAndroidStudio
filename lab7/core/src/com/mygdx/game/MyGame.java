package com.mygdx.game;

import com.mygdx.game.GameBeta;

public class MyGame extends GameBeta
{
    MainScreen mainScreen;
    SecondScreen secondScreen;

    @Override
    public void create()
    {
        super.create();

        mainScreen = new MainScreen();
        mainScreen.setMyGame(this);
        secondScreen = new SecondScreen();
        secondScreen.setMyGame(this);

        setActiveScreen(mainScreen);
    }
}
