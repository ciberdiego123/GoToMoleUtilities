import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;


public class CMDExecutor {

	public static String executeCmd(String cmd){
		try{
			ProcessBuilder pb;
			if(OSValidator.isUnix())
				pb = new ProcessBuilder("/bin/bash","-c",cmd);
			else if(OSValidator.isWindows())
				pb = new ProcessBuilder("cmd.exe","/c",cmd);
			else
				pb = new ProcessBuilder("/bin/bash","-c",cmd);
			pb.redirectErrorStream(true);
			Process process=pb.start();
			BufferedReader reader = new BufferedReader(
					new InputStreamReader(process.getInputStream())); 
			StringBuilder result = new StringBuilder();;
			while (true) {
				String s = reader.readLine();
				if (s == null) break;
				result.append(s+"\n");
			}
			return result.toString();
		}catch(Exception e){
			Logger.getGlobal().log(Level.SEVERE, e.toString());
			return null;
		}	
	}     	
}
