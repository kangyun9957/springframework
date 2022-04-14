package com.mycompany.webapp.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.mycompany.webapp.dto.Ch04Member;

import lombok.extern.log4j.Log4j2;
@Log4j2
public class Ch04MemberLoginFormValidator implements Validator {
	
	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		boolean result=Ch04Member.class.isAssignableFrom(clazz);
		return result;
		
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		Ch04Member member=(Ch04Member) target;
		//mid검사
		if(member.getMid()==null || member.getMid().trim().equals("")) {
			errors.rejectValue("mid","errors.mid.required","mid는 필수 입력 사항입니다.");//중간 위치 Spring이 browser언어 해석해서 나타내줌
		}else {
			if(member.getMid().length()<4) {
				errors.rejectValue("mid","errors.mid.minlength",new Object[] {4},"mid는 최소 4자 이상입니다.");
			}
		}
		
		//mpassword 검사
		if(member.getMid()==null || member.getMpassword().trim().equals("")) {
			errors.rejectValue("mpassword","errors.password.required","mpassword는 필수 입력 사항입니다.");
		}else {
			if(member.getMid().length()<8) {
				errors.rejectValue("mpassword",null,"mpassword는 최소 8자 이상입니다.");
			}
		}
		
	}

}
