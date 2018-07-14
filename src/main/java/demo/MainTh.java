package demo;

public class MainTh {

	public static void main(String[] args) {
		
		SharedObj sh = new SharedObj();
		ThreadRun1 tR1 = new ThreadRun1(sh);
		ThreadRun2 tR2 = new ThreadRun2(sh);
		
		Thread t1 = new Thread(tR1);
		Thread t2 = new Thread(tR2);
		t1.start();
		t2.start();
		

	}

}
