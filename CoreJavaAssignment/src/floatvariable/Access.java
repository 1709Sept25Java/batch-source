package floatvariable;

public class Access {
	private float f1 = 16.12f;
	private float f2 = 23.15f;
	
	public Access(float f, float g) {
	}
	public float getf1() {return this.f1;}
	public void setf1( float f1) {this.f1 = f1;}
	
	public float getf2() {return this.f1;}
	public void setf2(float f2) {this.f2 = f2; }
	@Override
	public String toString() {
		return " f1: " + this.f1 + ", f2: " + this.f2 ;
	}

}
