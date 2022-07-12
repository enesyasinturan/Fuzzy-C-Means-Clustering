package com.eyt.fuzzyclustering;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ClusterVariables {

	private List<Integer> _xiList;
	private List<Integer> _centroidList;
	private int _centroidNumber;
	private int _fuzzyIndex;
	private double _stoppingCriterion;

	ClusterVariables() {
		this._xiList = Arrays.asList(1, 3, 5, 9, 13, 15, 17);
		this._centroidList = Arrays.asList(2, 16);
		this._centroidNumber = 2;
		this._fuzzyIndex = 2;
		this._stoppingCriterion = 0.1;
	}

	ClusterVariables(ArrayList<Integer> xiList, ArrayList<Integer> _centroidList,
			int _centroidNumber, int _fuzzyIndex, double _stoppingCriterion) {
		this._xiList = xiList;
		this._centroidList = _centroidList;
		this._centroidNumber = _centroidNumber;
		this._fuzzyIndex = _fuzzyIndex;
		this._stoppingCriterion = _stoppingCriterion;
	}

	public List<Integer> getXiList() {
		return this._xiList;
	}

	public void setXiList(List<Integer> _xiList) {
		this._xiList = _xiList;
	}

	public List<Integer> getCentroidList() {
		return this._centroidList;
	}

	public void setCentroidList(List<Integer> _centroidList) {
		this._centroidList = _centroidList;
	}

	public int getCentroidNumber() {
		return this._centroidNumber;
	}

	public void setCentroidNumber(int _centroidNumber) {
		this._centroidNumber = _centroidNumber;
	}

	public int getFuzzyIndex() {
		return this._fuzzyIndex;
	}

	public void setFuzzyIndex(int _fuzzyIndex) {
		this._fuzzyIndex = _fuzzyIndex;
	}

	public double getStoppingCriterion() {
		return this._stoppingCriterion;
	}

	public void setStoppingCriterion(double _stoppingCriterion) {
		this._stoppingCriterion = _stoppingCriterion;
	}
}
