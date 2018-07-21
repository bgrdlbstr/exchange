package uk.co.bigredobster.microtypes.base;

public abstract class StringMicroType<T extends String> extends MicroType<T> {
    public static final String EMPTY = "";

    public StringMicroType(T value) {
        super(value);
    }
}
