package com.hackerrank.sample.service;

import java.util.List;

import com.hackerrank.sample.model.Model;

public interface ModelService {
	void deleteAllModels();

	void deleteModelById(Long id);

	void createModel(Model model);

	Model getModelById(Long id);

	List<Model> getAllModels();
}
