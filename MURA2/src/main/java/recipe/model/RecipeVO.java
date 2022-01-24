package recipe.model;

import java.sql.Timestamp;

public class RecipeVO {

	private int idx_li;
	private int un_mem;
	private String nn_mem;
	private String category_li;
	private String wsubject_li;
	private String tag_li;
	private String thumb_li;
	private String wcontent_li;
	private Timestamp date_li;
	private int readcount_li;
	private int recommend_cnt;
	private int board_num;
	private int reply_cnt;
	
	public int getIdx_li() {
		return idx_li;
	}
	public void setIdx_li(int idx_li) {
		this.idx_li = idx_li;
	}
	public int getUn_mem() {
		return un_mem;
	}
	public void setUn_mem(int un_mem) {
		this.un_mem = un_mem;
	}
	public String getNn_mem() {
		return nn_mem;
	}
	public void setNn_mem(String nn_mem) {
		this.nn_mem = nn_mem;
	}
	public String getCategory_li() {
		return category_li;
	}
	public void setCategory_li(String category_li) {
		this.category_li = category_li;
	}
	public String getWsubject_li() {
		return wsubject_li;
	}
	public void setWsubject_li(String wsubject_li) {
		this.wsubject_li = wsubject_li;
	}
	public String getTag_li() {
		return tag_li;
	}
	public void setTag_li(String tag_li) {
		this.tag_li = tag_li;
	}
	public String getThumb_li() {
		return thumb_li;
	}
	public void setThumb_li(String thumb_li) {
		this.thumb_li = thumb_li;
	}
	public String getWcontent_li() {
		return wcontent_li;
	}
	public void setWcontent_li(String wcontent_li) {
		this.wcontent_li = wcontent_li;
	}
	public Timestamp getDate_li() {
		return date_li;
	}
	public void setDate_li(Timestamp date_li) {
		this.date_li = date_li;
	}
	public int getReadcount_li() {
		return readcount_li;
	}
	public void setReadcount_li(int readcount_li) {
		this.readcount_li = readcount_li;
	}
	public int getRecommend_cnt() {
		return recommend_cnt;
	}
	public void setRecommend_cnt(int recommend_cnt) {
		this.recommend_cnt = recommend_cnt;
	}
	public int getBoard_num() {
		return board_num;
	}
	public void setBoard_num(int board_num) {
		this.board_num = board_num;
	}
	public int getReply_cnt() {
		return reply_cnt;
	}
	public void setReply_cnt(int reply_cnt) {
		this.reply_cnt = reply_cnt;
	}
	
}
