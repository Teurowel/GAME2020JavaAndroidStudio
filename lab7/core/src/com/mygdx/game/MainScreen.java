package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.actions.MoveByAction;
import com.badlogic.gdx.scenes.scene2d.actions.MoveToAction;
import com.badlogic.gdx.scenes.scene2d.actions.RepeatAction;

public class MainScreen extends ScreenBeta
{
    ActorBeta background;
    ActorBeta player;

    @Override
    public void initialize()
    {
        //Background
        background = new ActorBeta(Gdx.graphics.getWidth() * 0.5f, Gdx.graphics.getHeight() * 0.5f, mainStage);
        background.loadTexture("MainBackground.jpg");
        background.setOrigin(0.f, 0.f);
        background.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        background.setPosition(background.getX() - (background.getWidth() * background.getScaleX() * 0.5f),
                             background.getY() - (background.getHeight() * background.getScaleY() * 0.5f));

        //Player
        player = new ActorBeta(Gdx.graphics.getWidth() * 0.5f, Gdx.graphics.getHeight() * 0.5f, mainStage);
        player.loadTexture("Player.png");
        player.setScale(2.f);
        player.setOrigin(0.f, 0.f);
        player.setPosition(player.getX() - (player.getWidth() * player.getScaleX() * 0.5f),
                           player.getY() - (player.getHeight() * player.getScaleY() * 0.5f));

        MoveByAction playerMoveBy;
        playerMoveBy = new MoveByAction();
        playerMoveBy.setAmount(200.f, 0.f);
        playerMoveBy.setDuration(1.f);

        RepeatAction playerRepeatAction = new RepeatAction();
        playerRepeatAction.setCount(RepeatAction.FOREVER);
        playerRepeatAction.setAction(playerMoveBy);

        player.addAction(playerRepeatAction);




    }

    @Override
    public void update(float dt)
    {
        if(player.getX() > Gdx.graphics.getWidth())
        {
            GameBeta.setActiveScreen(myGame.secondScreen);
        }
    }
}
