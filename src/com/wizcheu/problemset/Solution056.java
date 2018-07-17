package com.wizcheu.problemset;

import com.wizcheu.problemset.common.Interval;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author wizcheu
 * @date 2018/07/17 20:26
 * @see <a href="https://leetcode.com/problems/merge-intervals/description/">https://leetcode.com/problems/merge-intervals/description/</a>
 */
public class Solution056 {

    // Your solution here
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> result = new ArrayList<>();
        if (null == intervals || intervals.size() <= 1) {
            return intervals;
        }
        intervals.sort(new IntervalComparator());
        Interval interval = intervals.get(0);
        for (int i = 1; i < intervals.size(); i++) {
            Interval curr = intervals.get(i);
            if (curr.start <= interval.end) {
                interval.end = Math.max(interval.end, curr.end);
            } else {
                result.add(interval);
                interval = curr;
            }
        }
        result.add(interval);
        return result;
    }

    private class IntervalComparator implements Comparator<Interval> {
        public int compare(Interval a, Interval b) {
            return a.start - b.start;
        }
    }

    private static void print(List<Interval> intervals) {
        System.out.print("[");
        for (Interval i : intervals) {
            System.out.print("[" + i.start + ", " + i.end + "],");
        }
        System.out.print("]");
    }

    public static void main(String[] args) {
        Solution056 st = new Solution056();
        List<Interval> list = new ArrayList<>();
        Interval interval1 = new Interval(1, 3);
        Interval interval2 = new Interval(2, 6);
        Interval interval3 = new Interval(8, 10);
        Interval interval4 = new Interval(15, 18);
        list.add(interval1);
        list.add(interval2);
        list.add(interval3);
        list.add(interval4);
        print(st.merge(list));
    }
}