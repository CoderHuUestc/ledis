package com.lamp.ledis.net;

import org.junit.Before;
import org.junit.Test;

import com.lamp.ledis.annotation.OperationEntity;
import com.lamp.ledis.commands.HashCommands;
import com.lamp.ledis.commands.HashCommandsImlp;
import com.lamp.ledis.commands.ListCommands;
import com.lamp.ledis.commands.ListCommandsImlp;
import com.lamp.ledis.commands.StringCommands;
import com.lamp.ledis.commands.StringCommandsImlp;
import com.lamp.ledis.entity.TestEntity;
import com.lamp.ledis.utils.KeyCreateUtils;

public class ConnectionFactoryTest {

	protected StringCommands< TestEntity > sc;

	protected ListCommands< TestEntity > lc;

	protected HashCommands< Integer , TestEntity > hc;

	@SuppressWarnings ( "unchecked" )
	@Before
	public void bo( ) {
		try {
			sc = new StringCommandsImlp< TestEntity >( null , null , KeyCreateUtils.getInstance( )
					.createKeyCreate( "com.lamp.ledis.entity.TestEntity" , "id" , null , null , null ) );

			OperationEntity oe = new OperationEntity( );
			oe.setClazz( TestEntity.class );
			oe.setKey( "id" );
			oe.setMapKey( "appId" );

			hc = new HashCommandsImlp< Integer , TestEntity >( null , null ,
					KeyCreateUtils.getInstance( ).createKeyCreate( oe ) );
			lc = new ListCommandsImlp< TestEntity >( null , null , KeyCreateUtils.getInstance( )
					.createKeyCreate( "com.lamp.ledis.entity.TestEntity" , "id" , null , null , null ) );

			System.out.println( " commands init succer" );
		} catch ( Exception e ) {
			// TODO 自动生成的 catch 块
			e.printStackTrace( );
		}
	}

	@Before
	public void info( ) {
		ConnectionFactory.getInstance( ).init( );
	}

	@Test
	public void connectionTest( ) {

	}

}
