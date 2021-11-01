package model.board;

import java.sql.Date;

public class BoardVO {
	
	private int wpk;
	private String title;
	private String id;
	private String content;
	private Date wdate;
	
	public int getWpk() {
		return wpk;
	}
	public void setWpk(int wpk) {
		this.wpk = wpk;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getWdate() {
		return wdate;
	}
	public void setWdate(Date wdate) {
		this.wdate = wdate;
	}
	
	@Override
	public String toString() {
		return "BoardVO [wpk=" + wpk + ", title=" + title + ", id=" + id + ", content=" + content + ", wdate="
				+ wdate + "]";
	}
}
