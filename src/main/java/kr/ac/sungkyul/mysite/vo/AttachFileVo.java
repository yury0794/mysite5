package kr.ac.sungkyul.mysite.vo;

public class AttachFileVo {

	private int fNo;
	private int no;
	private String path;
	private String orgName;
	private String saveName;
	private long fileSize;

	public int getfNo() {
		return fNo;
	}

	public void setfNo(int fNo) {
		this.fNo = fNo;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public String getSaveName() {
		return saveName;
	}

	public void setSaveName(String saveName) {
		this.saveName = saveName;
	}

	public long getFileSize() {
		return fileSize;
	}

	public void setFileSize(long fileSize) {
		this.fileSize = fileSize;
	}

	@Override
	public String toString() {
		return "AttachFileVo [fNo=" + fNo + ", no=" + no + ", path=" + path + ", orgName=" + orgName + ", saveName="
				+ saveName + ", fileSize=" + fileSize + "]";
	}
}