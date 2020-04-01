package com.mygdx.game;

import com.mygdx.game.GameBeta;

public class MyGame extends GameBeta
{
    MainScreen mainScreen;
    SecondScreen secondScreen;
    ThridScreen thridScreen;

    @Override
    public void create()
    {
        super.create();

        mainScreen = new MainScreen();
        mainScreen.setMyGame(this);

        secondScreen = new SecondScreen();
        secondScreen.setMyGame(this);

        thridScreen = new ThridScreen();
        thridScreen.setMyGame(this);


        setActiveScreen(mainScreen);
    }
}
