import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.Assert;
import org.junit.Test;


public class CMDExecutorTests {
	
	@Test
	public void executeCMDTest(){
		String result = CMDExecutor.executeCmd("echo \"Ma jolie phrase est belle.\"");
		Logger.getGlobal().log(Level.INFO,"Command result: "+result);
		Assert.assertNotNull(result);
	}

}
