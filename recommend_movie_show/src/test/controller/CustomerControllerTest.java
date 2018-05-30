package controller;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring/applicationContext-*xml"})

@WebAppConfiguration
public class CustomerControllerTest extends TestCase {

    private CustomerController customerController;

    @Before
    public void setup(){
        customerController = new CustomerController();
    }

    @Test
    public void log() {
    }

    @Test
    public void checkData() {
    }

    @Test
    public void register() {
    }

    @Test
    public void selectedMovie() {
    }

    @Test
    public void login() {
    }

    @Test
    public void pagelogout() {
    }

    @Test
    public void checkDataBoth() {
    }

    @Test
    public void updateUser() {
    }

    @Test
    public void getUserById() {
    }
}