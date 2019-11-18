package com.justatechie.battleship;

/**
 * A base class for each Ship piece.
 *
 * @author Jonathan Augustine
 */
public final class Ship {

    private final String name;
    private final char symbol;
    private final int length;

    protected Ship(String name, int length) {
        this.name = name;
        this.symbol = name.toUpperCase().charAt(0);
        this.length = length;
    }

    public final String getName() {
        return this.name;
    }

    public final char getSymbol() {
        return this.symbol;
    }

    public final int getLength() {
        return this.length;
    }

    public final class Carrier extends Ship {
        public Carrier() {
            super("Carrier", 5);
        }
    }

    public final class Battleship extends Ship {
        public Battleship() {
            super("Battleship", 4);
        }
    }

    public final class Destroyer extends Ship {
        public Destroyer() {
            super("Destroyer", 3);
        }
    }

    public final class Submarine extends Ship {
        public Submarine() {
            super("Submarine", 3);
        }
    }

    public final class PatrolBoat extends Ship {
        public PatrolBoat() {
            super("PatrolBoat", 2);
        }
    }
}
