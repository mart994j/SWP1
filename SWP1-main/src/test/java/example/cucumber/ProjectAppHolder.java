package example.cucumber;

import app.ProjectApp;

public class ProjectAppHolder {
    private ProjectApp projectApp;

    public ProjectApp getProjectsApp() {

    	if (this.projectApp == null) {
            this.projectApp = new ProjectApp();
        }
        return projectApp;
    }

}
