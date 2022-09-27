package teste.script;

import java.util.Arrays;
import java.util.List;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class Script {
	    public static void main(String[] args) throws ScriptException {
	    	 ScriptEngineManager manager = new ScriptEngineManager();
	         ScriptEngine engine = manager.getEngineByName("nashorn");

	         engine.eval("var intArray = [1, 2, 3];");
	         //ScriptObjectMirror mirror = (ScriptObjectMirror) engine.get("intArray");
	     //    Integer[] intArray = mirror.to(Integer[].class);
	        // System.out.println(intArray.length);

	         engine.put("stringList", new String[]{"jeden", "dwa", "trzy"});
	         List<String> stringList = Arrays.asList((String[]) engine.get("stringList"));
	         System.out.println(stringList);
	        }
	    }
	
