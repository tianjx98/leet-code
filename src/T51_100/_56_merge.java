package T51_100;

import java.util.ArrayList;
import java.util.List;

class Interval {
    int start;
    int end;
    Interval() {
        start = 0;
        end = 0;
    }
    Interval(int s, int e) {
        start = s;
        end = e;
    }

    @Override
    public String toString() {
        return "[ "+start+","+end+" ]";
    }
}

class _56_merge {
    /**
     * https://leetcode-cn.com/problems/merge-intervals/
     *
     * 先将集合中的元素以start从小到大排序
     * 创建一个start和一个end用来存储一段区间(最初为第一个元素的start,end)
     * 如果下一个元素和这个区间重合,就将end更新为下一个元素的end
     * 如果没有重合,就将start,end这个区间存到结果集,将当前没有重复的元素赋值给start,end,直到所有元素取完
     * @param intervals
     * @return
     */
    public List<Interval> merge(List<Interval> intervals) {
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
        List<Interval> intervals=new ArrayList<>();
//        intervals.add(new Interval(1,3));
//        intervals.add(new Interval(2,6));
//        intervals.add(new Interval(8,10));
//        intervals.add(new Interval(15,18));
//        intervals.add(new Interval(6,8));
        List<Interval> merge = new _56_merge().merge(intervals);
        System.out.println(merge.size());
        System.out.println(merge.toString());
    }
}