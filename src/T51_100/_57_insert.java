package T51_100;

import java.util.ArrayList;
import java.util.List;

class _57_insert {
    /**
     * https://leetcode-cn.com/problems/insert-interval/
     *
     * 先将元素插入区间集合里面,然后再用56题的合并方法得到结果
     * @param intervals
     * @param newInterval
     * @return
     */
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        intervals.add(newInterval);
        return merge(intervals);
    }
    private List<Interval> merge(List<Interval> intervals) {
        if (intervals==null||intervals.size()==0) return new ArrayList<>();
        if (intervals.size()==1) return intervals;
        intervals.sort((x,y)->x.start-y.start);
        List<Interval> result=new ArrayList<Interval>();
        int start=intervals.get(0).start,end=intervals.get(0).end;
        for (int i=1;i<intervals.size();i++){
            Interval interval = intervals.get(i);
            if (end>=interval.end) continue;
            if (end>=interval.start) {
                end=interval.end;
            }else {
                result.add(new Interval(start,end));
                start=interval.start;
                end=interval.end;
            }
        }
        result.add(new Interval(start,end));
        return result;
    }

    public static void main(String[] args) {
        ArrayList<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(1, 5));
//        intervals.add(new Interval(4, 5));
//        intervals.add(new Interval(6, 7));
//        intervals.add(new Interval(8, 10));
//        intervals.add(new Interval(12, 16));

        List<Interval> res = new _57_insert().insert(intervals, new Interval(6, 8));

        res.forEach((x) -> System.out.print(x));
    }
}