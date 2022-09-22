package myyk.backend.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(scopeName = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class RepositoryManager {
	
	@Autowired
	private MemberRepository memberRepository;
	
	@Autowired
	private TmpMemberRepository tmpMemberRepository;
	
	public MemberRepository getMemberRepository() {
		return memberRepository;
	}
	
	public TmpMemberRepository getTmpMemberRepository() {
		return tmpMemberRepository;
	}
	
}
