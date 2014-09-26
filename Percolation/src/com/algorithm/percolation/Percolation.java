package com.algorithm.percolation;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;


public class Percolation {
	private WeightedQuickUnionUF grid = null;
	boolean[] state =null;
	private int N ;
	public Percolation(int N){
		this.N = N;
		if(this.N>0){
			int size = this.N * this.N +1;
			grid = new WeightedQuickUnionUF(size);
			state = new boolean[size];
			for(int index =1;index < size;index++){
				state[index] = false ;
			}
		}
		else
			throw new IllegalArgumentException("Illegal pattern!");
	}
	private boolean isInGrid(int i,int j){
		if((i<=0||i>this.N)||(j<=0||j>this.N))
			return false;
		else
			return true;
	}
	public void open(int i , int j){
		if(isInGrid(i, j)){
			state[(i-1)*N+j] = true;  //set state is true
			if(isInGrid(i-1, j)&&isopen(i-1, j))
				grid.union((i-1)*this.N+j,(i-2)*this.N+j);
			if(isInGrid(i, j+1)&&isopen(i, j+1))
				grid.union((i-1)*this.N+j, (i-1)*this.N+j+1);
			if(isInGrid(i,j-1)&&isopen(i, j-1))
				grid.union((i-1)*this.N+j, (i-1)*this.N+j-1);
			if(isInGrid(i+1, j)&&isopen(i+1, j))
				grid.union((i-1)*this.N+j,(i)*this.N+j);
		}else
			throw new IndexOutOfBoundsException("Index out of bound!");
	}
	public boolean isopen(int i ,int j){
		if(isInGrid(i, j)){
			return state[(i-1)*N+j]==true;
		}else
			throw new IndexOutOfBoundsException();
	}
	public boolean isFull(int i, int j){  //is this site can connect to the first raw we can say this site is full
		if(isopen(i, j)){
			for(int index=1;index<=this.N;index++){
				if(grid.connected(index, (i-1)*N+j))
					return true;
			}
		}
		return false;
	}
	public boolean percolates(){
		for(int index=1;index<=this.N;index++){
			if(isopen(this.N, index)&&isFull(this.N,index)){
				return true;
			}
		}
		return false;
	}
	 public static void main(String[] args){
	 	 Percolation percolation = new Percolation(4);
	 	 System.out.println(percolation.percolates());
	 	 percolation.open(1, 1);
	 	 percolation.open(2, 1);
	 	 System.out.println(percolation.percolates());
	 	 percolation.open(3, 1);
	 	 percolation.open(3, 2);
	 	 percolation.open(4,2);
		 System.out.println(percolation.percolates());
	 }
}
