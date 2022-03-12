public interface Buffer {

    public abstract void insert (Object item) ;// producers produce items

    public abstract Object remove(); // consumers consume items
}
