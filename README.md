# Social-Login

소개)

구글/네이버/카카오 소셜 로그인 구현했습니다.

데이터베이스 하나 만들고 application.properties에서 연결한 다음 프로젝트 실행시키면 테이블은 자동 생성됩니다!

applicaion.properties 코드와 application-oauth.properties 코드는 카카오톡으로 보내드리겠습니다. 
복사/붙여넣기 하시고 application.properties 코드에서 db 설정 부분만 본인 db에 맞게 수정하시면 됩니다. 
application-oauth.properties 코드는 수정할 필요 없습니다. 

localhost:8080/sample/all 은 로그인 없이 접근 가능하고

localhost:8080/sample/user 는 로그인 한 사람만 접근 가능합니다. 


실행)

1. 빈 데이터베이스를 하나 생성한다. 

2. properties 코드를 복사/붙여넣기 한 다음 db 정보를 수정한다.

3. 프로젝트를 실행한다.

4. localhost:8080/sample/user 로 접속한다. -> localhost:8080/login 페이지로 재접속 된다.

5. 구글/네이버/카카오 중 하나를 골라서 로그인한다. -> 흰 창이 뜬다.

6. localhost:8080/sample/user로 다시 접속하면 본인 이메일과 ROLE_USER 권한이 뜬다.

7. DB에 가면 member 테이블과 member_role_set 테이블이 생성된 걸 확인할 수 있고, 본인이 로그인한 아이디와 이름이 저장된다. role_set에는 0이라는 값이 저장되는데 이는 접근 권한을 나타낸다.

8. 로그아웃 하고 싶을 땐 주소창에 localhost:8080/logout을 친다. 


