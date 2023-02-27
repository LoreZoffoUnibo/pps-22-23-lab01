package lab01.tdd;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class CircularListImpl implements CircularList {

    private final List<Integer> list;
    private int currentIndex;

    public CircularListImpl() {
        this.list = new LinkedList();
        this.currentIndex = 0;
    }

    @Override
    public void add(int element) {
        this.list.add(element);
    }

    @Override
    public int size() {
        return this.list.size();
    }

    @Override
    public boolean isEmpty() {
        return this.list.isEmpty();
    }

    @Override
    public Optional<Integer> next() {
        if (this.list.isEmpty()){
            return  Optional.empty();
        }

        Integer tmp = this.list.get(this.currentIndex);
        changeIndex(1);
        return Optional.of(tmp);
    }

    @Override
    public Optional<Integer> previous() {
        if (this.list.isEmpty()){
            return  Optional.empty();
        }

        Integer tmp = this.list.get(this.currentIndex);
        changeIndex(-1);
        return Optional.of(tmp);
    }

    @Override
    public void reset() {

    }

    private void changeIndex(final int amount){
        if (this.currentIndex + amount < 0){
            this.currentIndex = this.list.size()-1;
            return;
        }

        if (this.currentIndex + amount >= this.list.size()){
            this.currentIndex = 0;
            return;
        }
    }
}
