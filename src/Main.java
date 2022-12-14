public class Main {
    public static void main(String[] args) throws InterruptedException
    {
    	
        PC pc = new PC();
        
        Thread tp1 = new Thread(new Runnable() {
            @Override
            public void run()
            {
                try {
                    pc.produtor(1);
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        
        Thread tp2 = new Thread(new Runnable() {
            @Override
            public void run()
            {
                try {
                    pc.produtor(2);
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
 
        Thread tc1 = new Thread(new Runnable() {
            @Override
            public void run()
            {
                try {
                    pc.consumidor(1);
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        
        Thread tc2 = new Thread(new Runnable() {
            @Override
            public void run()
            {
                try {
                    pc.consumidor(2);
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        

        
        tp1.start();
        tp2.start();
        tc1.start();
        tc2.start();

        tp1.join();
        tp2.join();
        tc1.join();
        tc2.join();

    }

}