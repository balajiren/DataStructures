package DesignPatterns;


 abstract class AbstractLogger {
	   public static int INFO = 1;
	   public static int DEBUG = 2;
	   public static int ERROR = 3;

	   protected int level;

	   //next element in chain or responsibility
	   protected AbstractLogger nextLogger;

	   public void setNextLogger(AbstractLogger nextLogger){
	      this.nextLogger = nextLogger;
	   }

	   public void logMessage(int level, String message){
	      if(this.level <= level){
	         write(message);
	      }
	      if(nextLogger !=null){
	         nextLogger.logMessage(level, message);
	      }
	   }

	   abstract protected void write(String message);
		
	}
 
 class ConsoleLogger extends AbstractLogger {

	   public ConsoleLogger(int level){
	      this.level = level;
	   }

	   @Override
	   protected void write(String message) {		
	      System.out.println("Standard Console::Logger: " + message);
	   }
	}
 
 class ErrorLogger extends AbstractLogger {

	   public ErrorLogger(int level){
	      this.level = level;
	   }

	   @Override
	   protected void write(String message) {		
	      System.out.println("Error Console::Logger: " + message);
	   }
	}
public class ChainOfResponsibilities {
	
	private static AbstractLogger getChainOfLoggers(){

	      AbstractLogger errorLogger = new ErrorLogger(AbstractLogger.ERROR);
	      AbstractLogger consoleLogger = new ConsoleLogger(AbstractLogger.INFO);

	      errorLogger.setNextLogger(consoleLogger);

	      return errorLogger;	
	   }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 AbstractLogger loggerChain = getChainOfLoggers();

	      loggerChain.logMessage(AbstractLogger.INFO, 
	         "This is an information.");

	}
	
	

}
