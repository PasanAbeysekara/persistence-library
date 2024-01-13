package com.thaprobit.resengine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @author Tharinda Wickramaarachchi
 * @since 21/Jan/2021 11:39 PM
 */

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class PersistenceLib
{
	public static void main( String[] args )
	{
		SpringApplication.run( PersistenceLib.class, args );
	}
}
