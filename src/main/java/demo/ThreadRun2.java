package demo;

public class ThreadRun2 implements Runnable {

	SharedObj sh;
	
	public ThreadRun2(SharedObj sh) {
		this.sh = sh;
			// TODO Auto-generated constructor stub
	}

	@Override
	public void run() {
		
		try {
			sh.B();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	

}
