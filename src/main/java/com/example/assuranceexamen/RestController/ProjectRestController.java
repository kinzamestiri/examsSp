package com.example.assuranceexamen.RestController;

import com.example.assuranceexamen.entities.Project;
import com.example.assuranceexamen.entities.Sprint;
import com.example.assuranceexamen.services.IProjectService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("project")
public class ProjectRestController {
    IProjectService iProjectService;
    @PostMapping("ajouterproject")
    public Project addProject (@RequestBody Project project){
        return  iProjectService.addProject(project);
    }

    @PutMapping("affecterprojetadvp/{projectId}/{devId}")
    public void assignProjectToDeveloper (@PathVariable("projectId") int projectId,@PathVariable("devId") int devId){
        iProjectService.assignProjectToDeveloper(projectId, devId);
    }

    @PutMapping("affecterprojetadvp/{projectId}/{fName}/{lName}")
    public void assignProjectToScrumMaster(@PathVariable("projectId") int projectId,@PathVariable("fName") String fName,@PathVariable("lName") String lName){
        iProjectService.assignProjectToScrumMaster(projectId,fName,lName);
    }

    @GetMapping("afficher/{fName}/{lName}")
    public List<Project> getProjectsByScrumMaster(@PathVariable("fName") String fName,@PathVariable("lName") String lName){
        return iProjectService.getProjectsByScrumMaster(fName,lName);
    }

    @PostMapping("ajouterSprinttoProject/{idProject}")
    public void addSprintAndAssignToProject(@RequestBody Sprint sprint,@PathVariable("idProject") int idProject){
        iProjectService.addSprintAndAssignToProject(sprint,idProject);
    }
}
