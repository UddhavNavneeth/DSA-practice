public class Lab33 {
		 public static void main(String[] args)
		{
		 Thread randomThread = new Thread(new thread1());
		 randomThread.start();
		 }
} 


class thread1 implements Runnable {
	double num;
	public void run() {
		try {
			 Thread2 sqt = new Thread2();
			 Thread Thread2 = new Thread(sqt);
			 Thread3 cbt = new Thread3();
			 Thread Thread3 = new Thread(cbt);
			 Thread2.start();
			 Thread3.start();
			 for(int i=0;i<6;i++)
			{
			 System.out.println("thread1::"+i);
			 if(i%2 == 0)
			 {
			 sqt.setNum(new Double(i));
			 }
			 else
			{
			 cbt.setNum(new Double(i));
			 }
			 Thread.sleep(1000);
			 }
			 } catch (InterruptedException e)
			{
			 e.printStackTrace();
			 }
			 }
		}
	 class Thread2 implements Runnable {
		 Double num;
		 public void run()
		 {
	
		 try { 
		 int i=0;
		 do{
		 i++;
		 if(num != null&&num %2 ==0)
		 {
			 System.out.println("thread2:: square of "+num+"="+(num*num));
			 num = null;
		 }
		 Thread.sleep(1000);
		 }while(i<=5);
		 }
		 	catch (Exception e)
		 {
		 		e.printStackTrace();
		 }
		}
		 public Double getNum()
		{
			return num;
		 }
		 public void setNum(Double num)
		{
			 this.num = num;
		 }
	}
	 
	class Thread3 implements Runnable
	 {
		Double num;
	 public void run()
	{
	 try {
		 int i=0;
	 do{
		 i++;
		 if(num != null&&num%2 !=0)
		 {
			 System.out.println("thread3:: Cube of "+num+"="+(num*num*num));
			 num=null;
		 }
	 Thread.sleep(1000);
	 }
	 while(i<=5); 
	 }
	 catch (Exception e)
	 {
		 e.printStackTrace();
	 }
	}
	 public Double getNum()
	{
	 return num;
	 }
	 public void setNum(Double num)
	{
	 this.num = num;
	 }
	}
	
