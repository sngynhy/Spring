package model.board;

import java.sql.Date;

import org.springframework.web.multipart.MultipartFile;

public class BoardVO {
	
	private int wpk;
	private String title;
	private String id;
	private String content;
	private Date wdate;
	private String type; // 검색 옵션
	private String keyword; // 검색 키워드
	private MultipartFile fileUpload;
	
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
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public MultipartFile getFileUpload() {
		return fileUpload;
	}
	public void setFileUpload(MultipartFile fileUpload) {
		this.fileUpload = fileUpload;
	}
	
	@Override
	public String toString() {
		return "BoardVO [wpk=" + wpk + ", title=" + title + ", id=" + id + ", content=" + content + ", wdate=" + wdate + "]";
		
	}
	
}
