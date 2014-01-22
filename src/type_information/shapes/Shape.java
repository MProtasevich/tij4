package type_information.shapes;

public abstract class Shape {
	private boolean highlight;
	void draw() {
		System.out.println(this + ".draw()");
	}

	public void setHighLight(boolean highlight) {
		this.highlight = highlight;
	}

	public boolean isHighLighted() {
		return highlight; 
	}

	@Override
	abstract public String toString();
}