package uk.co.bigredobster.microtypes.base;

public abstract class IntegerMicroType<T extends Integer> extends MicroType<T> {
    protected static final int EMPTY = Integer.MIN_VALUE;

    public IntegerMicroType(T value) {
        super(value);
    }
}
