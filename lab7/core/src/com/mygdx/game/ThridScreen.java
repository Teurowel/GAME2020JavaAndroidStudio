package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.actions.MoveByAction;
import com.badlogic.gdx.scenes.scene2d.actions.RepeatAction;

public class ThridScreen extends ScreenBeta
{
    ActorBeta background;
    ActorBeta background2;
    ActorBeta player;
    ActorBeta player2;

    @Override
    public void initialize()
    {
        //Background
        background = new ActorBeta(Gdx.graphics.getWidth() * 0.5f, Gdx.graphics.getHeight() * 0.5f, mainStage);
        background.loadTexture("SecondBackground.jpg");
        background.setOrigin(0.5f, 0.5f);
        background.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        background.setPosition(background.getX() - (background.getWidth() * background.getScaleX() * 0.5f),
                background.getY() - (background.getHeight() * background.getScaleY() * 0.5f));

        MoveByAction backgroundMoveBy;
        backgroundMoveBy = new MoveByAction();
        backgroundMoveBy.setAmount(0.f, -100.f);
        backgroundMoveBy.setDuration(1.f);

        RepeatAction backgroundRepeatAction = new RepeatAction();
        backgroundRepeatAction.setCount(RepeatAction.FOREVER);
        backgroundRepeatAction.setAction(backgroundMoveBy);

        background.addAction(backgroundRepeatAction);



        //Background2
        background2 = new ActorBeta(0.f, 0.f, mainStage);
        background2.loadTexture("SecondBackground.jpg");
        background2.setOrigin(0.5f, 0.5f);
        background2.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        background2.setPosition(0.f, Gdx.graphics.getHeight());

        MoveByAction background2MoveBy;
        background2MoveBy = new MoveByAction();
        background2MoveBy.setAmount(0.f, -100.f);
        background2MoveBy.setDuration(1.f);

        RepeatAction background2RepeatAction = new RepeatAction();
        background2RepeatAction.setCount(RepeatAction.FOREVER);
        background2RepeatAction.setAction(background2MoveBy);

        background2.addAction(background2RepeatAction);


        //Player1
        player = new ActorBeta(Gdx.graphics.getWidth() * 0.5f, Gdx.graphics.getHeight(), mainStage);
        player.loadTexture("Player.png");
        player.setScale(2.f);
        player.setOrigin(0.f, 0.f);
        player.setPosition(Gdx.graphics.getWidth() * 0.5f, Gdx.graphics.getHeight() - (player.getHeight() * player.getScaleY() * 0.5f));
        player.setPosition(player.getX() - (player.getWidth() * player.getScaleX() * 0.5f),
                player.getY() - (player.getHeight() * player.getScaleY() * 0.5f));
        player.setBoundaryPolygon(4);

        MoveByAction playerMoveBy;
        playerMoveBy = new MoveByAction();
        playerMoveBy.setAmount(0.f, -200.f);
        playerMoveBy.setDuration(1.f);

        RepeatAction playerRepeatAction = new RepeatAction();
        playerRepeatAction.setCount(RepeatAction.FOREVER);
        playerRepeatAction.setAction(playerMoveBy);

        player.addAction(playerRepeatAction);

        //Player2
        player2 = new ActorBeta(0.f, 0.f, mainStage);
        player2.loadTexture("Player2.png");
        player2.setScale(2.f);
        player2.setOrigin(0.f, 0.f);
        player2.setPosition(0 + (player2.getWidth() * player2.getScaleX() * 0.5f), Gdx.graphics.getHeight() * 0.5f);
        player2.setPosition(player2.getX() - (player2.getWidth() * player2.getScaleX() * 0.5f),
                player2.getY() - (player2.getHeight() * player2.getScaleY() * 0.5f));
        player2.setBoundaryPolygon(4);

        MoveByAction player2MoveBy;
        player2MoveBy = new MoveByAction();
        player2MoveBy.setAmount(200.f, 0.f);
        player2MoveBy.setDuration(1.f);

        RepeatAction player2RepeatAction = new RepeatAction();
        player2RepeatAction.setCount(RepeatAction.FOREVER);
        player2RepeatAction.setAction(player2MoveBy);

        player2.addAction(player2RepeatAction);
    }

    @Override
    public void update(float dt)
    {
        if(background.getY() + (background.getHeight() * background.getScaleY()) < 0.f)
        {
            background.setY(Gdx.graphics.getHeight());
        }

        if(background2.getY() + (background2.getHeight() * background2.getScaleY()) < 0.f)
        {
            background2.setY(Gdx.graphics.getHeight());
        }

        if(player.overlaps(player2))
        {
            player.addAction(Actions.removeActor());
            player2.addAction(Actions.removeActor());
        }
    }
}
