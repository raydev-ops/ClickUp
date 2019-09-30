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

/**
 * Task class.
 *
 * @author Maday Alcala, Alejandro Sánchez
 * @version 1.0
 */
public class Task {
    private String name;
    private String url;

    /**
     * Getter method.
     *
     * @return a String containing name associated to this task.
     */
    public String getName() {
        return name;
    }

    /**
     * Setter method.
     *
     * @param name a String containing the new value to assign as a new name for this task.
     */
    public void setName(final String name) {
        this.name = name;
    }

    /**
     * Getter method.
     *
     * @return the url assigned to an instance of this class.
     */
    public String getUrl() {
        return url;
    }

    /**
     * Setter method.
     *
     * @param url A integer value to be assigned to an instance of this class.
     */
    public void setUrl(final String url) {
        this.url = url;
    }
}
