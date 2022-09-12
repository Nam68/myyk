package myyk.backend.service;

import myyk.backend.dto.member.CreateMemberInputDto;
import myyk.util.enumeration.Result;
import myyk.util.exception.SystemException;

public interface MemberService {

	Result create(CreateMemberInputDto memberDto) throws SystemException;
	
}
