package com.lamp.ledis.protocol;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList ;
import java.util.List;

import com.lamp.ledis.create.KeyCreate;
import com.lamp.ledis.serialize.JsonDeToSerialize ;

/**
 * 每个comm 
 * @author laohu
 *
 */
public class AgreementPretreatment {

	private static final List<ListReferenceAgreementPretreatment>  REFERNCE_LIST = new ArrayList<>( 10 );
	
	
	static {
		REFERNCE_LIST.add( new OneListReferenceAgreementPretreatment( ) );
		REFERNCE_LIST.add( new TwoListReferenceAgreementPretreatment( ) );
		REFERNCE_LIST.add( new ThreeListReferenceAgreementPretreatment( ) );
		REFERNCE_LIST.add( new FourListReferenceAgreementPretreatment( ) );
		REFERNCE_LIST.add( new FiveListReferenceAgreementPretreatment( ) );
		REFERNCE_LIST.add( new SixListReferenceAgreementPretreatment( ) );
		REFERNCE_LIST.add( new SevenListReferenceAgreementPretreatment( ) );
		REFERNCE_LIST.add( new EightListReferenceAgreementPretreatment( ) );
		REFERNCE_LIST.add( new NineListReferenceAgreementPretreatment( ) );
	}
	
	private byte[ ] perteatment;
	private boolean boo;
	private int length;
	
	
	public AgreementPretreatment( int length , String comman ) {
		this( length , comman , true );
	}

	public AgreementPretreatment( int length , String comman , boolean boo ) {
		this.length = length;
		if ( boo ) {
			this.perteatment = ProtocolUtil.getCommanByte( length , comman );
		} else {
			this.perteatment = ProtocolUtil.getCommanByte( comman );
		}
		this.boo = boo;
	}
	
	public int getLength(){
		return this.length;
	}

	public void perteatmentOut( OutputStream os , int length ) throws IOException {
		if ( !boo ) {

		}
		os.write( perteatment );
	}


	
	public <T> void referenceAgreementPretreatment(OutputStream os , List<T> comman , List<T> data , KeyCreate< T > mapKey){
		
	}
	
	public final static void OneReferenceAgreementPretreatment( OutputStream os , String one ) throws IOException {
		ProtocolUtil.write( os , one );
	}

	public final static void TwoReferenceAgreementPretreatment( OutputStream os , String one , String two )
			throws IOException {
		ProtocolUtil.write( os , one );
		ProtocolUtil.write( os , two );
	}

	public final static void ThreeReferenceAgreementPretreatment( OutputStream os , String one , String two ,
			String three ) throws IOException {
		ProtocolUtil.write( os , one );
		ProtocolUtil.write( os , two );
		ProtocolUtil.write( os , three );
	}

	public final static void FourReferenceAgreementPretreatment( OutputStream os , String one , String two ,
			String three , String four ) throws IOException {
		ProtocolUtil.write( os , one );
		ProtocolUtil.write( os , two );
		ProtocolUtil.write( os , three );
		ProtocolUtil.write( os , four );
	}

	public final static void ListReferenceAgreementPretreatment( OutputStream os ,  List< DataConversion > list , int num ) throws IOException {
			REFERNCE_LIST.get( --num ).execute( os , list );
	}

	public final static void ListReferenceAgreementPretreatment( OutputStream os , List< DataConversion > list , List<?> objectList ,int num) throws IOException{
		ProtocolUtil.write( os , list.get( 0 ).getWriteByteBuffer( ) );
		int i = objectList.size( );
		for( ; ; ){
			ProtocolUtil.write( os , JsonDeToSerialize.SERIALIZE_DEFAULT.execute( objectList.get( --i) ) );
			if( i == 0){
				break;
			}
		}
		if( num != 0)
			REFERNCE_LIST.get( num ).execute( os , list );
	}
	
	public final static void HashReferenceAgreementPretreatment( OutputStream os , List< DataConversion > list , List<?> objectList , KeyCreate<  Object > keyCreate) throws IOException{
		ProtocolUtil.write( os , list.get( 0 ).getWriteByteBuffer( ) );
		int i = objectList.size( );
		Object o ;
		for( ; ; ){
			o = objectList.get( -- i );
			ProtocolUtil.write( os , keyCreate.getKeySuffixByteAarry( o ) );
			ProtocolUtil.write( os , JsonDeToSerialize.SERIALIZE_DEFAULT.execute( o ) );
			if( i == 0){
				break;
			}
		}
	}
	
	
	interface ListReferenceAgreementPretreatment{
		
		void execute(OutputStream os ,  List< DataConversion > list) throws IOException;
	}
	
	static class OneListReferenceAgreementPretreatment implements ListReferenceAgreementPretreatment{

		@Override
		public void execute( OutputStream os , List< DataConversion > list ) throws IOException {
			ProtocolUtil.write( os , list.get( 0 ).getWriteByteBuffer( ) );
			
		}
		
	}
	static class TwoListReferenceAgreementPretreatment implements ListReferenceAgreementPretreatment{

		@Override
		public void execute( OutputStream os , List< DataConversion > list ) throws IOException {
			ProtocolUtil.write( os , list.get( 0 ).getWriteByteBuffer( ) );
			ProtocolUtil.write( os , list.get( 1 ).getWriteByteBuffer( ) );
		}
	}
	
	static class ThreeListReferenceAgreementPretreatment implements ListReferenceAgreementPretreatment{

		@Override
		public void execute( OutputStream os , List< DataConversion > list ) throws IOException {
			ProtocolUtil.write( os , list.get( 0 ).getWriteByteBuffer( ) );
			ProtocolUtil.write( os , list.get( 1 ).getWriteByteBuffer( ) );
			ProtocolUtil.write( os , list.get( 2 ).getWriteByteBuffer( ) );
		}
	}
	
	
	static class FourListReferenceAgreementPretreatment implements ListReferenceAgreementPretreatment{

		@Override
		public void execute( OutputStream os , List< DataConversion > list ) throws IOException {
			ProtocolUtil.write( os , list.get( 0 ).getWriteByteBuffer( ) );
			ProtocolUtil.write( os , list.get( 1 ).getWriteByteBuffer( ) );
			ProtocolUtil.write( os , list.get( 2 ).getWriteByteBuffer( ) );
			ProtocolUtil.write( os , list.get( 3 ).getWriteByteBuffer( ) );
		}
	}
	
	static class FiveListReferenceAgreementPretreatment implements ListReferenceAgreementPretreatment{

		@Override
		public void execute( OutputStream os , List< DataConversion > list ) throws IOException {
			ProtocolUtil.write( os , list.get( 0 ).getWriteByteBuffer( ) );
			ProtocolUtil.write( os , list.get( 1 ).getWriteByteBuffer( ) );
			ProtocolUtil.write( os , list.get( 2 ).getWriteByteBuffer( ) );
			ProtocolUtil.write( os , list.get( 3 ).getWriteByteBuffer( ) );
			ProtocolUtil.write( os , list.get( 4 ).getWriteByteBuffer( ) );
		}
	}
	
	
	static class SixListReferenceAgreementPretreatment implements ListReferenceAgreementPretreatment{

		@Override
		public void execute( OutputStream os , List< DataConversion > list ) throws IOException {
			ProtocolUtil.write( os , list.get( 0 ).getWriteByteBuffer( ) );
			ProtocolUtil.write( os , list.get( 1 ).getWriteByteBuffer( ) );
			ProtocolUtil.write( os , list.get( 2 ).getWriteByteBuffer( ) );
			ProtocolUtil.write( os , list.get( 3 ).getWriteByteBuffer( ) );
			ProtocolUtil.write( os , list.get( 4 ).getWriteByteBuffer( ) );
			ProtocolUtil.write( os , list.get( 5 ).getWriteByteBuffer( ) );
		}
	}
	
	static class SevenListReferenceAgreementPretreatment implements ListReferenceAgreementPretreatment{

		@Override
		public void execute( OutputStream os , List< DataConversion > list ) throws IOException {
			ProtocolUtil.write( os , list.get( 0 ).getWriteByteBuffer( ) );
			ProtocolUtil.write( os , list.get( 1 ).getWriteByteBuffer( ) );
			ProtocolUtil.write( os , list.get( 2 ).getWriteByteBuffer( ) );
			ProtocolUtil.write( os , list.get( 3 ).getWriteByteBuffer( ) );
			ProtocolUtil.write( os , list.get( 4 ).getWriteByteBuffer( ) );
			ProtocolUtil.write( os , list.get( 5 ).getWriteByteBuffer( ) );
			ProtocolUtil.write( os , list.get( 6 ).getWriteByteBuffer( ) );
		}
	}
	
	
	static class EightListReferenceAgreementPretreatment implements ListReferenceAgreementPretreatment{

		@Override
		public void execute( OutputStream os , List< DataConversion > list ) throws IOException {
			ProtocolUtil.write( os , list.get( 0 ).getWriteByteBuffer( ) );
			ProtocolUtil.write( os , list.get( 1 ).getWriteByteBuffer( ) );
			ProtocolUtil.write( os , list.get( 2 ).getWriteByteBuffer( ) );
			ProtocolUtil.write( os , list.get( 3 ).getWriteByteBuffer( ) );
			ProtocolUtil.write( os , list.get( 4 ).getWriteByteBuffer( ) );
			ProtocolUtil.write( os , list.get( 5 ).getWriteByteBuffer( ) );
			ProtocolUtil.write( os , list.get( 6 ).getWriteByteBuffer( ) );
			ProtocolUtil.write( os , list.get( 7 ).getWriteByteBuffer( ) );
		}
	}
	
	static class NineListReferenceAgreementPretreatment implements ListReferenceAgreementPretreatment{

		@Override
		public void execute( OutputStream os , List< DataConversion > list ) throws IOException {
			ProtocolUtil.write( os , list.get( 0 ).getWriteByteBuffer( ) );
			ProtocolUtil.write( os , list.get( 1 ).getWriteByteBuffer( ) );
			ProtocolUtil.write( os , list.get( 2 ).getWriteByteBuffer( ) );
			ProtocolUtil.write( os , list.get( 3 ).getWriteByteBuffer( ) );
			ProtocolUtil.write( os , list.get( 4 ).getWriteByteBuffer( ) );
			ProtocolUtil.write( os , list.get( 5 ).getWriteByteBuffer( ) );
			ProtocolUtil.write( os , list.get( 6 ).getWriteByteBuffer( ) );
			ProtocolUtil.write( os , list.get( 7 ).getWriteByteBuffer( ) );
			ProtocolUtil.write( os , list.get( 8 ).getWriteByteBuffer( ) );
		}
	}
}