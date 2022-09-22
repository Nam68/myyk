package myyk.backend.logic;

import org.springframework.beans.factory.annotation.Autowired;

import myyk.backend.repository.RepositoryManager;
import myyk.util.BaseApp;
import myyk.util.exception.SystemException;

public class BaseLogic extends BaseApp {
	
	@Autowired
	private RepositoryManager repositoryManager;
	
	protected RepositoryManager getRepositoryManager() {
		return repositoryManager;
	}
		
}
