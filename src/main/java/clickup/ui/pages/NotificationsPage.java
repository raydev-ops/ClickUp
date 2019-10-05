/*
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jalasoft.
 */

package clickup.ui.pages;

import clickup.ui.PageTransporter;
import core.utils.Actions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

/**
 * Notifications Page Object Model.
 *
 * @author Alejandro Sánchez Luizaga
 * @version 1.0
 */
public class NotificationsPage extends ApplicationBasePage {
    private static final String TASK_ANCHOR = "a[href='%s']";

    /**
     * Returns a webElement associated to a hyperlink.
     *
     * @param hyperLink a String containing a url address.
     * @return WebElement pointing to a hyperlink listed in the page.
     */
    private WebElement getAnchorElementByUrl(final String hyperLink) {
        return getDriver().findElement(By.cssSelector(String.format(TASK_ANCHOR, hyperLink)));
    }

    /**
     * Returns true if the task is listed in the page.
     *
     * @param taskId The id of a partiuclar Task.
     * @return true if the url is listed in the page.
     */
    private boolean isTaskByIdPresent(final String taskId) {
        List<WebElement> resultList = new ArrayList<WebElement>();
        String hyperLink = PageTransporter.getBaseUrl().concat(PageTransporter.map.get("task").concat(taskId));
        resultList = getDriver().findElements(By.cssSelector(String.format(TASK_ANCHOR, hyperLink)));
        return (resultList.size() == 1);
    }

    /**
     * Searches for a task by its id and retrieves its Name.
     *
     * @param taskId
     * @return
     */
    public String searchTaskByIdAndGetName(final String taskId) {
        String hyperLink = PageTransporter.getBaseUrl().concat(PageTransporter.map.get("task").concat(taskId));
        return Actions.getText(getAnchorElementByUrl(hyperLink));
    }
}
