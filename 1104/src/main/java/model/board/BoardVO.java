package model.board;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name="BOARD") // Ŭ������� ���̺���� ���� �ٸ� ��� name �Ӽ��� �̿��Ͽ� �̸��� ������ �� �ִ�.
public class BoardVO {
	
	@Id // �ش� �ʵ带 �ĺ��� �ʵ�� ������ִ� ������̼� (�ʼ�)
	@GeneratedValue // pk�� �������� ó���ϰų�, nvl ó�� ���� ��� �ٿ������!
	private int wpk; // �ĺ��� �ʵ� == pk
	private String title;
	private String id;
	private String content;
	@Temporal(TemporalType.DATE) // DATE Ÿ���� ��� ����
	private Date wdate = new Date();
	@Transient // spring������ ��������� ���̺� ���� �÷��� ��� ���ο��� ���ܽ�Ű�� ������̼�
	private String type; // �˻� �ɼ�
	@Transient
	private String keyword; // �˻� Ű����
	
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
	@Override
	public String toString() {
		return "BoardVO [wpk=" + wpk + ", title=" + title + ", id=" + id + ", content=" + content + ", wdate=" + wdate + "]";
		
	}
	
}
