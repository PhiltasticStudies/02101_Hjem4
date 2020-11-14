import java.util.Random;
public class Cell {
private boolean alive;
private int team;
private Random rand = new Random();

/**Used for creating new Cell type objects with specified start state
 * @param alive state of cell (boolean)
 * @param team team of cell (int)
 * @return a Cell type object with given state (boolean, int)
 */
public Cell(boolean alive, int team) {

	this.alive=alive;
	this.team=team;
}

/**Used for creating new Cell type objects with random start state
 * @return Cell(boolean, int) type object with random start state
 */
public Cell() {
	alive=rand.nextBoolean();
	team=rand.nextInt(2);
}

/**Used check if a cell si alive or not
 * @return boolean this returns alive state of Cell type object
 */
public boolean isAlive() {
	return alive;
	
}

/**Used to check the team of given cell
 * @return int this returns team number of Cell type objects
 */
public int getTeam() {
	return team;
}

/**Used to alter alive state of a Cell type object
 * @param alive boolean
 * @return void
 */
public void setAlive(boolean alive) {
	this.alive=alive;
}

/** Used to set team state of Cell type object to a new int value
 * @param team int
 * @return void
 */
public void setTeam(int team) {
	this.team=team;
}


}

