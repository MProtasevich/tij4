package inner_classes.ex23;

public class B {
    private U[] u;
    private int currentIndex = 0;

    public B(int size) {
        u = new U[size];
    }
    
    public B(U[] u) {
    	this.u = u;
    }

    public void add(U u) {
        if(currentIndex >= this.u.length) {
            System.err.println("Index is out of bounds");
        } else {
            this.u[currentIndex++] = u;
        }
    }

    public void setU(/*U u, */int index) {
        /*if(index >= this.u.length) {
            System.err.println("Index is out of bounds");
        } else {
            this.u[index] = u;
        }*/
    	this.u[index] = null;
    }

    public void reduce() {
    	for (U item : this.u) {
    		if(item == null) {
    			continue;
    		}

			item.f();
			item.g();
			item.h();
		}
    }
    
    public static final int NUM_OF_OBJECTS = 5;
    @SuppressWarnings("")
    public static void main(String[] args) {
		A[] a = new A[NUM_OF_OBJECTS];

		for(int i = 0; i < NUM_OF_OBJECTS; ++i) {
			a[i] = new A();
		}

		B b = new B(NUM_OF_OBJECTS);
		
		b.reduce();
		b.setU(3);
		b.setU(1);
	}
}