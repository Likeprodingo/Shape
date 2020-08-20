package by.shibaev.shape.entity;

public class Flat {
    private Point A;
    private Point B;
    private Point C;

    public Flat(Point a, Point b, Point c) {
        A = a;
        B = b;
        C = c;
    }

    public Point getA() {
        return A;
    }

    public void setA(Point a) {
        A = a;
    }

    public Point getB() {
        return B;
    }

    public void setB(Point b) {
        B = b;
    }

    public Point getC() {
        return C;
    }

    public void setC(Point c) {
        C = c;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Flat flat = (Flat) o;

        if (A != null ? !A.equals(flat.A) : flat.A != null) return false;
        if (B != null ? !B.equals(flat.B) : flat.B != null) return false;
        return C != null ? C.equals(flat.C) : flat.C == null;
    }

    @Override
    public int hashCode() {
        int result = A != null ? A.hashCode() : 0;
        result = 31 * result + (B != null ? B.hashCode() : 0);
        result = 31 * result + (C != null ? C.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Flat{");
        sb.append("A=").append(A);
        sb.append(", B=").append(B);
        sb.append(", C=").append(C);
        sb.append('}');
        return sb.toString();
    }
}
