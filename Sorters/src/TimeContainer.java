/**
 * @author drew
 *
 * TimesContainer contains the Sorting Algorithm, the filename, and the execution time
 */
public class TimeContainer 
{
	private String algorithm;
	private String fileName;
	private double executionTime;
	
	public TimeContainer(String algorithm, String fileName, double executionTime)
	{
		this.algorithm = algorithm;
		this.fileName = fileName;
		
		/* convert from nanoseconds to milliseconds */
		this.executionTime = executionTime;
	}
	
	/**
	 * @return algorithm
	 */
	public String getAlgorithm()
	{
		return algorithm;
	}

	/**
	 * @return fileName
	 */
	public String getFileName() 
	{
		return fileName;
	}

	/**
	 * @return executionTime
	 */
	public double getExecutionTime() 
	{
		return executionTime;
	}

}
