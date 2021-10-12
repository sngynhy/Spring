package model.board;

import java.sql.Date;

public class BoardVO {
	
	private int wpk;
	private String title;
	private String writer;
	private String content;
	private Date wdate;
	private String keyword;
	
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
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
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
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	
	@Override
	public String toString() {
		return "BoardVO [wpk=" + wpk + ", title=" + title + ", writer=" + writer + ", content=" + content + ", wdate="
				+ wdate;
	}
	
}
