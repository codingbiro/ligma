//Az interfesz arra szolgal, hogy minden kirajzolando dolgon
//meg lehessen hivni a shouldDraw fuggv�nyt
public interface IViewable {
	//jelzi, hogy ki kell rajzolni azt, akin meghivtak
	public void shouldDraw(View v);
}
