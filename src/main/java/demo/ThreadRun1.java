package demo;

public class ThreadRun1 implements Runnable {

	SharedObj sh;
	
	public ThreadRun1(SharedObj sh) {
		this.sh = sh;
	}

	@Override
	public void run() {
		
		try {
			sh.A();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	

}
