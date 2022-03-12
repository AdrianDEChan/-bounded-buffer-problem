
import java.util.Date;

public class Producer extends Thread {

    private A5 buffer;
    public Producer(A5 buffer)
    {
        this.buffer =  buffer;
    }


    public void run() {
        Date message;

        while (true)
        {

          sleep.nap();
           message = new Date();
           buffer.insert(message);

            }
        }


}

