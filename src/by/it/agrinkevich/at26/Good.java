package by.it.agrinkevich.at26;

import java.util.Objects;

class Good {
    String name;

    Good(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Good good = (Good) o;
        return Objects.equals(name, good.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

}
