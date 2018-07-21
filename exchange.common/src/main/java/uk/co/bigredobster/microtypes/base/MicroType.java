package uk.co.bigredobster.microtypes.base;

import java.util.Objects;

import static com.google.common.base.Preconditions.checkNotNull;

public abstract class MicroType<T> {
    public final T value;

    MicroType(T value) {
        this.value = checkNotNull(value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MicroType<?> microType = (MicroType<?>) o;
        return Objects.equals(value, microType.value);
    }

    @Override
    public int hashCode() {

        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return "MicroType{" +
                "name=" + value +
                '}';
    }
}
