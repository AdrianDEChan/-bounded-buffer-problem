import java.util.Date;

public class Consumer extends Thread {
    private Buffer buffer;
    public Consumer(Buffer buffer)
    {
        this.buffer =  buffer;
    }

    public void run()
    {
        Date message;
        while(true)
        {
            sleep.nap();

                message = (Date) buffer.remove();



            }



    }
}
