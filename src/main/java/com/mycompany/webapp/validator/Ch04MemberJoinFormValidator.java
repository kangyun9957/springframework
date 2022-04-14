package com.mycompany.webapp.validator;

import java.util.regex.Matcher;

import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.mycompany.webapp.dto.Ch04Member;

import lombok.extern.log4j.Log4j2;
@Log4j2
public class Ch04MemberJoinFormValidator implements Validator{
	//유효성 검사가 가능한 객체인지를 조사
	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		log.info("실행");
		//다형성 , 해당 객체거나 해당 객체의 자식관계면 다 대입이 가능
		//Ch04와 전혀 관계없는 클래스면 유효성 검사 불가능
		boolean result=Ch04Member.class.isAssignableFrom(clazz);
		return result;
	}
	//supports가 True일경우 실행
	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		log.info("실행");
		Ch04Member member=(Ch04Member) target;
		//mid검사
		if(member.getMid()==null || member.getMid().trim().equals("")) {
			errors.rejectValue("mid","errors.mid.required","mid는 필수 입력 사항입니다.");
		}else {
			if(member.getMid().length()<4) {
				errors.rejectValue("mid","errors.mid.minlength",new Object[] {4},"mid는 최소 4자 이상입니다.");
			}
		}
		
		//mpassword 검사
		if(member.getMid()==null || member.getMpassword().trim().equals("")) {
			errors.rejectValue("mpassword","errors.mpassword.required","mpassword는 필수 입력 사항입니다.");
		}else {
			if(member.getMid().length()<8) {
				errors.rejectValue("mpassword","errors.mpassword.minlength",new Object[]{8},"mpassword는 최소 8자 이상입니다.");
			}
		}
		//memail검사
		if(member.getMemail()==null || member.getMemail().trim().equals("")) {
			errors.rejectValue("memail","errors.memail.required","memail은 필수 입력 사항입니다.");
		}else {
			String regex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
			Pattern pattern=Pattern.compile(regex);
			Matcher matcher = pattern.matcher(member.getMemail());
			if(!matcher.matches()) {
				errors.rejectValue("memail","errors.memail.invalid","memail은 이메일 형식이 아닙니다.");
			}
		}
		//mtel 검사
	      if(member.getMtel() == null || member.getMtel().trim().equals("")) {
	         errors.rejectValue("mtel", "errors.mtel.required","errors.mtel.required");
	      } else {
	         String regex = "^\\d{3}-\\d{3,4}-\\d{4}$";
	         Pattern pattern = Pattern.compile(regex);
	         Matcher matcher = pattern.matcher(member.getMtel());
	         if(!matcher.matches()) {
	            errors.rejectValue("mtel","errors.mtel.invalid", "errors.mtel.invalid");
	         }
	      }
	}

}
