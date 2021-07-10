
import java.util.Date;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;
import com.mongodb.MongoException;

/* simple example code how use java and mongodb  */
// http://www.mkyong.com/mongodb/java-mongodb-hello-world-example/

/* java driver for mongodb */
// https://oss.sonatype.org/content/repositories/releases/org/mongodb/mongo-java-driver/3.8.2/

/* getting starting use mongodb */
// https://www.mongodb.com/blog/post/getting-started-with-mongodb-and-java-part-i



public class main {


    public static void main(String[] args) {
        System.out.println("sdf");


        try {

            /**** Connect to MongoDB ****/
            // Since 2.10.0, uses MongoClient
            MongoClient mongo = new MongoClient("localhost", 27017);

            /**** Get database ****/
            // if database doesn't exists, MongoDB will create it for you
            DB db = mongo.getDB("monitor-ads");

            /**** Get collection / table from 'testdb' ****/
            // if collection doesn't exists, MongoDB will create it for you
            DBCollection table = db.getCollection("ads-posts");

            /**** Insert ****/
            // create a document to store key and value
            BasicDBObject document = new BasicDBObject();
            document.put("name", "mky2ong");
            document.put("age", 34);
            document.put("createdDate", new Date());
            document.put("ff",2);
            table.insert(document);

            /**** Find and display ****/
            BasicDBObject searchQuery = new BasicDBObject();
            searchQuery.put("name", "mkyong");

            DBCursor cursor = table.find(searchQuery);

            while (cursor.hasNext()) {
                System.out.println(cursor.next());
            }
            System.out.println("отобразили");

            /**** Update ****/
            // search document where name="mkyong" and update it with new values
            /*
            BasicDBObject query = new BasicDBObject();
            query.put("name", "mkyong");

            BasicDBObject newDocument = new BasicDBObject();
            newDocument.put("name", "mkyong-updated");

            BasicDBObject updateObj = new BasicDBObject();
            updateObj.put("$set", newDocument);

            table.update(query, updateObj);
            */
            /**** Find and display ****/
            BasicDBObject searchQuery2
                    = new BasicDBObject().append("name", "mkyong-updated");

            DBCursor cursor2 = table.find(searchQuery2);

            while (cursor2.hasNext()) {
                System.out.println(cursor2.next());
            }

            /**** Done ****/
            System.out.println("Done");

        } catch (MongoException e) {
            System.out.println("MongoException: " + e.toString());
        } catch (Exception ex) {
            System.out.println("Exception: " + ex.toString());
        }


    }
}
