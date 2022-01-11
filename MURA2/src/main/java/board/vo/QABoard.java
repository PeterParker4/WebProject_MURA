package board.vo;

import java.sql.Timestamp;

public class QABoard {
	
	private int un_mem;
	private int idx_qt;
	private String nn_mem;
	private String wsubject_qt;
	private String wcontent_qt;
	private int step_qt;
	private int depth_qt;
	private Timestamp date_qt;
	private int readcount_qt;
	
	
	public int getUn_mem() {
		return un_mem;
	}
	public void setUn_mem(int un_mem) {
		this.un_mem = un_mem;
	}
	public int getIdx_qt() {
		return idx_qt;
	}
	public void setIdx_qt(int idx_qt) {
		this.idx_qt = idx_qt;
	}
	public String getNn_mem() {
		return nn_mem;
	}
	public void setNn_mem(String nn_mem) {
		this.nn_mem = nn_mem;
	}
	public String getWsubject_qt() {
		return wsubject_qt;
	}
	public void setWsubject_qt(String wsubject_qt) {
		this.wsubject_qt = wsubject_qt;
	}
	public String getWcontent_qt() {
		return wcontent_qt;
	}
	public void setWcontent_qt(String wcontent_qt) {
		this.wcontent_qt = wcontent_qt;
	}
	public int getStep_qt() {
		return step_qt;
	}
	public void setStep_qt(int step_qt) {
		this.step_qt = step_qt;
	}
	public int getDepth_qt() {
		return depth_qt;
	}
	public void setDepth_qt(int depth_qt) {
		this.depth_qt = depth_qt;
	}
	public Timestamp getDate_qt() {
		return date_qt;
	}
	public void setDate_qt(Timestamp date_qt) {
		this.date_qt = date_qt;
	}
	public int getReadcount_qt() {
		return readcount_qt;
	}
	public void setReadcount_qt(int readcount_qt) {
		this.readcount_qt = readcount_qt;
	}

}
