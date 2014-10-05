package com.algorithm.percolation;


import edu.princeton.cs.introcs.StdRandom;
import edu.princeton.cs.introcs.StdStats;

public class PercolationStats {
		private double  [] threshold;
	   public PercolationStats(int N, int T){    // perform T independent computational experiments on an N-by-N grid
		   if(N<=0||T<=0)
			   throw new IllegalArgumentException();
		   threshold = new double[T]; 
		   for(int i=0;i<T;i++){
			   Percolation percolation = new Percolation(N);
			   int count =0;
			   do{
				   int row = StdRandom.uniform(1, N+1);
				   int column = StdRandom.uniform(1, N+1);
				   if(percolation.isopen(row, column)){
					   continue;
				   }else{
					   percolation.open(row, column);
					   count++;
				   }
			   }while(!percolation.percolates());
			   threshold[i] = (double)count/(N*N);
		   }
	   }
	   public double mean(){   // sample mean of percolation threshold
		   return StdStats.mean(this.threshold);
	   }
	   public double stddev() {// sample standard deviation of percolation threshold
		   return StdStats.stddev(this.threshold);
	   }
	   public double confidenceLo(){ // returns lower bound of the 95% confidence interval
		  return mean()-1.96*stddev()/Math.sqrt(threshold.length);
	   }
	   public double confidenceHi(){ // returns upper bound of the 95% confidence interval
		  
		   return  mean()+1.96*stddev()/Math.sqrt(threshold.length);
	   }
	   public static void main(String[] args){// test client, described below
		   PercolationStats percolationStats = new PercolationStats(20,100);

       System.out.println("mean="+ percolationStats.mean());
       System.out.println("stddev="+ percolationStats.stddev());
       System.out.println("95%% confidence Interval="+percolationStats.confidenceLo()+"  "+ percolationStats.confidenceHi());
	   }
}
