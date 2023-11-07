package com.actions;
import com.entities.*;
import com.entities.Character;
public class Face implements IAction {
	Character character;
	IEntity other;
	
	public Face(Character character, IEntity other) {
		this.character = character;
		this.other = other;
	}
	@Override
	public String getName() {	
		return "Face";
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
