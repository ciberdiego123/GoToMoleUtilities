
public class OpenMoleHeadlessExecutor {
	
	public static String executeFileUsingOpenMole(String pathToFile){
		
		if(!OSValidator.isUnix()) return "Command not supported";
		
		//No password needed
		return CMDExecutor.executeCmd("./openmole -s "+pathToFile);	
		
	}
	
	public static String executeFileUsingOpenMole(String pathToFile, Boolean isAPasswordFile ,String password){
		
		if(!OSValidator.isUnix()) return "Command not supported";
		
		if(isAPasswordFile)//Password is a file
			return CMDExecutor.executeCmd("./openmole -s "+pathToFile+" --password-file "+password);
		else //Password is typed directly
			return CMDExecutor.executeCmd("./openmole -s "+pathToFile+" --password "+password);	
		
	}

}
