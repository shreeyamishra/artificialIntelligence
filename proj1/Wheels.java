package vacuum;

import java.util.Map;

public class Wheels implements Actuator {

	@Override
	public void act(Environment env, Map<String, Object> data) {
		// TODO Auto-generated method stub
		String command = (String) data.get("wheelsCommand");
		switch (command) {
		case "moveTo": 
			env.changeLocation((String) data.get("newLocation"));
			break;
		default:
			break;
		}
	}

}
