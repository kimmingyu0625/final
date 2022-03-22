package net.edupoll.kr.entity.validator;


import org.springframework.validation.Errors;

import net.edupoll.kr.entity.AccountVo;

public class AccountValidator implements org.springframework.validation.Validator{

	@Override
	public boolean supports(Class<?> clazz) {

		
		return	AccountVo.class.isAssignableFrom(clazz);
		
		
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		AccountVo vo = (AccountVo) target;
		
		
		if(vo.getUserId().length() <3) {
			
			errors.rejectValue("userId", "length");
		}
		if(!vo.getUserName().matches("[가-힁]{2,5}")) {
			errors.rejectValue("userName", "invalid");
			
			
			
		}
		
	}

	
	
}
