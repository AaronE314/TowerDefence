package com.game.main.objects;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;

public class Tile {

    private Vector2 pos;

    private Array<Tile> neighbors;

    private boolean path;
    private Tile prev;
    private int type;

    public Tile(Vector2 pos, int type) {
        this.pos = pos;
        this.type = type;
        this.neighbors = new Array<Tile>();
    }

    public void setNeighbors() {

    }

}
