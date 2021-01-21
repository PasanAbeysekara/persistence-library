package com.thaprobit.resengine.repo.prop;

import com.thaprobit.resengine.dao.PropEvent;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author Tharinda Wickramaarachchi
 * @since 21/Jan/2021 11:16 PM
 */
@RunWith(SpringRunner.class)
@DataJpaTest(properties = {"classpath:application.properties"})
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class PropEventsRepositoryTest
{
	@Autowired
	private PropEventsRepository eventsRepository;

	@Before
	public void setUp()
	{
	}

	@Test
	public void findAllKeys()
	{
		List<PropEvent> all = eventsRepository.findAll();
		System.out.println( all );

		Assert.assertFalse( all.isEmpty() );
	}

	@Test
	public void findAllProperties()
	{
		List<Long> allProperties = eventsRepository.findAllProperties( 2 );

		System.out.println( allProperties );

		Assert.assertFalse( allProperties.isEmpty() );
	}



}