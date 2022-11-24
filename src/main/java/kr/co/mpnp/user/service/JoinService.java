package kr.co.mpnp.user.service;

import org.json.simple.JSONObject;


import kr.co.mpnp.user.dao.MemberDAO;
import kr.co.mpnp.user.vo.MemberVO;


public class  JoinService {
	
	//�����-�ߺ�Ȯ��
	public String searchDupChk(String id) {
		
		MemberDAO mDAO=MemberDAO.getInstance();
		boolean dupChkFlag=mDAO.selectDupChk(id);
		
		JSONObject jsonFlag=new JSONObject();
		jsonFlag.put("dupChkFlag", dupChkFlag);
		
		return jsonFlag.toJSONString();
	}
	
	
	//�����-ȸ������
	public int addMember(MemberVO mVO) {
		int cnt=0;
		
		MemberDAO mDAO=MemberDAO.getInstance();
		cnt=mDAO.insertMember(mVO);
		
		return cnt;
	}
	
	
}
