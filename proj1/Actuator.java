package vacuum;

import java.util.Map;

public interface Actuator {
	public void act(Environment env, Map<String, Object> data);
}
