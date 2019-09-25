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

import clickup.ui.BasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Saves some element to the page clickUp.
 *
 * @author Jesus Menacho
 * @version 1.0
 */
public class SpacePage extends BasePage {
    static final int BUTTONCLICK = 7;
    @FindBy(css = ".cu2-project-list-bar__add-icon > .ng-star-inserted")
    private WebElement addNewButton;

    @FindBy(css = ".cu-form__input")
    private WebElement inputNameSpaceTextBox;

    @FindBy(css = ".cu-btn")
    private WebElement nextButton;

    @FindBy(css = ".cu-avatar-container > .cu-avatar")
    private WebElement spaceBarButton;

    @FindBy(xpath = "//div[contains(@class, 'cu-user-settings-menu__link cu-user-settings-menu__link_logout')]")
    private WebElement logOutButton;

    @FindBy(xpath = "By.xpath(\"//body\")")
    private WebElement bodyPage;

    /**
     * Creates a new space.
     *
     * @param nameSpace String parameter.
     */
    public void addNewSpace(final String nameSpace) {
        addNewButton.click();
        inputNameSpaceTextBox.sendKeys(nameSpace);
        for (int buttonPresses = 0; buttonPresses < BUTTONCLICK; buttonPresses++) {
            nextButton.click();
        }
    }

    /**
     * Finds name space in the page.
     *
     * @param nameSpace parameter string.
     * @return boolean result.
     */
    public boolean isFoundNameSpace(final String nameSpace) {
        return getDriver().getPageSource().contains(nameSpace);
    }

    /**
     * Lets log out from the main page.
     */
    public void logOut() {
        spaceBarButton.click();
        logOutButton.click();
    }
}
