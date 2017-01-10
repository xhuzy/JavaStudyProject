import java.text.ParseException;
import java.util.Date;

import org.quartz.Job;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.impl.JobDetailImpl;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.triggers.CronTriggerImpl;
import org.quartz.impl.triggers.SimpleTriggerImpl;

public class QuartzMainClass {
public static void main(String[]args) throws SchedulerException, InterruptedException, ParseException{
	JobDetailImpl job = new JobDetailImpl();
    job.setJobClass(QuartzHelloWord.class);
    job.setName("job1");
    job.setGroup("job_group_1");
    
    JobDetailImpl job1 = new JobDetailImpl();
    job1.setJobClass(QuartzHelloWord.class);
    job1.setName("job2");
    job1.setGroup("job_group_2");
    
   SimpleTriggerImpl simpleTriggerImpl=new SimpleTriggerImpl();
   simpleTriggerImpl.setGroup("sim_group_1");
   simpleTriggerImpl.setName("sim_name_1");
   simpleTriggerImpl.setStartTime(new Date());
   simpleTriggerImpl.setRepeatCount(-1);
   simpleTriggerImpl.setRepeatInterval(2000);
   
   
   
   
   CronTriggerImpl cronTriggerImpl=new CronTriggerImpl();
   cronTriggerImpl.setGroup("cron_grop-1");
   cronTriggerImpl.setName("cron_name-1");
   ////每分钟的零秒执行
   cronTriggerImpl.setCronExpression("0 * * * * ?");
   
   
   SchedulerFactory sf = new StdSchedulerFactory();
   Scheduler sched = sf.getScheduler();
//   sched.scheduleJob(job, simpleTriggerImpl);
   sched.scheduleJob(job1, cronTriggerImpl);
   sched.start();
   Thread.sleep(900000000L * 1000L);
   sched.shutdown(true);
   
		   
   
	}
}
