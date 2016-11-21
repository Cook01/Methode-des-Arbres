package Model;

enum Symbole {
    ET, OU, IMPLIQUE;

    @Override
    public String toString() {
        switch(this) {
            case ET: return "∧";
            case OU: return "∨";
            case IMPLIQUE: return "->";
            default: throw new IllegalArgumentException();
        }
    }
}
