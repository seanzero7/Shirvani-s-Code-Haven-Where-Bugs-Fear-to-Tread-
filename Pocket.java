package com.actions;
import com.entities.*;
import com.entities.Character;
public class Pocket implements IAction {
	Character character;
	IEntity other;
	
	public Pocket(Character character, IEntity other) {
		this.character = character;
		this.other = other;
	}
	
	@Override
	public String getName() {
		return "Pocket";
	}

	@Override
	public boolean getShouldWait() {
		return true;
	}
	@Override
	public String toString() {
		return String.format("%s(%s,%s)",getName(),character.getName(),other.getName());
	}
}
