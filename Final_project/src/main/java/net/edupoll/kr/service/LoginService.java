package net.edupoll.kr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import net.edupoll.kr.entity.AccountVo;
import net.edupoll.kr.repository.AccountDao;

@Service
public class LoginService {

	
	
	
	@Autowired
	AccountDao loginDao;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	
	public boolean selectOne(String id, String loginPass) {
		
		
			String rst = loginDao.selectOne(id);
		
		
		if(rst == null)
			return false;
		
		
		return passwordEncoder.matches(loginPass, rst);
		
		
	}
	
	public AccountVo findAccountById(String id) {
		
		
		return loginDao.selectAll(id);
		
	}
	
	
	
	public int updateAccountById(AccountVo vo) {
			
		
		return loginDao.updateEmail(vo);
	}
	
	public String selectEmail(String id) {
		
		return loginDao.selectEmail(id);
		
	}
	
	public int updateauth(String id) {
		
		return loginDao.updateauth(id);
	}
	
	
	
	
	
	
	
}

