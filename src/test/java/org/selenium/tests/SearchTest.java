package org.selenium.tests;

import org.selenium.base.BaseClass;
import org.selenium.pageObjects.StorePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchTest extends BaseClass {
    @Test
    public void searchWithPartialMatch() throws IllegalAccessException {
        StorePage storePage = new StorePage(getDriver()).
                loadStorePage().
                searchObject();
        Assert.assertEquals(storePage.getTitle(), "Search results: “Blue”");

    }
}
