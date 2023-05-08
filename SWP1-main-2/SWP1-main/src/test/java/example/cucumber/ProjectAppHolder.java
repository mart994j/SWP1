package example.cucumber;

import app.ProjectsApp;

public class ProjectAppHolder {
    private ProjectsApp projectsApp;

    public ProjectsApp getProjectsApp() {

    	if (this.projectsApp == null) {
            this.projectsApp = new ProjectsApp();
        }
        return projectsApp;
    }

}
