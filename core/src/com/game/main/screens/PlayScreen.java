package com.game.main.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.game.main.TDMain;
import com.game.main.handlers.LevelLoader;
import com.game.main.world.B2DWorldContactListener;

import static com.game.main.Constants.HEIGHT;
import static com.game.main.Constants.V_HEIGHT;
import static com.game.main.Constants.V_WIDTH;
import static com.game.main.Constants.WIDTH;


public class PlayScreen extends ScreenAdapter {

    private final TDMain game;
    private final SpriteBatch batch;

    private OrthographicCamera cam;
    private FitViewport viewport;

    private World world;
    private Box2DDebugRenderer b2ddr;
    private boolean showB2ddr;

    private LevelLoader levelLoader;



    public PlayScreen(TDMain game) {
        this.game = game;
        this.batch = game.getBatch();

        showB2ddr = true;
    }

    @Override
    public void show() {

        //Camera
        cam = new OrthographicCamera();
        viewport = new FitViewport(V_WIDTH, V_HEIGHT, cam);
        cam.position.set(V_WIDTH / 2, V_HEIGHT / 2, 0);

        //B2D
        world = new World(new Vector2(), true);
        world.setContactListener(new B2DWorldContactListener());
        b2ddr = new Box2DDebugRenderer();

        levelLoader = new LevelLoader(world);

        levelLoader.setMap("level1.tmx");

    }

    public void update(float dt) {

        world.step(dt, 6, 2);
    }

    @Override
    public void render(float dt) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        update(dt);

        levelLoader.render(cam);

        b2ddr.render(world, cam.combined);

    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height);
    }

    @Override
    public void dispose() {
        super.dispose();
    }
}
