package positionering.etc;

/**
 * This file contains enums containing information about which boat is selected
 * and whether the front or back is selected.
 *
 * @author Dion
 */
public enum BoatState {

    BOAT_1_FRONT(1, 1),
    BOAT_1_BACK(1, 2),
    BOAT_2_FRONT(2, 1),
    BOAT_2_BACK(2, 2),
    BOAT_3_FRONT(3, 1),
    BOAT_3_BACK(3, 2),
    BOAT_4_FRONT(4, 1),
    BOAT_4_BACK(4, 2);
    private final int id;
    private final int pos;

    BoatState(int id, int pos) {
        this.id = id;
        this.pos = pos;
    }

    public int getId() {
        return id;
    }
    
    public int getPos(){
        return pos;
    }
}
