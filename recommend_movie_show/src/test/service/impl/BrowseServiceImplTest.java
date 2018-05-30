package service.impl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BrowseServiceImplTest {

    private BrowseServiceImpl browseService;

    @Before
    public void setup(){
        browseService = new BrowseServiceImpl();
    }
    @Test
    public void getBrowseByUserId() {
        Assert.assertNotNull(browseService.getBrowseByUserId(19));
    }
}