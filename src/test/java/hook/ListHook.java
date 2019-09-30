/*
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jalasoft.
 */

package hook;

import clickup.entities.Context;
import clickup.ui.pages.ListMenu;
import cucumber.api.java.After;

/**
 * ListHook class.
 *
 * @author Maday Alcala
 * @version 1.0
 */
public class ListHook {
    private Context context;

    /**
     * Allows to receive the variable context.
     *
     * @param context - set the class context.
     */
    public ListHook(final Context context) {
        this.context = context;
    }

    /**
     * Deletes a list.
     */
    @After(order = 2, value = "@deleteList")
    public void deleteList() {
        ListMenu listPage = new ListMenu();
        listPage.deleteList(context.getList().getName());
    }
}
