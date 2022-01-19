package at.aau.ue5.bsp1;

import at.aau.ue5.bsp1.dao.CustomerDaoTest;
import at.aau.ue5.bsp1.dao.InvoiceDaoTest;
import at.aau.ue5.bsp1.dao.ProductDaoTest;
import at.aau.ue5.bsp1.service.InvoiceServiceImplIntegrationTest;
import at.aau.ue5.bsp1.service.InvoiceServiceImplUnitTest;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.runner.RunWith;


@RunWith(JUnitPlatform.class)
@SelectClasses({CustomerDaoTest.class, InvoiceDaoTest.class, ProductDaoTest.class, InvoiceServiceImplIntegrationTest.class, InvoiceServiceImplUnitTest.class})
public class AllTestsEx1 {

}
