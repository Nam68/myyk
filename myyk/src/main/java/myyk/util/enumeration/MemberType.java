package myyk.util.enumeration;

/**
 * <p>회원 타입에 대한 이넘.</p>
 */
public enum MemberType {
	
	/**
	 * <p>임시회원(미승인)</p>
	 */
	TMP_MEMBER,
	
	/**
	 * <p>정회원(승인완료)</p>
	 */
	MEMBER,
	
	/**
	 * <p>관리자</p>
	 */
	ADMIN,
	
	/**
	 * <p>삭제된 회원</p>
	 */
	WITHDRAW,
	
	/**
	 * <p>강퇴된 회원</p>
	 */
	BANNED,
	
	;
	
}
