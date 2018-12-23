package feature;

import java.util.ArrayList;


public class PayHistoryDAO {
	
	 
	
	// 자료 저장용 객체 준비
	// 다량의 데이터를 저장할 수 있는 저장소가 준비되어야 함.
	// 입출력과 용량관리가 편리해야 함
	private ArrayList<PayHistory> payHistoryList=new ArrayList<PayHistory>();
	private static PayHistoryDAO payUserThing=new PayHistoryDAO();


	PayHistoryDAO() {
		
	}
	
	// 객체 생성 제한 → static 메소드 준비
	public static PayHistoryDAO getInstance() {
		if(payUserThing==null)
			payUserThing=new PayHistoryDAO();
		return payUserThing;
	}
	// 자료 저장용 메소드
		public void add(PayHistory p) {
			this.payHistoryList.add(0, p);
		}
		
		// 자료 개수 확인용 메소드
		public int count() {
			return this.payHistoryList.size();
		}
		
		// 자료 전체 출력용 메소드
		public ArrayList<PayHistory> list(){
			return this.payHistoryList;
		}
		public void remove() {
			this.payHistoryList.remove(0);
		}
		

	
}
