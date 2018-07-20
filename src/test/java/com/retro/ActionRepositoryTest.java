package com.retro;

import com.retro.core.retro.model.Action;
import com.retro.core.retro.repository.ActionRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace=AutoConfigureTestDatabase.Replace.NONE)
public class ActionRepositoryTest {

    @Autowired
    public ActionRepository actionRepository;

    @Test
    public void testSave(){
        //given
        Action action = new Action();
        action.setRetroKey("I14");
        action.setActionContent("test content");
        //when
        actionRepository.save(action);
        //then
        Assert.assertEquals(1, actionRepository.findAll().size());
    }
}
