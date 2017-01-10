import java.util.Timer;
import java.util.TimerTask;

public class MainClass {
public static void main(String[]args){
	Timer timer=new Timer();
	timer.schedule(new PrintHelloService(), 0, 1000);
	timer.schedule(new PrintHelloService(),500,1000);
}
}
