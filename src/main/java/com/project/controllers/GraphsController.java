package com.project.controllers;

import com.project.models.GraphsModel;
import com.project.services.GraphsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/graphs")
public class GraphsController {

    @Autowired
    private GraphsService graphService;

    @GetMapping
    public List<GraphsModel> getAllGraphs() {
        return graphService.getAllGraphs();
    }

    @GetMapping("/{id}")
    public ResponseEntity<GraphsModel> getGraphById(@PathVariable Integer id) {
        return graphService.getGraphById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public GraphsModel createGraph(@RequestBody GraphsModel graph) {
        return graphService.createGraph(graph);
    }

    @PutMapping("/{id}")
    public ResponseEntity<GraphsModel> updateGraph(@PathVariable Integer id, @RequestBody GraphsModel graph) {
        GraphsModel updatedGraph = graphService.updateGraph(id, graph);
        return updatedGraph != null ? ResponseEntity.ok(updatedGraph) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGraph(@PathVariable Integer id) {
        if (graphService.deleteGraph(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
