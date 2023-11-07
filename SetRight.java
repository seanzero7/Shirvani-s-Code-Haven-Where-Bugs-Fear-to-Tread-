package com.actions;
import com.entities.*;
import com.entities.Character;
import com.actions.IAction;

public class SetRight implements IAction {
	Character character;
	
	public SetRight (Character character) {
		this.character = character;
	}
	@Override
	public String getName() {
		return "SetRight";
	}

	@Override
	public boolean getShouldWait() {
		return true;
	}
	public String toString() {
		return String.format("%s(%s)",getName(),character.getName());

	}
}
