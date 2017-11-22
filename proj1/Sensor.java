package vacuum;

import java.util.Map;

public interface Sensor {
	public Map<String, Object> sense(Environment env);
}
