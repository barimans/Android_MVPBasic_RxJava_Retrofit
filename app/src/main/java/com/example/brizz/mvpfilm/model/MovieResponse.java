package com.example.brizz.mvpfilm.model;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MovieResponse{

	@SerializedName("results")
	@Expose
	private List<Results> results = null;
	@SerializedName("page")
	@Expose
	private Integer page;
	@SerializedName("total_results")
	@Expose
	private Integer totalResults;
	@SerializedName("dates")
	@Expose
	private Dates dates;
	@SerializedName("total_pages")
	@Expose
	private Integer totalPages;

	/**
	 * No args constructor for use in serialization
	 *
	 */
	public MovieResponse() {
	}

	/**
	 *
	 * @param results
	 * @param dates
	 * @param totalResults
	 * @param page
	 * @param totalPages
	 */
	public MovieResponse(List<Results> results, Integer page, Integer totalResults, Dates dates, Integer totalPages) {
		super();
		this.results = results;
		this.page = page;
		this.totalResults = totalResults;
		this.dates = dates;
		this.totalPages = totalPages;
	}

	public List<Results> getResults() {
		return results;
	}

	public void setResults(List<Results> results) {
		this.results = results;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getTotalResults() {
		return totalResults;
	}

	public void setTotalResults(Integer totalResults) {
		this.totalResults = totalResults;
	}

	public Dates getDates() {
		return dates;
	}

	public void setDates(Dates dates) {
		this.dates = dates;
	}

	public Integer getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(Integer totalPages) {
		this.totalPages = totalPages;
	}
}