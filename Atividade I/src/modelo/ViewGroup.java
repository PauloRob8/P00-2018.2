package modelo;

public class ViewGroup extends View {
	
	public String texto;
	
	public boolean eh_layout = false;
	
	public View views[] = new View[15];
	
	public int contView = 0;
	
	public void addView(View v) {
		this.views[contView] = v;
		this.contView ++;
	}
	
}
