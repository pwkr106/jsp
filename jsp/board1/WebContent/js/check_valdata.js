$(function(){
				
				$('#regForm').submit(function(){
					

					var uid  = $('input[name=uid]').val();
					var pw1  = $('input[name=pw1]').val();
					var pw2  = $('input[name=pw2]').val();
					var name = $('input[name=name]').val();
					
					if(!isUidok){
						alert('아이디가 이미 사용중 입니다.')
						return false;
						
					}

					
					// 아이디 자리수 체크
					if(uid.length < 4){
						alert('아이디는 최소 4자 이상이어야 합니다.')
						return false;
					}
					// 비번 일치여부 확인
					if(pw1 != pw2){
						alert('비밀번호가 서로 일치하지 않습니다..')
						return false;
					}/*
					// 이름 영문 숫자 포함여부 체크
					if(){
						return false;
					}
					// 휴대폰 자리수 여부 체크 확인
					if(){
						return false;
					}*/
					
					return true;
				});
				
				
			});