package ers.domain;

public class Type {

	private int rt_id;
	private String type;
	
	public Type() {
		super();
	}

	public Type(int rt_id, String type) {
		super();
		this.rt_id = rt_id;
		this.type = type;
	}

	@Override
	public String toString() {
		return "Type [rt_id=" + rt_id + ", type=" + type + "]";
	}

	public int getRt_id() {
		return rt_id;
	}

	public void setRt_id(int rt_id) {
		this.rt_id = rt_id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	
	
	
}
