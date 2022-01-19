package at.aau.ue5.bsp1.dao;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
@SelectClasses({CustomerDaoTest.class, InvoiceDaoTest.class, ProductDaoTest.class})
public class DaoTests {

}
