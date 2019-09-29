import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileReader {
	
	public String ReadURL() throws FileNotFoundException, IOException {
	 Properties prop = new Properties();
	       String workingDir = System.getProperty("user.dir");
			  File file = new File(workingDir+"/Config.properties");
			  
	        prop.load(new FileInputStream(file));
	        String url = prop.getProperty("URL");
	        
	        return url;
	        
}
	}
