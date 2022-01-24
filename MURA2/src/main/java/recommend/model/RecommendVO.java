package recommend.model;

public class RecommendVO {

	private int idx_num; // 게시글 번호
	private String id_mem; // 추천한 사람
	private int board_num; // 게시판 번호

	public int getIdx_num() {
		return idx_num;
	}
	public void setIdx_num(int idx_num) {
		this.idx_num = idx_num;
	}
	public String getId_mem() {
		return id_mem;
	}
	public void setId_mem(String id_mem) {
		this.id_mem = id_mem;
	}
	public int getBoard_num() {
		return board_num;
	}
	public void setBoard_num(int board_num) {
		this.board_num = board_num;
	}
	
}
