package com.actions;
import com.actions.IAction;

import com.entities.Character;

public class Clap implements IAction {
	Character character;
	
	public Clap(Character character) {
		this.character = character;
	}
	@Override
	public String getName() {
		return "Clap";
	}

	@Override
	public boolean getShouldWait() {
		return true;
	}
	@Override
	public String toString() {
		return String.format("%s(%s)",getName(),character.getName());
	}

}
