package com.ericc.the.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import java.util.ArrayList;

public class Media {
    public static TextureRegion dunVoid;
    public static ArrayList<TextureRegion> floors, wallUp, wallDown, wallLeft, wallRight, floorsRev;
    public static TextureRegion wallLU, wallRU, wallLD, wallRD;
    public static TextureRegion playerFront, playerLeft, playerRight, playerBack;
    public static TextureRegion mobFront, mobLeft, mobRight, mobBack;
    public static TextureAtlas atlas;
    public static int floorsConfiguration;

    static {
        floors = new ArrayList<>();
        floorsRev = new ArrayList<>();
        wallUp = new ArrayList<>();
        wallDown = new ArrayList<>();
        wallLeft = new ArrayList<>();
        wallRight = new ArrayList<>();
        floorsConfiguration = 0;
    }

    public static void loadAssets() {
        atlas = new TextureAtlas(Gdx.files.internal("pack.atlas"));

        dunVoid = atlas.findRegion("map/void");

        floors.add(atlas.findRegion("map/floors/floor1"));
        floors.add(atlas.findRegion("map/floors/floor2"));
        floors.add(atlas.findRegion("map/floors/floor3"));
        floors.add(atlas.findRegion("map/floors/floor4"));
        floors.add(atlas.findRegion("map/floors/floor5"));
        floors.add(atlas.findRegion("map/floors/floor6"));
        floorsRev.add(atlas.findRegion("map/floors/floor1_reversed")); // for now lets stick with only one reversed texture

        wallUp.add(atlas.findRegion("map/walls/wall1_up"));
        wallUp.add(atlas.findRegion("map/walls/wall2_up"));
        wallUp.add(atlas.findRegion("map/walls/wall3_up"));
        wallUp.add(atlas.findRegion("map/walls/wall4_up"));

        wallDown.add(atlas.findRegion("map/walls/wall1_down"));
        wallDown.add(atlas.findRegion("map/walls/wall2_down"));

        wallLeft.add(atlas.findRegion("map/walls/wall1_left"));
        wallLeft.add(atlas.findRegion("map/walls/wall2_left"));
        wallLeft.add(atlas.findRegion("map/walls/wall3_left"));

        wallRight.add(atlas.findRegion("map/walls/wall1_right"));
        wallRight.add(atlas.findRegion("map/walls/wall2_right"));
        wallRight.add(atlas.findRegion("map/walls/wall3_right"));

        wallLD = atlas.findRegion("map/walls/wall1_corner_left_down");
        wallRD = atlas.findRegion("map/walls/wall1_corner_right_down");
        wallLU = atlas.findRegion("map/walls/wall1_corner_left_up");
        wallRU = atlas.findRegion("map/walls/wall1_corner_right_up");

        playerFront = atlas.findRegion("entity/hero/hero_front");
        playerBack = atlas.findRegion("entity/hero/hero_back");
        playerLeft = atlas.findRegion("entity/hero/hero_left");
        playerRight = atlas.findRegion("entity/hero/hero_right");

        mobFront = atlas.findRegion("entity/mage/mage_front");
        mobBack = atlas.findRegion("entity/mage/mage_back");
        mobLeft = atlas.findRegion("entity/mage/mage_left");
        mobRight = atlas.findRegion("entity/mage/mage_right");
    }

    public static void dispose() {
        atlas.dispose();
    }

    public static TextureRegion getRandomFloorTile(int x, int y, int index) {
        if (floorsConfiguration == 0) {
            return ((x + y) % 2 == 0) ? floors.get(index) : floorsRev.get(0);
        } else {
            return ((x + y) % 2 == 0) ? floorsRev.get(0) : floors.get(index);
        }
    }
}