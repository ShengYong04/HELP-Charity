package assignment.adt;

import assignment.entity.*;
import java.util.Comparator;

public interface LinkedListInterface<T> {
    
    public void add(T data);

    public void add(int indexNumber, T data);

    public void delete(int indexNumber);

    public T readForward(int indexNumber);
    
    public T readBackwards(int indexNumber);
    
    public int getNumberOfEntries();

    public Node getHead();

    public Node getTail();
    
    public boolean isEmpty();
    
    public void replace(int indexNumber, T data);
    
    public boolean contains(T data);
    
    public void sort(Comparator<T> comparator);
    
    public void clear();
}
