package vacuum;

import java.util.Map;

public class Vacuum implements Actuator {

	@Override
	public void act(Environment env, Map<String, Object> data) {
		// TODO Auto-generated method stub
		Object command = data.get("vacuumCommand");
		if (command != null ) {
			switch ((String)command) {
			case "suck": 
				env.clean();
				break;
			default:
				break;
			}
		}
	}

}
