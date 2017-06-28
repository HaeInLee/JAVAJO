package model;

import java.sql.Timestamp;

public class Board {
	private int num;
	private String m_id;
	private String title;
	private String content;
	private int readCount;
	private Timestamp writedate;
	
	
	
	@Override
	public String toString() {
		return "Board1 [num=" + num + ", m_id=" + m_id + ", title=" + title + ", content=" + content + ", readCount="
				+ readCount + ", writedate=" + writedate + "]";
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getM_id() {
		return m_id;
	}
	public void setM_id(String m_id) {
		this.m_id = m_id;
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
	public int getReadCount() {
		return readCount;
	}
	public void setReadCount(int readCount) {
		this.readCount = readCount;
	}
	public Timestamp getWritedate() {
		return writedate;
	}
	public void setWritedate(Timestamp writedate) {
		this.writedate = writedate;
	}
	
	
	
}
