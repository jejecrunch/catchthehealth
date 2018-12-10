package feature;

import java.util.*;

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
	
	// 객체 생성 제한 → static 메소드 준비
	public static MemberDAO getInstance() {
		if(memberdao==null)
			memberdao=new MemberDAO();
		return memberdao;
	}
	
	// 자료 저장용 메소드
	public void add(Member member) {
		this.memList.add(member);
	}
	
	// 자료 개수 확인용 메소드
	public int count() {
		return this.memList.size();
	}
	
	// 자료 전체 출력용 메소드
	public ArrayList<Member> list(){
		return this.memList;
	}
	
	// ID와 PW 기준 자료 검색용 메소드
	public Member searchIdPw(String id, String pw) {
		// 검색 결과를 저장하는 Member 객체
		Member mem = null;
		
		// 비교 대상인 ID를 저장하는 임시 Member 객체
		Member temp = new Member();
		temp.setId(id);
		temp.setPw(pw);
		
		for(int i=0;i<this.memList.size();i++) {
			// id를 가지고 ArrayList 컬렉션에 저장된 Member 객체를
			// id 부분만 비교해서 일치하는 Member 객체를 찾는 과정 추가
			if(this.compareToIdPw(temp, this.memList.get(i))) {
				mem = this.memList.get(i);
			}
		}
		
		return mem;
	}

	private boolean compareToIdPw(Member temp, Member member) {
		if(temp.getId().equals(member.getId())&&temp.getPw().equals(member.getPw()))
			return true;
		else
			return false;
	}
	
	// admin 탐색용 메소드
	public boolean searchAdmin() {
		for(int i=0;i<memList.size();) {
			String name = memList.get(i).getName();
			// 루프를 돌다가 id가 admin이고 pw가 test123인 멤버를 만나면 true를 리턴
			if(name == "관리자") {
				return true;
			}
		}
		return false;
	}

	@Override
	public String toString() {
		return "MemberDAO\n" + memList;
	}
}
