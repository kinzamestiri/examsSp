package com.example.assuranceexamen.services;

import com.example.assuranceexamen.entities.Project;
import com.example.assuranceexamen.entities.Sprint;
import com.example.assuranceexamen.entities.User;
import com.example.assuranceexamen.repositories.ProjectRepo;
import com.example.assuranceexamen.repositories.SprintRepo;
import com.example.assuranceexamen.repositories.UserRepo;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class ProjectService implements IProjectService{

    ProjectRepo projectRepo;
    UserRepo userRepo;
    SprintRepo sprintRepo;

    @Override
    public Project addProject(Project project){
        for (Sprint sprint : project.getSprints()) {
            sprint.setProject(project);
        }
        return projectRepo.save(project);
    }

    @Override
    public void assignProjectToDeveloper(int projectId, int devId) {
        User developer = userRepo.findUserByIdAndRoleDeveloper(devId);
        Project project = projectRepo.findById(projectId).orElse(null);

        if (developer != null && project != null) {
            project.getUsers().add(developer);
            developer.getProjects().add(project);

            project = projectRepo.save(project);
            developer = userRepo.save(developer);
        } else {
            throw new IllegalArgumentException("Développeur ou projet non trouvé.");
        }

    }

    @Override
    public void assignProjectToScrumMaster(int projectId, String fName, String lName){
        Project project = projectRepo.findById(projectId).orElse(null);
        User user = userRepo.findScrumMaster(fName, lName);

        if (user != null && project != null) {
            project.getUsers().add(user);
            user.getProjectSet().add(project);

            project = projectRepo.save(project);
            user = userRepo.save(user);
        } else {
            throw new IllegalArgumentException("Développeur ou projet non trouvé.");
        }

    }

    @Override
    public List<Project> getProjectsByScrumMaster(String fName, String lName){
       return  projectRepo.findRdvByNames(fName,lName);

    }

    @Override
    public void addSprintAndAssignToProject(Sprint sprint, int idProject){
        Project p = projectRepo.findById(idProject).orElse(null);
        sprint.setProject(p);
        sprintRepo.save(sprint);
    }

    @Scheduled(fixedRate = 30000000) // Exécuter toutes les 30 secondes
    public void getProjectsCurrentSprints() {
        LocalDate dateSysteme = LocalDate.now();
        List<Project> projectList = projectRepo.findBySprint(dateSysteme);
        for (Project p : projectList) {

                log.info("projet: " + p.getTitle());

        }
    }


}
