package fr.treeptik.springsample.test;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.treeptik.springsample.dao.impl.ClientJDBCDAO;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
public class TestClientJDBCDAO {
	@Autowired
    private ClientJDBCDAO clientJDBCDAO;

    @Test    
    public void testSaveClientOk(){
    }
    

}
