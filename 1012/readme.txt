1. IoC AOP 지원하는 컨테이너
IoC
-> applicationContext.xml을 이용하여 <bean> 등록
-> @어노테이션 사용 <context:scan>

비즈니스컴포넌트
->board, member table
->VO, DAO(jdbcTemplate), Service(interface), ServiceImpl, Client

★최소 9개의 클래스
board -> 1.검색 getBoardList 2.입력 insertBoard +)3.삭제 deleteBoard 4.수정 updateBoard
member -> 1.입력(회원가입) insertMember 2. 로그인 getMember

★어노테이션 우선으로 설정!
★의존성 주입(DI) Setter 주입을 우선으로
★Client에서 수행하는 get() -> 수행 전에 데이터 출력이 시작됩니다!
	모든 메서드() -> 수행 시간을 화면 (console)에 출력
 : AOP Advice의 동작 시점
	포인트컷을 담아놓은 '포인트컷클래스' 이용
