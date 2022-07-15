package com.eyt.fuzzyclustering;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ClusterVariables {

	private List<Double> _xiList;
	private List<Double> _centroidList;
	private List<Double> _centroidTempList;
	private int _centroidNumber;
	private int _fuzzyIndex;
	private double _stoppingCriterion;
	private List<Double> _uiList;

	public ClusterVariables() {
		this._xiList = Arrays.asList(1.0, 3.0, 5.0, 9.0, 13.0, 15.0, 17.0);
		this._centroidList = Arrays.asList(2.0, 16.0);
		this._centroidTempList = new ArrayList<Double>();
		this._centroidNumber = _centroidList.size();
		this._fuzzyIndex = 2;
		this._stoppingCriterion = 0.1;
		this._uiList = new ArrayList<Double>();
	}

	public ClusterVariables(List<Double> xiList, List<Double> _centroidList, int _fuzzyIndex, double _stoppingCriterion) {
		this._xiList = xiList;
		this._centroidList = _centroidList;
		this._centroidTempList = new ArrayList<Double>();
		this._centroidNumber = _centroidList.size();
		this._fuzzyIndex = _fuzzyIndex;
		this._stoppingCriterion = _stoppingCriterion;
		this._uiList = new ArrayList<Double>();
	}

	public List<Double> getXiList() {
		return this._xiList;
	}

	public void setXiList(List<Double> _xiList) {
		this._xiList = _xiList;
	}

	public List<Double> getCentroidList() {
		return this._centroidList;
	}

	public void setCentroidList(List<Double> _centroidList) {
		this._centroidList = _centroidList;
	}

	public List<Double> getCentroidTempList() {
		return this._centroidTempList;
	}

	public void setCentroidTempList(List<Double> _centroidTempList) {
		this._centroidTempList = _centroidTempList;
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

	public List<Double> getUiList() {
		return this._uiList;
	}

	public void setUiList(List<Double> uiList) {
		this._uiList = uiList;
	}
}
