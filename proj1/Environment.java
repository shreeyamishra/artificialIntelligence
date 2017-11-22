package vacuum;

public interface Environment {
	public boolean isClean();
	public void clean();
	public void makeDirty();
	public String getLocation();
	public void changeLocation(String location);
}
