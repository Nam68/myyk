package myyk.backend.service;

import myyk.backend.dto.member.CreateMemberDto;
import myyk.util.enumeration.Region;
import myyk.util.enumeration.Result;
import myyk.util.exception.SystemException;

public interface MemberService {

	Result create(CreateMemberDto dto) throws SystemException;
	
	Result checkEmail(CreateMemberDto dto, Region region) throws SystemException;
	
}
