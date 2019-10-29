package cave_1_startingThreads;

public class App3 {
	
	public static void main(String[] args) {

		Thread t1 = new Thread(new Runnable() {
			public void run() {
				for(int i = 0; i < 10 ; i++) {
					System.out.println("Hello " + i);
					
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});
		
		t1.start();
	}

}

/*
 * why are there so many, songs about rainbows
 * and what's on the other side
 * rainbows are visions the're only illusions
 * but rainbows have nothing to hide
 * so we've been told and some choose to believe it
 * I know they're wrong wait and see
 * some day they'll find it
 * a rainbow connection
 * the lovers the dreamers and me
 * 
 * who said that every wish 
 * would be herd and answered 
 * when wished on a morning star
 * somebody thought of that
 * and someone believed it
 * look what it's done so far
 * what's so amazing that keeps us star gazing
 * and what do we think we might see
 * someday we'll find it a rainbow connection
 * the lovers the dreamers and me
 * all of us under it's spell
 * I know that it's probably magic
 * 
 * have you been fast asleep 
 * and have you herd voices
 * I hear them calling my name
 * is this the sweet sound that calls the young sailors
 * the voice might be one and the same
 * I've herd it too many times to ignore it
 * it's something that I'm supposed to be
 * 
 * someday we'll find it
 * a rainbow connection
 * the lovers the dreamers and me.
 * */