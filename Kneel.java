package com.actions;
import com.entities.Character;
public class Kneel implements IAction {
	Character character;
	
	public Kneel (Character character) {
		this.character = character;
	}
	@Override
	public String getName() {
		return "Kneel";
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
