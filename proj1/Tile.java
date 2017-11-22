package vacuum;

public class Tile implements Environment {
	
	private boolean clean, cleanTile;
	private String location;
	
	public Tile(boolean isClean, String location) {
		this.clean = isClean;
		this.location = location;
	}

	@Override
	public boolean isClean() {
		// TODO Auto-generated method stub
		return clean;
	}

	public boolean cleaned() {
		return cleanTile;
	}
	public void stopCleaning() {
		
	}
	@Override
	public void clean() {
		// TODO Auto-generated method stub
		clean = true;
	}

	@Override
	public void makeDirty() {
		// TODO Auto-generated method stub
		clean = false;
	}

	@Override
	public String getLocation() {
		// TODO Auto-generated method stub
		return location
				;
	}

	@Override
	public void changeLocation(String location) {
		// TODO Auto-generated method stub
		this.location = location;
	}
	
	@Override
	public String toString() {
		return "location: " + location + " clean: " + clean;
	}
	
}
