package com.game.virtualevil.utility;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.game.virtualevil.utility.asset.TextureManager;

public class UserInterface {
	
	private TextureRegion healthAndEnergyInterface, piston, pistonArm, healthBar, energyBar;
	public UserInterface (TextureManager tm){
		healthAndEnergyInterface = new TextureRegion(tm.getImage("HPETileSet"),
				0, 0, 384, 191);
		healthBar = new TextureRegion(tm.getImage("HPETileSet"),
				0, 281, 3, 39 );
		piston = new TextureRegion(tm.getImage("HPETileSet"),
				0, 217, 29, 39);
		pistonArm = new TextureRegion(tm.getImage("HPETileSet"),
				0, 265, 3, 7);
		energyBar = new TextureRegion(tm.getImage("HPETileSet"),
				0, 329, 294, 78);
	}
	

	
	

	public TextureRegion getHealthAndEnergyInterface() {
		return healthAndEnergyInterface;
	}

	public TextureRegion getPiston() {
		return piston;
	}

	public TextureRegion getPistonArm() {
		return pistonArm;
	}

	public TextureRegion getHealthBar() {
		return healthBar;
	}

	public TextureRegion getEnergyBar(int current, int max) {
		if(current<0){
			current = 0;
		}
		if(current > max){
			current =max;
		}
		return new TextureRegion(energyBar,
				0, 0, (int) (294*((double)current/max)), 78);
	}
	
}
