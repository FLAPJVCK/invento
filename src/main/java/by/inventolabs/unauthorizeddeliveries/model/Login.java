package by.inventolabs.unauthorizeddeliveries.model;

import com.opencsv.bean.CsvBindByName;

import java.io.Serializable;
import java.util.Objects;

public class Login implements Serializable {
    @CsvBindByName
    private String application;
    @CsvBindByName
    private String appAccountName;
    @CsvBindByName
    private String isActive;
    @CsvBindByName
    private String jobTitle;
    @CsvBindByName
    private String department;

    public String getApplication() {
        return application;
    }

    public void setApplication(String application) {
        this.application = application;
    }

    public String getAppAccountName() {
        return appAccountName;
    }

    public void setAppAccountName(String appAccountName) {
        this.appAccountName = appAccountName;
    }

    public String getIsActive() {
        return isActive;
    }

    public void setIsActive(String isActive) {
        this.isActive = isActive;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Login login = (Login) o;
        return Objects.equals(application, login.application) && Objects.equals(appAccountName, login.appAccountName) && Objects.equals(isActive, login.isActive) && Objects.equals(jobTitle, login.jobTitle) && Objects.equals(department, login.department);
    }

    @Override
    public int hashCode() {
        return Objects.hash(application, appAccountName, isActive, jobTitle, department);
    }
}
