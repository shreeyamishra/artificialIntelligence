package vacuum;

import java.util.Timer;
import java.util.TimerTask;

public class runEnv {
	static int start = 0;
	static int score = 0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub


		Tile env = new Tile(false, "A");
		Agent agent = new Agent();
		agent.addSensor(new Camera());
		agent.addProgram(new AgentProgram());
		agent.addActuator(new Vacuum());
		agent.addActuator(new Wheels());

		new Timer().schedule(new TimerTask() {
			@Override
			public void run() {

				System.out.println("---------------------");
				System.out.println("Before");
				System.out.println(env);
				System.out.println("Score: " + score);
				System.out.println("---------------------");
				agent.run(env);
				System.out.println("After");
				System.out.println(env);
				System.out.println("Score: " + (env.cleaned() ? --score : ++score));
				env.stopCleaning();
				if (score >= 15) {
					System.exit(0);;
				}
				if (Math.random() < 0.5) { 
					env.makeDirty();
				}
			}
		}, 0, 2000);

	}
}




