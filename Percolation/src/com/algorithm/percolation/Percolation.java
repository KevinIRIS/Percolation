package com.algorithm.percolation;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;


public class Percolation {
	private WeightedQuickUnionUF grid = null;
	boolean[] state =null;
	private int N ;
	public Percolation(int N){
		this.N = N;
		if(this.N>0){
			int size = this.N * this.N +2;
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
		if((i<=0||i>this.N)||(j<0||j>this.N))
			return false;
		else
			return true;
	}
	public void open(int i , int j){
		if(isInGrid(i, j)){
			/*
			 * 在范围内
			 */
		}else
			throw new IndexOutOfBoundsException("Index out of bound!");
	}
	public boolean isopen(int i ,int j){
		if(isInGrid(i, j)){
			return true;
		}else
			throw new IndexOutOfBoundsException();
	}
	public boolean isFull(int i, int j){  //如果这个site 可以通过邻居节点连接到顶端 我们就说他是Full
		return false;
	}
	public boolean percolates(){
		return false;
	}
	 public static void main(String[] args){
	 	 
		 
	 }
}
