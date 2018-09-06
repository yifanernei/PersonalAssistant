package xyz.yifanernei.personalassistant.Enity;

import java.util.Date;
import java.util.List;

public class ProjectInfo {
    String id;
    String name;
    UserInfo cuser;
    UserInfo manager;
    ProjectStatus status;

    public Date getCdate() {
        return cdate;
    }

    public void setCdate(Date cdate) {
        this.cdate = cdate;
    }

    Date cdate;

    public List<ProjectItemInfo> getItems() {
        return items;
    }

    public void setItems(List<ProjectItemInfo> items) {
        this.items = items;
    }

    List<ProjectItemInfo> items;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UserInfo getCuser() {
        return cuser;
    }

    public void setCuser(UserInfo cuser) {
        this.cuser = cuser;
    }

    public UserInfo getManager() {
        return manager;
    }

    public void setManager(UserInfo manager) {
        this.manager = manager;
    }

    public ProjectStatus getStatus() {
        return status;
    }

    public void setStatus(ProjectStatus status) {
        this.status = status;
    }
}
