package feature;

import java.util.ArrayList;

public class NoticeList {

	// 객체 생성 제한 → static 멤버 준비
	private static NoticeList noticeList = new NoticeList();

	// 자료 저장용 객체 준비
	// 다량의 데이터를 저장할 수 있는 저장소가 준비되어야 함.
	// 입출력과 용량관리가 편리해야 함
	private ArrayList<Notice> notiList=new ArrayList<>();

	// 객체 생성 제한 → private 생성자
	private NoticeList() {

	}

	// 객체 생성 제한 → static 메소드 준비
	public static NoticeList getInstance() {
		if(noticeList==null)
			noticeList=new NoticeList();
		return noticeList;
	}

	// 자료 저장용 메소드
	public void add(Notice notice) {
		this.notiList.add(notice);
	}

	// 자료 개수 확인용 메소드
	public int count() {
		return this.notiList.size();
	}

	// 자료 전체 출력용 메소드
	public ArrayList<Notice> list(){
		return this.notiList;
	}

	// 글 삭제
	public boolean delete(int index) {
		this.notiList.remove(index);
		return true;
	}
}