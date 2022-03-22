package net.edupoll.kr.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import net.edupoll.kr.entity.AccountVo;
import net.edupoll.kr.repository.SignUpDao;

@Service
public class SignupService {

		@Autowired
		PasswordEncoder passwordEncoder;
		
		@Autowired
		SignUpDao signUpDao;
	
		public int registerAccount(AccountVo vo) {
			
			String pass = vo.getUserPass();
			String encodedPass = passwordEncoder.encode(pass);
			
			System.out.println("pass = " + pass );
			System.out.println("encodedPass = " + encodedPass );
			
			vo.setUserPass(encodedPass);
			
			return signUpDao.insertAll(vo);
			
			
		}
}
