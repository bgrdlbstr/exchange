package uk.co.bigredobster.microtypes.base;

public abstract class BooleanMicroType<T extends Boolean> extends MicroType<T>{
    public BooleanMicroType(T value) {
        super(value);
    }
}
