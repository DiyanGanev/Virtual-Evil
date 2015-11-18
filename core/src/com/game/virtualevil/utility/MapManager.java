package com.game.virtualevil.utility;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.game.virtualevil.Game;
import com.game.virtualevil.entity.GameCharacter.Direction;
import com.game.virtualevil.entity.PlayerCharacter;

public class MapManager {
	
	// contains the different maps in the game
	private Map[][] maps;
	private Game game;
	private PlayerCharacter player;
	/* the place in the world (and in the maps array)
	 * of the current map */
	private int mapsCollumn = 1, mapsRow = 1;
	
	private final int COLUMNS_OF_MAPS = 3;
	private final int ROWS_OF_MAPS = 3;
	private final int HORIZONTAL_MAP_BORDER = 300;
	private final int VERTICAL_MAP_BORDER = 200;
	
	// the amount by which the player is moved when changing maps
	private final int MAP_SWITCH_DISPLACEMENT = 20;
	
	
	public MapManager(Game game) {
		this.game = game;
		player = game.getEntityManager().getPlayer();
		// instantiate the array of maps
		maps = new Map[COLUMNS_OF_MAPS][ROWS_OF_MAPS];
		// load all the maps and put them in the maps array
		for (int i = 0; i < COLUMNS_OF_MAPS; i++) {
			for (int j = 0; j < ROWS_OF_MAPS; j++) {
				String mapName = "map" + 'C' + i + 'R' + j;
				maps[j][i] = new Map(game, mapName);
			}
		}
	}
	
	public void checkPlayerAgainstMapBoundaries() {
		Rectangle playerCollisionRect
			= player.getCollisionRectangle();
		
		if (playerCollisionRect.x < HORIZONTAL_MAP_BORDER) {
			mapsCollumn--;
			player.setX(getCurrentMap().getTotalWidth()
					- HORIZONTAL_MAP_BORDER - MAP_SWITCH_DISPLACEMENT);
		} else if (playerCollisionRect.x > getCurrentMap().getTotalWidth()
				- HORIZONTAL_MAP_BORDER) {
			mapsCollumn++;
			player.setX(HORIZONTAL_MAP_BORDER + MAP_SWITCH_DISPLACEMENT);
		}
	}
	
	public void drawMap(SpriteBatch batch, OrthographicCamera camera) {
		maps[mapsRow][mapsCollumn].drawMap(batch, camera.position);
	}
	
	/* TODO:
	 * - method for requesting a reload of the entities in the entity manager;
	 * - refresh projectiles collection;
	 * - map: render the 2nd part of multi-part game objects
	 * (go only trough the tiles on the screen; do not save them in a collection);
	 * - going right sends the player to the map on the right: map names
	 * define their place in the world as 'mapC2R1' -  column 2 row 1 (load
	 * at game start);
	 * - remove magic value 12 - rendering distance;
	 */
	
	
	public Map getCurrentMap() {
		return maps[mapsRow][mapsCollumn];
	}

	public Game getGame() {
		return game;
	}
}
