package com.actions;
import com.actions.IAction;
import com.entities.*;
import com.entities.Character;

public class SetLeft implements IAction {
	Character character;
	
	public SetLeft(Character character) {
		this.character = character;
	}
	
	@Override
	public String getName() {
		return "SetLeft";
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
