package service.impl;

import org.junit.Assert;
import org.junit.Test;


public class AlsServiceImplTest {

    @Test
    public void selectAlsMoviesByUserId() {
        AlsServiceImpl alsService = new AlsServiceImpl();
        Assert.assertNotNull(alsService.selectAlsMoviesByUserId(1));
    }
}