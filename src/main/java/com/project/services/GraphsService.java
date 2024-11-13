package com.project.services;

import com.project.models.GraphsModel;
import com.project.repositories.GraphsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GraphsService {

    @Autowired
    private GraphsRepository graphsRepository;

    public List<GraphsModel> getAllGraphs() {
        return graphsRepository.findAll();
    }

    public Optional<GraphsModel> getGraphById(Integer id) {
        return graphsRepository.findById(id);
    }

    public GraphsModel createGraph(GraphsModel graph) {
        return graphsRepository.save(graph);
    }

    public GraphsModel updateGraph(Integer id, GraphsModel graphDetails) {
        return graphsRepository.findById(id).map(graph -> {
            graph.setTestId(graphDetails.getTestId());
            graph.setType(graphDetails.getType());
            graph.setData(graphDetails.getData());
            return graphsRepository.save(graph);
        }).orElse(null);
    }

    public boolean deleteGraph(Integer id) {
        return graphsRepository.findById(id).map(graph -> {
            graphsRepository.delete(graph);
            return true;
        }).orElse(false);
    }
}
