package com.actions;
import com.entities.*;
public class SetNarration implements IAction {
	String narration;
	
	
	public SetNarration (String narration) {
		this.narration = narration;
	}
	@Override
	public String getName() {
		return "SetNarration";
	}

	@Override
	public boolean getShouldWait() {
				return true;
	}
	@Override 
	public String toString() {
		return String.format("%s(%s)",getName(), narration);
	}
}
