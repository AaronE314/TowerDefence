package com.game.main.handlers;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.MapObjects;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.HexagonalTiledMapRenderer;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Disposable;
import com.game.main.objects.Tile;

import java.util.HashMap;

public class LevelLoader implements Disposable{

    private World world;
    private HexagonalTiledMapRenderer tiledMapRenderer;
    private TiledMap currentMap;

    private HashMap<Integer, String> tiles;
    private HashMap<String, Integer[][]> levels;

    private HashMap<String, Array<Body>> mapBodies;

    private Array<Tile> grid;

    public LevelLoader(World world) {
        this.world = world;
//        this.tiles = new HashMap<Integer, String>();
//        this.levels = new HashMap<String, Integer[][]>();
        this.mapBodies = new HashMap<String, Array<Body>>();
    }

    public void setMap(String name) {
        b2dWorldDestroyer(world);
        this.currentMap = new TmxMapLoader().load(name);
        b2dWorldCreator(currentMap, world);
        tiledMapRenderer = new HexagonalTiledMapRenderer(currentMap, 1/2f);
    }

    public void render(OrthographicCamera cam) {
        tiledMapRenderer.setView(cam);
        tiledMapRenderer.render();
    }

    public TiledMap getMap() {
        return currentMap;
    }

    private void b2dWorldCreator(TiledMap map, World world) {

        BodyDef bDef = new BodyDef();
        //shape of some sort
        FixtureDef fdef = new FixtureDef();
        Array<Body> bodies = new Array<Body>();



    }

    private void b2dWorldDestroyer(World world) {
        if (mapBodies != null && !mapBodies.isEmpty()) {
            for (Array<Body> bodies : mapBodies.values()) {
                for (Body body : bodies) {
                    world.destroyBody(body);
                }
            }
        }
    }

    @Override
    public void dispose() {
        b2dWorldDestroyer(world);
        currentMap.dispose();
        tiledMapRenderer.dispose();
    }
}
