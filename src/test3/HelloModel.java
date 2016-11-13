package test3;

import java.util.HashMap;
import java.util.Map;

public class HelloModel {
	private Map<String, String> messages=new HashMap<String,String>();
    public HelloModel(){
    	messages.put("sdffjksd","fgfgsdtwew4");
    	messages.put("sdffjkd","sdtw");
    	messages.put("sfjksd","gsdtwew4");
    }
    public String doHello(String user){
    	String message=messages.get(user);
    	return message+","+user+"!";
    }
}
