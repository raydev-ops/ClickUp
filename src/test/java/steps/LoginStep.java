/*
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jalasoft.
 */

package steps;

import clickup.entities.Context;
import clickup.ui.PageTransporter;
import clickup.ui.pages.ApplicationPage;
import clickup.ui.pages.HomeModal;
import clickup.ui.pages.LoginPage;
import core.utils.CredentialDeserializer;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.commons.codec.DecoderException;
import org.testng.Assert;

import java.io.IOException;
import java.security.GeneralSecurityException;

/**
 * LoginStep class.
 *
 * @author Jesus Menacho
 * @version 1.0
 */
public class LoginStep {
    private Context context;
    private LoginPage loginPage;
    private ApplicationPage applicationPage;

    /**
     * Constructor for dependency injection.
     *
     * @param context A Context instance to be instantiated by pico-container library.
     */
    public LoginStep(final Context context) {
        this.context = context;
    }

    /**
     * Navigates through pages.
     *
     * @param login represents the specific page.
     */
    @Given("^the user goes to (.*) page$")
    public void navigatePage(final String login) {
        PageTransporter.goToUrl(login);
    }

    /**
     * Fills email and password in the login page.
     *
     * @param userType represents the type of user, i.e. user or admin.
     * @throws GeneralSecurityException .
     * @throws DecoderException         .
     * @throws IOException              .
     */
    @When("the (.*) fills the form with email and password")
    public void fillInLoginForm(final String userType) throws GeneralSecurityException, DecoderException,
            IOException {
        loginPage = new LoginPage();
        context.setUser(CredentialDeserializer.getInstance().getUser(userType));
        context.getUserMap().put(userType, context.getUser());
        applicationPage = loginPage.authenticate(context.getUserMap().get(userType).getEmail(),
                context.getUserMap().get(userType).getPassword());
    }

    /**
     * Fills email and password in the login page.
     *
     * @param userType    represents the type of user, i.e. user or admin.
     * @throws GeneralSecurityException .
     * @throws DecoderException .
     * @throws IOException .
     */
    @When("the user is logged with (.*) credentials")
    public void fillingFormAut(final String userType) throws GeneralSecurityException, DecoderException, IOException {
        loginPage = new LoginPage();
        context.setUser(CredentialDeserializer.getInstance().getUser(userType));
        context.getUserMap().put(userType, context.getUser());
        loginPage.authenticate(context.getUserMap().get(userType).getEmail(), context.getUserMap().get(userType)
                .getPassword());
    }

    /**
     * Verifies login information.
     */
    @Then("Username should appear in the panel")
    public void usernameShouldAppear() {
        HomeModal homeModal;
        homeModal = applicationPage.getSideMenu().displayUserMenu();
        String actual = context.getUser().getFullName();
        String expected = homeModal.getTitleName();
        Assert.assertEquals(expected, actual, context.getUser().getFullName() + "was unable to log into the system!");
    }

    /**
     * Logs a user into the application.
     *
     * @param userType a String containing the user type that the task is going to assigned to.
     * @throws GeneralSecurityException .
     * @throws IOException              .
     * @throws DecoderException         .
     */
    @When("the user logs in as (.*)")
    public void userLogsIn(final String userType) throws GeneralSecurityException, IOException, DecoderException {
        String login = PageTransporter.getMap().get("login");
        PageTransporter.goToUrl(login);
        fillInLoginForm(userType);
        applicationPage.getSideMenu().waitForPageLoading();
    }
}
