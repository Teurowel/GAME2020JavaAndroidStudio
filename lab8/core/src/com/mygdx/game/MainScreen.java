package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.actions.MoveByAction;
import com.badlogic.gdx.scenes.scene2d.actions.MoveToAction;
import com.badlogic.gdx.scenes.scene2d.actions.RepeatAction;

public class MainScreen extends ScreenBeta
{
    ActorBeta background;
    ActorBeta background2;
    ActorBeta idleActor;
    ActorBeta walkActor;
    ActorBeta attackActor;

    @Override
    public void initialize()
    {
        //Background////////////////////////////////////////////////////////////////////////////////////////////////////////////
        background = new ActorBeta(Gdx.graphics.getWidth() * 0.5f, Gdx.graphics.getHeight() * 0.5f, mainStage);
        background.loadTexture("horizontalBack.png");
        background.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        background.setPosition(0.f, 0.f);

        MoveByAction backgroundMoveBy;
        backgroundMoveBy = new MoveByAction();
        backgroundMoveBy.setAmount(-200.f, 0.f);
        backgroundMoveBy.setDuration(1.f);

        RepeatAction backgroundRepeatAction = new RepeatAction();
        backgroundRepeatAction.setCount(RepeatAction.FOREVER);
        backgroundRepeatAction.setAction(backgroundMoveBy);

        background.addAction(backgroundRepeatAction);
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////


        //Background2////////////////////////////////////////////////////////////////////////////////////////////////////////////
        background2 = new ActorBeta(Gdx.graphics.getWidth() * 0.5f, Gdx.graphics.getHeight() * 0.5f, mainStage);
        background2.loadTexture("horizontalBack.png");
        background2.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        background2.setPosition(Gdx.graphics.getWidth(), 0.f);

        MoveByAction background2MoveBy;
        background2MoveBy = new MoveByAction();
        background2MoveBy.setAmount(-200.f, 0.f);
        background2MoveBy.setDuration(1.f);

        RepeatAction background2RepeatAction = new RepeatAction();
        background2RepeatAction.setCount(RepeatAction.FOREVER);
        background2RepeatAction.setAction(background2MoveBy);

        background2.addAction(background2RepeatAction);
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////


        //Initialize idle actor////////////////////////////////////////////////////////////////////////////////////////////////////////////
        idleActor = new ActorBeta(Gdx.graphics.getWidth() * 0.5f, Gdx.graphics.getHeight() * 0.5f, mainStage);

        //create array of image path
        String[] idleString = {"idle/tile000.png", "idle/tile001.png", "idle/tile002.png", "idle/tile003.png", "idle/tile004.png"};

        //Load the array of images inside an animation object
        Animation<TextureRegion> idleAnim = idleActor.loadAnimationFromFiles(idleString, 0.1f, true);
        //set animation to idle
        idleActor.setAnimation(idleAnim);
        idleActor.setOrigin(0.f, 0.f);
        idleActor.setScale(5.f);
        idleActor.setPosition(200, Gdx.graphics.getHeight() - 400);

        MoveByAction idleActorMoveBy;
        idleActorMoveBy = new MoveByAction();
        idleActorMoveBy.setAmount(250.f, 0.f);
        idleActorMoveBy.setDuration(1.f);

        RepeatAction idleActorRepeatAction = new RepeatAction();
        idleActorRepeatAction.setCount(RepeatAction.FOREVER);
        idleActorRepeatAction.setAction(idleActorMoveBy);

        idleActor.addAction(idleActorRepeatAction);
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////


        //Initialize walk actor////////////////////////////////////////////////////////////////////////////////////////////////////////////
        walkActor = new ActorBeta(Gdx.graphics.getWidth() * 0.5f, Gdx.graphics.getHeight() * 0.5f, mainStage);

        //create array of image path
        String[] walkString = {"walk/tile000.png", "walk/tile001.png", "walk/tile002.png", "walk/tile003.png", "walk/tile004.png", "walk/tile005.png", "walk/tile006.png", "walk/tile007.png", "walk/tile008.png"};

        //Load the array of images inside an animation object
        Animation<TextureRegion> walkAnim = walkActor.loadAnimationFromFiles(walkString, 0.1f, true);
        //set animation to idle
        walkActor.setAnimation(walkAnim);
        walkActor.setOrigin(0.f, 0.f);
        walkActor.setScale(5.f);
        walkActor.setPosition(200, Gdx.graphics.getHeight() - 1000);

        MoveByAction walkActorMoveBy;
        walkActorMoveBy = new MoveByAction();
        walkActorMoveBy.setAmount(250.f, 0.f);
        walkActorMoveBy.setDuration(1.f);

        RepeatAction walkActorRepeatAction = new RepeatAction();
        walkActorRepeatAction.setCount(RepeatAction.FOREVER);
        walkActorRepeatAction.setAction(walkActorMoveBy);

        walkActor.addAction(walkActorRepeatAction);
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////


        //Initialize walk actor////////////////////////////////////////////////////////////////////////////////////////////////////////////
        attackActor = new ActorBeta(Gdx.graphics.getWidth() * 0.5f, Gdx.graphics.getHeight() * 0.5f, mainStage);

        //create array of image path
        String[] attackString = {"attack/attack_0.png","attack/attack_1.png","attack/attack_2.png","attack/attack_3.png","attack/attack_4.png","attack/attack_5.png","attack/attack_6.png","attack/attack_7.png",
                "attack/attack_8.png","attack/attack_9.png","attack/attack_10.png","attack/attack_11.png"};

        //Load the array of images inside an animation object
        Animation<TextureRegion> attackAnim = attackActor.loadAnimationFromFiles(attackString, 0.1f, true);
        //set animation to idle
        attackActor.setAnimation(attackAnim);
        attackActor.setOrigin(0.f, 0.f);
        attackActor.setScale(5.f);
        attackActor.setPosition(200, Gdx.graphics.getHeight() - 1600);

        MoveByAction attackActorMoveBy;
        attackActorMoveBy = new MoveByAction();
        attackActorMoveBy.setAmount(250.f, 0.f);
        attackActorMoveBy.setDuration(1.f);

        RepeatAction attackActorRepeatAction = new RepeatAction();
        attackActorRepeatAction.setCount(RepeatAction.FOREVER);
        attackActorRepeatAction.setAction(attackActorMoveBy);

        attackActor.addAction(attackActorRepeatAction);
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////
    }

    @Override
    public void update(float dt)
    {
        //Reset background position
        if(background.getX() < -background.getWidth())
        {
            background.setX(Gdx.graphics.getWidth());
        }

        if(background2.getX() < -background2.getWidth())
        {
            background2.setX(Gdx.graphics.getWidth());
        }

        if(idleActor.getX() > Gdx.graphics.getWidth())
        {
            GameBeta.setActiveScreen(myGame.secondScreen);
        }
    }
}
