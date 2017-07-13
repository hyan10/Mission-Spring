package kr.co.bit.board.vo;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

public class BoardVO {
	private int no;
	@NotEmpty(message="공백은 허용하지 않습니다")
	@Length(min=2, max=20, message="2 - 20사이의 글자로만 입력하세요")
	private String title;
	
	@NotEmpty(message="공백은 허용하지 않습니다")
	private String content;
	
	@NotEmpty(message="공백은 허용하지 않습니다")
	@Pattern(regexp="^[A-Za-z]*$", message="반드시 알파벳으로 시작하세요")
	private String writer;
		
	private int viewCnt;
	private String regDate;
	
	
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
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
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public int getViewCnt() {
		return viewCnt;
	}
	public void setViewCnt(int viewCnt) {
		this.viewCnt = viewCnt;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	@Override
	public String toString() {
		return "BoardVO [no=" + no + ", title=" + title + ", content=" + content + ", writer=" + writer + ", viewCnt="
				+ viewCnt + ", regDate=" + regDate + "]";
	}
	
	
}
