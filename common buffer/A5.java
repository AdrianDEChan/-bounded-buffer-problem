import java.util.concurrent.Semaphore;

public class A5 implements  Buffer {

    private static final int BUFFER_SIZE = 5;
    private Object[] buffer;
    private int in, out ,count;


    public A5() {
        in = 0;
        out = 0;
        buffer = new Object[BUFFER_SIZE];
        count = 0;


    }

    public synchronized void insert(Object item)  {
        while(count == BUFFER_SIZE)
        {
            try{
                wait();
            }
            catch(InterruptedException e){}
        }
        ++count;
       // System.out.println("count"+count);
        buffer[in] = item;
        in = (in+1) % BUFFER_SIZE;
        System.out.println("Produce No." +(in+1));

       notify();

    }

   public synchronized Object remove()
   {
       Object item;

       while(count == 0)
       {
           try{
               wait();
           }
           catch(InterruptedException e){}
       }
       --count;
      // System.out.println("Remove count"+count);
       item = buffer[out];
       out = (out+1) % BUFFER_SIZE;
      // System.out.println(" ");
       System.out.println("consume No."+(out+1));
       notify();

         return  item;
   }

    public static void main(String[] args) {
        Buffer buffer = new A5() ;


        Producer producer = new Producer((A5) buffer);
        Consumer consumer = (new Consumer(buffer));

        producer.start();

        consumer.start();
    }
}
