package feature;

import java.util.ArrayList;

public class MemberDAO {
	// 객체 생성 제한 → static 멤버 준비
	private static MemberDAO memberdao = new MemberDAO();
	
	// 자료 저장용 객체 준비
	// 다량의 데이터를 저장할 수 있는 저장소가 준비되어야 함.
	// 입출력과 용량관리가 편리해야 함
	private ArrayList<Member> memList=new ArrayList<Member>();
	
	// 객체 생성 제한 → private 생성자
	private MemberDAO() {
		
	}
}
