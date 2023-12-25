package com.example.assuranceexamen.services;

import com.example.assuranceexamen.entities.Project;
import com.example.assuranceexamen.entities.Sprint;

import java.util.List;

public interface IProjectService {
    Project addProject(Project project);

    void assignProjectToDeveloper(int projectId, int devId);

    void assignProjectToScrumMaster(int projectId, String fName, String lName);

    List<Project> getProjectsByScrumMaster(String fName, String lName);

    void addSprintAndAssignToProject(Sprint sprint, int idProject);
}
