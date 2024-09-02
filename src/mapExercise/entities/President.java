package mapExercise.entities;

import java.util.Objects;

public class President {
    private String name;

    public President(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        President president = (President) o;
        return Objects.equals(name, president.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }
}
