package com.bit;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.List;

import javax.xml.bind.DataBindingException;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;
import com.mongodb.client.*;
import com.mongodb.client.result.DeleteResult;

public class Ex02 {
public static void main(String[] args) {
	String addr="127.0.0.1";
	MongoClient client=null;
	try {
		client = new MongoClient(addr);
		MongoDatabase db = client.getDatabase("");
		MongoCollection<Document> coll = db.getCollection("sal");
		
//		입력
//		Document doc=new Document();
//		doc.append("item", "efg");
//		doc.append("price", 17.5);
//		doc.append("quantity", 7);
//		doc.append("date", new Date());
//		coll.insertOne(doc);
		
		
//		1개 삭제
		Document obj=new Document();
		obj.append("item", "efg");
		DeleteResult delResult = coll.deleteOne(obj);
		
		
//		수정
		Document doc1=new Document();//조건
		
		Document doc2=new Document();
		doc1.append("item", "efg");
		
		Document doc3=new Document();
		doc3.append("price", 15.5);
		
		doc2.append("$set", doc3);
		coll.updateOne(doc1, doc2);
		
//		bcon 안쓰고 싶은 이유 : 인터페이스라 상속받고하는 과정이 귀찮
		client.close();
	}catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
}
}
