package feature;

import java.util.Date;

public class Notice {

	private int postNo=0;
	private String title;
	private String content;
	private int viewCount=0;
	private Date date;
	
	public Notice(String title, String content, Date date) {
		this.postNo+=1;
		this.title=title;
		this.content=content;
		this.date=date;
	}

	public int getPostNo() {
		return postNo;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getViewCount() {
		return viewCount;
	}

	public void setViewCount(int viewCount) {
		this.viewCount = viewCount;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
}
