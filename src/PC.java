import java.util.ArrayList;

public class PC {
 
        ArrayList<Integer> buffer = new ArrayList<>();
        int tamanho = 5;
 
        public void produtor(int i) throws InterruptedException
        {
            int value = 0;
            while (true) {
                synchronized (this)
                {

                    while (buffer.size() == tamanho)
                        wait();
 
                    System.out.println("p" + i +" produziu - "
                                       + value);
 
                    buffer.add(value++);
 
                    notify();
 
                    Thread.sleep(500);
                }
            }
        }
 
        public void consumidor(int i) throws InterruptedException
        {
            while (true) {
                synchronized (this)
                {
                	
                    while (buffer.size() == 0)
                        wait();
 
                    int val = buffer.remove(0);
 
                    System.out.println("c" + 1 + " consumiu - "
                                       + val);
 
                    notify();
 
                    Thread.sleep(500);
                }
            }
        }
}