package simple;

import java.util.ArrayList;

/**
 * Definition for an interval.
 */ 
class Interval {
     int start;
     int end;
     Interval() { start = 0; end = 0; }
     Interval(int s, int e) { start = s; end = e; }
}
 
public class Intervals {
	public static ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        ArrayList<Interval> res = new ArrayList<Interval>();
        
        //insert all before newInterval
        int i=0;
        
        while(i<intervals.size() && intervals.get(i).end < newInterval.start){
            res.add(intervals.get(i));
            i++;
        }
        
        // end case
        if(i == intervals.size()){
            res.add(newInterval);
            return res;
        }
        
        
        int start;
        if(newInterval.start < intervals.get(i).start)
            start = newInterval.start;
        else
            start = intervals.get(i).start;
            
        
        //System.out.println("i: "+i);
        //check overlapping
        int overlap = 0;
        while(i < intervals.size() && intervals.get(i).start <= newInterval.end){
            overlap++;
            i++;
        }
        
        //System.out.println("overlap: "+overlap+ " " +intervals.get(i).start+"  "+newInterval.end);
        //System.out.println("i: "+i);
        
        int end;
        
        if(overlap == 0){
            end = newInterval.end;    
        }
        else{
            //shows overlap is till the end
            if(i != intervals.size()){
            	if(i > 0)
            		end = intervals.get(i-1).end > newInterval.end ? intervals.get(i-1).end : newInterval.end;
            	else
            		end = newInterval.end;
            			
            }
            else
                end = intervals.get(i-1).end > newInterval.end ? intervals.get(i-1).end : newInterval.end;
        }
        
        res.add(new Interval(start, end));
        
        while(i < intervals.size()){
            res.add(intervals.get(i));
            i++;
        }
        
        return res;
        
    }
    
    
    public static void test(){
    	ArrayList<Interval> a = new ArrayList<Interval>();
    	
    	a.add(new Interval(2,4));
    	a.add(new Interval(7,10));
    	a.add(new Interval(12,17));
    	a.add(new Interval(20,22));
    	a.add(new Interval(23,39));
    	Interval tmp = new Interval(9,14);
    	
    	a = insert(a, tmp);
    	
    	for(Interval i: a){
    		System.out.print("("+i.start+","+i.end+"), ");
    	}
    	
    }
}

