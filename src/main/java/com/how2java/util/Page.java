package com.how2java.util;

/**
 * @author:Mr.wang
 * @date:2019/2/27 0027 下午 6:11
 */
public class Page {
    int start=0;
    int count=5;//每页显示5条数据
    int last=0;

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getLast() {
        return last;
    }

    public void setLast(int last) {
        this.last = last;
    }
    //页数设置
    public void cacuLast(int total){
        // 假设总数是50，是能够被5整除的，那么最后一页的开始就是45
        if(total%count==0){
            last=total-count;
        }else{
            // 假设总数是51，不能够被5整除的，那么最后一页的开始就是50
            last=total-total%count;
        }
    }
}
