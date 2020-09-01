package T1101_1150;

import java.util.*;

public class SnapshotArray {
    class SetOperation {
        int index;
        int value;

        public SetOperation(int index, int value) {
            this.index = index;
            this.value = value;
        }
    }

    private List<SetOperation> operations;
    private List<Integer> snapshots;
    private int snapId = 0;

    public SnapshotArray(int length) {
        operations = new ArrayList<SetOperation>(50000);
        snapshots = new ArrayList<Integer>(50000);
    }

    public void set(int index, int val) {
        operations.add(new SetOperation(index, val));
    }

    public int snap() {
        snapshots.add(operations.size());
        return snapId++;
    }

    public int get(int index, int snap_id) {
        Integer optIndex = snapshots.get(snap_id);
        ListIterator<SetOperation> iterator = operations.listIterator(optIndex);
        while (iterator.hasPrevious()) {
            SetOperation operation = iterator.previous();
            if (operation.index == index) {
                return operation.value;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        //SnapshotArray snapshotArray = new SnapshotArray(4);
        //snapshotArray.snap();
        //snapshotArray.snap();
        //System.out.println(snapshotArray.get(3, 1));
        //snapshotArray.set(2, 4);
        //snapshotArray.snap();
        //snapshotArray.set(1, 4);

        SnapshotArray snapshotArray = new SnapshotArray(1);
        snapshotArray.set(0, 15);
        snapshotArray.snap();
        snapshotArray.snap();
        snapshotArray.snap();
        System.out.println(snapshotArray.get(0, 2));
    }
}