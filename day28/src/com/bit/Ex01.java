package com.bit;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.bson.Document;
import org.bson.types.ObjectId;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoIterable;

public class Ex01 {
public static void main(String[] args) {
	byte[] arr= {127,0,0,1};
	InetAddress inet=null;
	ServerAddress addr=null;
	MongoClient client = null;
	
	try {
		inet = InetAddress.getByAddress(arr);
		addr = new ServerAddress(inet);
		
		client = new MongoClient(addr);
//		List<String> dbs = client.getDatabaseNames();
//		for (int i = 0; i < dbs.size(); i++) {
//			System.out.println(dbs.get(i));
//		}
		MongoDatabase db = client.getDatabase("test01");
//		db.createCollection("guest1");
//		db.createCollection("emp");
//		db.createCollection("guest2");
		
		MongoIterable<String> collections = db.listCollectionNames();
		MongoCursor<String> ite = collections.iterator();
		while(ite.hasNext()) {
			System.out.println(ite.next());
		}
		
		MongoCollection coll= db.getCollection("sales");
		long cnt = coll.count();
		Document dojo = new Document();
		dojo.append("price", 5);
		dojo.append("quantity", 10);
		
		
		
		MongoCursor<Document> ite2 =  coll.find().iterator();
		while(ite2.hasNext()) {
			Document docu = ite2.next();
			System.out.println(docu);
			System.out.println("_id:"+docu.get("_id"));
			System.out.println("item:"+docu.get("item"));
			System.out.println("price:"+docu.get("price"));
			System.out.println("quantity:"+docu.get("quantity"));
			System.out.println("date:"+docu.get("date"));
			System.out.println(new SimpleDateFormat("yyyy")
					.format(((Date)docu.get("date"))));
			System.out.println("갯수:"+coll.countDocuments(dojo));
		}
		System.out.println("=============정렬 페이징 후================");
		ite2 =  coll.find().sort(new Document("_id",-1)).skip(3).limit(2).iterator();
		while(ite2.hasNext()) {
			Document docu = ite2.next();
			System.out.println(docu);
			System.out.println("_id:"+docu.get("_id"));
			System.out.println("item:"+docu.get("item"));
			System.out.println("price:"+docu.get("price"));
			System.out.println("quantity:"+docu.get("quantity"));
			System.out.println("date:"+docu.get("date"));
			System.out.println(new SimpleDateFormat("yyyy")
					.format(((Date)docu.get("date"))));
		}
		
		
		MongoCursor<Document> ite3 =  coll.find(dojo).iterator();
		System.out.println("=============================");
		while(ite3.hasNext()) {
			Document docu = ite3.next();
			System.out.println(docu);
			System.out.println("_id:"+docu.get("_id"));
			System.out.println("item:"+docu.get("item"));
			System.out.println("price:"+docu.get("price"));
			System.out.println("quantity:"+docu.get("quantity"));
			System.out.println("date:"+docu.get("date"));
			System.out.println(new SimpleDateFormat("yyyy")
					.format(((Date)docu.get("date"))));
			
			  
			
		}
		
		dojo = new Document();
		dojo.append("_id", new ObjectId("63c7acca708063fc224adf0d"));
		ite3 =  coll.find(dojo).iterator();
		
		System.out.println("=============id 검색===============");
		while(ite3.hasNext()) {
			Document docu = ite3.next();
			System.out.println(docu);
			System.out.println("_id:"+docu.get("_id"));
			System.out.println("item:"+docu.get("item"));
			System.out.println("price:"+docu.get("price"));
			System.out.println("quantity:"+docu.get("quantity"));
			System.out.println("date:"+docu.get("date"));
			System.out.println(new SimpleDateFormat("yyyy")
					.format(((Date)docu.get("date"))));
			
		}
		System.out.println("=============================");
		//위에꺼 자동 간략화
		ite3 =  coll.find(dojo).iterator();
		while(ite3.hasNext()) {
			Document docu = ite3.next();
			Iterator<String> ite4 = docu.keySet().iterator();
			while(ite4.hasNext()) {
				String key = ite4.next();
				System.out.println(key+":"+docu.get(key));
				if(key.equals("date")) {
					System.out.println(new SimpleDateFormat("yyyy")
							.format(((Date)docu.get(key))));
				}
			}
		}
		
		
		client.close();
	} catch (UnknownHostException e) {
		e.printStackTrace();
	}
}
}
