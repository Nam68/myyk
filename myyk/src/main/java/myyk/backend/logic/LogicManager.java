package myyk.backend.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import myyk.backend.service.MemberService;

@Component
@Scope(scopeName = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class LogicManager {
	
	@Autowired
	private MemberService memberSerivce;
		
	public MemberService getMemberService() {
		return memberSerivce;
	}
}
