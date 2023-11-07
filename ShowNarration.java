package com.actions;
import com.entities.*;

public class ShowNarration implements IAction {

	@Override
	public String getName() {
		return "ShowNarration";
	}
	@Override
	public boolean getShouldWait() {
		return true;
	}
	@Override
	public String toString() {
		return String.format("%s()",getName());
		
	}

}
