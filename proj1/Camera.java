package vacuum;

import java.util.HashMap;
import java.util.Map;

public class Camera implements Sensor {

	@Override
	public Map<String, Object> sense(Environment env) {
		// TODO Auto-generated method stub
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("isClean", env.isClean());
		data.put("location", env.getLocation());
		return data;
	}

}
