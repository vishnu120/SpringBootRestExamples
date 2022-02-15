package Thread;

public class OddEvenUsingTwoThread {
	
	int counter =1;
	static int N;
	void printOddNumber(){
		
		synchronized (this) {
			
			while(counter < N) {
				
				while(counter % 2 ==0) {
					try {
						wait();
					} catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
					}
				}
				System.out.println(counter+"  ");
				counter++;
				notify();
				
			}
			
		}
			
	}
	
	public void printEvenNumber()
    {
        synchronized (this)
        {
            // Print number till the N
            while (counter < N) {
  
                // If count is odd then print
                while (counter % 2 == 1) {
  
                    // Exception handle
                    try {
                        wait();
                    }
                    catch (
                        InterruptedException e) {
                        e.printStackTrace();
                    }
                }
  
                // Print the number
                System.out.print(
                    counter + " ");
  
                // Increment counter
                counter++;
  
                // Notify to 2nd thread
                notify();
            }
        }
    }
  
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 // Given Number N
        N = 10;
  
        // Create an object of class
        OddEvenUsingTwoThread mt = new OddEvenUsingTwoThread();
  
        // Create thread t1
        Thread t1 = new Thread(new Runnable() {
            public void run()
            {
                mt.printEvenNumber();
            }
        });
  
        // Create thread t2
        Thread t2 = new Thread(new Runnable() {
            public void run()
            {
                mt.printOddNumber();
            }
        });
  
        // Start both threads
        t1.start();
        t2.start();
    }


	}


