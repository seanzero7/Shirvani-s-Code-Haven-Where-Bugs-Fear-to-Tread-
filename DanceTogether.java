package com.actions;
import com.entities.*;
import com.entities.Character;
import com.entities.IEntity;

public class DanceTogether implements IAction{
	Character character;
	IEntity other;
	
	
	public DanceTogether(Character character, IEntity other) {
		this.character = character;
		this.other = other;
	}
	@Override
	public String getName() {
		return "DanceTogether";
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
