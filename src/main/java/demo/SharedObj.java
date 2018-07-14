package demo;

public class SharedObj {

	//SharedObj sh;
	
	public synchronized void A() throws InterruptedException {
		synchronized (this) {
			
		}
		System.out.println(Thread.currentThread().getName());
			Thread.sleep(10000);
			System.out.println(Thread.currentThread().getName());
		
		
		
	}
	
	public synchronized void B() throws InterruptedException {
		System.out.println(Thread.currentThread().getName());
			Thread.sleep(10000);
			System.out.println(Thread.currentThread().getName());
		
		
		
	}
	
}
