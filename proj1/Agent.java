package vacuum;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Agent {
	private ArrayList<Sensor> sensors = new ArrayList<Sensor>();
	private ArrayList<FunctionProgram> programs = new ArrayList<FunctionProgram>();
	private ArrayList<Actuator> actuators = new ArrayList<Actuator>();
	
	public void addSensor(Sensor sensor) {
		sensors.add(sensor);
	}
	
	public void addProgram(FunctionProgram program) {
		programs.add(program);
	}
	
	public void addActuator(Actuator actuator) {
		actuators.add(actuator);
	}
	
	public void run(Environment env) {
		Map<String, Object> data = new HashMap<String, Object>();
		for (int i = 0; i < sensors.size(); i++) {
			data.putAll(sensors.get(i).sense(env));
		}
		
		for (int i = 0; i < programs.size(); i++) {
			data.putAll(programs.get(i).run(data));
		}

		for (int i = 0; i < actuators.size(); i++) {
			actuators.get(i).act(env, data);
		}
	}
}
