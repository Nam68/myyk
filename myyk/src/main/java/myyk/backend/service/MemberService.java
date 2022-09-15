package myyk.backend.service;

import myyk.backend.dto.member.CreateMemberDto;
import myyk.util.enumeration.Result;
import myyk.util.exception.SystemException;

public interface MemberService {

	Result create(CreateMemberDto memberDto) throws SystemException;
	
}
