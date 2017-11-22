package vacuum;

import java.util.Map;

public class AgentProgram implements FunctionProgram {

	@Override
	public Map<String, Object> run(Map<String, Object> data) {
		// TODO Auto-generated method stub
		boolean isClean = (boolean) data.get("isClean");
		String location = (String) data.get("location");
		if (!isClean) {
			data.put("vacuumCommand", "suck");
		}
		
		if (location == "A") {
			data.put("wheelsCommand", "moveTo");
			data.put("newLocation", "B");
		} else {
			data.put("wheelsCommand", "moveTo");
			data.put("newLocation", "A");
		}
		
		return data;
	}
	
}
