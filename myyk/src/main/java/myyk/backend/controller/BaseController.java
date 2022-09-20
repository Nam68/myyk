package myyk.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;

import myyk.backend.logic.LogicManager;
import myyk.util.BaseApp;

public class BaseController extends BaseApp {

	@Autowired
	private LogicManager logicManager;
	
	protected LogicManager getLogicManager() {
		return logicManager;
	}
	
	public static final String MESSAGES = "messages";
	
	public static final String ENUMS = "enums";
	
	public static final String ENUM_NAME = "name";
	
	public static final String ENUM_VALUE = "value";
		
}
