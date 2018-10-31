package modelo;

public class Aplicativo {
	
	public String nome;
	public Activity[] activitys = new Activity[15];
	public int contActivity = 0;
	
	public void addActivity(Activity a) {
		this.activitys[this.contActivity] = a;
		this.contActivity ++;
		
	}

}
