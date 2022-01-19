package at.aau.ue5.bsp1.service;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
@SelectClasses({ InvoiceServiceImplIntegrationTest.class, InvoiceServiceImplUnitTest.class })
public class InvoiceServiceTests {

}
