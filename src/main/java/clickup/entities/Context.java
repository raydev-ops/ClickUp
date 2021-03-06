/*
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jalasoft.
 */

package clickup.entities;

import java.util.HashMap;
import java.util.Map;

/**
 * Contains all objects or variables that wee need save.
 *
 * @author Jesus Menacho
 * @version 1.0
 */
public class Context {
    private Space space;
    private List list;
    private Task task;
    private User user;
    private Project project;
    private Map<String, List> listMap;
    private Map<String, User> userMap;
    private Map<String, Project> projectMap;
    private Import anImport;

    /**
     * Initializes the variables.
     */
    public Context() {
        this.space = new Space();
        this.list = new List();
        this.task = new Task();
        this.project = new Project();
        this.listMap = new HashMap<>();
        this.userMap = new HashMap<>();
        this.projectMap = new HashMap<>();
    }

    /**
     * Gets the space class.
     *
     * @return space class.
     */
    public Space getSpace() {
        return space;
    }

    /**
     * Sets a space class.
     *
     * @param space variable.
     */
    public void setSpace(final Space space) {
        this.space = space;
    }

    /**
     * Getter method.
     *
     * @return a List' object.
     */
    public List getList() {
        return list;
    }

    /**
     * Setter method.
     *
     * @param list that is the object to change its behavior.
     */
    public void setList(final List list) {
        this.list = list;
    }

    /**
     * Getter method.
     *
     * @return a Task instance to be shared across step definitions.
     */
    public Task getTask() {
        return task;
    }

    /**
     * Setter method.
     *
     * @param task A Task instance to be shared across step definitions.
     */
    public void setTask(final Task task) {
        this.task = task;
    }

    /**
     * Getter method.
     * Retrieves the user that this context shares across step definitions.
     *
     * @return an instance of a User class.
     */
    public User getUser() {
        return user;
    }

    /**
     * Setter method.
     *
     * @param user A User instance to be shared across step definitions.
     */
    public void setUser(final User user) {
        this.user = user;
    }

    /**
     * Getter method.
     * Retrieves the ClickUp "Lists" map that this context shares across step definitions.
     *
     * @return a map containing multiple instances of ClickUp "List" entities shared by this class.
     */
    public HashMap<String, List> getListMap() {
        return (HashMap<String, List>) listMap;
    }

    /**
     * Getter method.
     *
     * @return a Project' object.
     */
    public Project getProject() {
        return project;
    }

    /**
     * Setter method.
     *
     * @param listMap a listMap to be copied onto this class' instance.
     */
    public void setListMap(final Map<String, List> listMap) {
        this.listMap = listMap;
    }

    /**
     * Setter method.
     *
     * @param project that is the object to change its behavior.
     */
    public void setProject(final Project project) {
        this.project = project;
    }

    /**
     * Getter method.
     * Retrieves the user map that this context shares across step definitions.
     *
     * @return a map containing multiple instances of the entities shared by this class.
     */
    public HashMap<String, User> getUserMap() {
        return (HashMap<String, User>) userMap;
    }

    /**
     * Setter method.
     *
     * @param userMap a userMap to be copied onto this class' instance.
     */
    public void setUserMap(final Map<String, User> userMap) {
        this.userMap = userMap;
    }

    /**
     * Getter method.
     * Retrieves the user map that this context shares across step definitions.
     *
     * @return a the map containing multiple instances of the entities shared by this class.
     */
    public Map<String, Project> getProjectMap() {
        return projectMap;
    }

    /**
     * Setter method.
     *
     * @param projectMap a userMap to be copied onto this class' instance.
     */

    public void setProjectMap(final Map<String, Project> projectMap) {
        this.projectMap = projectMap;
    }

    public Import getAnImport() {
        return anImport;
    }

    public void setAnImport(Import anImport) {
        this.anImport = anImport;
    }
}
